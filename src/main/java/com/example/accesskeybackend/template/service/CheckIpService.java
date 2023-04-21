package com.example.accesskeybackend.template.service;

import com.example.accesskeybackend.exception.IpReachabilityException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;

@Log4j2
@Service
public class CheckIpService {
    public static final int TIMEOUT = 2000;
    public static final String PATTERN_FOR_DOMAIN = "http(s)?://|www\\.|/.*";

    public boolean checkIpv6Support(String siteUrl) {
        try {
            String domainName = siteUrl.replaceAll(PATTERN_FOR_DOMAIN, ""); // extract domain name from url
            InetAddress[] addresses = InetAddress.getAllByName(domainName);
            for (InetAddress address : addresses) {
                if (address instanceof java.net.Inet6Address) {
                    if (address.isReachable(TIMEOUT)) {
                        log.info("IPv6 is supported by the site: " + siteUrl);
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            throw new IpReachabilityException(e);
        }
        return false;
    }
}
