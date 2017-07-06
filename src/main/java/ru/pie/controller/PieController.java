package ru.pie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pie.form.ProfileForm;
import ru.pie.form.ShowCaseMainForm;
import ru.pie.service.MainService;
import ru.pie.service.ShowCaseService;

import java.util.List;

/**
 * Created by user on 28.02.17.
 */
@Controller
@SessionAttributes("cityId")
@RequestMapping(value = "/")
public class PieController {
    private Integer userId = 1;

    @Autowired
    private MainService service;

    @Autowired
    private ShowCaseService showCaseService;

    @RequestMapping(value = "/getShowCaseList/{cityId}", method = RequestMethod.GET ,produces="application/json")
    public @ResponseBody List<ShowCaseMainForm> getShowCaseList(@PathVariable(value="cityId") int cityId) {
        return service.getShowCaseList(cityId);
    }

    @RequestMapping(method= RequestMethod.GET)
    public String fiendAllShowCase() {
        return "forward:/view/index.html";
    }

    @RequestMapping(value = "/profile", method= RequestMethod.GET)
    public ModelAndView fiendProfile() {
        ProfileForm profile = new ProfileForm();
        profile.setNote("user#1");
        profile.setCaseModelList(showCaseService.getCaseListByUserId(userId));
        return new ModelAndView("/profile", "profileValue", profile);
    }
}
