package com.abrahamchen.scooter.JsonModel;

/**
 * Created by AbrahamChen on 16/4/27.
 */
public class Data {

    private UserInfo userInfo;

    private String token;

    /**
     *
     * @return
     * The userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     *
     * @param userInfo
     * The user_info
     */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

}
