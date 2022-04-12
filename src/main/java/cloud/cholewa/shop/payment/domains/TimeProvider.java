package cloud.cholewa.shop.payment.domains;

import java.time.Instant;

interface TimeProvider {

    Instant getTimestamp();
}
