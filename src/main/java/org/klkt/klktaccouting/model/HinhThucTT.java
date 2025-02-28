package org.klkt.klktaccouting.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbldmhinhthuctt", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HinhThucTT {

    @Id
    @Column(name = "Ma_HTTT", length = 50, nullable = false)
    private String maHTTT;

    @Column(name = "Ten_HTTT", length = 50)
    private String tenHTTT;

    @Column(name = "STT")
    private Integer stt;

    @Column(name = "Ten_HTTT_HDDT_VNPT", length = 100)
    private String tenHTTTHDDTVNPT;
}
