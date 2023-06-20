package com.example.progrsofhifzstdnt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SearchFunc extends AppCompatActivity{


    EditText e1,e2;

    Button b1;

    RecyclerView rct;

    RecyclerView.LayoutManager layoutManager;

    RecyclerView.Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_func);

        e1 = findViewById(R.id.eName);
        e2 = findViewById(R.id.eClass);
        b1 = findViewById(R.id.bb);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
                String clas = e2.getText().toString();

                DbHelper db = new DbHelper(SearchFunc.this);
                List<HafizStudent> stds =  db.search(name , clas);
                if(stds.size()>0)
                {
                    rct = findViewById(R.id.decelerat);
                    rct.setHasFixedSize(true);

                    layoutManager = new LinearLayoutManager(SearchFunc.this);
                    rct.setLayoutManager(layoutManager);





                    adapter = new MyRecyclerViewAdapter(SearchFunc.this , stds) ;
                    rct.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"RECORD NOT FOUND",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

}
