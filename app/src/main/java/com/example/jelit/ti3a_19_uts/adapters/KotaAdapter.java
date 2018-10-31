package com.example.jelit.ti3a_19_uts.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jelit.ti3a_19_uts.R;

import java.util.ArrayList;

public class KotaAdapter extends RecyclerView.Adapter<KotaAdapter.RvKotaHolder> {
    ArrayList<String> dataset;

    public KotaAdapter(ArrayList<String> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RvKotaHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_rv,parent,false);
        RvKotaHolder viewHolder = new RvKotaHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RvKotaHolder rvKotaHolder, int i) {
        rvKotaHolder.txtNama.setText(dataset.get(i));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class RvKotaHolder extends RecyclerView.ViewHolder {
        TextView txtNama;
        public RvKotaHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
        }
    }
}
