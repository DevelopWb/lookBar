package com.juntai.look.mine.devManager.devSet;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  nvr设备设置
 * @date 2020/9/2 15:35
 */
public class NvrDevSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mCameraNoTv;
    /**
     * 肯德基法兰
     */
    private TextView mCameraNameTv;
    private RecyclerView mNvrChildRv;
    /**
     * fdasdfsadfsad
     */
    private TextView mCameraAddrTv;
    /**
     * 球防守打法技
     */
    private TextView mCameraGroupTv;
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
        return R.layout.activity_nvr_dev_set;
    }

    @Override
    public void initView() {

        setTitleName("设置");
        mCameraNoTv = (TextView) findViewById(R.id.camera_no_tv);
        mCameraNameTv = (TextView) findViewById(R.id.camera_name_tv);
        mCameraNameTv.setOnClickListener(this);
        mNvrChildRv = (RecyclerView) findViewById(R.id.nvr_child_rv);
        mCameraAddrTv = (TextView) findViewById(R.id.camera_addr_tv);
        mCameraAddrTv.setOnClickListener(this);
        mCameraGroupTv = (TextView) findViewById(R.id.camera_group_tv);
        mCameraGroupTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
        NvrSetAdapter adapter = new NvrSetAdapter(R.layout.nvr_child_item);
        initRecyclerview(mNvrChildRv, adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getTestData());
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
            case R.id.camera_name_tv:
                break;
            case R.id.camera_addr_tv:
                break;
            case R.id.camera_group_tv:
                break;
            case R.id.delete_dev_tv:
                break;
        }
    }
}
