package com.example.datn_nhandienhoa.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datn_nhandienhoa.FlowerDetailActivity;
import com.example.datn_nhandienhoa.ListFlowersActivity;
import com.example.datn_nhandienhoa.MyApplication;
import com.example.datn_nhandienhoa.databinding.ListFlowersBinding;
import com.example.datn_nhandienhoa.filterSearch.FilterFlower;
import com.example.datn_nhandienhoa.model.Flower;

import java.util.ArrayList;

public class AdapterFlower extends RecyclerView.Adapter<AdapterFlower.HolderFlower> implements Filterable
{
    private ListFlowersBinding binding;
    private Context context;
    public ArrayList<Flower> flowerArrayList, filterList;

    private FilterFlower filterBook;

    public AdapterFlower (Context context, ArrayList<Flower> flowerArrayList    ) {
        this.context = context;
        this.flowerArrayList = flowerArrayList;
        this.filterList = flowerArrayList;
    }

    public AdapterFlower(ListFlowersActivity context, ArrayList<String> flowerNames) {
    }

    @Override
    public Filter getFilter() {
        if (filterBook == null){
            filterBook = new FilterFlower(filterList,this);

        }
        return filterBook;
    }

    @NonNull
    @Override
    public AdapterFlower.HolderFlower onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListFlowersBinding.inflate(LayoutInflater.from(context),parent,false);
        return new HolderFlower(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFlower.HolderFlower holder, int position) {
        Flower b = flowerArrayList.get(position);
        int id = b.getId();
        String name = b.getName();
        //set
        holder.titletv.setText(name);
        String flowerId = id + "";

//        MyApplication.loadNameFlower();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlowerDetailActivity.class);
//                intent.putExtra("id", flowerId);
                intent.putExtra("name", name);
                context.startActivity(intent);
                Toast.makeText(v.getContext(), "Bạn đã chọn: " + name, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return flowerArrayList.size();
    }

    class HolderFlower extends RecyclerView.ViewHolder{
        TextView titletv;
        public HolderFlower(@NonNull View itemView) {
            super(itemView);
            titletv = binding.titleTV;
        }
    }
}
