package javanotificacion;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class Javanotificacion {

    public static void main(String[] args) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("icono.png");

            TrayIcon trayIcon = new TrayIcon(image, "Esta es una prueba de notificacion");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Mensaje de notificación");

            try {
                tray.add(trayIcon);
                trayIcon.displayMessage("Esta es una notificacion con java",
                        "Has recibido un mensaje", MessageType.INFO);
                
                // Espera 5 segundos antes de finalizar el programa
                Thread.sleep(5000);
                
                // Elimina el icono de la bandeja
                tray.remove(trayIcon);
                
                // Finaliza el programa
                System.exit(0);
            } catch (AWTException | InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("El sistema no soporta notificaciones de sistema.");
        }
    }
}
