package com.jetpack.pagingandroid.wrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OwnerResponse {
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("reputation")
    @Expose
    private String reputation;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("accept_rate")
    @Expose
    private String acceptRate;

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(String acceptRate) {
        this.acceptRate = acceptRate;
    }
}
