package ru.pie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.pie.form.ShowCaseDTO;
import ru.pie.form.ShowCaseForm;
import ru.pie.service.ShowCaseImageService;
import ru.pie.service.ShowCaseService;

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

    @Autowired
    private ShowCaseService showCaseService;

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
        ShowCaseDTO showCaseDTO = showCaseService.getShowCaseEdit(id);
        ShowCaseForm form = showCaseDTO.extractShowCaseForm();
        form.setImageList(showCaseImageService.getImageListByCaseId(id));

        return new ModelAndView("/showCaseEdit", "modelValue", form);
    }

    @RequestMapping(value = "/edit/action", method= RequestMethod.POST, produces="application/json")
    public @ResponseBody Integer showCaseEditAction(@RequestBody  ShowCaseDTO form) {
        return showCaseService.saveShowCase(form);
    }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public String showCaseCreate() {
        return "/showCaseCreate";
    }

    @RequestMapping(value = "/create/action", method= RequestMethod.POST, produces="application/json")
    public @ResponseBody Integer showCaseCreateAction(@RequestBody  ShowCaseDTO form) {
        return showCaseService.saveShowCase(form);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ModelAndView showCase(@PathVariable(value="id") int id) {
        ShowCaseForm model = new ShowCaseForm();
        model.setName("test");
        model.setImageList(showCaseImageService.getImageListByCaseId(id));
        return new ModelAndView("showCaseView", "modelValue", model);
    }
}
