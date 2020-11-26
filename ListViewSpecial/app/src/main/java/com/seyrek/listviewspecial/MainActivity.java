package com.seyrek.listviewspecial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ListItem> list = new ArrayList<>();
    LayoutInflater layoutInflater;
    TextView photoName;
    TextView owner;
    TextView link;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listView = findViewById(R.id.listView);

        list.add(new ListItem("Yellow Flower", "Mustafa SEYREK",
                "https://www.instagram.com/p/CGh6SV2AK9l/?utm_source=ig_web_copy_link", R.drawable.cicek));
        list.add(new ListItem("Shack", "Mustafa SEYREK",
                "https://www.instagram.com/p/CHNnflRAyXu/?utm_source=ig_web_copy_link", R.drawable.klube));
        list.add(new ListItem("Light", "Mustafa SEYREK",
                "https://www.instagram.com/p/CHf4wsVAsfv/?utm_source=ig_web_copy_link", R.drawable.isik));

        Adapter adapter = new Adapter();
        listView.setAdapter(adapter);


    }


    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.control_row_item, null);
            }

            photoName = view.findViewById(R.id.txtName);
            owner = view.findViewById(R.id.txtOwner);
            link = view.findViewById(R.id.txtLink);
            imageView = view.findViewById(R.id.imageView);

            photoName.setText(list.get(position).getPhotoName());
            owner.setText(list.get(position).getOwner());
            link.setText(list.get(position).getLink());
            imageView.setImageResource(list.get(position).getResourceId());
            return view;
        }
    }

    class ListItem {
        String photoName, owner, link;
        int resourceId;

        public ListItem(String photoName, String owner, String link, int resourceId) {
            this.photoName = photoName;
            this.owner = owner;
            this.link = link;
            this.resourceId = resourceId;
        }

        public String getPhotoName() {
            return photoName;
        }

        public String getOwner() {
            return owner;
        }

        public String getLink() {
            return link;
        }

        public int getResourceId() {
            return resourceId;
        }
    }
}
