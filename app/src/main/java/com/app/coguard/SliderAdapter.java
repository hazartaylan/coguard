package com.app.coguard;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;

    }

    public String[] slide_headings={
            "Find your Doctor",
            "apo",
            "alfred"

    };
    public int[] slide_decs={

            R.drawable.a1,
            R.drawable.a2,

            R.drawable.a3,
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        TextView sliderhead=(TextView)view.findViewById(R.id.slideheading);
        ImageView sliderdesc=(ImageView)view.findViewById(R.id.slide_desc);
        sliderhead.setText(slide_headings[position]);
        sliderdesc.setImageResource(slide_decs[position]);
        container.addView(view);




        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);

    }
}
