package com.juntai.look.homePage.mydevice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.exoplayer2.C;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;

/**
 * @aouther tobato
 * @description 描述 修改名称或者密码 (0分组的名称 或者1摄像头的名称,2是配置密码)
 * @date 2020/9/13 14:59
 */
public class ModifyNameOrPwdActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView,
        View.OnClickListener {

    private int cameraId;
    /**
     * 摄像头名称
     */
    private EditText mNameTv;
    private ImageView mClearContentIv;
    /**
     * 摄像头名称
     */
    private EditText mNameEt;

    public static String TYPE = "modifytype";//0分组的名称 或者1摄像头的名称//2是设置密码
    public static String CONTENT = "content";//修改的内容
    private int type;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_modify_name;
    }

    @Override
    public void initView() {

        getTitleRightTv().setOnClickListener(this);
        mNameEt = (EditText) findViewById(R.id.name_et);
        mClearContentIv = (ImageView) findViewById(R.id.clear_content_iv);
        mClearContentIv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        if (getIntent() != null) {
            type = getIntent().getIntExtra(TYPE, 0);
            if (1 == type || 0 == type) {
                //修改摄像头或者分组名称
                setTitleName("修改名称");
                getTitleRightTv().setText("完成");
                mNameEt.setHint("请输入摄像头名称");
                cameraId = getIntent().getIntExtra(SelectGroupActivity.CAMERA_ID, 0);
                mNameEt.setText(getIntent().getStringExtra(CONTENT));
            } else {
                setTitleName("设置密码");
                getTitleRightTv().setText("分享");
                mNameEt.setHint("请输入6~12位密码");
            }
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case MyDeviceContract.SAVE_CONFIG:
                ToastUtils.toast(mContext, "保存成功");
                finish();
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
            case R.id.clear_content_iv:
                mNameEt.setText("");
                break;
            case R.id.title_rightTv:
                //完成

                switch (type) {
                    case 0:
                        //修改分组名称
                        //修改分组名称
                        mPresenter.updateGroupName(getBaseBuilder().add("id", String.valueOf(cameraId)).add(
                                "name", getTextViewValue(mNameEt)).build(),
                                MyDeviceContract.SAVE_CONFIG);
                        break;
                    case 1:
                        mPresenter.saveCameraConfig(getBaseBuilder().add("id", String.valueOf(cameraId)).add(
                                "name", getTextViewValue(mNameEt)).build(),
                                MyDeviceContract.SAVE_CONFIG);
                        break;
                    case 2:
                        //修改分享密码后分享

                        break;
                    default:
                        break;
                }

                break;
        }
    }
}
