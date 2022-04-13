package cloud.cholewa.shop.payment.adapters.persistence;

import cloud.cholewa.shop.payment.domains.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface JpaPersistencePaymentMapper {

    @Mapping(target = "value", expression = "java(java.Math.BigDecimal.valueOf(payment.value().getNumber().doubleValueExact()))")
    @Mapping(target = "currency", expression = "java(payment.value().getCurrency().getCurrencyCode())")
    PaymentEntity toEntity(Payment payment);

    @Mapping(target = "value", expression = "java(FastMoney.of(entity.getValue(), entity.getCurrency()))")
    Payment toDomain(PaymentEntity entity);
}
