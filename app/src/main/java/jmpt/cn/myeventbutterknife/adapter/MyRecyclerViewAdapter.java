package jmpt.cn.myeventbutterknife.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import jmpt.cn.myeventbutterknife.R;
import jmpt.cn.myeventbutterknife.event.QRCode;

/**
 * Created by Administrator on 2016-03-09.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {


    private Context context;
    private List<QRCode> items;

    public MyRecyclerViewAdapter(Context context, List<QRCode> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        QRCode qrCode = items.get(position);
        holder.iv.setImageBitmap(qrCode.getBitmap());
        holder.tvText.setText(qrCode.getResult());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        holder.tvDate.setText(sdf.format(qrCode.getDate()));

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("操作");
                dialog.setItems(new String[]{"更新", "删除"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0){
                            //更新操作
                            updateQRCode(position);
                        }else if(which==1){
                            //删除操作
                            deleteQRCode(position);
                        }
                        dialog.dismiss();  //隐藏提示框
                    }
                });
                dialog.show();
                return true;
            }
        });

    }
    //删除二维码操作
    private void deleteQRCode(int position) {
        QRCode qrCode = items.get(position);
        qrCode.delete();
        items.remove(position);
        notifyDataSetChanged();
    }
    //更新二维码操作
    private void updateQRCode(int position) {
        QRCode qrCode = items.get(position);
        qrCode.setDate(new Date());
        qrCode.save();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class MyViewHolder extends  RecyclerView.ViewHolder{

        View itemView;

        @Bind(R.id.iv)
        ImageView iv;
        @Bind(R.id.tvText)
        TextView tvText;
        @Bind(R.id.tvDate)
        TextView tvDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this,itemView);
        }
    }
}
