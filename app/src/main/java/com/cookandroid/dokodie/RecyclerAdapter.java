package com.cookandroid.dokodie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<RecyclerItem> myDataList=null;

    // 리스너 객체 참조를 저장하는 변수
    private OnItemClickListener mListener = null ;

    RecyclerAdapter(ArrayList<RecyclerItem> dataList){
        myDataList=dataList;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView writer;

        ViewHolder(View itemView){
            super(itemView);

            imageView=itemView.findViewById(R.id.bookimage);
            title=itemView.findViewById(R.id.booktitle);
            writer=itemView.findViewById(R.id.bookwriter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        // 리스너 객체의 메서드 호출.
                        if (mListener != null) {
                            mListener.onItemClick(v, pos) ;
                        }
                    }
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //전개자(Inflater)를 통해 얻은 참조 객체를 통해 뷰홀더 객체 생성
        View view = inflater.inflate(R.layout.recyclerview_custom, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position){
        //ViewHolder가 관리하는 View에 position에 해당하는 데이터 바인딩
        viewHolder.imageView.setImageResource(myDataList.get(position).getBookimg());
        viewHolder.title.setText(myDataList.get(position).getBooktitle());
        viewHolder.writer.setText(myDataList.get(position).getBookwriter());
    }

    public int getItemCount(){
        //Adapter가 관리하는 전체 데이터 개수 반환
        return myDataList.size();
    }
}
