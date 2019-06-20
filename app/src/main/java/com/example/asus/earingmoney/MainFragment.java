package com.example.asus.earingmoney;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.asus.earingmoney.adapter.ListViewAdapter_missions;
import com.example.asus.earingmoney.model.Mission;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private static final String ARG_SHOW_TEXT = "text";

    private String token;
    private Spinner spinner1, spinner2, spinner3, spinner4;
    private service myservice;
    private ServiceFactory serviceFactory;
    private SharedPreferences user_shared_preference;
    private List<Mission> missionslist = new ArrayList<Mission>();
    public ListViewAdapter_missions adapter;
    private ListView listview;


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SHOW_TEXT, param1);
        fragment.setArguments(args);
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
        View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        setHasOptionsMenu(true);

        spinner1 = rootView.findViewById(R.id.spinner1);
        spinner2 = rootView.findViewById(R.id.spinner2);
        spinner3 = rootView.findViewById(R.id.spinner3);
        spinner4 = rootView.findViewById(R.id.spinner4);
        String[] mItems1 = getResources().getStringArray(R.array.spin1);
        String[] mItems2 = getResources().getStringArray(R.array.spin2);
        String[] mItems3 = getResources().getStringArray(R.array.spin3);
        String[] mItems4 = getResources().getStringArray(R.array.spin4);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item, mItems1);
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item, mItems2);
        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item, mItems3);
        ArrayAdapter<String> adapter4=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item, mItems4);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //绑定 Adapter到控件
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
//        TextView contentTv = rootView.findViewById(R.id.content_tv);
//        contentTv.setText(mContentText);

//        serviceFactory = new ServiceFactory();
//        myservice = serviceFactory.CreatService();
//
//        listview = rootView.findViewById(R.id.list);
//        adapter = new ListViewAdapter_missions(getActivity(), R.layout.mission_item, missionslist);
//        listview.setAdapter(adapter);
//
//        user_shared_preference = getActivity().getSharedPreferences("user", 0);
//        token = user_shared_preference.getString("token",null);
//
//        Observer<List<Mission>> observer = new Observer<List<Mission>>() {
//            @Override
//            public void onNext(List<Mission> missions) {
//                for(Mission i : missions){
//                    if(i.getTitle().toUpperCase().equals(songname.toUpperCase())){
//                        number = i.getNumber();
//                        getGithubComments(number);
//                        if(i.getComments().equals("0"))
//                            Toast.makeText(ChatActivity.this,"目前还没有任何评论", Toast.LENGTH_SHORT).show();
//                        haveissue = true;
//                    }
//                }
//                if(!haveissue){
//                    postGithubIssue(songname);
//                }
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        };
//        myservice.getMissions(token)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MissionDetailActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

}
