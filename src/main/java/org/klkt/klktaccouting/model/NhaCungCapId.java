package org.klkt.klktaccouting.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhaCungCapId implements Serializable {
    @Column(name = "ID", length = 20)
    private String id;

    @Column(name = "MST", length = 15)
    private String mst;
}
