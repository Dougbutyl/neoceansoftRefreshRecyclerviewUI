package com.neocean.app.refreshrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class LoadingMoreFooter extends RelativeLayout {


    public final static int STATE_LOADING = 0;
    public final static int STATE_COMPLETE = 1;
    public final static int STATE_NOMORE = 2;

    private String loadingHint;
    private String noMoreHint;
    private String loadingDoneHint;


    public LoadingMoreFooter(Context context) {
        super(context);
        initView();
    }

    /**
     * @param context
     * @param attrs
     */
    public LoadingMoreFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public void destroy() {


    }

    public void setLoadingHint(String hint) {
        loadingHint = hint;
    }

    public void setNoMoreHint(String hint) {
        noMoreHint = hint;
    }


    View mView;
    TextView mText;
    ProgressBar mProgressBar;

    public void initView() {
        mView = LayoutInflater.from(getContext()).inflate(R.layout.listview_footer, null);
        mText = (TextView) mView.findViewById(R.id.tv);
        mProgressBar = (ProgressBar) mView.findViewById(R.id.pb);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        mView.setLayoutParams(params);
        addView(mView);
    }


    public void setState(int state, String... noMoreDesc) {
        switch (state) {
            case STATE_LOADING:
                getLayoutParams().height = 60;
                mText.setText(getContext().getResources().getString(R.string.listview_loading));
                mProgressBar.setVisibility(View.VISIBLE);
                this.setVisibility(View.VISIBLE);
                break;
            case STATE_COMPLETE:
                getLayoutParams().height = 0;
                this.setVisibility(View.GONE);
                break;
            case STATE_NOMORE:
                getLayoutParams().height = 60;
                if (noMoreDesc != null && noMoreDesc.length > 0) {
                    mText.setText(noMoreDesc[0]);
                } else {
                    mText.setText("───── 我是有底线的───── ");
                }

                mProgressBar.setVisibility(View.GONE);
                this.setVisibility(View.VISIBLE);
                break;
        }
    }
}
