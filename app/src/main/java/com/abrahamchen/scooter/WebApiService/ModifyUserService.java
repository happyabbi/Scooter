package com.abrahamchen.scooter.WebApiService;

import com.abrahamchen.scooter.JsonModel.Status.ModifyUserStatus;

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

    public interface ModifyUserService {

        @Multipart
        @FormUrlEncoded
        @POST("member/modify_name")
        Call<ModifyUserStatus> modifyUserInfo(
                @Field(value = "id",encoded = false) String id
                , @Field(value = "username",encoded = false) String username
                , @Part(value = "img",encoding = "binary") MultipartBody.Part img
                , @Field(value = "gender",encoded = false) String gender
                , @Field(value = "city",encoded = false) String city
                , @Field(value = "diqu",encoded = false) String diqu
                , @Field(value = "Token",encoded = false) String Token
        );

        @Multipart
        @POST("upload")
        Call<ResponseBody> upload(@Part("description") RequestBody description,
                                  @Part MultipartBody.Part file);
    }




