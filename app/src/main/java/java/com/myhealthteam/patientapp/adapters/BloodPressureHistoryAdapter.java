package java.com.myhealthteam.patientapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.com.myhealthteam.patientapp.R;
import java.com.myhealthteam.patientapp.models.BloodPressureRecord;

import java.util.List;

public class BloodPressureHistoryAdapter extends RecyclerView.Adapter<BloodPressureHistoryAdapter.ViewHolder> {

    private List<BloodPressureRecord> records;

    public BloodPressureHistoryAdapter(List<BloodPressureRecord> records) {
        this.records = records;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_blood_pressure_record, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BloodPressureRecord record = records.get(position);
        holder.reading.setText(record.getReading());
        holder.measuredAt.setText(record.getMeasuredAt());
        holder.status.setText(record.getStatus());

        // Change the status text color dynamically
        if (record.getStatus().equalsIgnoreCase("Normal")) {
            holder.status.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green));
        } else if (record.getStatus().equalsIgnoreCase("High")) {
            holder.status.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView reading, measuredAt, status;

        ViewHolder(View itemView) {
            super(itemView);
            reading = itemView.findViewById(R.id.reading);
            measuredAt = itemView.findViewById(R.id.measured_at);
            status = itemView.findViewById(R.id.status);
        }
    }
}