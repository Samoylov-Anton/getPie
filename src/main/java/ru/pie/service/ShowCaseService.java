package ru.pie.service;

import ru.pie.model.ShowCaseModel;

import java.util.List;

/**
 * Created by user on 02.03.17.
 */
public interface ShowCaseService {
    List<ShowCaseModel> getShowCaseList(Integer cityId);
    List<ShowCaseModel> getCaseListByUserId(Integer userId);
}
