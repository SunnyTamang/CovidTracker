package com.example.covidtracker.Adapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracker.Madal.StateDataModel;
import com.example.covidtracker.R;

import java.util.List;

public class StateListAdapter extends RecyclerView.Adapter<StateListAdapter.ViewHolder> {

    public StateListAdapter() {
    }

    List<StateDataModel> stateListModalListCards;

    Context context;

    public void setData( List<StateDataModel> stateListModalListCards) {
        this.stateListModalListCards = stateListModalListCards;

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public StateListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_result_table_items_state, parent, false);
        return new StateListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateListAdapter.ViewHolder holder, int position) {
        String totalConfirmed = String.valueOf(stateListModalListCards.get(position));
        //holder.totalConfirmed.setText(String.valueOf(stateListModalListCards.get(position)));
//
        holder.bind(totalConfirmed);

    }

    @Override
    public int getItemCount() {
//        if(){
//            Toast.makeText(context, "No records to show", Toast.LENGTH_SHORT).show();
//        }
        return stateListModalListCards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //private TextView countryName;
        private TextView totalConfirmed;
        private TextView totalActive;
        private TextView totalRecovered;
        private TextView totalDeceased;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //countryName = itemView.findViewById(R.id.country_name);
            totalConfirmed = itemView.findViewById(R.id.total_confirmed);
//            totalActive = itemView.findViewById(R.id.total_active);
//            totalRecovered = itemView.findViewById(R.id.total_recovered);
//            totalDeceased = itemView.findViewById(R.id.total_deceased);
        }

        private void bind(final String TotalConfirmed) {
            //countryName.setText(CountryName);
            totalConfirmed.setText(TotalConfirmed);
//            totalActive.setText(TotalActive);
//            totalRecovered.setText(TotalRecovered);
//            totalDeceased.setText(TotalDeceased);
        }


    }
}

