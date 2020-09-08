package com.juntai.look.homePage.camera.ijkplayer;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.utils.MediaUtils;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.camera.PlayPresent;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

/**
 * @aouther tobato  流摄像头 全屏播放
 * @description 描述
 * @date 2020/6/1 16:49
 */

public class StreamCameraFullScreenActivity extends BaseMvpActivity<PlayPresent> implements PlayContract.IPlayView,
        View.OnClickListener {
    private PlayerView player;
    //    private String url = "rtmp://juntaikeji.net:1935/video/37130201561327011011";
    private PowerManager.WakeLock wakeLock;
    public static String STREAM_CAMERA_URL = "stream_num_rul";
    public static String STREAM_CAMERA_TITLE = "stream_num_rul_title";
    private String url, mCameraNum;
    private String mThumIv;
    private DrawerLayout mDrawerlayout;
    private ImageView mControlUpIv;
    private ImageView mControlLeftIv;
    private ImageView mControlDownIv;
    private ImageView mControlRightIv;
    private TextView mControlStopTv;
    private ImageView mZoomOutIv;
    private ImageView mZoomInIv;
    private ImageView mCollectIv;
    private ImageView mCutPicIv;
    private ImageView mRecordIv;
    private LinearLayout mFullScreenRightControlCl;
    private ImageView mTopSetIv;
    private ImageView mTopYuntaiIv;
    private ImageView mTopVideoCaptureIv;
    private ImageView mTopVideoRecordIv;
    private LinearLayout mLineView;

    @Override
    protected PlayPresent createPresenter() {
        return new PlayPresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.simple_player_view_player_full;
    }

    @Override
    public void initView() {
        url = getIntent().getStringExtra(STREAM_CAMERA_URL);
        mDrawerlayout = findViewById(R.id.drawerlayout);
        mDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mThumIv = getIntent().getStringExtra(PlayerLiveActivity.STREAM_CAMERA_THUM_URL);
        mCameraNum = getIntent().getStringExtra(PlayerLiveActivity.STREAM_CAMERA_NUM);
        //        setTitleName(getIntent().getStringExtra(STREAM_CAMERA_TITLE));
        getToolbar().setVisibility(View.GONE);
        mControlUpIv = (ImageView) findViewById(R.id.control_up_iv);
        mControlUpIv.setOnClickListener(this);
        mControlLeftIv = (ImageView) findViewById(R.id.control_left_iv);
        mControlLeftIv.setOnClickListener(this);
        mControlDownIv = (ImageView) findViewById(R.id.control_down_iv);
        mControlDownIv.setOnClickListener(this);
        mControlRightIv = (ImageView) findViewById(R.id.control_right_iv);
        mControlRightIv.setOnClickListener(this);
        mControlStopTv = (TextView) findViewById(R.id.control_stop_tv);
        mControlStopTv.setOnClickListener(this);
        mZoomOutIv = (ImageView) findViewById(R.id.zoom_out_iv);
        mZoomOutIv.setOnClickListener(this);
        mZoomInIv = (ImageView) findViewById(R.id.zoom_in_iv);
        mZoomInIv.setOnClickListener(this);
        mCollectIv = (ImageView) findViewById(R.id.collect_iv);
        mCollectIv.setOnClickListener(this);
        mCutPicIv = (ImageView) findViewById(R.id.cut_pic_iv);
        mCutPicIv.setOnClickListener(this);
        mRecordIv = (ImageView) findViewById(R.id.record_iv);
        mRecordIv.setOnClickListener(this);
        mFullScreenRightControlCl = (LinearLayout) findViewById(R.id.full_screen_right_control_cl);
        mTopSetIv = (ImageView) findViewById(R.id.top_set_iv);
        mTopSetIv.setOnClickListener(this);
        mTopYuntaiIv = (ImageView) findViewById(R.id.top_yuntai_iv);
        mTopYuntaiIv.setOnClickListener(this);
        mTopVideoCaptureIv = (ImageView) findViewById(R.id.top_video_capture_iv);
        mTopVideoCaptureIv.setOnClickListener(this);
        mTopVideoRecordIv = (ImageView) findViewById(R.id.top_video_record_iv);
        mTopVideoRecordIv.setOnClickListener(this);
        mLineView = (LinearLayout) findViewById(R.id.line_view);
        mLineView.postDelayed(new Runnable() {
            @Override
            public void run() {
                player.setFatherW_H(mLineView.getTop(), mLineView.getBottom());
            }
        }, 100);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //去除这个Activity的标题栏
        super.onCreate(savedInstanceState);
        /**常亮*/
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "liveTAG");
        wakeLock.acquire();

        player = new PlayerView(this, mBaseRootCol)
                //分辨率
                .hideSteam(true)
                //旋转
                .hideRotation(true)
                //底部功能键
                .hideControlPanl(false)
                .setOnlyFullScreen(true)
                .setScaleType(PlayStateParams.wrapcontent).showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        ImageLoadUtil.loadImageNoCrash(mContext.getApplicationContext(),
                                mThumIv, ivThumbnail);
                    }
                });
        if (!TextUtils.isEmpty(url)) {
            player.setPlaySource(url).startPlay();
        }
        player.hideHideTopBar(false)
                .forbidTouch(false)
                .setForbidHideControlPanl(false)
        ;
        player.getFullScreenView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onSuccess(String tag, Object o) {

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
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.control_up_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_UP,PlayContract.OPERATE_YUNTAI_SPEED,
                      mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_left_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_LEFT,PlayContract.OPERATE_YUNTAI_SPEED,
                       mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_down_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_DOWN,PlayContract.OPERATE_YUNTAI_SPEED,
                       mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_right_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_RIGHT,PlayContract.OPERATE_YUNTAI_SPEED,
                       mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.control_stop_tv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_STOP,PlayContract.OPERATE_YUNTAI_SPEED,
                       mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.zoom_out_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_ZOOM_OUT,PlayContract.OPERATE_YUNTAI_SPEED,
                       mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.zoom_in_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_ZOOM_IN,PlayContract.OPERATE_YUNTAI_SPEED,
                       mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.collect_iv:
                mPresenter.operateYunTai(PlayContract.OPERATE_YUNTAI_SAVE_POS,PlayContract.OPERATE_YUNTAI_SPEED,
                       mCameraNum,PlayContract.OPERATE_YUNTAI);
                break;
            case R.id.cut_pic_iv:
                break;
            case R.id.record_iv:
                break;
            case R.id.top_set_iv:
                break;
            case R.id.top_yuntai_iv:
                mDrawerlayout.openDrawer(mFullScreenRightControlCl);
                break;
            case R.id.top_video_capture_iv:
                break;
            case R.id.top_video_record_iv:
                break;
        }
    }
}
