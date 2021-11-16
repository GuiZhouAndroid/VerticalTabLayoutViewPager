package com.zs.itking.verticaltablayoutviewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.zs.itking.verticaltablayoutviewpager.frgament.BottomCategoryFragment;
import com.zs.itking.verticaltablayoutviewpager.frgament.BottomHomeFragment;
import com.zs.itking.verticaltablayoutviewpager.frgament.BottomMineFragment;
import com.zs.itking.verticaltablayoutviewpager.frgament.BottomShopFragmen6;
import com.zs.itking.verticaltablayoutviewpager.frgament.BottomShopFragment;
import com.zs.itking.verticaltablayoutviewpager.frgament.BottomShopFragment5;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;

public class MainActivity extends AppCompatActivity {

    private VerticalTabLayout mTablayout;
    private VerticalPager mViewpager;

    /**
     * 四个主功能Fragment界面
     */
    public Fragment[] fragments = null;
    /**
     * 声明Fragment集合，ViewPager适配器遍历绑定数组fragments
     */

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
    }

    //初始化控件
    private void initView() {
        mTablayout = findViewById(R.id.tablayout);
        mViewpager = findViewById(R.id.viewpager);
    }

    //初始化数据
    private void initViewPager() {
        fragmentList = new ArrayList<>();
        //创建Fragment类型的数组，适配ViewPager，添加四个功能页
        fragments = new Fragment[]{new BottomHomeFragment(), new BottomCategoryFragment(), new BottomShopFragment(), new BottomMineFragment(), new BottomShopFragment5(), new BottomShopFragmen6()};
        //ViewPager设置MyAdapter适配器，遍历List<Fragment>集合，填充Fragment页面
        mViewpager.setAdapter(new MyVerticalTabLayoutViewPagerAdapter(getSupportFragmentManager(), fragments, fragmentList));
        //进行TabLayout 关联 ViewPager
        mTablayout.setupWithViewPager(mViewpager);
    }
}