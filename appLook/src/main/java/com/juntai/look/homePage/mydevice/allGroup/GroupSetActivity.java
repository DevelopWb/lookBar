package com.juntai.look.homePage.mydevice.allGroup;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.ModifyNameActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.camerasOfGroup.CamerasListActivity;

/**
 * @aouther tobato
 * @description 描述  分组设置
 * @date 2020/9/3 11:17
 */
public class GroupSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    /**
     * 罗庄摄像头
     */
    private TextView mGroupNameTv;
    /**
     * 3个摄像头
     */
    private TextView mDevsOfGroupTv;
    /**
     * 删除设备
     */
    private TextView mDeleteDevTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return null;
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_group_set;
    }

    @Override
    public void initView() {
        setTitleName("分组设置");
        mGroupNameTv = (TextView) findViewById(R.id.group_name_tv);
        mGroupNameTv.setOnClickListener(this);
        mDevsOfGroupTv = (TextView) findViewById(R.id.devs_of_group_tv);
        mDevsOfGroupTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
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
            case R.id.group_name_tv:
                startActivity(new Intent(mContext, ModifyNameActivity.class));
                break;
            case R.id.devs_of_group_tv:
                startActivity(new Intent(mContext, CamerasListActivity.class));
                break;
            case R.id.delete_dev_tv:
                break;
        }
    }
}
