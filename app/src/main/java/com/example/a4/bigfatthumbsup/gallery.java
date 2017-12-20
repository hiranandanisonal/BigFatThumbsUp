package com.example.a4.bigfatthumbsup;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A4 on 12/17/2017.
 */

public class gallery extends Fragment implements ViewPager.OnPageChangeListener,TabHost.OnTabChangeListener{
    ViewPager vp;
    TabHost th;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gallery_fragment,container,false);
    }
    @Override
    public void onResume() {
        super.onResume();
        /*((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Filing FIR");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(null);*/
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViewpager(view);
        initTabhost(view);

    }

    private void initTabhost(View view) {
        th=(TabHost)view.findViewById(R.id.tabhost);
        th.setup();


        String[] tabnames= {"FIR", "Medical","Counselling"};

        for(int i=0;i<tabnames.length;i++)
        {
            TabHost.TabSpec tabspec;
            tabspec= th.newTabSpec(tabnames[i]);
            tabspec.setIndicator(tabnames[i]);
            tabspec.setContent(new FakeContent(getActivity()));
            th.addTab(tabspec);
        }
        th.setOnTabChangedListener(this);

    }

    private void initViewpager(View view) {
        vp=(ViewPager) view.findViewById(R.id.vp);
        List<Fragment> vpList=new ArrayList<Fragment>();
        vpList.add(new FIR());
        vpList.add(new medical());
        vpList.add(new Counselling());

        TabAdapter tabAdapter=new TabAdapter(getFragmentManager(),vpList);
        vp.setAdapter(tabAdapter);
        vp.addOnPageChangeListener(this);
    }

    //OnPage..........
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        th.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    //OnTab........
    @Override
    public void onTabChanged(String s) {
        int selectedTab=th.getCurrentTab();
        vp.setCurrentItem(selectedTab);
    }


    class FakeContent implements TabHost.TabContentFactory
    {
        Context c;
        FakeContent(Context c)
        {
            this.c=c;
        }

        @Override
        public View createTabContent(String s) {
            View fakeView=new View(c);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

}


