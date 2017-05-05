package com.example.myfirstapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rachelliu on 2017-05-03.
 */

public class WebAPIActivity extends AppCompatActivity {

    TextView txtString;
    public String url = "https://reqres.in/api/users/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_display);
        Intent intent = getIntent();
        txtString = (TextView) findViewById(R.id.webInfo);
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String jsonData = response.body().string();
                String output = "";
                try {
                    JSONObject obj = new JSONObject(jsonData);
                    JSONArray jsonArray = obj.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject newObj = jsonArray.getJSONObject(i);
                        output += newObj.getString("first_name") + "\n";
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final String result = output;
                WebAPIActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (txtString != null) {
//                            try {
//                                JSONObject json = new JSONObject(jsonData);
//                                txtString.setText(json.toString());
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
                            txtString.setText(result);
                        }
                    }
                });
            }
        });
    }
}
