package com.example.securemove.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.securemove.R;

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;

    public MyPagerAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View layout = inflater.inflate(R.layout.cours, container, false);

        TextView introductionTxt = layout.findViewById(R.id.introductionTxt);
        TextView descTxt = layout.findViewById(R.id.descTxt);
        TextView exmTxt = layout.findViewById(R.id.exmTxt);
        TextView exmN = layout.findViewById(R.id.exmN);

        switch (position) {
            case 0:
                introductionTxt.setText(R.string.cesarInt);
                descTxt.setText(R.string.cesarDesc);
                exmTxt.setText(R.string.cesarExIntro);
                exmN.setText(R.string.cesarEx);
                break;
            case 1:
                introductionTxt.setText(R.string.vigenereInt);
                introductionTxt.setTextColor(Color.parseColor("#22A39F"));

                descTxt.setText(R.string.vigenereDesc );
                exmTxt.setText(R.string.vigenereExIntro);
                exmTxt.setTextColor(Color.parseColor("#22A39F"));
                exmN.setText(R.string.vigenereEx);

                break;
            case 2:
                introductionTxt.setText(R.string.affineInt );
                introductionTxt.setTextColor(Color.parseColor("#FF6000"));

                descTxt.setText(R.string.affineDesc);
                exmTxt.setText(R.string.affineExIntro);
                exmTxt.setTextColor(Color.parseColor("#FF6000"));

                exmN.setText(R.string.affineEx);
                break;
        }

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
