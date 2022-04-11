package cloud.cholewa.shop.domains;

import lombok.Builder;
import org.javamoney.moneta.FastMoney;

import java.time.Instant;

@Builder
public record Payment(String id,
                      FastMoney value,
                      Instant timestamp,
                      PaymentStatus status) {
}
