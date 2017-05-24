package ru.pie.entity;

import ru.pie.form.ShowCaseDTO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by user on 28.02.17.
 */
@Entity
@Table(name = "show_case")
public class ShowCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_case_gen")
    @SequenceGenerator(name = "show_case_gen", sequenceName = "show_case_seq",
            allocationSize = 1)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="note")
    private String note;

    @Column(name="from_dt")
    private Date fromDt;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="show_case_type_id")
    private Integer showCaseTypeId;

    @Column(name="min_sum")
    private Integer minSum;

    @Column(name = "city_id")
    private Integer cityId;

    public ShowCaseEntity() {
    }

    public void populateFrom(ShowCaseDTO showCaseDTO) {
        this.name = showCaseDTO.getName();
        this.minSum = showCaseDTO.getMinSum();
        this.note = showCaseDTO.getNote();
        this.fromDt = new Date();
        this.showCaseTypeId = showCaseDTO.getShowCaseTypeId();
        this.cityId = 16;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
