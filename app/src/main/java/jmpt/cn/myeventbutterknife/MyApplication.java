package jmpt.cn.myeventbutterknife;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;

import jmpt.cn.myeventbutterknife.event.QRCode;

/**
 * Created by Administrator on 2016-03-10.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);   //初始化数据库依赖包
        Select select = new Select(); //创建查询对象
       ShareData.datas = select.from(QRCode.class).orderBy("id desc").execute();  //程序创建的时候，将数据库的所有数据查询出来到缓存中
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();  //释放数据库依赖包
    }
}
