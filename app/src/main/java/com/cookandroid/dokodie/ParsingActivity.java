package com.cookandroid.dokodie;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParsingActivity extends AppCompatActivity {

    private String htmlPageUrl = "https://lidron.tistory.com/19"; //파싱할 홈페이지의 URL주소
    private String htmlContentInStringFormat="";

    // 파싱한 내용을 가져올 텍스트 뷰
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parsed_main);

        tv1 = findViewById(R.id.xmlparsedtv);
        tv1.setMovementMethod(new ScrollingMovementMethod()); // 스크롤 가능한 텍스트뷰로 만듬

        JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
        jsoupAsyncTask.execute();
    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                // Jsoup.connect(URL 혹은 string).get() 으로 전체를 가져옴
                doc = Jsoup.connect(htmlPageUrl).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Elements로 선언한 무언가로 가져올 Query를 알려줌
            Elements element= doc.select("div.article_view p");

            for(Element e: element){
                // 가져와버리기
                htmlContentInStringFormat += e.text().trim() + "\n";
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            tv1.setText(htmlContentInStringFormat);
        }
    }
}
