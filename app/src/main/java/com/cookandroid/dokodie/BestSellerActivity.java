package com.cookandroid.dokodie;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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

    ArrayList<BookItem> bookList;

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

        Intent intent = getIntent();

        bookList = intent.getExtras().getParcelableArrayList("BookList");

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


        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BestSellerActivity.this, CalendarActicity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        });


        listView=(ListView)findViewById(R.id.bestlist);

        dataSetting();
    }

    private void dataSetting(){

        MyAdapter myAdapter= new MyAdapter();

        for(int i=10;i<=19;i++){
            myAdapter.addItem(""+(i-9), ContextCompat.getDrawable(getApplicationContext(),bookList.get(i).getBookImgNumber()), bookList.get(i).getTitle(), bookList.get(i).getWriter());
        }

        listView.setAdapter(myAdapter);
    }
}
