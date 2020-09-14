package com.juntai.look.homePage.mydevice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;

/**
 * @aouther tobato
 * @description 描述 修改名称
 * @date 2020/9/13 14:59
 */
public class ModifyNameActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_modify_name;
    }

    @Override
    public void initView() {
        setTitleName("修改名称");
        getTitleRightTv().setText("完成");
    }

    @Override
    public void initData() {

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }
}
