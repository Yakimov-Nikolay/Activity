package activity.activity.model.binding;

import javax.validation.constraints.Size;

public class AddCommentBindingModel {

    private String message;

    public AddCommentBindingModel() {
    }

    @Size(min = 10)
    public String getMessage() {
        return message;
    }

    public AddCommentBindingModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
