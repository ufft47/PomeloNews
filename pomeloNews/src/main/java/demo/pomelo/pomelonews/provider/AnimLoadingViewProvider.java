package demo.pomelo.pomelonews.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import demo.pomelo.pomelonews.R;
import demo.pomelo.pomelonews.entity.AnimLoading;
import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by UnclePomelo on 2017/2/14.
 */
public class AnimLoadingViewProvider
        extends ItemViewProvider<AnimLoading, AnimLoadingViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(
            @NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_third_loading, parent, false);
        return new ViewHolder(viewGroup);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull AnimLoading animLoading) {
        holder.lottieAnimationView.setAnimation("anim_loading.json");
        holder.lottieAnimationView.loop(true);
        holder.lottieAnimationView.playAnimation();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LottieAnimationView lottieAnimationView;
        ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            lottieAnimationView = (LottieAnimationView) viewGroup.findViewById(R.id.lottie_fragment_third_loading);
        }
    }
}