package cloud.cholewa.shop.payment.domains;

import cloud.cholewa.shop.commons.Page;
import cloud.cholewa.shop.commons.ResultPage;
import cloud.cholewa.shop.payment.ports.IdGenerator;
import cloud.cholewa.shop.payment.ports.PaymentRepository;
import cloud.cholewa.shop.payment.ports.PaymentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public record PaymentProcessor(IdGenerator idGenerator,
                               PaymentFeeCalculator paymentFeeCalculator,
                               TimeProvider timeProvider,
                               PaymentRepository paymentRepository) implements PaymentService {


    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var paymentFee = paymentRequest.value();
        var payment = Payment.builder()
                .id(idGenerator.getNext())
                .value(paymentFee.add(paymentFeeCalculator.calculate(paymentFee)))
                .timestamp(timeProvider.getTimestamp())
                .status(PaymentStatus.STARTED)
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getById(String id) {
        return paymentRepository.getById(id)
                .orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, Page page) {
        return paymentRepository.getByStatus(status, page);
    }
}
