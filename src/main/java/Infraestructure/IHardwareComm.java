package Infraestructure;

public interface IHardwareComm {
    void sendCommand(String cmd);
    String readData();
}
