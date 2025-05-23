package com.springProject.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springProject.course.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id;

    private Integer quantity;
    private Double price;

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public Double getSubTotal(){
        return price * quantity;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
