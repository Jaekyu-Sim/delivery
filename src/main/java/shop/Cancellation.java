package shop;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Cancellation_table")
public class Cancellation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;

    @PrePersist
    public void onPrePersist(){
        DeliveryCanceled deliveryCanceled = new DeliveryCanceled();
        BeanUtils.copyProperties(this, deliveryCanceled);
        deliveryCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }




}
