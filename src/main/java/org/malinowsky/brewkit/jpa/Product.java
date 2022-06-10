package org.malinowsky.brewkit.jpa;

import lombok.*;
import org.hibernate.Hibernate;
import org.malinowsky.brewkit.jpa.productType.ProductType;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product extends AbstractEntity {
    @Column(nullable = false, length = 128)
    private String name;
    @Column(nullable = false)
    private Long weight;
    private String description;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private ProductType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return getId() != null && Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
