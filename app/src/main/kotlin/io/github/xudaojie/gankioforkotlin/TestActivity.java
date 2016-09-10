package io.github.xudaojie.gankioforkotlin;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import org.jetbrains.annotations.Nullable;

import io.github.xudaojie.gankioforkotlin.adapter.TestAdapter;
import io.github.xudaojie.gankioforkotlin.bean.DayData;
import io.github.xudaojie.gankioforkotlin.data.Api;
import io.github.xudaojie.gankioforkotlin.data.remote.GankIoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static io.github.xudaojie.gankioforkotlin.R.id.recycler_view;

/**
 * Created by xdj on 16/9/9.
 */

public class TestActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_act);

        final RecyclerView recyclerView = (RecyclerView) findViewById(recycler_view);

        GankIoService service = Api.INSTANCE.net().create(GankIoService.class);
        String dateFormat = "2016/09/09";
        service.day(dateFormat).enqueue(new Callback<DayData>() {
            @Override
            public void onResponse(Call<DayData> call, Response<DayData> response) {
                RecyclerViewExpandableItemManager expMgr = new RecyclerViewExpandableItemManager(null);

                recyclerView.setLayoutManager(new LinearLayoutManager(getMActivity()));
                recyclerView.setAdapter(expMgr.createWrappedAdapter(new TestAdapter()));

                // NOTE: need to disable change animations to ripple effect work properly
                ((SimpleItemAnimator)recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

                expMgr.attachRecyclerView(recyclerView);
            }

            @Override
            public void onFailure(Call<DayData> call, Throwable t) {

            }
        });
    }
}
