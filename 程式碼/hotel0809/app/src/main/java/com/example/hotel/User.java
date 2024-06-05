package com.example.hotel;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    String id="";
    String account="";
    String password="";
    String email="";
    String name="";
    String address="";

    protected User(Parcel source) {
        account=source.readString();
        password=source.readString();
        email=source.readString();
        id=source.readString();
        address=source.readString();
        name=source.readString();
    }
    public User(String i,String acc, String pas, String ema , String nam,String add) {
        id=i;
        password=pas;
        account=acc;
        email=ema;
        name=nam;
        address=add;
    }
    public User(String acc, String pas, String ema) {
        password=pas;
        email=ema;
        account=acc;
    }
    public String getAccount() {
        return account;
    }

    public String getid() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setid(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(account);
        dest.writeString(password);
        dest.writeString(email);
        dest.writeString(id);
        dest.writeString(address);
        dest.writeString(name);
    }
    public static final Creator<User> CREATOR=new Creator<User>(){

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }

    };

}

