package com.example.motodescriptive;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class MotorAdapter extends RecyclerView.Adapter<MotorAdapter.ViewHolder> implements Filterable {

    private ArrayList<MotoEntity> arr;
    private ArrayList<MotoEntity> arrFull;
    private OnNoteClicked onNoteClicked;
    private Context context;

    @Override
    public long getItemId(int position) {
        return arr.get(position).getID();
    }

    public MotorAdapter(ArrayList<MotoEntity> motorcycles, OnNoteClicked onNoteClicked, Context context) {
        this.arr = motorcycles;
        this.arrFull = new ArrayList<>(arr);
        this.onNoteClicked = onNoteClicked;
        this.context = context;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.motocycles, parent, false);
        return new ViewHolder(v, onNoteClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text1.setText(arr.get(position).getMoto_name());
        holder.text2.setText(arr.get(position).getMoto_desc());
        Glide.with(context).load(arr.get(position).getMoto_img()).into(holder.image1);

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    @Override
    public Filter getFilter() {
        return ExampleFilter;
    }

    Filter ExampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<MotoEntity> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(arrFull);
            } else {
                String filteredPattern = charSequence.toString().toLowerCase().trim();
                for(MotoEntity item: arrFull) {
                    if(item.getMoto_name().toLowerCase().startsWith(filteredPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            arr.clear();
            arr.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView text1;
        private TextView text2;
        private ImageView image1;
        private MaterialCardView cardView;
        OnNoteClicked onNoteClicked;
        public ViewHolder(@NonNull View itemView, OnNoteClicked onNoteClicked) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            image1 = itemView.findViewById(R.id.image1);
            cardView = itemView.findViewById(R.id.cardView);
            this.onNoteClicked = onNoteClicked;

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("arrayL", arr);
            bundle.putInt("id", getAdapterPosition());
            onNoteClicked.OnNote(bundle);
        }
    }

    public interface OnNoteClicked {
        void OnNote(Bundle bundle);
    }
}
