package com.example.datn_nhandienhoa.filterSearch;

import android.widget.Filter;

import com.example.datn_nhandienhoa.adapter.AdapterFlower1;
import com.example.datn_nhandienhoa.model.Flower;

import java.text.Normalizer;
import java.util.ArrayList;

public class FilterFlower1 extends Filter{

    ArrayList<String> filterList;
    AdapterFlower1 adapterFlower;

    public FilterFlower1(ArrayList<String> filterList, AdapterFlower1 adapterFlower) {
        this.filterList = filterList;
        this.adapterFlower = adapterFlower;
    }


    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (constraint!= null && constraint.length()>0){
            constraint = constraint.toString().toLowerCase();
            ArrayList<String> filterListCate = new ArrayList<>();

            for (String item : filterList) {
                String itemLowerCase = item.toLowerCase();

                // Chuẩn hóa chuỗi về dạng không dấu trước khi so sánh
                String normalizedItem = Normalizer.normalize(itemLowerCase, Normalizer.Form.NFD)
                        .replaceAll("\\p{M}", "");

                // Kiểm tra xem chuỗi đã chuẩn hóa có chứa chuỗi constraint đã chuẩn hóa không
                if (normalizedItem.contains(constraint)) {
                    filterListCate.add(item);
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
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapterFlower.flowerArrayList = (ArrayList<String>) results.values;
        adapterFlower.notifyDataSetChanged();
    }
}
