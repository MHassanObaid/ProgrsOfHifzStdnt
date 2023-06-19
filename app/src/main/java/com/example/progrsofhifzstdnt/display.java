package com.example.progrsofhifzstdnt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class display extends AppCompatActivity {


    List<HafizStudent> friendsList = new ArrayList<>();

    RecyclerView.LayoutManager layoutManager;

    RecyclerView.Adapter adapter;

    Button b8;


    RecyclerView rct;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        rct=findViewById(R.id.rcvad);

        b8 = findViewById(R.id.button8);

        DbHelper dh = new DbHelper(this);

        friendsList = dh.selectAllStudents();

        rct.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rct.setLayoutManager(layoutManager);





        adapter = new MyRecyclerViewAdapter(display.this , friendsList) ;
        rct.setAdapter(adapter);
        //adapter.notifyDataSetChanged();W

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(display.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
