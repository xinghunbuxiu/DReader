package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.ui.bd;
import com.duokan.core.ui.bh;
import com.duokan.core.ui.AnimUtils;
import java.util.ArrayList;

class dc extends ga {
    /* renamed from: a */
    final /* synthetic */ FlowPagesView f7055a;

    public dc(FlowPagesView flowPagesView, Context context) {
        this.f7055a = flowPagesView;
        super(flowPagesView, context);
        setChildrenDrawingOrderEnabled(true);
    }

    /* renamed from: n */
    protected bd mo1766n() {
        return new de(this, getContext());
    }

    public boolean onPreDraw() {
        if (!super.onPreDraw()) {
            return false;
        }
        if (getItemCount() < 3 || this.f7055a.getCellsView().getChildCount() < 3 || this.f7055a.getCurrentPagePresenter() == null) {
            return true;
        }
        Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
        Rect rect2 = (Rect) AnimUtils.f1198g.addAnimation();
        rect2.set(getViewportBounds());
        this.f7055a.m10099f(rect);
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
        AnimUtils.f1198g.clearAnimation(rect2);
        AnimUtils.f1198g.clearAnimation(rect);
        this.f7055a.m10095e(getPreviewBounds());
        if (this.f7055a.m10081b(getViewportBounds())) {
            return false;
        }
        this.f7055a.mo2169q();
        return true;
    }

    /* renamed from: a */
    protected int mo447a(Point point) {
        int itemCount = getItemCount();
        for (int i = 0; i < itemCount; i++) {
            if (m1118a(i, point)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    protected int[] mo450a(Rect rect) {
        ArrayList arrayList = new ArrayList(getItemCount());
        for (int b = this.f7055a.f6852e; b <= this.f7055a.f6853f; b++) {
            int b2 = this.f7055a.m10117n(b);
            if (m1164s(b2) && m1133c(b2, rect)) {
                arrayList.add(Integer.valueOf(b2));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (b2 = 0; b2 < iArr.length; b2++) {
            iArr[b2] = ((Integer) arrayList.get(b2)).intValue();
        }
        return iArr;
    }

    /* renamed from: a */
    protected int mo446a(int i, int i2) {
        if (getItemCount() < 1) {
            return -1;
        }
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int e = this.f7055a.f6856i;
        int f = this.f7055a.f6857j;
        this.f7055a.f6856i = (Math.round(((float) size) * this.f7055a.getZoomFactor()) + this.f7055a.getPageLeftShadowWidth()) + this.f7055a.getPageRightShadowWidth();
        this.f7055a.f6857j = (Math.round(((float) size2) * this.f7055a.getZoomFactor()) + this.f7055a.getPageTopShadowHeight()) + this.f7055a.getPageBottomShadowHeight();
        if (this.f7055a.m10027o()) {
            m1131c(-1073741823, 0, 1073741823, Math.max(this.f7055a.f6857j, size2));
        } else {
            m1131c(0, -1073741823, Math.max(this.f7055a.f6856i, size), 1073741823);
        }
        if (this.f7055a.f6856i == e && this.f7055a.f6857j == f) {
            return 0;
        }
        return 1;
    }

    /* renamed from: a */
    protected void mo448a() {
        int i = -1;
        int i2 = 0;
        int l;
        int b;
        int contentWidth;
        if (!this.f7055a.m10027o()) {
            int i3;
            int p;
            l = this.f7055a.f6855h;
            for (i3 = 0; i3 <= this.f7055a.f6853f; i3++) {
                b = this.f7055a.m10117n(i3);
                p = m1161p(b) > 0 ? m1161p(b) : this.f7055a.f6856i;
                int q = m1162q(b) > 0 ? m1162q(b) : this.f7055a.f6857j;
                contentWidth = (getContentWidth() - p) / 2;
                m1112a(b, contentWidth, l, contentWidth + p, l + q);
                m1146h(b, MeasureSpec.makeMeasureSpec(0, 0));
                m1149i(b, MeasureSpec.makeMeasureSpec(0, 0));
                l += q;
            }
            int l2 = this.f7055a.f6855h;
            while (i >= this.f7055a.f6852e) {
                b = this.f7055a.m10117n(i);
                p = m1161p(b) > 0 ? m1161p(b) : this.f7055a.f6856i;
                i3 = m1162q(b) > 0 ? m1162q(b) : this.f7055a.f6857j;
                contentWidth = (getContentWidth() - p) / 2;
                m1112a(b, contentWidth, l2 - i3, contentWidth + p, l2);
                m1146h(b, MeasureSpec.makeMeasureSpec(0, 0));
                m1149i(b, MeasureSpec.makeMeasureSpec(0, 0));
                l2 -= i3;
                i--;
            }
        } else if (this.f7055a.m10026n()) {
            contentWidth = this.f7055a.f6854g;
            while (i2 >= this.f7055a.f6852e) {
                b = this.f7055a.m10117n(i2);
                l = (getContentHeight() - this.f7055a.f6857j) / 2;
                m1112a(b, contentWidth, l, contentWidth + this.f7055a.f6856i, l + this.f7055a.f6857j);
                m1146h(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6856i, 1073741824));
                m1149i(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6857j, 1073741824));
                contentWidth += this.f7055a.f6856i;
                i2--;
            }
            r4 = this.f7055a.f6854g;
            for (i2 = 1; i2 <= this.f7055a.f6853f; i2++) {
                b = this.f7055a.m10117n(i2);
                l = (getContentHeight() - this.f7055a.f6857j) / 2;
                m1112a(b, r4 - this.f7055a.f6856i, l, r4, l + this.f7055a.f6857j);
                m1146h(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6856i, 1073741824));
                m1149i(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6857j, 1073741824));
                r4 -= this.f7055a.f6856i;
            }
        } else {
            contentWidth = this.f7055a.f6854g;
            while (i2 <= this.f7055a.f6853f) {
                b = this.f7055a.m10117n(i2);
                l = (getContentHeight() - this.f7055a.f6857j) / 2;
                m1112a(b, contentWidth, l, contentWidth + this.f7055a.f6856i, l + this.f7055a.f6857j);
                m1146h(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6856i, 1073741824));
                m1149i(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6857j, 1073741824));
                contentWidth += this.f7055a.f6856i;
                i2++;
            }
            r4 = this.f7055a.f6854g;
            for (i2 = -1; i2 >= this.f7055a.f6852e; i2--) {
                b = this.f7055a.m10117n(i2);
                l = (getContentHeight() - this.f7055a.f6857j) / 2;
                m1112a(b, r4 - this.f7055a.f6856i, l, r4, l + this.f7055a.f6857j);
                m1146h(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6856i, 1073741824));
                m1149i(b, MeasureSpec.makeMeasureSpec(this.f7055a.f6857j, 1073741824));
                r4 -= this.f7055a.f6856i;
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        int b;
        int b2;
        int c;
        if (this.f7055a.m10028p()) {
            b2 = this.f7055a.f6852e + i2;
            if (this.f7055a.f6859l == null) {
                b = this.f7055a.m10117n(b2);
            } else {
                c = this.f7055a.f6853f;
                b = this.f7055a.f6852e;
                while (b <= this.f7055a.f6853f) {
                    if (this.f7055a.f6848a.get(this.f7055a.m10117n(b)) == this.f7055a.f6859l) {
                        break;
                    }
                    b++;
                }
                b = c;
                if (b == this.f7055a.f6853f) {
                    b = this.f7055a.m10117n(b2);
                } else if (i2 == i - 1) {
                    b = this.f7055a.m10117n(b);
                } else {
                    b = this.f7055a.m10117n(b2 < b ? b2 : b2 + 1);
                }
            }
        } else {
            b2 = this.f7055a.f6853f - i2;
            if (this.f7055a.f6859l == null) {
                b = this.f7055a.m10117n(b2);
            } else {
                c = this.f7055a.f6852e;
                b = this.f7055a.f6852e;
                while (b <= this.f7055a.f6853f) {
                    if (this.f7055a.f6848a.get(this.f7055a.m10117n(b)) == this.f7055a.f6859l) {
                        break;
                    }
                    b++;
                }
                b = c;
                if (b == this.f7055a.f6852e) {
                    b = this.f7055a.m10117n(b2);
                } else if (i2 == i - 1) {
                    b = this.f7055a.m10117n(b);
                } else {
                    b = this.f7055a.m10117n(b2 > b ? b2 : b2 - 1);
                }
            }
        }
        return indexOfChild((View) m1141g(b).getParent());
    }

    /* renamed from: b */
    protected bh mo489b() {
        return new dd(this);
    }
}
