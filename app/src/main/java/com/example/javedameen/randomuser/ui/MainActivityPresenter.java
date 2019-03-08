package com.example.javedameen.randomuser.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.javedameen.randomuser.R;
import com.example.javedameen.randomuser.model.RandomUsers;
import com.example.javedameen.randomuser.network.ApiService;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mView;
    private Context mContext;
    private ApiService mApiService;
    private ProgressDialog progress;

    private Observer<RandomUsers> mRandomUsersObserver = new Observer<RandomUsers>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(RandomUsers value) {
            Log.d("RandomUser",value.toString());
            mView.showResult(value);
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onComplete() {
            mView.dismissProgress();
        }
    };

    @Inject
    public MainActivityPresenter(MainActivityContract.View view, Context context, ApiService apiService){
        mView = view;
        mContext = context;
        mApiService = apiService;
    }

    @Override
    public void getRandomUsersMultiple(int size) {
        mApiService.getRandomUsersMultiple(size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mRandomUsersObserver);

    }

    @Override
    public void getRandomUsersOnGender(String sex) {
        mApiService.getRandomUsersOnGender(sex)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mRandomUsersObserver);
    }

    @Override
    public void getRandomUser(int id) {
        mApiService.getRandomUser(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mRandomUsersObserver);
    }


}
