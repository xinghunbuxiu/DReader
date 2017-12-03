package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.bj;

import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class cw extends LinearScrollView {
    private cx a;
    private int b;

    protected /* synthetic */ bj e() {
        return f();
    }

    public cw(Context context) {
        this(context, null);
    }

    public cw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = -1;
        setOrientation(0);
        setThumbEnabled(false);
        setHorizontalOverScrollMode(OverScrollMode.NEVER);
    }

    public int getShowingChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (a(i)) {
                return i;
            }
        }
        return -1;
    }

    public void setOnFlipListener(cx cxVar) {
        this.a = cxVar;
    }

    public void b(int i) {
        scrollBy(getChildAt(i).getLeft() - getViewportBounds().left, 0);
        setShowingChild(i);
    }

    public void a(int i, Runnable runnable, Runnable runnable2) {
        a(getChildAt(i).getLeft(), 0, this.b < 0 ? HttpStatus.SC_MULTIPLE_CHOICES : Math.abs(i - this.b) * HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
    }

    public Integer[] getVisiableViewIndex() {
        List arrayList = new ArrayList();
        int childCount = getChildCount();
        Rect viewportBounds = getViewportBounds();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (viewportBounds.intersects(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom())) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return (Integer[]) arrayList.toArray(new Integer[0]);
    }

    public void g() {
        this.b = -1;
        removeAllViews();
    }

    protected cy f() {
        return new cy(this);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int min = Math.min(this.b, getChildCount() - 1);
            if (min >= 0) {
                scrollTo(getChildAt(min).getLeft(), 0);
            }
        }
    }

    private void setShowingChild(int i) {
        if (this.b != i) {
            int i2 = this.b;
            this.b = i;
            if (this.a != null) {
                this.a.a(i2, this.b);
            }
        }
    }

    private int getFirstViewableChildIndex() {
        for (int i = 0; i < getChildCount(); i++) {
            if (a(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastViewableChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (a(childCount)) {
                return childCount;
            }
        }
        return -1;
    }
}
