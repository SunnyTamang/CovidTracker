package com.example.covidtracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracker.Madal.StateDataModel;
import com.example.covidtracker.R;

import java.util.List;

public class StateListAdapter extends RecyclerView.Adapter<StateListAdapter.ViewHolder> {

    public StateListAdapter() {
    }

    List<StateDataModel.Stats> StateListModalListCards;
    List<StateDataModel> StateListModalListTable;
    Context context;

    public void setData(List<StateDataModel.Stats> StateListModalListCards, List<StateDataModel> StateListModalListTable) {
        this.StateListModalListCards = StateListModalListCards;
        this.StateListModalListTable = StateListModalListTable;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_result_table_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String Name = StateListModalList.get(position).getCountryName();
//        String T_Affected = StateListModalList.get(position).getTotalAffected();
//        String Recovered = StateListModalList.get(position).getTotalRecovered();
//        String N_Affected = StateListModalList.get(position).getNewAffected();
//        String Death = StateListModalList.get(position).getTotalDeath();

//        holder.bind(Name,T_Affected,Recovered,N_Affected,Death);
        int activeCases = StateListModalListCards.get(position).getConfirmed() - StateListModalListCards.get(position).getRecovered() - StateListModalListCards.get(position).getDeaths();
        holder.countryName.setText(StateListModalListTable.get(position).getCountry());
        holder.totalConfirmed.setText(String.valueOf(StateListModalListCards.get(position).getConfirmed()));
        holder.totalActive.setText(activeCases);
        holder.totalRecovered.setText(String.valueOf(StateListModalListCards.get(position).getRecovered()));
        holder.totalDeceased.setText(String.valueOf(StateListModalListCards.get(position).getDeaths()));

    }

    @Override
    public int getItemCount() {
        return StateListModalListTable.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName;
        private TextView totalConfirmed;
        private TextView totalActive;
        private TextView totalRecovered;
        private TextView totalDeceased;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_name);
            totalConfirmed = itemView.findViewById(R.id.total_confirmed);
            totalActive = itemView.findViewById(R.id.total_active);
            totalRecovered = itemView.findViewById(R.id.total_recovered);
            totalDeceased = itemView.findViewById(R.id.total_deceased);
        }
    }
}

