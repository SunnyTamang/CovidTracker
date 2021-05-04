package com.example.covidtracker.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracker.Madal.WorldDataList;
import com.example.covidtracker.Madal.WorldListModal;
import com.example.covidtracker.R;

import java.util.List;

public class WorldListAdapter extends RecyclerView.Adapter<WorldListAdapter.ViewHolder> {

    public WorldListAdapter() {
    }

    List<WorldDataList> worldListModalList;
    Context context;

    public void setData(List<WorldDataList> worldListModalList) {
        this.worldListModalList = worldListModalList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_result_table_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String Name = worldListModalList.get(position).getCountryName();
//        String T_Affected = worldListModalList.get(position).getTotalAffected();
//        String Recovered = worldListModalList.get(position).getTotalRecovered();
//        String N_Affected = worldListModalList.get(position).getNewAffected();
//        String Death = worldListModalList.get(position).getTotalDeath();

//        holder.bind(Name,T_Affected,Recovered,N_Affected,Death);

        holder.countryName.setText(worldListModalList.get(position).getCountry());
        holder.totalAffected.setText(String.valueOf(worldListModalList.get(position).getCases()));
        holder.totalRecovered.setText(String.valueOf(worldListModalList.get(position).getRecovered()));
        holder.totalDeath.setText(String.valueOf(worldListModalList.get(position).getDeaths()));
        holder.newAffected.setText(String.valueOf(worldListModalList.get(position).getTodayCases()));

    }

    @Override
    public int getItemCount() {
        return worldListModalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName;
        private TextView totalAffected;
        private TextView totalRecovered;
        private TextView newAffected;
        private TextView totalDeath;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_name);
            totalAffected = itemView.findViewById(R.id.total_affected);
            totalRecovered = itemView.findViewById(R.id.total_recovered);
            newAffected = itemView.findViewById(R.id.new_affected);
            totalDeath = itemView.findViewById(R.id.total_deaths);
        }

//        private void bind(final String CountryName,final String TotalAffected,final String TotalRecovered,final String NewAffected,final String TotalDeath){
//            countryName.setText(CountryName);
//            totalAffected.setText(TotalAffected);
//            totalRecovered.setText(TotalRecovered);
//            newAffected.setText(NewAffected);
//            totalDeath.setText(TotalDeath);
//        }
    }
}
