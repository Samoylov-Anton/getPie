package ru.pie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pie.form.ShowCaseMainForm;
import ru.pie.model.ImageShowCaseModel;
import ru.pie.model.ShowCaseModel;
import ru.pie.service.MainService;
import ru.pie.service.ShowCaseImageService;
import ru.pie.service.ShowCaseService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 28.02.17.
 */
@Service
@Transactional
public class MainServiceImpl implements MainService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ShowCaseImageService showCaseImageService;
    @Autowired
    private ShowCaseService showCaseService;

    public List<ShowCaseMainForm> getShowCaseList(){

        List<ShowCaseMainForm> profileFormList = new ArrayList<>();
        List<ShowCaseModel> showCaseModels = showCaseService.getShowCaseList();
        if (!showCaseModels.isEmpty()) {
            ShowCaseMainForm form = new ShowCaseMainForm();

            for (ShowCaseModel model: showCaseModels) {
                form.setAvatar("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQMwrBISlBl_ZpX5__JKG6Y7Rk39yk1z0RqTKAtrY91pUqZDdMg");
                form.setLike(22);
                form.setMinSum(model.getMinSum());
                form.setNote(model.getNote());

                form.setImageList(showCaseImageService.getImageListByCaseId(model.getId()));
                profileFormList.add(form);
            }
        }
        return profileFormList;
    }
}
