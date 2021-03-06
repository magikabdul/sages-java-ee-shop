package cloud.cholewa.shop.payment.ports;

import cloud.cholewa.shop.commons.Page;
import cloud.cholewa.shop.commons.ResultPage;
import cloud.cholewa.shop.payment.domains.Payment;
import cloud.cholewa.shop.payment.domains.PaymentStatus;

import java.util.Optional;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> getById(String id);

    ResultPage<Payment> getByStatus(PaymentStatus status, Page page);
}
