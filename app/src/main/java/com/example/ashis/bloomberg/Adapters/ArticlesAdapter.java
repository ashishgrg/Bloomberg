package com.example.ashis.bloomberg.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ashis.bloomberg.R;
import com.example.ashis.bloomberg.model.Articles;

import java.util.List;

/**
 * Created by ashis on 12/30/2016.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {
    private List<Articles> articlesList;
    private Context context;

    public ArticlesAdapter(List<Articles> articlesList, Context context) {
        this.articlesList = articlesList;
        this.context = context;
    }

    private Context getContext() {
        return context;
    }
    @Override
    public ArticlesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View contactView = inflater.inflate(R.layout.custom, parent, false);


        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArticlesAdapter.ViewHolder viewHolder, int position) {

        Articles articles = articlesList.get(position);

        TextView title= viewHolder.title;
        title.setText(articles.getTitle());
        TextView author=viewHolder.author;
        author.setText(articles.getAuthor());
        TextView description=viewHolder.description;
        description.setText(articles.getDescription());


    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }
    public static  class ViewHolder extends RecyclerView.ViewHolder {

        public TextView author;
        public TextView title;
        public TextView description;

        public ViewHolder(View itemView) {

            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            description = (TextView) itemView.findViewById(R.id.desc);


        }
    }
}
