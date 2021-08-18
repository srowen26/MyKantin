package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerviewItemAdapter recyclerviewItemAdapter;
    private List<User> userList;

    private void prepareItems(){
        for(int i = 0; i < 50; i++) {
            User users = new User("User "+i,"password: "+i);
            userList.add(users);
        }
        recyclerviewItemAdapter.notifyDataSetChanged();
    }

    public void detailItem(View view){
        Intent detailItem = new Intent (MainActivity.this, Details.class);
        startActivity(detailItem);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recycleView);

        recyclerviewItemAdapter = new RecyclerviewItemAdapter(userList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerviewItemAdapter);

        recyclerviewItemAdapter.setOnItemClickListener(new ClickListener<User>(){
            @Override
            public void onClick(View view, User data, int position) {
                Toast.makeText(getApplicationContext(),"Position = "+position+"\n Item = "+data.getUsername(),Toast.LENGTH_SHORT).show();
            }
        });
        prepareItems();
    }
}