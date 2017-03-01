package demo.pomelo.pomelonews.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.Zhihu;
import it.sephiroth.android.library.picasso.Picasso;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by UnclePomelo on 2017/2/15.
 */
public class ZhihuItemViewProvider
        extends ItemViewProvider<Zhihu.NewsBean, ZhihuItemViewProvider.ViewHolder> {

    public ZhihuItemViewProvider() {
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_third_more_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull final Zhihu.NewsBean newsBean) {
        holder.imageView.setTag(newsBean.getThumbnail());
        holder.tvTitle.setTag(newsBean.getTitle());

        Picasso.with(holder.itemView.getContext())
                .load((String) holder.imageView.getTag())
                .resize(150,150)
                .into(holder.imageView);
        holder.tvTitle.setText((String) holder.tvTitle.getTag());

        holder.viewGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(onItemClickListener!=null){
                   onItemClickListener.onItemClick(newsBean.getId());
               }
            }
        });

    }

    public interface OnItemClickListener {
        void onItemClick(String id);
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvTitle;
        ViewGroup viewGroup;
        ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.viewGroup = viewGroup;
            imageView = (ImageView) viewGroup.findViewById(R.id.iv_image_fragment_third_more_item);
            tvTitle = (TextView) viewGroup.findViewById(R.id.tv_title_fragment_third_more_item);
        }
    }
}