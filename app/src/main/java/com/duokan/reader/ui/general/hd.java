package com.duokan.reader.ui.general;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.IController;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.a;
import com.duokan.core.ui.cv;
import com.duokan.core.ui.UTools;

public class hd extends ActivatedController {
    static final /* synthetic */ boolean $assertionsDisabled = (!hd.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final int FLAG_CONSUME_TOUCH_EVENTS = 2;
    public static final int FLAG_DEFAULT_POPUP = 2;
    public static final int FLAG_DISMISS_ON_TOUCH_OUTSIDE = 1;
    public static final int FLAG_NONE = 0;
    private ViewGroup mPopupRootView = null;
    private cv mPopupWindow = null;
    protected ActivatedController mShareController = null;

    public hd(IFeature featrue) {
        super(featrue);
    }

    public hd(IFeature featrue, int i) {
        super(featrue, i);
    }

    public final cv getPopupWindow() {
        if ($assertionsDisabled || isActive()) {
            if (this.mPopupWindow == null) {
                if ($assertionsDisabled || this.mPopupRootView == null) {
                    this.mPopupWindow = new he(this, getContext(), $assertionsDisabled);
                    this.mPopupRootView = new FrameLayout(getContext());
                    this.mPopupWindow.setContentView(this.mPopupRootView, new LayoutParams(-1, -1));
                    int b = UTools.closeAnimation(getContext(), 5.0f);
                    this.mPopupWindow.setBalloonPadding(b, b, b, b);
                } else {
                    throw new AssertionError();
                }
            }
            return this.mPopupWindow;
        }
        throw new AssertionError();
    }

    public boolean showPopupSmoothly(ActivatedController activatedControllerVar, Runnable runnable) {
        if (!showPopup(activatedControllerVar)) {
            return $assertionsDisabled;
        }
        TaskHandler.PostTask(runnable);
        return true;
    }

    @TargetApi(19)
    public boolean showPopup(ActivatedController activatedControllerVar) {
        return showPopup(activatedControllerVar, $assertionsDisabled);
    }

    public boolean showPopup(ActivatedController activatedControllerVar, boolean z) {
        return showPopup(activatedControllerVar, 119, (z ? 1 : 0) | 2);
    }

    @TargetApi(19)
    public boolean showPopup(ActivatedController activatedControllerVar, int i, int i2) {
        if (!$assertionsDisabled && !isActive()) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && activatedControllerVar == null) {
            throw new AssertionError();
        } else if (!isActive()) {
            return $assertionsDisabled;
        } else {
            ActivatedController hgVar = new hg(this, getContext(), activatedControllerVar, i, i2);
            addSubController(hgVar);
            getPopupWindow();
            if (!$assertionsDisabled && this.mPopupWindow == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.mPopupRootView != null) {
                this.mPopupRootView.addView(hgVar.getContentView(), new FrameLayout.LayoutParams(-1, -1));
                if (!this.mPopupWindow.isShowing()) {
                    this.mPopupWindow.show();
                }
                activate(hgVar);
                return true;
            } else {
                throw new AssertionError();
            }
        }
    }

    public void showBalloonPopup(ActivatedController activatedControllerVar, View view, int i) {
        showBalloonPopup(activatedControllerVar, view, i, 0);
    }

    public void showBalloonPopup(ActivatedController activatedControllerVar, View view, int i, int i2) {
        if (!$assertionsDisabled && !isActive()) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && activatedControllerVar == null) {
            throw new AssertionError();
        } else if (isActive()) {
            ActivatedController hfVar = new hf(this, getContext(), activatedControllerVar, i, i2);
            addSubController(hfVar);
            getPopupWindow();
            if ($assertionsDisabled || this.mPopupWindow != null) {
                this.mPopupWindow.showBalloon((a) hfVar.getContentView(), view);
                activate(hfVar);
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

    public final boolean dismissPopup(ActivatedController activatedControllerVar) {
        ActivatedController popupHolder = getPopupHolder(activatedControllerVar);
        if (popupHolder == null) {
            return $assertionsDisabled;
        }
        deactivate(popupHolder);
        if (popupHolder instanceof hf) {
            if ($assertionsDisabled || this.mPopupWindow != null) {
                this.mPopupWindow.removeBalloon((a) popupHolder.getContentView());
            } else {
                throw new AssertionError();
            }
        } else if (popupHolder instanceof hg) {
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
            if (subController instanceof hj) {
                return ((hj) subController).a();
            }
        }
        return null;
    }

    public final boolean isPopup(ActivatedController activatedControllerVar) {
        if (this.mPopupWindow == null || activatedControllerVar == null || activatedControllerVar.getContentView() == null || getPopupHolder(activatedControllerVar) == null) {
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

    protected boolean onRequestDetach(ActivatedController activatedControllerVar) {
        if (!(activatedControllerVar instanceof hg)) {
            return super.onRequestDetach(activatedControllerVar);
        }
        dismissPopup(((hg) activatedControllerVar).a());
        if (this.mPopupWindow == null || getPopupCount() >= 1) {
            return true;
        }
        this.mPopupWindow.dismiss();
        this.mPopupWindow = null;
        this.mPopupRootView = null;
        return true;
    }

    protected IController newSubControllerParent() {
        return super.newSubControllerParent();
    }

    private hj getPopupHolder(ActivatedController activatedControllerVar) {
        for (int i = 0; i < getSubControllerCount(); i++) {
            ActivatedController subController = getSubController(i);
            if (subController instanceof hj) {
                hj hjVar = (hj) subController;
                if (hjVar.a() == activatedControllerVar) {
                    return hjVar;
                }
            }
        }
        return null;
    }
}
