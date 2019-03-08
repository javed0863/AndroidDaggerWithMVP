package com.example.javedameen.randomuser.ui.fragment;

import javax.inject.Inject;

public class UserDetailFragmentpresenter implements UserDetailFragmentContract.Presenter {

    UserDetailFragmentContract.View mView;

    @Inject
    public UserDetailFragmentpresenter(UserDetailFragmentContract.View mView){
        this.mView = mView;
    }

    @Override
    public void getData() {
        mView.loadData("Hello World");
    }
}
