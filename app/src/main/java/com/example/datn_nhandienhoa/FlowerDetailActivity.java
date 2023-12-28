package com.example.datn_nhandienhoa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FlowerDetailActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton backBtn;
    ImageButton camera, gallery, search;

    TextView txtorigin, txtutility, txtdes, titleTV;
    private String flower, flowerId;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_detail);

        imageView = findViewById(R.id.imageView);
        txtorigin = findViewById(R.id.txtorigin);
        txtutility = findViewById(R.id.txtutility);
        txtdes = findViewById(R.id.txtdes);
        backBtn = findViewById(R.id.backBtn);
        titleTV = findViewById(R.id.titleTV);

//        search = findViewById(R.id.search);
//        camera = findViewById(R.id.takePicture);
//        gallery = findViewById(R.id.launchGallery);

        Intent intent = getIntent();
        flowerId = intent.getStringExtra("id");
        flower = intent.getStringExtra("name");

        if (flower.equalsIgnoreCase("Hoa bồ công anh")) {
            imageView.setImageResource(R.drawable.dandelion);
            titleTV.setText("Hoa bồ công anh");
        }
        else if (flower.equalsIgnoreCase("Hoa diên vĩ")) {
            imageView.setImageResource(R.drawable.iris);
            titleTV.setText("Hoa diên vĩ");
        }else if (flower.equalsIgnoreCase("Hoa cúc")) {
            imageView.setImageResource(R.drawable.daisy);
            titleTV.setText("Hoa cúc");
        }else if (flower.equalsIgnoreCase("Hoa hồng")) {
            imageView.setImageResource(R.drawable.rose);
            titleTV.setText("Hoa hồng");
        }else if (flower.equalsIgnoreCase("Hoa hướng dương")) {
            imageView.setImageResource(R.drawable.image_47);
            titleTV.setText("Hoa hướng dương");
        }else if (flower.equalsIgnoreCase("Hoa Tulip")) {
            imageView.setImageResource(R.drawable.tulip);
            titleTV.setText("Hoa Tulip");
        }


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//
//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(FlowerDetailActivity.this, ListFlowersActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(cameraIntent, 3);
//                } else {
//                    requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 100);
//                }
//            }
//        });
//        gallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(cameraIntent, 1);
//            }
//        });
//
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://flowerclassification-7fae1-default-rtdb.asia-southeast1.firebasedatabase.app/");

        DatabaseReference reference = db.getReference("Flower");
        reference.child(String.valueOf(flower))
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String description = "" + snapshot.child("des").getValue();
                        String origin = "" + snapshot.child("origin").getValue();
                        String utility = "" + snapshot.child("utility").getValue();
                        String url = "" + snapshot.child("url").getValue();

                        txtorigin.setText(origin.replace("\\n", System.getProperty("line.separator")));
                        txtutility.setText(utility.replace("\\n", System.getProperty("line.separator")));
                        txtdes.setText(description.replace("\\n", System.getProperty("line.separator")));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }
}