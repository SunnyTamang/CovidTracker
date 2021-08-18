package com.trackc.trackc.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trackc.trackc.Madal.StateDataModel;
import com.trackc.trackc.R;

import java.util.ArrayList;
import java.util.List;

public class StateListAdapterStateName extends RecyclerView.Adapter<StateListAdapterStateName.ViewHolder>{

    public StateListAdapterStateName() {

    }


    List<StateDataModel> stateListModalListTable;
    List<StateDataModel> confirmedCount;
    List<StateDataModel> recoveredCount;
    List<StateDataModel> deceasedCount;
    List<StateDataModel> activeCount;
    Context context;
    private List<StateDataModel> mStateFilteredList = new ArrayList<>();

    public void setData( List<StateDataModel> stateListModalListTable,List<StateDataModel> confirmedCount, List<StateDataModel> recoveredCount, List<StateDataModel> deceasedCount, List<StateDataModel> activeCount) {
        this.stateListModalListTable = stateListModalListTable;
        this.confirmedCount = confirmedCount;
        this.recoveredCount = recoveredCount;
        this.deceasedCount = deceasedCount;
        this.activeCount = activeCount;
        notifyDataSetChanged();

    }

//    public StateListAdapterStateName(List<StateDataModel> stateListModalListTable, Context context) {
//        this.stateListModalListTable = stateListModalListTable;
//        this.context = context;
//    }

    @NonNull
    @Override
    public StateListAdapterStateName.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.c_result_table_items_state, parent, false);
        return new StateListAdapterStateName.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateListAdapterStateName.ViewHolder holder, int position) {

        //int activeCount = confirmedCount.get(position).getStats().getConfirmed();
        String stateName = String.valueOf(stateListModalListTable.get(position));
        String Confirmed = String.valueOf(confirmedCount.get(position));
        String Active = String.valueOf(activeCount.get(position));
        String Recovered = String.valueOf((recoveredCount.get(position)));
        String Deceased = String.valueOf(deceasedCount.get(position));
        //holder.stateName.setText(stateListModalListTable.get(position).getProvince());

        holder.bind(stateName,Confirmed,Active,Recovered,Deceased);
        //holder.countryName.setText(stateListModalListTable.get(position).getProvince());





    }

    @Override
    public int getItemCount() {
//        if(getItemCount() == 0){
//            Toast.makeText(context, "No records to show", Toast.LENGTH_SHORT).show();
//        }
        return stateListModalListTable.size() ;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stateName;
        private TextView total_confirmed;
        private TextView total_active;
        private TextView total_recovered;
        private TextView total_deceased;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stateName = itemView.findViewById(R.id.state_name);
            total_confirmed = itemView.findViewById(R.id.total_confirmed);
            total_active = itemView.findViewById(R.id.total_active);
            total_recovered = itemView.findViewById(R.id.total_recovered);
            total_deceased = itemView.findViewById(R.id.total_deceased);

        }

        private void bind(final String StateName, final String Confirmed, final String Active, final String Recovered, final String Deceased) {
            stateName.setText(StateName);
            total_confirmed.setText(Confirmed);
            total_active.setText(Active);
            total_recovered.setText(Recovered);
            total_deceased.setText(Deceased);

        }




    }

    public void filterList(List<StateDataModel> filteredList) {
        mStateFilteredList = filteredList;
        notifyDataSetChanged();
    }
}
