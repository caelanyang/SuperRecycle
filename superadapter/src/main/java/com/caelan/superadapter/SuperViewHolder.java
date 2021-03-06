package com.caelan.superadapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by yangjiacheng on 2018/4/11.
 * ...
 */
@SuppressWarnings("WeakerAccess")
public class SuperViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> viewHolder = new SparseArray<>();

    public SuperViewHolder(View itemView) {
        this(itemView, new int[0]);
    }

    public SuperViewHolder(View itemView, @IdRes int... ids) {
        super(itemView);
        holderChildViewByIds(ids);
    }

    public void holderChildViewByIds(@IdRes int... ids) {
        for (int id : ids) {
            viewHolder.put(id, itemView.findViewById(id));
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T get(@IdRes int id) {
        View view = viewHolder.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            viewHolder.put(id, view);
        }
        return (T) view;
    }
}
