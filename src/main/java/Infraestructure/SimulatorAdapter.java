package Infraestructure;

public class SimulatorAdapter implements IHardwareComm {
    @Override
    public String readData() {
        // Aquí puedes simular que de vez en cuando alguien entra
        // Por ejemplo, devolver un string que el controlador entienda
        return "ENTRY:1";
    }

    @Override
    public void sendCommand(String cmd) {
        System.out.println("[SIMULADOR] Comando enviado al estadio: " + cmd);
    }
}
