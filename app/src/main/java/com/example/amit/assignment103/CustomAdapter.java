package com.example.amit.assignment103;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.*;

/**
 * Created by Amit on 6/16/2017.
 */

public class CustomAdapter extends BaseAdapter {
    ListFragment context;
    ArrayList<CustomHandler>data;
    LayoutInflater inflater;
    int[]siteimg={R.drawable.youtttube,R.drawable.blogger};
    public CustomAdapter(ListFragment context, ArrayList<CustomHandler> data) {
        this.context=context;
        this.data=data;
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertview, ViewGroup viewGroup) {
        Holder holder=new Holder();
        if(convertview==null){
            inflater=(LayoutInflater)context.getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            inflater.inflate(R.layout.row,null);
        }
        holder.tex1=(TextView)convertview.findViewById(R.id.tet1);
        holder.tex2=(TextView)convertview.findViewById(R.id.tet2);
        holder.img=(ImageView) convertview.findViewById(R.id.img);
        holder.tex1.setText(data.get(position).getName());
        holder.tex1.setText(data.get(position).getDescription());
        holder.img.setBackground(ContextCompat.getDrawable(context.getContext(),siteimg[position]));
        return convertview;


    }
    public class Holder{
        TextView tex1,tex2;
        ImageView img;
    }
}
