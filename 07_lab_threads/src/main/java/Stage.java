public abstract class Stage {
    protected int length;
    protected String description;
    protected String stageType;

    public String getDescription() {
        return description;
    }

    public String getStageType() {
        return stageType;
    }

    public abstract void go(Car c);

}
