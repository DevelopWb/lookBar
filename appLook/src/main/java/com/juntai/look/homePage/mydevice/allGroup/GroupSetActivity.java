package com.juntai.look.homePage.mydevice.allGroup;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.ModifyNameActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.camerasOfGroup.CamerasListActivity;

import java.util.List;

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

    public static String GROUP_INFO="groupInfo";//分组信息
    private CameraListBean cameraListBean;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_group_set;
    }

    @Override
    public void initView() {
        setTitleName("分组设置");
        mGroupNameTv = (TextView) findViewById(R.id.camera_type_tv);
        mGroupNameTv.setOnClickListener(this);
        mDevsOfGroupTv = (TextView) findViewById(R.id.devs_of_group_tv);
        mDevsOfGroupTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            CameraGroupBean.DataBean dataBean  = getIntent().getParcelableExtra(GROUP_INFO);
            if (dataBean != null) {
                mGroupNameTv.setText(dataBean.getName());
                mPresenter.getCamerasOfGroup(getBaseBuilder().add("id",String.valueOf(dataBean.getId())).build(),"");
            }

        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        cameraListBean = (CameraListBean) o;
        if (cameraListBean != null) {
            List<CameraListBean.DataBean>   arrays = cameraListBean.getData();
            if (arrays != null) {
                    mDevsOfGroupTv.setText(String.format("%s%s", arrays.size(),"个摄像头"));
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.camera_type_tv:
                startActivity(new Intent(mContext, ModifyNameActivity.class));
                break;
            case R.id.devs_of_group_tv:
                startActivity(new Intent(mContext, CamerasListActivity.class).putExtra(CamerasListActivity.CAMERAS,cameraListBean));
                break;
            case R.id.delete_dev_tv:
                break;
        }
    }
}
