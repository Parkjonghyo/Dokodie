package com.cookandroid.dokodie;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<MyItem> mitems=new ArrayList<>();

    @Override
    public int getCount(){
        return mitems.size();
    }

    @Override
    public MyItem getItem(int position){
        return mitems.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        // 'list_custom' layout을 inflate하여 convertView 참조 획득
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom, parent, false);
        }

        //'listview_custom'에 정의된 위젯에 대한 참조 획득
        TextView list_num =(TextView) convertView.findViewById(R.id.list_num);
        ImageView list_img = (ImageView) convertView.findViewById(R.id.list_img);
        TextView list_title = (TextView) convertView.findViewById(R.id.list_title);
        TextView list_writer = (TextView) convertView.findViewById(R.id.list_writer);

        //각 리스트에 뿌려줄 아이템을 받아오는데 myitem 재활용
        MyItem myItem = getItem(position);

        //각 위젯에 세팅된 아이템을 뿌랴준다.
        list_num.setText(myItem.getNum());
        list_img.setImageDrawable(myItem.getImg());
        list_title.setText(myItem.getTitle());
        list_writer.setText(myItem.getWriter());

        // 위젯에 대한 이벤트 리스너를 지정하고 싶다면 여기에 작성하면 된다.

        return convertView;
    }

    //아이템 데이터 추가를 위한 함수. 자신이 원하는대로 작성
    public void addItem(String num, Drawable img, String title, String writer){
        MyItem mitem= new MyItem();

        // MyItem에 아이템을 setting한다
        mitem.setNum(num);
        mitem.setImg(img);
        mitem.setTitle(title);
        mitem.setWriter(writer);

        //mitem에 MyItem을 추가한다
        mitems.add(mitem);
    }
}
