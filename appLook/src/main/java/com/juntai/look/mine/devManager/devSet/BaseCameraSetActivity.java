package com.juntai.look.mine.devManager.devSet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.camera.PlayContract;
import com.juntai.look.homePage.mydevice.ModifyNameOrPwdActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.look.mine.devManager.devSet.cameraType.DevTypeEditActivity;
import com.juntai.look.mine.devManager.shareToAccount.ShareToAccountActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.juntai.wisdom.bdmap.act.LocateSelectionActivity;

/**
 * @Author: tobato
 * @Description: 作用描述   摄像头设置的基类
 * @CreateDate: 2020/9/14 11:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/14 11:35
 */
public abstract class BaseCameraSetActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView
        , View.OnClickListener {

    /**
     * 29374237492374973449
     */
    private TextView mCameraNoTv;
    /**
     * 肯德基法兰
     */
    private TextView mCameraNameTv;
    /**
     * 球技
     */
    private TextView mCameraTypeTv;
    /**
     * fdasdfsadfsad
     */
    private TextView mCameraAddrTv;
    /**
     * 球防守打法技
     */
    private TextView mCameraGroupTv;
    /**
     * 分享到微信
     */
    private TextView mCameraShareWxTv;
    /**
     * 分享给好友账号
     */
    private TextView mCameraShareUserTv;
    /**
     * 全球直播
     */
    private TextView mShareWorldTv;
    /**
     * 本地全时段录像
     */
    private TextView mCameraRecordTv;
    /**
     * 删除设备
     */
    private TextView mDeleteDevTv;
    private LinearLayout mPosLl;
    private LinearLayout mGroupLl;
    public static String DEV_INFO_ID = "devinfoId";//设备信息
    public static String DEV_INFO = "devinfo";//设备信息
    private int devId;
    private StreamCameraDetailBean.DataBean mStreamCameraBean;

    protected abstract boolean isCameraOfNvr();

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_camera_set;
    }

    @Override
    public void initView() {
        setTitleName("设置");
        mCameraNoTv = (TextView) findViewById(R.id.camera_no_tv);
        mCameraNameTv = (TextView) findViewById(R.id.camera_name_tv);
        mCameraTypeTv = (TextView) findViewById(R.id.camera_type_tv);
        mCameraAddrTv = (TextView) findViewById(R.id.camera_addr_tv);
        mCameraGroupTv = (TextView) findViewById(R.id.camera_group_tv);
        mCameraShareWxTv = (TextView) findViewById(R.id.camera_share_wx_tv);
        mCameraShareWxTv.setOnClickListener(this);
        mCameraShareUserTv = (TextView) findViewById(R.id.camera_share_user_tv);
        mCameraShareUserTv.setOnClickListener(this);
        mShareWorldTv = (TextView) findViewById(R.id.share_world_tv);
        mShareWorldTv.setOnClickListener(this);
        mCameraRecordTv = (TextView) findViewById(R.id.camera_record_tv);
        mCameraRecordTv.setOnClickListener(this);
        mDeleteDevTv = (TextView) findViewById(R.id.delete_dev_tv);
        mDeleteDevTv.setOnClickListener(this);
        mCameraNameTv.setOnClickListener(this);
        mCameraTypeTv.setOnClickListener(this);
        mCameraAddrTv.setOnClickListener(this);
        mCameraGroupTv.setOnClickListener(this);

        mPosLl = (LinearLayout) findViewById(R.id.pos_ll);
        mGroupLl = (LinearLayout) findViewById(R.id.group_ll);
        if (isCameraOfNvr()) {
            mPosLl.setVisibility(View.GONE);
            mGroupLl.setVisibility(View.GONE);
        } else {
            mPosLl.setVisibility(View.VISIBLE);
            mGroupLl.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            devId = getIntent().getIntExtra(DEV_INFO_ID, 0);
            mPresenter.getStreamCameraDetail(getBaseBuilder().add("id", String.valueOf(devId)).build(),
                    PlayContract.GET_STREAM_CAMERA_DETAIL);
        }

    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.DEL_DEV:
                ToastUtils.toast(mContext, "删除成功");
                break;
            case PlayContract.GET_STREAM_CAMERA_DETAIL:
                StreamCameraDetailBean detailBean = (StreamCameraDetailBean) o;
                if (detailBean != null) {
                    mStreamCameraBean = detailBean.getData();
                    mCameraNoTv.setText(mStreamCameraBean.getNumber());
                    mCameraNameTv.setText(mStreamCameraBean.getName());
                    mCameraTypeTv.setText(mStreamCameraBean.getTypeName());
                    mCameraAddrTv.setText(mStreamCameraBean.getAddress());
                    mCameraGroupTv.setText(mStreamCameraBean.getGroupName());

                }
                break;
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.camera_share_wx_tv:
                break;
            case R.id.camera_share_user_tv:
                //分享到账号
                startActivity(new Intent(mContext, ShareToAccountActivity.class));

                break;
            case R.id.share_world_tv:
                break;
            case R.id.camera_record_tv:
                //录像设置
                startActivity(new Intent(mContext, VideoSetActivity.class));
                break;
            case R.id.delete_dev_tv:
                //删除设备
                new AlertDialog.Builder(mContext)
                        .setMessage("删除后无法恢复,确定删除设备吗?")
                        .setCancelable(false)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //删除设备
                        if (mStreamCameraBean != null) {
                            mPresenter.deleteDev(getBaseBuilder().add("number",
                                    String.valueOf(mStreamCameraBean.getNumber())).build(), MyDeviceContract.DEL_DEV);
                        }

                    }
                }).show();
                break;
            case R.id.camera_name_tv:
                //摄像头名称
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, ModifyNameOrPwdActivity.class).putExtra(ModifyNameOrPwdActivity.CONTENT,mStreamCameraBean.getName())
                            .putExtra(ModifyNameOrPwdActivity.TYPE,1)
                            .putExtra(SelectGroupActivity.CAMERA_ID, mStreamCameraBean.getId()), BASE_REQUESR);
                }
                break;
            case R.id.camera_type_tv:
                //摄像头类型
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, DevTypeEditActivity.class).putExtra(DEV_INFO,
                            mStreamCameraBean), BASE_REQUESR);
                }

                break;
            case R.id.camera_addr_tv:
                startActivity(new Intent(mContext, LocateSelectionActivity.class));
                break;
            case R.id.camera_group_tv:
                //设备分组
                if (mStreamCameraBean != null) {
                    startActivityForResult(new Intent(mContext, SelectGroupActivity.class).putExtra(SelectGroupActivity.CAMERA_ID,
                            mStreamCameraBean.getId()).putExtra(SelectGroupActivity.GROUP_ID,
                            mStreamCameraBean.getGroupId()),
                            BASE_REQUESR);
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (BASE_REQUESR == requestCode) {
            initData();
        }
    }
}