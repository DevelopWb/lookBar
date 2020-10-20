package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.bean.BaseStreamBean;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述 预置位实体类
 * @CreateDate: 2020/10/15 17:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/15 17:15
 */
public class PreSetBean extends BaseStreamBean {


    /**
     * totalsize : 3
     * onepagesize : 3
     * totalpage : 1
     * pageno : 1
     * count : 3
     * data : [{"channelid":"11016666001321000065","presetid":1,"presetname":"preset 1"},{"channelid
     * ":"11016666001321000065","presetid":2,"presetname":"preset 2"},{"channelid":"11016666001321000065",
     * "presetid":3,"presetname":"preset 3"}]
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * channelid : 11016666001321000065
         * presetid : 1
         * presetname : preset 1
         */

        private String channelid;
        private int presetid;
        private String presetname;

        public String getChannelid() {
            return channelid;
        }

        public void setChannelid(String channelid) {
            this.channelid = channelid;
        }

        public int getPresetid() {
            return presetid;
        }

        public void setPresetid(int presetid) {
            this.presetid = presetid;
        }

        public String getPresetname() {
            return presetname;
        }

        public void setPresetname(String presetname) {
            this.presetname = presetname;
        }
    }
}
