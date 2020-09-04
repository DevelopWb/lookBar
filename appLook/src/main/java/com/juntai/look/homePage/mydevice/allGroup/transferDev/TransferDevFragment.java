package com.juntai.look.homePage.mydevice.allGroup.transferDev;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
 * @Description: 作用描述  转入设备
 * @CreateDate: 2020/8/21 17:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/21 17:14
 */
public class TransferDevFragment extends BaseMvpFragment<MinePresent> implements MineContract.IMineView {


    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;

    public static TransferDevFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        TransferDevFragment fragment = new TransferDevFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected MinePresent createPresenter() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_transfer_dev;
    }

    @Override
    protected void initView() {

        mRecyclerview = (RecyclerView) getView(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) getView(R.id.smartrefreshlayout);
        TransferDevAdapter adapter = new TransferDevAdapter(R.layout.cameras_of_group_item);
        getBaseActivity().initRecyclerview(mRecyclerview,adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getBaseActivity().getTestData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

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
