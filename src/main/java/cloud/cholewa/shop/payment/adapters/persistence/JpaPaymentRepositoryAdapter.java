package cloud.cholewa.shop.payment.adapters.persistence;

import cloud.cholewa.shop.commons.Page;
import cloud.cholewa.shop.commons.ResultPage;
import cloud.cholewa.shop.payment.domains.Payment;
import cloud.cholewa.shop.payment.domains.PaymentStatus;
import cloud.cholewa.shop.payment.ports.PaymentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public record JpaPaymentRepositoryAdapter(JpaPaymentRepository paymentRepository,
                                          JpaPersistencePaymentMapper paymentMapper) implements PaymentRepository {

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = paymentRepository.save(paymentMapper.toEntity(payment));
        return paymentMapper.toDomain(entity);
    }

    @Override
    public Optional<Payment> getById(String id) {
        return paymentRepository.getById(id)
                .map(paymentMapper::toDomain);
    }

    @Override
    public ResultPage<Payment> getByStatus(PaymentStatus status, Page page) {
        ResultPage<PaymentEntity> resultPage = paymentRepository.getByStatus(status.name(), page);
        List<Payment> payments = resultPage.data().stream().map(paymentMapper::toDomain).toList();
        return resultPage.with(payments);
    }
}
