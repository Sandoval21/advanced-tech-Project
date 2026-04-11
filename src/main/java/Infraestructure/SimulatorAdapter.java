package Infraestructure;

public class SimulatorAdapter implements IHardwareComm {
    @Override
    public void sendCommand(String cmd) { System.out.println("Simulator Received: " + cmd); }
    @Override
    public String readData() { return "SIM_DATA"; }
}
