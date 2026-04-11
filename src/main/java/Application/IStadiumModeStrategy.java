package Application;

// IStadiumModeStrategy.java (Strategy Pattern)
public interface IStadiumModeStrategy {
    void executeBehavior(StadiumController context, String sensorData);
}
