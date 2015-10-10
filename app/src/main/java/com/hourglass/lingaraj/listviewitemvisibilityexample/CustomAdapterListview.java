package com.hourglass.lingaraj.listviewitemvisibilityexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lingaraj on 9/28/15.
 */
public class CustomAdapterListview extends BaseAdapter {

    //private Context tcontext;
    private String[] itemValues;
    private LayoutInflater inflater;
    public  ViewHolder holder=null;


    CustomAdapterListview(Context context,String[] values)
    {
       // this.tcontext=context;
        this.itemValues=values;
        this.inflater=LayoutInflater.from(context);
    }


    public int getCount() {

        return itemValues.length;
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.layout_for_listview,null);
            holder=new ViewHolder();
            holder.tickMark=(ImageView) convertView.findViewById(R.id.tick_mark);
            holder.itemDataView=(TextView)convertView.findViewById(R.id.items);
            convertView.setTag(holder);

        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }

        holder.itemDataView.setText(itemValues[position]);
        if(MainActivity.tickMarkVisibileListPosition[position]==Boolean.TRUE)
        {
            holder.tickMark.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.tickMark.setVisibility(View.INVISIBLE);
        }







        return convertView;
    }
    static  class ViewHolder
    {
        TextView itemDataView;
        ImageView tickMark;
    }


}
