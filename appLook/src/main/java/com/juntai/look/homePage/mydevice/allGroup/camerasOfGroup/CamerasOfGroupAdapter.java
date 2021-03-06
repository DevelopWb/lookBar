package com.juntai.look.homePage.mydevice.allGroup.camerasOfGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  分组中的设备
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class CamerasOfGroupAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CamerasOfGroupAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setGone(R.id.selected_status_iv, false);
        helper.setGone(R.id.arrow_right_tag_iv, true);
    }
}
