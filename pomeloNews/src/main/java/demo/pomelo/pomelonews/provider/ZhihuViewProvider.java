package demo.pomelo.pomelonews.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.Zhihu;
import demo.pomelo.pomelonews.utils.PicassoTransformation;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.Transformation;
import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.Items;

import static demo.pomelo.pomelonews.R.id.iv_pic_1_fragment_third_zhihu;
import static demo.pomelo.pomelonews.R.id.tv_title_1_fragment_third_zhihu;

/**
 * Created by UnclePomelo on 2017/2/12.
 */
public class ZhihuViewProvider
        extends ItemViewProvider<Zhihu, ZhihuViewProvider.ViewHolder> {

    Items items;
    int position;

    public ZhihuViewProvider(Items items) {
        this.items = items;
    }


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_third_zhihu, parent, false);
        return new ViewHolder(viewGroup);
    }

    @Override
    protected void onBindViewHolder(@NonNull final ViewHolder holder, @NonNull final Zhihu zhihu) {
        position  = items.indexOf(zhihu);

        Transformation transformation = new PicassoTransformation(holder.itemView, 2.1);

        holder.imageView_1.setTag(zhihu.getNews().get(1).getImage());
        holder.tvTitle_1.setTag(zhihu.getNews().get(1).getTitle());
        holder.imageView_2.setTag(zhihu.getNews().get(2).getImage());
        holder.tvTitle_2.setTag(zhihu.getNews().get(2).getTitle());
        holder.imageView_3.setTag(zhihu.getNews().get(3).getImage());
        holder.tvTitle_3.setTag(zhihu.getNews().get(3).getTitle());
        holder.imageView_4.setTag(zhihu.getNews().get(4).getImage());
        holder.tvTitle_4.setTag(zhihu.getNews().get(4).getTitle());

        if (position != 1) {
            holder.tvCategory.setText(zhihu.getDisplay_date());
        }
        holder.relMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onMoreClickListener != null) {
                    onMoreClickListener.onMoreClick(zhihu, holder.itemView.getContext());
                }
            }
        });

        Picasso.with(holder.itemView.getContext())
                .load((String) holder.imageView_1.getTag())
                .transform(transformation)
                .into(holder.imageView_1);
        Picasso.with(holder.itemView.getContext())
                .load((String) holder.imageView_2.getTag())
                .transform(transformation)
                .into(holder.imageView_2);
        Picasso.with(holder.itemView.getContext())
                .load((String) holder.imageView_3.getTag())
                .transform(transformation)
                .into(holder.imageView_3);
        Picasso.with(holder.itemView.getContext())
                .load((String) holder.imageView_4.getTag())
                .transform(transformation)
                .into(holder.imageView_4);
        holder.tvTitle_1.setText((String) holder.tvTitle_1.getTag());
        holder.tvTitle_2.setText((String) holder.tvTitle_2.getTag());
        holder.tvTitle_3.setText((String) holder.tvTitle_3.getTag());
        holder.tvTitle_4.setText((String) holder.tvTitle_4.getTag());


        holder.imageView_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(1).getId());
            }
        });
        holder.imageView_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(2).getId());
            }
        });
        holder.imageView_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(3).getId());
            }
        });
        holder.imageView_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(4).getId());
            }
        });
        holder.tvTitle_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(1).getId());
            }
        });
        holder.tvTitle_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(2).getId());
            }
        });
        holder.tvTitle_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(3).getId());
            }
        });
        holder.tvTitle_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(zhihu.getNews().get(4).getId());
            }
        });
    }

     class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategory;
        RelativeLayout relMore;

        GridLayout gridLayout;
        ImageView imageView_1;
        ImageView imageView_2;
        ImageView imageView_3;
        ImageView imageView_4;

        TextView tvTitle_1;
        TextView tvTitle_2;
        TextView tvTitle_3;
        TextView tvTitle_4;

        ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            Log.i("TAG","position:"+position);

            tvCategory = (TextView) viewGroup.findViewById(R.id.tv_category_fragment_third_zhihu);
            relMore = (RelativeLayout) viewGroup.findViewById(R.id.relativelayout_fragment_third_zhihu);

            gridLayout = (GridLayout) viewGroup;
            imageView_1 = (ImageView) viewGroup.findViewById(iv_pic_1_fragment_third_zhihu);
            tvTitle_1 = (TextView) viewGroup.findViewById(tv_title_1_fragment_third_zhihu);
            imageView_2 = (ImageView) viewGroup.findViewById(R.id.iv_pic_2_fragment_third_zhihu);
            tvTitle_2 = (TextView) viewGroup.findViewById(R.id.tv_title_2_fragment_third_zhihu);
            imageView_3 = (ImageView) viewGroup.findViewById(R.id.iv_pic_3_fragment_third_zhihu);
            tvTitle_3 = (TextView) viewGroup.findViewById(R.id.tv_title_3_fragment_third_zhihu);
            imageView_4 = (ImageView) viewGroup.findViewById(R.id.iv_pic_4_fragment_third_zhihu);
            tvTitle_4 = (TextView) viewGroup.findViewById(R.id.tv_title_4_fragment_third_zhihu);
        }
    }

    //监听更多按钮点击事件
    public interface onMoreClickListener {
        void onMoreClick(Zhihu zhihu, Context context);
    }

    onMoreClickListener onMoreClickListener;

    public void setOnMoreClickListener(onMoreClickListener onMoreClickListener) {
        this.onMoreClickListener = onMoreClickListener;
    }

    //图片的点击事件
    public interface OnItemClickListener {
        void onItemClick(String id);
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}