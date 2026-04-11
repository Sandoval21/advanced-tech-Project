package Application;

// StadiumFacade.java (Facade Pattern)
public class StadiumFacade {
    private StadiumController controller = StadiumController.getInstance();

    public String getDashboard() {
        return "Stadium Status: OK | Mode: " + controller.getClass().getSimpleName();
    }

    public void processCommand(String cmd) {
        if (cmd.startsWith("MODE")) controller.setMode(cmd.split(" ")[1]);
        else if (cmd.startsWith("SET THRESHOLD")) controller.setEntryThreshold(Integer.parseInt(cmd.split(" ")[2]));
    }
}
