package com.solucar.infrastructure.obd;

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
        commander.connect();
    }

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