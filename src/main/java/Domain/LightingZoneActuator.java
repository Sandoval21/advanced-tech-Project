package Domain;

public class LightingZoneActuator extends Actuator {
    @Override
    public void turnOn() { this.state = true; }
    @Override
    public void turnOff() { this.state = false; }
}
