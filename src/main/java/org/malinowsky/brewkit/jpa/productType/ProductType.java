package org.malinowsky.brewkit.jpa.productType;

import lombok.*;
import org.hibernate.Hibernate;
import org.malinowsky.brewkit.jpa.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PRODUCT_TYPES")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productType", propOrder = {
        "name",
        "typeCode"
})
public class ProductType extends AbstractEntity {

    @XmlElement(required = true)
    @Column(name = "CODE", nullable = false, unique = true)
    private String typeCode;

    @XmlElement(required = true)
    @Column(nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductType that = (ProductType) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}