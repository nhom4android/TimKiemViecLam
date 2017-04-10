package com.example.deleting.timkiemvieclam.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.deleting.timkiemvieclam.R;
import com.example.deleting.timkiemvieclam.model.Job;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.key;

/**
 * Created by ITLAB on 3/22/2017.
 */

public class BookMarkAdapter extends ArrayAdapter<Job> {

    public BookMarkAdapter(Context context, int resource, ArrayList<Job> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.bookmark_item_listview, null);
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
                txt4.setText(String.valueOf(p.job_fromsalary) + " - " + String.valueOf(p.job_tosalary));
            }

            TextView txt5 = (TextView) view.findViewById(R.id.tvDate);
            txt5.setText(p.date_view);

            TextView txt6 = (TextView) view.findViewById(R.id.tvJobID);
            txt6.setText(String.valueOf(p.job_id));

            CheckBox chk = (CheckBox) view.findViewById(R.id.chkDelete);


            ImageView img = (ImageView) view.findViewById(R.id.imvLogo);
            Log.d("Hiep","IMG: " + p.getShare_img());
            Picasso.with(getContext()).load(p.share_img.toString()).into(img);

            //Log.d("test","AAA" + img7);
        }
        return view;
    }
}