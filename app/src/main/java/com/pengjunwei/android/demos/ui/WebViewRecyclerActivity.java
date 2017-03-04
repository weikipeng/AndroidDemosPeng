package com.pengjunwei.android.demos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pengjunwei.android.demos.R;
import com.pengjunwei.android.demos.scroll.WeiWebView;

/**
 * Created by WikiPeng on 2017/3/4 10:40.
 */
public class WebViewRecyclerActivity extends AppCompatActivity {

    protected WeiWebView mWebView;

    protected RecyclerView mRecyclerView;

    protected WebRecyclerAdapter mRecyclerAdapter;


    //----------------------------------------------------------------
    //--------------------------------RecyclerView--------------------------------
    //----------------------------------------------------------------
    protected LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview_recycler);

        initView();

        initData();
    }

    protected void initData() {
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerAdapter = new WebRecyclerAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);


        //----------------------------------------------------------------
        //--------------------------------注释--------------------------------
        //----------------------------------------------------------------
        mWebView.loadUrl("file:///android_asset/web_recyclerview_scroll.html");
    }

    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mWebView = (WeiWebView) findViewById(R.id.webView);
    }

    public static class WebRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(parent.getContext());
            textView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                    50));
            return new TextViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TextViewHolder) {
                ((TextViewHolder) holder).setText("position ===" + position);
            }
        }

        @Override
        public int getItemCount() {
            return 30;
        }
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {
        public TextViewHolder(View itemView) {
            super(itemView);
        }

        public void setText(String text) {
            if (text == null) {
                text = "";
            }
            if (itemView instanceof TextView) {
                ((TextView) itemView).setText(text);
            }
        }
    }
}