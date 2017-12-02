package com.duokan.core.ui;

import android.content.Context;

import com.duokan.core.app.c;
import com.duokan.core.app.d;

public class f extends j implements c {
    private boolean mCancelOnBack = true;
    private boolean mCancelOnTouchOutside = true;
    private d mOnCancelListener = null;

    public f(Context context) {
        super(context);
    }

    public void setCancelOnBack(boolean z) {
        this.mCancelOnBack = z;
    }

    public void setCancelOnTouchOutside(boolean z) {
        this.mCancelOnTouchOutside = z;
    }

    public void cancel() {
        if (isShowing()) {
            onCancel();
            dismiss();
        }
    }

    public void open(d dVar) {
        this.mOnCancelListener = dVar;
        show();
    }

    protected boolean onTouchOutside() {
        if (!isShowing() || !this.mCancelOnTouchOutside) {
            return super.onTouchOutside();
        }
        cancel();
        return true;
    }

    protected boolean onBack() {
        if (!isShowing() || !this.mCancelOnBack) {
            return super.onBack();
        }
        cancel();
        return true;
    }

    protected void onDismiss() {
        super.onDismiss();
        this.mOnCancelListener = null;
    }

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
