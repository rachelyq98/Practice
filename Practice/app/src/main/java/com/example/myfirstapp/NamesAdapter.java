package com.example.myfirstapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rachelliu on 2017-05-04.
 */

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.MyViewHolder>  {

    private List<Person> namesList;

    private final Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name, idNum, avatar;

        public MyViewHolder (View view){
            super (view);
            name = (TextView) view.findViewById(R.id.name);
            idNum = (TextView) view.findViewById(R.id.idNum);
            avatar = (TextView) view.findViewById(R.id.avatar);
        }

        @Override
        public void onClick(View v) {
            Person person = namesList.get(getAdapterPosition());

            Toast.makeText(context, person.getName() + " is selected!", Toast.LENGTH_SHORT).show();
        }
    }

    public NamesAdapter(Context context){
        this.namesList = new ArrayList<>();
        this.context = context;
    }

    public void setItems(ArrayList<Person> items) {
        this.namesList = items;
        notifyDataSetChanged();
    }

    @Override
    public NamesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NamesAdapter.MyViewHolder holder, int position) {
        Person person = namesList.get(position);
        holder.name.setText(person.getName());
        holder.idNum.setText(person.getIdNum());
        holder.avatar.setText(person.getAvatar());
    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }
}
