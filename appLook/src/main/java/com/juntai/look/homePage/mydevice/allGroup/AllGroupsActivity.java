package com.juntai.look.homePage.mydevice.allGroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDevAdapter;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.orhanobut.hawk.Hawk;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @aouther tobato
 * @description 描述  全部分组
 * @date 2020/8/30 16:34
 */
public class AllGroupsActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private AllGroupAdapter adapter;

    public static int ALL_GROUPS_RESULT = 1001;
    public static String ALL_GROUPS_POSITION = "position";

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.dev_content;
    }

    @Override
    public void initView() {
        setTitleName("全部分组");
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        adapter = new AllGroupAdapter(R.layout.my_group_item);
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(manager);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position!=adapter.getData().size()-1) {
                    Intent intent = new Intent();
                    intent.putExtra(ALL_GROUPS_POSITION,position);
                    setResult(ALL_GROUPS_RESULT,intent);
                    finish();
                }

            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view instanceof ImageView) {
                    startActivity(new Intent(mContext, CreateGroupActivity.class));
                } else {
                    startActivity(new Intent(mContext, GroupSetActivity.class));
                }

            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getVideoGroup(getBaseBuilder().build(), MyDeviceContract.CAMERA_GROUP);
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.CAMERA_GROUP:
                CameraGroupBean cameraGroupBean = (CameraGroupBean) o;
                if (cameraGroupBean != null) {
                    List<CameraGroupBean.DataBean> arrays = cameraGroupBean.getData();
                    Hawk.put(HawkProperty.CAMERA_GROUP, arrays);
                    arrays.add(new CameraGroupBean.DataBean(-1));
                    adapter.setNewData(arrays);
                }
                break;
            default:
                break;
        }
    }
}
