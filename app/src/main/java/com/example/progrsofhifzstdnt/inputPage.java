package com.example.progrsofhifzstdnt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class inputPage extends AppCompatActivity {

    Button back,addRecord;
    RecyclerView rc;
    EditText hafizNm,hafizAge,hafizCls,hafizSbqPara,hafizSbqStVrs,hafizSbqLstVrs;
    RecyclerView.LayoutManager layoutManager;

    RecyclerView.Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        addRecord = findViewById(R.id.button3);

        List<HafizStudent> friendsList = new ArrayList<>();



        rc = findViewById(R.id.rcvad);

        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hafizNm = findViewById(R.id.editTextTextPersonName);
                hafizAge = findViewById(R.id.editTextTextPersonName2);
                hafizCls = findViewById(R.id.editTextTextPersonName3);
                hafizSbqPara = findViewById(R.id.editTextTextPersonName4);
                hafizSbqStVrs = findViewById(R.id.editTextTextPersonName5);
                hafizSbqLstVrs = findViewById(R.id.editTextTextPersonName6);





                HafizStudent hs = new HafizStudent();
                 hs.setName(hafizNm.getText().toString());
                 hs.setAge(Integer.parseInt(hafizAge.getText().toString()));
                 hs.setClas(hafizCls.getText().toString());
                 hs.setSabaqPara(Integer.parseInt(hafizSbqPara.getText().toString()));
                 hs.setSabaqStVrse(Integer.parseInt(hafizSbqStVrs.getText().toString()));
                 hs.setSabaqLsVrse(Integer.parseInt(hafizSbqLstVrs.getText().toString()));
                 int sbqpara = (Integer.parseInt(hafizSbqPara.getText().toString()));
                 hs.setSabaqi(sbqpara-1);
                 String mnzil="";
                 for (int i=1; i<sbqpara ; i++)
                 {
                      mnzil += i;
                 }
                 hs.setManzil(mnzil);

                DbHelper db;
                  db = new DbHelper(inputPage.this);
                 db.insertStudent(hs);

                Toast.makeText(getApplicationContext(),"Record Added",Toast.LENGTH_SHORT).show();
                friendsList.add(hs);




            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inputPage.this, MainActivity.class);
                startActivity(intent);
            }
        });



        DbHelper dp = new DbHelper(inputPage.this);

        List<HafizStudent> friendsLists = new ArrayList<>();

        friendsLists = dp.selectAllStudents();

        rc.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);




        adapter = new MyRecyclerViewAdapter(this , friendsLists) ;
        rc.setAdapter(adapter);
        //adapter.notifyDataSetChanged();


    }
}