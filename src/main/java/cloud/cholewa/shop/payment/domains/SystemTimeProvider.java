package cloud.cholewa.shop.payment.domains;

import java.time.Instant;

public class SystemTimeProvider implements TimeProvider {
    @Override
    public Instant getTimestamp() {
        return Instant.now();
    }
}
