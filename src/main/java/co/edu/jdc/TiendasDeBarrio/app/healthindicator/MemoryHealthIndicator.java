package co.edu.jdc.TiendasDeBarrio.app.healthindicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MemoryHealthIndicator implements HealthIndicator {

        @Override
        public Health health() {
            long freeMemory = Runtime.getRuntime().freeMemory();
            long totalMemory = Runtime.getRuntime().totalMemory();
            double freeMemoryPercentage = (double) freeMemory / totalMemory;
            if (freeMemoryPercentage > 25) {
                return Health.up()
                        .withDetail("freeMemory", freeMemory + " bytes")
                        .withDetail("totalMemory", totalMemory + " bytes")
                        .withDetail("freeMemoryPercentage", freeMemoryPercentage+ "%")
                        .build();

            }else{
                return Health.down()
                        .withDetail("freeMemory", freeMemory + " bytes")
                        .withDetail("totalMemory", totalMemory + " bytes")
                        .withDetail("freeMemoryPercentage", freeMemoryPercentage+ "%")
                        .build();
            }
        }
}
