package jmpt.cn.myeventbutterknife.event;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by Administrator on 2016-03-09.
 */
@Table(name="tb_qrcode")
public class QRCode extends Model {

    @Column
    private String result;
    @Column
    private Date date;
    @Column
    private boolean isFromScaned;
    @Column
    private byte[] code_bytes;  //图片数据，用于保存bitmap到数据库
    private Bitmap bitmap;   //bitmap显示

    public QRCode() {
    }

    public QRCode(String result, Date date, boolean isFromScaned, byte[] code_bytes) {
        this.result = result;
        this.date = date;
        this.isFromScaned = isFromScaned;
        this.code_bytes = code_bytes;
    }

    public QRCode(String result, Date date, Bitmap bitmap, boolean isFromScaned) {
        this.result = result;
        this.date = date;
        this.bitmap = bitmap;
        this.isFromScaned = isFromScaned;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bitmap getBitmap() {
        if (bitmap==null && code_bytes!=null){
            bitmap = BitmapFactory.decodeByteArray(code_bytes,0,code_bytes.length);
        }
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public boolean isFromScaned() {
        return isFromScaned;
    }

    public void setIsFromScaned(boolean isFromScaned) {
        this.isFromScaned = isFromScaned;
    }

    public byte[] getCode_bytes() {
        return code_bytes;
    }

    public void setCode_bytes(byte[] code_bytes) {
        this.code_bytes = code_bytes;
        if (bitmap==null){
            bitmap = BitmapFactory.decodeByteArray(code_bytes,0,code_bytes.length);
        }
    }
}
