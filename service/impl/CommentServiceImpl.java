package activity.activity.service.impl;

import activity.activity.model.entity.Commentaries;
import activity.activity.model.service.CommentServiceModel;
import activity.activity.model.view.CommentViewModel;
import activity.activity.repository.CommentsRepository;
import activity.activity.repository.SportRepository;
import activity.activity.repository.UserRepository;
import activity.activity.service.CommentService;
import activity.activity.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final SportRepository sportRepository;
    private final UserRepository userRepository;
    private final CommentsRepository commentsRepository;

    public CommentServiceImpl(SportRepository sportRepository, UserRepository userRepository, CommentsRepository commentsRepository) {
        this.sportRepository = sportRepository;
        this.userRepository = userRepository;
        this.commentsRepository = commentsRepository;
    }

    @Override
    public CommentViewModel createComment(CommentServiceModel commentServiceModel) throws ObjectNotFoundException {

        Objects.requireNonNull(commentServiceModel.getAuthor());

        var sport =
                sportRepository.findById(commentServiceModel.getSportId())
                        .orElseThrow(() -> new ObjectNotFoundException("Activity with id " + commentServiceModel.getSportId() + " not found!"));
        var author =
                userRepository.findByUsername(commentServiceModel.getAuthor())
                        .orElseThrow(() -> new ObjectNotFoundException("User with username " + commentServiceModel.getAuthor() + " not found!"));

        Commentaries newComment = new Commentaries();
        newComment.setApproved(true);
        newComment.setContent(commentServiceModel.getMessage());
        newComment.setCreated(LocalDateTime.now());
        newComment.setSport(sport);
        newComment.setAuthor(author);

        Commentaries savedComment = commentsRepository.save(newComment);
        return mapAsComment(savedComment);

    }

    @Transactional
    @Override
    public List<CommentViewModel> getAllComment(Long sportId) throws ObjectNotFoundException {

        var sportOpt =
                sportRepository.findById(sportId);

        if (sportOpt.isEmpty()) {
            throw new ObjectNotFoundException("Sport whit id" + sportId + " was not found!");
        }
        return sportOpt
                .get()
                .getComments()
                .stream()
                .map(this::mapAsComment)
                .collect(Collectors.toList());
    }

    private CommentViewModel mapAsComment(Commentaries commentEntity) {
        CommentViewModel commentViewModel = new CommentViewModel();
        commentViewModel.setId(commentEntity.getId())
                .setCanApprove(true)
                .setCanDelete(true)
                .setCreated(commentEntity.getCreated())
                .setMessage(commentEntity.getContent())
                .setUser(commentEntity.getAuthor().getUsername());

        return commentViewModel;
    }
}
