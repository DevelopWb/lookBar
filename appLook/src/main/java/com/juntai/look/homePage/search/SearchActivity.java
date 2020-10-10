package com.juntai.look.homePage.search;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.allenliu.versionchecklib.utils.AppUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.bean.MultipleItem;
import com.juntai.look.bean.SearchMoreBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.HomePageContract;
import com.juntai.look.homePage.HomePagePresent;
import com.juntai.look.homePage.camera.ijkplayer.PlayerLiveActivity;
import com.juntai.wisdom.basecomponent.base.BaseMvpActivity;
import com.juntai.wisdom.basecomponent.utils.StringTools;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;


/**
 * @aouther tobato
 * @description 描述  搜索
 * @date 2020/3/14 14:47
 */
public class SearchActivity extends BaseMvpActivity<HomePagePresent> implements HomePageContract.IHomePageView, View.OnClickListener, SearchFragment.OnSearchCallBack {

    private SearchFragment searchTopFragment;
    //tab条目中的内容
    // 0：监控1：案件2：警员3：车辆4：实有房屋5：实有人员6：实有单位7：巡检8：资讯 14:重点人员
    // 0：监控1：案件2：警员3：车辆4：实有房屋5：实有人员6：实有单位7：巡检8：资讯
    public final static int INFO_TYPE_CAMERA = 0;//监控
    public final static int INFO_TYPE_GROUP = 2;//group
    private RecyclerView mSearchInfoRv;
    private SmartRefreshLayout mSearchRfl;
    private SearchAdapter searchAdapter;
    private String textContent;
    private int limit = 10;//默认条数
    private int insertPosition;//插入的位置

    @Override
    public int getLayoutView() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        getToolbar().setVisibility(View.GONE);
        mBaseRootCol.setFitsSystemWindows(true);
        mImmersionBar.statusBarColor(com.juntai.wisdom.basecomponent.R.color.white).statusBarDarkFont(true).init();
        searchTopFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_serach_top);
        mSearchInfoRv = (RecyclerView) findViewById(R.id.search_info_rv);
        mSearchRfl = (SmartRefreshLayout) findViewById(R.id.search_srl);
        mSearchRfl.setEnableLoadMore(false);
        searchAdapter = new SearchAdapter(null);
        initRecyclerview(mSearchInfoRv, searchAdapter, LinearLayoutManager.VERTICAL);
    }

    @Override
    public void initData() {
        mSearchRfl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.search(HomePageContract.SEARCH, mPresenter.getSearchRequestBody(textContent));
            }
        });
        searchAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultipleItem multipleItem = (MultipleItem) adapter.getItem(position);
                switch (multipleItem.getItemType()) {
                    case MultipleItem.ITEM_TITLE:
                        break;
                    case MultipleItem.ITEM_CONTENT:
                        SearchBean.DataBean.ListBean databean = (SearchBean.DataBean.ListBean) multipleItem.getObject();
                        switch (databean.getTypeId()) {
                            case INFO_TYPE_CAMERA:
                                String mCameraNum = null;
                                String url = databean.getPicture();//http://juntaikeji.net:8080/image/37130201561327011015.jpg
                                if (!TextUtils.isEmpty(url)) {
                                    mCameraNum = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
                                }
                                startActivity(new Intent(mContext.getApplicationContext(), PlayerLiveActivity.class)
                                        .putExtra(PlayerLiveActivity.STREAM_CAMERA_ID, databean.getId())
                                        .putExtra(PlayerLiveActivity.STREAM_CAMERA_NUM, mCameraNum));
                                break;
                            case INFO_TYPE_GROUP:
                                if (StringTools.isStringValueOk(databean.getAccount())) {
                                    chat(mContext, databean.getAccount(), "指挥调度:" + databean.getName());
                                }
                                break;
                            default:
                                break;
                        }
                        break;
                    case MultipleItem.ITEM_LOAD_MORE:
                        SearchMoreBean searchMoreBean = (SearchMoreBean) multipleItem.getObject();
                        String loadMoreMsg = searchMoreBean.getMsg();
                        if (getString(R.string.load_more).equals(loadMoreMsg)) {
                            insertPosition = position;
                            mPresenter.search_getmore(HomePageContract.SEARCH_MORE, mPresenter.getSearchMoreRequestBody(textContent, searchMoreBean.getTypeId(), limit, searchMoreBean.getCurrentOffset()));
                        }
                        break;
                    default:
                        break;
                }


            }
        });
    }

    @Override
    protected HomePagePresent createPresenter() {
        return new HomePagePresent();
    }


    @Override
    public void onSuccess(String tag, Object o) {
        mSearchRfl.finishRefresh();
        switch (tag) {
            case HomePageContract.SEARCH:
                SearchBean searchBean = (SearchBean) o;
                if (searchBean != null) {
                    List<SearchBean.DataBean> item_des = searchBean.getData();
                    List<MultipleItem> multipleItems = new ArrayList<>();
                    if (item_des != null) {
                        for (SearchBean.DataBean item_de : item_des) {
                            List<SearchBean.DataBean.ListBean> itemMsgs = item_de.getList();
                            if (itemMsgs != null && itemMsgs.size() > 0) {
                                multipleItems.add(new MultipleItem(MultipleItem.ITEM_TITLE, item_de));
                                for (SearchBean.DataBean.ListBean itemMsg : itemMsgs) {
                                    itemMsg.setTypeId(item_de.getTypeId());
                                    multipleItems.add(new MultipleItem(MultipleItem.ITEM_CONTENT, itemMsg));
                                }
                                if (itemMsgs.size() < 3) {
                                    //没有更多数据了
                                    multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE, new SearchMoreBean(item_de.getTypeId(), 0, getString(R.string.load_more_no_data))));
                                } else {
                                    if (item_de.getCount() != 3) {
                                        //总共3条数据
                                        multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE, new SearchMoreBean(item_de.getTypeId(), 3, getString(R.string.load_more))));
                                    }

                                }
                            }
                        }
                    }
                    if (multipleItems.size() < 1) {
                        searchAdapter.setEmptyView(getAdapterEmptyView("很遗憾，没搜出相关信息", -1));
                    }
                    searchAdapter.setNewData(multipleItems);

                }
                break;
            case HomePageContract.SEARCH_MORE:
                SearchResultBean loadmoreBean = (SearchResultBean) o;
                if (loadmoreBean != null) {
                    SearchResultBean.DataBean dataBean = loadmoreBean.getData();
                    if (dataBean != null) {
                        List<SearchBean.DataBean.ListBean> list = dataBean.getDatas();
                        List<MultipleItem> multipleItems = new ArrayList<>();
                        for (SearchBean.DataBean.ListBean listBean : list) {
                            listBean.setTypeId(dataBean.getTotal());
                            multipleItems.add(new MultipleItem(MultipleItem.ITEM_CONTENT, listBean));
                        }
                        if (list.size() < limit) {
                            //没有更多数据了
                            multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE, new SearchMoreBean(dataBean.getTotal(), 0, getString(R.string.load_more_no_data))));
                        } else {
                            multipleItems.add(new MultipleItem(MultipleItem.ITEM_LOAD_MORE, new SearchMoreBean(dataBean.getTotal(), dataBean.getPageCount(), getString(R.string.load_more))));
                        }
                        searchAdapter.addData(insertPosition, multipleItems);
                        searchAdapter.remove(insertPosition + list.size() + 1);
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onError(String tag, Object o) {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onSearch(String textContent) {
        this.textContent = textContent;
        mPresenter.search(HomePageContract.SEARCH, mPresenter.getSearchRequestBody(textContent));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        textContent = null;
    }

}
