package ru.pie.service;

import ru.pie.form.ImageDTO;

import java.io.IOException;

/**
 * Created by asamoilov on 26.05.2017.
 */
public interface ImageService {
    void save(ImageDTO imageModel) throws IOException;
}
