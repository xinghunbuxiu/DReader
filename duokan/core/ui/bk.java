package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class bk extends LinearLayout {
    static final /* synthetic */ boolean a = (!bk.class.desiredAssertionStatus());
    private OnHierarchyChangeListener b;
    private Drawable c;
    private View d;
    private boolean e;
    private boolean f;
    private bs g;
    private br h;
    private bq i;

    public bk(Context context) {
        this(context, null);
    }

    public bk(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.e = false;
        this.f = true;
        this.g = null;
        this.h = null;
        this.i = null;
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
        if (this.d == null) {
            return -1;
        }
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) == this.d) {
                return i;
            }
        }
        return -1;
    }

    public final View getSelectedChild() {
        return this.d;
    }

    public final void setOnSelectionChangeListener(br brVar) {
        this.h = brVar;
    }

    public final void setOnDelayedSelectionChangeListener(bq bqVar) {
        this.i = bqVar;
    }

    public final boolean a(int i) {
        return a(getChildAt(i));
    }

    public final boolean a(View view) {
        return a(view, false);
    }

    public final void setSelectAnimateEnable(boolean z) {
        this.f = z;
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.b = onHierarchyChangeListener;
    }

    public Drawable getBackground() {
        return this.c;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.c != drawable) {
            this.c = drawable;
            b();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.g = null;
        }
    }

    private boolean a(View view, boolean z) {
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
        if (this.f) {
            if (this.g != null) {
                this.g.b = view;
            } else {
                this.g = new bs(this);
                this.g.a = selectedChild;
                this.g.b = view;
                this.g.setAnimationListener(new bn(this));
            }
        }
        this.d = view;
        this.e = z;
        a(selectedChild, view, this.e);
        if (!this.f) {
            b(selectedChild, view, this.e);
        }
        invalidate();
        return true;
    }

    private void b() {
        if (this.c == null) {
            super.setBackgroundDrawable(null);
        } else {
            super.setBackgroundDrawable(new bp(this, this.c, 0));
        }
    }

    private void a(Rect rect, View view) {
        int i = 0;
        if (view == null) {
            rect.setEmpty();
            return;
        }
        int indexOfChild = indexOfChild(view);
        if (!a && indexOfChild < 0) {
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

    private void a(View view, View view2, boolean z) {
        if (this.h != null) {
            this.h.a(this, view, view2, z);
        }
    }

    private void b(View view, View view2, boolean z) {
        if (this.i != null) {
            this.i.a(this, view, view2, z);
        }
    }
}
