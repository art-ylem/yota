package com.example.yota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> stringSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringSet = new ArrayList<>();
        stringSet.add("First");
        stringSet.add("Second");
        stringSet.add("Third");

        recyclerView = findViewById(R.id.posterRecyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // specify an adapter (see also next example)
        mAdapter = new PosterRecyclerViewAdapter(stringSet, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.scrollToPosition(1);

        CarouselPicker carouselPicker = (CarouselPicker) findViewById(R.id.carousel);


        //Case 2 : To populate the picker with text
        List<CarouselPicker.PickerItem> textItems = new ArrayList<>();

        //20 here represents the textSize in dp, change it to the value you want.
        textItems.add(new CarouselPicker.TextItem("10", 20));
        textItems.add(new CarouselPicker.TextItem("20", 20));
        textItems.add(new CarouselPicker.TextItem("30", 20));
        textItems.add(new CarouselPicker.TextItem("40", 20));
        textItems.add(new CarouselPicker.TextItem("50", 20));
        textItems.add(new CarouselPicker.TextItem("60", 20));
        textItems.add(new CarouselPicker.TextItem("70", 20));
        CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this, textItems, 0);
        carouselPicker.setAdapter(textAdapter);


    }
}