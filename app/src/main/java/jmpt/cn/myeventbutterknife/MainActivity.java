package jmpt.cn.myeventbutterknife;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jmpt.cn.myeventbutterknife.adapter.MyFragmentAdapter;
import jmpt.cn.myeventbutterknife.event.QRCode;
import jmpt.cn.myeventbutterknife.fragment.AboutUsFragment;
import jmpt.cn.myeventbutterknife.fragment.GeneratFragment;
import jmpt.cn.myeventbutterknife.fragment.HistoryFragment;
import jmpt.cn.myeventbutterknife.fragment.ScanFragment;
import jmpt.cn.myeventbutterknife.util.QRCodeUtil;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    private List<Fragment> fragments;
    private String[] titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);  // 1 、绑定黄油刀事件

        fragments = new ArrayList<>();
        fragments.add(new GeneratFragment());
        fragments.add(new ScanFragment());
        fragments.add(new HistoryFragment());
        fragments.add(new AboutUsFragment());
        titles = getResources().getStringArray(R.array.tabs);

        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Bitmap bitmap = QRCodeUtil.createCodeBitmap(this, result, 350);
            if (bitmap != null) {
                QRCode qrCode = new QRCode(result,new Date(),bitmap,true);
                saveToDB(bitmap, qrCode);
                EventBus.getDefault().post(qrCode);
            }
        }
    }

    private void saveToDB(Bitmap bitmap, QRCode qrCode) {
        ByteArrayOutputStream bos  = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] bytes = bos.toByteArray();
        qrCode.setCode_bytes(bytes);
        qrCode.save();
        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
