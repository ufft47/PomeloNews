package demo.pomelo.pomelonews.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.Text;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by UnclePomelo on 2017/2/5.
 */

public class TextViewProvider extends ItemViewProvider<Text, TextViewProvider.TextViewHolder> {

    String source;

    public TextViewProvider() {

    }

    public TextViewProvider(String source) {
        this.source = source;
    }

    @NonNull
    @Override
    protected TextViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
            TextView textView = (TextView) inflater.inflate(R.layout.fragment_fourth_text, parent, false);
            return new TextViewHolder(textView);
    }

    @Override
    protected void onBindViewHolder(@NonNull TextViewHolder holder, @NonNull final Text text) {
            //第四个页面
            holder.textView.setText(text.getText());
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public TextViewHolder(View view) {
            super(view);
            textView = (TextView) view;
        }
    }
}
