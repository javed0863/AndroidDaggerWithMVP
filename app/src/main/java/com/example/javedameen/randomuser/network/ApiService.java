package com.example.javedameen.randomuser.network;

import com.example.javedameen.randomuser.model.RandomUsers;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {

    @GET("api")
    Observable<RandomUsers> getRandomUsersOnGender(@Query("gender") String sex);

    @GET("api")
    Observable<RandomUsers> getRandomUser(@Query("seed") int id);

    @GET("api")
    Observable<RandomUsers> getRandomUsersMultiple(@Query("results") int size);
}