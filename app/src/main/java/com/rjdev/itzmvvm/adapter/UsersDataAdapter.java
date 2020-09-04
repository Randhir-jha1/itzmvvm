package com.rjdev.itzmvvm.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.rjdev.itzmvvm.R;
import com.rjdev.itzmvvm.model.UsersDataModel;

import java.util.ArrayList;


public class UsersDataAdapter extends RecyclerView.Adapter<UsersDataAdapter.ViewHolder> {

    Context context;
    private ArrayList<UsersDataModel> data_list;

    String str_id,str_status,str_abs,str_pres,str_day;
    public UsersDataAdapter(ArrayList<UsersDataModel> data_list, Context context) {

        this.data_list = data_list;
        this.context = context;
    }

    @NonNull
    @Override
    public UsersDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new UsersDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UsersDataAdapter.ViewHolder holder, int position) {
        holder.tv_empid.setText(data_list.get(position).getEmployee_id());
        holder.tv_empname.setText(data_list.get(position).getName());
        holder.tv_loc.setText(data_list.get(position).getLocation_name());
        holder.tv_status.setText(data_list.get(position).getD_I());
        holder.tv_id.setText(data_list.get(position).getId());
        holder.tv_tabs.setText(data_list.get(position).getTotal_absent());
        holder.tv_tprsnt.setText(data_list.get(position).getTotal_present());

        if (holder.tv_status.getText().toString().contains("P"))
        {
            holder.tv_status.setTextColor(Color.parseColor("#24756D"));
            holder.ll_pop.setBackgroundColor(Color.parseColor("#24756D"));

        }else if (holder.tv_status.getText().toString().contains("A"))
        {
            holder.tv_status.setTextColor(Color.parseColor("#DE1D34"));
            holder.ll_pop.setBackgroundColor(Color.parseColor("#DE1D34"));
        }else
        {
            holder.tv_status.setTextColor(Color.parseColor("#36B9CC"));
            holder.ll_pop.setBackgroundColor(Color.parseColor("#DE1D34"));
        }
        holder.ll_main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str_id = holder.tv_id.getText().toString() ;
                str_abs = holder.tv_tabs.getText().toString() ;
                str_pres = holder.tv_tprsnt.getText().toString() ;

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                    alertDialog.setMessage("Please select");

                    alertDialog.setPositiveButton("Present", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {
                         str_status = "P";

                        }
                    });
                    alertDialog.setNegativeButton("Absent", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            str_status ="A";

                        }
                    });

                    alertDialog.show();
                }

        });

    }

    @Override
    public int getItemCount() {
        return data_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_empid,tv_empname;

        TextView tv_status,tv_id,tv_tabs,tv_tprsnt,tv_loc;

        LinearLayout ll_main_layout,ll_pop;
        public ViewHolder(View itemView) {

            super(itemView);
            tv_empid = itemView.findViewById(R.id.tv_empid);
            tv_empname = itemView.findViewById(R.id.tv_empname);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_tabs = itemView.findViewById(R.id.tv_tabs);
            tv_tprsnt = itemView.findViewById(R.id.tv_tprsnt);
            ll_main_layout = itemView.findViewById(R.id.ll_main_layout);
            ll_pop = itemView.findViewById(R.id.ll_pop);
            tv_loc = itemView.findViewById(R.id.tv_loc);

        }
    }



}
