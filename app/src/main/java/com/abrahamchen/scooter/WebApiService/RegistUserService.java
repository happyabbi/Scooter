package com.abrahamchen.scooter.WebApiService;

import com.abrahamchen.scooter.JsonModel.Status.RegisterUserStatus;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by AbrahamChen on 16/4/27.
 */
public interface RegistUserService {
    @FormUrlEncoded
    @POST("member/ios_regist")
    Call<RegisterUserStatus> registUser(@Field(value = "telphone",encoded = false) String telphone
            , @Field(value = "password",encoded = false) String password
            , @Field(value = "checkcode",encoded = false) String checkcode);

}




