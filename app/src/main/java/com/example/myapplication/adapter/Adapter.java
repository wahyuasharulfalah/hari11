package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

import com.example.myapplication.model.Data;

;

public class Adapter extends BaseAdapter {
    Activity activity;
    LayoutInflater layoutInflater;
    List<Data> items;

    public Adapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater==null){
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.list_row,null);
            TextView id = view.findViewById(R.id.txtId);
            TextView nama = view.findViewById(R.id.txtName);
            TextView address = view.findViewById(R.id.txtAddress);
            Data data = items.get(i);
            id.setText(data.getId());
            nama.setText(data.getNama());
            address.setText(data.getAddress());
        }
        return view;
    }
}

