package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.IllegalArgumentException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
@AllArgsConstructor
@Log4j2
public class IpCheckerService {
    public Boolean checkIPv6Support(String siteUrl) {
        boolean isIpv6Supported = false;
        try {
            InetAddress[] inetAddresses = InetAddress.getAllByName(siteUrl);
            for (InetAddress address : inetAddresses) {
                if (address instanceof Inet6Address) {
                    isIpv6Supported = true;
                    break;
                }
            }
        } catch (UnknownHostException ex) {
            throw new IllegalArgumentException("Некорректный Url");
        }
        return isIpv6Supported;
    }
}
