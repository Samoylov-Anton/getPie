package ru.pie.form;

import ru.pie.model.ImageShowCaseModel;

import java.util.List;

/**
 * Created by user on 28.02.17.
 */
public class ShowCaseMainForm {
    private String avatar;
    private String note;
    private List<ImageShowCaseModel> imageList;
    private Integer like;
    private Integer minSum;

    public ShowCaseMainForm() {
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<ImageShowCaseModel> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageShowCaseModel> imageList) {
        this.imageList = imageList;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getMinSum() {
        return minSum;
    }

    public void setMinSum(Integer minSum) {
        this.minSum = minSum;
    }
}
