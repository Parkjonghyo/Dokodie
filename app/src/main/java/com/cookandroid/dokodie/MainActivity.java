package com.cookandroid.dokodie;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button newBtn, bestBtn, calBtn;
    LinearLayout book1;
    BookDatabaseManager databaseManager;
    ArrayList<BookItem> bookList;

    public static Activity newB_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseManager = BookDatabaseManager.getInstance(this);

        // TODO-이거 실행하면 초기 DB에 다 들어감
        checkFirstRun();
        // 실행 후 bookList (ArrayList<BookItem> 에 책 정보가 들어감)
        //
        getBookData();

        // TODO - 이렇게 씀 bookList.get(0).getTitle(); 이러면 우리집에 엄마가 산다가 나옴

        //Intent intent = new Intent(this, ParsingActivity.class);
        //startActivity(intent);

        //getBookData();

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

    public void checkFirstRun(){
        SharedPreferences pref = getSharedPreferences("isFirst", Activity.MODE_PRIVATE);
        boolean isFirst = pref.getBoolean("isFirst",false);
        if(!isFirst)
        {
            Log.d(TAG,"처음입니다?");
            insertAllBookData();
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("isFirst", true);
            editor.commit();
        }
    }

    public void insertAllBookData(){
        insertBookData("우리 집에 엄마가 산다", "배경희", "고즈넉이엔티","2019.12.13",13500);
        insertBookData("홀린", "장래이", "고즈넉이엔티","2019.12.13",13500);
        insertBookData("환절기에 온 편지", "김래임", "고즈넉이엔티","2019.12.13",13500);
        insertBookData("민호", "민서", "천의무봉","2019.12.11",11000);
        insertBookData("아직 집에는 가지 않을래요", "백수린, 강화길 등등", "현대문학","2019.12.10",15000);
        // TODO - 5
        insertBookData("나, 티투바, 세일럼의 검은 마녀", "마리즈 콩데", "은행나무","2019.12.10",13000);
        insertBookData("데미안", "헤르만 헤세", "스타북스","2019.12.10",8800);
        insertBookData("밤의 연두", "이서안", "문이당","2019.12.10",13000);
        insertBookData("스웨터로 떠날래", "안나 니콜스카야", "바람의아이들","2019.12.10",15000);
        insertBookData("굿모닝 미드나이트", "릴리 브룩스돌턴", "시공사","2019.12.10",15500);
        // TODO - 10
        insertBookData("작가들의 비밀스러운 삶", "기욤 뮈소", "밝은세상","2019.11.21",14800);
        insertBookData("82년생 김지영", "조남주", "민음사","2016.10.14",13000);
        insertBookData("일의 기쁨과 슬픔", "장류진", "창비","2019.10.25",14000);
        insertBookData("그 사랑 놓치지 마라", "이해인", "마음산책","2019.11.25",13500);
        insertBookData("빨강 머리 앤", "루시 모드 몽고메리", "더모던","2019.05.10",16800);
        // TODO - 15
        insertBookData("아홉 명의 완벽한 타인들", "리안 모리아티", "마시멜로","2019.10.25",15800);
        insertBookData("꽃을 보듯 너를 본다", "나태주", "지혜","2015.06.20",10000);
        insertBookData("멋진 신세계", "올더스 헉슬리", "소담출판사","2015.06.12",13800);
        insertBookData("캐롤 한/영 각본집", "필리스 나지", "플레인","2019.11.18",25000);
        insertBookData("긴 이별을 위한 짧은 편지", "페터 한트케", "문학동네","2011.02.25",10000);
        // TODO - 20
    }

    public void insertBookData(String title, String writer, String publisher, String date, Integer price){
        ContentValues addRowValue = new ContentValues();

        addRowValue.put("title", title);
        addRowValue.put("writer", writer);
        addRowValue.put("publisher", publisher);
        addRowValue.put("date", date);
        addRowValue.put("price", price);

        databaseManager.insert(addRowValue);
    }

    public void getBookData()
    {
        bookList = new ArrayList<>();

        String[] columns = new String[] {"_id", "title", "writer", "publisher", "date", "price"};

        Cursor cursor = databaseManager.query(columns, null, null,null,null,null);

        if(cursor != null)
        {
            while (cursor.moveToNext())
            {
                BookItem currentData = new BookItem();

                currentData.setId(cursor.getInt(0));
                currentData.setTitle(cursor.getString(1));
                currentData.setWriter(cursor.getString(2));
                currentData.setPublisher(cursor.getString(3));
                currentData.setDate(cursor.getString(4));
                currentData.setPrice(Integer.parseInt(cursor.getString(5)));

                bookList.add(currentData);
            }
        }
    }
}
