package com.jaya.bootcamp.learndagger.ui.home;

import com.jaya.bootcamp.learndagger.data.local.DatabaseService;
import com.jaya.bootcamp.learndagger.data.remote.NetworkService;
import com.jaya.bootcamp.learndagger.di.scope.FragmentScope;
import com.jaya.bootcamp.learndagger.utils.NetworkHelper;

import javax.inject.Inject;

@FragmentScope
public class HomeViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;
    private NetworkHelper networkHelper;

    @Inject
    public HomeViewModel(DatabaseService databaseService,
                         NetworkService networkService,
                         NetworkHelper networkHelper) {
        this.databaseService = databaseService;
        this.networkService = networkService;
        this.networkHelper = networkHelper;
    }

    public String getSomeData() {
        return databaseService.getDummyData()
                + " : " + networkService.getDummyData()
                + " : " + networkHelper.isNetworkConnected();
    }
}
