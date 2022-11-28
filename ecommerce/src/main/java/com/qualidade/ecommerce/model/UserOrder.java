package com.qualidade.ecommerce.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_order")

public class UserOrder {

    @EmbeddedId
    @JsonIgnore
    private UserOrderPK pk;

    public UserOrder() {
        super();
    }

    public UserOrder(User user, Order order) {
        pk = new UserOrderPK();
        pk.setOrder(order);
        pk.setUser(user);
    }

    @Transient
    public User getUser() {
        return this.pk.getUser();
    }

    public UserOrderPK getPk() {
        return pk;
    }

    public void setPk(UserOrderPK pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserOrder other = (UserOrder) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }
}
