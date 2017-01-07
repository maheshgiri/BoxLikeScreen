package hack.android.hunger.box8homescreen;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecylerView;
    private StaggeredGridLayoutManager mainLayManager;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRecylerView = (RecyclerView)findViewById(R.id.mainRecyScroller);
        mainLayManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mainLayManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        mainRecylerView.setLayoutManager(mainLayManager);
        mainRecylerView.setHasFixedSize(true);
        mainRecylerView.setAdapter(new MainItemsManageAdaptor(this));

    }





    private class MainItemsManageAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
        Context mContext;
        int[] resorces={R.drawable.img_1,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4};

        public MainItemsManageAdaptor(MainActivity mainActivity) {
        mContext=mainActivity;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            if (viewType == 0) {
                View mainRecyView = inflater.inflate(R.layout.mainviewpager, parent, false);
                RecyclerView.ViewHolder adapter =  new MainViewPager(mainRecyView);
                return adapter;
            }else{
                View mainRecyView = inflater.inflate(R.layout.main_recyclerview_item, parent, false);
                RecyclerView.ViewHolder adapter = new MainAdaptor(mainRecyView);

                return adapter;
            }
        }

        @Override
        public int getItemViewType(int position) {

            if (position == 0 && position<1){
                return 0;
            }else if (position%8 == 1 && position >0){
                return 1;
            }else if (position%8 == 2 && position >0){
                return 2;
            }else if (position%8 == 3 && position >0){
                return 3;
            }else if (position%8 == 4 && position >0){
                return 4;
            }else if (position%8 == 5 && position >0){
                return 5;
            }else if (position%8 == 6 && position >0){
                return 6;
            }else if (position%8 == 7 && position >0){
                return 7;
            }else if (position%8 == 0 && position >0){
                return 8;
            }else {
                return 9;
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            float width=size.x/4;
            float widthSmall=size.x/6;
            if (holder.getItemViewType() == 0) {
                MainViewPager mainViewPageAdaptor=(MainViewPager) holder;
                StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                layoutParams.setFullSpan(true);
                mainViewPageAdaptor.mainScrollImageView.setAdapter(new MainViewPageAdaptor(getApplicationContext()));

            } else if (holder.getItemViewType() ==1 && position%8 == 1){
                MainAdaptor holderMain= (MainAdaptor) holder;
                    ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                    layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 825 , mContext.getResources().getDisplayMetrics());
                    layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 990, mContext.getResources().getDisplayMetrics());
                    holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                    StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                    layoutParams1.setFullSpan(false);
                    holderMain.mainCategoryImageView.setImageResource(resorces[position]);
                }else if (holder.getItemViewType()==2 && position%8 == 2){
                MainAdaptor holderMain= (MainAdaptor) holder;
                ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 660, mContext.getResources().getDisplayMetrics());
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 750, mContext.getResources().getDisplayMetrics());
                holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                layoutParams1.setFullSpan(false);
                holderMain.mainCategoryImageView.setImageResource(resorces[position]);
            }else if (holder.getItemViewType() ==3 && position%8 == 3){

                MainAdaptor holderMain= (MainAdaptor) holder;
                ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 660, mContext.getResources().getDisplayMetrics());
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 750, mContext.getResources().getDisplayMetrics());
                holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                layoutParams1.setFullSpan(false);
                holderMain.mainCategoryImageView.setImageResource(resorces[position]);
            }else if (holder.getItemViewType() ==4 && position%8 == 4){

                MainAdaptor holderMain= (MainAdaptor) holder;
                ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 825, mContext.getResources().getDisplayMetrics());
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 510, mContext.getResources().getDisplayMetrics());
                holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                layoutParams1.setFullSpan(false);
                holderMain.mainCategoryImageView.setImageResource(resorces[position]);

            }else if (holder.getItemViewType() ==5 && position%8 == 5){

                MainAdaptor holderMain= (MainAdaptor) holder;
                ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 660, mContext.getResources().getDisplayMetrics());
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 750, mContext.getResources().getDisplayMetrics());
                holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                layoutParams1.setFullSpan(false);
                holderMain.mainCategoryImageView.setImageResource(resorces[position]);


            }else if (holder.getItemViewType() ==6 && position%8 == 6){
                MainAdaptor holderMain= (MainAdaptor) holder;
                ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 825, mContext.getResources().getDisplayMetrics());
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 510, mContext.getResources().getDisplayMetrics());
                holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                layoutParams1.setFullSpan(false);
                holderMain.mainCategoryImageView.setImageResource(resorces[position]);

            }else if (holder.getItemViewType() ==7 && position%8 == 7){

                MainAdaptor holderMain= (MainAdaptor) holder;
                ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 825 , mContext.getResources().getDisplayMetrics());
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 990, mContext.getResources().getDisplayMetrics());
                holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                layoutParams1.setFullSpan(false);
                holderMain.mainCategoryImageView.setImageResource(resorces[position]);

            }else if (holder.getItemViewType() ==8 && position%8 == 0){
                MainAdaptor holderMain= (MainAdaptor) holder;
                ViewGroup.LayoutParams layoutParams = holderMain.mainCategoryImageView.getLayoutParams();
                layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 660, mContext.getResources().getDisplayMetrics());
                layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 750, mContext.getResources().getDisplayMetrics());
                holderMain.mainCategoryImageView.setLayoutParams(layoutParams);

                StaggeredGridLayoutManager.LayoutParams layoutParams1 = ((StaggeredGridLayoutManager.LayoutParams) holderMain.itemView.getLayoutParams());
                layoutParams1.setFullSpan(false);
                holderMain.mainCategoryImageView.setImageResource(resorces[position]);
            }
            }


        @Override
        public int getItemCount() {
            return resorces.length;
        }

        public class MainAdaptor extends RecyclerView.ViewHolder {
         private ImageView mainCategoryImageView;
            public MainAdaptor(View itemView) {
                super(itemView);
                mainCategoryImageView=(ImageView) itemView.findViewById(R.id.categoryImagesView);
            }
        }
    }
}
