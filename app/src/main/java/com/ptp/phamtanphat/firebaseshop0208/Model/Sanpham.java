package com.ptp.phamtanphat.firebaseshop0208.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by KhoaPhamPC on 25/10/2017.
 */

public class Sanpham implements Parcelable{
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

    protected Sanpham(Parcel in) {
        Idloaisp = in.readString();
        Idsp = in.readString();
        Tensp = in.readString();
        Giasp = in.readString();
        Hinhanhsp = in.readString();
        Motasp = in.readString();
    }

    public static final Creator<Sanpham> CREATOR = new Creator<Sanpham>() {
        @Override
        public Sanpham createFromParcel(Parcel in) {
            return new Sanpham(in);
        }

        @Override
        public Sanpham[] newArray(int size) {
            return new Sanpham[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Idloaisp);
        parcel.writeString(Idsp);
        parcel.writeString(Tensp);
        parcel.writeString(Giasp);
        parcel.writeString(Hinhanhsp);
        parcel.writeString(Motasp);
    }
}
