package cloud.cholewa.shop.payment.domains;

import cloud.cholewa.shop.payment.ports.IdGenerator;
import cloud.cholewa.shop.payment.ports.PaymentFactory;
import cloud.cholewa.shop.payment.ports.PaymentRepository;
import cloud.cholewa.shop.payment.ports.PaymentService;
import org.javamoney.moneta.FastMoney;

public class DefaultPaymentFactory implements PaymentFactory {

    private final static PaymentFeeCalculator PAYMENT_FEE_CALCULATOR = new ConstantPaymentFeeCalculator(FastMoney.of(10, "PLN"));
    private final static TimeProvider TIME_PROVIDER = new SystemTimeProvider();

    @Override
    public PaymentService paymentService(IdGenerator idGenerator, PaymentRepository paymentRepository) {
        return new PaymentProcessor(idGenerator, PAYMENT_FEE_CALCULATOR, TIME_PROVIDER, paymentRepository);
    }

}
