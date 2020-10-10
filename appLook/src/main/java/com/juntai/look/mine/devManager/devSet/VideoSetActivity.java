package com.juntai.look.mine.devManager.devSet;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.UserInfoManager;
import com.juntai.wisdom.basecomponent.utils.PickerManager;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String devNum = null;
    private String devctrltype = "record";//设备控制类型
    private String param_start = "start";//设备控制类型
    private String param_stop = "stop";//设备控制类型
    private String download_start_time = null;//下载开始时间
    private String download_end_time = null;//下载结束时间

    private long startTime = 0;
    private long endTime = 0;

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
        download_start_time = sdf.format(new Date());
        download_end_time = download_start_time;
        mDownloadStartTimeTv.setText(download_start_time);
        mDownloadEndTimeTv = (TextView) findViewById(R.id.download_end_time_tv);
        mDownloadEndTimeTv.setOnClickListener(this);
        mDownloadEndTimeTv.setText(download_end_time);
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();

        mDownloadTv = (TextView) findViewById(R.id.download_tv);
        mDownloadTv.setOnClickListener(this);
        mSaveToLocalSv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (devNum == null) {
                    return;
                }
                if (isChecked) {
                    mPresenter.operateDev(devNum, devctrltype, param_start, "");
                } else {
                    mPresenter.operateDev(devNum, devctrltype, param_stop, "");
                }
            }
        });
    }

    @Override
    public void initData() {
        StreamCameraDetailBean.DataBean mStreamCameraBean = Hawk.get(HawkProperty.CURRENT_CAMERA_SET);
        if (mStreamCameraBean != null) {
            //shareTimeintervalId  目前默认传0（0全时段；1自定义时段）
            devNum = mStreamCameraBean.getNumber();
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.DOWNLOAD:
                ToastUtils.toast(mContext, "已发送下载指令");
                break;
            default:
                ToastUtils.toast(mContext, "操作成功");
                break;
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.save_config_yun_tv:
                break;
            case R.id.download_start_time_tv:
                PickerManager.getInstance().showTimePickerView(mContext, PickerManager.getInstance().getTimeType(
                        "minute"), "录像开始时间", new PickerManager.OnTimePickerTimeSelectedListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        startTime = date.getTime();
                        download_start_time = sdf.format(date);
                        mDownloadStartTimeTv.setText(download_start_time);
                        download_start_time = download_start_time.replace(" ", "T");
                    }
                });
                break;
            case R.id.download_end_time_tv:
                PickerManager.getInstance().showTimePickerView(mContext, PickerManager.getInstance().getTimeType(
                        "minute"), "录像结束时间", new PickerManager.OnTimePickerTimeSelectedListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        endTime = date.getTime();
                        download_end_time = sdf.format(date);
                        mDownloadEndTimeTv.setText(download_end_time);
                        download_end_time = download_end_time.replace(" ", "T");

                    }
                });
                break;
            case R.id.download_tv:
                if (endTime > startTime) {
                    if (!download_start_time.contains("T")) {
                        download_start_time = download_start_time.replace(" ", "T");
                    }
                    if (!download_end_time.contains("T")) {
                        download_end_time = download_end_time.replace(" ", "T");
                    }
                    //todo  这个地方需要保活  后期添加

                    mPresenter.recordDownload(devNum,download_start_time,download_end_time, MyDeviceContract.DOWNLOAD);
                } else {
                    ToastUtils.toast(mContext, "结束时间不能比开始时间小");
                }


                break;
        }
    }
}
