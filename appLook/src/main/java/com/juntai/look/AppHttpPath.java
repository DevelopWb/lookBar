package com.juntai.look;

public class AppHttpPath {
    /**
     * base
     */
    //    public static final String BASE = "http://kb167.cn:25080/zhcl";
    /**
     * base
     */
    //    public static final String BASE_IMAGE = "http://image.kb167.cn/";
    public static final String BASE_IMAGE = "http://192.168.124.115:8092";

    //    /**
    //     * 摄像头缩略图
    //     */
    //    public static final String STREAM_CAMERA_THUMBNAI_IMAGE = "https://www.juntaikeji
    //    .com:17002/cameraImg/thumbnail/";
    /**
     * 测试接口
     */
    public static final String BASE = "http://192.168.124.115:8080/streamingMedia/u/app";

    /**
     * 获取案件类型
     */
    public static final String GET_CASE_TYPE = BASE + "/u/appCallCate.shtml";
    /**
     * 获取我的案件
     */
    public static final String GET_MYCASE = BASE + "/u/infoAppCaseById.shtml";
    /**
     * 搜索
     */
    public static final String SEARCH_A = BASE + "/u/appCallUnion.shtml";

    /*====================================================    天气
    ==============================================================*/

    //实时天气
    public static final String REALTIME_WEATHER = BASE + "/getRealTimeWeather.shtml";
    //天气预报
    public static final String FORCAST_WEATHER = BASE + "/getForecastWeather.shtml";
    //获取省份
    public static final String PROVINCE = BASE + "/getProvince.shtml";
    //获取城市 u/apiAppAlarm/getProvince.shtml
    public static final String CITY = BASE + "/getCity.shtml";
    //获取地区 u/apiAppAlarm/getProvince.shtml
    public static final String AREA = BASE + "/getArea.shtml";
    //获取街道
    public static final String STREET = BASE + "/getStreet.shtml";






    /*==============================================  流媒体相关  =============================================*/


    //摄像头拉流地址
    public static final String BASE_CAMERA_URL = "http://juntaikeji.net:8060";
    //摄像头拉流地址
    public static final String BASE_CAMERA_CAPTURE_URL = "http://juntaikeji.net:8080/";

    //摄像头拉流地址
    public static final String BASE_CAMERA_DNS = "rtmp://www.juntaikeji.net:1935";

    /**
     * 硬盘录像机下面的摄像头列表
     */
    public static final String STREAM_CAMERAS_FROM_VCR = BASE + "/u/camera/selectCameraByDvrIdAPP.shtml?";


    /**
     * 视频广场
     */
    public static final String STREAM_CAMERAS = BASE + "/getVideoSquare.shtml";
    /**
     * 获取视频播放地址
     */
    public static final String STREAM_OPE_ADDR = BASE + "/getVideoOpenStream.shtml";


    /**
     * 上传封面图
     */
    public static final String UPLOAD_STREAM_CAMERAS_THUMB = BASE + "/uploadVideoEzopen.shtml";
    /**
     * 流媒体缩略图地址
     */
    public static final String THUMB_ADDR = "http://192.168.124.115:8092/thumbnail";

    //    /**
    //     * 摄像头缩略图
    //     */
    //    public static final String THUMB_ADDR = "https://www.juntaikeji.com:17002/cameraImg/thumbnail/";


    /**
     * 摄像头详情
     */
    public static final String STREAM_CAMERAS_DETAIL = BASE + "/getVideoInfo.shtml";


    /**
     * 查询视频分组
     */
    public static final String CAMERA_GROUP = BASE + "/getVideoGroup.shtml";

    /**
     * 创建视频分组
     */
    public static final String ADD_CAMERA_GROUP = BASE + "/addVideoGroup.shtml";

    /**
     * 创建视频
     */
    public static final String ADD_CAMERA = BASE + "/addVideo.shtml";
    /**
     * 保存视频设置  也可以用于nvr名称修改
     */
    public static final String SAVE_CAMERA_CONFIG = BASE + "/updateVideo.shtml";
    /**
     * 视频leixing
     */
    public static final String CAMERA_TYPE = BASE + "/getVideoType.shtml";
    /**
     * 创建NVR设备
     */
    public static final String ADD_NVR_DEV = BASE + "/addDvr.shtml";


    /**
     * 开启全球直播申请接口
     */
    public static final String APPLY_LIVE_GLOBAL = BASE + "/auditVideoShare.shtml";
    /**
     * 删除设备
     */
    public static final String DEL_DEV = BASE + "/deleteVideo.shtml";

    /**
     * 转入设备到分组
     */
    public static final String TRSFER_TO_GROUP = BASE + "/shiftVideoGroup.shtml";

    /**
     * 删除分组
     */
    public static final String DEL_GROUP = BASE + "/deleteGroup.shtml";
    /**
     * 更新分组名称
     */
    public static final String UPDATE_GROUP_NAME = BASE + "/updateGroup.shtml";
    /**
     * 分组详情
     */
    public static final String GROUP_INFO = BASE + "/getGroupInfo.shtml";
    /**
     * 设备搜索（搜索设备序列号）接口
     */
    public static final String SEARCH_DEV_NUM = BASE + "/searchSerialNumber.shtml";


    /**
     * 获取分组下对应的设备(包含nvr)
     */
    public static final String GET_DEVS_OF_GROUP = BASE + "/getListModel.shtml";
    /**
     * 获取分组下对应的设备(不包含nvr)
     */
    public static final String GET_CAMERAS_OF_GROUP = BASE + "/getVideoBelongGroup.shtml";

    /**
     * 获取硬盘录像机下对应的设备
     */
    public static final String GET_DEVS_OF_NVR = BASE + "/getVideoBelongDvr.shtml";

















    /*==============================================  搜索  =============================================*/

    /**
     * 搜索
     */
    public static final String SEARCH = BASE + "/search.shtml";


    /**
     * 搜索更多
     */
    public static final String SEARCH_MORE = BASE + "/searchMore.shtml";


























    /*==============================================  托养信息  =============================================*/


    /**
     * 获取托养子列表/u/infoAppCase.shtml
     */
    //    public static final String CASE_INFO = BASE + "/u/infoAppCase.shtml";
    /**
     * 获取托养子列表/u/infoAppCase.shtml
     */
    public static final String ALL_STREETS = BASE + "/u/appConnector/selectStreet.shtml";
    /**
     * 查询年份
     */
    public static final String GET_YEARS = BASE + "/u/appConnector/selectYear.shtml";





    /*==============================================  登录注册  =============================================*/


    /**
     * 登录
     */
    public static final String LOGIN = BASE + "/login.shtml";

    /**
     * 搜索托养人员
     */
    public static final String SEARCH_CARETAKER = BASE + "/u/appConnector/selectCaregiversList.shtml";

    /**
     * 搜索所有的残疾人
     */
    public static final String SEARCH_ALL_DISABLED_PEOPLE = BASE + "/u/appConnector/selectDisabledList.shtml";
    /**
     * 托养信息
     */
    public static final String CARE_INFO = BASE + "/u/appConnector/selectCaregiversById.shtml";
    /**
     * 托养信息
     */
    public static final String CARE_RECORD = BASE + "/u/appConnector/selectServiceInfoById.shtml";
    /**
     * 托养信息  更多
     */
    public static final String CARE_INFO_MORE = BASE + "/u/appConnector/selectCaregiversMoreById.shtml";
    /**
     * 托养人基本信息
     */
    public static final String CARE_TAKER_BASE_INFO = BASE + "/u/appConnector/selectDisabledInfoByIdNo.shtml";


    /**
     * 添加托养人
     */
    public static final String ADD_CARE_TAKER = BASE + "/u/appConnector/insertCaregivers.shtml";
    /**
     * 修改托养人
     */
    public static final String MODIFY_CARE_TAKER = BASE + "/u/appConnector/insertCaregiversUpdate.shtml";
    /**
     * 按街道分类服务人员(选择服务人员)接口
     */
    public static final String GET_SERVICE_PEOPLE = BASE + "/u/appConnector/selectStreetServicerList.shtml";
    /**
     * 提交托养记录
     */
    public static final String COMMIT_CARE_RECORD = BASE + "/u/appConnector/insertService.shtml";
    /**
     * 获取服务类型
     */
    public static final String GET_SERVICE_TYPE = BASE + "/u/appConnector/getServiceCate.shtml";

    /**
     * 服务记录
     */
    public static final String SERVICE_RECORD = BASE + "/u/appConnector/getMyCaregiversList.shtml";
    /**
     * 上传位置信息
     */
    public static final String UPLOAD_LOCATION = BASE + "/u/appConnector/insertUserHistory.shtml";


    /**
     * 托养记录分布
     */
    public static final String CARE_RECORD_POSITIONS = BASE + "/u/appConnector/selectCaregiversListWhere.shtml";


    /**
     * 服务人员
     */
    public static final String SERVICE_PEOPLES_POSITIONS = BASE + "/u/appConnector/selectServicerList.shtml";
    /**
     * 康复机构
     */
    public static final String HEATH_ORGANIZE_POSITIONS = BASE + "/u/appConnector/selectKeyunitList.shtml";
    /**
     * 康复机构详情
     */
    public static final String HEATH_ORGANIZE_DETAIL = BASE + "/u/appConnector/selectKeyunitById.shtml";




    /*====================================================
    我的=============================================================*/


    /**
     * 退出登录
     */
    public static final String LOG_OUT = BASE + "/logout.shtml";

    /**
     * 个人基本信息
     */
    public static final String USER_INFO = BASE + "/getUserInfo.shtml";


    /**
     * 检查更新
     */
    public static final String APP_UPDATE = BASE + "/getAppVersions.shtml";
    /**
     * 修改用户密码
     */
    public static final String MODIFY_PWD = BASE + "/updatePassword.shtml";
    /**
     * 修改用户头像
     */
    public static final String MODIFY_HEAD_ICON = BASE + "/updateHeadImg.shtml";
    /**
     * 我的消息
     */
    public static final String MY_NOTICE = BASE + "/u/appConnector/getMsgList.shtml";
    /**
     * 全部已读
     */
    public static final String IS_READ = BASE + "/u/appConnector/isReaded.shtml";
    /**
     * 未读数据
     */
    public static final String UNREAD_MSG = BASE + "/u/appConnector/getUnReadMsgCount.shtml";

    /**
     * 获取托养子列表/u/infoAppCase.shtml
     */
    public static final String OLD_CASE_INFO = BASE + "/u/appConnector/selectCaregiversInfoOld.shtml";







    /*==============================================  个人中心  =============================================*/


    /**
     * 我的分享
     */
    public static final String MY_SHARE = BASE + "/getUserShare.shtml";
    /**
     * 删除分享
     */
    public static final String DEL_SHARE = BASE + "/deleteUserShare.shtml";






    /*==============================================  分享  =============================================*/

    /**
     * 权限列表
     */
    public static final String VEDIO_PERMISSION_LIST = BASE + "/ getVideoSharePower.shtml";
    /**
     * 被分享的好友
     */
    public static final String SHARED_USERS = BASE + "/ getVideoShare.shtml";
}
