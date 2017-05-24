package ru.pie.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pie.entity.ShowCaseEntity;
import ru.pie.form.ShowCaseDTO;
import ru.pie.model.ShowCaseModel;
import ru.pie.service.ShowCaseService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by user on 02.03.17.
 */
@Service
@Transactional
public class ShowCaseServiceImpl implements ShowCaseService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer saveShowCase(ShowCaseDTO showCase){
        ShowCaseEntity showCaseEntity;
        if (showCase.getId() == null) {
            showCaseEntity = new ShowCaseEntity();
            showCaseEntity.populateFrom(showCase);
            entityManager.persist(showCaseEntity);
        } else {
            showCaseEntity = entityManager.getReference(ShowCaseEntity.class, showCase.getId());
            showCaseEntity.populateFrom(showCase);
        }
        return showCaseEntity.getId();
    }

    public ShowCaseDTO getShowCaseEdit(Integer showCaseId){
        return entityManager.createQuery("SELECT new ru.pie.form.ShowCaseDTO(sce.id, sce.name, sce.minSum,sce.note, sce.showCaseTypeId) " +
                " from ShowCaseEntity sce where sce.id = :id", ShowCaseDTO.class).setParameter("id", showCaseId).getSingleResult();
    }

    public List<ShowCaseModel> getShowCaseList(Integer cityId){
        return   entityManager.createQuery("SELECT new ru.pie.model.ShowCaseModel(pe.id, pe.name,pe.note," +
                        " pe.fromDt, pe.userId, pe.showCaseTypeId, pe.minSum) FROM ShowCaseEntity pe where pe.cityId = :cityId"
                , ShowCaseModel.class).setParameter("cityId", cityId).setMaxResults(10).getResultList();
    }

    @Override
    public List<ShowCaseModel> getCaseListByUserId(Integer userId){
        return entityManager.createQuery("SELECT new ru.pie.model.ShowCaseModel(sc.id, sc.name) " +
                        "FROM ShowCaseEntity sc where sc.userId = :userId"
                , ShowCaseModel.class).setParameter("userId", userId).getResultList();
    }
}
