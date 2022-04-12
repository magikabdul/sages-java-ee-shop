package cloud.cholewa.shop.ports;

import cloud.cholewa.shop.commons.Page;
import cloud.cholewa.shop.commons.ResultPage;
import cloud.cholewa.shop.domains.Payment;
import cloud.cholewa.shop.domains.PaymentRequest;
import cloud.cholewa.shop.domains.PaymentStatus;

public interface PaymentService {

    Payment process(PaymentRequest paymentRequest);

    Payment getById(String id);

    ResultPage<Payment> getByStatus(PaymentStatus status, Page page);
}
