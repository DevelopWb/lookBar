package com.juntai.look.homePage.mydevice;


import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.base.ViewPagerAdapter;
import com.juntai.look.base.customView.CustomViewPager;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.allGroup.AllGroupsActivity;
import com.juntai.look.homePage.weather.WeatherHelper;
import com.juntai.look.main.MainContract;
import com.juntai.wisdom.basecomponent.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  我的设备（模式切换）
 * @date 2020/7/6 16:08
 */
public class MyDeviceFragment extends BaseMvpFragment<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        ViewPager.OnPageChangeListener, View.OnClickListener {

    private TabLayout mTablayout;
    private CustomViewPager mViewpager;
    List<Fragment> mFragments = new ArrayList<>();
    private String[] titles = null;
    private ViewPagerAdapter adapter;
    private ImageView mWeatherIconIv;
    /**
     * 晴朗
     */
    private TextView mWeatherNameTv;
    /**
     * 20°C
     */
    private TextView mTemperatureTv;
    /**
     * 空气质量:优
     */
    private TextView mAirQualityTv;
    private ConstraintLayout mWeatherCl;
    private ImageView mSearchIv;
    private ImageView mAddDevIv;
    private ConstraintLayout mTopLayoutCl;
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
    protected void lazyLoad() {
        //获取摄像头分组列表
        mPresenter.getVideoGroup(((BaseAppActivity)getActivity()).getBaseBuilder().build(),MyDeviceContract.CAMERA_GROUP);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.mine_device;
    }

    @Override
    protected void initView() {
        mTablayout = (TabLayout) getView(R.id.tablayout);
        mViewpager = (CustomViewPager) getView(R.id.viewpager);
        mWeatherIconIv = (ImageView) getView(R.id.weather_icon_iv);
        mWeatherNameTv = (TextView) getView(R.id.weather_name_tv);
        mTemperatureTv = (TextView) getView(R.id.temperature_tv);
        mAirQualityTv = (TextView) getView(R.id.air_quality_tv);
        mWeatherCl = (ConstraintLayout) getView(R.id.weather_cl);
        mWeatherCl.setOnClickListener(this);
        mSearchIv = (ImageView) getView(R.id.search_iv);
        mSearchIv.setOnClickListener(this);
        mAddDevIv = (ImageView) getView(R.id.add_dev_iv);
        mAddDevIv.setOnClickListener(this);
        mTopLayoutCl = (ConstraintLayout) getView(R.id.top_layout_cl);
        mTablayout = (TabLayout) getView(R.id.tablayout);
        mDevTotalAmountTv = (TextView) getView(R.id.dev_total_amount_tv);
        mMoreFuctionIv = (ImageView) getView(R.id.more_fuction_iv);
        mMoreFuctionIv.setOnClickListener(this);
        mViewpager = (CustomViewPager) getView(R.id.viewpager);
    }

    @Override
    protected void initData() {


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
    /**
     * 配置天气信息
     *
     * @param realTimeWeather
     */
    public void setWeatherInfos(ResponseRealTimeWeather realTimeWeather) {
        int aqi = realTimeWeather.getData().getResult().getAqi();
        mTemperatureTv.setText(Math.round(realTimeWeather.getData().getResult().getTemperature())+"°C");
        mAirQualityTv.setText( "空气质量:" + WeatherHelper.switchPM25(aqi));
        mWeatherNameTv.setText( WeatherHelper.switchSkycon(realTimeWeather.getData().getResult().getSkycon()));
        mWeatherIconIv.setImageResource( WeatherHelper.switchSkyconInt(realTimeWeather.getData().getResult().getSkycon()));
    }
    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.CAMERA_GROUP:
                CameraGroupBean  cameraGroupBean= (CameraGroupBean) o;
                if (cameraGroupBean != null) {
                    List<CameraGroupBean.DataBean> cameraGroups = cameraGroupBean.getData();
                    if (cameraGroups != null&&cameraGroups.size()>0) {
                        titles =null;
                        mFragments.clear();
                        titles =  new String[cameraGroups.size()];
                        for (int i = 0; i < cameraGroups.size(); i++) {
                            CameraGroupBean.DataBean dataBean = cameraGroups.get(i);
                            titles[i] = dataBean.getName();
                            mFragments.add(MyDevContentFragment.newInstance(i));

                        }
                        adapter = new ViewPagerAdapter(getChildFragmentManager(), mContext, titles, mFragments);
                        mViewpager.setAdapter(adapter);
                        mViewpager.setOffscreenPageLimit(titles.length);
                        /*viewpager切换监听，包含滑动点击两种*/
                        mViewpager.addOnPageChangeListener(this);
                        mTablayout.setupWithViewPager(mViewpager);
                        initTablayoutView(0, adapter);
                        /*viewpager切换默认第一个*/
                        mViewpager.setCurrentItem(0);
                    }
                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String tag, Object o) {

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
            case R.id.weather_cl:
                break;
            case R.id.search_iv:
                break;
            case R.id.add_dev_iv:
                break;
            case R.id.more_fuction_iv:
                startActivity(new Intent(mContext, AllGroupsActivity.class));

                break;
        }
    }
}
