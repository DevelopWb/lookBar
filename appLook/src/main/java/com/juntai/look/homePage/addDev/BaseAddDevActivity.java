package com.juntai.look.homePage.addDev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;

/**
 * @Author: tobato
 * @Description: 作用描述  添加设备的基类  添加普通摄像头 添加nvr
 * @CreateDate: 2020/9/1 15:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/1 15:37
 */
public abstract class BaseAddDevActivity extends BaseMvpActivity<MyDevicePresent> implements View.OnClickListener,
        MyDeviceContract.IMyDeviceView {

    /**
     * 29374237492374973449
     */
    private TextView mAddDevNoTv;
    /**
     * 摄像头
     */
    private TextView mAddDevTypeTv;
    private FrameLayout mAddDevLayoutFl;
    private TextView mAddLocationAddrTv;
    /**
     * 设备名称:
     */
    private TextView mDevNameTv;
    private EditText mDevNameEt;
    /**
     * 保存
     */
    private TextView mSaveDevTv;

    protected abstract int getLayout();

    @Override
    public int getLayoutView() {
        return R.layout.base_add_dev;
    }

    @Override
    public void initView() {
        setTitleName("设备添加");
        mAddDevNoTv = (TextView) findViewById(R.id.add_dev_no_tv);
        mAddDevTypeTv = (TextView) findViewById(R.id.add_dev_type_tv);
        mAddDevLayoutFl = (FrameLayout) findViewById(R.id.add_dev_layout_fl);
        if (getLayout()!=0) {
            mAddDevLayoutFl.addView(LayoutInflater.from(mContext).inflate(getLayout(),mBaseRootCol,false));
        }
        mAddLocationAddrTv = (TextView) findViewById(R.id.add_location_addr_tv);
        mAddLocationAddrTv.setOnClickListener(this);
        mDevNameTv = (TextView) findViewById(R.id.dev_name_tv);
        mDevNameEt = (EditText) findViewById(R.id.dev_name_et);
        mSaveDevTv = (TextView) findViewById(R.id.save_dev_tv);
        mSaveDevTv.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }


    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.add_location_addr_tv:
                break;
            case R.id.save_dev_tv:
                break;
        }
    }
}
