package ru.pie.service;

import ru.pie.form.ShowCaseDTO;
import ru.pie.model.ShowCaseModel;

import java.util.List;

/**
 * Created by user on 02.03.17.
 */
public interface ShowCaseService {
    Integer saveShowCase(ShowCaseDTO showCase);
    ShowCaseDTO getShowCaseEdit(Integer showCaseId);
    List<ShowCaseModel> getShowCaseList(Integer cityId);
    List<ShowCaseModel> getCaseListByUserId(Integer userId);
}
