package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WeatherDataClass> weatherDataClass;

    public WeatherAdapter(Context context, ArrayList<WeatherDataClass> weatherDataClass) {
        this.context = context;
        this.weatherDataClass = weatherDataClass;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        WeatherDataClass model = weatherDataClass.get(position);
        holder.tempratureTV.setText(model.getTemprature() + "°c");
        Picasso.get().load("http:".concat(model.getIcon())).into(holder.conditionIV);
        holder.windTV.setText(model.getWindSpeed() + "Km/Hr");
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");

        try{
            Date t = input.parse(model.getTime());
            holder.timeTv.setText(output.format(t));
        }catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return weatherDataClass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView windTV, tempratureTV,timeTv;
        private ImageView conditionIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            windTV = itemView.findViewById(R.id.wind_speed);
            tempratureTV = itemView.findViewById(R.id.temp_display);
            timeTv = itemView.findViewById(R.id.time);
            conditionIV = itemView.findViewById(R.id.condition_image);

        }
    }
}
