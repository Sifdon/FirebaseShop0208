package com.ptp.phamtanphat.firebaseshop0208.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ptp.phamtanphat.firebaseshop0208.Adapter.SanphamAdapter;
import com.ptp.phamtanphat.firebaseshop0208.Model.Sanpham;
import com.ptp.phamtanphat.firebaseshop0208.R;

import java.util.ArrayList;

public class ManhinhSanPhamActivity extends AppCompatActivity {

    String idloaisp = "";
    ListView lvsp;
    ArrayList<Sanpham> sanphamArrayList;
    SanphamAdapter sanphamAdapter;
    private DatabaseReference mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh_san_pham);

        mData = FirebaseDatabase.getInstance().getReference();

        final Intent intent = getIntent();
        idloaisp = intent.getStringExtra("idloaisp");

        lvsp = (ListView) findViewById(R.id.listviewsanpham);
        sanphamArrayList = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(ManhinhSanPhamActivity.this,sanphamArrayList);
        lvsp.setAdapter(sanphamAdapter);
        GetSPData();
        lvsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intentsp = new Intent(ManhinhSanPhamActivity.this,ChitietSanPhamActivity.class);
                    intentsp.putExtra("sanpham",sanphamArrayList.get(i));
                    startActivity(intentsp);
            }
        });
    }

    private void GetSPData() {
        mData.child("Sanpham").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Sanpham sanpham = dataSnapshot.getValue(Sanpham.class);
                if (sanpham.getIdloaisp().equals(idloaisp)){
                    sanphamArrayList.add(sanpham);
                }
                sanphamAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
