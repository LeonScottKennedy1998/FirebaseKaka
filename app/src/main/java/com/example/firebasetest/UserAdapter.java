package com.example.firebasetest;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
    private List<User> userList;




@NonNull
@Override
public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    return null;
}

@Override
public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position){

}

public int getItemCount(){
    return  0;
}

public class UserViewHolder extends RecyclerView.ViewHolder {
    public UserViewHolder(@NonNull View itemView){
        super(itemView);
    }
}
}