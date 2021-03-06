package com.example.deleting.timkiemvieclam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deleting.timkiemvieclam.R;
import com.example.deleting.timkiemvieclam.model.Job;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ITLAB on 3/22/2017.
 */

public class ListAdapter extends ArrayAdapter<Job> {

    public ListAdapter(Context context, int resource, ArrayList<Job> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_listview, null);
        }

        Job p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri

            TextView txt1 = (TextView) view.findViewById(R.id.tvJobtitle);
            txt1.setText(p.job_title);

            TextView txt2 = (TextView) view.findViewById(R.id.tvNamecompany);
            txt2.setText(p.job_contact_company);

            TextView txt3 = (TextView) view.findViewById(R.id.tvLocation);
            txt3.setText(p.location_name);

            TextView txt4 = (TextView) view.findViewById(R.id.tvSalary);
            if (p.job_fromsalary == 0 && p.job_tosalary == 0) {
                txt4.setText("Lương Thỏa Thuận");
            } else {
                if (p.salary_unit == null)
                {
                    txt4.setText(String.valueOf(p.job_fromsalary) + " - " + String.valueOf(p.job_tosalary) + " vnd");
                } else {
                    txt4.setText(String.valueOf(p.job_fromsalary) + " - " + String.valueOf(p.job_tosalary) + " " + p.salary_unit);
                }
            }

            TextView txt5 = (TextView) view.findViewById(R.id.tvDate);
            txt5.setText(p.date_view);

            ImageView img = (ImageView) view.findViewById(R.id.imvLogo);
            if (p.share_img == "") {
                img.setImageResource(R.drawable.ic_no_logo);
            } else {
                Picasso.with(getContext()).load(p.share_img).into(img);
            }
        }
        return view;
    }
}