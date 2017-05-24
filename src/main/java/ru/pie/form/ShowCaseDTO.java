package ru.pie.form;

/**
 * Created by asamoilov on 22.05.2017.
 */
public class ShowCaseDTO {
    private Integer id;
    private String name;
    private Integer minSum;
    private String note;
    private Integer showCaseTypeId;

    public ShowCaseDTO() {
    }

    public ShowCaseDTO(Integer id, String name, Integer minSum, String note, Integer showCaseTypeId) {
        this.id = id;
        this.name = name;
        this.minSum = minSum;
        this.note = note;
        this.showCaseTypeId = showCaseTypeId;
    }

    public ShowCaseForm extractShowCaseForm(){
        ShowCaseForm form = new ShowCaseForm();
        form.setId(this.getId());
        form.setName(this.getName());
        form.setMinSum(this.getMinSum());
        form.setNote(this.getNote());
        form.setType(this.getShowCaseTypeId());

        return form;
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

    public Integer getMinSum() {
        return minSum;
    }

    public void setMinSum(Integer minSum) {
        this.minSum = minSum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getShowCaseTypeId() {
        return showCaseTypeId;
    }

    public void setShowCaseTypeId(Integer showCaseTypeId) {
        this.showCaseTypeId = showCaseTypeId;
    }
}
