package Presentation;

import Application.StadiumFacade;

public class ConsoleUI implements Observer {
    private StadiumFacade facade = new StadiumFacade();

    public void start() {
        System.out.println("--- BELLO HORIZONTE 'REY PELE' SYSTEM START ---");
    }

    public void parseCommand(String cmd) {
        facade.processCommand(cmd);
    }

    public void displayDashboard() {
        System.out.println(facade.getDashboard());
    }

    @Override
    public void update(String msg) {
        System.out.println("[LIVE DATA UPDATE]: " + msg);
    }
}