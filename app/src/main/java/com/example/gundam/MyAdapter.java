package com.example.gundam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gundam.model.gundam;
import com.bumptech.glide.Glide;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // ประกาศ global variables เพื่อใช้งาน
    //
    private List<gundam> values;
    private Context context;    // หมายถึง MainActivity context ที่ส่งมาตอนเรียกใช้ MyAdapter

    // constructor ของ MyAdapter ทำหน้าที่นำค่าที่ได้รับมาตอนถูกสร้างที่ MainActivity มาเก็บไว้ที่ global variables
    //
    public MyAdapter(List<gundam> values, Context context) {
        this.values = values;
        this.context = context;
    }

    // ********
    // INNER class ViewHolder extends RecyclerView.ViewHolder คือชิ้นส่วนแต่ละอันที่จะแสดงข้อมูลอาหาร 1 อย่าง
    //
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgView;
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            imgView = (ImageView) v.findViewById(R.id.icon);
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // เมื่อมีการ bind ViewHolder เข้ากับ RecyclerView ให้กำหนดค่าที่ ImageView และ 2 TextView เป็นภาพ ชื่อ และราคาอาหาร
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final gundam food = values.get(position);
        holder.txtHeader.setText(food.getgundam_name());
        holder.txtFooter.setText(food.getgundam_price() + " บาท");

        //ใช้ Glide ในการแสดงภาพบน ImageView  ซึ่งอาจจะใช้ Picasso แทนก็ได้
        //
        Glide.with(context)
                .load(food.getgundam_image())
                .into(holder.imgView);
        holder.imgView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context,
                        food.getgundam_name(),
                        Toast.LENGTH_SHORT);
                toast.show();

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}

