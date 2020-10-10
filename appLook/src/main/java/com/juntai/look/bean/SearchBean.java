package com.juntai.look.bean;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  搜索结果
 * @CreateDate: 2020/4/29 10:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/4/29 10:11
 */
public class SearchBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"count":37,"typeId":1,"typeName":"视频","videoSearchList":[{"id":2,"ezopen":"/camera_img
     * /2a711bd1bae040bf8f10b90b9966b672.jpeg","address":"中国山东省临沂市河东区九曲街道人民大街中段","name":"nvr01","dvrFlag":1},{"id":5,
     * "ezopen":"/camera_img/7378a3f686c045d1abdd026e5fd122fa.jpeg","address":"中国山东省临沂市河东区九曲街道人民大街中段","name":"008",
     * "dvrFlag":0},{"id":6,"ezopen":"/camera_img/4f129690302d467190b9a6615cc67697.jpeg",
     * "address":"中国山东省临沂市河东区九曲街道人民大街中段","name":"005","dvrFlag":0}],"videoGroupSearchList":null},{"count":2,
     * "typeId":2,"typeName":"分组","videoSearchList":null,"videoGroupSearchList":[{"id":3,"ezopen":"1","address":"26",
     * "name":"我的家"},{"id":4,"ezopen":"2","address":"4","name":"分享给我的"}]}]
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
         * count : 37
         * typeId : 1
         * typeName : 视频
         * videoSearchList : [{"id":2,"ezopen":"/camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg",
         * "address":"中国山东省临沂市河东区九曲街道人民大街中段","name":"nvr01","dvrFlag":1},{"id":5,"ezopen":"/camera_img
         * /7378a3f686c045d1abdd026e5fd122fa.jpeg","address":"中国山东省临沂市河东区九曲街道人民大街中段","name":"008","dvrFlag":0},{"id
         * ":6,"ezopen":"/camera_img/4f129690302d467190b9a6615cc67697.jpeg","address":"中国山东省临沂市河东区九曲街道人民大街中段",
         * "name":"005","dvrFlag":0}]
         * videoGroupSearchList : null
         */

        private int count;
        private int typeId;
        private String typeName;
        private List<videoGroupSearchList> videoGroupSearchList;
        private List<VideoSearchListBean> videoSearchList;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public List<videoGroupSearchList> getVideoGroupSearchList() {
            return videoGroupSearchList;
        }

        public void setVideoGroupSearchList(List<videoGroupSearchList> videoGroupSearchList) {
            this.videoGroupSearchList = videoGroupSearchList;
        }

        public List<VideoSearchListBean> getVideoSearchList() {
            return videoSearchList;
        }

        public void setVideoSearchList(List<VideoSearchListBean> videoSearchList) {
            this.videoSearchList = videoSearchList;
        }

        public static class VideoSearchListBean {
            /**
             * id : 2
             * ezopen : /camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg
             * address : 中国山东省临沂市河东区九曲街道人民大街中段
             * name : nvr01
             * dvrFlag : 1
             */

            private int id;
            private String ezopen;
            private String address;
            private String name;
            private int dvrFlag;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getEzopen() {
                return ezopen;
            }

            public void setEzopen(String ezopen) {
                this.ezopen = ezopen;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getDvrFlag() {
                return dvrFlag;
            }

            public void setDvrFlag(int dvrFlag) {
                this.dvrFlag = dvrFlag;
            }
        }

        public static class videoGroupSearchList {
            /**
             * id : 2
             * ezopen : /camera_img/2a711bd1bae040bf8f10b90b9966b672.jpeg
             * address : 中国山东省临沂市河东区九曲街道人民大街中段
             * name : nvr01
             * dvrFlag : 1
             */

            private int id;
            private String ezopen;
            private String address;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getEzopen() {
                return ezopen == null ? "" : ezopen;
            }

            public void setEzopen(String ezopen) {
                this.ezopen = ezopen == null ? "" : ezopen;
            }

            public String getAddress() {
                return address == null ? "" : address;
            }

            public void setAddress(String address) {
                this.address = address == null ? "" : address;
            }

            public String getName() {
                return name == null ? "" : name;
            }

            public void setName(String name) {
                this.name = name == null ? "" : name;
            }
        }
    }
}
