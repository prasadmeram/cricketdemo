package cricketcom.example.cricketdemo.service;


import cricketcom.example.cricketdemo.Model.CricketMatch;
import cricketcom.example.cricketdemo.Model.CricketResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CricketService {

    @Value("${cricket.api.url}")
    private String apiUrl;

    @Value("${cricket.api.key}")
    private String apiKey;

    public String fetchAndComputeMatchStats() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<CricketResponse> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, CricketResponse.class);
            CricketResponse cricketResponse = responseEntity.getBody();

            // **Consider logging the response body here for debugging:**
            // ObjectMapper mapper = new ObjectMapper();
            // System.out.println(mapper.writeValueAsString(responseEntity));

            if (cricketResponse == null || cricketResponse.getMatches() == null || cricketResponse.getMatches().isEmpty()) {
                return "No matches data found in the response.";
            }

            List<CricketMatch> matches = cricketResponse.getMatches();

            int highestScore = 0;
            String highestScoreTeam = "";
            int matchesOver300 = 0;

            for (CricketMatch match : matches) {
                int t1Score = match.getT1s();
                int t2Score = match.getT2s();
                int totalScore = t1Score + t2Score;

                if (t1Score > highestScore) {
                    highestScore = t1Score;
                    highestScoreTeam = match.getT1();
                }
                if (t2Score > highestScore) {
                    highestScore = t2Score;
                    highestScoreTeam = match.getT2();
                }

                if (totalScore > 300) {
                    matchesOver300++;
                }
            }

            return String.format("Highest Score: %d and Team Name is: %s\nNumber of Matches with total 300 Plus Score: %d",
                    highestScore, highestScoreTeam, matchesOver300);

        } catch (Exception e) {
            return "Error occurred while fetching cricket stats: " + e.getMessage();
        }
    }
}