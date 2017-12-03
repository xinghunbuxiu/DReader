package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.bd;
import com.duokan.core.ui.bh;
import com.duokan.core.ui.UTools;

import java.util.ArrayList;

class dc extends gg {
    final /* synthetic */ FlowPagesView a;

    public dc(FlowPagesView flowPagesView, Context context) {
        this.a = flowPagesView;
        super(flowPagesView, context);
        setChildrenDrawingOrderEnabled(true);
    }

    protected bd n() {
        return new de(this, getContext());
    }

    public boolean onPreDraw() {
        if (!super.onPreDraw()) {
            return false;
        }
        if (getItemCount() < 3 || this.a.getCellsView().getChildCount() < 3 || this.a.getCurrentPagePresenter() == null) {
            return true;
        }
        Rect rect = (Rect) UTools.g.getRect();
        Rect rect2 = (Rect) UTools.g.getRect();
        rect2.set(getViewportBounds());
        this.a.f(rect);
        if (rect2.top < rect.top) {
            rect2.top = rect.top;
            rect2.bottom = rect2.top + getViewportBounds().height();
        }
        if (rect2.left < rect.left) {
            rect2.left = rect.left;
            rect2.right = rect2.left + getViewportBounds().width();
        }
        if (rect2.right > rect.right) {
            rect2.right = rect.right;
            rect2.left = rect2.right - getViewportBounds().width();
        }
        if (rect2.bottom > rect.bottom) {
            rect2.bottom = rect.bottom;
            rect2.top = rect2.bottom - getViewportBounds().height();
        }
        if (!rect2.equals(getViewportBounds())) {
            scrollTo(rect2.left, rect2.top);
        }
        UTools.g.getRect(rect2);
        UTools.g.getRect(rect);
        this.a.e(getPreviewBounds());
        if (this.a.b(getViewportBounds())) {
            return false;
        }
        this.a.q();
        return true;
    }

    protected int a(Point point) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (a(i, point)) {
                return i;
            }
        }
        return -1;
    }

    protected int[] a(Rect rect) {
        ArrayList arrayList = new ArrayList(getItemCount());
        for (int b = this.a.e; b <= this.a.f; b++) {
            int b2 = this.a.n(b);
            if (s(b2) && c(b2, rect)) {
                arrayList.add(Integer.valueOf(b2));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (b2 = 0; b2 < iArr.length; b2++) {
            iArr[b2] = ((Integer) arrayList.get(b2)).intValue();
        }
        return iArr;
    }

    protected int a(int i, int i2) {
        if (getItemCount() < 1) {
            return -1;
        }
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int e = this.a.i;
        int f = this.a.j;
        this.a.i = (Math.round(((float) size) * this.a.getZoomFactor()) + this.a.getPageLeftShadowWidth()) + this.a.getPageRightShadowWidth();
        this.a.j = (Math.round(((float) size2) * this.a.getZoomFactor()) + this.a.getPageTopShadowHeight()) + this.a.getPageBottomShadowHeight();
        if (this.a.o()) {
            c(-1073741823, 0, 1073741823, Math.max(this.a.j, size2));
        } else {
            c(0, -1073741823, Math.max(this.a.i, size), 1073741823);
        }
        if (this.a.i == e && this.a.j == f) {
            return 0;
        }
        return 1;
    }

    protected void a() {
        int i = -1;
        int i2 = 0;
        int l;
        int b;
        int contentWidth;
        if (!this.a.o()) {
            int i3;
            int p;
            l = this.a.h;
            for (i3 = 0; i3 <= this.a.f; i3++) {
                b = this.a.n(i3);
                p = p(b) > 0 ? p(b) : this.a.i;
                int q = q(b) > 0 ? q(b) : this.a.j;
                contentWidth = (getContentWidth() - p) / 2;
                a(b, contentWidth, l, contentWidth + p, l + q);
                h(b, MeasureSpec.makeMeasureSpec(0, 0));
                i(b, MeasureSpec.makeMeasureSpec(0, 0));
                l += q;
            }
            int l2 = this.a.h;
            while (i >= this.a.e) {
                b = this.a.n(i);
                p = p(b) > 0 ? p(b) : this.a.i;
                i3 = q(b) > 0 ? q(b) : this.a.j;
                contentWidth = (getContentWidth() - p) / 2;
                a(b, contentWidth, l2 - i3, contentWidth + p, l2);
                h(b, MeasureSpec.makeMeasureSpec(0, 0));
                i(b, MeasureSpec.makeMeasureSpec(0, 0));
                l2 -= i3;
                i--;
            }
        } else if (this.a.n()) {
            contentWidth = this.a.g;
            while (i2 >= this.a.e) {
                b = this.a.n(i2);
                l = (getContentHeight() - this.a.j) / 2;
                a(b, contentWidth, l, contentWidth + this.a.i, l + this.a.j);
                h(b, MeasureSpec.makeMeasureSpec(this.a.i, 1073741824));
                i(b, MeasureSpec.makeMeasureSpec(this.a.j, 1073741824));
                contentWidth += this.a.i;
                i2--;
            }
            r4 = this.a.g;
            for (i2 = 1; i2 <= this.a.f; i2++) {
                b = this.a.n(i2);
                l = (getContentHeight() - this.a.j) / 2;
                a(b, r4 - this.a.i, l, r4, l + this.a.j);
                h(b, MeasureSpec.makeMeasureSpec(this.a.i, 1073741824));
                i(b, MeasureSpec.makeMeasureSpec(this.a.j, 1073741824));
                r4 -= this.a.i;
            }
        } else {
            contentWidth = this.a.g;
            while (i2 <= this.a.f) {
                b = this.a.n(i2);
                l = (getContentHeight() - this.a.j) / 2;
                a(b, contentWidth, l, contentWidth + this.a.i, l + this.a.j);
                h(b, MeasureSpec.makeMeasureSpec(this.a.i, 1073741824));
                i(b, MeasureSpec.makeMeasureSpec(this.a.j, 1073741824));
                contentWidth += this.a.i;
                i2++;
            }
            r4 = this.a.g;
            for (i2 = -1; i2 >= this.a.e; i2--) {
                b = this.a.n(i2);
                l = (getContentHeight() - this.a.j) / 2;
                a(b, r4 - this.a.i, l, r4, l + this.a.j);
                h(b, MeasureSpec.makeMeasureSpec(this.a.i, 1073741824));
                i(b, MeasureSpec.makeMeasureSpec(this.a.j, 1073741824));
                r4 -= this.a.i;
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        int b;
        int b2;
        int c;
        if (this.a.p()) {
            b2 = this.a.e + i2;
            if (this.a.l == null) {
                b = this.a.n(b2);
            } else {
                c = this.a.f;
                b = this.a.e;
                while (b <= this.a.f) {
                    if (this.a.a.get(this.a.n(b)) == this.a.l) {
                        break;
                    }
                    b++;
                }
                b = c;
                if (b == this.a.f) {
                    b = this.a.n(b2);
                } else if (i2 == i - 1) {
                    b = this.a.n(b);
                } else {
                    b = this.a.n(b2 < b ? b2 : b2 + 1);
                }
            }
        } else {
            b2 = this.a.f - i2;
            if (this.a.l == null) {
                b = this.a.n(b2);
            } else {
                c = this.a.e;
                b = this.a.e;
                while (b <= this.a.f) {
                    if (this.a.a.get(this.a.n(b)) == this.a.l) {
                        break;
                    }
                    b++;
                }
                b = c;
                if (b == this.a.e) {
                    b = this.a.n(b2);
                } else if (i2 == i - 1) {
                    b = this.a.n(b);
                } else {
                    b = this.a.n(b2 > b ? b2 : b2 - 1);
                }
            }
        }
        return indexOfChild((View) g(b).getParent());
    }

    protected bh b() {
        return new dd(this);
    }
}
