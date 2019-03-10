package com.jetpack.pagingandroid.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.jetpack.pagingandroid.datasource.ItemDataSource;
import com.jetpack.pagingandroid.datasource.ItemDataSourceFactory;
import com.jetpack.pagingandroid.wrapper.ItemsDataResponse;

public class ItemViewModel extends ViewModel {

   public LiveData<PagedList<ItemsDataResponse>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer, ItemsDataResponse>> liveDataSource;

    public ItemViewModel() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE).build();

        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig))
                .build();
    }
}
