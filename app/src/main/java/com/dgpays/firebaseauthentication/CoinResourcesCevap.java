package com.dgpays.firebaseauthentication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinResourcesCevap {
    @GET("coins?list=BTC")
    Call<CoinResources> getAllCoins();

}
