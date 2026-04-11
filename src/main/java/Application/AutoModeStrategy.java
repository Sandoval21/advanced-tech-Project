package Application;

public class AutoModeStrategy implements IStadiumModeStrategy {
    @Override
    public void executeBehavior(StadiumController context, String sensorData) {
        // Verificamos si el conteo actual superó el umbral definido
        if (context.getEntryCount() > context.getEntryThreshold()) {
            context.triggerAlarm(true);
        } else {
            context.triggerAlarm(false);
        }
    }
}
