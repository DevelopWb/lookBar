package com.juntai.look.homePage.careTaker.addCareTaker;

import android.view.View;


import com.juntai.look.hcb.R;
import com.juntai.look.homePage.HomePageContract;
import com.juntai.look.homePage.HomePagePresent;
import com.juntai.wisdom.basecomponent.base.BaseMvpFragment;

/**
 * @aouther tobato
 * @description 描述  添加托养人
 * @date 2020/7/6 16:23
 */

public class AddCareTakerFragment extends BaseMvpFragment<HomePagePresent> implements View.OnClickListener,
        HomePageContract.IHomePageView {


    @Override
    protected int getLayoutRes() {
        return R.layout.add_care_taker;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
    }

    @Override
    protected HomePagePresent createPresenter() {
        return new HomePagePresent();
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onError(String tag, Object o) {

    }


}
