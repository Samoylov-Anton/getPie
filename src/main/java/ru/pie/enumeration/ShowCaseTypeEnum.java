package ru.pie.enumeration;

/**
 * Created by user on 02.03.17.
 */
public enum ShowCaseTypeEnum {
    CAKE(1);

    private int id;

    ShowCaseTypeEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
