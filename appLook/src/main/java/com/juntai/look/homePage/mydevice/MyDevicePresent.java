package com.juntai.look.homePage.mydevice;

import com.juntai.look.AppNetModule;
import com.juntai.look.base.update.UpdatePresent;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.CameraTypeBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
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
public class MyDevicePresent extends BasePresenter<IModel, MyDeviceContract.IMyDeviceView> implements MyDeviceContract.IMyDevicePresent {
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
    public void addCamera(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .addCamera(requestBody)
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
    public void saveCameraConfig(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .saveCameraConfig(requestBody)
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
    public void cameraType(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .cameraType(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<CameraTypeBean>(getView()) {
                    @Override
                    public void onSuccess(CameraTypeBean o) {
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
    public void addNvrDev(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .addNvrDev(requestBody)
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
    public void getCamerasOfGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getCamerasOfGroup(requestBody)
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

    @Override
    public void searchDevByNum(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .searchDevByNum(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<DevToAddBean>(getView()) {
                    @Override
                    public void onSuccess(DevToAddBean o) {
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
    public void transferDev(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .transferDev(requestBody)
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
    public void deleteDev(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .deleteDev(requestBody)
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
    public void deleteGroup(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .deleteGroup(requestBody)
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

    public void getStreamCameraDetail(RequestBody requestBody, String tag) {
        AppNetModule.createrRetrofit()
                .getStreamCameraDetail(requestBody)
                .compose(RxScheduler.ObsIoMain(getView()))
                .subscribe(new BaseObserver<StreamCameraDetailBean>(null) {
                    @Override
                    public void onSuccess(StreamCameraDetailBean o) {
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
