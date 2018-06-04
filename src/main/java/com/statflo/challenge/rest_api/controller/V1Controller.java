package com.statflo.challenge.rest_api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
@RequestMapping("/v1/users")
public class V1Controller {

    /**
     * @TODO: Fix me
     */
    @GetMapping(value = "/{id}")
    public String fetch(@PathVariable("id") String id) {
        return "{\"id\": \"977e3f5b-6a70-4862-9ff8-96af4477272a\", \"name\": \"foo\", \"role\": \"bar\"}";
    }

    /**
     * @TODO: Fix me
     */
    @GetMapping()
    public String find(@RequestParam Map<String, Object> criteria) {
        return "[{\"id\": \"977e3f5b-6a70-4862-9ff8-96af4477272a\", \"name\": \"foo\", \"role\": \"bar\"}]";
    }

    /**
     * @TODO: Fix me
     */
    @PostMapping()
    public String create(String body) {
        return "{\"id\": \"977e3f5b-6a70-4862-9ff8-96af4477272a\", \"name\": \"foo\", \"role\": \"bar\"}";
    }

    /**
     * @TODO: Fix me
     */
    @PatchMapping(value = "/{id}")
    public String patch(@PathVariable("id") String id, String body) {
        return "{\"id\": \"977e3f5b-6a70-4862-9ff8-96af4477272a\", \"name\": \"foo bar\", \"role\": \"bar\"}";
    }
}
