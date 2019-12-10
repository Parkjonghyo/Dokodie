package com.cookandroid.dokodie;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button newBtn, bestBtn, calBtn;
    LinearLayout book1;

    public static Activity newB_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Intent intent = new Intent(this, ParsingActivity.class);
        //startActivity(intent);

        newBtn=findViewById(R.id.newbook);
        bestBtn=findViewById(R.id.bestseller);
        calBtn=findViewById(R.id.calendar);
        book1=findViewById(R.id.book1);

        newB_Activity=MainActivity.this;

        bestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BestSellerActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
                newB_Activity.finish();
            }
        });

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_right, R.anim.anim_slide_out_left);
            }
        });
    }
}