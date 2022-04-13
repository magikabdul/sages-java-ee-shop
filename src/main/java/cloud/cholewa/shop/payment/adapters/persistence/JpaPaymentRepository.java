package cloud.cholewa.shop.payment.adapters.persistence;

import cloud.cholewa.shop.commons.Page;
import cloud.cholewa.shop.commons.ResultPage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class JpaPaymentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PaymentEntity save(PaymentEntity paymentEntity) {
        entityManager.persist(paymentEntity);
        return paymentEntity;
    }

    public Optional<PaymentEntity> getById(String id) {
        return Optional.ofNullable(entityManager.find(PaymentEntity.class, id));
    }

    public ResultPage<PaymentEntity> getByStatus(String status, Page page) {
        List<PaymentEntity> result = entityManager.createNamedQuery(PaymentEntity.GET_BY_STATUS, PaymentEntity.class)
                .setParameter("status", status)
                .setFirstResult(page.getOffset())
                .setMaxResults(page.size())
                .getResultList();

        Long count = entityManager.createNamedQuery(PaymentEntity.COUNT_BY_STATUS, Long.class)
                .setParameter("status", status)
                .getSingleResult();

        return new ResultPage<>(result, page.number(), (count / page.size()));
    }
}
