package com.example.halkhomeworkatakan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class FragmentViewPagerActivity extends AppCompatActivity {

    private static final int NUM_PAGE = 3;
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_view_pager);
        viewPager2 = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePageAdapter(this);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());
    }

    private class ScreenSlidePageAdapter extends FragmentStateAdapter {
        public ScreenSlidePageAdapter(FragmentViewPagerActivity fragmentViewPagerActivity) {
            super(fragmentViewPagerActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new FragmentViewPagerExample();
                case 1:
                    return new FragmentViewPagerExample2();
                case 2:
                    return new FragmentViewPagerExample3();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGE;
        }

    }

    private class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(@NonNull View page, float position) {

            int pageWidth = page.getWidth();
            int pageHeight = page.getHeight();
            if (position < -1) {
                page.setAlpha(0f);
            } else if (position <= 1) {
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float verMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;

                if(position<0){
                    page.setTranslationX(horzMargin-verMargin/2);
                }else{
                    page.setTranslationY(-horzMargin+verMargin/2);
                }
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setAlpha(MIN_ALPHA+(scaleFactor-MIN_SCALE)/(1-MIN_SCALE)*(1-MIN_SCALE));
            }
            else{
                page.setAlpha(0f);
            }
        }
    }

}