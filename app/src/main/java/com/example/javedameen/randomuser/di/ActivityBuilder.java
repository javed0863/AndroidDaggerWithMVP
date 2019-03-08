package com.example.javedameen.randomuser.di;

import com.example.javedameen.randomuser.MainActivity;
import com.example.javedameen.randomuser.ui.MainActivityModule;
import com.example.javedameen.randomuser.ui.fragment.UserDetailFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, UserDetailFragmentProvider.class})
    abstract MainActivity bindMainActivity();


//    @ContributesAndroidInjector(modules = {DetailActivityModule.class, DetailFragmentProvider.class})
//    abstract DetailActivity bindDetailActivity();

}
