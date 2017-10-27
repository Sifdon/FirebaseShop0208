package com.ptp.phamtanphat.firebaseshop0208.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ptp.phamtanphat.firebaseshop0208.Adapter.LoaisanphamAdapter;
import com.ptp.phamtanphat.firebaseshop0208.Model.Loaisanpham;
import com.ptp.phamtanphat.firebaseshop0208.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvloaisp;
    LoaisanphamAdapter loaisanphamAdapter;
    ArrayList<Loaisanpham> arrayListloaisp;
    private DatabaseReference mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = FirebaseDatabase.getInstance().getReference();
        lvloaisp = (ListView) findViewById(R.id.listviewloaisp);
        arrayListloaisp = new ArrayList<>();
        loaisanphamAdapter = new LoaisanphamAdapter(MainActivity.this,arrayListloaisp);
        lvloaisp.setAdapter(loaisanphamAdapter);

        GetLoaiSP();
    }

    private void GetLoaiSP() {
        mData.child("Loaisanpham").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Loaisanpham loaisanpham = dataSnapshot.getValue(Loaisanpham.class);
                arrayListloaisp.add(loaisanpham);
                loaisanphamAdapter.notifyDataSetChanged();
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
