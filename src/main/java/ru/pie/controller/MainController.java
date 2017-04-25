package ru.pie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.pie.form.ProfileForm;
import ru.pie.form.ShowCaseForm;
import ru.pie.form.ShowCaseMainForm;
import ru.pie.service.MainService;
import ru.pie.service.ShowCaseImageService;
import ru.pie.service.ShowCaseService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by user on 28.02.17.
 */
@Controller
@SessionAttributes("cityId")
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private MainService service;

    @Autowired
    private ShowCaseService showCaseService;

    @Autowired
    private ShowCaseImageService showCaseImageService;

    @RequestMapping(value = "/getShowCaseList/{cityId}", method = RequestMethod.GET ,produces="application/json")
    public @ResponseBody List<ShowCaseMainForm> getShowCaseList(@PathVariable(value="cityId") int cityId) {
        return service.getShowCaseList(cityId);
    }

    @RequestMapping(value = "/file-upload/{id}", method = RequestMethod.POST ,produces="application/json")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file, @PathVariable(value="id") int id) {

        if (file.isEmpty()) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("C:\\file\\" + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView fiendAllShowCase() {
        return new ModelAndView("/index");
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
        model.setId(1);
        model.setName("test");
        model.setImageList(showCaseImageService.getImageListByCaseId(id));
        return new ModelAndView("/showCaseEdit", "modelValue", model);
    }

    @RequestMapping(value = "/showCase/{id}", method= RequestMethod.GET)
    public ModelAndView showCase( @PathVariable(value="id") int id) {
        ShowCaseForm model = new ShowCaseForm();
        model.setName("test");
        model.setImageList(showCaseImageService.getImageListByCaseId(id));
        return new ModelAndView("/showCase", "modelValue", model);
    }
}
