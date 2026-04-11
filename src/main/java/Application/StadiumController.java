package Application;

import Infraestructure.DeviceFactory;
import Infraestructure.IHardwareComm;
import Presentation.ConsoleUI;
import Presentation.Observer;

import java.util.ArrayList;
import java.util.List;

// StadiumController.java (Singleton Pattern)
public class StadiumController {
    private IStadiumModeStrategy modeStrategy;
    private List<Observer> observers = new ArrayList<>();
    private DeviceFactory hardwareFactory;
    private StadiumFacade facade;
    private IHardwareComm hardwareComm;
    private int entryThreshold;
    private int lightThreshold;
    private int entryCount;
    private int currentLightLevel;

    private static StadiumController instance;

    private StadiumController() {
        // Inicialización por defecto
        this.modeStrategy = new ManualModeStrategy();
    }

    public static StadiumController getInstance() {
        if (instance == null) instance = new StadiumController();
        return instance;
    }

    public void setMode(String mode) {
        if (mode.equalsIgnoreCase("AUTO")) this.modeStrategy = new AutoModeStrategy();
        else if (mode.equalsIgnoreCase("EMERGENCY")) this.modeStrategy = new EmergencyModeStrategy();
        else this.modeStrategy = new ManualModeStrategy();
    }

    public void setLightThreshold(int val) { this.lightThreshold = val; }
    public void setEntryThreshold(int val) { this.entryThreshold = val; }

    public void toggleLight(String zone, boolean state) {
        String cmd = "LIGHT:" + zone + ":" + (state ? "ON" : "OFF");
        if (hardwareComm != null) hardwareComm.sendCommand(cmd);
    }

    public void triggerAlarm(boolean state) {
        if (hardwareComm != null) hardwareComm.sendCommand("ALARM:" + (state ? "ON" : "OFF"));
    }

    public void processSensorData(String data) {
        // Procesa datos y ejecuta estrategia
        if (modeStrategy != null) modeStrategy.executeBehavior(this, data);
        notifyObservers(data);
    }

    public void addObserver(ConsoleUI obs) { observers.add(obs); }
    public void removeObserver(Observer obs) { observers.remove(obs); }

    private void notifyObservers(String msg) {
        for (Observer obs : observers) obs.update(msg);
    }

    public int getCurrentLightLevel() {
        return this.currentLightLevel; // Asegúrate de tener este atributo definido
    }

    public int getLightThreshold() {
        return this.lightThreshold;
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public int getEntryThreshold() {
        return this.entryThreshold;
    }
}
