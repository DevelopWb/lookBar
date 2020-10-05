package com.juntai.look.bean.stream;

import com.juntai.wisdom.basecomponent.base.BaseResult;

import java.util.List;

/**
 * @Author: tobato
 * @Description: 作用描述  被分享的用户列表
 * @CreateDate: 2020/10/5 17:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/10/5 17:07
 */
public class SharedUserBean extends BaseResult {


    /**
     * error : null
     * returnValue : null
     * msg : null
     * code : null
     * data : [{"id":2,"shared":"15615691823","nickName":"韩国杰"},{"id":1,"shared":"17568086930","nickName":"王彬"}]
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
         * id : 2
         * shared : 15615691823
         * nickName : 韩国杰
         */

        private int id;
        private String shared;
        private String nickName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getShared() {
            return shared;
        }

        public void setShared(String shared) {
            this.shared = shared;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}
