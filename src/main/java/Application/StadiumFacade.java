package Application;

// StadiumFacade.java (Facade Pattern)
public class StadiumFacade {
    private StadiumController controller = StadiumController.getInstance();

    public void processCommand(String cmd) {
        if (cmd.startsWith("SET THRESHOLD")) {
            int val = Integer.parseInt(cmd.split(" ")[2]);
            controller.setEntryThreshold(val);
        }
    }
}
