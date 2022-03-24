package com.example.practice1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiscussionAdapter extends ArrayAdapter<Discussion> {

    Context context;
    int resource;
    List<Discussion> objects;

    public DiscussionAdapter(@NonNull Context context, int resource, @NonNull List<Discussion> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        DiscussionHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);

            holder = new DiscussionHolder();
            holder.image = (ImageView)row.findViewById(R.id.img);
            holder.nameFilm = (TextView)row.findViewById(R.id.name);
            holder.message = (TextView)row.findViewById(R.id.message);

            row.setTag(holder);
        }

        else {
            holder = (DiscussionHolder)row.getTag();
        }

        Discussion discussion = objects.get(position);
        holder.image.setImageResource(discussion.image);
        holder.nameFilm.setText(discussion.nameFilm);
        holder.message.setText(discussion.message);
        return row;
    }

    static class DiscussionHolder{
        TextView nameFilm;
        TextView message;
        ImageView image;
    }
}
