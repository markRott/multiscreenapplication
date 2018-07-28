package com.smadmin.multiscreenapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.items.ItemsListFragment;
import com.smadmin.multiscreenapp.navigator.NavigatorManager;
import com.smadmin.multiscreenapp.utils.ResourcesManager;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;

public class MainActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    NavigatorManager navigatorManager;
    @Inject
    ResourcesManager resourcesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inject(savedInstanceState);

        resourcesManager.setScreenOrientation(this);
        initToolbar();
        addLeftFragment();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigatorManager.getNavigator());
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    private void inject(Bundle bundle) {
        if (bundle == null) {
            ComponentsHelper.initActivityComponent(this).inject(this);
        }
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    private void addLeftFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.left_frame_layout_list,
                        ItemsListFragment.newInstance(), ItemsListFragment.class.getSimpleName())
                .commit();
    }
}
