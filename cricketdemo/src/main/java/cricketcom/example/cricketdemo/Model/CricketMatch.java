package cricketcom.example.cricketdemo.Model;

public class CricketMatch {
    private String id;
    private String dateTimeGMT;
    private String matchType;
    private String status;
    private String ms;
    private String t1;
    private String t2;
    private int t1s;
    private int t2s;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDateTimeGMT() { return dateTimeGMT; }
    public void setDateTimeGMT(String dateTimeGMT) { this.dateTimeGMT = dateTimeGMT; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMs() { return ms; }
    public void setMs(String ms) { this.ms = ms; }

    public String getT1() { return t1; }
    public void setT1(String t1) { this.t1 = t1; }

    public String getT2() { return t2; }
    public void setT2(String t2) { this.t2 = t2; }

    public int getT1s() { return t1s; }
    public void setT1s(int t1s) { this.t1s = t1s; }

    public int getT2s() { return t2s; }
    public void setT2s(int t2s) { this.t2s = t2s; }
}
