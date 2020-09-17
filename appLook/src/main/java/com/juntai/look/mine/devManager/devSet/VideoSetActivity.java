package com.juntai.look.mine.devManager.devSet;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  录像设置
 * @date 2020/9/14 17:54
 */
public class VideoSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private Switch mSaveToLocalSv;
    private Switch mSaveToYunSv;
    private Spinner mSavedDaysSp;
    private Spinner mSaveTimeStartSp;
    private Spinner mSaveTimeEndSp;
    /**
     * 周日
     */
    private CheckBox mSundayCb;
    /**
     * 周一
     */
    private CheckBox mMondayCb;
    /**
     * 周二
     */
    private CheckBox mTuesdayCb;
    /**
     * 周三
     */
    private CheckBox mWednesdayCb;
    /**
     * 周四
     */
    private CheckBox mThursdayCb;
    /**
     * 周五
     */
    private CheckBox mFridayCb;
    /**
     * 周六
     */
    private CheckBox mSaturday;
    /**
     * 保存
     */
    private TextView mSaveConfigYunTv;
    /**
     * 2020-10-20 11:55
     */
    private TextView mDownloadStartTimeTv;
    /**
     * 2020-10-20 11:55
     */
    private TextView mDownloadEndTimeTv;
    /**
     * 发送下载指令
     */
    private TextView mDownloadTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_video_set;
    }

    @Override
    public void initView() {
        setTitleName("设备录像设置");
        mSaveToLocalSv = (Switch) findViewById(R.id.save_to_local_sv);
        mSaveToYunSv = (Switch) findViewById(R.id.save_to_yun_sv);
        mSavedDaysSp = (Spinner) findViewById(R.id.saved_days_sp);
        mSaveTimeStartSp = (Spinner) findViewById(R.id.save_time_start_sp);
        mSaveTimeEndSp = (Spinner) findViewById(R.id.save_time_end_sp);
        mSundayCb = (CheckBox) findViewById(R.id.sunday_cb);
        mMondayCb = (CheckBox) findViewById(R.id.monday_cb);
        mTuesdayCb = (CheckBox) findViewById(R.id.tuesday_cb);
        mWednesdayCb = (CheckBox) findViewById(R.id.wednesday_cb);
        mThursdayCb = (CheckBox) findViewById(R.id.thursday_cb);
        mFridayCb = (CheckBox) findViewById(R.id.friday_cb);
        mSaturday = (CheckBox) findViewById(R.id.saturday);
        mSaveConfigYunTv = (TextView) findViewById(R.id.save_config_yun_tv);
        mSaveConfigYunTv.setOnClickListener(this);
        mDownloadStartTimeTv = (TextView) findViewById(R.id.download_start_time_tv);
        mDownloadStartTimeTv.setOnClickListener(this);
        mDownloadEndTimeTv = (TextView) findViewById(R.id.download_end_time_tv);
        mDownloadEndTimeTv.setOnClickListener(this);
        mDownloadTv = (TextView) findViewById(R.id.download_tv);
        mDownloadTv.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.save_config_yun_tv:
                break;
            case R.id.download_start_time_tv:
                break;
            case R.id.download_end_time_tv:
                break;
            case R.id.download_tv:
                break;
        }
    }
}
