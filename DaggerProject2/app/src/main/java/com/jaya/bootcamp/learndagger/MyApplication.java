package com.jaya.bootcamp.learndagger;

import android.app.Application;

import com.jaya.bootcamp.learndagger.data.local.DatabaseService;
import com.jaya.bootcamp.learndagger.data.remote.NetworkService;
import com.jaya.bootcamp.learndagger.di.component.ApplicationComponent;
import com.jaya.bootcamp.learndagger.di.component.DaggerApplicationComponent;
import com.jaya.bootcamp.learndagger.di.module.ApplicationModule;

import javax.inject.Inject;

public class MyApplication extends Application {

    public ApplicationComponent applicationComponent;

    @Inject
    NetworkService networkService;

    @Inject
    DatabaseService databaseService;

    @Override
    public void onCreate() {
        super.onCreate();
        getDependencies();
    }

    public void getDependencies() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }
}