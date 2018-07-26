package com.smadmin.multiscreenapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.smadmin.multiscreenapp.di.ComponentsHelper;
import com.smadmin.multiscreenapp.items.ItemsListFragment;
import com.smadmin.multiscreenapp.navigator.NavigatorManager;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;

public class MainActivity extends AppCompatActivity {

    @Inject
    public NavigatorHolder navigatorHolder;

    private boolean tablet;
    private Navigator navigator;
    private NavigatorManager navigatorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inject(savedInstanceState);
        initToolbar();
        initViews();

        Resources res = getResources();
        tablet = res.getBoolean(R.bool.tablet);

        addLeftFragment();
        initNavigator();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    private void inject(Bundle bundle) {
        if (bundle == null) {
            ComponentsHelper.getMainAppComponent().inject(this);
        }
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    private void initViews() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void addLeftFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.left_frame_layout_list,
                        ItemsListFragment.newInstance(), ItemsListFragment.class.getSimpleName())
                .commit();
    }

    //TODO inject by dagger
    private void initNavigator() {
        navigatorManager = new NavigatorManager(this, tablet);
        navigator = navigatorManager.getNavigator();
    }
}
