package com.example.faustin.ocactivite2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

/**
 * Created by faustin on 6/25/17.
 */

public class FakeNewsAdapter extends RecyclerView.Adapter<FakeNewsAdapter.FakeNewsViewHolder> {

    private List<FakeNews> fakeNewsList;

    public FakeNewsAdapter(){
        this.fakeNewsList = FakeNewsList.all;
    }

    @Override
    public int getItemCount() {
        return this.fakeNewsList.size();
    }

    /**
     * creates a finite number of FakeNewsViewHolder
     * @param parent
     * @param viewType
     * @return FakeNewsViewHolder
     */
    @Override
    public FakeNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // get the title cell view and ...
        View titleCellView = inflater.inflate(R.layout.title_cell, parent, false);

        // give it to the View holder
        return new FakeNewsViewHolder(titleCellView);
    }

    @Override
    public void onBindViewHolder(FakeNewsViewHolder holder, int position) {
        FakeNews news = this.fakeNewsList.get(position);
        holder.display(news);
    }

    public class FakeNewsViewHolder extends RecyclerView.ViewHolder{

        /**
         * will bind to the title cell
         */
        private final TextView newsTitle;

        private FakeNews currentNews;


        public FakeNewsViewHolder(final View FakeNewTitleView){
            super(FakeNewTitleView);

            newsTitle = FakeNewTitleView.findViewById(R.id.titleCell);

            // click event handler for the title cell
            FakeNewTitleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send the article to Article activity
                    Intent showNewsIntent = new Intent(view.getContext(), ArticleActivity.class);
                    showNewsIntent.putExtra("newsTitle", currentNews.title);
                    showNewsIntent.putExtra("newsHtmlContent", currentNews.htmlContent);

                    view.getContext().startActivity(showNewsIntent);

                }
            });
        }

        /**
         * writes the title of the given news into a newsTitle cell
         * @param news
         */
        public void display(FakeNews news){
            currentNews = news;
            newsTitle.setText(news.title);
        }

    }
}
