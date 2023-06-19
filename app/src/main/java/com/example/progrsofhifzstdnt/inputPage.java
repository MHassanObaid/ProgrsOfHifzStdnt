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

public class inputPage extends AppCompatActivity {

    Button back,addRecord,diply;
    RecyclerView rc;
    EditText hafizNm,hafizAge,hafizCls,hafizSbqPara,hafizSbqStVrs,hafizSbqLstVrs;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        addRecord = findViewById(R.id.button3);
        diply = findViewById(R.id.button6);
back = findViewById(R.id.button5);
        List<HafizStudent> friendsList = new ArrayList<>();





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
                //friendsList.add(hs);


                //DbHelper dp = new DbHelper(inputPage.this);

                List<HafizStudent> friendsLists = new ArrayList<>();




                Log.d("size","here is size "+friendsLists.size());
              //  friendsLists = db.selectAllStudents();





            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inputPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        diply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(inputPage.this, display.class);
                startActivity(intent);


            }
        });






    }
}