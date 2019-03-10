package com.jetpack.pagingandroid.wrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseWrapper {
    @SerializedName("quota_max")
    @Expose
    private String quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private String quotaRemaining;
    @SerializedName("has_more")
    @Expose
    private boolean hasMore;
    @SerializedName("items")
    @Expose
    private ArrayList<ItemsDataResponse> items;

    public String getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(String quotaMax) {
        this.quotaMax = quotaMax;
    }

    public String getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(String quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public ArrayList<ItemsDataResponse> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemsDataResponse> items) {
        this.items = items;
    }
}
