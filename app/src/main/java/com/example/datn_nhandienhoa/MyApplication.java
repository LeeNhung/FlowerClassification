package com.example.datn_nhandienhoa;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Environment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static void loadNameFlower() {
        FirebaseDatabase db = FirebaseDatabase.getInstance(
                "https://flowerclassification-7fae1-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference ref= db.getReference("Flower");
//        ref.child(flower)
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        String flower = "" + snapshot.child("name").getValue();
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                        String flowerName = childSnapshot.getKey();
                        // Đây là tên của mỗi root trong collection "Flower"
                        System.out.println("Tên loài hoa: " + flowerName);
                    }
                } else {
                    System.out.println("Không có dữ liệu trong collection 'Flower'.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Đã xảy ra lỗi: " + error.getMessage());
            }
        });
    }

}