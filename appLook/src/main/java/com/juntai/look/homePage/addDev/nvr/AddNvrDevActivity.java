package com.juntai.look.homePage.addDev.nvr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.addDev.BaseAddDevActivity;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  添加硬盘录像机
 * @date 2020/9/2 9:40
 */
public class AddNvrDevActivity extends BaseAddDevActivity {


    private RecyclerView mNvrChildDevRv;
    private NvrChildAdapter adapter;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_add_nvr_dev;
    }

    @Override
    public void onSuccess(String tag, Object o) {
        super.onSuccess(tag, o);
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
            case PlayContract.GET_STREAM_CAMERA_DETAIL:
                StreamCameraDetailBean detailBean = (StreamCameraDetailBean) o;
                if (detailBean != null) {
                    mStreamCameraBean = detailBean.getData();
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
                CameraListBean.DataBean bean = (CameraListBean.DataBean) adapter.getData().get(position);
                int flag = bean.getBindingFlag();
                if (0==flag) {
                    //未绑定
                    if (mStreamCameraBean != null) {
                        startActivityForResult(new Intent(mContext, AddCameraOfNVRActivity.class).putExtra(BaseCameraSetActivity.CAMERA_NUM, bean.getNumber())
                                .putExtra(BaseCameraSetActivity.DEV_INFO, mStreamCameraBean), BASE_REQUESR);
                    }
                }else {
                    ToastUtils.toast(mContext,"已绑定");
                }

            }
        });


    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.getDevsOfNVR(getBaseBuilder().add("number", dataBean.getNumber()).add("channel",
                MyDeviceContract.CAMERAS_OF_NVR_2).build(), MyDeviceContract.CAMERAS_OF_NVR);
        mPresenter.getStreamCameraDetail(getBaseBuilder().add("id", String.valueOf(dataBean.getId())).build(),
                PlayContract.GET_STREAM_CAMERA_DETAIL);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (BASE_REQUESR == requestCode) {
            mPresenter.getDevsOfNVR(getBaseBuilder().add("number", dataBean.getNumber()).add("channel",
                    MyDeviceContract.CAMERAS_OF_NVR_2).build(), MyDeviceContract.CAMERAS_OF_NVR);
        }

    }
}
