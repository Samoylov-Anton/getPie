package ru.pie.service.impl;

import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pie.entity.ShowCaseImageEntity;
import ru.pie.form.ImageDTO;
import ru.pie.service.ImageService;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asamoilov on 26.05.2017.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    private static final String ROOT_PATH = "c://file/";

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ImageDTO imageModel) throws IOException {
        DateFormat df = new SimpleDateFormat("MM.dd.yyyy-HH.mm.ss");
        Date createDate = new Date();
        String path = imageModel.getUserId() + "/" + imageModel.getShowCaseId() + "/";
        String largeImagePath = path + "large_" + df.format(createDate) + ".jpg";
        String liteImagePath = path + "lite_" + df.format(createDate) + ".jpg";


        BufferedImage image = ImageIO.read(imageModel.getFile().getInputStream());
        BufferedImage scaledImageLarge = Scalr.resize(image, 640);
        BufferedImage scaledImageLite = Scalr.resize(image, 150);
        File largeFile = new File(ROOT_PATH + largeImagePath);
        File liteFile = new File(ROOT_PATH + liteImagePath);
        largeFile.getParentFile().mkdirs();
        ImageIO.write(scaledImageLarge, "jpg", largeFile);
        ImageIO.write(scaledImageLite, "jpg", liteFile);

        ShowCaseImageEntity entity = new ShowCaseImageEntity();
        entity.setLargePath(largeImagePath);
        entity.setLitePath(liteImagePath);
        entity.setShowCaseId(imageModel.getShowCaseId());
        entity.setNote(imageModel.getNote());
        entity.setFromDt(createDate);
        entityManager.persist(entity);

    }
}
