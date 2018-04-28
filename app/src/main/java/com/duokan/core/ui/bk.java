package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;

public class bk extends LinearLayout {
    /* renamed from: a */
    static final /* synthetic */ boolean f1015a = (!bk.class.desiredAssertionStatus());
    /* renamed from: b */
    private OnHierarchyChangeListener f1016b;
    /* renamed from: c */
    private Drawable f1017c;
    /* renamed from: d */
    private View f1018d;
    /* renamed from: e */
    private boolean f1019e;
    /* renamed from: f */
    private boolean f1020f;
    /* renamed from: g */
    private bs f1021g;
    /* renamed from: h */
    private br f1022h;
    /* renamed from: i */
    private bq f1023i;

    public bk(Context context) {
        this(context, null);
    }

    public bk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1018d = null;
        this.f1019e = false;
        this.f1020f = true;
        this.f1021g = null;
        this.f1022h = null;
        this.f1023i = null;
        super.setOnHierarchyChangeListener(new bl(this));
    }

    public final int getSelectedId() {
        View selectedChild = getSelectedChild();
        if (selectedChild == null) {
            return -1;
        }
        return selectedChild.getId();
    }

    public final int getSelectedIndex() {
        if (this.f1018d == null) {
            return -1;
        }
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == this.f1018d) {
                return i;
            }
        }
        return -1;
    }

    public final View getSelectedChild() {
        return this.f1018d;
    }

    public final void setOnSelectionChangeListener(br brVar) {
        this.f1022h = brVar;
    }

    public final void setOnDelayedSelectionChangeListener(bq bqVar) {
        this.f1023i = bqVar;
    }

    /* renamed from: a */
    public final boolean m1695a(int i) {
        return m1696a(getChildAt(i));
    }

    /* renamed from: a */
    public final boolean m1696a(View view) {
        return m1686a(view, false);
    }

    public final void setSelectAnimateEnable(boolean z) {
        this.f1020f = z;
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1016b = onHierarchyChangeListener;
    }

    public Drawable getBackground() {
        return this.f1017c;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f1017c != drawable) {
            this.f1017c = drawable;
            m1690b();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f1021g = null;
        }
    }

    /* renamed from: a */
    private boolean m1686a(View view, boolean z) {
        if (view != null && view.getParent() != this) {
            return false;
        }
        View selectedChild = getSelectedChild();
        if (view == selectedChild) {
            return false;
        }
        if (selectedChild != null) {
            selectedChild.setSelected(false);
        }
        if (view != null) {
            view.setSelected(true);
        }
        if (this.f1020f) {
            if (this.f1021g != null) {
                this.f1021g.f1031b = view;
            } else {
                this.f1021g = new bs(this);
                this.f1021g.f1030a = selectedChild;
                this.f1021g.f1031b = view;
                this.f1021g.setAnimationListener(new bn(this));
            }
        }
        this.f1018d = view;
        this.f1019e = z;
        m1683a(selectedChild, view, this.f1019e);
        if (!this.f1020f) {
            m1691b(selectedChild, view, this.f1019e);
        }
        invalidate();
        return true;
    }

    /* renamed from: b */
    private void m1690b() {
        if (this.f1017c == null) {
            super.setBackgroundDrawable(null);
        } else {
            super.setBackgroundDrawable(new bp(this, this.f1017c, 0));
        }
    }

    /* renamed from: a */
    private void m1682a(Rect rect, View view) {
        int i = 0;
        if (view == null) {
            rect.setEmpty();
            return;
        }
        int indexOfChild = indexOfChild(view);
        if (!f1015a && indexOfChild < 0) {
            throw new AssertionError();
        } else if (getOrientation() == 0) {
            rect.left = indexOfChild == 0 ? 0 : view.getLeft();
            rect.top = 0;
            rect.right = indexOfChild == getChildCount() + -1 ? getWidth() : view.getRight();
            rect.bottom = getHeight();
        } else {
            rect.left = 0;
            if (indexOfChild != 0) {
                i = view.getTop();
            }
            rect.top = i;
            rect.right = getWidth();
            rect.bottom = indexOfChild == getChildCount() + -1 ? getHeight() : view.getBottom();
        }
    }

    /* renamed from: a */
    private void m1683a(View view, View view2, boolean z) {
        if (this.f1022h != null) {
            this.f1022h.m1698a(this, view, view2, z);
        }
    }

    /* renamed from: b */
    private void m1691b(View view, View view2, boolean z) {
        if (this.f1023i != null) {
            this.f1023i.mo2314a(this, view, view2, z);
        }
    }
}
