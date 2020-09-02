package com.juntai.wisdom.basecomponent.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/5/30 10:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/5/30 10:25
 */
public class OpenLiveBean extends BaseStreamBean {

    /**
     * errcode : 0
     * errdesc : OK
     * strsessionid : 37131201561327001001
     * videourl : rtmp://60.213.43.241:1935/video/37131201561327001001
     * keepalivetime : 60
     */

    private int filesize;
    private String strsessionid;
    private String sessionid;
    private String videourl;
    private String hlsurl;

    public String getHlsurl() {
        return hlsurl == null ? "" : hlsurl;
    }

    public void setHlsurl(String hlsurl) {
        this.hlsurl = hlsurl == null ? "" : hlsurl;
    }

    private String rtspurl;
    private String imagetime;//截图时返回的参数
    private String imageurl;//截图时返回的参数
    private int keepalivetime;

    public String getSessionid() {
        return sessionid == null ? "" : sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid == null ? "" : sessionid;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public String getRtspurl() {
        return rtspurl == null ? "" : rtspurl;
    }

    public void setRtspurl(String rtspurl) {
        this.rtspurl = rtspurl == null ? "" : rtspurl;
    }

    public String getImagetime() {
        return imagetime == null ? "" : imagetime;
    }

    public void setImagetime(String imagetime) {
        this.imagetime = imagetime == null ? "" : imagetime;
    }

    public String getImageurl() {
        return imageurl == null ? "" : imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? "" : imageurl;
    }


    public String getStrsessionid() {
        return strsessionid;
    }

    public void setStrsessionid(String strsessionid) {
        this.strsessionid = strsessionid;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public int getKeepalivetime() {
        return keepalivetime;
    }

    public void setKeepalivetime(int keepalivetime) {
        this.keepalivetime = keepalivetime;
    }
}
