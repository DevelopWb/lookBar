package com.juntai.look.mine.devManager.shareToAccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  分享的权限
 * @date 2020/9/14 17:52
 */
public class SharePermissionActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_share_permission;
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
