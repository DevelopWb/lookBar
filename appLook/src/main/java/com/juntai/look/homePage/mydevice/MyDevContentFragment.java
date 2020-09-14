package com.juntai.look.homePage.mydevice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.hcb.R;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.juntai.wisdom.basecomponent.base.BaseMvpFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @Author: tobato
 * @Description: 作用描述  我的设备
 * @CreateDate: 2020/8/21 17:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/21 17:14
 */
public class MyDevContentFragment extends BaseMvpFragment<MyDevicePresent> implements MyDeviceContract.IMyDeviceView {


    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;

    public static MyDevContentFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        MyDevContentFragment fragment = new MyDevContentFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected MyDevicePresent createPresenter() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.dev_content;
    }

    @Override
    protected void initView() {

        mRecyclerview = (RecyclerView) getView(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) getView(R.id.smartrefreshlayout);
        MyDevAdapter adapter = new MyDevAdapter(R.layout.my_dev_item);
        GridLayoutManager manager = new GridLayoutManager(mContext,2);
        mRecyclerview.setAdapter(adapter);
        mRecyclerview.setLayoutManager(manager);
        adapter.setNewData(getBaseActivity().getTestData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,NVRDevDetailActivity.class));
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onError(String tag, Object o) {

    }

}
