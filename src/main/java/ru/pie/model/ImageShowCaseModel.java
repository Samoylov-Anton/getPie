package ru.pie.model;

/**
 * Created by user on 28.02.17.
 */
public class ImageShowCaseModel {
    private String largePath;
    private String litePath;
    private String note;

    public ImageShowCaseModel(String largePath, String litePath, String note) {
        this.largePath = largePath;
        this.litePath = litePath;
        this.note = note;
    }

    public String getLargePath() {
        return largePath;
    }

    public void setLargePath(String largePath) {
        this.largePath = largePath;
    }

    public String getLitePath() {
        return litePath;
    }

    public void setLitePath(String litePath) {
        this.litePath = litePath;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
