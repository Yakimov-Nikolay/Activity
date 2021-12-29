package activity.activity.service;


import activity.activity.model.view.StatisticView;

public interface StatisticService {

    void onRequest();
    StatisticView getStat();
}
