package org.klkt.klktaccouting.model;

import java.io.Serializable;
import java.util.Objects;

public class TaiKhoanId implements Serializable {
    private String mst;
    private String soHieuTK;

    public TaiKhoanId() {}

    public TaiKhoanId(String mst, String soHieuTK) {
        this.mst = mst;
        this.soHieuTK = soHieuTK;
    }

    public String getMst() {
        return mst;
    }

    public void setMst(String mst) {
        this.mst = mst;
    }

    public String getSoHieuTK() {
        return soHieuTK;
    }

    public void setSoHieuTK(String soHieuTK) {
        this.soHieuTK = soHieuTK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoanId that = (TaiKhoanId) o;
        return Objects.equals(mst, that.mst) && Objects.equals(soHieuTK, that.soHieuTK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mst, soHieuTK);
    }
}
