package com.juntai.look.mine.devManager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.base.ViewPagerAdapter;
import com.juntai.look.base.customView.CustomViewPager;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.MainPagerAdapter;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.juntai.wisdom.basecomponent.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  设备管理
 * @date 2020/7/16 17:56
 */
public class DevManagerActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        ViewPager.OnPageChangeListener {


    private TabLayout mTablayout;
    private CustomViewPager mViewpager;
    List<Fragment> mFragments = new ArrayList<>();
    private String[] title = new String[]{"我的家", "九曲街道", "珠穆朗玛峰", "NBA", "新闻", "体坛快讯", "哎吆不错哈哈"};
    private ViewPagerAdapter adapter;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_my_dev_manager;
    }

    @Override
    public void initView() {
        setTitleName("设备管理");
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewpager = (CustomViewPager) findViewById(R.id.viewpager);
    }

    @Override
    public void initData() {
        mFragments.add(DevManagerFragment.newInstance(0));
        mFragments.add(DevManagerFragment.newInstance(1));
        mFragments.add(DevManagerFragment.newInstance(2));
        mFragments.add(DevManagerFragment.newInstance(3));
        mFragments.add(DevManagerFragment.newInstance(4));
        mFragments.add(DevManagerFragment.newInstance(5));
        mFragments.add(DevManagerFragment.newInstance(6));

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), mContext, title, mFragments);
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(title.length);
        /*viewpager切换监听，包含滑动点击两种*/
        mViewpager.addOnPageChangeListener(this);
        mTablayout.setupWithViewPager(mViewpager);
        initTablayoutView(0,adapter);
        /*viewpager切换默认第一个*/
        mViewpager.setCurrentItem(0);
    }
    /**
     * 添加自定义tab布局
     * */
    private void initTablayoutView(int  currentPosition,ViewPagerAdapter adapter) {

        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            if (tab != null) {
                View view = tab.getCustomView();
                if (view == null) {
                    view = adapter.getTabViewNoPic(i);
                    tab.setCustomView(view);
                }
                TextView titleTv = view.findViewById(R.id.tabitem_text);
                if (i==currentPosition) {
                    titleTv.setTextSize(22);
                }else {
                    titleTv.setTextSize(14);
                }
            }
        }
    }

    @Override
    public void onSuccess(String tag, Object o) {
    }

    @Override
    public void onError(String tag, Object o) {
        super.onError(tag, o);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        initTablayoutView(i,adapter);

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
