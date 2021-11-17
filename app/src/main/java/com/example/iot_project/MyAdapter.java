package com.example.iot_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {
    ArrayList<DeviceInfo> dataHolder;

    public MyAdapter(ArrayList<DeviceInfo> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.deviceName.setText(dataHolder.get(position).getDeviceName());
        holder.ipAddress.setText(dataHolder.get(position).getIpAddress());
        holder.area.setText(dataHolder.get(position).getArea());
        holder.status.setText(dataHolder.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView deviceName, ipAddress, area, status;
        public myViewHolder(@NonNull View itemView){
            super(itemView);
            deviceName = (TextView) itemView.findViewById(R.id.deviceName);
            ipAddress = (TextView)  itemView.findViewById(R.id.ipAddress);
            area = (TextView) itemView.findViewById(R.id.area);
            status = (TextView) itemView.findViewById(R.id.status);

        }
    }
}
