package ru.pie.service;

import ru.pie.model.ImageShowCaseModel;

import java.util.List;

/**
 * Created by user on 02.03.17.
 */
public interface ShowCaseImageService {
    List<ImageShowCaseModel> getImageListByCaseId(Integer showCaseId);
    List<ImageShowCaseModel> getLimitImageListByCaseId(Integer showCaseId);
}
