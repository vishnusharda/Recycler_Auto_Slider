package com.vindevelopment.recyclerautoslider;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RecyclerView Recycler_AutoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Recycler_AutoSlider = findViewById(R.id.Recycler_AutoSlider);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        Recycler_AutoSlider.setLayoutManager(linearLayoutManager);

        List<AutoSliderModel> autoSliderModelList = new ArrayList<>();
        autoSliderModelList.add(new AutoSliderModel("https://i.pinimg.com/originals/ec/eb/5c/eceb5ca8f6d88aa2c326063af1b38fe0.jpg"));
        autoSliderModelList.add(new AutoSliderModel("https://www.indianpanorama.in/blog/wp-content/uploads/2018/02/Banner.jpeg"));
        autoSliderModelList.add(new AutoSliderModel("https://www.selectvacationproperties.com/wp-content/uploads/2020/02/AdobeStock_265268314.jpeg"));

        AutoSliderAdapter autoSliderAdapter = new AutoSliderAdapter(getApplicationContext(),autoSliderModelList);
        autoSliderAdapter.notifyDataSetChanged();
        Recycler_AutoSlider.setAdapter(autoSliderAdapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(Recycler_AutoSlider);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < (autoSliderAdapter.getItemCount() -1)){
                    linearLayoutManager.smoothScrollToPosition(Recycler_AutoSlider,new RecyclerView.State(),linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }else if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == (autoSliderAdapter.getItemCount() -1)){
                    linearLayoutManager.smoothScrollToPosition(Recycler_AutoSlider,new RecyclerView.State(),0);
                }
            }
        },0,2000);

    }
}