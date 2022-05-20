package com.nadimmahmud.fuelmatrix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.nadimmahmud.fuelmatrix.Api.Service;
import com.nadimmahmud.fuelmatrix.Model.LoginModel;
import com.nadimmahmud.fuelmatrix.Model.Tank;
import com.nadimmahmud.fuelmatrix.Model.tankList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserListActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RecyclerView listView;
    AdapterClass adapterClass;
    ProgressDialog progressDialog;
    int userPostId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        getSupportActionBar().hide();
        sharedPreferences = getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        String userID= sharedPreferences.getString("userID",null);
        String password= sharedPreferences.getString("password",null);
        userPostId = sharedPreferences.getInt("userId",0);


        if (isConnected()){
            initialise();
            if (userPostId!=0){
                userPostRequest();
            }
        }

        final Handler ha=new Handler();
        ha.postDelayed(new Runnable() {

            @Override
            public void run() {
                //call function
                userPostRequest();
               /* Toast.makeText(UserListActivity.this,"return",Toast.LENGTH_SHORT).show();*/
                ha.postDelayed(this, 10000);
            }
        }, 10000);
    }


    private boolean isConnected() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            return true;
        } else
            return false;

    }
    private void initialise() {
        listView = findViewById(R.id.listView);
        listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        progressDialog = new ProgressDialog(UserListActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        sharedPreferences = getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void userPostRequest() {
        /*progressDialog.show();*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://us.infrmtx.com/iot/fuelmatix/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Service service = retrofit.create(Service.class);
        Call<tankList> call = service.getTankList(userPostId);
        call.enqueue(new Callback<tankList>() {
            @Override
            public void onResponse(Call<tankList> call, Response<tankList> response) {
                if (response.isSuccessful()){
                   /* progressDialog.dismiss();*/
                    List<Tank> tankList  = response.body().getTanks();
                    adapterClass(tankList);


                }else{
                  /*  progressDialog.dismiss();*/
                    Toast.makeText(UserListActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<tankList> call, Throwable t) {
              /*  progressDialog.dismiss();*/
                /*Toast.makeText(UserListActivity.this, "Status Error", Toast.LENGTH_SHORT).show();*/
            }
        });
    }
    private void adapterClass(List<Tank> listResult) {
        if (!listResult.isEmpty()){
            adapterClass = new AdapterClass(listResult,getApplicationContext());
            listView.setAdapter(adapterClass);
        }else{

            Log.e("msg","Not found");
        }
    }

}