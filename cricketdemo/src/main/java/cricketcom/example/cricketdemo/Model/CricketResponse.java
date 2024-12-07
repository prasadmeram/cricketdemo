package cricketcom.example.cricketdemo.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CricketResponse {

    private List<CricketMatch> matches;

    public List<CricketMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<CricketMatch> matches) {
        this.matches = matches;
    }
}