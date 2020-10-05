package com.juntai.look.mine.devManager.shareToAccount;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.SharedUserBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.mine.devManager.devSet.BaseCameraSetActivity;

import java.util.List;

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
     * 取消分享
     */
    private TextView mCancelShareTv;
    private AccountAdapter adapter;

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
        mCancelShareTv = (TextView) findViewById(R.id.cancel_share_tv);
        mCancelShareTv.setOnClickListener(this);
        adapter = new AccountAdapter(R.layout.account_item);
        initRecyclerview(mAddedUsersRv, adapter, LinearLayoutManager.VERTICAL);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            String cameraNum = getIntent().getStringExtra(BaseCameraSetActivity.CAMERA_NUM);
            mPresenter.getSharedUserList(getBaseBuilder().add("number", cameraNum).build(),
                    MyDeviceContract.SHARED_USERS);
        }

    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.SHARED_USERS:
                SharedUserBean sharedUserBean = (SharedUserBean) o;
                if (sharedUserBean != null) {
                   List<SharedUserBean.DataBean> arrays =  sharedUserBean.getData();
                   adapter.setNewData(arrays);
                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.search_users_tv:
                //搜索用户
                startActivity(new Intent(mContext, SearchAccountToShareActivity.class));
                break;
            case R.id.cancel_share_tv:
                //取消分享
                break;
        }
    }
}
