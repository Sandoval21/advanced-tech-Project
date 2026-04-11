package Application;

public class ManualModeStrategy implements IStadiumModeStrategy {

    @Override
    public void executeBehavior(StadiumController context,String sensorData) {
        System.out.println("Manual Mode: Waiting for user commands.");
    }
}
