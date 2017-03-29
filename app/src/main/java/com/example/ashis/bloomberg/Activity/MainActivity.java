package com.example.ashis.bloomberg.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ashis.bloomberg.Adapters.ArticlesAdapter;
import com.example.ashis.bloomberg.R;
import com.example.ashis.bloomberg.model.Articles;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url;
    RequestQueue queue;
    ArticlesAdapter adapter;
    List<Articles> articlesList;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articlesList=new ArrayList<>();
        url="https://newsapi.org/v1/articles?source=bloomberg&sortBy=top&apiKey=a136cfe6cfa444bb8f268167bd34f42c";
        queue= Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {


                     JSONArray jsonArray=response.getJSONArray("articles");


                     for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String title = obj.getString("title");
                        String description =obj.getString("description");
                        String author =  obj.getString("author");

                        Articles m = new Articles();
                        m.setTitle(title);
                        m.setDescription(description);
                        m.setAuthor(author);

                      articlesList.add(m);
                        Log.d("n1",title);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
                adapter = new ArticlesAdapter(articlesList,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

        queue.add(jsonObjectRequest);
    }
}
