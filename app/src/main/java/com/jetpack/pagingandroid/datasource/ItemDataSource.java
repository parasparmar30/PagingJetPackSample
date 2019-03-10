package com.jetpack.pagingandroid.datasource;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.jetpack.pagingandroid.api.RetrofitClient;
import com.jetpack.pagingandroid.wrapper.ItemsDataResponse;
import com.jetpack.pagingandroid.wrapper.ResponseWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, ItemsDataResponse> {

    public static final int PAGE_SIZE = 20;
    private static final int INIT_PAGE = 1;
    private static final String SITE_NAME = "android";

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ItemsDataResponse> callback) {
        RetrofitClient.getInstance()
                .getApiInterface().getAnswers(INIT_PAGE, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<ResponseWrapper>() {
                    @Override
                    public void onResponse(Call<ResponseWrapper> call, Response<ResponseWrapper> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body().getItems(), null, INIT_PAGE + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseWrapper> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ItemsDataResponse> callback) {
        RetrofitClient.getInstance()
                .getApiInterface().getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<ResponseWrapper>() {
                    @Override
                    public void onResponse(Call<ResponseWrapper> call, Response<ResponseWrapper> response) {
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {
                            callback.onResult(response.body().getItems(), adjacentKey);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseWrapper> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ItemsDataResponse> callback) {
        RetrofitClient.getInstance()
                .getApiInterface()
                .getAnswers(params.key, PAGE_SIZE, SITE_NAME)
                .enqueue(new Callback<ResponseWrapper>() {
                    @Override
                    public void onResponse(Call<ResponseWrapper> call, Response<ResponseWrapper> response) {
                        if (response.body() != null && response.body().isHasMore()) {
                            callback.onResult(response.body().getItems(), params.key + 1);
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseWrapper> call, Throwable t) {

                    }
                });
    }
}
