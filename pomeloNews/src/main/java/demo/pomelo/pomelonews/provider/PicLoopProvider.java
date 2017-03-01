package demo.pomelo.pomelonews.provider;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.PicLoop;
import it.sephiroth.android.library.picasso.Picasso;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by UnclePomelo on 2017/2/4.
 */

public class PicLoopProvider extends ItemViewProvider<PicLoop, PicLoopProvider.PicLoopViewHolder> {

    @NonNull
    @Override
    protected PicLoopViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        Banner banner = (Banner) inflater.inflate(R.layout.fragment_third_picloop, parent, false);
        return new PicLoopViewHolder(banner);
    }

    @Override
    protected void onBindViewHolder(@NonNull PicLoopViewHolder holder, @NonNull final PicLoop picLoop) {


        holder.banner
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setIndicatorGravity(BannerConfig.CENTER)
                .setImages(picLoop.getImageList())
                .setBannerTitles(picLoop.getTitles())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, final Object path, ImageView imageView) {
                        Picasso.with(context).load((String) path).into(imageView);
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int index = picLoop.getPicUrls().indexOf(path);
                                onLoopClickListener.onLoopClick(picLoop.getIds().get(index));
                            }
                        });
                    }
                })
                .setDelayTime(5000)
                .start();

    }

    class PicLoopViewHolder extends RecyclerView.ViewHolder {
        Banner banner;

        public PicLoopViewHolder(Banner banner) {
            super(banner);
            this.banner = banner;
        }
    }

    public interface OnLoopClickListener{
        void onLoopClick(String id);
    }
    OnLoopClickListener onLoopClickListener;
    public void setOnLoopClickListener(OnLoopClickListener onLoopClickListener){
        this.onLoopClickListener = onLoopClickListener;
    }
}
