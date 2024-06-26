package com.solucar.infrastructure.obd;

import java.io.IOException;

import javax.bluetooth.*;
import io.github.macfja.obd2.Command;
import io.github.macfja.obd2.Response;
import io.github.macfja.obd2.command.engine.EngineRPM;
import io.github.macfja.obd2.command.vehicle_speed.VehicleSpeed;
import io.github.macfja.obd2.elm327.Commander;

// ... (autres imports)

public class OBDAdapter {

    private final Commander commander;

    public OBDAdapter(String connectionType, String deviceName) {
        this.commander = new Commander(connectionType, deviceName);
    }

    
    public void connect() throws IOException {
        //commander.connect();
        try {
            List<Device> devices = commander.getElm327Devices();
            if (devices.isEmpty()) {
                throw new IOException("No paired OBD-II device found");
            }

            Device device = devices.get(0);
            commander.connect(device);
        } catch (IOException e) {
            String errorMessage = "Error connecting to OBD-II device :" + e.getMessage();
            if (e.getMessage().contains("Service discovery failed")) {
                errorMessage = "Unable to discover OBD-II device. Please check if it's powered on and paired.";
            } else if (e.getMessage().contains("Connection refused")) {
                errorMessage = "Connection to OBD-II device was refused. Please check the device settings.";
            }
            throw new IOException(errorMessage,e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Connection to OBD-II device interrupted.",e);
        }
    }
    /**
     * Executes a given OBD command and returns the result.
     * 
     * @param command The OBD command to be executed.
     * @return The calculated result from the OBD command.
     * @throws IOException If there is an error in sending the command or if the command returns an error response.
     */
    public String executeCommand(Command command) throws IOException {
        Response response = commander.sendCommand(command);
        if (response.isError()) {
            throw new IOException("OBD command error: " + response.getError());
        }
        return response.getCalculatedResult();
    }

    public void disconnect() throws IOException {
        commander.close();
    }

    // ... (autres méthodes pour exécuter des commandes spécifiques)
}