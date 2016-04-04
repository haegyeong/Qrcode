package jmpt.cn.myeventbutterknife.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.google.zxing.WriterException;

import jmpt.cn.myeventbutterknife.zxing.encoding.EncodingHandler;


/**
 * Created by idea on 2016/3/9.
 */
public class QRCodeUtil {

    public static Bitmap createCodeBitmap(Context context, String str,int size){
        try {
            if (!str.equals("")) {
                //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                Bitmap qrCodeBitmap = EncodingHandler.createQRCode(context,str, size);
                return qrCodeBitmap;
            }else {
                Toast.makeText(context, "Text can not be empty", Toast.LENGTH_SHORT).show();
            }
        } catch (WriterException e) {
            e.printStackTrace();
        }

        return null;
    }

}
