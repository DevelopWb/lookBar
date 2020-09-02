package com.juntai.look.homePage.search;

import android.view.View;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.homePage.HomePageContract;
import com.juntai.look.homePage.HomePagePresent;
import com.juntai.look.hcb.R;

/**
 * @aouther tobato
 * @description 描述
 * @date 2020/4/23 10:46  更新  搜索
 */
public class SearchActivity extends BaseAppActivity<HomePagePresent> implements View.OnClickListener,
        HomePageContract.IHomePageView, SearchFragment.OnSearchCallBack {

    private SearchFragment searchTopFragment;


    @Override
    public void onClick(View v) {

    }

    @Override
    protected HomePagePresent createPresenter() {
        return new HomePagePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
    }

    @Override
    public void initData() {
    }

    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onSearch(String textContent) {

    }


}
