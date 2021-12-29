package activity.activity.service.impl;

import activity.activity.model.view.StatisticView;
import activity.activity.service.StatisticService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    private int anonymousRequests, authRequests;

    @Override
    public void onRequest() {
       Authentication auth
               =  SecurityContextHolder.getContext().getAuthentication();

       if (auth != null && (auth.getPrincipal() instanceof UserDetails)){
           authRequests++;
       }else{
           anonymousRequests++;
       }
    }

    @Override
    public StatisticView getStat() {
        return new StatisticView(authRequests, anonymousRequests);
    }
}
