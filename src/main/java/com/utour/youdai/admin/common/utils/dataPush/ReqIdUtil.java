package com.utour.youdai.admin.common.utils.dataPush;


import cn.hutool.core.util.IdUtil;

/**
 *  	reqId生成工具类
 *
 */
public class ReqIdUtil {

    public  static final String reqId(String CUSCC){
        return  CUSCC+"-"+  IdUtil.simpleUUID();
    }

    public static void main(String[] args) {
        System.out.println(reqId("1234567890"));
    }

}
