package com.juntai.look.main;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.baidu.location.BDLocation;
import com.juntai.look.base.customView.CustomViewPager;
import com.juntai.look.base.update.UpdateActivity;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.HomePageContract;
import com.juntai.look.homePage.HomePageFragment;
import com.juntai.look.homePage.MainPagerAdapter;
import com.juntai.look.homePage.mydevice.MyDeviceFragment;
import com.juntai.look.homePage.search.SearchFragment;
import com.juntai.look.mine.MineFragment;
import com.juntai.wisdom.basecomponent.mvp.BaseIView;
import com.juntai.wisdom.bdmap.service.LocateAndUpload;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  首页
 * @date 2020/7/29 16:55
 */
public class MainActivity extends UpdateActivity<MainPresent> implements SearchFragment.OnSearchCallBack,
        ViewPager.OnPageChangeListener, BaseIView {
    private long mExitTime;
    private CustomViewPager mMainViewpager;
    private TabLayout mMainTablayout;
    List<Fragment> mFragments = new ArrayList<>();
    private MainPagerAdapter adapter;
    String[] titles = {"首页", "模式切换", "我的"};
    int[] tabDrawables = {R.drawable.bottom_button_home_press, R.drawable.bottom_button_post_press,
            R.drawable.bottom_button_user_press};
    private MyDeviceFragment mDeviceFragment;
    private HomePageFragment mHomePageFragment;
    private MineFragment mMineFragment;


    @Override
    public int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
        initStatusBar(0);
        mMainViewpager = (CustomViewPager) findViewById(R.id.main_viewpager);
        mMainTablayout = (TabLayout) findViewById(R.id.main_tablayout);
        mDeviceFragment = new MyDeviceFragment();
        mHomePageFragment = new HomePageFragment();
        mMineFragment = new MineFragment();
        mFragments.add(mHomePageFragment);
        mFragments.add(mDeviceFragment);
        mFragments.add(mMineFragment);
        initTab();
        update(false);

    }

    @Override
    protected void onResume() {
        super.onResume();

        //        mPresenter.unReadMsg(getPublishMultipartBody().build(), MineContract.UNREAD_MSG);
    }

    @Override
    public boolean requestLocation() {
        return true;
    }

    @Override
    public void onLocationReceived(BDLocation bdLocation) {

        if (bdLocation != null) {
            String latStr = String.valueOf(bdLocation.getLatitude());
            String lngStr = String.valueOf(bdLocation.getLongitude());
            mPresenter.getWeatherRealTime(HomePageContract.GET_WEATHER_REAL_TIME, lngStr, latStr);
        }
    }

    public void initTab() {
        adapter = new MainPagerAdapter(getSupportFragmentManager(), mContext, titles, tabDrawables, mFragments);
        mMainViewpager.setAdapter(adapter);
        mMainViewpager.setOffscreenPageLimit(titles.length);
        //        /*viewpager切换监听，包含滑动点击两种*/
        mMainViewpager.addOnPageChangeListener(this);
        //设置不可左右滑动
        mMainViewpager.setScanScroll(false);
        //TabLayout
        //        mMainTablayout.addTab(mMainTablayout.newTab().setText("index").setIcon(R.mipmap.point_focus));
        mMainTablayout.setupWithViewPager(mMainViewpager);
        /**
         * 添加自定义tab布局
         * */
        for (int i = 0; i < mMainTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = mMainTablayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapter.getTabView(i));
            }
        }
        /*viewpager切换默认第一个*/
        mMainViewpager.setCurrentItem(0);
        mMainTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                initStatusBar(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 初始化状态栏
     *
     * @param position
     */
    private void initStatusBar(int position) {
        switch (position) {
            case 0:
                //状态栏配置
                mBaseRootCol.setFitsSystemWindows(true);
                mImmersionBar.statusBarColor(R.color.blue)
                        .statusBarDarkFont(false)
                        .init();
                break;
            case 1:
                //状态栏配置
                mBaseRootCol.setFitsSystemWindows(true);
                mImmersionBar.statusBarColor(R.color.blue)
                        .statusBarDarkFont(false)
                        .init();
                break;
            case 2:
                //状态栏配置
                mBaseRootCol.setFitsSystemWindows(true);
                mImmersionBar.statusBarColor(R.color.white)
                        .statusBarDarkFont(true)
                        .init();
                break;
            default:
                break;
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case HomePageContract.GET_WEATHER_REAL_TIME:
                ResponseRealTimeWeather realTimeWeather = (ResponseRealTimeWeather) o;
               mHomePageFragment.setWeatherInfos(realTimeWeather);
                mDeviceFragment.setWeatherInfos(realTimeWeather);
                break;
            default:
                //未读消息
                UnReadMsgBean unReadMsgBean = (UnReadMsgBean) o;
                int size = unReadMsgBean.getData();
                mMineFragment.setUnReadMsg(unReadMsgBean);
                TabLayout.Tab tab = mMainTablayout.getTabAt(2);
                TextView unReadTv = tab.getCustomView().findViewById(R.id.unread_tv);
                if (size > 0) {
                    unReadTv.setVisibility(View.VISIBLE);
                } else {
                    unReadTv.setVisibility(View.INVISIBLE);
                }

                break;
        }



    }
    @Override
    public void onSearch(String textContent) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onBackPressed() {
        exit();
    }


    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再次点击返回退出托养宝", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            //            ModuleIm_Init.logout();
            finish();
            System.exit(0);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected MainPresent createPresenter() {
        return new MainPresent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(MainActivity.this, LocateAndUpload.class));
    }


}