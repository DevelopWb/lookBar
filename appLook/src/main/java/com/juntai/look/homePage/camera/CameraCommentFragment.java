package com.juntai.look.homePage.camera;

import com.juntai.look.base.BaseAppFragment;
import com.juntai.look.hcb.R;

/**
 * @Author: tobato
 * @Description: 作用描述  摄像头评论
 * @CreateDate: 2020/8/14 9:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/14 9:23
 */
public class CameraCommentFragment extends BaseAppFragment<PlayPresent> implements PlayContract.IPlayView {
    @Override
    protected PlayPresent createPresenter() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_camera_comment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(String tag, Object o) {

    }

    @Override
    public void onError(String tag, Object o) {

    }
}
