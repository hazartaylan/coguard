package com.app.coguard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.coguard.Auth.TelLog;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private TextView back;
    private TextView next;
    private TextView finish;
    private int mCurrentP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.slideView);
        linearLayout=(LinearLayout)findViewById(R.id.dotslay);
        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        back=(TextView)findViewById(R.id.back);
        next=(TextView)findViewById(R.id.next);
        finish=(TextView)findViewById(R.id.finish);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentP+1);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentP-1);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, TelLog.class);
                startActivity(intent);

            }
        });
    }

    public void addDotsIndicator(int position){
        mDots=new TextView[3];
        linearLayout.removeAllViews();
        for (int i=0; i<mDots.length; i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));

            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorAccent));
            linearLayout.addView(mDots[i]);


        }
        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.black));
        }

    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentP=i;
            if (i==0){
                next.setEnabled(true);
                back.setEnabled(false);
                finish.setEnabled(false);
                back.setVisibility(View.INVISIBLE);
                next.setText("Next");
                back.setText("");

            }else if (i==mDots.length -1){
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                next.setText("NEXT");
                back.setText("BACK");
            }
            else if (i==mDots.length - 1){
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                finish.setEnabled(true);
                next.setVisibility(View.INVISIBLE);
                next.setText("START");
                back.setText("BACK");


            }else {
                next.setEnabled(true);
                back.setEnabled(true);
                back.setVisibility(View.VISIBLE);
                next.setText("NEXT");
                back.setText("BACK");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    }
