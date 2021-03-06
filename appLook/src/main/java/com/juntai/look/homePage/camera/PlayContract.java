package com.juntai.look.homePage.camera;


import com.juntai.look.AppHttpPath;
import com.juntai.wisdom.basecomponent.bean.OpenLiveBean;
import com.juntai.wisdom.basecomponent.mvp.BaseIView;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/5/30 9:50
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/5/30 9:50
 */
public interface PlayContract {


    String GET_URL_PATH = "get_url_path";//获取流地址
    String GET_STREAM_CAMERA_DETAIL = "get_url_path_detail";//获取摄像头详情
    String GET_STREAM_CAMERA_THUMBNAIL = "get_url_path_capture";//缩略图
    String GET_STREAM_CAMERA_CAPTURE = "get_url_path_capture_save";//截图  保存本地
    String UPLOAD_CAMERA_CAPTURE = "upload_path_capture";//上传截图
    String SEARCH_MONTH_OF_VIDEOABLE = "searchVideos";// 查看一个月中 哪些天有录像
    String SEARCH_DAY_OF_VIDEOABLE = "searchVideosDay";// 查看一天中 哪些时间段有录像
    String GET_VIDEO_RTMP_URL = "hrygeturl";//获取录像的流
    String OPERATE_YUNTAI = "operate";//操控云台
    String OPERATE_YUNTAI_UP = "up";//操控云台  向上
    String OPERATE_YUNTAI_DOWN = "down";//操控云台  向上
    String OPERATE_YUNTAI_LEFT = "left";//操控云台  向上
    String OPERATE_YUNTAI_RIGHT = "right";//操控云台  向上
    String OPERATE_YUNTAI_ZOOM_IN = "zoomin";//操控云台  拉近
    String OPERATE_YUNTAI_ZOOM_OUT = "zoomout";//操控云台  拉远
    String OPERATE_YUNTAI_SAVE_POS = "setpos";//操控云台  保存位置
    String OPERATE_YUNTAI_CALL_POS = "callpos";//操控云台  调整位置
    String OPERATE_YUNTAI_DEL_POS = "delpos";//操控云台  删除位置
    String OPERATE_YUNTAI_STOP = "stop";//操控云台  停止
    int OPERATE_YUNTAI_SPEED = 50;//操控云台 调控速度
    String OPERATE_RECORD_VIDEO = "oprate_video";//操控录像

    interface IPlayView extends BaseIView {

    }

    interface IPlayPresent {
        /**
         * 打开视频流
         *
         * @param channelid
         * @param type
         * @param videourltype
         * @param tag
         */
        void openStream(String channelid, String type, String videourltype, String tag);

        /**
         * 截图
         *
         * @param channelid
         * @param type
         * @param tag
         */
        void capturePic(String channelid, String type, String tag);

        /**
         * 摄像头详情
         *
         * @param tag
         */
        void getStreamCameraDetail(RequestBody requestBody, String tag);


        /**
         * 上传封面图
         *
         * @param tag
         */
        void uploadStreamCameraThumbPic(RequestBody requestBody, String tag);

        /**
         * 录像查询
         *
         * @param begintime
         * @param endtime
         * @param channelid
         * @param tag
         */
        void searchVideos(String begintime, String endtime, String channelid, String tag);

        /**
         * 云台操控
         *
         * @param ptztype
         * @param ptzparam
         * @param channelid
         * @param tag
         */
        void operateYunTai(String ptztype, int ptzparam, String channelid, String tag);

        /**
         * 录像点播 获取rtmp流
         *
         * @return
         */
        void playHisVideo(Map<String, String> queryMap, String tag);

        /**
         * 录像控制
         *
         * @return
         */
        void operateRecordVideo(String sessionid, String vodctrltype, String vodctrlparam,String tag);

    }
}
