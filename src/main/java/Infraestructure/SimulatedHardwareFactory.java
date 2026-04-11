package Infraestructure;

import Domain.Actuator;
import Domain.LightSensor;
import Domain.LightingZoneActuator;
import Domain.Sensor;

public class SimulatedHardwareFactory extends DeviceFactory {
    @Override
    public IHardwareComm getHardwareInterface() { return new ArduinoAdapter(); }
    @Override public Sensor createSensor(String type) { return new LightSensor(); }
    @Override public Actuator createActuator(String type) { return new LightingZoneActuator();}
}
