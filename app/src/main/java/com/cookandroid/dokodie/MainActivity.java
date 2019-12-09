package com.cookandroid.dokodie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button newBtn, bestBtn, calBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(this, ParsingActivity.class);
        //startActivity(intent);

        newBtn=findViewById(R.id.newbook);
        bestBtn=findViewById(R.id.bestseller);
        calBtn=findViewById(R.id.calendar);

        bestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BestSellerActivity.class);
                startActivity(intent);
            }
        });
    }
}