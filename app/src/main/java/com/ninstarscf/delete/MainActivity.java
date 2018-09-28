package com.ninstarscf.delete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
/*
    private ImageView address_book_iv;
    private ImageView add_friend_iv;
    private TextView search;
    *//*private RelativeLayout search_rlv;*/
    private SwipeRecycleView friend_message_rv;
    private SmartRefreshLayout friend_smartefresh;
    private List<QQPointBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mList.add(new QQPointBean(R.mipmap.ic_launcher,"牛牛集团"+i,"你好在ma"+i,"12:59",i));
        }
        initView();
    }

    private void initView() {
      /*  address_book_iv = (ImageView) findViewById(R.id.address_book_iv);
        add_friend_iv = (ImageView) findViewById(R.id.add_friend_iv);
        search = (TextView) findViewById(R.id.search);
        search_rlv = (RelativeLayout) findViewById(R.id.search_rlv);*/
        friend_message_rv = (SwipeRecycleView) findViewById(R.id.friend_message_rv);
        friend_smartefresh = (SmartRefreshLayout) findViewById(R.id.friend_smartefresh);
        friend_message_rv.setLayoutManager(new LinearLayoutManager(this));
        FriendAdapter swipeAdapter = new FriendAdapter(mList);
        friend_message_rv.setAdapter(swipeAdapter);
        swipeAdapter.setOnClickListener(new FriendAdapter.OnClickListener() {
            @Override
            public void onHeadImgClickListener(int position) {
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClickListener(int position, SwipeMenuLayout swipeMenuLayout) {
                if (swipeMenuLayout.isMenuOpen()){
                    swipeMenuLayout.smoothToCloseMenu();
                }

            }

            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
