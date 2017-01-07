package hack.android.hunger.box8homescreen;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hunger on 12/30/2016.
 */

public class MainViewPager extends RecyclerView.ViewHolder  implements ViewPager.OnPageChangeListener,View.OnClickListener {
  ViewPager mainScrollImageView;
  ImageView backBtn,forwardBtn;
  int position = 0;

    public MainViewPager(View itemView) {
        super(itemView);
        mainScrollImageView=(ViewPager) itemView.findViewById(R.id.mainViewPager);
        backBtn=(ImageView) itemView.findViewById(R.id.backBtn);
        forwardBtn=(ImageView) itemView.findViewById(R.id.forwardBtn);
        backBtn.setOnClickListener(this);
        forwardBtn.setOnClickListener(this);
        mainScrollImageView.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("MainViewPager","Position"+position);
    }

    @Override
    public void onPageSelected(int position) {
        this.position=position;
        Log.e("MainViewPager","Selected Position"+position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
     if (view.getId() == backBtn.getId()){
      if (position <= 0){
          return;
      }else {
          mainScrollImageView.setCurrentItem(position-1);
      }

     }
    if (view.getId()==forwardBtn.getId()){
        if (position < 0){
            return;
        }else {
            mainScrollImageView.setCurrentItem(position+1);
        }
    }
    }
}
