package com.example.animationandshared;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActivityUsers extends AppCompatActivity implements AdapterUser.OnUserClick {
    RecyclerView recyclerView;
    AdapterUser adapterUser;
    List<ModelUser> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        ModelUser modelUser = new ModelUser();
        modelUser.setName("Muzammil");
        modelUser.setPassword("deiufhcadl");

        list.add(modelUser);
        list.add(modelUser);
        list.add(modelUser);
        list.add(modelUser);
        list.add(modelUser);
        list.add(modelUser);
        list.add(modelUser);
        list.add(modelUser);

        recyclerView = findViewById(R.id.rvUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterUser = new AdapterUser(this, list, this);
        recyclerView.setAdapter(adapterUser);

    }

    @Override
    public void userClick(ModelUser modelUser) {
        Toast.makeText(this, ""+modelUser, Toast.LENGTH_SHORT).show();

    }
}