package com.example.kenny.stickyexcel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.example.kenny.stickyexcel.customView.MyHScrollView;

/**
 * Created by Kenny on 2018/1/16.
 */

public class ExcelAdapter extends RecyclerView.Adapter<ExcelAdapter.Holder> {

    private Context mContext;
    private View mHeaderView;

    public ExcelAdapter(Context c, View headerView) {
        mContext = c;
        mHeaderView = headerView;
    }

    public void addDatas() {
        notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_coin_detail_list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return 31;
    }

    class Holder extends RecyclerView.ViewHolder {
        View mItemTitle;
        TextView mItemPosition;
        TextView mItemName;
        TextView mItemContent;
        TextView mItemPrice;
        TextView mItemChgTv;
        TextView mItemVolum;
        TextView mItemTime;
        HorizontalScrollView scrollView;

        Holder(View itemView) {
            super(itemView);
            MyHScrollView scrollView1 = itemView
                    .findViewById(R.id.horizontalScrollView1);

            scrollView = scrollView1;
            mItemTitle = itemView.findViewById(R.id.mItemTitle);
            mItemPosition = itemView
                    .findViewById(R.id.mItemPosition);
            mItemName = itemView
                    .findViewById(R.id.mItemName);
            mItemContent = itemView
                    .findViewById(R.id.mItemContent);
            mItemPrice = itemView
                    .findViewById(R.id.mItemPrice);
            mItemChgTv = itemView
                    .findViewById(R.id.mItemChgTv);
            mItemVolum = itemView
                    .findViewById(R.id.mItemVolum);
            mItemTime = itemView
                    .findViewById(R.id.mItemTime);

            mItemTitle.getLayoutParams().width = Utils.getDisplay(mContext)[0] / 3;
            mItemPrice.getLayoutParams().width = Utils.getDisplay(mContext)[0] / 3;
            mItemChgTv.getLayoutParams().width = Utils.getDisplay(mContext)[0] / 3;
            mItemVolum.getLayoutParams().width = Utils.getDisplay(mContext)[0] / 3;
            mItemTime.getLayoutParams().width = Utils.getDisplay(mContext)[0] / 3;

            MyHScrollView headSrcrollView = mHeaderView
                    .findViewById(R.id.horizontalScrollView1);
            headSrcrollView
                    .AddOnScrollChangedListener(new OnScrollChangedListenerImp(
                            scrollView1));
        }
    }

    class OnScrollChangedListenerImp implements MyHScrollView.OnScrollChangedListener {
        MyHScrollView mScrollViewArg;

        OnScrollChangedListenerImp(MyHScrollView scrollViewar) {
            mScrollViewArg = scrollViewar;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollViewArg.smoothScrollTo(l, t);
        }
    }
}

