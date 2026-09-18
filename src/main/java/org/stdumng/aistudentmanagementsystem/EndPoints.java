package org.stdumng.aistudentmanagementsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPoints {
    private final AiLayer aiLayer;
    public EndPoints(AiLayer aiLayer) {
        this.aiLayer = aiLayer;
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody String prompt){
        return aiLayer.operate(prompt);
    }
    @GetMapping("/getStudent")
    public String getStudent(@RequestBody String prompt){
        return aiLayer.operate(prompt);
    }
}
