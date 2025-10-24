package com.techtrivia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
public class QuestionController {

    @GetMapping("/api/questions")
    public List<Map<String, Object>> getQuestions(@RequestParam String topic) throws Exception {
        String fileName = "/questions/" + topic + ".json";
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) throw new RuntimeException("Topic not found: " + topic);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(is, List.class);
    }
}
