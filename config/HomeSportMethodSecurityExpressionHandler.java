package activity.activity.config;

import activity.activity.service.SportService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;

import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class HomeSportMethodSecurityExpressionHandler
        extends DefaultMethodSecurityExpressionHandler {

    private final SportService sportService;

    public HomeSportMethodSecurityExpressionHandler(SportService sportService) {
        this.sportService = sportService;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, MethodInvocation invocation){

            OwnerSecurityExpressionRoot ownerSecurityExpressionRoot = new OwnerSecurityExpressionRoot(authentication);

            ownerSecurityExpressionRoot.setSportService(sportService);
            ownerSecurityExpressionRoot.setPermissionEvaluator(getPermissionEvaluator());
            ownerSecurityExpressionRoot.setTrustResolver(new AuthenticationTrustResolverImpl());
            ownerSecurityExpressionRoot.setRoleHierarchy(getRoleHierarchy());


            return ownerSecurityExpressionRoot;
    }
}
