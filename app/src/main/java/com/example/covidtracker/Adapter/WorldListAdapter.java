package com.example.covidtracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracker.Madal.WorldDataList;
import com.example.covidtracker.R;
import com.example.covidtracker.StateWiseDataActivity;

import java.util.ArrayList;
import java.util.List;

public class WorldListAdapter extends RecyclerView.Adapter<WorldListAdapter.ViewHolder> {

    public WorldListAdapter() {
    }

    List<WorldDataList> worldListModalList;
    Context context;

    private OnItemClickListener mListener;
    private List<WorldDataList> mExampleList = new ArrayList<>();

    //Interface for RV onclick listener
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }



    public void setData(List<WorldDataList> worldListModalList) {
        this.worldListModalList = worldListModalList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid_result_table_items,parent,false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String CountryName = worldListModalList.get(position).getCountry();
        String TotalConfirmed = String.valueOf(worldListModalList.get(position).getCases());
        String TotalActive = String.valueOf(worldListModalList.get(position).getActive());
        String TotalRecovered =String.valueOf(worldListModalList.get(position).getRecovered());
        String TotalDeceased = String.valueOf(worldListModalList.get(position).getDeaths());

        holder.bind(CountryName,TotalConfirmed,TotalActive,TotalRecovered,TotalDeceased);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), StateWiseDataActivity.class);
                intent.putExtra("Country Name",CountryName);
                intent.putExtra("Total Confirmed",TotalConfirmed);
                intent.putExtra("Total Active",TotalActive);
                intent.putExtra("CountryRecovered",TotalRecovered);
                intent.putExtra("Total Deceased",TotalDeceased);
                view.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return worldListModalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView countryName;
        private TextView totalConfirmed;
        private TextView totalActive;
        private TextView totalRecovered;
        private TextView totalDeceased;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            countryName = itemView.findViewById(R.id.country_name);
            totalConfirmed = itemView.findViewById(R.id.total_confirmed);
            totalActive = itemView.findViewById(R.id.total_active);
            totalRecovered = itemView.findViewById(R.id.total_recovered);
            totalDeceased = itemView.findViewById(R.id.total_deceased);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }

            });
        }

        private void bind(final String CountryName,final String TotalConfirmed,final String TotalActive,final String TotalRecovered,final String TotalDeceased){
            countryName.setText(CountryName);
            totalConfirmed.setText(TotalConfirmed);
            totalActive.setText(TotalActive);
            totalRecovered.setText(TotalRecovered);
            totalDeceased.setText(TotalDeceased);
        }
    }

    public void filterList(ArrayList<WorldDataList> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }
}
