package ru.pie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pie.form.ProfileForm;
import ru.pie.form.ShowCaseForm;
import ru.pie.form.ShowCaseMainForm;
import ru.pie.model.ShowCaseModel;
import ru.pie.service.MainService;
import ru.pie.service.ShowCaseImageService;
import ru.pie.service.ShowCaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by user on 28.02.17.
 */
@Controller
@SessionAttributes("cityId")
public class MainController {

    @Autowired
    private MainService service;

    @Autowired
    private ShowCaseService showCaseService;

    @Autowired
    private ShowCaseImageService showCaseImageService;

    @RequestMapping(value = "/getCity/{cityId}", method = RequestMethod.GET)
    public ModelAndView processPerson(@PathVariable(value="cityId") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        modelAndView.addObject("cityId", cityId);
        return modelAndView;
    }

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ModelAndView fiendAllShowCase() {
        List<ShowCaseMainForm> showCaseList = service.getShowCaseList();
        return new ModelAndView("/index", "showCaseList", showCaseList);
    }

    @RequestMapping(value = "/profile/{userId}", method= RequestMethod.GET)
    public ModelAndView fiendProfile( @PathVariable(value="userId") int userId) {
        ProfileForm profile = new ProfileForm();
        profile.setNote("test");
        profile.setCaseModelList(showCaseService.getCaseListByUserId(userId));
        return new ModelAndView("/profile", "profileValue", profile);
    }

    @RequestMapping(value = "/showCase/{id}/edit", method= RequestMethod.GET)
    public ModelAndView showCaseEdit( @PathVariable(value="id") int id) {
        ShowCaseForm model = new ShowCaseForm();
        model.setName("test");
        model.setImageList(showCaseImageService.getImageListByCaseId(id));
        return new ModelAndView("/showCase", "modelValue", model);
    }
}
