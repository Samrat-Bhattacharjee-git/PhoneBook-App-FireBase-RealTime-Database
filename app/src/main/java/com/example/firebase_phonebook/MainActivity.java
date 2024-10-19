package com.example.firebase_phonebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.firebase_phonebook.databinding.ActivityMainBinding;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserData> userData;
    RecyclerView recyclerView;
    MyAdapter adapter;
    ActivityMainBinding binding;

    TextView text1,text2,text3;
    //fireBase
    DatabaseReference databaseReference;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("Users");



        //fetch the data from fireBase to recyclerView
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    UserData user=dataSnapshot.getValue(UserData.class);
                    userData.add(user);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                //handle errors here
            }
        });

        //recycleView with dataBinding
        recyclerView=binding.recycle;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userData=new ArrayList<>();
        adapter=new MyAdapter(this,userData);
        recyclerView.setAdapter(adapter);


    }
}