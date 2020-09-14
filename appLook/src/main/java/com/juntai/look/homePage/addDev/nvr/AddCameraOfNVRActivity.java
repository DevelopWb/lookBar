package com.juntai.look.homePage.addDev.nvr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述 添加nvr 里面的摄像头
 * @date 2020/9/13 11:18
 */
public class AddCameraOfNVRActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_add_camera_of_n_v_r;
    }

    @Override
    public void initView() {
        setTitleName("设备添加");
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }
}
