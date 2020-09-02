package com.juntai.look.mine.devManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  普通摄像头配置
 * @date 2020/9/2 15:34
 */
public class CameraSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mCameraNoTv;
    /**
     * 肯德基法兰
     */
    private TextView mCameraNameTv;
    /**
     * 球技
     */
    private TextView mCameraTypeTv;
    /**
     * fdasdfsadfsad
     */
    private TextView mCameraAddrTv;
    /**
     * 球防守打法技
     */
    private TextView mCameraGroupTv;
    /**
     * 分享到微信
     */
    private TextView mCameraShareWxTv;
    /**
     * 分享给好友账号
     */
    private TextView mCameraShareUserTv;
    /**
     * 全球直播
     */
    private TextView mShareWorldTv;
    /**
     * 本地全时段录像
     */
    private TextView mCameraRecordTv;
    /**
     * 删除设备
     */
    private TextView mDeleteDevTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_camera_set;
    }

    @Override
    public void initView() {
        setTitleName("设置");
        mCameraNoTv = (TextView) findViewById(R.id.camera_no_tv);
        mCameraNameTv = (TextView) findViewById(R.id.camera_name_tv);
        mCameraTypeTv = (TextView) findViewById(R.id.camera_type_tv);
        mCameraAddrTv = (TextView) findViewById(R.id.camera_addr_tv);
        mCameraGroupTv = (TextView) findViewById(R.id.camera_group_tv);
        mCameraShareWxTv = (TextView) findViewById(R.id.camera_share_wx_tv);
        mCameraShareWxTv.setOnClickListener(this);
        mCameraShareUserTv = (TextView) findViewById(R.id.camera_share_user_tv);
        mCameraShareUserTv.setOnClickListener(this);
        mShareWorldTv = (TextView) findViewById(R.id.share_world_tv);
        mShareWorldTv.setOnClickListener(this);
        mCameraRecordTv = (TextView) findViewById(R.id.camera_record_tv);
        mCameraRecordTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
        mCameraNameTv.setOnClickListener(this);
        mCameraTypeTv.setOnClickListener(this);
        mCameraAddrTv.setOnClickListener(this);
        mCameraGroupTv.setOnClickListener(this);
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
            case R.id.camera_share_wx_tv:
                break;
            case R.id.camera_share_user_tv:
                break;
            case R.id.share_world_tv:
                break;
            case R.id.camera_record_tv:
                break;
            case R.id.delete_dev_tv:
                break;
            case R.id.camera_name_tv:
                break;
            case R.id.camera_type_tv:
                break;
            case R.id.camera_addr_tv:
                break;
            case R.id.camera_group_tv:
                break;
        }
    }
}
