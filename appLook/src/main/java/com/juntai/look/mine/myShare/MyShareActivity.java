package com.juntai.look.mine.myShare;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.mine.MyShareBean;
import com.juntai.look.hcb.R;
import com.juntai.look.mine.MineContract;
import com.juntai.look.mine.MinePresent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

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
    private int currentPage = 1;//当前的页码
    private int pageSize = 12;//一次显示多少条

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
        mDeleteTv = (TextView) findViewById(R.id.bt_tv);
        mDeleteTv.setText("删除");
        mDeleteTv.setOnClickListener(this);
        mSmartrefreshlayout.setOnRefreshListener(refreshLayout -> {
            currentPage = 1;
            initData();
        });
        mSmartrefreshlayout.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            initData();
        });
    }


    @Override
    public void initData() {
        mPresenter.myShare(getBaseBuilder().add("currentPage", String.valueOf(currentPage)).add("pageSize",
                String.valueOf(pageSize)).build(), "");
    }


    @Override
    public void onSuccess(String tag, Object o) {
        mSmartrefreshlayout.finishRefresh();
        mSmartrefreshlayout.finishLoadMore();
        MyShareBean myShareBean = (MyShareBean) o;
        if (myShareBean != null) {
            MyShareBean.DataBean  dataBean =   myShareBean.getData();
            if (dataBean != null) {
                List<MyShareBean.DataBean.DatasBean> arrays = dataBean.getDatas();
                if (arrays != null) {
                    if (currentPage == 1) {
                        adapter.setNewData(arrays);
                    } else {
                        if (arrays.size() < pageSize) {
                            mSmartrefreshlayout.finishLoadMoreWithNoMoreData();
                        } else {
                            mSmartrefreshlayout.setNoMoreData(false);
                        }
                        adapter.addData(arrays);
                    }

                }
            }
        }
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
                    getTitleRightTv().setText("编辑");
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
