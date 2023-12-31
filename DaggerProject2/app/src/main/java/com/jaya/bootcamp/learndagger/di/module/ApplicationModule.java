package com.jaya.bootcamp.learndagger.di.module;

import android.content.Context;

import com.jaya.bootcamp.learndagger.MyApplication;
import com.jaya.bootcamp.learndagger.di.qualifier.ApplicationContext;
import com.jaya.bootcamp.learndagger.di.qualifier.DatabaseInfo;
import com.jaya.bootcamp.learndagger.di.qualifier.NetworkInfo;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @ApplicationContext
    @Provides
    Context provideContext() {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "dummy_db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 1;
    }

    @Provides
    @NetworkInfo
    String provideApiKey() {
        return "SOME_API_KEY";
    }
}
