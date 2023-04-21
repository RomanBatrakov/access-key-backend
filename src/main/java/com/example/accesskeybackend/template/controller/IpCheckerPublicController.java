package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.IpCheckerService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web/")
@AllArgsConstructor
public class IpCheckerPublicController {
    private final IpCheckerService ipCheckerService;

    @GetMapping("/checkIpv6Support")
    public Boolean checkIPv6Support(@NotNull @RequestParam("siteUrl") String siteUrl) {
        return ipCheckerService.checkIPv6Support(siteUrl);
    }
}
