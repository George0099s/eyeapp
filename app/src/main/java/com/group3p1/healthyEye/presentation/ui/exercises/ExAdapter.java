package com.group3p1.healthyEye.presentation.ui.exercises;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.group3p1.healthyEye.R;
import com.group3p1.healthyEye.domain.model.ExerciseModel;

import java.util.ArrayList;
import java.util.List;

interface ItemClickListener {
    void onClick(ExerciseModel model);
}

public class ExAdapter extends RecyclerView.Adapter<ExAdapter.ExHolder> {

    private List<ExerciseModel> list;
    private ItemClickListener listener;
    public ExAdapter(ItemClickListener listener) {
        this.list = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_ex, parent, false);
        return new ExHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExHolder holder, int position) {
        final ExerciseModel item = list.get(position);
        holder.text.setText(item.getText());
        holder.title.setText(item.getTitle());
        holder.itemView.setOnClickListener(v -> {
            listener.onClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateList(List<ExerciseModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ExHolder extends RecyclerView.ViewHolder {
        TextView text, title;

        public ExHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            title = itemView.findViewById(R.id.title);
        }
    }
}
