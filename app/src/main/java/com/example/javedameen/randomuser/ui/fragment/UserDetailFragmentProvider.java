package com.example.javedameen.randomuser.ui.fragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class UserDetailFragmentProvider {

    @ContributesAndroidInjector(modules = UserFragmentModule.class)
    abstract UserDetailFragment provideDetailFragmentFactory();
}
