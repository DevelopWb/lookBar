package com.juntai.look.homePage.camera.yunkong;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.camera.PlayPresent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @Author: tobato
 * @Description: 作用描述  云控 收藏的位置
 * @CreateDate: 2020/8/14 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/14 9:23
 */
public class CameraYunControlChildPositionsFragment extends BaseAppFragment<PlayPresent> implements PlayContract.IPlayView, View.OnClickListener {
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    /**
     * 编辑
     */
    private TextView mEditSavedPositionTv;

    @Override
    protected PlayPresent createPresenter() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_camera_yun_control_child_position;
    }

    @Override
    protected void initView() {

        mRecyclerview = (RecyclerView) getView(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) getView(R.id.smartrefreshlayout);
        mEditSavedPositionTv = (TextView) getView(R.id.edit_saved_position_tv);
        mEditSavedPositionTv.setOnClickListener(this);

        YunPropertyAdapter adapter = new YunPropertyAdapter(R.layout.yun_property_item);
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        mRecyclerview.setLayoutManager(manager);
        mRecyclerview.setAdapter(adapter);
        adapter.setNewData(getBaseActivity().getTestData());


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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.edit_saved_position_tv:
                break;
        }
    }
}
