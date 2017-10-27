package com.ptp.phamtanphat.firebaseshop0208.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ptp.phamtanphat.firebaseshop0208.Model.Sanpham;
import com.ptp.phamtanphat.firebaseshop0208.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by KhoaPhamPC on 27/10/2017.
 */

public class SanphamAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> sanphamArrayList;

    public SanphamAdapter(Context context, ArrayList<Sanpham> sanphamArrayList) {
        this.context = context;
        this.sanphamArrayList = sanphamArrayList;
    }

    @Override
    public int getCount() {
        return sanphamArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return sanphamArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    class ViewHolder{
        ImageView imgsanpham;
        TextView txttensp,txtgiasp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.dong_sanpham,null);
            viewHolder.txtgiasp = view.findViewById(R.id.textviewgiasanpham);
            viewHolder.txttensp = view.findViewById(R.id.textviewtensanpham);
            viewHolder.imgsanpham = view.findViewById(R.id.imageviewsanpham);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttensp.setText(sanpham.getTensp());
        Picasso.with(context).load(sanpham.getHinhanhsp()).into(viewHolder.imgsanpham);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiasp.setText(decimalFormat.format(Integer.parseInt(sanpham.getGiasp())));
        return view;
    }
}
