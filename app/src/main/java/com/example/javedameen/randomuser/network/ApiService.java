package com.example.javedameen.randomuser.network;

import com.example.javedameen.randomuser.model.RandomUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;


public interface ApiService {

    @GET("api")
    Observable<RandomUsers> getRandomUsersOnGender(@Query("gender") String sex);

    @GET("api")
    Observable<RandomUsers> getRandomUser(@Query("seed") int id);

    @GET("api")
    Observable<RandomUsers> getRandomUsersMultiple(@Query("results") int size);
}