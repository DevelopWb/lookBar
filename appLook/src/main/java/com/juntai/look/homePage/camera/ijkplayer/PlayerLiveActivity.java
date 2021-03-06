package com.juntai.look.homePage.camera.ijkplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.utils.MediaUtils;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.juntai.look.AppHttpPath;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.CameraCommentFragment;
import com.juntai.look.homePage.camera.CameraVideoRecordFragment;
import com.juntai.look.homePage.camera.yunkong.CameraYunControlFragment;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.camera.PlayPresent;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.base.BaseDownLoadActivity;
import com.juntai.wisdom.basecomponent.bean.OpenLiveBean;
import com.juntai.wisdom.basecomponent.utils.FileCacheUtils;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @aouther tobato
 * @description 描述   播放视频流
 * @date 2020/7/25 16:44
 */
public class PlayerLiveActivity extends BaseDownLoadActivity<PlayPresent> implements PlayContract.IPlayView,
        View.OnClickListener, BaseDownLoadActivity.OnFileDownloaded {

    private PlayerView player;
    //    private String url = "rtmp://juntaikeji.net:1935/video/37130201561327011011";
    private PowerManager.WakeLock wakeLock;
    private Intent intent;
    public static String STREAM_CAMERA_ID = "stream";
    public static String STREAM_CAMERA_NUM = "stream_num";
    public static String STREAM_CAMERA_URL = "stream_url";
    public static String STREAM_CAMERA_THUM_URL = "stream_thum_url";//缩略图路径
    public static String STREAM_CAMERA_SESSION_ID = "sessionid";
    private int mCameraId;//
    public String mCameraNum;//
    private StreamCameraDetailBean.DataBean mStreamCameraBean;//详情
    private String playUrl;
    private CameraCommentFragment cameraCommentFragment;
    private CameraYunControlFragment cameraYunControlFragment;
    private CameraVideoRecordFragment videoRecordFragment;
    private String COMMENT = "COMMENT";//评价
    private String YUN_CONTROL = "YUN_CONTROL";//云控制
    private String VIDEO_RECORD = "VIDEO_RECORD";
    private ImageView mVideoIv;
    private ImageView mYuntaiIv;
    private ImageView mCalendarIv;
    private String mThumUrl;
    private boolean isPlay = false;
    private String videoStrsessionid;

    @Override
    protected PlayPresent createPresenter() {
        return new PlayPresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.simple_player_view_player;
    }

    @Override
    public void initView() {
        intent = new Intent(this, KeepAliveService.class);
        setFileDownLoadCallBack(this);
        setTitleName("摄像头");
        mCameraId = getIntent().getIntExtra(STREAM_CAMERA_ID, 0);
        mCameraNum = getIntent().getStringExtra(STREAM_CAMERA_NUM);
        mThumUrl = getIntent().getStringExtra(STREAM_CAMERA_THUM_URL);
        mVideoIv = (ImageView) findViewById(R.id.video_iv);
        mVideoIv.setOnClickListener(this);
        mYuntaiIv = (ImageView) findViewById(R.id.yuntai_iv);
        mYuntaiIv.setOnClickListener(this);
        mCalendarIv = (ImageView) findViewById(R.id.calendar_iv);
        mCalendarIv.setOnClickListener(this);
    }


    @Override
    public void initData() {
        initControlBtStatus(0);
        //获取摄像头信息
        mPresenter.getStreamCameraDetail(mPresenter.getPublishMultipartBody()
                        .addFormDataPart("id", String.valueOf(mCameraId)).build(),
                PlayContract.GET_STREAM_CAMERA_DETAIL);
    }

    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //去除这个Activity的标题栏
        super.onCreate(savedInstanceState);

        /**常亮*/
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "liveTAG");
        wakeLock.acquire();

        player = new PlayerView(this, mBaseRootCol)
                //隐藏顶部布局
                .hideHideTopBar(false)
                //分辨率
                .hideSteam(true)
                //旋转
                .hideRotation(true)
                //隐藏全屏按钮，true隐藏，false为显示
                .hideFullscreen(false)
                .hideCenterPlayer(false)
                .forbidTouch(false)
                .setForbidDoulbeUp(true)
                .setScaleType(PlayStateParams.fitxy).showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        ImageLoadUtil.loadImageNoCrash(mContext.getApplicationContext(),
                                mThumUrl, ivThumbnail);
                    }
                });
        player.getFullScreenView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(playUrl)) {
                    startActivity(new Intent(mContext, StreamCameraFullScreenActivity.class)
                            .putExtra(StreamCameraFullScreenActivity.STREAM_CAMERA_TITLE,
                                    mStreamCameraBean.getPlace() + "(" + mStreamCameraBean.getRemark() + ")")
                            .putExtra(StreamCameraFullScreenActivity.STREAM_CAMERA_URL, playUrl)
                            .putExtra(PlayerLiveActivity.STREAM_CAMERA_THUM_URL, mThumUrl)
                            .putExtra(STREAM_CAMERA_NUM, mCameraNum));
                } else {
                    ToastUtils.toast(mContext, "无法获取流地址");
                }
            }
        });

        player.getCapturePicView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //截屏
                mPresenter.capturePic(mCameraNum, "1", PlayContract.GET_STREAM_CAMERA_CAPTURE);
            }
        });
        playUrl = getIntent().getStringExtra(STREAM_CAMERA_URL);
        String strsessionid = getIntent().getStringExtra(STREAM_CAMERA_SESSION_ID);
        //保存摄像头直播时的
        Hawk.put(HawkProperty.LIVE_PlAY_URL, playUrl);
        Hawk.put(HawkProperty.LIVE_CAMERA_SESSION_ID, strsessionid);
        if (playUrl != null && !TextUtils.isEmpty(playUrl)) {
            player.setPlaySource(playUrl).startPlay();
            //调用截图的接口  然后 上传封面图
            mPresenter.capturePic(mCameraNum, "1", PlayContract.GET_STREAM_CAMERA_THUMBNAIL);
            intent.putExtra("sessionId", strsessionid);
            startService(intent);
        } else {
            //打开流数据
            mPresenter.openStream(mCameraNum, "1", "rtmp", PlayContract.GET_URL_PATH);
        }
    }

    @Override
    protected String getTitleRightName() {
        return null;
    }

    @Override
    protected String getDownLoadPath() {
        return null;
    }

    @Override
    public void onError(String tag, Object o) {
        super.onError(tag, o);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_iv:
//                isPlay = !isPlay;
//                if (isPlay) {
//                    //录像
//                    mPresenter.operateRecordVideo(videoStrsessionid, "pause", "0", PlayContract.OPERATE_RECORD_VIDEO);
//                } else {
//                    //录像
//                    mPresenter.operateRecordVideo(videoStrsessionid, "play", "1", PlayContract.OPERATE_RECORD_VIDEO);
//                }


                break;
            case R.id.yuntai_iv:
                //云控
                initControlBtStatus(1);
                break;
            case R.id.calendar_iv:
                //查看录像记录
                initControlBtStatus(2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
        MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
        MediaUtils.muteAudioFocus(mContext, false);
        if (wakeLock != null) {
            wakeLock.acquire();
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (wakeLock != null) {
            wakeLock.release();
        }
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();

    }

    @Override
    public void onSuccess(String tag, Object o) {


        switch (tag) {
            case PlayContract.GET_URL_PATH:
                OpenLiveBean openLiveBean = (OpenLiveBean) o;
                int errorCode = openLiveBean.getErrcode();
                if (errorCode < 0) {
                    //                    tvstate.append("离线");
                    ToastUtils.toast(mContext, "设备离线，无数据");
                    return;
                } else {
                    //                    tvstate.append("在线");
                    //调用截图的接口  然后 上传封面图
                    mPresenter.capturePic(mCameraNum, "1", PlayContract.GET_STREAM_CAMERA_THUMBNAIL);
                }
                playUrl = openLiveBean.getVideourl();
                if (StringTools.isStringValueOk(playUrl)) {
                    if (playUrl.contains("//")) {
                        playUrl = playUrl.substring(playUrl.indexOf("//") + 2);
                        playUrl = playUrl.substring(playUrl.indexOf("/"));
                        playUrl = AppHttpPath.BASE_CAMERA_DNS + playUrl;
                    }
                }
                player.setPlaySource(playUrl).startPlay();
                intent.putExtra("sessionId", openLiveBean.getStrsessionid());
                startService(intent);
                break;
            case PlayContract.GET_STREAM_CAMERA_THUMBNAIL:
                //截图  每次打开 更新缩略图
                OpenLiveBean captureBean = (OpenLiveBean) o;
                int errCode = captureBean.getErrcode();
                if (errCode < 0) {
                    //截图失败
                } else {
                    //截图成功 上传封面图（将图片路径上传后台）  http://60.213.43.241:8080/image/37131201561327001001.jpg
                    String imagePath = captureBean.getImageurl();
                    if (!TextUtils.isEmpty(imagePath)) {
                        if (imagePath.contains("image")) {
                            //截图成功 保存本地
                            downloadFileContentUnique(FileCacheUtils.STREAM_THUMBNAIL, imagePath);
                        }
                    }
                }
                break;
            case PlayContract.GET_STREAM_CAMERA_CAPTURE:
                //截图并保存本地
                OpenLiveBean captureBeanToLocal = (OpenLiveBean) o;
                int errMsg = captureBeanToLocal.getErrcode();
                if (errMsg < 0) {
                    //截图失败
                    ToastUtils.toast(mContext, "截图失败");
                } else {
                    //截图成功 保存本地
                    String imagePath = captureBeanToLocal.getImageurl();
                    if (!TextUtils.isEmpty(imagePath)) {
                        downloadFileContent(FileCacheUtils.STREAM_CAPTURE + mStreamCameraBean.getPlace() + "(" + mStreamCameraBean.getRemark() + ")", imagePath);
                    }
                }
                break;
            case PlayContract.GET_VIDEO_RTMP_URL:
                //获取录像的流地址
                OpenLiveBean videoLiveBean = (OpenLiveBean) o;
                if (videoLiveBean != null) {
                    if (0 == videoLiveBean.getErrcode()) {
                        //有录像
                        playUrl = videoLiveBean.getVideourl();
                        player.setPlaySource(playUrl).startPlay();
                        videoStrsessionid = videoLiveBean.getStrsessionid();
                        intent.putExtra("sessionId", videoStrsessionid);
                        startService(intent);
                    }
                }
                break;
            case PlayContract.UPLOAD_CAMERA_CAPTURE:
                //上传封面图
                break;
            case PlayContract.GET_STREAM_CAMERA_DETAIL:
                StreamCameraDetailBean detailBean = (StreamCameraDetailBean) o;
                if (detailBean != null) {
                    mStreamCameraBean = detailBean.getData();
                    //                    tvplace.append(mStreamCameraBean.getPlace() + "(" + mStreamCameraBean
                    //                    .getRemark() + ")");

                }
                break;
            case PlayContract.OPERATE_RECORD_VIDEO:
                player.isLive =false;
                player.onPlayPause();

                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
        if (intent != null) {
            stopService(intent);
        }
        setFileDownLoadCallBack(null);
    }

    @Override
    public void onFileDownloaded(String filePath) {
        if (!filePath.contains(FileCacheUtils.STREAM_CAPTURE)) {
            String fileName = filePath.substring(filePath.lastIndexOf(
                    "/") + 1, filePath.lastIndexOf("."));
            //压缩图片作为缩略图
            compressImage(filePath, FileCacheUtils.STREAM_THUMBNAIL, fileName, new OnImageCompressedPath() {
                @Override
                public void compressedImagePath(File file) {
                    if (mPresenter == null) {
                        return;
                    }
                    MultipartBody.Builder builder = mPresenter.getPublishMultipartBody()
                            .addFormDataPart("id", String.valueOf(mCameraId))
                            .addFormDataPart("number", String.valueOf(mCameraNum))
                            .addFormDataPart("file", fileName, RequestBody.create(MediaType.parse("file"), file));
                    mPresenter.uploadStreamCameraThumbPic(builder.build(), PlayContract.UPLOAD_CAMERA_CAPTURE);
                }
            });
        }

    }


    /**
     * 初始化控件的状态
     *
     * @param i
     */
    public void initControlBtStatus(int i) {
        mYuntaiIv.setImageResource(R.mipmap.playview_icon_yuntai_nor);
        mCalendarIv.setImageResource(R.mipmap.playview_calendar_video_normal);
        switch (i) {
            case 0:
                initFragmentSelected(0);
                break;
            case 1:
                initFragmentSelected(1);
                mYuntaiIv.setImageResource(R.mipmap.playview_icon_yuntai_pre);
                break;
            case 2:
                initFragmentSelected(2);
                mCalendarIv.setImageResource(R.mipmap.playview_calendar_video_press);
                break;
            case 3:
                initFragmentSelected(0);
                //回到直播
                player.setPlaySource((String) Hawk.get(HawkProperty.LIVE_PlAY_URL)).startPlay();
                intent.putExtra("sessionId", (String) Hawk.get(HawkProperty.LIVE_CAMERA_SESSION_ID));
                startService(intent);
                break;
            default:
                break;
        }
    }

    /**
     * 获取各个fragment对象
     */
    private void initFragments() {
        if (cameraCommentFragment == null) {
            cameraCommentFragment = new CameraCommentFragment();
        }
        if (cameraYunControlFragment == null) {
            cameraYunControlFragment = new CameraYunControlFragment();
        }
        if (videoRecordFragment == null) {
            videoRecordFragment = new CameraVideoRecordFragment();
        }
    }

    /**
     * 初始化fragment
     *
     * @param i
     */
    private void initFragmentSelected(int i) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hindFragments(fragmentTransaction);
        initFragments();
        switch (i) {
            case 0:
                if (!cameraCommentFragment.isAdded()) {
                    fragmentTransaction.add(R.id.camera_fl, cameraCommentFragment, COMMENT);
                }
                fragmentTransaction.show(cameraCommentFragment);
                break;
            case 1:
                if (!cameraYunControlFragment.isAdded()) {
                    fragmentTransaction.add(R.id.camera_fl, cameraYunControlFragment, YUN_CONTROL);
                }
                fragmentTransaction.show(cameraYunControlFragment);
                break;
            case 2:
                if (!videoRecordFragment.isAdded()) {
                    fragmentTransaction.add(R.id.camera_fl, videoRecordFragment, VIDEO_RECORD);
                }
                fragmentTransaction.show(videoRecordFragment);
                break;
            default:
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏所有的fragment
     *
     * @param fragmentTransaction
     */
    private void hindFragments(FragmentTransaction fragmentTransaction) {

        if (cameraCommentFragment != null) {
            fragmentTransaction.hide(cameraCommentFragment);
        }
        if (cameraYunControlFragment != null) {
            fragmentTransaction.hide(cameraYunControlFragment);
        }
        if (videoRecordFragment != null) {
            fragmentTransaction.hide(videoRecordFragment);
        }
    }

    /**
     * //获取录像的流地址
     *
     * @param begintime
     * @param endtime
     */
    public void getVideoRtmpUrl(String begintime, String endtime) {
        Map<String, String> map = new ArrayMap<>();
        map.put("channelid", mCameraNum);
        map.put("begintime", begintime);
        map.put("endtime", endtime);
        map.put("transport", "udp");
        map.put("videourltype", "rtmp");
        mPresenter.playHisVideo(map, PlayContract.GET_VIDEO_RTMP_URL);
    }

}
