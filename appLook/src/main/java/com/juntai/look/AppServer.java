package com.juntai.look;


import com.juntai.look.bean.CityBean;
import com.juntai.look.bean.UserBaseMsgBean;
import com.juntai.look.bean.careTaker.ServiceTypeBean;
import com.juntai.look.bean.LoginBean;
import com.juntai.look.bean.ServicePeoplePositionBean;
import com.juntai.look.bean.ServiceRecordBean;
import com.juntai.look.bean.SearchResultBean;
import com.juntai.look.bean.careTaker.CareRecordDetailBean;
import com.juntai.look.bean.careTaker.CareRecordPositionBean;
import com.juntai.look.bean.careTaker.CareTakerBaseInfoBean;
import com.juntai.look.bean.careTaker.CareTakerInfoBean;
import com.juntai.look.bean.careTaker.CareTakerInfoMoreBean;
import com.juntai.look.bean.careTaker.SearchedPeopleBean;
import com.juntai.look.bean.careTaker.ServicePeoplesBean;
import com.juntai.look.bean.careTaker.StreetBean;
import com.juntai.look.bean.careTaker.YearsBean;
import com.juntai.look.bean.mine.MyMsgBean;
import com.juntai.look.bean.mine.MyShareBean;
import com.juntai.look.bean.mine.UnReadMsgBean;
import com.juntai.look.bean.stream.CameraGroupBean;
import com.juntai.look.bean.stream.CameraListBean;
import com.juntai.look.bean.stream.CameraTypeBean;
import com.juntai.look.bean.stream.DevListBean;
import com.juntai.look.bean.stream.DevToAddBean;
import com.juntai.look.bean.stream.StreamCameraBean;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.bean.weather.ResponseForcastWeather;
import com.juntai.look.bean.weather.ResponseRealTimeWeather;
import com.juntai.wisdom.basecomponent.base.BaseResult;
import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;
import com.juntai.wisdom.basecomponent.bean.CaptureBean;
import com.juntai.wisdom.basecomponent.bean.CareChildListNewestBean;
import com.juntai.wisdom.basecomponent.bean.OpenLiveBean;
import com.juntai.wisdom.basecomponent.bean.VideoInfoBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * responseBody里的数据只能调用(取出)一次，第二次为空。可赋值给新的变量使用
 */
public interface AppServer {
    //    /**
    //     * 登录
    //     *
    //     * @param account
    //     * @param password
    //     * @return
    //     */
    //    @POST(AppHttpPath.LOGIN)
    //    Observable<UserBean> login(@Query("account") String account, @Query("password") String password);
    //    //车辆轨迹
    //    @POST(AppHttpPath.CAR_HISTORY)
    //    Observable<ResponseCarHistory> getPoliceCarTrack(@Body RequestBody body);
    //


    /**
     * 获取我的案件
     */
    @POST(AppHttpPath.GET_MYCASE)
    Observable<CareChildListNewestBean> getMyCase(@Body RequestBody body);

    /**
     * 获取我的案件
     */
    @POST(AppHttpPath.SEARCH_A)
    Observable<SearchResultBean> search(@Body RequestBody body);





    /*====================================================    描述信息
    ==============================================================*/

    //    /**
    //     * 获取托养子列表
    //     */
    //    @POST(AppHttpPath.CASE_INFO)
    //    Observable<CareChildListNewestBean> getMyCare(@Body RequestBody requestBody);

    /**
     * 获取所有的区域 街道
     */
    @POST(AppHttpPath.ALL_STREETS)
    Observable<StreetBean> getStreets();

    /**
     * 获取所有的区域 街道
     */
    @POST(AppHttpPath.GET_YEARS)
    Observable<YearsBean> getAllYears();

    /*==================================================== 登录接口
    ==============================================================*/

    /**
     * 登录
     */
    @POST(AppHttpPath.LOGIN)
    Observable<LoginBean> login(@Query("account") String account, @Query("password") String password);


    /**
     * 搜索托养人员
     */
    @POST(AppHttpPath.SEARCH_CARETAKER)
    Observable<SearchedPeopleBean> searchCareTaker(@Body RequestBody requestBody);

    /**
     * 搜索所有的残疾人
     */
    @POST(AppHttpPath.SEARCH_ALL_DISABLED_PEOPLE)
    Observable<SearchedPeopleBean> searchDisabledPeoples(@Body RequestBody requestBody);

    /**
     * 托养信息
     */
    @POST(AppHttpPath.CARE_INFO)
    Observable<CareTakerInfoBean> careInfo(@Body RequestBody requestBody);

    /**
     * 托养信息  更多
     */
    @POST(AppHttpPath.CARE_INFO_MORE)
    Observable<CareTakerInfoMoreBean> careInfoMore(@Body RequestBody requestBody);

    /**
     * 托养信息
     */
    @POST(AppHttpPath.CARE_RECORD)
    Observable<CareRecordDetailBean> careRecord(@Body RequestBody requestBody);

    /**
     * 托养信息
     */
    @POST(AppHttpPath.CARE_TAKER_BASE_INFO)
    Observable<CareTakerBaseInfoBean> careTakerBaseInfo(@Body RequestBody requestBody);

    /**
     * 添加托养人
     */
    @POST(AppHttpPath.ADD_CARE_TAKER)
    Observable<BaseResult> addCareTaker(@Body RequestBody requestBody);

    /**
     * 修改托养人
     */
    @POST(AppHttpPath.MODIFY_CARE_TAKER)
    Observable<BaseResult> modifyCareTaker(@Body RequestBody requestBody);

    /**
     * 托养分布
     */
    @POST(AppHttpPath.CARE_RECORD_POSITIONS)
    Observable<CareRecordPositionBean> careRecordPosition(@Body RequestBody requestBody);

    /**
     * 按街道分类服务人员
     */
    @POST(AppHttpPath.GET_SERVICE_PEOPLE)
    Observable<ServicePeoplesBean> getServicePeople(@Body RequestBody requestBody);


    /**
     * 提交托养记录
     */
    @POST(AppHttpPath.COMMIT_CARE_RECORD)
    Observable<BaseResult> commitCareRecord(@Body RequestBody requestBody);

    /**
     * 获取服务类型
     */
    @POST(AppHttpPath.GET_SERVICE_TYPE)
    Observable<ServiceTypeBean> getServiceType(@Body RequestBody requestBody);

    /*====================================================    天气
    ==============================================================*/


    //实时天气
    @GET(AppHttpPath.REALTIME_WEATHER)
    Observable<ResponseRealTimeWeather> getWeatherRealtime(@Query("longitude") String longitude,
                                                           @Query("latitude") String latitude);

    //天气预报
    @GET(AppHttpPath.FORCAST_WEATHER)
    Observable<ResponseForcastWeather> getForcast(@Query("longitude") String longitude,
                                                  @Query("latitude") String latitude);

    @GET(AppHttpPath.PROVINCE)
    Observable<CityBean> getProvince();

    @GET(AppHttpPath.CITY)
    Observable<CityBean> getCity(@Query("cityNum") int cityNum);

    @GET(AppHttpPath.AREA)
    Observable<CityBean> getArea(@Query("cityNum") int cityNum);

    @GET(AppHttpPath.STREET)
    Observable<CityBean> getStreet(@Query("cityNum") int townNum);


    /*====================================================    流媒体
    ==============================================================*/


    /**
     * 获取所有的流摄像头
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS)
    Observable<StreamCameraBean> getAllStreamCameras(@Body RequestBody requestBody);


    /**
     * 获取硬盘录像机下的所有的流摄像头
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS_FROM_VCR)
    Observable<StreamCameraBean> getAllStreamCamerasFromVCR(@Body RequestBody requestBody);

    /**
     * 摄像头详情
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_CAMERAS_DETAIL)
    Observable<StreamCameraDetailBean> getStreamCameraDetail(@Body RequestBody requestBody);


    /**
     * 上传封面图
     *
     * @return
     */
    @POST(AppHttpPath.UPLOAD_STREAM_CAMERAS_THUMB)
    Observable<BaseResult> uploadStreamCameraThumbPic(@Body RequestBody requestBody);

    /**
     * 打开视频流
     *
     * @return
     */
    @POST(AppHttpPath.STREAM_OPE_ADDR)
    Observable<OpenLiveBean> openStream(@Body RequestBody requestBody);

    /**
     * 会话id   保活的接口
     *
     * @param sessionid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/video_keepalive/{sessionid}")
    Observable<OpenLiveBean> keepAlive(@Path("sessionid") String sessionid);

    /**
     * 截图
     *
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/get_image/{channelid}/{type}")
    Observable<CaptureBean> capturePic(@Path("channelid") String channelid, @Path("type") String type);

    /**
     * 录像查询
     *
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/history_search/{begintime}/{endtime}/{channelid}")
    Observable<VideoInfoBean> searchVideos(@Path("begintime") String begintime, @Path("endtime") String endtime,
                                           @Path("channelid") String channelid);


    /**
     * 录像点播 获取rtmp流
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/playback/start?")
    Observable<OpenLiveBean> getVideosUrl(@QueryMap Map<String,String> options);


    /**
     * 云台操控
     * @param ptztype
     * @param ptzparam
     * @param channelid
     * @return
     */
    @GET(AppHttpPath.BASE_CAMERA_URL + "/vss/ptz/{ptztype}/{ptzparam}/{channelid}")
    Observable<BaseStreamBean> operateYunTai(@Path("ptztype") String ptztype, @Path("ptzparam") int ptzparam,
                                             @Path("channelid") String channelid);







    /**
     * 录像控制
     * "sessionid":    (字符串) 点播返回的sessionid句柄
     * 	"vodctrltype":  (字符串) "play","pause","stop","jump"
     * 	"vodctrlparam": (字符串)  0(pause,stop) / 0.125,0.25,0.5,1,2,4,8,16(play) (范围:0-32)/ 从开始时间跳转的秒数(jump)
     * @return
     */
    @GET("http://juntaikeji.net:8060/vss/his_stream_ctrl/{sessionid}/{vodctrltype}/{vodctrlparam}")
    Observable<BaseStreamBean> operateRecordVideo(@Path("sessionid") String sessionid,
                                               @Path("vodctrltype") String vodctrltype,
                                             @Path("vodctrlparam") String vodctrlparam);




    /**
     * 获取摄像头分组
     *
     * @return
     */
    @POST(AppHttpPath.CAMERA_GROUP)
    Observable<CameraGroupBean> getCameraGroup(@Body RequestBody requestBody);

    /**
     * 创建摄像头分组
     *
     * @return
     */
    @POST(AppHttpPath.ADD_CAMERA_GROUP)
    Observable<BaseResult> creatCameraGroup(@Body RequestBody requestBody);
    /**
     * 添加摄像头
     *
     * @return
     */
    @POST(AppHttpPath.ADD_CAMERA)
    Observable<BaseResult> addCamera(@Body RequestBody requestBody);
    /**
     * 保存摄像头配置
     *
     * @return
     */
    @POST(AppHttpPath.SAVE_CAMERA_CONFIG)
    Observable<BaseResult> saveCameraConfig(@Body RequestBody requestBody);
    /**
     * CAMERA_TYPE
     *
     * @return
     */
    @POST(AppHttpPath.CAMERA_TYPE)
    Observable<CameraTypeBean> cameraType(@Body RequestBody requestBody);
    /**
     * 添加NVR 设备
     *
     * @return
     */
    @POST(AppHttpPath.ADD_NVR_DEV)
    Observable<BaseResult> addNvrDev(@Body RequestBody requestBody);
    /**
     * 获取分组下的摄像头
     *
     * @return
     */
    @POST(AppHttpPath.GET_DEVS_OF_GROUP)
    Observable<DevListBean> getDevsOfGroup(@Body RequestBody requestBody);
    /**
     * 获取分组下的摄像头(不含nvr)
     *
     * @return
     */
    @POST(AppHttpPath.GET_CAMERAS_OF_GROUP)
    Observable<CameraListBean> getCamerasOfGroup(@Body RequestBody requestBody);
    /**
     * 获取nvr下的摄像头
     *
     * @return
     */
    @POST(AppHttpPath.GET_DEVS_OF_NVR)
    Observable<CameraListBean> getDevsOfNVR(@Body RequestBody requestBody);
    /**
     * 设备搜索（搜索设备序列号）接口
     *
     * @return
     */
    @POST(AppHttpPath.SEARCH_DEV_NUM)
    Observable<DevToAddBean> searchDevByNum(@Body RequestBody requestBody);
    /**
     * 转入设备
     *
     * @return
     */
    @POST(AppHttpPath.TRSFER_TO_GROUP)
    Observable<BaseResult> transferDev(@Body RequestBody requestBody);
    /**
     * 删除设备
     *
     * @return
     */
    @POST(AppHttpPath.DEL_DEV)
    Observable<BaseResult> deleteDev(@Body RequestBody requestBody);
    /**
     * 删除分组
     *
     * @return
     */
    @POST(AppHttpPath.DEL_GROUP)
    Observable<BaseResult> deleteGroup(@Body RequestBody requestBody);






















    /**
     * 服务人员
     *
     * @return
     */
    @POST(AppHttpPath.SERVICE_PEOPLES_POSITIONS)
    Observable<ServicePeoplePositionBean> getServicePeoplesPosition(@Body RequestBody requestBody);





    /*====================================================    描述信息
    ==============================================================*/

    /**
     * 服务记录
     */
    @POST(AppHttpPath.SERVICE_RECORD)
    Observable<ServiceRecordBean> serviceRecord(@Body RequestBody requestBody);

    /**
     * 退出登录
     */
    @POST(AppHttpPath.LOG_OUT)
    Observable<BaseResult> logout(@Body RequestBody requestBody);

    /**
     * 个人资料
     */
    @GET(AppHttpPath.USER_INFO)
    Observable<UserBaseMsgBean> persionalInfo(@QueryMap Map<String,String> options);

    /**
     * 修改头像
     */
    @POST(AppHttpPath.MODIFY_HEAD_ICON)
    Observable<BaseResult> modifyHeadIcon(@Body RequestBody requestBody);

    /**
     * 修改密码
     */
    @POST(AppHttpPath.MODIFY_PWD)
    Observable<BaseResult> modifyPwd(@Body RequestBody requestBody);

    /**
     * 我的消息
     */
    @POST(AppHttpPath.MY_NOTICE)
    Observable<MyMsgBean> myNotice(@Body RequestBody requestBody);
    /**
     * 我的分享
     */
    @POST(AppHttpPath.MY_SHARE)
    Observable<MyShareBean> myShare(@Body RequestBody requestBody);
    /**
     * 删除分享
     */
    @POST(AppHttpPath.DEL_SHARE)
    Observable<BaseResult> delShare(@Body RequestBody requestBody);

    /**
     * 消息已读
     */
    @POST(AppHttpPath.IS_READ)
    Observable<BaseResult> msgIsRead(@Body RequestBody requestBody);

    /**
     * 未读消息
     */
    @POST(AppHttpPath.UNREAD_MSG)
    Observable<UnReadMsgBean> unReadMsgAmount(@Body RequestBody requestBody);


    /**
     * 获取托养子列表
     */
    @POST(AppHttpPath.OLD_CASE_INFO)
    Observable<CareChildListNewestBean> getMyCare(@Body RequestBody requestBody);

}
