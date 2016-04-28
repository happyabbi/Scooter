package com.abrahamchen.scooter.WebApiService;

import com.abrahamchen.scooter.JsonModel.Status.LoginStatus;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by AbrahamChen on 16/4/27.
 */
public interface LoginService {
    @FormUrlEncoded
    @POST("member/login")
    Call<LoginStatus> login(@Field(value = "telphone",encoded = false) String telphone
            , @Field(value = "password",encoded = false) String password);

}