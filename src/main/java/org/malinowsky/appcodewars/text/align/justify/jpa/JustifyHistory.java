package org.malinowsky.appcodewars.text.align.justify.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "JUSTIFY_HSTR")
@AllArgsConstructor
@NamedQuery(name = JustifyHistory.FIND_BY_UUID, query = "select j from JustifyHistory j where j.uuid = :id")
public class JustifyHistory {
    public static final String FIND_BY_UUID = "JustifyHistory.findByUUID";

    public JustifyHistory() {
    }

    public JustifyHistory(String uuid, String result) {
        this.uuid = uuid;
        this.result = result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID", nullable = false, length = 40)
    private String uuid;

    @Column(name = "RESULT", nullable = false, length = 10000)
    private String result;

}
