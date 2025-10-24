package com.techtrivia.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")  // base path
public class QuestionController {

    @GetMapping("/questions") // full path = /api/questions
    public List<Map<String, Object>> getQuestions(@RequestParam String topic) throws IOException {
        String fileName = switch(topic) {
            case "tech" -> "tech.json";
            case "programming" -> "programming.json";
            case "dsa" -> "dsa.json";
            default -> "tech.json";
        };

        InputStream is = getClass().getClassLoader().getResourceAsStream("questions/" + fileName);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, List.class);
    }
}
