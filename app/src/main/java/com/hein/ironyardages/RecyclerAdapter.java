package com.hein.ironyardages;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

    //Create a list
    List<Club> clubList;

    public RecyclerAdapter(List<Club>clubList) {
        this.clubList = clubList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvClub.setText(clubList.get(position).getClub());
        holder.tvMen.setText(clubList.get(position).getMen());
        holder.tvWomen.setText(clubList.get(position).getWomen());


    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvClub, tvMen, tvWomen;
        Button btnDelete, btnUpdate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClub = itemView.findViewById(R.id.club);
            tvMen = itemView.findViewById(R.id.men);
            tvWomen = itemView.findViewById(R.id.women);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Club clubs = new Club();
            long ID = clubList.get(getAbsoluteAdapterPosition()).getId();

            clubs.setId(ID);

            MainActivity.clubDatabase.clubDAO().delete(clubs);
            MainActivity.fragmentManager.beginTransaction()
                    .replace(R.id.Container,new ViewFragment(), null)
                    .commit();

        }
    }
}
