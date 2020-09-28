package com.juntai.look.homePage.mydevice.allGroup.camerasOfGroup;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.look.homePage.mydevice.allGroup.transferDev.TransferDevActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  分组里的摄像头
 * @date 2020/9/3 11:32
 */
public class CamerasListActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    /**
     * 转入分组
     */
    private TextView mTransferDevTv;
    public static String  CAMERAS = "cameras";//分组下的所有摄像头
    private CamerasOfGroupAdapter adapter;

    @Override
    protected MyDevicePresent createPresenter() {
        return null;
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_cameras_of_group;
    }

    @Override
    public void initView() {
        setTitleName("所有摄像头");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        mTransferDevTv = (TextView) findViewById(R.id.transfer_dev_tv);
        mTransferDevTv.setOnClickListener(this);
        adapter = new CamerasOfGroupAdapter(R.layout.cameras_of_group_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext, SelectGroupActivity.class));
            }
        });
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            CameraListBean cameraListBean =  getIntent().getParcelableExtra(CAMERAS);
            if (cameraListBean != null) {
                List<CameraListBean.DataBean> arrays = cameraListBean.getData();
                adapter.setNewData(arrays);
            }

        }

    }


    @Override
    public void onSuccess(String tag, Object o) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.transfer_dev_tv:
                //转入设备
                startActivityForResult(new Intent(mContext, TransferDevActivity.class),BASE_REQUESR);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR==requestCode) {
            initData();
        }
    }
}
