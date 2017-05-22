package ru.pie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.pie.form.ShowCaseCreateDTO;
import ru.pie.form.ShowCaseForm;
import ru.pie.service.ShowCaseImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by asamoilov on 22.05.2017.
 */
@Controller
@RequestMapping(value = "/showCase")
public class ShowCaseController {

    @Autowired
    private ShowCaseImageService showCaseImageService;

    @RequestMapping(value = "/file-upload/{id}", method = RequestMethod.POST ,produces="application/json")
    public ResponseEntity upload(@RequestParam("files") MultipartFile file, @PathVariable(value="id") int id) {

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

    @RequestMapping(value = "/edit/{id}", method= RequestMethod.GET)
    public ModelAndView showCaseEdit(@PathVariable(value="id") int id) {
        ShowCaseForm model = new ShowCaseForm();
        model.setId(id);
        model.setName("test");
        model.setImageList(showCaseImageService.getImageListByCaseId(id));
        return new ModelAndView("/showCaseEdit", "modelValue", model);
    }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public String showCaseCreate() {
        return "/showCaseCreate";
    }

    @RequestMapping(value = "/create/action", method= RequestMethod.POST)
    public @ResponseBody Integer showCaseCreateAction(ShowCaseCreateDTO form) {
        Integer id = 1;
        return id;
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ModelAndView showCase(@PathVariable(value="id") int id) {
        ShowCaseForm model = new ShowCaseForm();
        model.setName("test");
        model.setImageList(showCaseImageService.getImageListByCaseId(id));
        return new ModelAndView("showCaseView", "modelValue", model);
    }
}
