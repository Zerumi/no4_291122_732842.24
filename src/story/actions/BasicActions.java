package story.actions;

public enum BasicActions implements IActionable {
    EXIST("существует"),
    MATERIALIZE("материализуется"),
    FLYING("летит"),
    SWIMMING("плывет"),
    STAYING("располагается");

    private final String actionDescribe;
    BasicActions(String actionDescribe) {
        this.actionDescribe = actionDescribe;
    }
    @Deprecated
    public String getActionDescribe() {
        return actionDescribe;
    }

    @Override
    public String getAction() {
        return actionDescribe;
    }
}
