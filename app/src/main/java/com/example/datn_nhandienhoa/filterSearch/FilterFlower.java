package com.example.datn_nhandienhoa.filterSearch;

import android.widget.Filter;

import com.example.datn_nhandienhoa.adapter.AdapterFlower;
import com.example.datn_nhandienhoa.model.Flower;

import java.util.ArrayList;

public class FilterFlower extends Filter{

    ArrayList<Flower> filterList;
    AdapterFlower adapterFlower;

    public FilterFlower(ArrayList<Flower> filterList, AdapterFlower adapterFlower) {
        this.filterList = filterList;
        this.adapterFlower = adapterFlower;
    }


    @Override
    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        Filter.FilterResults results = new Filter.FilterResults();
        if (constraint!= null && constraint.length()>0){
            constraint = constraint.toString().toLowerCase();
            ArrayList<Flower> filterListCate = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++){
                if (filterList.get(i).getName().toLowerCase().contains(constraint)){
                    filterListCate.add(filterList.get(i));
                }
            }

            results.count = filterListCate.size();
            results.values = filterListCate;

        }else {
            results.count = filterList.size();
            results.values = filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        adapterFlower.flowerArrayList = (ArrayList<Flower>) results.values;
        adapterFlower.notifyDataSetChanged();
    }
}
