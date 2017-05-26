package ru.pie.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by asamoilov on 26.05.2017.
 */
public class ImageDTO {

    private MultipartFile file;
    private Integer showCaseId;
    private Integer userId;
    private String note;

    public ImageDTO(MultipartFile file, Integer showCaseId, Integer userId, String note) {
        this.file = file;
        this.userId = userId;
        this.showCaseId = showCaseId;
        this.note = note;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getShowCaseId() {
        return showCaseId;
    }

    public void setShowCaseId(Integer showCaseId) {
        this.showCaseId = showCaseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
