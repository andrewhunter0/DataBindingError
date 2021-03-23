package com.andrew.architecture.core.bindings;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.andrew.architecture.core.base.BaseAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Java类在使用BaseAdapter和List接口的时候，可以不传入泛型，且可以正常运行，
 * 但一但用了接口或者基类的泛型限制，也编译过不了了，所以目前看来，还是用Java的注解，且不加泛型限制扩展性强
 * 如果kotlin，必须传泛型，不传直接报错，传了吧，必须得是一样的实现类才行，否则编译不过
 *
 * 使用Java作为@BindingAdapter还有一个强大之处，在xml里传入的List对象可以使用MutableLiveData<ArrayList<MainListItem>>
 * 这里看到传入的MutableLiveData<ArrayList<MainListItem>>，直接变成了java.util.ArrayList类型，但kotlin直接报错
 */
public class RecyclerViewBindings {
    // Application namespace for attribute app:mainListAdapter will be ignored
    @BindingAdapter(value = {"mainListAdapter", "dataList"}, requireAll = false)
    public static void bindAdapterAndList(RecyclerView recyclerview, BaseAdapter adapter, List list) {
        if (recyclerview == null || adapter == null || list == null ||  list.isEmpty())
            return;

        // If not set,just set the new adapter
        if (recyclerview.getAdapter() == null) {
            recyclerview.setAdapter(adapter);
        }

        // 布局
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

//        System.out.println("test---class name:" + list.getClass() + " size:" + list.size());
        // Set data list for adapter
        adapter.updateListData(list);
        adapter.notifyDataSetChanged();
    }

    @BindingAdapter(value = {"imgUrl", "cardBackgroundByImageView"})
    public static void loadImageVIew(ImageView imageView, String url, @Nullable final Drawable drawable) {
        if (imageView == null || TextUtils.isEmpty(url))
            return;

        Glide.with(imageView).load(url).into(imageView);

        System.out.println("test--- loadImageView drawable:" + drawable);
    }
}
