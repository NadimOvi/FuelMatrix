package com.nadimmahmud.fuelmatrix;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nadimmahmud.fuelmatrix.Model.Tank;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    private List<Tank> list;
    private Context context;

    public AdapterClass(List<Tank> list, Context applicationContext) {
        this.list = list;
        this.context = applicationContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_holder,viewGroup,false);
        return new AdapterClass.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        Tank dataList = list.get(position);
        String tankNameShow = dataList.getTank_name();
        double heightShow = dataList.getHeight();
        double VolumeShow = dataList.getVolume();
        String height_unit = dataList.getHeight_unit();
        String volume_unit = dataList.getVolume_unit();

        holder.colorSet.setHeight((int) (VolumeShow-heightShow));
        /*holder.params.height = VolumeShow- heightShow+60;
        holder.colorSet.setLayoutParams(holder.params);*/

        /*holder.lp.height= 180;*/

        holder.tank_name.setText(tankNameShow);
        holder.height.setText(String.valueOf(heightShow+" "+height_unit));
        holder.volume.setText(String.valueOf(VolumeShow+" "+volume_unit));

        if (position % 4 == 0){
            holder.height.setBackgroundColor(Color.parseColor("#7F64DC"));

        }else if (position %3==0){
            holder.height.setBackgroundColor(Color.parseColor("#249262"));

        }else if (position %2 == 0){
            holder.height.setBackgroundColor(Color.parseColor("#DC64BC"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tank_name,colorSet,height,volume;
        LinearLayout heightLayout;
        ViewGroup.LayoutParams params;
        LinearLayout.LayoutParams lp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heightLayout = itemView.findViewById(R.id.heightLayout);
            tank_name = itemView.findViewById(R.id.tank_name);
            colorSet = itemView.findViewById(R.id.colorSet);

            height = itemView.findViewById(R.id.height);
            volume = itemView.findViewById(R.id.volume);
            params = colorSet.getLayoutParams();
            lp = (LinearLayout.LayoutParams) heightLayout.getLayoutParams();
        }
    }
}
