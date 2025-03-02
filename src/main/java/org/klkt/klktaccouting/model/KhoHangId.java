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
public class KhoHangId implements Serializable {

    @Column(name = "MST", length = 15, nullable = false)
    private String mst;

    @Column(name = "SohieuTK", length = 10, nullable = false)
    private String soHieuTK;
}
