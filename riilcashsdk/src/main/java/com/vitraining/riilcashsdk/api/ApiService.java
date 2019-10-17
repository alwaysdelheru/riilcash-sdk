package com.vitraining.riilcashsdk.api;

import com.google.gson.JsonElement;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    /*register*/
    @FormUrlEncoded
    @POST("peoples")
    Call<JsonElement> peoples(
            @Header("Content-Type") String content_type,
            @FieldMap Map<String, Object> params1
    );

    /*login*/
    @FormUrlEncoded
    @POST("peoples/login")
    Call<JsonElement> login(
            @Header("Content-Type") String content_type,
            @FieldMap Map<String, Object> params1
    );

    /*master country*/
    @GET("master/country")
    Call<JsonElement> country(
            @Header("access_token") String access_token
    );

    /*master currency*/
    @GET("master/currency")
    Call<JsonElement> currency(
            @Header("access_token") String access_token
    );

    /*master mto*/
    @GET("master/mto")
    Call<JsonElement> mto(
            @Header("access_token") String access_token
    );

    /*master bank*/
    @GET("master/bank")
    Call<JsonElement> bank(
            @Header("access_token") String access_token
    );

    /*master provider*/
    @GET("master/provider")
    Call<JsonElement> provider(
            @Header("access_token") String access_token
    );

    /*list user account*/
    @GET("peoples")
    Call<JsonElement> listUser(
            @Header("access_token") String access_token
    );

    /*user account*/
    @GET("peoples/{user_id}")
    Call<JsonElement> getUser(
            @Header("access_token") String access_token,
            @Path(value = "user_id") String userId
    );

    /*check account*/
    @FormUrlEncoded
    @POST("check_account")
    Call<JsonElement> checkAccount(
            @Header("access_token") String content_type,
            @FieldMap Map<String, Object> params1
    );

    /*people by name*/
    @GET("peopleByName/{name}")
    Call<JsonElement> peopleByName(
            @Header("access_token") String access_token,
            @Path(value = "name") String name
    );

    /*people by parent*/
    @GET("peopleByParent/{id}")
    Call<JsonElement> peopleByParent(
            @Header("access_token") String access_token,
            @Path(value = "id") Integer id
    );

    /*forgot password*/
    @GET("forgotPassword/{name}")
    Call<JsonElement> forgotPassword(
            @Header("access_token") String access_token,
            @Path(value = "name") String name
    );

    /*single people by name*/
    @GET("singlePeopleByName/{name}")
    Call<JsonElement> singlePeopleByName(
            @Header("access_token") String access_token,
            @Path(value = "name") String name
    );

    /*create deposit*/
    @FormUrlEncoded
    @POST("deposits")
    Call<JsonElement> deposits(
            @Header("access_token") String content_type,
            @FieldMap Map<String, Object> params1
    );

    /*get deposit*/
    @GET("deposits/{name}")
    Call<JsonElement> getDeposit(
            @Header("access_token") String access_token,
            @Path(value = "name") String name
    );

    /*process deposit*/
    @POST("deposits/process/{unique_code}")
    Call<JsonElement> processDeposit(
            @Header("access_token") String access_token,
            @Path(value = "unique_code") String unique_code
    );

    /*create withdrawal*/
    @FormUrlEncoded
    @POST("withdrawals")
    Call<JsonElement> withdrawals(
            @Header("access_token") String content_type,
            @FieldMap Map<String, Object> params1
    );

    /*get withdrawal*/
    @GET("withdrawals/{name}")
    Call<JsonElement> getWithdrawal(
            @Header("access_token") String access_token,
            @Path(value = "name") String name
    );

    /*process withdrawal*/
    @POST("withdrawals/process/{unique_code}")
    Call<JsonElement> processWithdrawal(
            @Header("access_token") String access_token,
            @Path(value = "unique_code") String unique_code
    );

    /*get bank transfer*/
    @GET("bank_transfers/{unique_code}")
    Call<JsonElement> getBankTransfer(
            @Header("access_token") String access_token,
            @Path(value = "unique_code") String unique_code
    );

    /*process bank transfer*/
    @POST("bank_transfers/process/{unique_code}")
    Call<JsonElement> processBankTransfer(
            @Header("access_token") String access_token,
            @Path(value = "unique_code") String unique_code
    );

    /*create payment*/
    @FormUrlEncoded
    @POST("create_payment")
    Call<JsonElement> createPayment(
            @Header("access_token") String content_type,
            @FieldMap Map<String, Object> params1
    );

    /*send money*/
    @FormUrlEncoded
    @POST("send_money")
    Call<JsonElement> sendMoney(
            @Header("access_token") String content_type,
            @FieldMap Map<String, Object> params1
    );
}
