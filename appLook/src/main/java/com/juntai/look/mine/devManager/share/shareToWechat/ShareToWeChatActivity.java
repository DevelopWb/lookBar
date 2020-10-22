package com.juntai.look.mine.devManager.share.shareToWechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.bean.stream.StreamCameraDetailBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.mydevice.ModifyNameOrPwdActivity;
import com.juntai.look.homePage.mydevice.MyDeviceContract;
import com.juntai.look.homePage.mydevice.MyDevicePresent;
import com.juntai.look.homePage.mydevice.allGroup.selectGroup.SelectGroupActivity;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
import com.juntai.wisdom.basecomponent.utils.ToastUtils;
import com.orhanobut.hawk.Hawk;

/**
 * @aouther tobato
 * @description 描述  分享至微信
 * @date 2020/10/17 16:28
 */
public class ShareToWeChatActivity extends BaseAppActivity<MyDevicePresent> implements MyDeviceContract.IMyDeviceView
        , View.OnClickListener {

    private ImageView mSharePicIv;
    /**
     * 肯德基法兰
     */
    private TextView mShareTimeValueTv;
    private Switch mVisitPwdSv;

    @Override
    protected MyDevicePresent createPresenter() {
        return new MyDevicePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.activity_share_to_we_chat;
    }

    @Override
    public void initView() {
        setTitleName("分享至微信");
        getTitleRightTv().setText("下一步");
        getTitleRightTv().setOnClickListener(this);
        mSharePicIv = (ImageView) findViewById(R.id.share_pic_iv);
        mShareTimeValueTv = (TextView) findViewById(R.id.share_time_value_tv);
        mVisitPwdSv = (Switch) findViewById(R.id.visit_pwd_sv);
        mShareTimeValueTv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        StreamCameraDetailBean.DataBean mStreamCameraBean = Hawk.get(HawkProperty.CURRENT_CAMERA_SET);
        if (mStreamCameraBean != null) {
            ImageLoadUtil.loadImageCache(mContext,
                    UrlFormatUtil.formatStreamCapturePicUrl(mStreamCameraBean.getEzopen()),mSharePicIv);
        }
    }


    @Override
    public void onSuccess(String tag, Object o) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.share_time_value_tv:
                startActivityForResult(new Intent(mContext, SetShareTimeActivity.class),BASE_REQUESR);

                break;
            case R.id.title_rightTv:
                //下一步
                ToastUtils.toast(mContext,"暂未开放");
//                if (!StringTools.isStringValueOk(getTextViewValue(mShareTimeValueTv))) {
//                    ToastUtils.toast(mContext,"请选择分享时间段");
//                    return;
//                }
//                if (mVisitPwdSv.isChecked()) {
//                    startActivityForResult(new Intent(mContext, ModifyNameOrPwdActivity.class).putExtra(ModifyNameOrPwdActivity.TYPE, 2), BASE_REQUESR);
//                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode==BASE_RESULT) {
            if (data != null) {
                int type = data.getIntExtra(SetShareTimeActivity.TIME_TYPE,0);
                if (0==type) {
                    mShareTimeValueTv.setText("全时段");
                }else {
                String startTime = data.getStringExtra(SetShareTimeActivity.START_TIME);
                String endTime = data.getStringExtra(SetShareTimeActivity.END_TIME);
                mShareTimeValueTv.setText(String.format("%s%s%s",startTime,getString(R.string.to),endTime));
                }
            }
        }
    }
}
