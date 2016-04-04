package jmpt.cn.myeventbutterknife.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import jmpt.cn.myeventbutterknife.R;
import jmpt.cn.myeventbutterknife.event.QRCode;
import jmpt.cn.myeventbutterknife.util.QRCodeUtil;

/**
 * Created by Administrator on 2016-03-09.
 */
public class GeneratFragment extends Fragment {

    @Bind(R.id.textInputLayout)
    TextInputLayout textInputLayout;
    @Bind(R.id.btnDelete)
    Button btnDelete;
//    @Bind(R.id.editText)
    EditText editText ;
    @Bind(R.id.btnGenerate)
    Button btnGenerate;
    @Bind(R.id.btnDiscard)
    Button btnDiscard;
    @Bind(R.id.btnSave)
    Button btnSave;
    @Bind(R.id.tvHint)
    TextView tvHint;
    @Bind(R.id.ivGenerated)
    ImageView ivGenerated;


    private View view;
    private String text;
    private Bitmap codeBitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_generate, container, false);
            ButterKnife.bind(this, view);
            editText = textInputLayout.getEditText();
        }
        return view;
    }

    @OnClick(R.id.btnDelete)
    public void clearText(View view) {
        editText.setText("");
    }

    @OnClick(R.id.btnGenerate)
    public void generate(View view) {
        text = editText.getText().toString();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(getActivity(), "生成二维码的字符不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        codeBitmap = QRCodeUtil.createCodeBitmap(getActivity(), text, 350);
        ivGenerated.setImageBitmap(codeBitmap);
        btnGenerate.setVisibility(View.GONE);

    }

    @OnClick(R.id.btnDiscard)
    public void discard(View view) {
        editText.setText("");
//        btnGenerate.setVisibility(View.VISIBLE);
//        ivGenerated.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.background));

    }

    @OnClick(R.id.btnSave)
    public void save(View view) {
        if (codeBitmap != null) {
            text = editText.getText().toString();
            QRCode qrCode = new QRCode(text, new Date(), codeBitmap, false);
            saveToDB(qrCode);
            EventBus.getDefault().post(qrCode);
        }

    }

    private void saveToDB(QRCode qrCode) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            codeBitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
            byte[] bytes = bos.toByteArray();
            String filePath = Environment.getExternalStorageDirectory()+File.separator+"QRCode";
//            String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + File.separator + System.currentTimeMillis() + ".png";
            File file = new File(filePath);
            if (!file.exists()){
                file.mkdir();
            }
            bos.write(bytes, 0, bytes.length);

            qrCode.setCode_bytes(bytes);
            Long saveId = qrCode.save();//执行保存到数据库中
            Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
            Log.i("main", "saveToDB: saveID =  " + saveId);
            String fileName = filePath+File.separator+System.currentTimeMillis()+".png";
            FileOutputStream out = new FileOutputStream(new File(fileName));
            out.write(bytes, 0, bytes.length);
            out.flush();
            bos.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnTextChanged(R.id.editText)
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        tvHint.setText("当前已输入" + s.length() + "个字符");
        btnGenerate.setVisibility(View.GONE);
        if(s.length()==0){
            return;
        }
        codeBitmap = QRCodeUtil.createCodeBitmap(getActivity(), s.toString(), 350);
        ivGenerated.setImageBitmap(codeBitmap);
//        ivGenerated.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.background));
    }

}
