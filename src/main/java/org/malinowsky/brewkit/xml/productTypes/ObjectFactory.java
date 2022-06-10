//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.06.07 at 07:20:54 PM CEST 
//


package org.malinowsky.brewkit.xml.productTypes;

import org.malinowsky.brewkit.jpa.productType.ProductType;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.malinowsky.brewkit.xml.productType package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProductTypes_QNAME = new QName("", "productTypes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.malinowsky.brewkit.xml.productType
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductTypes }
     * 
     */
    public ProductTypes createProductTypes() {
        return new ProductTypes();
    }

    /**
     * Create an instance of {@link ProductType }
     * 
     */
    public ProductType createProductType() {
        return new ProductType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "productTypes")
    public JAXBElement<ProductTypes> createProductTypes(ProductTypes value) {
        return new JAXBElement<ProductTypes>(_ProductTypes_QNAME, ProductTypes.class, null, value);
    }

}