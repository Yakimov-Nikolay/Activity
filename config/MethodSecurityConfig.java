package activity.activity.config;

import activity.activity.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private HomeSportMethodSecurityExpressionHandler homeSportMethodSecurityExpressionHandler;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return homeSportMethodSecurityExpressionHandler;
    }

    @Bean
    public HomeSportMethodSecurityExpressionHandler createExpressionHandler(SportService sportService){

        return new HomeSportMethodSecurityExpressionHandler(sportService);
    }

}
