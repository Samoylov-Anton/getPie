package ru.pie.model;

/**
 * Created by user on 28.02.17.
 */
public class ImageShowCaseModel {
    private String image;
    private String note;

    public ImageShowCaseModel() {
    }

    public ImageShowCaseModel(String image, String note) {
        this.image = image;
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
