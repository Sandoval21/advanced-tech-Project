package Domain;

public abstract class Actuator {
    protected String id;
    protected boolean state;
    public abstract void turnOn();
    public abstract void turnOff();
}
