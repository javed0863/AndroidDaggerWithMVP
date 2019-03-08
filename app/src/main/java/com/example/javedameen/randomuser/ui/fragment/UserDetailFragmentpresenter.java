package com.example.javedameen.randomuser.ui.fragment;

import com.example.javedameen.randomuser.ui.fragment.UserDetailFragmentContract.Presenter;

import javax.inject.Inject;

public class UserDetailFragmentpresenter implements UserDetailFragmentContract.Presenter {

    UserDetailFragmentContract.View mView;

    @Inject
    public UserDetailFragmentpresenter(UserDetailFragmentContract.View mView){
        this.mView = mView;
    }

    @Override
    public void getData() {
        mView.loadData("Javed");
    }
}
