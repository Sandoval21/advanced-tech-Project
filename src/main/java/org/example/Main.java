package org.example;
import Application.StadiumController;
import Presentation.ConsoleUI;


public class Main {
    public static void main(String[] args) {
        StadiumController controller = StadiumController.getInstance();
        ConsoleUI ui = new ConsoleUI();
        controller.addObserver(ui);

        // CONFIGURACIÓN INICIAL
        controller.setMode("AUTO");        // Activamos la estrategia automática
        controller.setEntryThreshold(5);   // El límite es de 5 personas

        // SIMULACIÓN
        for(int i = 1; i <= 7; i++) {
            System.out.println("\n--- Simulando paso de persona " + i + " ---");
            controller.processSensorData("ENTRY:1");

            try {
                Thread.sleep(1000); // Esperamos un segundo entre cada una
            } catch (InterruptedException e) { e.printStackTrace(); }
        }}
}