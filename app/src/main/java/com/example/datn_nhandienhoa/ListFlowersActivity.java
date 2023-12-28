package com.example.datn_nhandienhoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.datn_nhandienhoa.adapter.AdapterFlower;
import com.example.datn_nhandienhoa.adapter.AdapterFlower1;
import com.example.datn_nhandienhoa.model.Flower;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class ListFlowersActivity extends AppCompatActivity {

    private ArrayList<String> flowersArrayList = new ArrayList<>();;
    private AdapterFlower1 adapterFlower;
    ImageButton camera, gallery, search, backBtn;
    RecyclerView flowerRCV;
    EditText searchET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_flowers);

        flowerRCV = findViewById(R.id.flowerRCV);
        searchET = findViewById(R.id.searchET);
        backBtn = findViewById(R.id.backBtn);

        loadFlowerList();

        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                try {
                    adapterFlower.getFilter().filter(s);
                }catch (Exception e){

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void loadFlowerList() {
        String[] flowersToAdd = {"Hoa cúc", "Hoa bồ công anh", "Hoa diên vĩ", "Hoa hồng", "Hoa hướng dương", "Hoa Tulip"};
        Collections.addAll(flowersArrayList, flowersToAdd);
        adapterFlower = new AdapterFlower1(ListFlowersActivity.this, flowersArrayList);
        flowerRCV.setAdapter(adapterFlower);
//        DatabaseReference ref = FirebaseDatabase.getInstace().getReference("Flower");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                flowersArrayList.clear();
//                for (DataSnapshot ds: snapshot.getChildren()){
////                    Flower c = ds.getValue(Flower.class);
////                    flowersArrayList.add(c);
//                    String flowerName = snapshot.child("name").getValue(String.class);
//                    flowersArrayList.add(flowerName);
//                }
//                adapterFlower = new AdapterFlower1(ListFlowersActivity.this, flowersArrayList);
//                binding.flowerRCV.setAdapter(adapterFlower);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }
}