package com.example.animationandshared;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {

    private LayoutInflater mInflater;
    private List<ModelUser> userList;
    private OnUserClick onUserClick;

    public AdapterUser(Context context, List<ModelUser> userList, OnUserClick onUserClick) {
        this.mInflater = LayoutInflater.from(context);
        this.userList = userList;
        this.onUserClick = onUserClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelUser currentUser = userList.get(position);

        holder.name.setText(currentUser.getName());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent()

                onUserClick.userClick(currentUser);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView message;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.userName);
            message = itemView.findViewById(R.id.message);
            relativeLayout = itemView.findViewById(R.id.layoutRelative);
        }
    }

    public interface OnUserClick{
        public void userClick(ModelUser modelUser);
    }
}
