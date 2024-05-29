import com.solucar.domain.diagnostic;

public class DiagnosticCode {
    private final String code;
    private String description;
    private String severity;
    private String possibleCauses;

    public DiagnosticCode(String code){
        this.code = code;
        fetchDetails();
    }

    //TO DO : replace this with a database lookup or external API call
        
    private void fetchDetails(){
        
    }
    //getters
    public String getCode(){
        return code;
    }

    public String getDescription(){
        return description;
    }

    public String getSeverity(){
        return severity;
    }

    public String getPossibleCauses(){
        return possibleCauses;
    }

    @Override
    public String toString(){
        return "DC : "+ code + "-" + description + "("+ severity + ")";
    }

}
