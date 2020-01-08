package com.hello.esoftwarica.Recycleview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hello.esoftwarica.R;
import com.hello.esoftwarica.UpdateActivity;

import java.util.List;

public class SoftwaricaAdapter extends RecyclerView.Adapter<SoftwaricaAdapter.SoftwaricaViewHolder> {
    Context mContext;
    List<Softwarica> softwaricaList;

    public SoftwaricaAdapter(Context mContext, List<Softwarica> softwaricaList) {
        this.mContext = mContext;
        this.softwaricaList = softwaricaList;
    }

    @NonNull
    @Override
    public SoftwaricaAdapter.SoftwaricaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_softwarica, parent, false);
        return new SoftwaricaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SoftwaricaAdapter.SoftwaricaViewHolder holder, final int position) {
        final Softwarica softwarica = softwaricaList.get(position);
        holder.tvName.setText(softwarica.getName());
        holder.tvAddress.setText(softwarica.getAddress());
        holder.tvGender.setText(softwarica.getGender());

        holder.tvAge.setText(softwarica.getAge()+"");


        holder.imgRemove.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_delete));
        String gender = softwarica.getGender();
        if (gender == "male") {
            holder.imgProfile.setImageResource(R.drawable.male);
        } else if (gender == "female") {
            holder.imgProfile.setImageResource(R.drawable.female);
        } else {
            holder.imgProfile.setImageResource(R.drawable.others);
        }


        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "hi " + softwarica.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Softwarica softwarica1 = softwaricaList.get(position);
                int index = softwaricaList.indexOf(softwarica1);
                UpdateActivity.index = index;
                Intent intent = new Intent(mContext,UpdateActivity.class);
                mContext.startActivity(intent);
            }
        });

        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Softwarica softwarica1 = softwaricaList.get(position);
                softwaricaList.remove(position);
                notifyItemRemoved(position);

                Toast.makeText(mContext, "Removed " + softwarica1.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return softwaricaList.size();
    }

    public class SoftwaricaViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvAddress, tvAge, tvGender;
        ImageView imgProfile, imgRemove,imgUpdate;

        public SoftwaricaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvAge = itemView.findViewById(R.id.tvage);
            tvGender = itemView.findViewById(R.id.tvgender);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            imgRemove = itemView.findViewById(R.id.imgRemove);
            imgUpdate=itemView.findViewById(R.id.imgupdate);

        }
    }
}