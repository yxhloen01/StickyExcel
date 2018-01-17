package com.example.kenny.stickyexcel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mHeaderView;
    private RecyclerView mListView;

    private RelativeLayout rlTopLeft;
    private TextView textView1;
    private LinearLayout mTopTitlePriceLay, mTopTitleChgLay, mTopTitleVolumeLay, mTopTitleUpdateLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeaderView = findViewById(R.id.mHeaderView);
        rlTopLeft = findViewById(R.id.rlTopLeft);
        mTopTitlePriceLay = findViewById(R.id.mTopTitlePriceLay);
        mTopTitleChgLay = findViewById(R.id.mTopTitleChgLay);
        mTopTitleVolumeLay = findViewById(R.id.mTopTitleVolumeLay);
        mTopTitleUpdateLay = findViewById(R.id.mTopTitleUpdateLay);
        rlTopLeft.getLayoutParams().width = Utils.getDisplay(this)[0] / 3;
        mTopTitlePriceLay.getLayoutParams().width = Utils.getDisplay(this)[0] / 3;
        mTopTitleChgLay.getLayoutParams().width = Utils.getDisplay(this)[0] / 3;
        mTopTitleVolumeLay.getLayoutParams().width = Utils.getDisplay(this)[0] / 3;
        mTopTitleUpdateLay.getLayoutParams().width = Utils.getDisplay(this)[0] / 3;

        mListView = findViewById(R.id.mListView);
        mHeaderView.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());
        mListView.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());

        final List<String> testList = new ArrayList<>();
        testList.add("BTC");
        testList.add("BTC");
        testList.add("BTC");
        testList.add("BCH");
        testList.add("BCH");
        testList.add("XRP");
        testList.add("ETH");
        testList.add("ETH");
        testList.add("ETH");
        testList.add("ETH");
        testList.add("LTC");
        testList.add("LTC");
        testList.add("LTC");
        testList.add("LTC");
        testList.add("DASH");
        testList.add("DASH");
        testList.add("DASH");
        testList.add("DASH");
        testList.add("EOS");
        testList.add("EOS");
        testList.add("EOS");
        testList.add("EOS");
        testList.add("EOS");
        testList.add("OMG");
        testList.add("OMG");
        testList.add("OMG");
        testList.add("OMG");
        testList.add("OMG");
        testList.add("ZEC");
        testList.add("ZEC");
        testList.add("ZEC");

        final NormalDecoration decoration = new NormalDecoration(Utils.getDisplay(this)[0]) {
            @Override
            public String getHeaderName(int pos) {
                return testList.get(pos);
            }
        };

        decoration.setOnHeaderClickListener(new NormalDecoration.OnHeaderClickListener() {
            @Override
            public void headerClick(int pos) {
                Toast.makeText(MainActivity.this, "点击到头部" + testList.get(pos), Toast.LENGTH_SHORT).show();
            }
        });

        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(final int pos) {
                final View headView = LayoutInflater.from(MainActivity.this).inflate(R.layout.header_stick, null);
                ((TextView) headView.findViewById(R.id.tvStick)).setText(testList.get(pos));
                headView.findViewById(R.id.llStick).getLayoutParams().width = Utils.getDisplay(MainActivity.this)[0];
                return headView;
            }
        });

        ExcelAdapter adapter = new ExcelAdapter(this, mHeaderView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mListView.addItemDecoration(decoration);
        mListView.setLayoutManager(manager);
        mListView.setAdapter(adapter);
    }

    class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            HorizontalScrollView headSrcrollView = mHeaderView
                    .findViewById(R.id.horizontalScrollView1);
            headSrcrollView.onTouchEvent(arg1);
            return false;
        }
    }
}
