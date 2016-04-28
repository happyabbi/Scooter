package com.abrahamchen.scooter;

import com.abrahamchen.scooter.JsonModel.Status.LoginStatus;
import com.abrahamchen.scooter.JsonModel.Status.ModifyUserStatus;
import com.abrahamchen.scooter.JsonModel.Status.RegisterUserStatus;
import com.abrahamchen.scooter.WebApiService.LoginService;
import com.abrahamchen.scooter.WebApiService.ModifyUserService;
import com.abrahamchen.scooter.WebApiService.RegistUserService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class WebApiUnitTest {


    String EndPoint;

    @Before
    public void setUp() {
        this.EndPoint = "http://www.3banfo.cn/index.php/";
    }
    @After
    public void tearDown() {

    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void registUserService_test() throws Exception{

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EndPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegistUserService service = retrofit.create(RegistUserService.class);

        Call<RegisterUserStatus> postCall = service.registUser("11111111111","2345","1234");
        postCall.enqueue(new Callback<RegisterUserStatus>() {
            @Override
            public void onResponse(Call<RegisterUserStatus> call, Response<RegisterUserStatus> response) {
                assertEquals(true, response.isSuccessful());
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<RegisterUserStatus> call, Throwable t) {
                assertEquals(true,false);
            }
        });

        Thread.sleep(2000);
    }

    @Test
    public void LoginService_test() throws Exception{

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EndPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginService service = retrofit.create(LoginService.class);

        Call<LoginStatus> postCall = service.login("18691132660","6216587aaa");
        postCall.enqueue(new Callback<LoginStatus>() {
            @Override
            public void onResponse(Call<LoginStatus> call, Response<LoginStatus> response) {
                assertEquals(true, response.isSuccessful());
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<LoginStatus> call, Throwable t) {
                assertEquals(true,false);
            }
        });

        Thread.sleep(2000);
    }

    @Test
    public void ModifyUserService_test() throws Exception{

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EndPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ModifyUserService service = retrofit.create(ModifyUserService.class);
        // use the FileUtils to get the actual file by uri
        File file = FileUtils.getFile(this, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);


        Call<ModifyUserStatus> postCall = service.modifyUserInfo("","",body,"","","","");
        postCall.enqueue(new Callback<ModifyUserStatus>() {
            @Override
            public void onResponse(Call<ModifyUserStatus> call, Response<ModifyUserStatus> response) {
                assertEquals(true, response.isSuccessful());
                if(response.isSuccessful()){

                }
            }

            @Override
            public void onFailure(Call<ModifyUserStatus> call, Throwable t) {
                assertEquals(true,false);
            }
        });

        Thread.sleep(2000);
    }
}