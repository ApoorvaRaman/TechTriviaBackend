package com.techtrivia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {

    @GetMapping("/api/questions")
    public List<Map<String, Object>> getQuestions(String topic) {
        // Temporary demo questions
        return List.of(
            Map.of("q", "Which device is considered the 'brain' of the computer?", "opts", List.of("Hard Disk","CPU","RAM","Monitor"), "ans", 1),
            Map.of("q", "Which memory is volatile?", "opts", List.of("ROM","RAM","Hard Disk","DVD"), "ans", 1),
            Map.of("q", "Which keyword in C can be used to make a local variable retain its value?", "opts", List.of("const","volatile","static","extern"), "ans", 2)
        );
    }
}
