package com.juntai.look.mine.devManager.shareToAccount;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;

/**
 * @aouther tobato
 * @description 描述  选择要分享的账号
 * @date 2020/9/14 17:47
 */
public class SelectAccountToShareActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView, View.OnClickListener {

    /**
     * 搜索用户名或账号
     */
    private EditText mSearchUsersEt;
    private ImageView mClearContentIv;
    private RecyclerView mUsersRv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_select_account_to_share;
    }

    @Override
    public void initView() {
        setTitleName("分享账号添加");
        mSearchUsersEt = (EditText) findViewById(R.id.search_users_et);
        mClearContentIv = (ImageView) findViewById(R.id.clear_content_iv);
        mClearContentIv.setOnClickListener(this);
        mUsersRv = (RecyclerView) findViewById(R.id.users_rv);
        AccountAdapter adapter = new AccountAdapter(R.layout.account_item);
        initRecyclerview(mUsersRv,adapter, LinearLayoutManager.VERTICAL);
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
            case R.id.clear_content_iv:
                mSearchUsersEt.setText("");
                break;
        }
    }
}
