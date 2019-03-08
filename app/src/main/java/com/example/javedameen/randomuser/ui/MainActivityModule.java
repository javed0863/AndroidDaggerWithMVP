package com.example.javedameen.randomuser.ui;

import android.content.Context;

import com.example.javedameen.randomuser.MainActivity;
import com.example.javedameen.randomuser.network.ApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainActivityContract.View provideMainView(MainActivity mainActivity){
        return mainActivity;
    }

    @Provides
    MainActivityContract.Presenter provideMainPresenter(MainActivityContract.View mainView, Context context, ApiService apiService){
        return new MainActivityPresenter(mainView, context, apiService);
    }

}
