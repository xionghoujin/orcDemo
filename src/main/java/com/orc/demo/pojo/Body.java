package com.orc.demo.pojo;

import java.util.List;

/**
 * Created by 熊厚谨 on 2018/5/26 22:55
 *
 * @author 熊厚谨
 */
public class Body {

    /**
     * request_id : 20180526225152_8d33969cea6827563ea01aa530e3760e
     * ret : [{"prob":0.8998757004737854,"rect":{"angle":0,"height":182.99996948242188,"left":476,"top":149,"width":1086.9998779296875},"word":"13687096286"}]
     * success : true
     */

    private String request_id;
    private boolean success;
    private List<RetBean> ret;

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<RetBean> getRet() {
        return ret;
    }

    public void setRet(List<RetBean> ret) {
        this.ret = ret;
    }

    public static class RetBean {
        /**
         * prob : 0.8998757004737854
         * rect : {"angle":0,"height":182.99996948242188,"left":476,"top":149,"width":1086.9998779296875}
         * word : 13687096286
         */

        private double prob;
        private RectBean rect;
        private String word;

        public double getProb() {
            return prob;
        }

        public void setProb(double prob) {
            this.prob = prob;
        }

        public RectBean getRect() {
            return rect;
        }

        public void setRect(RectBean rect) {
            this.rect = rect;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public static class RectBean {
            /**
             * angle : 0
             * height : 182.99996948242188
             * left : 476
             * top : 149
             * width : 1086.9998779296875
             */

            private int angle;
            private double height;
            private double left;
            private double top;
            private double width;

            public int getAngle() {
                return angle;
            }

            public void setAngle(int angle) {
                this.angle = angle;
            }

            public double getHeight() {
                return height;
            }

            public void setHeight(double height) {
                this.height = height;
            }

            public double getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public double getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public double getWidth() {
                return width;
            }

            public void setWidth(double width) {
                this.width = width;
            }
        }
    }
}
