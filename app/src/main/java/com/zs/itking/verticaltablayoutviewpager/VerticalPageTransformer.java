package com.zs.itking.verticaltablayoutviewpager;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * created by on 2021/11/16
 * 描述：自定义PageTransformer实现ViewPager竖屏滑动效果
 *
 * @author ZSAndroid
 * @create 2021-11-16-10:22
 */
public class VerticalPageTransformer implements ViewPager.PageTransformer{

    private  float MIN_SCALE = 0.5f;

    @Override
    public void transformPage(View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        }else if (position <= 0) { // [-1,1]
            view.setAlpha(1 + position);
            view.setTranslationX(-view.getWidth() * position);
            view.setPivotY( view.getMeasuredHeight());
            view.setPivotX( view.getMeasuredWidth()/2);
            view.setTranslationY( position * view.getHeight());
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
                    * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        }
        else if (position <= 1) { // [-1,1]
            view.setAlpha(1);
            view.setTranslationX(-view.getWidth() * position);
            view.setTranslationY( position * view.getHeight());
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE)
                    * (1 - Math.abs(position));

        } else { // (1,+Infinity]
            view.setAlpha(0);
            view.setTranslationY( position * view.getHeight());
        }
    }

}

