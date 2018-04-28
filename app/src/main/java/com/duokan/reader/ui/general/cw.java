package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.bj;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpStatus;

public class cw extends LinearScrollView {
    /* renamed from: a */
    private cx f6018a;
    /* renamed from: b */
    private int f6019b;

    /* renamed from: e */
    protected /* synthetic */ bj mo1597e() {
        return mo1599f();
    }

    public cw(Context context) {
        this(context, null);
    }

    public cw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6018a = null;
        this.f6019b = -1;
        setOrientation(0);
        setThumbEnabled(false);
        setHorizontalOverScrollMode(OverScrollMode.NEVER);
    }

    public int getShowingChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (m1279a(i)) {
                return i;
            }
        }
        return -1;
    }

    public void setOnFlipListener(cx cxVar) {
        this.f6018a = cxVar;
    }

    /* renamed from: b */
    public void m9070b(int i) {
        scrollBy(getChildAt(i).getLeft() - getViewportBounds().left, 0);
        setShowingChild(i);
    }

    /* renamed from: a */
    public void m9069a(int i, Runnable runnable, Runnable runnable2) {
        mo434a(getChildAt(i).getLeft(), 0, this.f6019b < 0 ? HttpStatus.SC_MULTIPLE_CHOICES : Math.abs(i - this.f6019b) * HttpStatus.SC_MULTIPLE_CHOICES, runnable, runnable2);
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

    /* renamed from: g */
    public void m9073g() {
        this.f6019b = -1;
    }

    /* renamed from: f */
    protected cy mo1599f() {
        return new cy(this);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int min = Math.min(this.f6019b, getChildCount() - 1);
            if (min >= 0) {
                scrollTo(getChildAt(min).getLeft(), 0);
            }
        }
    }

    private void setShowingChild(int i) {
        if (this.f6019b != i) {
            int i2 = this.f6019b;
            this.f6019b = i;
            if (this.f6018a != null) {
                this.f6018a.mo1699a(i2, this.f6019b);
            }
        }
    }

    private int getFirstViewableChildIndex() {
        for (int i = 0; i < getChildCount(); i++) {
            if (m1279a(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastViewableChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (m1279a(childCount)) {
                return childCount;
            }
        }
        return -1;
    }
}
