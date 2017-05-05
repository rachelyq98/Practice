package com.example.myfirstapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rachelliu on 2017-05-04.
 */

public class DisplayFinalActivity extends AppCompatActivity {

    public String url = "https://reqres.in/api/users/";
    private RecyclerView recyclerView;
    private NamesAdapter peopleAdapter;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_names);
        Intent intent = getIntent();

        peopleAdapter = new NamesAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler__view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(peopleAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void run() throws IOException {
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
                String name = "";
                String id = "";
                String avatar ="";

                try {
                    JSONObject obj = new JSONObject(jsonData);
                    JSONArray jsonArray = obj.getJSONArray("data");
                    final ArrayList<Person> people = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject newObj = jsonArray.getJSONObject(i);
                        name = newObj.getString("first_name") + " " + newObj.getString("last_name");
                        id = newObj.getString("id");
                        avatar = newObj.getString("avatar");
                        people.add(new Person(name, id, avatar));
                    }

                    DisplayFinalActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            peopleAdapter.setItems(people);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
