package com.jetpack.pagingandroid.datasource;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.jetpack.pagingandroid.wrapper.ItemsDataResponse;

public class ItemDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, ItemsDataResponse>> itemLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource<Integer, ItemsDataResponse> create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, ItemsDataResponse>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
