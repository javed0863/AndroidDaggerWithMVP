package com.example.javedameen.randomuser.ui;

import android.content.Context;

import com.example.javedameen.randomuser.MainActivity;
import com.example.javedameen.randomuser.network.ApiService;
import com.example.javedameen.randomuser.ui.fragment.UserDetailFragment;
import com.example.javedameen.randomuser.ui.fragment.UserFragmentModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

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
