package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  分组下的摄像头或者硬盘录像机
 * @CreateDate: 2020/9/24 15:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/24 15:27
 */
public class DevListBean extends BaseResult {

    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : {"total":45,"list":[{"id":2,"number":"37130201561187053901","name":"东关街NVR",
     * "ezopen":"/camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg","dvrFlag":1,"dvrId":"0","count":11,"isOnline":1,
     * "isShared":1},{"id":24,"number":"37132301561327000001","name":"地下画廊",
     * "ezopen":"/camera_img/f246be2ae9144e2499972d08dd7ee360.jpeg","dvrFlag":0,"dvrId":"0","count":0,"isOnline":1,
     * "isShared":1}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 45
         * list : [{"id":2,"number":"37130201561187053901","name":"东关街NVR",
         * "ezopen":"/camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg","dvrFlag":1,"dvrId":"0","count":11,
         * "isOnline":1,"isShared":1},{"id":24,"number":"37132301561327000001","name":"地下画廊",
         * "ezopen":"/camera_img/f246be2ae9144e2499972d08dd7ee360.jpeg","dvrFlag":0,"dvrId":"0","count":0,
         * "isOnline":1,"isShared":1}]
         */

        private int total;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * number : 37130201561187053901
             * name : 东关街NVR
             * ezopen : /camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg
             * dvrFlag : 1
             * dvrId : 0
             * count : 11
             * isOnline : 1
             * isShared : 1
             */

            private int id;
            private String number;
            private String name;
            private String ezopen;
            private int dvrFlag;
            private String dvrId;
            private int count;
            private int isOnline;
            private int isShared;
            /**
             * 设备绑定标识（0未绑定；1已绑定）  是否绑定nvr
             */
            private Integer bindingFlag;
            public int getId() {
                return id;
            }

            public Integer getBindingFlag() {
                return bindingFlag;
            }

            public void setBindingFlag(Integer bindingFlag) {
                this.bindingFlag = bindingFlag;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEzopen() {
                return ezopen;
            }

            public void setEzopen(String ezopen) {
                this.ezopen = ezopen;
            }

            public int getDvrFlag() {
                return dvrFlag;
            }

            public void setDvrFlag(int dvrFlag) {
                this.dvrFlag = dvrFlag;
            }

            public String getDvrId() {
                return dvrId;
            }

            public void setDvrId(String dvrId) {
                this.dvrId = dvrId;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getIsOnline() {
                return isOnline;
            }

            public void setIsOnline(int isOnline) {
                this.isOnline = isOnline;
            }

            public int getIsShared() {
                return isShared;
            }

            public void setIsShared(int isShared) {
                this.isShared = isShared;
            }
        }
    }
}
