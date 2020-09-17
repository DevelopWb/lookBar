package com.juntai.look.mine.devManager.shareToAccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  分享至账号
 * @date 2020/9/14 17:45
 */
public class ShareToAccountActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {

    /**
     * 搜索用户名或账号
     */
    private TextView mSearchUsersTv;
    private RecyclerView mAddedUsersRv;
    /**
     * 全时段
     */
    private TextView mSharedSpaceTv;
    private LinearLayout mSharedSpaceLl;
    /**
     * 预览、录像回放
     */
    private TextView mSharedPermissionTv;
    private LinearLayout mSharedPermissionLl;
    /**
     * 取消分享
     */
    private TextView mCancelShareTv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_share_to_account;
    }

    @Override
    public void initView() {
        setTitleName("分享到账号");
        mSearchUsersTv = (TextView) findViewById(R.id.search_users_tv);
        mSearchUsersTv.setOnClickListener(this);
        mAddedUsersRv = (RecyclerView) findViewById(R.id.added_users_rv);
        mSharedSpaceTv = (TextView) findViewById(R.id.shared_space_tv);
        mSharedSpaceLl = (LinearLayout) findViewById(R.id.shared_space_ll);
        mSharedSpaceLl.setOnClickListener(this);
        mSharedPermissionTv = (TextView) findViewById(R.id.shared_permission_tv);
        mSharedPermissionLl = (LinearLayout) findViewById(R.id.shared_permission_ll);
        mSharedPermissionLl.setOnClickListener(this);
        mCancelShareTv = (TextView) findViewById(R.id.cancel_share_tv);
        mCancelShareTv.setOnClickListener(this);
        AccountAdapter adapter = new AccountAdapter(R.layout.account_item);
        initRecyclerview(mAddedUsersRv,adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getTestData());
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
            case R.id.search_users_tv:
                //搜索用户
                startActivity(new Intent(mContext,SelectAccountToShareActivity.class));
                break;
            case R.id.shared_space_ll:
                //分享时间
                break;
            case R.id.shared_permission_ll:
                //分享权限
                break;
            case R.id.cancel_share_tv:
                //取消分享
                break;
        }
    }
}
