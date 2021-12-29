package activity.activity.service;


import activity.activity.service.impl.CloudinaryImg;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {

    CloudinaryImg upload(MultipartFile file) throws IOException;

    boolean delete(String publicId);

}

