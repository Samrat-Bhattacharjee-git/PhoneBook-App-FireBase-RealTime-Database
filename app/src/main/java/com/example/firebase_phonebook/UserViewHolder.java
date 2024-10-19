package com.example.firebase_phonebook;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_phonebook.databinding.ItemCardBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {
    //combining recycler view with databinding for each item

    ItemCardBinding itemCardBinding;

    public UserViewHolder( ItemCardBinding itemCardBinding) {
        super(itemCardBinding.getRoot());
        this.itemCardBinding = itemCardBinding;

        //handling click events on items in the recyclerView list

        itemCardBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting the position of different item

                int position=getAdapterPosition();
            }
        });
    }
}
