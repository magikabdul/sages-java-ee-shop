package cloud.cholewa.shop.payment.ports;

public interface PaymentFactory {

    PaymentService paymentService(IdGenerator idGenerator, PaymentRepository paymentRepository);
}
