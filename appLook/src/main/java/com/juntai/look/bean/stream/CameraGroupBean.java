package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述
 * @CreateDate: 2020/9/17 14:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/17 14:58
 */
public class CameraGroupBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"id":1,"name":"我的家","icon":1},{"id":2,"name":"分享给我的","icon":2},{"id":5,"name":"公司","icon":3},{"id":6,
     * "name":"喜欢","icon":4}]
     * type : null
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
         * id : 1
         * name : 我的家
         * icon : 1
         */

        private int id;
        private String name;
        private int icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }
    }
}
