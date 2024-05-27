package com.solucar.application;

import com.solucar.domain.diagnostic.DiagnosticTroubleCode;
import com.solucar.infrastructure.obd.OBDAdapter;
import io.github.macfja.obd2.command.generic.Mode03;
import org.junit.jupiter.api.Test;
import ord.mockito.Mockito;

import java.beans.Transient;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiagnosticServiceTest {
    
    @Test 
    public void testGetDiagnosticTroubleCodes() throws IOException {
        // mock the OBD Adapter
        OBDAdapter obdAdapter = Mockito.mock(OBDAdapter.class);
        Mockito.when(obdAdapter.executerCommand(newMode03())).thenReturn("P0101,P0202");

        // Create the DiagnosticService with the mocked OBDAdapter
        DiagnosticService diagnosticService = new DiagnosticService(obdAdapter);

        // Call the getDiagnosticTroubleCodes method
        List<DiagnosticTroubleCode> dtcList = diagnosticService.getDiagnosticTroubleCodes();

        // Assert the results
        assertEquals(2, dtcList.size());
        assertEquals("P0101", dtcList.get(0).getCode());
        assertEquals("P0202", dtcList.get(1).getCode());
    }
}
