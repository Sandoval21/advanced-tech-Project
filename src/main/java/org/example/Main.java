package org.example;
import Application.StadiumController;
import Presentation.ConsoleUI;


public class Main {
    public static void main(String[] args) {
        // 1. Obtener el controlador (Singleton)
        StadiumController controller = StadiumController.getInstance();

        // 2. Crear la interfaz de usuario
        ConsoleUI gui = new ConsoleUI();

        // 3. Suscribir la interfaz a los cambios (Observer)
        controller.addObserver(gui);

        // 4. Iniciar el sistema
        gui.start();

        // 5. Simular entrada de datos
        controller.setMode("AUTO");
        controller.setEntryThreshold(10);
        controller.processSensorData("L:200|P:5"); // Esto disparará la lógica

        gui.displayDashboard();
    }
}