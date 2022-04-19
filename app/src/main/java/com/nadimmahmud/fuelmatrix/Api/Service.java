package com.nadimmahmud.fuelmatrix.Api;

import com.google.gson.JsonObject;
import com.nadimmahmud.fuelmatrix.Model.LoginModel;
import com.nadimmahmud.fuelmatrix.Model.tankList;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Service {
    @GET("login.php")
    Call<LoginModel> getLogin(@Query("user") String userName,
                              @Query("pass") String userPassword);

    @GET("readings.php")
    Call<tankList> getTankList(@Query("user") Integer user);

}
