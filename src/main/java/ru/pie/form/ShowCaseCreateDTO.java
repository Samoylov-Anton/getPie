package ru.pie.form;

/**
 * Created by asamoilov on 22.05.2017.
 */
public class ShowCaseCreateDTO {
    private String name;
    private String minSum;
    private String note;

    public ShowCaseCreateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinSum() {
        return minSum;
    }

    public void setMinSum(String minSum) {
        this.minSum = minSum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
