package Infraestructure;

// ArduinoAdapter.java (Adapter Pattern)
public class ArduinoAdapter implements IHardwareComm {
    @Override
    public void sendCommand(String cmd) { System.out.println("Arduino Received: " + cmd); }
    @Override
    public String readData() { return "LDR:300;PIR:1"; }
}