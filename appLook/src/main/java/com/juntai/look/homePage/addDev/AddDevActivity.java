package com.juntai.look.homePage.addDev;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;

import com.baidu.location.BDLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.QRScanActivity;
import com.juntai.look.homePage.addDev.nvr.AddNvrDevActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @aouther tobato
 * @description 描述  添加设备
 * @date 2020/9/1 15:22
 */
public class AddDevActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private ImageView mScanDevIv;
    private RecyclerView mRecyclerview;
    private SmartRefreshLayout mSmartrefreshlayout;
    private long currentTime;
    private SearchView mSearchContentSv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_add_dev;
    }



    @Override
    public void initView() {
        setTitleName("添加设备");
        mScanDevIv = (ImageView) findViewById(R.id.scan_dev_iv);
        mScanDevIv.setOnClickListener(this);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartrefreshlayout = (SmartRefreshLayout) findViewById(R.id.smartrefreshlayout);
        mSearchContentSv = (SearchView) findViewById(R.id.search_content_sv);
        SearchView.SearchAutoComplete textView =
                (SearchView.SearchAutoComplete) mSearchContentSv.findViewById(R.id.search_src_text);
        textView.setTextSize(12);
        AddDevAdapter adapter = new AddDevAdapter(R.layout.add_dev_item);
        initRecyclerview(mRecyclerview, adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getTestData());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (0==position) {
                    startActivity(new Intent(mContext, AddNornalCameraActivity.class));
                }else {
                    startActivity(new Intent(mContext, AddNvrDevActivity.class));
                }
            }
        });
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
            default:
                break;
            case R.id.scan_dev_iv:
                if ((System.currentTimeMillis() - currentTime) < 800) {
                    return;
                }
                currentTime = System.currentTimeMillis();
                startActivity(new Intent(mContext,
                        QRScanActivity.class));
                break;
        }
    }

}
