package com.techtrivia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/api/demo")
    public List<Map<String, Object>> getDemoQuestions() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = getClass().getResourceAsStream("/questions/tech.json");
        List<Map<String, Object>> allQuestions = mapper.readValue(is, List.class);
        return allQuestions.subList(0, Math.min(10, allQuestions.size())); // first 10
    }
}
