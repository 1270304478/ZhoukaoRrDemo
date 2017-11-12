package login.bwie.com.zhoukaorrdemo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import login.bwie.com.zhoukaorrdemo.R;
import login.bwie.com.zhoukaorrdemo.bean.JsonBean;
import login.bwie.com.zhoukaorrdemo.utils.ImageLoaderUtil;


/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/9/15 8:58
 */
public class MyBaseAdapter extends BaseAdapter {
    Context context;
    List<JsonBean.NewslistBean> list;

    public MyBaseAdapter(Context context, List<JsonBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Viewhodler hodler;
        if (view == null) {
            view = View.inflate(context, R.layout.item_lista, null);
            hodler = new Viewhodler();
            hodler.image_view = view.findViewById(R.id.image_view);
            hodler.text_view = view.findViewById(R.id.text_view);
            view.setTag(hodler);

        } else {
            hodler = (Viewhodler) view.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(i).getPicUrl(), hodler.image_view, ImageLoaderUtil.getOption());
       hodler.text_view.setText(list.get(i).getTitle());
        return view;
    }

    class Viewhodler{
        ImageView image_view;
        TextView text_view;
    }

}
