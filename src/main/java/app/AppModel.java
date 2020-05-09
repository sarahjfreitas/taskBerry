package app;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class AppModel {
    protected Instant createdIn;

    public Instant getCreatedIn() { return createdIn; }
    public void setCreatedIn(Instant createdIn) { this.createdIn = createdIn; }

    public String getFormattedCreatedIn(){
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        return DATE_TIME_FORMATTER.format(createdIn);
    }
}
