package com.example.account.util;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AccountHealthCheck implements HealthIndicator {

    int counter;
    @Override
    public Health getHealth(boolean includeDetails) {
        return null;
    }

    @Override
    public Health health() {
        counter++;
        if(counter>2 && counter <5)
        return Health.down().withDetail("Account service not working:",counter).build();
        return Health.up().build();
    }
}
