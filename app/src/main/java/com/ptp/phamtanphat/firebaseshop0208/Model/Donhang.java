package com.ptp.phamtanphat.firebaseshop0208.Model;

/**
 * Created by KhoaPhamPC on 25/10/2017.
 */

public class Donhang {
    private String Iddh;
    private String Iddhsp;
    private String Hoten;
    private String Email;
    private String Sdt;
    private String Diachi;

    public Donhang() {
    }

    public Donhang(String iddh, String iddhsp, String hoten, String email, String sdt, String diachi) {
        Iddh = iddh;
        Iddhsp = iddhsp;
        Hoten = hoten;
        Email = email;
        Sdt = sdt;
        Diachi = diachi;
    }

    public String getIddh() {
        return Iddh;
    }

    public void setIddh(String iddh) {
        Iddh = iddh;
    }

    public String getIddhsp() {
        return Iddhsp;
    }

    public void setIddhsp(String iddhsp) {
        Iddhsp = iddhsp;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
}
