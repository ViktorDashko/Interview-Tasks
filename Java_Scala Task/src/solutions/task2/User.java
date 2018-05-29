package task2;

public class User {
    private String userName;
    private Integer level = 0;
    private Integer experience = 0;
    private UserSubscriptionType subscriptionType = UserSubscriptionType.FREE_USER;
    private Integer availableActions = subscriptionType.getNumberOfAllowedActions();
    private Integer paidDays = 0;

// Constructor to create new User
    public User(String userName) throws IncorrectUserNameException{
        String regex = "[a-zA-Z0-9\\._\\-]*";
        if (userName.matches(regex)) {
            this.userName = userName;
        }else {
            throw new IncorrectUserNameException();
        }
    }
// Constructor to create user with parameters from DB
    public User(String userName, Integer level, Integer experience, UserSubscriptionType subscriptionType,
                Integer availableActions, Integer paidDays) throws IncorrectUserNameException {
        this(userName);
        if(level < 0 || experience < 0 || availableActions < 0 || paidDays < 0){
            throw new IllegalArgumentException();
        }
        this.level = level;
        this.experience = experience;
        this.subscriptionType = subscriptionType;
        this.availableActions = availableActions;
        this.paidDays = paidDays;
    }

    public void refreshUser(){
        convertExperience();
        decreasePaidDays();
        refreshNumberOfActions();
    }

    private void convertExperience(){
        level += experience / 500;
        experience %= 500;
    }

    private void refreshNumberOfActions(){
        availableActions = subscriptionType.getNumberOfAllowedActions();
    }

    private void decreasePaidDays(){
        if (paidDays > 0){
            paidDays--;
        }
        if(paidDays == 0){
            subscriptionType = UserSubscriptionType.FREE_USER;
        }
    }

    public void decreaseAvailableOfActions(){
        availableActions--;
    }

    public void addExperience(int experience){
        this.experience += experience;
    }

    public void setSubscriptionType(UserSubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
        this.availableActions = subscriptionType.getNumberOfAllowedActions();
    }

    public void setPaidDays(Integer paidDays) {
        if(paidDays > 0) {
            this.paidDays = paidDays;
        }
    }

    public String getUserName() {
        return userName;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getExperience() {
        return experience;
    }

    public UserSubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public Integer getAvailableActions() {
        return availableActions;
    }

    public Integer getPaidDays() {
        return paidDays;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (obj instanceof User) {
            User otherUser = (User) obj;
            return this.userName.equals(otherUser.userName);
        }

        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", subscriptionType=" + subscriptionType +
                ", availableActions=" + availableActions +
                ", paidDays=" + paidDays +
                '}';
    }
}
