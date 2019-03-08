package com.example.javedameen.randomuser.ui;

import android.app.ProgressDialog;

import com.example.javedameen.randomuser.model.RandomUsers;

public interface MainActivityContract {

    interface View{

        void showResult(RandomUsers result);

        void showProgress();

        void dismissProgress();
    }

    interface Presenter {

        void getRandomUsersMultiple(int size);

        void getRandomUsersOnGender(String sex);

        void getRandomUser(int id);

    }
}
