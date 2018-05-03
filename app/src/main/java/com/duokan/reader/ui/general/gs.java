package com.duokan.reader.ui.general;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.duokan.core.app.ISubControllerParent;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.C0374a;
import com.duokan.core.ui.cv;
import com.duokan.core.ui.AnimUtils;

public class gs extends ActivatedController {
    static final /* synthetic */ boolean $assertionsDisabled = (!gs.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final int FLAG_CONSUME_TOUCH_EVENTS = 2;
    public static final int FLAG_DEFAULT_POPUP = 2;
    public static final int FLAG_DISMISS_ON_TOUCH_OUTSIDE = 1;
    public static final int FLAG_NONE = 0;
    private ViewGroup mPopupRootView = null;
    private cv mPopupWindow = null;
    protected ActivatedController mShareController = null;

    public gs(IFeature mFeature) {
        super(mFeature);
    }

    public gs(IFeature mFeature, int i) {
        super(mFeature, i);
    }

    public final cv getPopupWindow() {
        if ($assertionsDisabled || isActive()) {
            if (this.mPopupWindow == null) {
                if ($assertionsDisabled || this.mPopupRootView == null) {
                    this.mPopupWindow = new gt(this, getContext(), $assertionsDisabled);
                    this.mPopupRootView = new FrameLayout(getContext());
                    this.mPopupWindow.setContentView(this.mPopupRootView, new LayoutParams(-1, -1));
                    int b = AnimUtils.m1932b(getContext(), 5.0f);
                    this.mPopupWindow.setBalloonPadding(b, b, b, b);
                } else {
                    throw new AssertionError();
                }
            }
            return this.mPopupWindow;
        }
        throw new AssertionError();
    }

    public boolean showPopupSmoothly(ActivatedController c0303e, Runnable runnable) {
        if (!showPopup(c0303e)) {
            return $assertionsDisabled;
        }
        UThread.post(runnable);
        return true;
    }

    @TargetApi(19)
    public boolean showPopup(ActivatedController c0303e) {
        return showPopup(c0303e, $assertionsDisabled);
    }

    public boolean showPopup(ActivatedController c0303e, boolean z) {
        return showPopup(c0303e, 119, (z ? 1 : 0) | 2);
    }

    @TargetApi(19)
    public boolean showPopup(ActivatedController c0303e, int i, int i2) {
        if (!$assertionsDisabled && !isActive()) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && c0303e == null) {
            throw new AssertionError();
        } else if (!isActive()) {
            return $assertionsDisabled;
        } else {
            ActivatedController gvVar = new gv(this, getContext(), c0303e, i, i2);
            addSubController(gvVar);
            getPopupWindow();
            if (!$assertionsDisabled && this.mPopupWindow == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.mPopupRootView != null) {
                this.mPopupRootView.addView(gvVar.getContentView(), new FrameLayout.LayoutParams(-1, -1));
                if (!this.mPopupWindow.isShowing()) {
                    this.mPopupWindow.show();
                }
                activate(gvVar);
                return true;
            } else {
                throw new AssertionError();
            }
        }
    }

    public void showBalloonPopup(ActivatedController c0303e, View view, int i) {
        showBalloonPopup(c0303e, view, i, 0);
    }

    public void showBalloonPopup(ActivatedController c0303e, View view, int i, int i2) {
        if (!$assertionsDisabled && !isActive()) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && c0303e == null) {
            throw new AssertionError();
        } else if (isActive()) {
            ActivatedController guVar = new gu(this, getContext(), c0303e, i, i2);
            addSubController(guVar);
            getPopupWindow();
            if ($assertionsDisabled || this.mPopupWindow != null) {
                this.mPopupWindow.showBalloon((C0374a) guVar.getContentView(), view);
                activate(guVar);
                if (!this.mPopupWindow.isShowing()) {
                    this.mPopupWindow.show();
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
    }

    public final void dismissAllPopups() {
        while (getPopupCount() > 0) {
            dismissTopPopup();
        }
    }

    public boolean dismissTopPopup() {
        ActivatedController topPopup = getTopPopup();
        if (topPopup == null) {
            return $assertionsDisabled;
        }
        return dismissPopup(topPopup);
    }

    public final boolean dismissPopup(ActivatedController c0303e) {
        ActivatedController popupHolder = getPopupHolder(c0303e);
        if (popupHolder == null) {
            return $assertionsDisabled;
        }
        deactivate(popupHolder);
        if (popupHolder instanceof gu) {
            if ($assertionsDisabled || this.mPopupWindow != null) {
                this.mPopupWindow.removeBalloon((C0374a) popupHolder.getContentView());
            } else {
                throw new AssertionError();
            }
        } else if (popupHolder instanceof gv) {
            this.mPopupRootView.removeView(popupHolder.getContentView());
        }
        removeSubController(popupHolder);
        if (this.mPopupWindow.isShowing() && getPopupCount() < 1) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
            this.mPopupRootView = null;
        }
        return true;
    }

    public final int getPopupCount() {
        if (this.mPopupWindow == null) {
            return 0;
        }
        if (this.mPopupRootView == null) {
            return this.mPopupWindow.getBalloonCount();
        }
        return this.mPopupWindow.getBalloonCount() + this.mPopupRootView.getChildCount();
    }

    public final ActivatedController getTopPopup() {
        if (this.mPopupWindow == null) {
            return null;
        }
        for (int subControllerCount = getSubControllerCount() - 1; subControllerCount >= 0; subControllerCount--) {
            ActivatedController subController = getSubController(subControllerCount);
            if (subController instanceof gy) {
                return ((gy) subController).m10732a();
            }
        }
        return null;
    }

    public final boolean isPopup(ActivatedController c0303e) {
        if (this.mPopupWindow == null || c0303e == null || c0303e.getContentView() == null || getPopupHolder(c0303e) == null) {
            return $assertionsDisabled;
        }
        return true;
    }

    protected boolean onBack() {
        if (super.onBack()) {
            return true;
        }
        ActivatedController topPopup = getTopPopup();
        if (topPopup == null || !topPopup.requestDetach()) {
            return $assertionsDisabled;
        }
        return true;
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (!(c0303e instanceof gv)) {
            return super.onRequestDetach(c0303e);
        }
        dismissPopup(((gv) c0303e).m10732a());
        if (this.mPopupWindow == null || getPopupCount() >= 1) {
            return true;
        }
        this.mPopupWindow.dismiss();
        this.mPopupWindow = null;
        this.mPopupRootView = null;
        return true;
    }

    protected ISubControllerParent newSubControllerParent() {
        return super.newSubControllerParent();
    }

    private gy getPopupHolder(ActivatedController c0303e) {
        for (int i = 0; i < getSubControllerCount(); i++) {
            ActivatedController subController = getSubController(i);
            if (subController instanceof gy) {
                gy gyVar = (gy) subController;
                if (gyVar.m10732a() == c0303e) {
                    return gyVar;
                }
            }
        }
        return null;
    }
}
