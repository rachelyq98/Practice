package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rachelliu on 2017-05-02.
 */

public class DisplayRecyclerActivity extends AppCompatActivity {
    private List<Movie> moviesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate (savedInstanceState);
        setContentView(R.layout.content_main);

        Intent intent = getIntent();
        mAdapter = new MoviesAdapter(moviesList);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener(){
            public void onClick (View view, int position){
                Movie movie = moviesList.get (position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }
            public void onLongClick (View view, int position){
            }
        }));
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        prepareMovieData ();
    }

    private void prepareMovieData(){
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        moviesList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        moviesList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        moviesList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        moviesList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        moviesList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        moviesList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        moviesList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        moviesList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        moviesList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        moviesList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        moviesList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        moviesList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        moviesList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        moviesList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        moviesList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        moviesList.add(movie);

        mAdapter.notifyDataSetChanged();

    }


}
