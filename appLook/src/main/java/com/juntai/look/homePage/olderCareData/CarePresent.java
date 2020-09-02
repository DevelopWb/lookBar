package com.juntai.look.homePage.olderCareData;

import com.juntai.look.AppNetModule;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.bean.CareChildListNewestBean;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.mvp.IModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/21 16:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/21 16:05
 */

public class CarePresent extends BasePresenter<IModel,CareContract.ICareView>implements CareContract.ICarePresent {


    @Override
    public void getCareChildList(RequestBody body, String tag) {
        AppNetModule
                .createrRetrofit()
                .getMyCare(body)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseObserver<CareChildListNewestBean>(getView()) {
                    @Override
                    public void onSuccess(CareChildListNewestBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag,o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag,msg);
                        }
                    }
                });
    }


    @Override
    protected IModel createModel() {
        return null;
    }

}
