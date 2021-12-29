package activity.activity.web;
import activity.activity.model.apoValidation.ApiError;
import activity.activity.model.binding.AddCommentBindingModel;
import activity.activity.model.service.CommentServiceModel;
import activity.activity.model.view.CommentViewModel;
import activity.activity.service.CommentService;
import activity.activity.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.*;

@RestController
public class CommentRestController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentRestController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/{sportId}/comments")
    public ResponseEntity<List<CommentViewModel>> getAllComments(
            @PathVariable Long sportId,
            Principal principal) throws ObjectNotFoundException {

        return ResponseEntity.ok(commentService.getAllComment(sportId));
    }

    @PostMapping("/api/{sportId}/comments")
    public ResponseEntity<CommentViewModel> newComment(
            @AuthenticationPrincipal UserDetails principal,
            @PathVariable Long sportId,
            @RequestBody @Valid AddCommentBindingModel addCommentBindingModel
    ) throws ObjectNotFoundException {
        CommentServiceModel commentServiceModel =
                modelMapper.map(addCommentBindingModel, CommentServiceModel.class);
        commentServiceModel.setAuthor(principal.getUsername());
        commentServiceModel.setSportId(sportId);

        CommentViewModel newComment = commentService.createComment(commentServiceModel);

        URI locationOfNewComment =
                URI.create(String.format("/api/%s/comments/%s", sportId, newComment.getId()));

        return ResponseEntity.created(locationOfNewComment).body(newComment);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onValidationFailure(MethodArgumentNotValidException exception) {

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        exception.getFieldErrors().forEach(fe -> apiError.addFieldWithError(fe.getField()));

        return ResponseEntity.badRequest().body(apiError);
    }


}
