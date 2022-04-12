package cloud.cholewa.shop.payment.domains;

import java.time.Instant;

public interface TimeProvider {

    Instant getTimestamp();
}
