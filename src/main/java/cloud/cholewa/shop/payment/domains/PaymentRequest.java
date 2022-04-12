package cloud.cholewa.shop.payment.domains;

import org.javamoney.moneta.FastMoney;

public record PaymentRequest(Long id, FastMoney value) {
}
