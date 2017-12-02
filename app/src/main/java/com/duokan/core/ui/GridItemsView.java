package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;

public class GridItemsView extends ay {
    static final /* synthetic */ boolean a = (!GridItemsView.class.desiredAssertionStatus());
    private int b;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private int l;
    private Drawable m;
    private int n;
    private int o;
    private int p;
    private int q;
    private ArrayList r;

    public GridItemsView(Context context) {
        this(context, null);
    }

    public GridItemsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = null;
        this.l = 0;
        this.m = null;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 2;
        this.r = new ArrayList(1);
        setClipToPadding(false);
    }

    public final int getStretchMode() {
        return this.q;
    }

    public final void setStretchMode(int i) {
        if (this.q != i) {
            this.q = i;
            i();
        }
    }

    public final int getDesiredColumnWidth() {
        return this.h;
    }

    public final void setDesiredColumnWidth(int i) {
        if (this.h != i) {
            this.h = i;
            i();
        }
    }

    public final int getNumColumns() {
        return this.g;
    }

    public final void setNumColumns(int i) {
        if (this.g != i) {
            this.g = i;
            i();
        }
    }

    public final int getColumnCount() {
        l();
        return this.d;
    }

    public final Drawable getColumnDivider() {
        return this.m;
    }

    public final void setColumnDivider(Drawable drawable) {
        a(drawable, false);
    }

    public final void a(Drawable drawable, boolean z) {
        if (this.m != drawable) {
            this.m = drawable;
            if (!z) {
                setDesiredColumnSpacing(this.m == null ? 0 : this.m.getIntrinsicWidth());
            }
        }
    }

    public final int getDesiredColumnSpacing() {
        return this.n;
    }

    public final void setDesiredColumnSpacing(int i) {
        if (this.n != i) {
            this.n = i;
            i();
        }
    }

    public final int getRowCount() {
        l();
        return this.f;
    }

    public final Drawable getRowBackground() {
        return this.j;
    }

    public final void setRowBackground(int i) {
        setRowBackground(getResources().getDrawable(i));
    }

    public final void setRowBackground(Drawable drawable) {
        this.j = drawable;
        invalidate();
    }

    public final Drawable getRowDivider() {
        return this.k;
    }

    public final void setRowDivider(int i) {
        setRowDivider(getResources().getDrawable(i));
    }

    public final void setRowDivider(Drawable drawable) {
        b(drawable, false);
    }

    public final void b(Drawable drawable, boolean z) {
        if (this.k != drawable) {
            this.k = drawable;
            if (!z) {
                setRowSpacing(this.k == null ? 0 : this.k.getIntrinsicHeight());
            }
        }
    }

    public final int getRowSpacing() {
        return this.l;
    }

    public final void setRowSpacing(int i) {
        if (this.l != i) {
            this.l = i;
            i();
        }
    }

    public final int getGroupCount() {
        return this.p;
    }

    public final int a(int i) {
        v vVar = (v) this.r.get(i);
        return vVar.b - vVar.a;
    }

    public final void a(int i, Rect rect, int i2) {
        if (!rect.isEmpty() && rect.width() != 0 && rect.height() != 0 && i >= 0 && this.r.size() > i) {
            Rect c = c(i);
            Rect rect2 = (Rect) dv.g.a();
            Gravity.apply(i2, c.width(), c.height(), c(rect), rect2);
            scrollBy(c.left - rect2.left, c.top - rect2.top);
            dv.g.a(rect2);
            e();
        }
    }

    public final void b(int i) {
        if (!getViewportBounds().isEmpty() && getContentWidth() != 0 && getContentHeight() != 0 && i >= 0 && this.r.size() > i) {
            Rect c = c(i);
            scrollTo(c.left, c.top);
            e();
        }
    }

    public Rect c(int i) {
        View view = ((v) this.r.get(i)).e;
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    protected int a(Point point) {
        int i = 0;
        int i2 = 0;
        while (i2 < this.f) {
            int b = b(i2, 0);
            if (!a && b < 0) {
                throw new AssertionError();
            } else if (o(b) <= point.y) {
                i2++;
            } else {
                if (m(b) <= point.y) {
                    while (i < this.d) {
                        b = b(i2, i);
                        if (a(b, point)) {
                            return b;
                        }
                        i++;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    protected int[] a(Rect rect) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (i3 < this.f) {
            int b = b(i3, 0);
            if (a || b >= 0) {
                if (c(b, rect)) {
                    if (i2 < 0) {
                        i2 = b;
                    }
                    i = b(i3, this.d - 1);
                    if (!a && i < 0) {
                        throw new AssertionError();
                    }
                } else if (i2 >= 0) {
                    break;
                }
                i3++;
            } else {
                throw new AssertionError();
            }
        }
        if (i2 < 0) {
            return new int[0];
        }
        int[] iArr = new int[((i - i2) + 1)];
        for (int i4 = i2; i4 <= i; i4++) {
            iArr[i4 - i2] = i4;
        }
        return iArr;
    }

    protected void a(Canvas canvas) {
        super.a(canvas);
        Rect rect = (Rect) dv.g.a();
        if (this.j != null) {
            int[] m = m();
            if (m.length > 0) {
                int d = d(m[m.length - 1]);
                for (int d2 = d(m[0]); d2 <= d; d2++) {
                    a(d2, rect);
                    this.j.setLevel(d2);
                    this.j.setBounds(rect);
                    this.j.draw(canvas);
                }
            }
        }
        dv.g.a(rect);
    }

    protected void b(Canvas canvas) {
        int d;
        int d2;
        int i;
        int f;
        super.b(canvas);
        Rect rect = (Rect) dv.g.a();
        Rect rect2 = (Rect) dv.g.a();
        if (this.k != null) {
            int[] m = m();
            if (m.length > 0) {
                d = d(m[0]);
                d2 = d(m[m.length - 1]);
                for (i = d; i <= d2; i++) {
                    f = f(i);
                    if (c(f, i - ((v) this.r.get(f)).c)) {
                        a(i, rect);
                        a(i + 1, rect2);
                        if (!Rect.intersects(rect, getViewportBounds()) || !Rect.intersects(rect2, getViewportBounds())) {
                            break;
                        }
                        d = ((rect2.top + rect.bottom) - this.k.getIntrinsicHeight()) / 2;
                        this.k.setBounds(rect.left, d, rect.right, this.k.getIntrinsicHeight() + d);
                        this.k.draw(canvas);
                    }
                }
            }
        }
        if (this.m != null) {
            for (i = 0; i < this.r.size(); i++) {
                v vVar = (v) this.r.get(i);
                if (vVar.d - vVar.c >= 1) {
                    a(vVar.c, rect);
                    a(vVar.d - 1, rect2);
                    d2 = rect.top;
                    f = rect2.bottom;
                    for (d = 0; d < this.d - 1; d++) {
                        b(d, rect);
                        b(d + 1, rect2);
                        if (!Rect.intersects(rect, getViewportBounds()) || !Rect.intersects(rect2, getViewportBounds())) {
                            break;
                        }
                        int intrinsicWidth = ((rect2.left + rect.right) - this.m.getIntrinsicWidth()) / 2;
                        this.m.setBounds(intrinsicWidth, d2, this.m.getIntrinsicWidth() + intrinsicWidth, f);
                        this.m.draw(canvas);
                    }
                }
            }
        }
        dv.g.a(rect2);
        dv.g.a(rect);
    }

    protected void a() {
        int cellsMarginLeft = getCellsMarginLeft();
        int cellsMarginTop = getCellsMarginTop();
        for (int i = 0; i < this.r.size(); i++) {
            v vVar = (v) this.r.get(i);
            if (vVar.e != null) {
                be beVar = (be) vVar.e.getLayoutParams();
                int i2 = beVar.leftMargin + cellsMarginLeft;
                int i3 = beVar.topMargin + cellsMarginTop;
                vVar.e.layout(i2, i3, vVar.e.getMeasuredWidth() + i2, vVar.e.getMeasuredHeight() + i3);
                cellsMarginTop = (vVar.e.getMeasuredHeight() + i3) + beVar.bottomMargin;
            }
            for (int i4 = 0; i4 < vVar.d - vVar.c; i4++) {
                int i5 = 0;
                int i6 = 0;
                while (i5 < this.d) {
                    i3 = (vVar.a + (this.d * i4)) + i5;
                    if (i3 >= vVar.b) {
                        break;
                    }
                    if (q(i3) < 0) {
                        h(i3, MeasureSpec.makeMeasureSpec(this.b, 1073741824));
                        i(i3, MeasureSpec.makeMeasureSpec(0, 0));
                    }
                    i2 = q(i3);
                    if (i2 < 0) {
                        i2 = o(i3) - m(i3);
                        if (i2 < 0) {
                            i2 = this.i;
                        }
                    }
                    i5++;
                    i6 = Math.max(i6, i2);
                }
                i3 = cellsMarginLeft;
                for (int i7 = 0; i7 < this.d; i7++) {
                    i2 = (vVar.a + (this.d * i4)) + i7;
                    if (i2 >= vVar.b) {
                        break;
                    }
                    int i8 = i3 + this.b;
                    int i9 = cellsMarginTop + i6;
                    h(i2, MeasureSpec.makeMeasureSpec(this.b, 1073741824));
                    if (q(i2) >= 0) {
                        i(i2, MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    }
                    a(i2, i3, cellsMarginTop, i8, i9);
                    i3 = i8 + this.o;
                }
                cellsMarginTop += i6;
                if (c(i, i4)) {
                    cellsMarginTop += this.l;
                }
            }
        }
        g(this.e + getCellsMarginHorizontal(), getCellsMarginBottom() + cellsMarginTop);
    }

    protected int a(int i, int i2) {
        int size;
        v vVar;
        int i3;
        int p;
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i);
        int cellsMarginHorizontal = getCellsMarginHorizontal();
        int cellsMarginVertical = getCellsMarginVertical();
        int itemCount = getItemCount();
        int i4 = this.b;
        this.p = getAdapter() instanceof w ? ((w) getAdapter()).a() : 0;
        if (this.p < 1) {
            for (size = this.r.size() - 1; size >= 0; size--) {
                vVar = (v) this.r.get(size);
                if (vVar.e != null) {
                    removeViewInLayout(vVar.e);
                }
                this.r.remove(size);
            }
            vVar = new v();
            vVar.a = 0;
            vVar.b = vVar.a + itemCount;
            vVar.e = null;
            this.r.add(vVar);
        } else {
            w wVar = (w) getAdapter();
            this.r.ensureCapacity(this.p);
            for (i3 = 0; i3 < this.p; i3++) {
                v vVar2;
                if (i3 < this.r.size()) {
                    vVar2 = (v) this.r.get(i3);
                } else {
                    v vVar3 = new v();
                    this.r.add(vVar3);
                    vVar2 = vVar3;
                }
                if (i3 < 1) {
                    size = 0;
                } else {
                    size = ((v) this.r.get(i3 - 1)).b;
                }
                vVar2.a = size;
                vVar2.b = vVar2.a + wVar.a(i3);
                View view = vVar2.e;
                vVar2.e = wVar.a(i3, view, this);
                if (vVar2.e != view) {
                    if (view != null) {
                        removeViewInLayout(view);
                    }
                    if (vVar2.e != null) {
                        LayoutParams g;
                        if (vVar2.e.getLayoutParams() == null) {
                            g = g();
                        } else if (vVar2.e.getLayoutParams() instanceof be) {
                            be beVar = (be) vVar2.e.getLayoutParams();
                        } else {
                            g = a(vVar2.e.getLayoutParams());
                        }
                        addViewInLayout(vVar2.e, -1, g);
                    }
                }
            }
            for (size = this.r.size() - 1; size >= this.p; size--) {
                vVar = (v) this.r.get(size);
                if (vVar.e != null) {
                    removeViewInLayout(vVar.e);
                }
                this.r.remove(size);
            }
        }
        if (itemCount > 0) {
            h(0, MeasureSpec.makeMeasureSpec(0, 0));
            i(0, MeasureSpec.makeMeasureSpec(0, 0));
            k(0);
            p = mode == 0 ? p(0) : Math.min(p(0), size2 - cellsMarginHorizontal);
            i3 = q(0);
        } else {
            i3 = 0;
            p = 0;
        }
        if (this.q == 1) {
            if (this.h > 0) {
                p = this.h;
            }
            if (this.g > 0) {
                itemCount = this.g;
            } else if (mode == 0) {
                itemCount = 1;
            } else {
                itemCount = this.n + p > 0 ? ((size2 - cellsMarginHorizontal) + this.n) / (this.n + p) : itemCount;
            }
            int i5;
            if (mode == 0) {
                size = this.n;
                i5 = p;
                p = itemCount;
                itemCount = i5;
            } else {
                size = itemCount < 2 ? 0 : ((size2 - cellsMarginHorizontal) - (p * itemCount)) / (itemCount - 1);
                i5 = p;
                p = itemCount;
                itemCount = i5;
            }
        } else {
            if (this.g > 0) {
                size = this.g;
            } else if (mode == 0) {
                size = 1;
            } else if (this.h > 0) {
                if (this.h + this.n > 0) {
                    itemCount = ((size2 - cellsMarginHorizontal) + this.n) / (this.h + this.n);
                }
                size = Math.max(1, itemCount);
            } else {
                if (this.n + p > 0) {
                    itemCount = ((size2 - cellsMarginHorizontal) + this.n) / (this.n + p);
                }
                size = Math.max(1, itemCount);
            }
            if (a || size > 0) {
                if (mode != 0) {
                    p = (((size2 - cellsMarginHorizontal) + this.n) / size) - this.n;
                } else if (this.h > 0) {
                    p = this.h;
                }
                itemCount = p;
                p = size;
                size = this.n;
            } else {
                throw new AssertionError();
            }
        }
        this.d = p;
        if (size < 0) {
            this.b = this.e / p;
            this.o = 0;
        } else {
            this.b = itemCount;
            this.o = size;
        }
        this.f = 0;
        for (size = 0; size < this.r.size(); size++) {
            vVar = (v) this.r.get(size);
            int i6 = (((vVar.b - vVar.a) + this.d) - 1) / this.d;
            vVar.c = this.f;
            vVar.d = vVar.c + i6;
            this.f += i6;
        }
        this.e = (this.b * this.d) + (this.o * (this.d - 1));
        if (getItemCount() > 0) {
            h(0, MeasureSpec.makeMeasureSpec(itemCount, 1073741824));
            i(0, MeasureSpec.makeMeasureSpec(0, 0));
            k(0);
            this.i = q(0);
        } else {
            this.i = i3;
        }
        itemCount = 0;
        while (itemCount < this.r.size()) {
            vVar = (v) this.r.get(itemCount);
            mode = vVar.d - vVar.c;
            if (vVar.e != null) {
                beVar = (be) vVar.e.getLayoutParams();
                View view2 = vVar.e;
                cellsMarginHorizontal = MeasureSpec.makeMeasureSpec((this.e - beVar.leftMargin) - beVar.rightMargin, 1073741824);
                if (beVar.height > 0) {
                    i6 = MeasureSpec.makeMeasureSpec(beVar.height, 1073741824);
                } else {
                    i6 = MeasureSpec.makeMeasureSpec(0, 0);
                }
                view2.measure(cellsMarginHorizontal, i6);
                size = cellsMarginVertical + ((vVar.e.getMeasuredHeight() + beVar.topMargin) + beVar.bottomMargin);
            } else {
                size = cellsMarginVertical;
            }
            if (mode > 0) {
                size += (i3 * mode) + (this.l * (mode - 1));
                if (c(itemCount, mode - 1)) {
                    size += this.l;
                }
            }
            itemCount++;
            cellsMarginVertical = size;
        }
        g(this.e + getCellsMarginHorizontal(), cellsMarginVertical);
        if (getItemCount() >= 1 || this.p >= 1) {
            return this.b != i4 ? 1 : 0;
        } else {
            return -1;
        }
    }

    protected final Rect a(int i, Rect rect) {
        int b = b(i, 0);
        rect.left = l(b);
        rect.top = m(b);
        rect.right = rect.left + this.e;
        rect.bottom = o(b);
        return rect;
    }

    protected final Rect b(int i, Rect rect) {
        int b = b(this.f - 1, 0);
        rect.left = getCellsMarginLeft() + ((this.b + this.o) * i);
        rect.top = getCellsMarginTop();
        rect.right = rect.left + this.b;
        rect.bottom = o(b);
        return rect;
    }

    protected final int d(int i) {
        v vVar = (v) this.r.get(e(i));
        return ((i - vVar.a) / this.d) + vVar.c;
    }

    protected final int b(int i, int i2) {
        int f = f(i);
        if (f < 0) {
            return -1;
        }
        v vVar = (v) this.r.get(f);
        return Math.max(vVar.a, Math.min((vVar.a + (this.d * (i - vVar.c))) + i2, vVar.b - 1));
    }

    protected final int e(int i) {
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            v vVar = (v) this.r.get(i2);
            if (i >= vVar.a && i < vVar.b) {
                return i2;
            }
        }
        return -1;
    }

    protected final int f(int i) {
        for (int i2 = 0; i2 < this.r.size(); i2++) {
            v vVar = (v) this.r.get(i2);
            if (i >= vVar.c && i < vVar.d) {
                return i2;
            }
        }
        return -1;
    }

    protected final boolean c(int i, int i2) {
        v vVar = (v) this.r.get(i);
        if (i2 + 1 < vVar.d - vVar.c) {
            return true;
        }
        for (int i3 = i + 1; i3 < this.r.size(); i3++) {
            vVar = (v) this.r.get(i3);
            if (vVar.e != null) {
                return false;
            }
            if (vVar.d - vVar.c > 0) {
                return true;
            }
        }
        return false;
    }
}
