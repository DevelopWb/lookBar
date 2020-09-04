package com.juntai.look.homePage.mydevice.allGroup.transferDev;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  转移设备的适配器
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class TransferDevAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TransferDevAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setGone(R.id.selected_status_iv, true);
        helper.setGone(R.id.arrow_right_tag_iv, false);
    }
}
