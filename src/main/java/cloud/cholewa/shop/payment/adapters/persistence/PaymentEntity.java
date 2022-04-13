package cloud.cholewa.shop.payment.adapters.persistence;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@NamedQuery(name = PaymentEntity.GET_BY_STATUS, query = "SELECT p FROM payment p where p.status = :status")
@NamedQuery(name = PaymentEntity.COUNT_BY_STATUS, query = "SELECT count(p.id) from payment p where p.status = :status")
@Entity(name = "payment")
@Setter
@Getter
public class PaymentEntity {

    public static final String GET_BY_STATUS = "paymentGetByStatus";
    public static final String COUNT_BY_STATUS = "paymentCountByStatus";

    @Id
    private String id;
    private BigDecimal value;
    private String currency;
    private Instant timestamp;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
