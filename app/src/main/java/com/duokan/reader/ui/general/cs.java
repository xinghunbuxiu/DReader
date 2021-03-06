package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import com.duokan.core.ui.bh;
import com.duokan.reader.ui.general.PagesView.PageLayout;

class cs extends ga {
    /* renamed from: a */
    static final /* synthetic */ boolean f7045a = (!FixedPagesView.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ FixedPagesView f7046b;

    public cs(FixedPagesView fixedPagesView, Context context) {
        this.f7046b = fixedPagesView;
        super(fixedPagesView, context);
        setChildrenDrawingOrderEnabled(true);
    }

    /* renamed from: a */
    protected int mo447a(Point point) {
        int itemCount = getItemCount();
        int i = 0;
        while (i < itemCount) {
            int i2 = (i + itemCount) / 2;
            if (m1118a(i2, point)) {
                return i2;
            }
            if (this.f7046b.getPageLayout() == PageLayout.TOP_TO_BOTTOM) {
                if (m1156m(i2) < point.y) {
                    i2++;
                } else {
                    itemCount = i2;
                    i2 = i;
                }
            } else if (this.f7046b.getPageLayout() == PageLayout.LEFT_TO_RIGHT) {
                if (m1154l(i2) < point.x) {
                    i2++;
                } else {
                    itemCount = i2;
                    i2 = i;
                }
            } else if (f7045a) {
                i2 = i;
            } else {
                throw new AssertionError();
            }
            i = i2;
        }
        return -1;
    }

    /* renamed from: a */
    protected int[] mo450a(Rect rect) {
        int itemCount = getItemCount();
        int i = -1;
        int i2 = itemCount;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = (i3 + i2) / 2;
            if (m1133c(i4, rect)) {
                i2 = i3;
                i3 = i4;
            } else if (this.f7046b.getPageLayout() == PageLayout.TOP_TO_BOTTOM) {
                if (m1156m(i4) < rect.top) {
                    i3 = i;
                    r8 = i4 + 1;
                    i4 = i2;
                    i2 = r8;
                } else {
                    i2 = i3;
                    i3 = i;
                }
            } else if (this.f7046b.getPageLayout() == PageLayout.LEFT_TO_RIGHT) {
                if (m1154l(i4) < rect.left) {
                    i3 = i;
                    r8 = i4 + 1;
                    i4 = i2;
                    i2 = r8;
                } else {
                    i2 = i3;
                    i3 = i;
                }
            } else if (f7045a) {
                i4 = i2;
                i2 = i3;
                i3 = i;
            } else {
                throw new AssertionError();
            }
            i = i3;
            i3 = i2;
            i2 = i4;
        }
        if (i < 0) {
            return new int[0];
        }
        i4 = i + 1;
        i2 = i;
        while (i4 < itemCount && m1133c(i4, rect)) {
            i2 = i4;
            i4++;
        }
        int[] iArr = new int[((i2 - i) + 1)];
        for (i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = i + i4;
        }
        return iArr;
    }

    /* renamed from: a */
    protected int mo446a(int i, int i2) {
        if (getItemCount() < 1) {
            return -1;
        }
        int a;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int itemCount = getItemCount();
        if (itemCount > 0) {
            int i3 = itemCount / 2;
            a = this.f7046b.getProxyAdapter().m10414a(i3);
            i3 = this.f7046b.getProxyAdapter().m10417b(i3);
            if (mode != 0 && mode2 != 0) {
                this.f7046b.f6842g = size;
                this.f7046b.f6843h = size2;
            } else if (mode == 0) {
                this.f7046b.f6842g = Integer.MAX_VALUE;
                this.f7046b.f6843h = size2;
            } else {
                this.f7046b.f6842g = size;
                this.f7046b.f6843h = Integer.MAX_VALUE;
            }
            float a2 = this.f7046b.m10029a(a, i3, this.f7046b.f6842g, this.f7046b.f6843h, this.f7046b.f6838c);
            a = this.f7046b.m10040b(a, a2, this.f7046b.getZoomFactor());
            mode = this.f7046b.m10045c(i3, a2, this.f7046b.getZoomFactor());
        } else {
            mode = 0;
            a = 0;
        }
        this.f7046b.f6840e = a;
        this.f7046b.f6841f = mode;
        if (itemCount > 0) {
            switch (cq.f7043b[this.f7046b.getPageLayout().ordinal()]) {
                case 1:
                    a = this.f7046b.f6840e + paddingLeft;
                    mode = ((this.f7046b.f6841f * itemCount) + (this.f7046b.f6837b * (itemCount - 1))) + paddingTop;
                    break;
                case 2:
                    a = ((this.f7046b.f6840e * itemCount) + (this.f7046b.f6837b * (itemCount - 1))) + paddingLeft;
                    mode = this.f7046b.f6841f + paddingTop;
                    break;
                default:
                    if (f7045a) {
                        mode = 0;
                        a = 0;
                        break;
                    }
                    throw new AssertionError();
            }
        }
        mode = 0;
        a = 0;
        m1143g(a, mode);
        return 0;
    }

    /* renamed from: a */
    protected void mo448a() {
        int itemCount = getItemCount();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i6 < itemCount) {
            int i12;
            int i13;
            int i14;
            int i15;
            int a = this.f7046b.getProxyAdapter().m10414a(i6);
            int b = this.f7046b.getProxyAdapter().m10417b(i6);
            if (i3 == a && i4 == b) {
                i12 = i11;
                i13 = i5;
                i14 = i4;
                i15 = i3;
            } else {
                float a2 = this.f7046b.m10029a(a, b, this.f7046b.f6842g, this.f7046b.f6843h, this.f7046b.f6838c);
                i5 = this.f7046b.m10040b(a, a2, this.f7046b.getZoomFactor());
                i12 = this.f7046b.m10045c(b, a2, this.f7046b.getZoomFactor());
                i13 = i5;
                i14 = b;
                i15 = a;
            }
            b = 0;
            i5 = 0;
            switch (cq.f7043b[this.f7046b.getPageLayout().ordinal()]) {
                case 1:
                    b = (this.f7046b.f6842g - i13) / 2;
                    i5 = i2;
                    i2 = (this.f7046b.f6837b + i12) + i2;
                    break;
                case 2:
                    b = i + Math.max(0, (this.f7046b.f6842g - i13) / 2);
                    i5 = (this.f7046b.f6843h - i12) / 2;
                    i = (Math.max(i13, this.f7046b.f6842g) + this.f7046b.f6837b) + i;
                    break;
                default:
                    if (!f7045a) {
                        throw new AssertionError();
                    }
                    break;
            }
            i4 = b + i13;
            i3 = i5 + i12;
            i10 = Math.min(i10, b);
            i9 = Math.min(i9, i5);
            i8 = Math.max(i8, this.f7046b.getPageLayout() == PageLayout.TOP_TO_BOTTOM ? i4 : i - this.f7046b.f6837b);
            i7 = Math.max(i7, i3);
            m1112a(i6, b, i5, i4, i3);
            m1146h(i6, MeasureSpec.makeMeasureSpec(i13, 1073741824));
            m1149i(i6, MeasureSpec.makeMeasureSpec(i12, 1073741824));
            i6++;
            i5 = i13;
            i4 = i14;
            i3 = i15;
            i11 = i12;
        }
        m1131c(i10, i9, i8, i7);
    }

    /* renamed from: b */
    protected bh mo489b() {
        return new ct(this);
    }
}
