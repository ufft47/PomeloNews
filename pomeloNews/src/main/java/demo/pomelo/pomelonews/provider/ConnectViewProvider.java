package demo.pomelo.pomelonews.provider;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import demo.pomelo.pomelonews.entity.Connect;
import demo.pomelo.pomelonews.R;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by UnclePomelo on 2017/2/5.
 */

public class ConnectViewProvider extends ItemViewProvider<Connect, ConnectViewProvider.TelephoneViewHolder> {

    @NonNull
    @Override
    protected TelephoneViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_fourth_connect, parent, false);
        return new TelephoneViewHolder(viewGroup);
    }

    @Override
    protected void onBindViewHolder(@NonNull TelephoneViewHolder holder, @NonNull final Connect connect) {
        holder.iv_icon.setBackgroundResource(connect.getIconRes());
        holder.tv_connect.setText(connect.getInfo());
        holder.tv_way.setText(connect.getWay());
        if (connect.getSendRes() != 0) {
            holder.iv_msg.setBackgroundResource(connect.getSendRes());

            holder.iv_msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (connect.getInfo().equals("181-1122-2321")) {
                        ClipboardManager cm = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        cm.setText("18111222321");
                        Toast.makeText(v.getContext(), "已将号码复制到剪切板", Toast.LENGTH_SHORT).show();
                    }else if (connect.getInfo().equals("pomeloJiang@gmail.com")){
                        ClipboardManager cm = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        cm.setText("pomeloJiang@gmail.com");
                        Toast.makeText(v.getContext(), "已将邮件地址复制到剪切板", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {
             holder.tv_connect.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if(connect.getInfo().equals("https://github.com/pomeloJiang")){
                         ClipboardManager cm = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                         cm.setText("https://github.com/pomeloJiang");
                         Toast.makeText(v.getContext(), "已将网址复制到剪切板", Toast.LENGTH_SHORT).show();
                     }
                 }
             });
        }


    }

    class TelephoneViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_icon;
        TextView tv_connect;
        TextView tv_way;
        ImageView iv_msg;

        public TelephoneViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            iv_icon = (ImageView) viewGroup.findViewById(R.id.iv_icon_fragment_fourth_connect);
            tv_connect = (TextView) viewGroup.findViewById(R.id.tv_tel_fragment_fourth_connect);
            tv_way = (TextView) viewGroup.findViewById(R.id.tv_mobile_fragment_fourth_connect);
            iv_msg = (ImageView) viewGroup.findViewById(R.id.iv_msg_fragment_fourth_connect);
        }
    }
}
