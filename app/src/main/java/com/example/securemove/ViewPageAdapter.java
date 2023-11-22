package com.example.securemove;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class ViewPageAdapter extends PagerAdapter {

    Context context;

    int animations[] = {
            R.raw.on1,
            R.raw.on2,
            R.raw.on3,
    };

    int headings[] = {
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
    };

    int description[] = {
            R.string.screen1,
            R.string.screen2,
            R.string.screen3,
    };

    public ViewPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.img_layout, container, false);

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.lottieAnimationView);
        TextView slideHeading = view.findViewById(R.id.texttitle);
        TextView slideDescription = view.findViewById(R.id.textdeccription);

        // Set animation for the LottieAnimationView
        lottieAnimationView.setAnimation(animations[position]);

        // Set repeat count
        lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE); // Set to 0 for playing only once

        // Start the animation
        lottieAnimationView.playAnimation();

        slideHeading.setText(headings[position]);
        slideDescription.setText(description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
