package org.malinowsky.appcodewars.java.ee.events;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SimpleEvent implements Serializable {
    private String data;
}
