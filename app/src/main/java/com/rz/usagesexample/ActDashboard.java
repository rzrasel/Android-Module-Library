package com.rz.usagesexample;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Rz Rasel on 2017-08-28.
 */

public class ActDashboard extends AppCompatActivity {
    private Activity activity;
    private Context context;
    private SpinalNavDrawerActivity spinalNavDrawerActivity;
    private TextView sysTvRowTitle;

    //|------------------------------------------------------------|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.act_dashboard);
        setContentView(R.layout.act_dashboard);
        activity = this;
        context = this;
        sysTvRowTitle = (TextView) findViewById(R.id.sysTvRowTitle);
        spinalNavDrawerActivity = new SpinalNavDrawerActivity(activity, context);
        //spinalNavDrawerActivity.onInitActivity(activity, context, (Toolbar) findViewById(R.id.sysToolBar));
        spinalNavDrawerActivity
                .onConfigureToolBar((Toolbar) findViewById(R.id.sysToolBar))
                .onConfigureDrawer((DrawerLayout) findViewById(R.id.sysDrawerLayout));
    }

    //|------------------------------------------------------------|
    @Override
    public boolean onOptionsItemSelected(MenuItem argMenuItem) {
        if (spinalNavDrawerActivity.onOptionsItemSelected(argMenuItem)) {
            return true;
        }
        return super.onOptionsItemSelected(argMenuItem);
    }

    //|------------------------------------------------------------|
    @Override
    public void onConfigurationChanged(Configuration argNewConfig) {
        super.onConfigurationChanged(argNewConfig);
        spinalNavDrawerActivity.onConfigurationChanged(argNewConfig);
    }
    //|------------------------------------------------------------|
}