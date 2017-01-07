package hack.android.hunger.box8homescreen;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by hunger on 12/20/2016.
 */

public class MainViewPageAdaptor extends PagerAdapter {
private int[] listImages = {R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4};
private Context mContext;
    MainViewPageAdaptor(Context context){
       mContext=context;
    }

    @Override
    public int getCount() {
        return listImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {


        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.viewpager_main_view, container, false);

        ImageView mainContentImage = (ImageView) itemView.findViewById(R.id.main_viewPagerImage);
        mainContentImage.setImageResource(listImages[position]);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }


}
