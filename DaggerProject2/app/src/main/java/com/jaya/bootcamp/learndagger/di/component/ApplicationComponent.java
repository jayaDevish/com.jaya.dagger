package com.jaya.bootcamp.learndagger.di.component;

import android.content.Context;

import com.jaya.bootcamp.learndagger.MyApplication;
import com.jaya.bootcamp.learndagger.data.local.DatabaseService;
import com.jaya.bootcamp.learndagger.data.remote.NetworkService;
import com.jaya.bootcamp.learndagger.di.module.ApplicationModule;
import com.jaya.bootcamp.learndagger.di.qualifier.ApplicationContext;
import com.jaya.bootcamp.learndagger.utils.NetworkHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @ApplicationContext
    Context getContext();

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();

    NetworkHelper getNetworkHelper();
}
