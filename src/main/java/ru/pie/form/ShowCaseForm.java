package ru.pie.form;

import ru.pie.model.ImageShowCaseModel;

import java.util.List;

/**
 * Created by user on 02.03.17.
 */
public class ShowCaseForm {
    private Integer id;
    private String avatar;
    private String note;
    private String name;
    private List<ImageShowCaseModel> imageList;
    private Integer minSum;

    public ShowCaseForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageShowCaseModel> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageShowCaseModel> imageList) {
        this.imageList = imageList;
    }

    public Integer getMinSum() {
        return minSum;
    }

    public void setMinSum(Integer minSum) {
        this.minSum = minSum;
    }
}
