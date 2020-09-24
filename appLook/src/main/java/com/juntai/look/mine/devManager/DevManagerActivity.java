package com.juntai.look.mine.devManager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.base.ViewPagerAdapter;
import com.juntai.look.base.customView.CustomViewPager;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDevContentFragment;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.GroupSetActivity;
import com.juntai.look.uitils.HawkProperty;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  设备管理
 * @date 2020/7/16 17:56
 */
public class DevManagerActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        ViewPager.OnPageChangeListener, View.OnClickListener {


    private TabLayout mTablayout;
    private CustomViewPager mViewpager;
    List<Fragment> mFragments = new ArrayList<>();
    private ViewPagerAdapter adapter;
    /**
     * 28个摄像头
     */
    private TextView mDevTotalAmountTv;
    private ImageView mMoreFuctionIv;

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
        mDevTotalAmountTv = (TextView) findViewById(R.id.dev_total_amount_tv);
        mMoreFuctionIv = (ImageView) findViewById(R.id.more_fuction_iv);
        mMoreFuctionIv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        List<String> titleArrays = Hawk.get(HawkProperty.CAMERA_GROUP);
        for (int i = 0; i < titleArrays.size(); i++) {
            mFragments.add(DevManagerFragment.newInstance(i));
        }
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), mContext, titleArrays, mFragments);
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(titleArrays.size());
        /*viewpager切换监听，包含滑动点击两种*/
        mViewpager.addOnPageChangeListener(this);
        mTablayout.setupWithViewPager(mViewpager);
        initTablayoutView(0, adapter);
        /*viewpager切换默认第一个*/
        mViewpager.setCurrentItem(0);
    }

    /**
     * 添加自定义tab布局
     */
    private void initTablayoutView(int currentPosition, ViewPagerAdapter adapter) {

        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            if (tab != null) {
                View view = tab.getCustomView();
                if (view == null) {
                    view = adapter.getTabViewNoPic(i);
                    tab.setCustomView(view);
                }
                TextView titleTv = view.findViewById(R.id.tabitem_text);
                if (i == currentPosition) {
                    titleTv.setTextSize(22);
                } else {
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
        initTablayoutView(i, adapter);

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.more_fuction_iv:
                startActivity(new Intent(mContext, GroupSetActivity.class));
                break;
        }
    }
}
