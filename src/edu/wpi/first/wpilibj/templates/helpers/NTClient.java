/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.helpers;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.io.IOException;

/**
 *
 * @author profplump
 */
public class NTClient {

    static {
        try {
            NetworkTable.setTeam(4030);
            NetworkTable.setClientMode();
            NetworkTable.initialize();
        } catch (IOException ex) {
            System.err.println("No network tables for you");
        }
    }
    static NetworkTable table = NetworkTable.getTable("SmartDashboard");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        double bob = table.getNumber("Bob Pull");
        table.putNumber("Bob Put", bob);
    }
}
