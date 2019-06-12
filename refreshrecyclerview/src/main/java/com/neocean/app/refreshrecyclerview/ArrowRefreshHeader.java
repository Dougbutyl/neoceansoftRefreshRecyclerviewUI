package com.neocean.app.refreshrecyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Date;


public class ArrowRefreshHeader extends LinearLayout implements BaseRefreshHeader {

    private static final String XR_REFRESH_KEY = "XR_REFRESH_KEY";
    private static final String XR_REFRESH_TIME_KEY = "XR_REFRESH_TIME_KEY";
    private RelativeLayout mContainer;
    //    private ImageView mArrowImageView;
    ImageView imgLoading;
//    private SimpleViewSwitcher mProgressBar;
    private TextView mStatusTextView;
    private int mState = STATE_NORMAL;

    private TextView mHeaderTimeView;
    private LinearLayout mHeaderRefreshTimeContainer;

    private Animation mRotateUpAnim;
    private Animation mRotateDownAnim;

    private static final int ROTATE_ANIM_DURATION = 180;

    public int mMeasuredHeight;


    public void destroy() {
        if (mRotateUpAnim != null) {
            mRotateUpAnim.cancel();
            mRotateUpAnim = null;
        }
        if (mRotateDownAnim != null) {
            mRotateDownAnim.cancel();
            mRotateDownAnim = null;
        }
    }

    public ArrowRefreshHeader(Context context) {
        super(context);
        initView();
    }

    /**
     * @param context
     * @param attrs
     */
    public ArrowRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public void setRefreshTimeVisible(boolean show) {
        if (mHeaderRefreshTimeContainer != null)
            mHeaderRefreshTimeContainer.setVisibility(show ? VISIBLE : GONE);
    }

    RelativeLayout rl;
    TextView tv_refreshcount;//刷新数量提示
    //    ImageView mImageView;
    Animation imgLoadingAnim;//刷新动画

    private void initView() {
        // 初始情况，设置下拉刷新view高度为0
        mContainer = (RelativeLayout) LayoutInflater.from(getContext()).inflate(
                R.layout.listview_header, null);

        rl = (RelativeLayout) mContainer.findViewById(R.id.rl);
        mHeaderRefreshTimeContainer
                = (LinearLayout) mContainer.findViewById(R.id.header_refresh_time_container);
//        mImageView=(ImageView)mContainer.findViewById(R.id.img_refresh);
//        Animation rotateAn=AnimationUtils.loadAnimation(getContext(),R.anim.anim_rotate_refresh);
//        rotateAn.setInterpolator(new AccelerateDecelerateInterpolator());
//        mImageView.startAnimation(rotateAn);
        tv_refreshcount = (TextView) mContainer.findViewById(R.id.tv_refreshcount);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, 0);
        this.setLayoutParams(lp);
        this.setPadding(0, 0, 0, 0);

        addView(mContainer, new LayoutParams(LayoutParams.MATCH_PARENT, 0));

        //TODO
//        mArrowImageView = (ImageView) findViewById(R.id.listview_header_arrow);
        imgLoading = (ImageView) findViewById(R.id.img_loading);
        imgLoadingAnim = AnimationUtils.loadAnimation(getContext(), R.anim.anim_rotate_refresh);
        imgLoadingAnim.setInterpolator(new LinearInterpolator());
        mStatusTextView = (TextView) findViewById(R.id.refresh_status_textview);

        //init the progress view


        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);
        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);

        mHeaderTimeView = (TextView) findViewById(R.id.last_refresh_time);
        measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mMeasuredHeight = getMeasuredHeight();
    }


    /**
     * 设置刷新提示颜色
     * @param color
     */
    public void setRefreshTextColor(int color){
        if(tv_refreshcount!=null){
            tv_refreshcount.setTextColor(getContext().getResources().getColor(color));
        }
    }


    //TODO
//    public void setArrowImageView(int resid) {
//        mArrowImageView.setImageResource(resid);
//    }

    public void setState(int state) {
        if (state == mState) return;

        if (state == STATE_REFRESHING) {    // 显示进度
            //TODO
            imgLoading.startAnimation(imgLoadingAnim);
            imgLoading.setVisibility(View.VISIBLE);
//            mArrowImageView.clearAnimation();
//            mArrowImageView.setVisibility(View.INVISIBLE);

            smoothScrollTo(mMeasuredHeight);
        } else if (state == STATE_DONE) {
            //TODO
            imgLoading.clearAnimation();
            imgLoading.setVisibility(View.INVISIBLE);
//            mArrowImageView.setVisibility(View.INVISIBLE);

        } else {    // 显示箭头图片
            //TODO
//            mArrowImageView.setVisibility(View.VISIBLE);
        }
        mHeaderTimeView.setText(friendlyTime(getLastRefreshTime()));
        switch (state) {
            case STATE_NORMAL:
                if (mState == STATE_RELEASE_TO_REFRESH) {
                    //TODO

//                    mArrowImageView.startAnimation(mRotateDownAnim);
                }
                if (mState == STATE_REFRESHING) {
                    //TODO
//                    mArrowImageView.clearAnimation();
                }
                mStatusTextView.setText(R.string.listview_header_hint_normal);
                break;
            case STATE_RELEASE_TO_REFRESH:
                if (mState != STATE_RELEASE_TO_REFRESH) {
                    //TODO
//                    mArrowImageView.clearAnimation();
//                    mArrowImageView.startAnimation(mRotateUpAnim);
                    mStatusTextView.setText(R.string.listview_header_hint_release);
                }
                break;
            case STATE_REFRESHING:
                mStatusTextView.setText(R.string.refreshing);
                break;
            case STATE_DONE:
                mStatusTextView.setText(R.string.refresh_done);
                break;
            default:
        }

        mState = state;
    }

    public int getState() {
        return mState;
    }

    private long getLastRefreshTime() {
        SharedPreferences s =
                getContext()
                        .getSharedPreferences(XR_REFRESH_KEY, Context.MODE_APPEND);
        return s.getLong(XR_REFRESH_TIME_KEY, new Date().getTime());
    }

    private void saveLastRefreshTime(long refreshTime) {
        SharedPreferences s =
                getContext()
                        .getSharedPreferences(XR_REFRESH_KEY, Context.MODE_APPEND);
        s.edit().putLong(XR_REFRESH_TIME_KEY, refreshTime).commit();
    }

    @Override
    public void refreshComplete() {
        mHeaderTimeView.setText(friendlyTime(getLastRefreshTime()));
        saveLastRefreshTime(System.currentTimeMillis());
        setState(STATE_DONE);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                reset();
            }
        }, 200);
    }

    @Override
    public void refreshComplete(final String refreshDataStr) {
        if (TextUtils.isEmpty(refreshDataStr)) {
            refreshComplete();
            return;
        }
        mHeaderTimeView.setText(friendlyTime(getLastRefreshTime()));
        saveLastRefreshTime(System.currentTimeMillis());
        setState(STATE_DONE);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                reset(refreshDataStr);
            }
        }, 200);

    }


    public void setVisibleHeight(int height) {
        if (height < 0) height = 0;
        LayoutParams lp = (LayoutParams) mContainer.getLayoutParams();
        lp.height = height;
        mContainer.setLayoutParams(lp);
    }

    public int getVisibleHeight() {
        LayoutParams lp = (LayoutParams) mContainer.getLayoutParams();
        return lp.height;
    }

    @Override
    public void onMove(float delta) {
        if (getVisibleHeight() > 0 || delta > 0) {
            setVisibleHeight((int) delta + getVisibleHeight());
            if (mState <= STATE_RELEASE_TO_REFRESH) { // 未处于刷新状态，更新箭头
                if (getVisibleHeight() > mMeasuredHeight) {
                    setState(STATE_RELEASE_TO_REFRESH);
                } else {
                    setState(STATE_NORMAL);
                }
            }
        }
    }

    @Override
    public boolean releaseAction() {
        boolean isOnRefresh = false;
        int height = getVisibleHeight();
        if (height == 0) // not visible.
            isOnRefresh = false;

        if (getVisibleHeight() > mMeasuredHeight && mState < STATE_REFRESHING) {
            setState(STATE_REFRESHING);
            isOnRefresh = true;
        }
        // refreshing and header isn't shown fully. do nothing.
        if (mState == STATE_REFRESHING && height <= mMeasuredHeight) {
            //return;
        }
        if (mState != STATE_REFRESHING) {
            smoothScrollTo(0);
        }

        if (mState == STATE_REFRESHING) {
            int destHeight = mMeasuredHeight;
            smoothScrollTo(destHeight);
        }

        return isOnRefresh;
    }

    public void reset() {
        smoothScrollTo(0);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                setState(STATE_NORMAL);
            }
        }, 500);
    }

    public void reset(final String refreshDataStr) {
        smoothScrollTo(0);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                setState(STATE_NORMAL);
                tv_refreshcount.setVisibility(View.VISIBLE);
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_text);
                tv_refreshcount.startAnimation(animation);
                tv_refreshcount.setText(refreshDataStr);
                rl.setVisibility(View.GONE);
                mContainer.getLayoutParams().height = 50;
                smoothScrollTo(50);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        smoothScrollTo(0);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tv_refreshcount.setVisibility(View.INVISIBLE);
                                rl.setVisibility(View.VISIBLE);
                            }
                        }, 200);
                    }
                }, 1500);
            }
        }, 200);
    }

    private void smoothScrollTo(int destHeight) {
        ValueAnimator animator = ValueAnimator.ofInt(getVisibleHeight(), destHeight);
        animator.setDuration(300).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                setVisibleHeight((int) animation.getAnimatedValue());
            }
        });
        animator.start();
    }


    public static String friendlyTime(Date time) {
        return friendlyTime(time.getTime());
    }

    public static String friendlyTime(long time) {
        //获取time距离当前的秒数
        int ct = (int) ((System.currentTimeMillis() - time) / 1000);

        if (ct == 0) {
            return "刚刚";
        }

        if (ct > 0 && ct < 60) {
            return ct + "秒前";
        }

        if (ct >= 60 && ct < 3600) {
            return Math.max(ct / 60, 1) + "分钟前";
        }
        if (ct >= 3600 && ct < 86400)
            return ct / 3600 + "小时前";
        if (ct >= 86400 && ct < 2592000) { //86400 * 30
            int day = ct / 86400;
            return day + "天前";
        }
        if (ct >= 2592000 && ct < 31104000) { //86400 * 30
            return ct / 2592000 + "月前";
        }
        return ct / 31104000 + "年前";
    }

}