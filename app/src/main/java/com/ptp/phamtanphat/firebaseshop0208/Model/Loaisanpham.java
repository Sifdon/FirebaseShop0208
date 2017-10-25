package com.ptp.phamtanphat.firebaseshop0208.Model;

/**
 * Created by KhoaPhamPC on 25/10/2017.
 */

public class Loaisanpham {
    private String IDLoaiSP;
    private String TenLoaiSP;
    private String HinhLoaiSP;

    public Loaisanpham() {
    }

    public Loaisanpham(String IDLoaiSP, String tenLoaiSP, String hinhLoaiSP) {
        this.IDLoaiSP = IDLoaiSP;
        TenLoaiSP = tenLoaiSP;
        HinhLoaiSP = hinhLoaiSP;
    }

    public String getIDLoaiSP() {
        return IDLoaiSP;
    }

    public void setIDLoaiSP(String IDLoaiSP) {
        this.IDLoaiSP = IDLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        TenLoaiSP = tenLoaiSP;
    }

    public String getHinhLoaiSP() {
        return HinhLoaiSP;
    }

    public void setHinhLoaiSP(String hinhLoaiSP) {
        HinhLoaiSP = hinhLoaiSP;
    }
}
