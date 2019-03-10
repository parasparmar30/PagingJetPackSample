package com.jetpack.pagingandroid.api;
import com.jetpack.pagingandroid.wrapper.ResponseWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface  ApiInterface {
    @GET("answers")
    Call<ResponseWrapper> getAnswers(@Query("page") int page, @Query("pagesize") int pagesize, @Query("site") String site);
}
