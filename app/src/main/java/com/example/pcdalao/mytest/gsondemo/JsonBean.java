package com.example.pcdalao.mytest.gsondemo;

import java.util.List;

/**
 * Created by pan jh on 2017/2/8.
 */

public class JsonBean {

    /**
     * contentBody : 推荐课程
     * extra : [{"infoTitle":"标题","coverPath":"封面","infoUrl":"H5路径"},{"infoTitle":"","coverPath":"","infoUrl":""}]
     */

    private String contentBody;
    private List<ExtraBean> extra;

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public List<ExtraBean> getExtra() {
        return extra;
    }

    public void setExtra(List<ExtraBean> extra) {
        this.extra = extra;
    }

    public static class ExtraBean {
        /**
         * infoTitle : 标题
         * coverPath : 封面
         * infoUrl : H5路径
         */

        private String infoTitle;
        private String coverPath;
        private String infoUrl;

        public String getInfoTitle() {
            return infoTitle;
        }

        public void setInfoTitle(String infoTitle) {
            this.infoTitle = infoTitle;
        }

        public String getCoverPath() {
            return coverPath;
        }

        public void setCoverPath(String coverPath) {
            this.coverPath = coverPath;
        }

        public String getInfoUrl() {
            return infoUrl;
        }

        public void setInfoUrl(String infoUrl) {
            this.infoUrl = infoUrl;
        }
    }
}
