package com.duokan.core.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class j {
    private OnDismissListener mOnDismissListener = null;
    private OnShowListener mOnShowListener = null;
    private final cv mWindow;

    public j(Context context) {
        this.mWindow = new k(this, context);
        this.mWindow.setDimAmount(0.6f);
        this.mWindow.setConsumeTouchEvents(true);
    }

    public Context getContext() {
        return this.mWindow.getContext();
    }

    public Activity getActivity() {
        return this.mWindow.getActivity();
    }

    public View getDecorView() {
        return this.mWindow.getDecorView();
    }

    public View getContentView() {
        return this.mWindow.getContentView();
    }

    public void setContentView(int i) {
        this.mWindow.setContentView(i);
    }

    public void setContentView(View view) {
        this.mWindow.setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new LayoutParams(-1, -2));
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        this.mWindow.setContentView(view, layoutParams);
    }

    public void setConsumeTouchEvents(boolean z) {
        this.mWindow.setConsumeTouchEvents(z);
    }

    public boolean isFocusable() {
        return this.mWindow.isFocusable();
    }

    public void setFocusable(boolean z) {
        this.mWindow.setFocusable(z);
    }

    public boolean getResizeForSoftInput() {
        return this.mWindow.getResizeForSoftInput();
    }

    public void setResizeForSoftInput(boolean z) {
        this.mWindow.setResizeForSoftInput(z);
    }

    public int getGravity() {
        return this.mWindow.getGravity();
    }

    public void setGravity(int i) {
        this.mWindow.setGravity(i);
    }

    public float getDimAmount() {
        return this.mWindow.getDimAmount();
    }

    public void setDimAmount(float f) {
        this.mWindow.setDimAmount(f);
    }

    public void setEnterAnimation(int i) {
        this.mWindow.setEnterAnimation(i);
    }

    public void setExitAnimation(int i) {
        this.mWindow.setExitAnimation(i);
    }

    public void setOnShowListener(OnShowListener mVar) {
        this.mOnShowListener = mVar;
    }

    public void setOnDismissListener(OnDismissListener lVar) {
        this.mOnDismissListener = lVar;
    }

    public int getBalloonCount() {
        return this.mWindow.getBalloonCount();
    }

    public void showBalloon(a aVar, View view) {
        this.mWindow.showBalloon(aVar, view);
    }

    public void showBalloon(a aVar, View view, LayoutParams layoutParams) {
        this.mWindow.showBalloon(aVar, view, layoutParams);
    }

    public void showBalloon(a aVar, Rect rect) {
        this.mWindow.showBalloon(aVar, rect);
    }

    public void showBalloon(a aVar, Rect rect, LayoutParams layoutParams) {
        this.mWindow.showBalloon(aVar, rect, layoutParams);
    }

    public a getBalloon(int i) {
        return this.mWindow.getBalloon(i);
    }

    public void removeBalloon(a aVar) {
        this.mWindow.removeBalloon(aVar);
    }

    public void setBalloonPadding(int i, int i2, int i3, int i4) {
        this.mWindow.setBalloonPadding(i, i2, i3, i4);
    }

    public static void updateLayout() {
        cv.updateLayout();
    }

    public boolean isShowing() {
        return this.mWindow.isShowing();
    }

    public void show() {
        this.mWindow.show();
    }

    public void dismiss() {
        this.mWindow.dismiss();
    }

    public View findViewById(int i) {
        return this.mWindow.findViewById(i);
    }

    public boolean isOpened() {
        return isShowing();
    }

    public void close() {
        dismiss();
    }

    private final void notifyShow() {
        if (this.mOnShowListener != null) {
            this.mOnShowListener.a(this);
        }
    }

    private final void notifyDismiss() {
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss(this);
        }
    }

    protected void onShow() {
    }

    protected void onDismiss() {
    }

    protected void onCancel() {
    }

    protected boolean onTouchOutside() {
        return false;
    }

    protected boolean onBack() {
        return false;
    }
}
