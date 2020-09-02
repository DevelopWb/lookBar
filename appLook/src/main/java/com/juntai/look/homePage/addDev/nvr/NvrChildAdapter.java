package com.juntai.look.homePage.addDev.nvr;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  硬盘录像机里的摄像机
 * @CreateDate: 2020/7/7 9:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 9:53
 */
public class NvrChildAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public NvrChildAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.addOnClickListener(R.id.add_dev_tv);
    }

}
