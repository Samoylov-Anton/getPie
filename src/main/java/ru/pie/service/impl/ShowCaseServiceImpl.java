package ru.pie.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public List<ShowCaseModel> getShowCaseList(){
        return   entityManager.createQuery("SELECT new ru.pie.model.ShowCaseModel(pe.id, pe.name,pe.note," +
                        " pe.fromDt, pe.userId, pe.showCaseTypeId, pe.minSum) FROM ShowCaseEntity pe "
                , ShowCaseModel.class).setMaxResults(10).getResultList();
    }

    @Override
    public List<ShowCaseModel> getCaseListByUserId(Integer userId){
        return entityManager.createQuery("SELECT new ru.pie.model.ShowCaseModel(sc.id, sc.name) " +
                        "FROM ShowCaseEntity sc where sc.userId = :userId"
                , ShowCaseModel.class).setParameter("userId", userId).getResultList();
    }
}
