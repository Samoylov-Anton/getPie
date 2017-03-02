package ru.pie.form;

import ru.pie.model.ShowCaseModel;
import java.util.List;

/**
 * Created by user on 02.03.17.
 */
public class ProfileForm {
    private Integer id;
    private String note;
    private String avatar;
    private List<ShowCaseModel> caseModelList;

    public ProfileForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<ShowCaseModel> getCaseModelList() {
        return caseModelList;
    }

    public void setCaseModelList(List<ShowCaseModel> caseModelList) {
        this.caseModelList = caseModelList;
    }
}
