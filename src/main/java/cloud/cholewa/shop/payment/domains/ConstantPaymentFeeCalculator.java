package cloud.cholewa.shop.payment.domains;

import org.javamoney.moneta.FastMoney;

public record ConstantPaymentFeeCalculator(FastMoney fee) implements PaymentFeeCalculator {

    @Override
    public FastMoney calculate(FastMoney value) {
        return fee;
    }
}
