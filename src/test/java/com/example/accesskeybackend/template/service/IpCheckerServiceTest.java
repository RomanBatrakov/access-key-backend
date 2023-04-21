package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.IllegalArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IpCheckerServiceTest {
    private final IpCheckerService ipCheckerService = new IpCheckerService();

    @Test
    void checkIPv6SupportWithNotSupportedDomain_shouldFalse() {
        String host = "example.com";
        assertFalse(ipCheckerService.checkIPv6Support(host));
    }

    @Test
    void checkIPv6SupportWithNull_shouldFalse() {
        assertFalse(ipCheckerService.checkIPv6Support(null));
    }

    @Test
    void checkIPv6SupportWithEmpty_shouldFalse() {
        assertFalse(ipCheckerService.checkIPv6Support(""));
    }

    @Test
    void checkIPv6SupportWithInvalidDomain_shouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> ipCheckerService.checkIPv6Support("invalid_domain"));
    }
}