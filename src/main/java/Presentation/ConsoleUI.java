package Presentation;

import Application.StadiumFacade;

public class ConsoleUI implements Observer {
    private StadiumFacade facade = new StadiumFacade();

    public void start() {
        System.out.println("--- BELLO HORIZONTE 'REY PELE' SYSTEM START ---");
    }

    public void parseCommand(String cmd) {
        if (cmd.equals("SIMULATE ENTRY")) {
            // Simulamos que el hardware envió la señal de una persona
            facade.simulatePersonEntry();
        }
    }

    public void update(String msg) {
        System.out.println(">>> ACTUALIZACIÓN: " + msg);
        displayDashboard();
    }

    private void displayDashboard() {
        System.out.println("\n========================================");
        System.out.println("   ESTADIO BELLO HORIZONTE 'REY PELE'   ");
        System.out.println("           ESTADO DEL SISTEMA           ");
        System.out.println("========================================");

    // Obtenemos los datos a través de la Fachada
        String data = facade.getDashboard();
        System.out.println(data);

        System.out.println("========================================\n");
    }
}