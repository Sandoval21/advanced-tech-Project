package Infraestructure;

import Domain.Actuator;
import Domain.Sensor;

// DeviceFactory.java (Factory Method Pattern)
public abstract class DeviceFactory {
    public abstract Sensor createSensor(String type);
    public abstract Actuator createActuator(String type);
    public abstract IHardwareComm getHardwareInterface();
}

