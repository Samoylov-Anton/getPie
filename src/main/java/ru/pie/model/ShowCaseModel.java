package ru.pie.model;

import java.util.Date;

/**
 * Created by user on 28.02.17.
 */
public class ShowCaseModel {
    private Integer id;
    private String name;
    private String note;
    private Date fromDt;
    private Integer userId;
    private Integer showCaseTypeId;
    private Integer minSum;

    public ShowCaseModel() {
    }

    public ShowCaseModel(Integer id, String name, String note, Date fromDt, Integer userId, Integer showCaseTypeId, Integer minSum) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.fromDt = fromDt;
        this.userId = userId;
        this.showCaseTypeId = showCaseTypeId;
        this.minSum = minSum;
    }

    public ShowCaseModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getFromDt() {
        return fromDt;
    }

    public void setFromDt(Date fromDt) {
        this.fromDt = fromDt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShowCaseTypeId() {
        return showCaseTypeId;
    }

    public void setShowCaseTypeId(Integer showCaseTypeId) {
        this.showCaseTypeId = showCaseTypeId;
    }

    public Integer getMinSum() {
        return minSum;
    }

    public void setMinSum(Integer minSum) {
        this.minSum = minSum;
    }
}
