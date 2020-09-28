package com.juntai.look.mine.devManager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;
import com.juntai.look.mine.devManager.devSet.CameraSetActivity;
import com.juntai.look.mine.devManager.devSet.NvrDevSetActivity;
import com.juntai.wisdom.basecomponent.base.BaseMvpFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/8/21 17:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/21 17:14
 */
public class DevManagerFragment extends BaseAppFragment<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {


    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private DevManagerAdapter adapter;

    public static DevManagerFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("groupId", type);
        DevManagerFragment fragment = new DevManagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    protected void lazyLoad() {
        int groupId = getArguments().getInt("groupId");
        mPresenter.getDevsOfGroup(getBaseAppActivity().getBaseBuilder().add("id",String.valueOf(groupId)).build(),"");
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.recycleview_layout;
    }

    @Override
    protected void initView() {

        mRecyclerview = (RecyclerView) getView(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) getView(R.id.smartrefreshlayout);
        adapter = new DevManagerAdapter(R.layout.dev_manager_item);
        getBaseActivity().initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                DevListBean.DataBean.ListBean bean = (DevListBean.DataBean.ListBean) adapter.getData().get(position);
                if (0==position) {
                    startActivity(new Intent(mContext, CameraSetActivity.class).putExtra(BaseCameraSetActivity.DEV_INFO,bean));
                }else {
                    startActivity(new Intent(mContext, NvrDevSetActivity.class));
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {
        DevListBean devListBean = (DevListBean) o;
        if (devListBean != null) {
            DevListBean.DataBean dataBean =  devListBean.getData();
            if (dataBean != null) {
                List<DevListBean.DataBean.ListBean> arrays =    dataBean.getList();
                if (arrays != null) {
                    adapter.setNewData(arrays);
                }

            }
        }
    }

    @Override
    public void onError(String tag, Object o) {

    }

}
