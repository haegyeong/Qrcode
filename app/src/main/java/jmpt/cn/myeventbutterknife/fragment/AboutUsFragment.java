package jmpt.cn.myeventbutterknife.fragment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jmpt.cn.myeventbutterknife.R;

/**
 * Created by Administrator on 2016-03-10.
 */
public class AboutUsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private View view;
    private SharedPreferences spf;
    int redProgress = 0;
    int greenProgress = 0;
    int blueProgress = 0;

    @Bind(R.id.red)
    SeekBar red;
    @Bind(R.id.green)
    SeekBar green;
    @Bind(R.id.blue)
    SeekBar blue;
    @Bind(R.id.qrbg)
    TextView qrbg;
    @Bind(R.id.layout)
    LinearLayout layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        spf = getActivity().getSharedPreferences("color",getActivity().MODE_PRIVATE);
        redProgress = spf.getInt("red", 0);
        greenProgress = spf.getInt("green", 0);
        blueProgress = spf.getInt("blue",0);

        red.setProgress(redProgress);
        green.setProgress(greenProgress);
        blue.setProgress(blueProgress);
        qrbg.setTextColor(Color.rgb(redProgress, greenProgress, blueProgress));
        layout.setBackgroundColor(Color.rgb(redProgress, greenProgress, blueProgress));
        red.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);

        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.red:
                redProgress = seekBar.getProgress();
                Log.i("main", "redProgress: " + redProgress);
                break;
            case R.id.green:
                greenProgress = seekBar.getProgress();
                Log.i("main", "greenProgress: " + greenProgress);
                break;
            case R.id.blue:
                blueProgress = seekBar.getProgress();
                Log.i("main", "blueProgress: " + blueProgress);
                break;

        }
        qrbg.setTextColor(Color.rgb(redProgress, greenProgress, blueProgress));
        layout.setBackgroundColor(Color.rgb(redProgress, greenProgress, blueProgress));
        SharedPreferences.Editor edit = spf.edit();
        edit.putInt("red",redProgress);
        edit.putInt("green",greenProgress);
        edit.putInt("blue",blueProgress);
        edit.commit();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
