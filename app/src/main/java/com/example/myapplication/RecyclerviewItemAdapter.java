package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewItemAdapter extends RecyclerView.Adapter<RecyclerviewItemAdapter.MyViewHolder> {
    private List<User> userList;
    private ClickListener clickListener;

    RecyclerviewItemAdapter(List<User> mItemList){
        this.userList = mItemList;
    }

    @Override
    public RecyclerviewItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerviewItemAdapter.MyViewHolder holder, final int position) {
        final User user = userList.get(position);
        holder.name.setText(user.getUsername());
        holder.price.setText(user.getPassword());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(v,user,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView name,price;
        private LinearLayout itemLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            price = itemView.findViewById(R.id.tvPrice);
            itemLayout =  itemView.findViewById(R.id.itemLayout);
        }
    }


}
