package com.dgpays.firebaseauthentication;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.dgpays.firebaseauthentication.databinding.ActivityHomeBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ApiRetrofitInterface apiInterface;
    private List<CoinResources> dataArrayList;
    private ActivityHomeBinding binding;
    Handler mHandler;
    NumberFormat formatter = new DecimalFormat("##.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        apiInterface = ApiRetrofitClient.getClient().create(ApiRetrofitInterface.class);
        getCoins();
        setContentView(binding.getRoot());
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_out_left);
        this.mHandler = new Handler();
        m_Runnable.run();
    }

    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
            getCoins();
            HomeActivity.this.mHandler.postDelayed(m_Runnable,2000);
        }

    };

    public void getCoins() {
        dataArrayList = new ArrayList<>();
        Call<List<CoinResources>> call = apiInterface.getCoin();
        call.enqueue(new Callback<List<CoinResources>>() {
            @Override
            public void onResponse(Call<List<CoinResources>> call, Response<List<CoinResources>> response) {
                Log.e("DGPAYSIT", "onResponse : " + response.body());
                dataArrayList = response.body();
                updateUICoins();
            }

            @Override
            public void onFailure(Call<List<CoinResources>> call, Throwable t) {
                Log.e("DGPAYSIT", "onResponse Fail : " + t.getLocalizedMessage());

            }
        });
    }

    public void updateUICoins() {
        binding.textBtcPrice.setText("$" + formatter.format(dataArrayList.get(0).getPrice()));
        binding.textBtcName.setText(dataArrayList.get(0).getCoin() + " - " + dataArrayList.get(0).getName());
        binding.textBtcPriceSubs.setText("$" + formatter.format(dataArrayList.get(0).getPrice()));

        binding.textBchPrice.setText("$" + formatter.format(dataArrayList.get(1).getPrice()));
        binding.textBchName.setText(dataArrayList.get(0).getCoin() + " - " + dataArrayList.get(1).getName());
        binding.textBchPriceSubs.setText("$" + formatter.format(dataArrayList.get(1).getPrice()));

        binding.textBsvPrice.setText("$" + formatter.format(dataArrayList.get(2).getPrice()));
        binding.textBsvName.setText(dataArrayList.get(0).getCoin() + " - " + dataArrayList.get(2).getName());
        binding.textBsvPriceSubs.setText("$" + formatter.format(dataArrayList.get(2).getPrice()));

        binding.textEthPrice.setText("$" + formatter.format(dataArrayList.get(3).getPrice()));
        binding.textEthName.setText(dataArrayList.get(0).getCoin() + " - " + dataArrayList.get(3).getName());
        binding.textEthPriceSubs.setText("$" + formatter.format(dataArrayList.get(3).getPrice()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_out_right);
    }
}