package com.juntai.look.mine.devManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.ServiceRecordBean;
import com.juntai.look.bean.stream.DevListBean;
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
public class DevManagerAdapter extends BaseQuickAdapter<DevListBean.DataBean.ListBean, BaseViewHolder> {
    public DevManagerAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, DevListBean.DataBean.ListBean item) {
        helper.setText(R.id.dev_name_tv, item.getName());
        helper.setText(R.id.dev_des_tv,item.getNumber());
        ImageLoadUtil.loadImageCache(mContext, UrlFormatUtil.formatStreamCapturePicUrl(item.getEzopen()),
                helper.getView(R.id.dev_icon_iv));
    }
}
