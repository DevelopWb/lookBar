package com.juntai.look.homePage.addDev;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  添加设备
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class AddDevAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AddDevAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
//        helper.addOnClickListener(R.id.add_dev_tv);
    }

}
