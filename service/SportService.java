package activity.activity.service;

import activity.activity.model.binding.AddSportBindingModel;
import activity.activity.model.entity.SportEntity;
import activity.activity.model.service.SportServiceModel;
import activity.activity.model.service.SportUpdateServiceModel;
import activity.activity.model.view.SportDetailsViewModel;
import activity.activity.model.view.SportViewModel;
import activity.activity.service.exception.ObjectNotFoundException;

import java.util.*;

public interface SportService {


    SportServiceModel addActivity(AddSportBindingModel addSportBindingModel, String userIdentifier);

    SportDetailsViewModel findSportById(Long id, String currentUser);

    List<SportViewModel> findAllSportSportViewModels();

    List<SportEntity> findAllSportViewModel();


    boolean isOwner(String userName, Long id);

    void deleteSport(Long id);

      void updateSport(SportUpdateServiceModel sportUpdateServiceModel) throws ObjectNotFoundException;

}