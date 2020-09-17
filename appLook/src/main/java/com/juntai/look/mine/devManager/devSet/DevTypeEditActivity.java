package com.juntai.look.mine.devManager.devSet;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  设备类型编辑
 * @date 2020/9/14 16:28
 */
public class DevTypeEditActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    /**
     * 球机
     */
    private RadioButton mBallTypeRb;
    /**
     * 半球
     */
    private RadioButton mHalfBallTypeRb;
    /**
     * 枪机
     */
    private RadioButton mGunTypeRb;
    /**
     * 其他
     */
    private RadioButton mOtherTypeRb;
    /**
     * 是
     */
    private RadioButton mHasYunRb;
    /**
     * 否
     */
    private RadioButton mNoHaveYunRb;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_dev_type_edit;
    }

    @Override
    public void initView() {
        setTitleName("设备类型编辑");
        getTitleRightTv().setText("保存");
        getTitleRightTv().setOnClickListener(this);

        mBallTypeRb = (RadioButton) findViewById(R.id.ball_type_rb);
        mHalfBallTypeRb = (RadioButton) findViewById(R.id.half_ball_type_rb);
        mGunTypeRb = (RadioButton) findViewById(R.id.gun_type_rb);
        mOtherTypeRb = (RadioButton) findViewById(R.id.other_type_rb);
        mHasYunRb = (RadioButton) findViewById(R.id.has_yun_rb);
        mNoHaveYunRb = (RadioButton) findViewById(R.id.no_have_yun_rb);
        mBallTypeRb.setOnClickListener(this);
        mHalfBallTypeRb.setOnClickListener(this);
        mGunTypeRb.setOnClickListener(this);
        mOtherTypeRb.setOnClickListener(this);
        mHasYunRb.setOnClickListener(this);
        mNoHaveYunRb.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }

    /**
     * 初始化类型选择
     */
    private void initCameraTypeRb(int type) {
        mBallTypeRb.setChecked(false);
        mHalfBallTypeRb.setChecked(false);
        mGunTypeRb.setChecked(false);
        mOtherTypeRb.setChecked(false);
        switch (type) {
            case 1:
                mBallTypeRb.setChecked(true);
                break;
            case 2:
                mHalfBallTypeRb.setChecked(true);
                break;
            case 3:
                mGunTypeRb.setChecked(true);
                break;
            case 4:
                mOtherTypeRb.setChecked(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_rightTv:
                //保存
                break;
            default:
                break;
            case R.id.ball_type_rb:
                initCameraTypeRb(1);
                break;
            case R.id.half_ball_type_rb:
                initCameraTypeRb(2);

                break;
            case R.id.gun_type_rb:
                initCameraTypeRb(3);

                break;
            case R.id.other_type_rb:
                initCameraTypeRb(4);

                break;
            case R.id.has_yun_rb:
                break;
            case R.id.no_have_yun_rb:
                break;
        }
    }

}
