package activity.activity.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="statistics")
public class Statistic extends BaseEntity{
    private Long logTime;
    private int authenticatedRequest;
    private int anonymousRequest;
    private int requestOnFuelAdd;
    private int getRequestOnExpenseAdd;

    public Statistic() {
    }

    public Long getLogTime() {
        return logTime;
    }

    public Statistic setLogTime(Long logTime) {
        this.logTime = logTime;
        return this;
    }

    public int getAuthenticatedRequest() {
        return authenticatedRequest;
    }

    public Statistic setAuthenticatedRequest(int authenticatedRequest) {
        this.authenticatedRequest = authenticatedRequest;
        return this;
    }

    public int getAnonymousRequest() {
        return anonymousRequest;
    }

    public Statistic setAnonymousRequest(int anonymousRequest) {
        this.anonymousRequest = anonymousRequest;
        return this;
    }

    public int getRequestOnFuelAdd() {
        return requestOnFuelAdd;
    }

    public Statistic setRequestOnFuelAdd(int requestOnFuelAdd) {
        this.requestOnFuelAdd = requestOnFuelAdd;
        return this;
    }

    public int getGetRequestOnExpenseAdd() {
        return getRequestOnExpenseAdd;
    }

    public Statistic setGetRequestOnExpenseAdd(int getRequestOnExpenseAdd) {
        this.getRequestOnExpenseAdd = getRequestOnExpenseAdd;
        return this;
    }

}
