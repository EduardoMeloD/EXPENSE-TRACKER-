package com.eduardomelo.EXPENSE_TRACKER.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = Costs.TABLE_NAME)
public class Costs{

    public static final String TABLE_NAME="costs";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;
    @Column(name = "description", length = 300, nullable = true)
    private String description;
    @Column(name = "amount", nullable = false)
    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;


    public Costs() {
    }

    public Costs(Long id, User user, String description, BigDecimal amount) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.amount = amount;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Costs id(Long id) {
        setId(id);
        return this;
    }

    public Costs user(User user) {
        setUser(user);
        return this;
    }

    public Costs description(String description) {
        setDescription(description);
        return this;
    }

    public Costs amount(BigDecimal amount) {
        setAmount(amount);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Costs))
            return false;
        Costs other = (Costs) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;

        return Objects.equals(this.user, other.user)
                && Objects.equals(this.description, other.description)
                && Objects.equals(this.amount, other.amount);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    
    
}