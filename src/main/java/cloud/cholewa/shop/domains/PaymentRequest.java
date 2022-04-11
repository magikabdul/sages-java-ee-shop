package cloud.cholewa.shop.domains;

import org.javamoney.moneta.FastMoney;

public record PaymentRequest(Long id, FastMoney value) {
}
