package com.juntai.look.homePage.addDev.nvr;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.juntai.look.hcb.R;
import com.juntai.look.homePage.addDev.BaseAddDevActivity;

/**
 * @aouther tobato
 * @description 描述  添加硬盘录像机
 * @date 2020/9/2 9:40
 */
public class AddNvrDevActivity extends BaseAddDevActivity {


    private RecyclerView mNvrChildDevRv;

    @Override
    protected int getLayout() {
        return R.layout.activity_add_nvr_dev;
    }

    @Override
    public void onSuccess(String tag, Object o) {

    }


    @Override
    public void initView() {
        super.initView();
        mNvrChildDevRv = (RecyclerView) findViewById(R.id.nvr_child_dev_rv);
        NvrChildAdapter adapter = new NvrChildAdapter(R.layout.nvr_child_item);
        initRecyclerview(mNvrChildDevRv, adapter, LinearLayoutManager.VERTICAL);
        adapter.setNewData(getTestData());

    }
}
