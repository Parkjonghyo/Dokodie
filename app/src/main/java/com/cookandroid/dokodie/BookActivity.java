package com.cookandroid.dokodie;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {

    BookItem thatbook;
    TextView tvT, tvW, tvP, tvPr, tvD, tvC;
    ImageView imvB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initialization();

        Intent intent = getIntent();
        thatbook = intent.getParcelableExtra("BookItem");

        putInXml();

    }

    public void initialization(){
        tvT = findViewById(R.id.real_title);
        tvW = findViewById(R.id.real_writer);
        tvP = findViewById(R.id.real_publisher);
        tvPr = findViewById(R.id.real_price);
        tvD = findViewById(R.id.real_date);
        tvC = findViewById(R.id.real_contents);
        imvB = findViewById(R.id.bookimg);
    }

    public void putInXml(){
        tvT.setText(thatbook.getTitle());
        tvW.setText(thatbook.getWriter());
        tvP.setText(thatbook.getPublisher());
        tvPr.setText(thatbook.getPrice().toString());
        tvD.setText(thatbook.getDate());
        tvC.setText(content_reader());
        imvB.setImageResource(thatbook.getBookImgNumber());
    }
    public int content_reader(){
        switch (thatbook.getId()){
            case 1: return R.string.우리집에엄마가산다;
            case 2: return R.string.홀린;
            case 3: return R.string.환절기에온편지;
            case 4: return R.string.민호;
            case 5: return R.string.아직집에는가지않을래요;
            case 6: return R.string.나티투바세일럼의검은마녀;
            case 7: return R.string.데미안;
            case 8: return R.string.밤의연두;
            case 9: return R.string.스웨터로떠날래;
            case 10: return R.string.굿모닝미드나이트;
            case 11: return R.string.작가들의비밀스러운삶;
            case 12: return R.string._82년생김지영;
            case 13: return R.string.일의기쁨과슬픔;
            case 14: return R.string.그사랑놓치지마라;
            case 15: return R.string.빨강머리앤;
            case 16: return R.string.아홉명의완벽한타인들;
            case 17: return R.string.꽃을보듯너를본다;
            case 18: return R.string.멋진신세계;
            case 19: return R.string.캐롤한영각본집;
            case 20: return R.string.긴이별을위한짧은편지;
        }
        return 0;
    }
}
