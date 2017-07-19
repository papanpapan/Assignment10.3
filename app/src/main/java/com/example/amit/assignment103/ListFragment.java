package com.example.amit.assignment103;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListFragment extends Fragment {
String[]site={"Youtube","Blogger"};
    ListView listView;
    ArrayList<CustomHandler>model=new ArrayList<>();
    public ListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview= inflater.inflate(R.layout.fragment_list, container, false);
        listView=(ListView)rootview.findViewById(R.id.list);
        for(int i=0;i<site.length;i++){
            CustomHandler customHandler=new CustomHandler();
            customHandler.setName(site[i]);
            customHandler.setDescription(site[i]+"Description");
            model.add(customHandler);
            CustomAdapter adapter=new CustomAdapter(this,model);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Toast.makeText(getContext(),"Click On..." +site[position],Toast.LENGTH_SHORT).show();
                }
            });
        }
        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }


}
