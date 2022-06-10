package org.malinowsky.appcodewars.pagination.helper;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Elements implements Serializable {
    private List<String> elements;
    private int pageSize;
    private int size;

    public Elements() {
        elements = new ArrayList<>();
    }
}
