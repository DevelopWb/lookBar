package com.juntai.look.homePage.mydevice;

import com.juntai.wisdom.basecomponent.mvp.BaseIView;

import okhttp3.RequestBody;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/4/21 16:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/21 16:05
 */
public interface MyDeviceContract {

    /**
     * 查询视频分组
     */
    String CAMERA_GROUP = "/getVideoGroup.shtml";

    /**
     * 创建视频分组
     */
    String ADD_CAMERA_GROUP = "/addVideoGroup.shtml";
    /**
     * 转入设备
     */
    String TRANSFER_DEV = "/transfer.shtml";


    interface IMyDeviceView extends BaseIView {
    }

    interface IMyDevicePresent {
        /**
         * 获取摄像头分组
         *
         * @param requestBody
         * @param tag
         */
        void getVideoGroup(RequestBody requestBody, String tag);

        /**
         * 创建摄像头分组
         *
         * @param requestBody
         * @param tag
         */
        void creatVideoGroup(RequestBody requestBody, String tag);


        /**
         * 获取分组下的设备列表
         *
         * @param requestBody
         * @param tag
         */
        void getDevsOfGroup(RequestBody requestBody, String tag);
        /**
         * 获取分组下的设备列表(不含nvr)
         *
         * @param requestBody
         * @param tag
         */
        void getCamerasOfGroup(RequestBody requestBody, String tag);

        /**
         * 获取nvr下的设备列表
         *
         * @param requestBody
         * @param tag
         */
        void getDevsOfNVR(RequestBody requestBody, String tag);

        /**
         * 设备搜索（搜索设备序列号）接口
         *
         * @param requestBody
         * @param tag
         */
        void searchDevByNum(RequestBody requestBody, String tag);
        /**
         * 转入设备
         *
         * @param requestBody
         * @param tag
         */
        void transferDev(RequestBody requestBody, String tag);






    }

}
