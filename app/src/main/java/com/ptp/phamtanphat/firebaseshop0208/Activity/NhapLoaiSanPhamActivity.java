package com.ptp.phamtanphat.firebaseshop0208.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.ptp.phamtanphat.firebaseshop0208.Model.Loaisanpham;
import com.ptp.phamtanphat.firebaseshop0208.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Calendar;

public class NhapLoaiSanPhamActivity extends AppCompatActivity {

    EditText edtidloaisp,edttenloaisp;
    ImageView imgloaisp;
    Button btnsaveloaisp;
    FirebaseStorage storage;
    private DatabaseReference mDatabase;
    final int Request_Code_Image = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_loai_san_pham);

        storage = FirebaseStorage.getInstance();
        final StorageReference storageRef = storage.getReference();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        anhxa();
        imgloaisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(NhapLoaiSanPhamActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        Request_Code_Image);
            }
        });
        btnsaveloaisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentime = (int) Calendar.getInstance().getTimeInMillis();
                StorageReference mountainsRef = storageRef.child("Hinh/hinhloaisanpham" + currentime + ".png");

                //sử dụng lấy hình ảnh mới của imageview
                BitmapDrawable bitmapdrawable = (BitmapDrawable) imgloaisp.getDrawable();
                Bitmap bitmap = bitmapdrawable.getBitmap();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText(NhapLoaiSanPhamActivity.this, "Upload hinh thất bại", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(NhapLoaiSanPhamActivity.this, "Upload thành công", Toast.LENGTH_SHORT).show();
                        Loaisanpham loaisanpham = new Loaisanpham(edtidloaisp.getText().toString(), edttenloaisp.getText().toString(), String.valueOf(downloadUrl));
                        mDatabase.child("Loaisanpham").push().setValue(loaisanpham, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                if (databaseError == null) {
                                    Toast.makeText(NhapLoaiSanPhamActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(NhapLoaiSanPhamActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }
        });
    }


    private void anhxa() {
        edtidloaisp = (EditText) findViewById(R.id.edittextidloaisp);
        edttenloaisp = (EditText) findViewById(R.id.edittexttenloaisp);
        imgloaisp = (ImageView) findViewById(R.id.imageviewloaisp);
        btnsaveloaisp = (Button) findViewById(R.id.buttonsaveloaisp);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == Request_Code_Image) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Request_Code_Image);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Request_Code_Image && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgloaisp.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}