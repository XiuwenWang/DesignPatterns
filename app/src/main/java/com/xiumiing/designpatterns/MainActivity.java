package com.xiumiing.designpatterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BaseQuickAdapter.OnItemClickListener {

    private RecyclerView mMRecycler;
    private ArrayList<String> mData = new ArrayList<>();
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        mMRecycler = findViewById(R.id.recycler);
        mMRecycler.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.main_item, mData) {
            @Override
            protected void convert(BaseViewHolder helper, String item) {
                helper.setText(R.id.tv_name, item);
            }

        };
        mAdapter.setOnItemClickListener(this);
        mMRecycler.setAdapter(mAdapter);
    }

    private void initData() {
        mData.add("单例模式");
        mData.add("适配器模式");
        mData.add("观察者模式");
        mData.add("工厂方法模式");
        mData.add("抽象工厂模式");
        mData.add("建造者模式");
        mData.add("桥接模式");
        mData.add("桥接模式");
        mData.add("组合模式");
        mData.add("装饰模式");
        mData.add("外观模式");
        mData.add("亨元模式");
        mData.add("代理模式");
        mData.add("访问者模式");
        mData.add("模板模式");
        mData.add("策略模式");
        mData.add("状态模式");
        mData.add("备忘录模式");
        mData.add("中介者模式");
        mData.add("迭代器模式");
        mData.add("解释器模式");
        mData.add("命令模式");
        mData.add("责任链模式");
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(this,mData.get(position),Toast.LENGTH_SHORT).show();
    }
}
