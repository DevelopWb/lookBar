package com.juntai.look.homePage.mydevice;

import com.juntai.look.AppNetModule;
import com.juntai.look.base.update.UpdatePresent;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.main.MainContract;
import com.juntai.wisdom.basecomponent.base.BaseObserver;
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

}
