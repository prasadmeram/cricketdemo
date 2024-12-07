package cricketcom.example.cricketdemo.controller;

import cricketcom.example.cricketdemo.service.CricketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CricketController {
    private final CricketService cricketService;

    // Constructor-based injection
    public CricketController(CricketService cricketService) {
        this.cricketService = cricketService;
    }

    @GetMapping("/cricket-stats")  // Ensure there are no extra spaces or newline characters
    public String getCricketStats() {
        return cricketService.fetchAndComputeMatchStats();
    }
}
