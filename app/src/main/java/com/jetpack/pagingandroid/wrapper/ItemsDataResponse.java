package com.jetpack.pagingandroid.wrapper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemsDataResponse {

    @SerializedName("owner")
    @Expose
    private OwnerResponse owner;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("is_accepted")
    @Expose
    private String isAccepted;
    @SerializedName("last_activity_date")
    @Expose
    private String lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("answer_id")
    @Expose
    private String answerId;
    @SerializedName("question_id")
    @Expose
    private String questionId;

    public OwnerResponse getOwner() {
        return owner;
    }

    public void setOwner(OwnerResponse owner) {
        this.owner = owner;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted;
    }

    public String getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
