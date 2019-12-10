package com.cookandroid.dokodie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class BestSellerActivity extends AppCompatActivity {

    Button newBtn, bestBtn, calBtn;


    private ArrayList<HashMap<String, String>> Data = new ArrayList<HashMap<String, String>>();
    private HashMap<String, String> inputData1=new HashMap<>();
    private  HashMap<String, String> inputData2=new HashMap<>();
    private ListView listView;

    public static Activity bestS_Activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestseller);

        newBtn=findViewById(R.id.newbook);
        bestBtn=findViewById(R.id.bestseller);
        calBtn=findViewById(R.id.calendar);

        bestS_Activity=BestSellerActivity.this;

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BestSellerActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right);
                bestS_Activity.finish();
            }
        });


        listView=(ListView)findViewById(R.id.bestlist);

        dataSetting();
    }

    private void dataSetting(){

        MyAdapter myAdapter= new MyAdapter();

        for(int i=1;i<=10;i++){
            myAdapter.addItem(""+i, ContextCompat.getDrawable(getApplicationContext(),R.drawable.gatsby), "위대한 개츠비", "F. 스콧 피츠제럴드");
        }

        listView.setAdapter(myAdapter);
    }
}
