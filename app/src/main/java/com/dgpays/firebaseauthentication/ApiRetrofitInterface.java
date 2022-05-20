package com.dgpays.firebaseauthentication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRetrofitInterface {
    @GET("coins?list=BTC,BCH,BSV,ETH")
    Call<List<CoinResources>> getCoin();
}
