package Domain;

public abstract class Sensor {
    protected String id;
    protected double value;
    public abstract double readValue();
}
