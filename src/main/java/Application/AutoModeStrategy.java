package Application;

public class AutoModeStrategy implements IStadiumModeStrategy {
    @Override
    public void executeBehavior(StadiumController context,String sensorData) {
        // Logic for Light Threshold
        if (context.getCurrentLightLevel() < context.getLightThreshold()) {
            context.toggleLight("ZONE_A", true);
        }

        // Logic for Entry/Security Threshold
        if (context.getEntryCount() > context.getEntryThreshold()) {
            context.triggerAlarm(true);
        }
    }
}
