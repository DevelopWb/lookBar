package com.juntai.look.homePage.mydevice.allGroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  转移设备
 * @date 2020/9/3 11:41
 */
public class TransferDevActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    @Override
    protected MyDevicePresent createPresenter() {
        return null;
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_transfer_dev;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }
}
