package com.juntai.look.mine.myShare;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @aouther tobato
 * @description 描述  我的分享
 * @date 2020/9/12 14:27
 */
public class MyShareActivity extends BaseAppActivity<MinePresent> implements MineContract.IMineView,
        View.OnClickListener {

    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private MyShareAdapter adapter;
    private TextView mDeleteTv;

    @Override
    protected MinePresent createPresenter() {
        return new MinePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_my_share;
    }

    @Override
    public void initView() {
        setTitleName("我的分享");
        getTitleRightTv().setText("编辑");
        getTitleRightTv().setOnClickListener(this);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        adapter = new MyShareAdapter(R.layout.my_share_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getTestData());
        mDeleteTv = (TextView) findViewById(R.id.bt_tv);
        mDeleteTv.setText("删除");
        mDeleteTv.setOnClickListener(this);
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
            case R.id.title_rightTv:
                if ("编辑".equals(getTextViewValue(getTitleRightTv()))) {
                    //编辑按钮
                    //显示选择控件
                    //显示删除按钮
                    mDeleteTv.setVisibility(View.VISIBLE);
                    getTitleRightTv().setText("完成");
                } else {
                    //隐藏选择控件
                    //隐藏删除按钮
                    mDeleteTv.setVisibility(View.GONE);
                }

                break;
            case R.id.bt_tv:
                //删除按钮
                break;
            default:
                break;
        }
    }
}
