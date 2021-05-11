package com.example.covidtracker.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.covidtracker.Madal.CountryItem;
import com.example.covidtracker.R;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteCountryAdapter extends ArrayAdapter<CountryItem> {

    private List<CountryItem> countryListFull;

    public AutoCompleteCountryAdapter(@NonNull Context context, @NonNull List<CountryItem> countryList) {
        super(context.getApplicationContext(), 0,countryList);

        //if(countryList.size() != 0){

            countryListFull = new ArrayList<>();
            countryListFull = countryList;

        //}
        //else
            //Log.d("Auto","This is null");

    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.option_item,parent, false
            );
        }
        TextView textView = convertView.findViewById(R.id.country_view_name);

        CountryItem countryItem = getItem(position);
        if (countryItem != null){
            textView.setText(countryItem.getCountryName());
        }


        return convertView;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results =  new FilterResults();
            List<CountryItem> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                suggestions.addAll(countryListFull);
            }
            else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (CountryItem item : countryListFull){
                    if (item.getCountryName().toLowerCase().contains(filterPattern)){
                        suggestions.add(item);
                    }
                }
            }

            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((CountryItem) resultValue).getCountryName();
        }
    };
}
