package dev.childer.childerserver.services;

import dev.childer.childerserver.models.ImageModel;
import dev.childer.childerserver.repositories.ImageRepository;
import dev.childer.childerserver.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageModel uploadImage(MultipartFile file) throws IOException {
        ImageModel imageData = imageRepository.save(ImageModel.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return imageData;
        }
        return null;
    }

    public byte[] downloadImage(String fileName) {
        Optional<ImageModel> dbImageData = imageRepository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
