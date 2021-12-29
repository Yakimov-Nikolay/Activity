package activity.activity.config;

import activity.activity.service.SportService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class OwnerSecurityExpressionRoot
        extends SecurityExpressionRoot
        implements MethodSecurityExpressionOperations {

    private SportService sportService;
    private Object returnObject;
    private Object filterObject;

    public OwnerSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean isOwner(Long id) {
        String username = currentUserName();
        if (username != null) {
            return sportService.isOwner(username, id);
        }
        return false;
    }

    private String currentUserName() {
        Authentication auth = getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails){
            return ((UserDetails)((UserDetails) auth.getPrincipal())).getUsername();
        }
        return null;
    }

    public void setSportService(SportService sportService) {
        this.sportService = sportService;
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }
}
