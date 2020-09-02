package com.juntai.look.bean.healthOrg;

import com.juntai.wisdom.basecomponent.base.BaseResult;

/**
 * @Author: tobato
 * @Description: 作用描述  康复机构详情
 * @CreateDate: 2020/7/23 17:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/23 17:22
 */
public class HealthOrganizeDetailBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * list : null
     * type : null
     * data : {"id":2,"name":"尚善残疾人托养院","address":"山东省临沂市河东区","phone":"15275399135",
     * "remark
     * ":"学校自成立以来，得到了社会各界的广泛支持和帮助。临沂公交集团、临沂工商联、康婷日化以及部分爱心企业和个人，多次来学校进行捐助，奉献爱心。在接受社会捐助的同时，我们也勇于承担社会责任，积极回馈社会。对于农村贫困家庭的残疾儿童，学校采取内部救助、减免学费等形式","img":"/case_image/94825862b5934d27bb5bdfe54a0e300b.jpeg"}
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
         * id : 2
         * name : 尚善残疾人托养院
         * address : 山东省临沂市河东区
         * phone : 15275399135
         * remark :
         * 学校自成立以来，得到了社会各界的广泛支持和帮助。临沂公交集团、临沂工商联、康婷日化以及部分爱心企业和个人，多次来学校进行捐助，奉献爱心。在接受社会捐助的同时，我们也勇于承担社会责任，积极回馈社会。对于农村贫困家庭的残疾儿童，学校采取内部救助、减免学费等形式
         * img : /case_image/94825862b5934d27bb5bdfe54a0e300b.jpeg
         */

        private int id;
        private String name;
        private String address;
        private String phone;
        private String remark;
        private String img;
        private  double latitude;
        private  double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name == null ? "暂无" : name;
        }

        public void setName(String name) {
            this.name = name == null ? "暂无" : name;
        }

        public String getAddress() {
            return address == null ? "暂无" : address;
        }

        public void setAddress(String address) {
            this.address = address == null ? "暂无" : address;
        }

        public String getPhone() {
            return phone == null ? "暂无" : phone;
        }

        public void setPhone(String phone) {
            this.phone = phone == null ? "暂无" : phone;
        }

        public String getRemark() {
            return remark == null ? "暂无" : remark;
        }

        public void setRemark(String remark) {
            this.remark = remark == null ? "暂无" : remark;
        }

        public String getImg() {
            return img == null ? "" : img;
        }

        public void setImg(String img) {
            this.img = img == null ? "" : img;
        }
    }
}
