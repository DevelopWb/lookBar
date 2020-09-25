package com.juntai.look.homePage.mydevice;

import com.juntai.look.AppNetModule;
import com.juntai.look.base.update.UpdatePresent;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.main.MainContract;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.bean.VideoInfoBean;
import com.juntai.wisdom.basecomponent.mvp.BasePresenter;
import com.juntai.wisdom.basecomponent.mvp.IModel;
import com.juntai.wisdom.basecomponent.utils.RxScheduler;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/7/30 11:03
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/30 11:03
 */
public class MyDevicePresent extends BasePresenter<IModel,MyDeviceContract.IMyDeviceView> implements MyDeviceContract.IMyDevicePresent{
    @Override
    protected IModel createModel() {
        return null;
    }

    @Override
    public void getVideoGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getCameraGroup(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraGroupBean>(getView()) {
                    @Override
                    public void onSuccess(CameraGroupBean o) {
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
    public void creatVideoGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .creatCameraGroup(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<BaseResult>(getView()) {
                    @Override
                    public void onSuccess(BaseResult o) {
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
    public void getDevsOfGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getDevsOfGroup(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<DevListBean>(getView()) {
                    @Override
                    public void onSuccess(DevListBean o) {
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
    public void getDevsOfNVR(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getDevsOfNVR(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraListBean>(getView()) {
                    @Override
                    public void onSuccess(CameraListBean o) {
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
}
