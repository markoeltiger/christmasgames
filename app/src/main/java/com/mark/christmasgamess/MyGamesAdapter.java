package com.mark.christmasgamess;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyGamesAdapter extends RecyclerView.Adapter<MyGamesAdapter.ViewHolder>{
    ArrayList<gamedata> gamesData;
    Context context;

    public MyGamesAdapter( ArrayList<gamedata>  gamesData ,ChooseGame activity) {
        this.gamesData=gamesData;
        this.context=activity;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.card_cell,parent,false);
        ViewHolder viewHolder =new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final  gamedata gamedataList =gamesData.get(position);
            holder.gameCover.setImageResource(gamedataList.getGameImage());
            holder.gameName.setText(gamedataList.getGamename());
        holder.gameCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent gameIntnent = new Intent(context ,gameactivity.class);
             gameIntnent.putExtra("url",gamedataList.getGameURl());
             context.startActivity(gameIntnent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return gamesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gameCover;
        TextView gameName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        gameCover=itemView.findViewById(R.id.GameCover);
        gameName=itemView.findViewById(R.id.gameName);


        }
    }

}
