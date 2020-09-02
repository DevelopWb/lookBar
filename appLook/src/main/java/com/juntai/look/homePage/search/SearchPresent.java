package com.juntai.look.homePage.search;

import com.juntai.look.AppNetModule;
import com.juntai.look.bean.careTaker.SearchedPeopleBean;
import com.juntai.look.bean.careTaker.StreetBean;
import com.juntai.look.bean.careTaker.YearsBean;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.mvp.IModel;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/9 15:01
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/9 15:01
 */
public class SearchPresent extends BasePresenter<IModel,SearchContract.ISearchView> implements SearchContract.ISearchPresent {

    @Override
    public void getStreets(String tag) {
        AppNetModule
                .createrRetrofit()
                .getStreets()
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<StreetBean>(getView()) {
                    @Override
                    public void onSuccess(StreetBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag, msg);
                        }
                    }
                });
    }

    @Override
    public void getAllYears(String tag) {
        AppNetModule
                .createrRetrofit()
                .getAllYears()
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<YearsBean>(getView()) {
                    @Override
                    public void onSuccess(YearsBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag, msg);
                        }
                    }
                });
    }

    @Override
    public void searchAllCareTakers(RequestBody body, String tag) {
        AppNetModule
                .createrRetrofit()
                .searchCareTaker(body)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<SearchedPeopleBean>(getView()) {
                    @Override
                    public void onSuccess(SearchedPeopleBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag, msg);
                        }
                    }
                });
    }

    @Override
    public void searchAllDisabledPeoples(RequestBody body, String tag) {
        AppNetModule
                .createrRetrofit()
                .searchDisabledPeoples(body)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<SearchedPeopleBean>(getView()) {
                    @Override
                    public void onSuccess(SearchedPeopleBean o) {
                        if (getView() != null) {
                            getView().onSuccess(tag, o);
                        }

                    }

                    @Override
                    public void onError(String msg) {
                        if (getView() != null) {
                            getView().onError(tag, msg);
                        }
                    }
                });
    }


    @Override
    protected IModel createModel() {
        return null;
    }
}
