package com.example.recycleviewwithlistener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHlder>{

     Context context;
     ArrayList<Player> playerList;
     private OnRecycleViewItemClickListener onRecycleViewItemClickListener;

    public interface OnRecycleViewItemClickListener
    {
        void onRecycleViewItemClick(int position);
    }

    public void setOnRecycleViewItemClickListener(OnRecycleViewItemClickListener listener)
    {
        onRecycleViewItemClickListener = listener;
    }

    public PlayerAdapter(Context context, ArrayList<Player> playerList) {
        this.context = context;
        this.playerList = playerList;
       // this.onRecycleViewItemClickListener = onRecycleViewItemClickListener;
    }

    @NonNull
    @Override
    public PlayerViewHlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_demo,parent,false);
        PlayerViewHlder holder = new PlayerViewHlder(view,onRecycleViewItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHlder holder, int position) {

        Player player = playerList.get(position);
        holder.textViewName.setText(player.getName());
        holder.textViewCountry.setText(player.getCountry());
        holder.textViewRank.setText(player.getRankId());

        holder.imageView.setImageDrawable(context.getResources().getDrawable(player.getImageId()));

    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class PlayerViewHlder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName,textViewRank,textViewCountry;

        public PlayerViewHlder(@NonNull View itemView, final OnRecycleViewItemClickListener listener) {
            super(itemView);


            imageView = itemView.findViewById(R.id.image_id_demo_ac);
            textViewName = itemView.findViewById(R.id.name_text_id_demo_ac);
            textViewRank = itemView.findViewById(R.id.rank_id_demo_ac);
            textViewCountry = itemView.findViewById(R.id.coutry_id_demo_ac);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onRecycleViewItemClick(position);
                        }
                    }
                }
            });

        }


    }





}
