package com.juntai.look.mine.myMsg;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.bean.mine.MyMsgBean;
import com.juntai.look.hcb.R;
import com.juntai.look.uitils.StringTools;
import com.juntai.wisdom.basecomponent.utils.CalendarUtil;
import com.juntai.wisdom.basecomponent.utils.ImageLoadUtil;

/**
 * Describe:我的消息
 * Create by zhangzhenlong
 * 2020-3-25
 * email:954101549@qq.com
 */
public class MyMsgAdapter extends BaseQuickAdapter<MyMsgBean.DataBean.DatasBean, BaseViewHolder> {

    public MyMsgAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMsgBean.DataBean.DatasBean item) {
        if (item.getIsRead() == 1){//0未读,1已读
            helper.setVisible(R.id.read_tag,false);
        }else {//未读
            helper.setVisible(R.id.read_tag,true);
        }
        ImageLoadUtil.loadImage(mContext,R.drawable.app_logo,helper.getView(R.id.item_image_iv));
        helper.setText(R.id.item_title_tv,item.getTitle());
        helper.setText(R.id.item_content_tv,item.getContent());
        String time = item.getPublishTime();
        if (StringTools.isStringValueOk(time)) {
            time = CalendarUtil.getTimeFromString("yyyy-MM-dd HH:mm:ss",time,"yyyy-MM-dd HH:mm");
        }
        helper.setText(R.id.item_date_tv,time);
    }
}
