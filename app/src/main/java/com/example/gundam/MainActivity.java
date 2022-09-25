package com.example.gundam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gundam.model.gundam;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // เก็บ Food 2 อย่างไว้ใน ArrayList<Food> ชื่อว่า foods
        //
        List<gundam> Gundams = new ArrayList<>();
        gundam gundams = new gundam();
        gundams.setgundam_name("Gundam Unicorn RX-02 Banshee ");
        gundams.setgundam_image("https://media.kapowtoys.co.uk/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/g/u/gundam-unicorn-1.jpg");
        gundams.setGundam_price(1500);
        Gundams.add(gundams);

        gundam gundams2 = new gundam();
        gundams2.setgundam_name("Gundam Unicorn RX-0");
        gundams2.setgundam_image("https://i.pinimg.com/736x/be/99/c7/be99c77c40ce40b1e3512493539164d1--gundam-art-unicorn-gundam.jpg");
        gundams2.setGundam_price(1200);
        Gundams.add(gundams2);


        // ส่ง foods ไปให้ MyAdapter
        //
        mAdapter = new MyAdapter(Gundams, this);
        recyclerView.setAdapter(mAdapter);


    }
}