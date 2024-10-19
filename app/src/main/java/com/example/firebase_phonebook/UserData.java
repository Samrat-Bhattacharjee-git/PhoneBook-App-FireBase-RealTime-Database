package com.example.firebase_phonebook;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UserData extends BaseObservable {
    String name;
    String phoneNumber;
    String groupUser;

    //when dealing with database always create empty constructor to get rid of null pointer exception
    public UserData() {
    }

    public UserData(String name, String phoneNumber, String groupUser) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.groupUser = groupUser;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

    @Bindable
    public String getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(String groupUser) {
        this.groupUser = groupUser;
        notifyPropertyChanged(BR.groupUser);
    }
}
