package Application;

// StadiumFacade.java (Facade Pattern)
public class StadiumFacade {
    private StadiumController controller = StadiumController.getInstance();

    public String getDashboard() {
        return String.format(
                " > OCUPACIÓN ACTUAL: %d personas\n" +
                        " > NIVEL DE LUZ:    %d\n" +
                        " > MODO ACTIVO:     %s",
                controller.getEntryCount(),      // Corresponde al primer %d
                controller.getCurrentLightLevel(), // Corresponde al segundo %d
                "MODO MANUAL"                     // Corresponde al %s
        );
    }

    public void simulatePersonEntry() {
        // Le pasamos al controlador la cadena que el Arduino enviaría
        controller.processSensorData("ENTRY:1");
    }
}
