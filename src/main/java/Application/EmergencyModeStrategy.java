package Application;

public class EmergencyModeStrategy implements IStadiumModeStrategy {
    @Override
    public void executeBehavior(StadiumController context, String sensorData) {
        context.triggerAlarm(true);
        context.toggleLight("ALL", true);
    }
}