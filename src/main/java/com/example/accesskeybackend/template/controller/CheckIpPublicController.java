package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.CheckIpService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/web/")
@AllArgsConstructor
public class CheckIpPublicController {

    private final CheckIpService checkIpService;

    @GetMapping("/checkIpv6Support")
    public Map<String, Boolean> checkIpv6Support(@RequestParam("siteUrl") final String siteUrl) {
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", checkIpService.checkIpv6Support(siteUrl));
        return response;
    }
}
