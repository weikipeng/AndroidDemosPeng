package com.pengjunwei.android.demos.ui;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.pengjunwei.android.demos.MainActivity;
import com.pengjunwei.android.demos.R;
import com.pengjunwei.android.demos.scroll.WeiScrollLayout;
import com.pengjunwei.android.demos.scroll.WeiWebView;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * Created by WikiPeng on 2017/3/4 10:40.
 */
public class WebViewRecyclerActivity extends AppCompatActivity implements BGARefreshLayout.BGARefreshLayoutDelegate {

    protected WeiWebView mWebView;

    protected RecyclerView mRecyclerView;

    protected WebRecyclerAdapter mRecyclerAdapter;


    //----------------------------------------------------------------
    //--------------------------------RecyclerView--------------------------------
    //----------------------------------------------------------------
    protected LinearLayoutManager mLinearLayoutManager;

    protected WeiScrollLayout mWeiScrollLayout;


    //----------------------------------------------------------------
    //--------------------------------注释--------------------------------
    //----------------------------------------------------------------
    private BGARefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview_recycler);

        initView();

        initData();
    }
//
//    protected Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            mWeiScrollLayout.scrollTo(0,666);
//            mWeiScrollLayout.requestLayout();
//        }
//    };

    protected void initData() {
        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerAdapter = new WebRecyclerAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);







        //----------------------------------------------------------------
        //--------------------------------注释--------------------------------
        //----------------------------------------------------------------
        WebSettings webSettings = mWebView.getSettings();
        String      oldUA       = webSettings.getUserAgentString();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setLightTouchEnabled(true);
        webSettings.setAppCacheEnabled(true);

        //
        webSettings.setDatabaseEnabled(true);
        webSettings.setGeolocationEnabled(true);

        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        //5.0
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        //支持上传文件
        webSettings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(0);
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB && Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        mWebView.setWebChromeClient(new WebChromeClient() {

        });
        mWebView.setWebViewClient(new WebViewClient(){

        });


        //----------------------------------------------------------------
        //--------------------------------注释--------------------------------
        //----------------------------------------------------------------
        mWebView.loadUrl("file:///android_asset/web_recyclerview_scroll.html");
    }

    protected void initView() {
        mRefreshLayout = (BGARefreshLayout) findViewById(R.id.rl_modulename_refresh);
        initRefreshLayout(mRefreshLayout);
        mWeiScrollLayout = (WeiScrollLayout) findViewById(R.id.rootLayout);
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


    private void initRefreshLayout(BGARefreshLayout refreshLayout) {
        mRefreshLayout = (BGARefreshLayout) findViewById(R.id.rl_modulename_refresh);
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(this, true);
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);

//
//        // 为了增加下拉刷新头部和加载更多的通用性，提供了以下可选配置选项  -------------START
//        // 设置正在加载更多时不显示加载更多控件
//        // mRefreshLayout.setIsShowLoadingMoreView(false);
//        // 设置正在加载更多时的文本
//        refreshViewHolder.setLoadingMoreText(loadingMoreText);
//        // 设置整个加载更多控件的背景颜色资源 id
//        refreshViewHolder.setLoadMoreBackgroundColorRes(loadMoreBackgroundColorRes);
//        // 设置整个加载更多控件的背景 drawable 资源 id
//        refreshViewHolder.setLoadMoreBackgroundDrawableRes(loadMoreBackgroundDrawableRes);
//        // 设置下拉刷新控件的背景颜色资源 id
//        refreshViewHolder.setRefreshViewBackgroundColorRes(refreshViewBackgroundColorRes);
//        // 设置下拉刷新控件的背景 drawable 资源 id
//        refreshViewHolder.setRefreshViewBackgroundDrawableRes(refreshViewBackgroundDrawableRes);
//        // 设置自定义头部视图（也可以不用设置）     参数1：自定义头部视图（例如广告位）， 参数2：上拉加载更多是否可用
//        mRefreshLayout.setCustomHeaderView(mBanner, false);
//        // 可选配置  -------------END
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        // 在这里加载最新数据

//        if (mIsNetworkEnabled) {
//            // 如果网络可用，则加载网络数据
//            new AsyncTask<Void, Void, Void>() {
//
//                @Override
//                protected Void doInBackground(Void... params) {
//                    try {
//                        Thread.sleep(MainActivity.LOADING_DURATION);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//
//                @Override
//                protected void onPostExecute(Void aVoid) {
//                    // 加载完毕后在 UI 线程结束下拉刷新
//                    mRefreshLayout.endRefreshing();
//                    mDatas.addAll(0, DataEngine.loadNewData());
//                    mAdapter.setDatas(mDatas);
//                }
//            }.execute();
//        } else {
//            // 网络不可用，结束下拉刷新
//            Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
//            mRefreshLayout.endRefreshing();
//        }
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        // 在这里加载更多数据，或者更具产品需求实现上拉刷新也可以

//        if (mIsNetworkEnabled) {
//            // 如果网络可用，则异步加载网络数据，并返回 true，显示正在加载更多
//            new AsyncTask<Void, Void, Void>() {
//
//                @Override
//                protected Void doInBackground(Void... params) {
//                    try {
//                        Thread.sleep(MainActivity.LOADING_DURATION);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//
//                @Override
//                protected void onPostExecute(Void aVoid) {
//                    // 加载完毕后在 UI 线程结束加载更多
//                    mRefreshLayout.endLoadingMore();
//                    mAdapter.addDatas(DataEngine.loadMoreData());
//                }
//            }.execute();
//
//            return true;
//        } else {
//            // 网络不可用，返回 false，不显示正在加载更多
//            Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        return true;
    }

    // 通过代码方式控制进入正在刷新状态。应用场景：某些应用在 activity 的 onStart 方法中调用，自动进入正在刷新状态获取最新数据
    public void beginRefreshing() {
        mRefreshLayout.beginRefreshing();
    }

    // 通过代码方式控制进入加载更多状态
    public void beginLoadingMore() {
        mRefreshLayout.beginLoadingMore();
    }

}
