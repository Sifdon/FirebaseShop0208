package com.ptp.phamtanphat.firebaseshop0208.Model;

/**
 * Created by KhoaPhamPC on 25/10/2017.
 */

public class Sanpham {
    private String Idloaisp;
    private String Idsp;
    private String Tensp;
    private String Giasp;
    private String Hinhanhsp;
    private String Motasp;

    public Sanpham() {
    }

    public Sanpham(String idloaisp, String idsp, String tensp, String giasp, String hinhanhsp, String motasp) {
        Idloaisp = idloaisp;
        Idsp = idsp;
        Tensp = tensp;
        Giasp = giasp;
        Hinhanhsp = hinhanhsp;
        Motasp = motasp;
    }

    public String getIdloaisp() {
        return Idloaisp;
    }

    public void setIdloaisp(String idloaisp) {
        Idloaisp = idloaisp;
    }

    public String getIdsp() {
        return Idsp;
    }

    public void setIdsp(String idsp) {
        Idsp = idsp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public String getGiasp() {
        return Giasp;
    }

    public void setGiasp(String giasp) {
        Giasp = giasp;
    }

    public String getHinhanhsp() {
        return Hinhanhsp;
    }

    public void setHinhanhsp(String hinhanhsp) {
        Hinhanhsp = hinhanhsp;
    }

    public String getMotasp() {
        return Motasp;
    }

    public void setMotasp(String motasp) {
        Motasp = motasp;
    }
}
