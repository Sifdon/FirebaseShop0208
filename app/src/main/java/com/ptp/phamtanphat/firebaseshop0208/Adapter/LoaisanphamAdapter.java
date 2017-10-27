package com.ptp.phamtanphat.firebaseshop0208.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.firebaseshop0208.Model.Loaisanpham;
import com.ptp.phamtanphat.firebaseshop0208.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by KhoaPhamPC on 27/10/2017.
 */

public class LoaisanphamAdapter extends BaseAdapter {
    Context context;
    ArrayList<Loaisanpham> loaisanphamArrayList;

    public LoaisanphamAdapter(Context context, ArrayList<Loaisanpham> loaisanphamArrayList) {
        this.context = context;
        this.loaisanphamArrayList = loaisanphamArrayList;
    }

    @Override
    public int getCount() {
        return loaisanphamArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return loaisanphamArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    class ViewHolder{
        ImageView imgloaisp;
        TextView txtloaisp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.dong_loai_sanpham,null);
            viewHolder.imgloaisp = view.findViewById(R.id.imageviewloaisanpham);
            viewHolder.txtloaisp = view.findViewById(R.id.textviewloaisanpham);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Loaisanpham loaisanpham = (Loaisanpham) getItem(i);
        viewHolder.txtloaisp.setText(loaisanpham.getTenLoaiSP());
        Picasso.with(context).load(loaisanpham.getHinhLoaiSP()).into(viewHolder.imgloaisp);
        return view;
    }
}
