package com.example.jinyoungbang.jisocoffee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.jinyoungbang.jisocoffee.R.id.Menu;
import static com.example.jinyoungbang.jisocoffee.R.id.parent;

/**
 * Created by JinyoungBang on 2017-09-19.
 */

public class MenuAdapter extends BaseAdapter {

  ArrayList<MenuItem> arrayList = new ArrayList<MenuItem>();


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, viewGroup, false);
        }

        MenuItem item = arrayList.get(i);

        TextView menu = view.findViewById(R.id.Menu);
        TextView size = view.findViewById(R.id.Size);
        TextView count = view.findViewById(R.id.Count);

        menu.setText(item.getItemName());
        size.setText(item.getItemSize());
        count.setText(item.getItemNum());

        return view;
    }

    public void addItem(String Menu, String Size, String count) {
        MenuItem menuitem = new MenuItem();

         menuitem.setItemName(Menu);
         menuitem.setItemSize(Size);
         menuitem.setItemNum(count);

        arrayList.add(menuitem);
    }
}
