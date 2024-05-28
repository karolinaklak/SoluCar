import com.solucar.application;

import com.solucar.domain.diagnostic.DiagnosticTroubleCode;
import com.solucar.infrastructure.obd.OBDAdapter;
import io.github.macfja.obd2.command.generic.Mode03;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosticService {
    private final OBDAdapter obdAdapter;

    // constructor

    public List<DiagnosticTroubleCode> getDiagnosticTroubleCodes() throws IOException{
        List<DiagnosticTroubleCode> dtcList = new ArrayList<>();

        try {
            obdAdapter.connect();
            String response = obdAdapter.executeCommand(new Mode03());

            for (String code : response.split(",")) {
                dtcList.add(new DiagnosticTroubleCode(code.trim()));
            }
        } catch (IOException e){
            System.err.println("Error reading DTCs : "+ e.getMessage());
            throw e;
        } finally {
            obdAdapter.disconnect();
        }
        return dtcList;
    }
}
