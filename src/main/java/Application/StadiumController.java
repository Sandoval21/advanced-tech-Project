package Application;

// StadiumController.java (Singleton Pattern)
public class StadiumController {
    private static StadiumController instance;
    private IStadiumModeStrategy modeStrategy;
    private List<IObserver> observers = new ArrayList<>();

    // State and Thresholds (Matching UML)
    private int entryThreshold;
    private int lightThreshold;
    private int entryCount;
    private int currentLightLevel;

    private StadiumController() {}

    public static synchronized StadiumController getInstance() {
        if (instance == null) instance = new StadiumController();
        return instance;
    }

    public void setMode(String mode) {
        if (mode.equals("AUTO")) this.modeStrategy = new AutoModeStrategy();
        // ... Logic for other modes
    }

    public void processSensorData(String data) {
        // Parse data and update currentLightLevel and entryCount
        notifyObservers();
        if (modeStrategy != null) modeStrategy.executeBehavior(this);
    }

    public void notifyObservers() {
        for (IObserver obs : observers) obs.update("System State Updated");
    }

    // Getters and Setters matching UML
    public int getEntryCount() { return entryCount; }
    public int getCurrentLightLevel() { return currentLightLevel; }
    public int getEntryThreshold() { return entryThreshold; }
    public int getLightThreshold() { return lightThreshold; }
    public void setEntryThreshold(int val) { this.entryThreshold = val; }
    public void setLightThreshold(int val) { this.lightThreshold = val; }

    public void toggleLight(String zone, boolean state) { /* Hardware Command */ }
    public void triggerAlarm(boolean state) { /* Hardware Command */ }
}

