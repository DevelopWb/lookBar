package com.juntai.look.homePage.search;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.careTaker.SearchedPeopleBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

/**
 * @Author: tobato
 * @Description: 作用描述  搜索到的托养人
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class SearchedAdapter extends BaseQuickAdapter<SearchedPeopleBean.DataBean.DatasBean, BaseViewHolder> {
    public SearchedAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchedPeopleBean.DataBean.DatasBean item) {

        String street =item.getStreetAddress();
        String village = item.getCommunityAddress();
        if (StringTools.isStringValueOk(street)) {
            if (street.length()>5) {
                street = street.substring(0,5);
            }
        }
        if (StringTools.isStringValueOk(village)) {
            if (village.length()>5) {
                village = village.substring(0,5);
            }
        }

        String title = String.format("%s%s%s%s%s", street," ",village, " ",
                item.getName());
        helper.setText(R.id.dev_no_tv, title);
        helper.setText(R.id.care_content_tv, item.getIdNo());
        helper.setText(R.id.dev_tag_tv, item.getYear() + "年度");
        ImageLoadUtil.loadImage(mContext, UrlFormatUtil.formatPicUrl(item.getPersonImg()),
                helper.getView(R.id.care_item_iv));
        helper.addOnClickListener(R.id.add_dev_tv);
        helper.setText(R.id.add_dev_tv, "导航");
    }
}
