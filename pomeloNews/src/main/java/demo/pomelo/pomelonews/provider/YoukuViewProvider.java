package demo.pomelo.pomelonews.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youku.player.VideoDefinition;
import com.youku.player.base.YoukuPlayerView;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.Youku;
import demo.pomelo.pomelonews.utils.PicassoTransformation;
import demo.pomelo.pomelonews.view.MainActivity;
import it.sephiroth.android.library.picasso.Picasso;
import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.Items;

/**
 * Created by UnclePomelo on 2017/2/17.
 */
public class YoukuViewProvider
        extends ItemViewProvider<Youku.VideosBean, YoukuViewProvider.ViewHolder> {

    Items items;
    int playPosition;

    public YoukuViewProvider(Items items) {
        this.items = items;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_second_youku, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, @NonNull final Youku.VideosBean videosBean) {

        holder.youkuPlayerView.setTag(videosBean.getId());
        holder.ivCover.setTag(videosBean.getThumbnail());
        holder.tvTitle.setTag(videosBean.getTitle());
        holder.tvSeconds.setTag(videosBean.getSeconds());
        holder.tvUpCounts.setTag(videosBean.getUp_count());
        holder.tvDownCounts.setTag(videosBean.getDown_count());

        PicassoTransformation transformation = new PicassoTransformation(holder.itemView, 1);
        Picasso.with(holder.itemView.getContext())
                .load((String) holder.ivCover.getTag())
                .transform(transformation)
                .into(holder.ivCover);
        holder.tvTitle.setText((String) holder.tvTitle.getTag());
        holder.tvSeconds.setText((String) holder.tvSeconds.getTag());
        holder.tvUpCounts.setText((String) holder.tvUpCounts.getTag());
        holder.tvDownCounts.setText((String) holder.tvDownCounts.getTag());

        //判断是否播放过
        if (videosBean.isPlayed()) {
            if (holder.youkuPlayerView.isPlaying()) {
                holder.youkuPlayerView.pause();
                videosBean.setPlayed(false);
            }
        }

        int currentPosition = items.indexOf(videosBean);
        if (currentPosition - playPosition >= 1 || currentPosition - playPosition <= -1) {
            holder.youkuPlayerView.stop();
            holder.youkuPlayerView.release();
            holder.ivPlay.setVisibility(View.VISIBLE);
            holder.ivCover.setVisibility(View.VISIBLE);
        }


        holder.youkuPlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.youkuPlayerView.isPlaying()) {
                    holder.youkuPlayerView.pause();
                } else {
                    holder.youkuPlayerView.play();
                }
            }
        });




        holder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ivPlay.setVisibility(View.GONE);
                holder.ivCover.setVisibility(View.GONE);
                holder.youkuPlayerView.playYoukuVideo((String) holder.youkuPlayerView.getTag());
                playPosition = items.indexOf(videosBean);
                videosBean.setPlayed(true);
            }
        });

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        YoukuPlayerView youkuPlayerView;
        ImageView ivCover;
        ImageView ivPlay;
        TextView tvTitle;
        TextView tvSeconds;
        TextView tvUpCounts;
        TextView tvDownCounts;

        ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            youkuPlayerView = (YoukuPlayerView) viewGroup.findViewById(R.id.youku_player_fragment_second_youku);
            ivCover = (ImageView) viewGroup.findViewById(R.id.iv_cover_fragment_second_youku);
            ivPlay = (ImageView) viewGroup.findViewById(R.id.iv_play_fragment_second_youku);
            tvTitle = (TextView) viewGroup.findViewById(R.id.tv_title_fragment_second_youku);
            tvSeconds = (TextView) viewGroup.findViewById(R.id.tv_seconds_fragment_second_youku);
            tvUpCounts = (TextView) viewGroup.findViewById(R.id.tv_up_fragment_second_youku);
            tvDownCounts = (TextView) viewGroup.findViewById(R.id.tv_down_fragment_second_youku);

            initYoukuPlayerView(youkuPlayerView);
        }

        private void initYoukuPlayerView(YoukuPlayerView youkuPlayerView) {
            // 初始化播放器
            youkuPlayerView.attachActivity(new MainActivity());
            youkuPlayerView.setPreferVideoDefinition(VideoDefinition.VIDEO_HD);
        }
    }
}