package com.juntai.look.homePage.careTaker.careInfo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.juntai.look.base.BaseAppActivity;
import com.juntai.look.base.TextListAdapter;
import com.juntai.look.bean.TextListBean;
import com.juntai.look.bean.careTaker.CareTakerInfoBean;
import com.juntai.look.hcb.R;
import com.juntai.look.homePage.careTaker.CareContract;
import com.juntai.look.homePage.careTaker.CarePresent;
import com.juntai.look.homePage.careTaker.addCareTaker.AddCareRecordActivity;
import com.juntai.look.uitils.GlideImageLoader;
import com.juntai.look.uitils.HawkProperty;
import com.juntai.look.uitils.StringTools;
import com.juntai.look.uitils.UrlFormatUtil;
import com.juntai.wisdom.basecomponent.utils.CalendarUtil;
import com.juntai.wisdom.video.img.ImageZoomActivity;
import com.orhanobut.hawk.Hawk;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @aouther tobato
 * @description 描述  托养人详情
 * @date 2020/7/10 15:42
 */
public class CareTakerInfoActivity extends BaseAppActivity<CarePresent> implements CareContract.ICareView,
        View.OnClickListener {
    private TextListAdapter textListAdapter;
    private RecyclerView mCareInfoRv;
    /**
     * 导航
     */
    private TextView mCareInfoNavigationTv;
    public static String CARE_TAKER_ID = "care_taker_id";
    public static String CARE_TAKER_YEAR = "care_taker_year";//托养年份
    public static String CARE_TAKER_INFO = "care_taker_info";
    private Banner banner;
    private GlideImageLoader imageLoader;
    private List<String> images;
    private RecyclerView mCareRecordRv;
    /**
     * 托养服务
     */
    private TextView mRecordCareTv;
    private CareTakerRecordAdapter recordAdapter;
    /**
     * 更多信息
     */
    private TextView mMoreInfoTv;
    private int id;
    private CareTakerInfoBean.DataBean careTakerBean;

    public static int  CARE_RECORE = 10086;
    private SmartRefreshLayout mSmartRefreshLayout;


    @Override
    protected CarePresent createPresenter() {
        return new CarePresent();
    }

    @Override
    public int getLayoutView() {
        return R.layout.recycleview_layout;
    }

    @Override
    public void initView() {
        //获取托养人员的id
        if (getIntent() != null) {
            id = getIntent().getIntExtra(CARE_TAKER_ID, 0);
        }
        setTitleName("托养信息");
        mCareRecordRv = (RecyclerView) findViewById(R.id.recyclerview);
        mSmartRefreshLayout = findViewById(R.id.smartrefreshlayout);
        mSmartRefreshLayout.setEnableLoadMore(true);
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
               initData();
            }
        });

        recordAdapter = new CareTakerRecordAdapter(R.layout.care_item_layout);
        recordAdapter.addHeaderView(getHeadView());
        recordAdapter.setHeaderAndEmpty(true);
        initRecyclerview(mCareRecordRv, recordAdapter, LinearLayoutManager.VERTICAL);
        recordAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                CareTakerInfoBean.DataBean.ServiceListVosBean bean = (CareTakerInfoBean.DataBean.ServiceListVosBean) adapter.getData().get(position);
                startActivity(new Intent(mContext,CareRecordDetailActivity.class).putExtra(CareRecordDetailActivity.CARE_RECORD_TAKER_ID,bean.getServiceId()));
            }
        });
    }

    private View getHeadView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_care_taker_info_head,null);
        mRecordCareTv = (TextView) view.findViewById(R.id.record_care_tv);
        mRecordCareTv.setOnClickListener(this);
        mCareInfoRv = (RecyclerView) view.findViewById(R.id.care_info_rv);
        mCareInfoNavigationTv = (TextView) view.findViewById(R.id.care_info_navigation_tv);
        mCareInfoNavigationTv.setOnClickListener(this);
        textListAdapter = new TextListAdapter(R.layout.item_text_layout);
        textListAdapter.setHidePresentBg(true);
        initRecyclerview(mCareInfoRv, textListAdapter, LinearLayoutManager.VERTICAL);
        /*anner*/
        banner = view.findViewById(R.id.banner);
        banner.isAutoPlay(false);
        ArrayList<String> photos = new ArrayList<>();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                //查看图片
                photos.clear();
                photos.addAll(images);
                startActivity(new Intent(mContext, ImageZoomActivity.class).putExtra("paths", photos).putExtra("item"
                        , position));

            }
        });
        imageLoader = new GlideImageLoader().setOnFullScreenCallBack(new GlideImageLoader.OnFullScreenListener() {
            @Override
            public void onFullScreen() {
            }
        });
        mMoreInfoTv = (TextView) view.findViewById(R.id.more_info_tv);
        mMoreInfoTv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (banner != null) {
            banner.releaseBanner();
            banner.removeAllViews();
            banner.setOnBannerListener(null);

        }
        banner = null;
    }

    @Override
    public void initData() {
        mPresenter.getCareInfo(getPublishMultipartBody()
                        .addFormDataPart("id", String.valueOf(id)).build(),
                CareContract.CARE_INFO);

    }


    @Override
    public void onSuccess(String tag, Object o) {
        switch (tag) {
            case CareContract.CARE_INFO:
                mSmartRefreshLayout.finishRefresh();
                CareTakerInfoBean careTakerInfoBean = (CareTakerInfoBean) o;
                if (careTakerInfoBean != null) {
                    careTakerBean = careTakerInfoBean.getData();
                    Hawk.put(HawkProperty.CARE_INFO_KEY,careTakerBean);
                    images = new ArrayList<>();
                    if (careTakerBean != null) {
                        textListAdapter.setNewData(null);
                        if (String.valueOf(CalendarUtil.getCurrentYear()).equals(careTakerBean.getYear())) {
                            mRecordCareTv.setBackgroundResource(R.drawable.sp_filled_yellow);
                        }else {
                            mRecordCareTv.setBackgroundResource(R.drawable.sp_gray_square_button);
                        }
                        String name = String.format("%s%s%s", careTakerBean.getName(), "   ", careTakerBean.getSex());
                        textListAdapter.addData(new TextListBean("姓名性别", name));
                        textListAdapter.addData(new TextListBean("残疾详情", careTakerBean.getDetails()));
                        textListAdapter.addData(new TextListBean("残疾证号", careTakerBean.getCertificateNo()));
                        textListAdapter.addData(new TextListBean("现在住址", careTakerBean.getPlace()));
                        if (StringTools.isStringValueOk(careTakerBean.getHouseImg())) {
                            images.add(UrlFormatUtil.formatPicUrl(careTakerBean.getHouseImg()));
                        }
                        if (StringTools.isStringValueOk(careTakerBean.getIndoorImg())) {
                            images.add(UrlFormatUtil.formatPicUrl(careTakerBean.getIndoorImg()));
                        }
                        if (StringTools.isStringValueOk(careTakerBean.getPersonImg())) {
                            images.add(UrlFormatUtil.formatPicUrl(careTakerBean.getPersonImg()));
                        }
                        if (StringTools.isStringValueOk(careTakerBean.getGateImg())) {
                            images.add(UrlFormatUtil.formatPicUrl(careTakerBean.getGateImg()));
                        }
                        if (StringTools.isStringValueOk(careTakerBean.getStreetImg())) {
                            images.add(UrlFormatUtil.formatPicUrl(careTakerBean.getStreetImg()));
                        }
                        if (StringTools.isStringValueOk(careTakerBean.getOtherImg())) {
                            images.add(UrlFormatUtil.formatPicUrl(careTakerBean.getOtherImg()));
                        }
                        banner.setImages(images).setImageLoader(imageLoader).start();

                        List<CareTakerInfoBean.DataBean.ServiceListVosBean> records = careTakerBean.getServiceListVos();
                        if (records != null) {
                            recordAdapter.setNewData(records);
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.care_info_navigation_tv:
                navigationLogic(new LatLng(careTakerBean.getLatitude(), careTakerBean.getLongitude()),
                        careTakerBean.getPlace());
                break;
            case R.id.record_care_tv:
                //只能添加当年的托养记录
                if (String.valueOf(CalendarUtil.getCurrentYear()).equals(careTakerBean.getYear())) {
                    startActivityForResult(new Intent(mContext, AddCareRecordActivity.class).putExtra(CARE_TAKER_INFO,
                            careTakerBean),CARE_RECORE);
                }
                break;
            case R.id.more_info_tv:
                startActivity(new Intent(this,CareInfoMoreActivity.class).putExtra(CARE_TAKER_ID,id));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==CARE_RECORE) {
            initData();
        }
    }
}
