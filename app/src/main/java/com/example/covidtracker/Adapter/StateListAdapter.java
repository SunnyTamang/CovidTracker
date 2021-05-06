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

    List<StateDataModel.Stats> stateListModalListCards;

    Context context;

    public void setData( List<StateDataModel.Stats> stateListModalListCards) {
        this.stateListModalListCards = stateListModalListCards;

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_result_table_items_state, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        int activeCases = stateListModalListCards.get(position).getConfirmed() - stateListModalListCards.get(position).getRecovered() - stateListModalListCards.get(position).getDeaths();
//        //String countryName = stateListModalListTable.get(position).getCountry();
//        String totalActive = String.valueOf(activeCases);
//        String totalRecovered = String.valueOf(stateListModalListCards.get(position).getRecovered());
//        String totalConfirmed = String.valueOf(stateListModalListCards.get(position).getConfirmed());
//        String totalDeceased = String.valueOf(stateListModalListCards.get(position).getDeaths());
//
//        holder.bind(totalConfirmed,totalActive,totalRecovered,totalDeceased);

////        holder.bind(Name,T_Affected,Recovered,N_Affected,Death);
//        int activeCases = StateListModalListCards.get(position).getConfirmed() - StateListModalListCards.get(position).getRecovered() - StateListModalListCards.get(position).getDeaths();
//        holder.countryName.setText(stateListModalListTable.get(position).getCountry());
//        holder.totalConfirmed.setText(String.valueOf(stateListModalListCards.get(position).getConfirmed()));
//        holder.totalActive.setText(activeCases);
//        holder.totalRecovered.setText(String.valueOf(stateListModalListCards.get(position).getRecovered()));
//        holder.totalDeceased.setText(String.valueOf(stateListModalListCards.get(position).getDeaths()));

        holder.totalConfirmed.setText(String.valueOf(stateListModalListCards.get(position).getDeaths()));
       // holder.totalRecovered.setText(String.valueOf(stateListModalListCards.get(position).getMoreDetails().getRecovered()));
       // holder.totalDeceased.setText(String.valueOf(stateListModalListCards.get(position).getMoreDetails().getDeaths()));

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
            totalActive = itemView.findViewById(R.id.total_active);
            totalRecovered = itemView.findViewById(R.id.total_recovered);
            totalDeceased = itemView.findViewById(R.id.total_deceased);
        }

        private void bind(final String TotalConfirmed, final String TotalActive, final String TotalRecovered, final String TotalDeceased) {
            //countryName.setText(CountryName);
            totalConfirmed.setText(TotalConfirmed);
            totalActive.setText(TotalActive);
            totalRecovered.setText(TotalRecovered);
            totalDeceased.setText(TotalDeceased);
        }


    }
}

