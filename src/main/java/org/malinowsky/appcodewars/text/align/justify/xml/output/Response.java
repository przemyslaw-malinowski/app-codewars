package org.malinowsky.appcodewars.text.align.justify.xml.output;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {
    "quantity",
    "results"
})
public class Response {

    @XmlElement(required = true)
    protected Integer quantity;
    @XmlElement(required = true)
    protected Results results;

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer value) {
        this.quantity = value;
    }
    public Results getResults() {
        return results;
    }
    public void setResults(Results value) {
        this.results = value;
    }

}
