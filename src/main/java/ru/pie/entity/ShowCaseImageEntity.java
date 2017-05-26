package ru.pie.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 02.03.17.
 */
@Entity
@Table(name = "show_case_image")
public class ShowCaseImageEntity {

    @Id
    @GeneratedValue(generator = "show_case_image_gen")
    @SequenceGenerator(name = "show_case_image_gen", sequenceName = "show_case_image_seq")
    private Integer id;

    @Column(name="large_path")
    private String largePath;

    @Column(name="lite_path")
    private String litePath;

    @Column(name="note")
    private String note;

    @Column(name="from_dt")
    private Date fromDt;

    @Column(name="show_case_id")
    private Integer showCaseId;

    @Column(name="is_main")
    private Boolean isMain;

    public ShowCaseImageEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getFromDt() {
        return fromDt;
    }

    public void setFromDt(Date fromDt) {
        this.fromDt = fromDt;
    }

    public Integer getShowCaseId() {
        return showCaseId;
    }

    public void setShowCaseId(Integer showCaseId) {
        this.showCaseId = showCaseId;
    }

    public Boolean getMain() {
        return isMain;
    }

    public void setMain(Boolean main) {
        isMain = main;
    }
}
