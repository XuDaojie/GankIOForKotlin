package io.github.xudaojie.gankioforkotlin.test;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import io.github.xudaojie.gankioforkotlin.BaseFragment;
import io.github.xudaojie.gankioforkotlin.R;

/**
 * Created by xdj on 16/9/10.
 */

public class TestToolbarFragment extends BaseFragment {

    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @android.support.annotation.Nullable ViewGroup container, @android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setMRoot(inflater.inflate(R.layout.detail_frag, container, false));
        Toolbar toolbar = (Toolbar) getMRoot().findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_share) {
                    return true;
                }
                return false;
            }
        });
        return getMRoot();
    }
}
