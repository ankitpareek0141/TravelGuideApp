package com.example.travelguideapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    private ArrayList<Country> list;
    private Context context;
    private String type = "";
    private Util util;
    private Country country;

    public CountryAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<Country> list) {
        this.list = list;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recyclerview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.countryName.setText(list.get(position).getName());
        Glide.with(context)
                .asBitmap()
                .load(list.get(position).getImageurl())
                .into(holder.countryImage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, CountryActivity.class);
                intent.putExtra("countryID", list.get(position).getCountryId());
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                util = new Util();
                country = list.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                builder.setMessage("Do you want to delete this country from the list ?");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (type) {
                            case "wantToList":
                                if (util.removeWantToVisit(list.get(position))) {
                                    Toast.makeText(context, country.getName() + " has been successfully deleted from the 'want to visit' list", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                break;
                            case "alreadyVisitList":
                                if (util.removeAlredyVisited(list.get(position))) {
                                    Toast.makeText(context, country.getName() + " has been successfully deleted from the 'already visit' list", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                                break;
                        }
                    }
                });
                builder.create().show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView countryImage;
        TextView countryName;
        CardView cardView;

        public MyViewHolder(View viewitem) {
            super(viewitem);
            countryImage = viewitem.findViewById(R.id.countryImage);
            countryName = viewitem.findViewById(R.id.countryName);
            cardView = viewitem.findViewById(R.id.cardView);
        }
    }
}
