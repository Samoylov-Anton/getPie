package ru.pie.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pie.model.ImageShowCaseModel;
import ru.pie.service.ShowCaseImageService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by user on 02.03.17.
 */
@Service
@Transactional
public class ShowCaseImageServiceImpl implements ShowCaseImageService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ImageShowCaseModel> getImageListByCaseId(Integer showCaseId){
        return entityManager.createQuery("SELECT new ru.pie.model.ImageShowCaseModel(sci.largePath, sci.litePath, sci.note) " +
                        "FROM ShowCaseImageEntity sci where sci.showCaseId = :showCaseId"
                , ImageShowCaseModel.class).setParameter("showCaseId", showCaseId).getResultList();
    }

    @Override
    public List<ImageShowCaseModel> getLimitImageListByCaseId(Integer showCaseId){
        return entityManager.createQuery("SELECT new ru.pie.model.ImageShowCaseModel(sci.largePath, sci.litePath, sci.note) " +
                "FROM ShowCaseImageEntity sci where sci.showCaseId = :showCaseId"
                , ImageShowCaseModel.class).setParameter("showCaseId", showCaseId).setMaxResults(5).getResultList();
    }
}

