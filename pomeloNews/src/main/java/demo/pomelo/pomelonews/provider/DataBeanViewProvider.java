package demo.pomelo.pomelonews.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import demo.pomelo.pomelonews.entity.News_Toutiao;
import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.utils.PicassoTransformation;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.Transformation;
import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.Items;

/**
 * Created by UnclePomelo on 2017/1/18.
 */
public class DataBeanViewProvider
        extends ItemViewProvider<News_Toutiao.ResultBean.DataBean, DataBeanViewProvider.ViewHolder> {

    private Items items;

    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener = null;

    public DataBeanViewProvider(Items items) {
        this.items = items;
    }

    public DataBeanViewProvider() {

    }


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull final LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.fragment_first_sub_1_toutiao, parent, false);

        return new ViewHolder(root);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull News_Toutiao.ResultBean.DataBean dataBean) {

        if (items == null) {
            return;
        }

        int position = items.indexOf(dataBean);
        if (position % 3 == 0
                && dataBean.getThumbnail_pic_s() != null
                && dataBean.getThumbnail_pic_s02() != null
                && dataBean.getThumbnail_pic_s03() != null) {
            //三等分
            Transformation transformation = new PicassoTransformation(holder.itemView, 3);
            holder.relativeLayout.setVisibility(View.GONE);
            holder.linearLayout.setVisibility(View.VISIBLE);
            holder.tvTitle_1.setText(dataBean.getTitle());
            Picasso.with(holder.itemView.getContext())
                    .load(dataBean.getThumbnail_pic_s())
                    .transform(transformation)
                    .into(holder.imageView2);
            Picasso.with(holder.itemView.getContext())
                    .load(dataBean.getThumbnail_pic_s02())
                    .transform(transformation)
                    .into(holder.imageView3);
            Picasso.with(holder.itemView.getContext())
                    .load(dataBean.getThumbnail_pic_s03())
                    .transform(transformation)
                    .into(holder.imageView4);
        } else {
            holder.linearLayout.setVisibility(View.GONE);
            holder.relativeLayout.setVisibility(View.VISIBLE);
            Picasso.with(holder.imageView1.getContext()).load(dataBean.getThumbnail_pic_s())
                    .resize(160, 120).into(holder.imageView1);
        }

        holder.tvTitle.setText(dataBean.getTitle());
        holder.tvSource.setText(dataBean.getAuthor_name());
        holder.tvDate.setText(dataBean.getDate());
        //为itemView设置标签，传递url和title
        holder.itemView.setTag(R.id.tag_url, dataBean.getUrl());
        holder.itemView.setTag(R.id.tag_title, dataBean.getTitle());
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView1;
        TextView tvTitle;
        TextView tvSource;
        TextView tvDate;
        RelativeLayout relativeLayout;
        View itemView;

        TextView tvTitle_1;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativelayout_fragment_first_sub_1);
            imageView1 = (ImageView) itemView.findViewById(R.id.iv_pic_fragment_first_sub_1_toutiao);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title_fragment_first_sub_1_toutiao);
            tvSource = (TextView) itemView.findViewById(R.id.tv_source_fragment_first_sub_1_toutiao);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date_fragment_first_sub_1_toutiao);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearlayout_1_fragment_first_sub_1);
            tvTitle_1 = (TextView) itemView.findViewById(R.id.tv_title_1_fragment_sub_1_toutiao);
            imageView2 = (ImageView) itemView.findViewById(R.id.iv_pic_1_fragment_first_sub_1_toutiao);
            imageView3 = (ImageView) itemView.findViewById(R.id.iv_pic_2_fragment_first_sub_1_toutiao);
            imageView4 = (ImageView) itemView.findViewById(R.id.iv_pic_3_fragment_first_sub_1_toutiao);

            itemView.setOnClickListener(this);
        }

        //点击事件
        @Override
        public void onClick(View v) {
            if (onRecyclerViewItemClickListener != null) {
                onRecyclerViewItemClickListener.OnItemClick(v, (String) v.getTag(R.id.tag_url), (String) v.getTag(R.id.tag_title));
            }
        }
    }

    //点击事件的回调接口
    public interface OnRecyclerViewItemClickListener {
        void OnItemClick(View view, String url, String title);
    }

    //暴露给外部调用的方法
    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onRecyclerViewItemClickListener = listener;
    }

}