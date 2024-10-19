package com.example.firebase_phonebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_phonebook.databinding.ItemCardBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private Context context;
    private ArrayList<UserData> userarrayList;

    public MyAdapter(Context context, ArrayList<UserData> userarrayList) {
        this.context = context;
        this.userarrayList = userarrayList;
    }

    public MyAdapter() {
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //initializes the viewholder and inflates the item layout
        ItemCardBinding binding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_card,
                parent,
                false
        );
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        //bind data to an existing viewHolder
        //populates the views in the viewholder with data from the dataset

        UserData currentUser=userarrayList.get(position);
        holder.itemCardBinding.setUser(currentUser);
    }

    @Override
    public int getItemCount() {
        return userarrayList.size();
    }
}
