package activity.activity.web;
import activity.activity.service.StatisticService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class StatsInterceptor implements HandlerInterceptor {

    private final StatisticService statisticService;

    public StatsInterceptor(StatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        statisticService.onRequest();
        return true;
    }
}
