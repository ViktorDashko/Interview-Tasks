package task2;

public enum UserSubscriptionType {
    FREE_USER(3),
    PAID_USER(Integer.MAX_VALUE);

    private Integer numberOfAllowedActions;

    UserSubscriptionType(Integer numberOfAllowedActions) {
        this.numberOfAllowedActions = numberOfAllowedActions;
    }

    public Integer getNumberOfAllowedActions() {
        return numberOfAllowedActions;
    }
}
