package com.abrahamchen.scooter.JsonModel;

/**
 * Created by AbrahamChen on 16/4/27.
 */

public class UserInfo {

    private String id;
    private String username;
    private String password;
    private String telphone;
    private String gender;
    private Object img;
    private String area;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     * The telphone
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     *
     * @param telphone
     * The telphone
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The img
     */
    public Object getImg() {
        return img;
    }

    /**
     *
     * @param img
     * The img
     */
    public void setImg(Object img) {
        this.img = img;
    }

    /**
     *
     * @return
     * The area
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(String area) {
        this.area = area;
    }

}