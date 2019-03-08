package com.example.javedameen.randomuser.ui.fragment;

public interface UserDetailFragmentContract {

    interface View{
        void loadData(String javed);
    }

    interface Presenter {
        void getData();
    }
}
