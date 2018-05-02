package com.duokan.core.ui;

import android.content.Context;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

/* renamed from: com.duokan.core.ui.f */
public class C0343f extends C0342j implements C0301c {
    private boolean mCancelOnBack = true;
    private boolean mCancelOnTouchOutside = true;
    private OnCancelListener mOnCancelListener = null;

    public C0343f(Context context) {
        super(context);
    }

    public void setCancelOnBack(boolean mCancelOnBack) {
        this.mCancelOnBack = mCancelOnBack;
    }

    public void setCancelOnTouchOutside(boolean mCancelOnTouchOutside) {
        this.mCancelOnTouchOutside = mCancelOnTouchOutside;
    }

    public void cancel() {
        if (isShowing()) {
            onCancel();
            dismiss();
        }
    }

    public void open(OnCancelListener onCancelListener) {
        this.mOnCancelListener = onCancelListener;
        show();
    }

    @Override
    protected boolean onTouchOutside() {
        if (!isShowing() || !this.mCancelOnTouchOutside) {
            return super.onTouchOutside();
        }
        cancel();
        return true;
    }

    @Override
    protected boolean onBack() {
        if (!isShowing() || !this.mCancelOnBack) {
            return super.onBack();
        }
        cancel();
        return true;
    }

    @Override
    protected void onDismiss() {
        super.onDismiss();
        this.mOnCancelListener = null;
    }

    @Override
    protected void onCancel() {
        notifyCancel();
        super.onCancel();
    }

    private void notifyCancel() {
        if (this.mOnCancelListener != null) {
            this.mOnCancelListener.onCancel(this);
        }
    }
}
