package org.klkt.klktaccouting.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VatTuHangHoaId implements Serializable {
    private String mst;
    private String sohieuTK;
    private String maKho;
    private String maNhom;
    private String maVattu;
}
