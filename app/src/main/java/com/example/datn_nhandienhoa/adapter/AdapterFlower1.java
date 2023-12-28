package com.example.datn_nhandienhoa.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datn_nhandienhoa.FlowerDetailActivity;
import com.example.datn_nhandienhoa.ListFlowersActivity;
import com.example.datn_nhandienhoa.databinding.ListFlowersBinding;
import com.example.datn_nhandienhoa.filterSearch.FilterFlower1;

import java.util.ArrayList;

public class AdapterFlower1 extends RecyclerView.Adapter<AdapterFlower1.HolderFlower> implements Filterable
{
    private ListFlowersBinding binding;
    private Context context;
    public ArrayList<String> flowerArrayList, filterList;

    private FilterFlower1 filterBook;

    public AdapterFlower1(Context context, ArrayList<String> flowerArrayList
    ) {
        this.context = context;
        this.flowerArrayList = flowerArrayList;
        this.filterList = flowerArrayList;
    }

    @Override
    public Filter getFilter() {
        if (filterBook == null){
            filterBook = new FilterFlower1(filterList,this);

        }
        return filterBook;
    }

    @NonNull
    @Override
    public AdapterFlower1.HolderFlower onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListFlowersBinding.inflate(LayoutInflater.from(context),parent,false);
        return new HolderFlower(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFlower1.HolderFlower holder, int position) {

        String name = flowerArrayList.get(position); // Lấy tên loài hoa từ danh sách
        holder.titletv.setText(name);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlowerDetailActivity.class);
                intent.putExtra("name", name);
                context.startActivity(intent);

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
