package com.juntai.look.homePage.addDev.nvr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.addDev.BaseAddDevActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  添加硬盘录像机
 * @date 2020/9/2 9:40
 */
public class AddNvrDevActivity extends BaseAddDevActivity {


    private RecyclerView mNvrChildDevRv;
    private NvrChildAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_add_nvr_dev;
    }

    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.CAMERAS_OF_NVR:
                CameraListBean devListBean = (CameraListBean) o;
                if (devListBean != null) {
                    List<CameraListBean.DataBean> dataBean = devListBean.getData();
                    if (dataBean != null) {
                        adapter.setNewData(dataBean);

                    }
                }


                break;
            default:
                break;
        }
    }


    @Override
    public void initView() {
        super.initView();
        mNvrChildDevRv = (RecyclerView) findViewById(R.id.nvr_child_dev_rv);
        adapter = new NvrChildAdapter(R.layout.nvr_child_item);
        initRecyclerview(mNvrChildDevRv, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext, AddCameraOfNVRActivity.class));
            }
        });

        mPresenter.getDevsOfNVR(getBaseBuilder().add("number", dataBean.getNumber()).add("channel",
                MyDeviceContract.CAMERAS_OF_NVR_1).build(), MyDeviceContract.CAMERAS_OF_NVR);
    }
}
