package com.juntai.look.homePage.olderCareData;

import android.support.v4.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.bean.CareChildListNewestBean;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;
/**
 * @Author: tobato
 * @Description: 作用描述  跟踪列表
 * @CreateDate: 2020/4/27 11:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/27 11:16
 */
public class FollowListAdapter extends BaseQuickAdapter<CareChildListNewestBean.DataBean.ChildCaseBean, BaseViewHolder> {
    boolean showNavigation = false;//是否显示导航

    public FollowListAdapter(int layoutResId, boolean showNavigation) {
        super(layoutResId);
        this.showNavigation = showNavigation;
    }

    @Override
    protected void convert(BaseViewHolder helper, CareChildListNewestBean.DataBean.ChildCaseBean item) {

        String image = item.getPersonImg();
        if (StringTools.isStringValueOk(item.getPersonImg())) {
            ImageLoadUtil.loadImage(mContext, UrlFormatUtil.formatPicUrl(image),
                    helper.getView(R.id.care_item_iv));
        } else {
            helper.setImageResource(R.id.care_item_iv, R.drawable.nopicture);
        }
        helper.setText(R.id.care_time_tv, item.getCaseDate());
        helper.setText(R.id.care_detail_tv, item.getName());
        if (String.valueOf(item.getCaseFId()).equals("0")) {
            helper.setTextColor(R.id.care_detail_tv, ContextCompat.getColor(mContext,R.color.blue));
            helper.setTextColor(R.id.add_dev_tv, ContextCompat.getColor(mContext,R.color.blue));
            helper.setTextColor(R.id.care_time_tv, ContextCompat.getColor(mContext,R.color.blue));
        }else{
            helper.setTextColor(R.id.care_detail_tv, ContextCompat.getColor(mContext,R.color.text_default_color));
            helper.setTextColor(R.id.add_dev_tv, ContextCompat.getColor(mContext,R.color.text_default_color));
            helper.setTextColor(R.id.care_time_tv, ContextCompat.getColor(mContext,R.color.text_default_color));
        }
        if (showNavigation) {
            helper.addOnClickListener(R.id.add_dev_tv);
            helper.setText(R.id.add_dev_tv, "导航");
            helper.setTextColor(R.id.add_dev_tv, ContextCompat.getColor(mContext, R.color.white));
            helper.setBackgroundRes(R.id.add_dev_tv, R.drawable.sp_blue_square_button);
        } else {
            helper.setText(R.id.add_dev_tv, String.valueOf(getData().size() - helper.getAdapterPosition()));
            helper.setBackgroundRes(R.id.add_dev_tv, 0);
        }

    }
}
