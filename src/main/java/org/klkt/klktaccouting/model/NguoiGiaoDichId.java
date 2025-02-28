package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NguoiGiaoDichId implements Serializable {
    private String mst;
    private String mstKh;
    private String maNguoiGd;
}