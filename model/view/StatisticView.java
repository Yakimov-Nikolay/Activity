package activity.activity.model.view;

public class StatisticView {

    private final int authRequests;
    private final int anonymousRequests;

    public StatisticView(int authRequests, int anonymousRequests) {
        this.authRequests = authRequests;
        this.anonymousRequests = anonymousRequests;
    }

    public int getTotalRequests(){
        return authRequests + anonymousRequests;
    }

    public int getAuthRequests() {
        return authRequests;
    }


    public int getAnonymousRequests() {
        return anonymousRequests;
    }
}
