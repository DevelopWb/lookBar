package com.juntai.look.homePage.careTaker.careInfo;

import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.careTaker.CareTakerInfoBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  托养记录
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class CareTakerRecordAdapter extends BaseQuickAdapter<CareTakerInfoBean.DataBean.ServiceListVosBean,
        BaseViewHolder> {
    public CareTakerRecordAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, CareTakerInfoBean.DataBean.ServiceListVosBean item) {
        String title = String.format("%s%s", "服务人员：", item.getServicer());
        helper.setText(R.id.dev_no_tv, title);
        String endTime = item.getEndTime();
        if (endTime.length()>6) {
            endTime = endTime.substring(endTime.length()-5,endTime.length());
        }
        helper.setText(R.id.care_content_tv, String.format("%s%s%s", item.getStartTime(), " 至 ",endTime ));
        helper.setBackgroundRes(R.id.dev_tag_tv,0);
        helper.setTextColor(R.id.dev_tag_tv,ContextCompat.getColor(mContext,R.color.text_default_color));
        helper.getView(R.id.dev_tag_tv).setPadding(0,0,0,0);
        helper.setText(R.id.dev_tag_tv, String.format("%s%s", "时长：", item.getServiceLength()));
        List<CareTakerInfoBean.DataBean.ServiceListVosBean.ServiceFileVosBean> pics = item.getServiceFileVos();
        if (pics != null) {
            if (pics.size() > 0) {
                ImageLoadUtil.loadImage(mContext, UrlFormatUtil.formatPicUrl(pics.get(0).getPath()),
                        helper.getView(R.id.care_item_iv));
            }
        }

        helper.setGone(R.id.add_dev_tv, false);
    }
}
