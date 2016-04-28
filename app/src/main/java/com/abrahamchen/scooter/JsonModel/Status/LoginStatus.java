package com.abrahamchen.scooter.JsonModel.Status;

import com.abrahamchen.scooter.JsonModel.Data;

/**
 * Created by AbrahamChen on 16/4/27.
 */
public class LoginStatus {



    private Integer ret;

    private String msg;

    private Data data;


    /**
     *
     * @return
     * The ret
     */
    public Integer getRet() {
        return ret;
    }

    /**
     *
     * @param ret
     * The ret
     */
    public void setRet(Integer ret) {
        this.ret = ret;
    }

    /**
     *
     * @return
     * The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     * The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }


    public void setData(Data data){
        this.data = data;
    }

    public Data getData(){
        return this.data;
    }
}
