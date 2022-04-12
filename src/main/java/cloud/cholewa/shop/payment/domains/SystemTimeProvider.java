package cloud.cholewa.shop.payment.domains;

import java.time.Instant;

class SystemTimeProvider implements TimeProvider {
    @Override
    public Instant getTimestamp() {
        return Instant.now();
    }
}
