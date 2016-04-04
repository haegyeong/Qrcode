package jmpt.cn.myeventbutterknife.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.LinkedList;

import butterknife.Bind;
import butterknife.ButterKnife;
import jmpt.cn.myeventbutterknife.ShareData;
import jmpt.cn.myeventbutterknife.adapter.MyRecyclerViewAdapter;
import jmpt.cn.myeventbutterknife.R;
import jmpt.cn.myeventbutterknife.event.QRCode;

/**
 * Created by Administrator on 2016-03-09.
 */
public class HistoryFragment extends Fragment {

    private View view;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.tvNodata)
    TextView tvNodata;

    private MyRecyclerViewAdapter adapter;
    private LinkedList<QRCode> items =new LinkedList<>();

    public HistoryFragment() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        items.addAll(ShareData.datas);
        adapter = new MyRecyclerViewAdapter(getActivity(), items);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_history, container, false);
            ButterKnife.bind(this, view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }
        if (items.size()==0){
            recyclerView.setVisibility(View.GONE);
            tvNodata.setVisibility(View.VISIBLE);
        }else{
            recyclerView.setVisibility(View.VISIBLE);
            tvNodata.setVisibility(View.GONE);
        }
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dealWithQRCode(QRCode qrCode){
        items.addFirst(qrCode);
        if (adapter!=null){
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }

}
