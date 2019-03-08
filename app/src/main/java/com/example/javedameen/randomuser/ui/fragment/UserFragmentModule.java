package com.example.javedameen.randomuser.ui.fragment;

import dagger.Module;
import dagger.Provides;

@Module
public class UserFragmentModule {

    @Provides
    UserDetailFragmentContract.View provideDetailFragmentView(UserDetailFragment detailFragment){
        return detailFragment;
    }

    @Provides
    UserDetailFragmentContract.Presenter provideDetailFragmentPresenter(UserDetailFragmentContract.View view){
        return new UserDetailFragmentpresenter(view);
    }

}
