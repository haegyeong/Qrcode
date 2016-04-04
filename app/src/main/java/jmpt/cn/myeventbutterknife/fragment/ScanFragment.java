package jmpt.cn.myeventbutterknife.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jmpt.cn.myeventbutterknife.R;
import jmpt.cn.myeventbutterknife.event.QRCode;
import jmpt.cn.myeventbutterknife.zxing.activity.CaptureActivity;

/**
 * Created by Administrator on 2016-03-09.
 */
public class ScanFragment extends Fragment {

    private View view;

    @Bind(R.id.ivScanned)
    ImageView ivScanned;
    @Bind(R.id.btnScan)
    Button btnScan;
    @Bind(R.id.tvScanned)
    TextView tvScanned;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_scan, container, false);
            ButterKnife.bind(this, view);
        }

        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dealWithScanEvent(QRCode event){
        String str = tvScanned.getText().toString();
        Date date = event.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tvScanned.setText(event.getResult()+"\n"+sdf.format(date)+"\n\n"+str);
        ivScanned.setImageBitmap(event.getBitmap());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btnScan)
    public void startScan(View view) {
        startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
    }
}
