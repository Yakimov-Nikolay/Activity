package activity.activity.service;

import activity.activity.model.binding.AddPictureBindingModel;
import activity.activity.model.entity.PictureEntity;

import java.io.IOException;
import java.util.*;

public interface PictureService {

    void addPicture(AddPictureBindingModel addPictureBindingModel, String principalName) throws IOException;

    List<PictureEntity> findAllPictureViewModel();
}
