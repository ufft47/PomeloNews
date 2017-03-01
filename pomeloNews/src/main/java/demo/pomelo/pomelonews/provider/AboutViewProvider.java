package demo.pomelo.pomelonews.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.pomelo.pomelonews.entity.About;
import demo.pomelo.pomelonews.R;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by UnclePomelo on 2017/2/5.
 */

public class AboutViewProvider extends ItemViewProvider<About,AboutViewProvider.AboutViewHolder>{
    @NonNull
    @Override
    protected AboutViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_fourth_about_logo,parent,false);

        return new AboutViewHolder(viewGroup);
    }

    @Override
    protected void onBindViewHolder(@NonNull AboutViewHolder holder, @NonNull About about) {

    }

    class AboutViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public AboutViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
        }
    }
}
