package activity.activity.service;

import activity.activity.model.service.CommentServiceModel;
import activity.activity.model.view.CommentViewModel;
import org.hibernate.ObjectNotFoundException;

import java.util.*;

public interface CommentService {

        CommentViewModel createComment(CommentServiceModel commentServiceModel)
                throws ObjectNotFoundException, activity.activity.service.exception.ObjectNotFoundException;

    List<CommentViewModel> getAllComment(Long sportId) throws ObjectNotFoundException, activity.activity.service.exception.ObjectNotFoundException;
}
