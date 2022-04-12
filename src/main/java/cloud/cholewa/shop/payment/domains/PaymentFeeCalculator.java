package cloud.cholewa.shop.payment.domains;

import org.javamoney.moneta.FastMoney;

public interface PaymentFeeCalculator {

    FastMoney calculate(FastMoney value);
}
