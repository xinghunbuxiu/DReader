package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

import java.util.ArrayList;

public class GridItemsView extends ay {
    /* renamed from: a */
    static final /* synthetic */ boolean f790a = (!GridItemsView.class.desiredAssertionStatus());
    /* renamed from: b */
    private int f791b;
    /* renamed from: d */
    private int f792d;
    /* renamed from: e */
    private int f793e;
    /* renamed from: f */
    private int f794f;
    /* renamed from: g */
    private int f795g;
    /* renamed from: h */
    private int f796h;
    /* renamed from: i */
    private int f797i;
    /* renamed from: j */
    private Drawable f798j;
    /* renamed from: k */
    private Drawable f799k;
    /* renamed from: l */
    private int f800l;
    /* renamed from: m */
    private Drawable f801m;
    /* renamed from: n */
    private int f802n;
    /* renamed from: o */
    private int f803o;
    /* renamed from: p */
    private int f804p;
    /* renamed from: q */
    private int f805q;
    /* renamed from: r */
    private ArrayList<C0396v> f806r;

    public GridItemsView(Context context) {
        this(context, null);
    }

    public GridItemsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f791b = 0;
        this.f792d = 0;
        this.f793e = 0;
        this.f794f = 0;
        this.f795g = 0;
        this.f796h = 0;
        this.f797i = 0;
        this.f798j = null;
        this.f799k = null;
        this.f800l = 0;
        this.f801m = null;
        this.f802n = 0;
        this.f803o = 0;
        this.f804p = 0;
        this.f805q = 2;
        this.f806r = new ArrayList(1);
        setClipToPadding(false);
    }

    public final int getStretchMode() {
        return this.f805q;
    }

    public final void setStretchMode(int i) {
        if (this.f805q != i) {
            this.f805q = i;
            m1147i();
        }
    }

    public final int getDesiredColumnWidth() {
        return this.f796h;
    }

    public final void setDesiredColumnWidth(int i) {
        if (this.f796h != i) {
            this.f796h = i;
            m1147i();
        }
    }

    public final int getNumColumns() {
        return this.f795g;
    }

    public final void setNumColumns(int i) {
        if (this.f795g != i) {
            this.f795g = i;
            m1147i();
        }
    }

    public final int getColumnCount() {
        m1155l();
        return this.f792d;
    }

    public final Drawable getColumnDivider() {
        return this.f801m;
    }

    public final void setColumnDivider(Drawable drawable) {
        m1172a(drawable, false);
    }

    /* renamed from: a */
    public final void m1172a(Drawable drawable, boolean z) {
        if (this.f801m != drawable) {
            this.f801m = drawable;
            if (!z) {
                setDesiredColumnSpacing(this.f801m == null ? 0 : this.f801m.getIntrinsicWidth());
            }
        }
    }

    public final int getDesiredColumnSpacing() {
        return this.f802n;
    }

    public final void setDesiredColumnSpacing(int i) {
        if (this.f802n != i) {
            this.f802n = i;
            m1147i();
        }
    }

    public final int getRowCount() {
        m1155l();
        return this.f794f;
    }

    public final Drawable getRowBackground() {
        return this.f798j;
    }

    public final void setRowBackground(int i) {
        setRowBackground(getResources().getDrawable(i));
    }

    public final void setRowBackground(Drawable drawable) {
        this.f798j = drawable;
        invalidate();
    }

    public final Drawable getRowDivider() {
        return this.f799k;
    }

    public final void setRowDivider(int i) {
        setRowDivider(getResources().getDrawable(i));
    }

    public final void setRowDivider(Drawable drawable) {
        m1178b(drawable, false);
    }

    /* renamed from: b */
    public final void m1178b(Drawable drawable, boolean z) {
        if (this.f799k != drawable) {
            this.f799k = drawable;
            if (!z) {
                setRowSpacing(this.f799k == null ? 0 : this.f799k.getIntrinsicHeight());
            }
        }
    }

    public final int getRowSpacing() {
        return this.f800l;
    }

    public final void setRowSpacing(int i) {
        if (this.f800l != i) {
            this.f800l = i;
            m1147i();
        }
    }

    public final int getGroupCount() {
        return this.f804p;
    }

    /* renamed from: a */
    public final int mo445a(int i) {
        C0396v c0396v = (C0396v) this.f806r.get(i);
        return c0396v.f1339b - c0396v.f1338a;
    }

    /* renamed from: a */
    public final void m1170a(int i, Rect rect, int i2) {
        if (!rect.isEmpty() && rect.width() != 0 && rect.height() != 0 && i >= 0 && this.f806r.size() > i) {
            Rect c = m1179c(i);
            Rect rect2 = (Rect) dv.f1198g.addAnimation();
            Gravity.apply(i2, c.width(), c.height(), m1130c(rect), rect2);
            scrollBy(c.left - rect2.left, c.top - rect2.top);
            dv.f1198g.clearAnimation(rect2);
            m1138e();
        }
    }

    /* renamed from: b */
    public final void mo451b(int i) {
        if (!getViewportBounds().isEmpty() && getContentWidth() != 0 && getContentHeight() != 0 && i >= 0 && this.f806r.size() > i) {
            Rect c = m1179c(i);
            scrollTo(c.left, c.top);
            m1138e();
        }
    }

    /* renamed from: c */
    public Rect m1179c(int i) {
        View view = ((C0396v) this.f806r.get(i)).f1342e;
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* renamed from: a */
    protected int mo447a(Point point) {
        int i = 0;
        int i2 = 0;
        while (i2 < this.f794f) {
            int b = m1174b(i2, 0);
            if (!f790a && b < 0) {
                throw new AssertionError();
            } else if (m1160o(b) <= point.y) {
                i2++;
            } else {
                if (m1156m(b) <= point.y) {
                    while (i < this.f792d) {
                        b = m1174b(i2, i);
                        if (m1118a(b, point)) {
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

    /* renamed from: a */
    protected int[] mo450a(Rect rect) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (i3 < this.f794f) {
            int b = m1174b(i3, 0);
            if (f790a || b >= 0) {
                if (m1133c(b, rect)) {
                    if (i2 < 0) {
                        i2 = b;
                    }
                    i = m1174b(i3, this.f792d - 1);
                    if (!f790a && i < 0) {
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

    /* renamed from: a */
    protected void mo449a(Canvas canvas) {
        super.mo449a(canvas);
        Rect rect = (Rect) dv.f1198g.addAnimation();
        if (this.f798j != null) {
            int[] m = m1157m();
            if (m.length > 0) {
                int d = mo453d(m[m.length - 1]);
                for (int d2 = mo453d(m[0]); d2 <= d; d2++) {
                    m1168a(d2, rect);
                    this.f798j.setLevel(d2);
                    this.f798j.setBounds(rect);
                    this.f798j.draw(canvas);
                }
            }
        }
        dv.f1198g.clearAnimation(rect);
    }

    /* renamed from: b */
    protected void mo452b(Canvas canvas) {
        int d;
        int d2;
        int i;
        int f;
        super.mo452b(canvas);
        Rect rect = (Rect) dv.f1198g.addAnimation();
        Rect rect2 = (Rect) dv.f1198g.addAnimation();
        if (this.f799k != null) {
            int[] m = m1157m();
            if (m.length > 0) {
                d = mo453d(m[0]);
                d2 = mo453d(m[m.length - 1]);
                for (i = d; i <= d2; i++) {
                    f = m1183f(i);
                    if (m1180c(f, i - ((C0396v) this.f806r.get(f)).f1340c)) {
                        m1168a(i, rect);
                        m1168a(i + 1, rect2);
                        if (!Rect.intersects(rect, getViewportBounds()) || !Rect.intersects(rect2, getViewportBounds())) {
                            break;
                        }
                        d = ((rect2.top + rect.bottom) - this.f799k.getIntrinsicHeight()) / 2;
                        this.f799k.setBounds(rect.left, d, rect.right, this.f799k.getIntrinsicHeight() + d);
                        this.f799k.draw(canvas);
                    }
                }
            }
        }
        if (this.f801m != null) {
            for (i = 0; i < this.f806r.size(); i++) {
                C0396v c0396v = (C0396v) this.f806r.get(i);
                if (c0396v.f1341d - c0396v.f1340c >= 1) {
                    m1168a(c0396v.f1340c, rect);
                    m1168a(c0396v.f1341d - 1, rect2);
                    d2 = rect.top;
                    f = rect2.bottom;
                    for (d = 0; d < this.f792d - 1; d++) {
                        m1175b(d, rect);
                        m1175b(d + 1, rect2);
                        if (!Rect.intersects(rect, getViewportBounds()) || !Rect.intersects(rect2, getViewportBounds())) {
                            break;
                        }
                        int intrinsicWidth = ((rect2.left + rect.right) - this.f801m.getIntrinsicWidth()) / 2;
                        this.f801m.setBounds(intrinsicWidth, d2, this.f801m.getIntrinsicWidth() + intrinsicWidth, f);
                        this.f801m.draw(canvas);
                    }
                }
            }
        }
        dv.f1198g.clearAnimation(rect2);
        dv.f1198g.clearAnimation(rect);
    }

    /* renamed from: a */
    protected void mo448a() {
        int cellsMarginLeft = getCellsMarginLeft();
        int cellsMarginTop = getCellsMarginTop();
        for (int i = 0; i < this.f806r.size(); i++) {
            C0396v c0396v = (C0396v) this.f806r.get(i);
            if (c0396v.f1342e != null) {
                be beVar = (be) c0396v.f1342e.getLayoutParams();
                int i2 = beVar.leftMargin + cellsMarginLeft;
                int i3 = beVar.topMargin + cellsMarginTop;
                c0396v.f1342e.layout(i2, i3, c0396v.f1342e.getMeasuredWidth() + i2, c0396v.f1342e.getMeasuredHeight() + i3);
                cellsMarginTop = (c0396v.f1342e.getMeasuredHeight() + i3) + beVar.bottomMargin;
            }
            for (int i4 = 0; i4 < c0396v.f1341d - c0396v.f1340c; i4++) {
                int i5 = 0;
                int i6 = 0;
                while (i5 < this.f792d) {
                    i3 = (c0396v.f1338a + (this.f792d * i4)) + i5;
                    if (i3 >= c0396v.f1339b) {
                        break;
                    }
                    if (m1162q(i3) < 0) {
                        m1146h(i3, MeasureSpec.makeMeasureSpec(this.f791b, 1073741824));
                        m1149i(i3, MeasureSpec.makeMeasureSpec(0, 0));
                    }
                    i2 = m1162q(i3);
                    if (i2 < 0) {
                        i2 = m1160o(i3) - m1156m(i3);
                        if (i2 < 0) {
                            i2 = this.f797i;
                        }
                    }
                    i5++;
                    i6 = Math.max(i6, i2);
                }
                i3 = cellsMarginLeft;
                for (int i7 = 0; i7 < this.f792d; i7++) {
                    i2 = (c0396v.f1338a + (this.f792d * i4)) + i7;
                    if (i2 >= c0396v.f1339b) {
                        break;
                    }
                    int i8 = i3 + this.f791b;
                    int i9 = cellsMarginTop + i6;
                    m1146h(i2, MeasureSpec.makeMeasureSpec(this.f791b, 1073741824));
                    if (m1162q(i2) >= 0) {
                        m1149i(i2, MeasureSpec.makeMeasureSpec(i6, 1073741824));
                    }
                    m1112a(i2, i3, cellsMarginTop, i8, i9);
                    i3 = i8 + this.f803o;
                }
                cellsMarginTop += i6;
                if (m1180c(i, i4)) {
                    cellsMarginTop += this.f800l;
                }
            }
        }
        m1143g(this.f793e + getCellsMarginHorizontal(), getCellsMarginBottom() + cellsMarginTop);
    }

    /* renamed from: a */
    protected int mo446a(int i, int i2) {
        int size;
        C0396v c0396v;
        int i3;
        int p;
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i);
        int cellsMarginHorizontal = getCellsMarginHorizontal();
        int cellsMarginVertical = getCellsMarginVertical();
        int itemCount = getItemCount();
        int i4 = this.f791b;
        this.f804p = getAdapter() instanceof C0375w ? ((C0375w) getAdapter()).mo486a() : 0;
        if (this.f804p < 1) {
            for (size = this.f806r.size() - 1; size >= 0; size--) {
                c0396v = (C0396v) this.f806r.get(size);
                if (c0396v.f1342e != null) {
                    removeViewInLayout(c0396v.f1342e);
                }
                this.f806r.remove(size);
            }
            c0396v = new C0396v();
            c0396v.f1338a = 0;
            c0396v.f1339b = c0396v.f1338a + itemCount;
            c0396v.f1342e = null;
            this.f806r.add(c0396v);
        } else {
            C0375w c0375w = (C0375w) getAdapter();
            this.f806r.ensureCapacity(this.f804p);
            for (i3 = 0; i3 < this.f804p; i3++) {
                C0396v c0396v2;
                if (i3 < this.f806r.size()) {
                    c0396v2 = (C0396v) this.f806r.get(i3);
                } else {
                    C0396v c0396v3 = new C0396v();
                    this.f806r.add(c0396v3);
                    c0396v2 = c0396v3;
                }
                if (i3 < 1) {
                    size = 0;
                } else {
                    size = ((C0396v) this.f806r.get(i3 - 1)).f1339b;
                }
                c0396v2.f1338a = size;
                c0396v2.f1339b = c0396v2.f1338a + c0375w.mo487a(i3);
                View view = c0396v2.f1342e;
                c0396v2.f1342e = c0375w.mo488a(i3, view, this);
                if (c0396v2.f1342e != view) {
                    if (view != null) {
                        removeViewInLayout(view);
                    }
                    if (c0396v2.f1342e != null) {
                        LayoutParams g;
                        if (c0396v2.f1342e.getLayoutParams() == null) {
                            g = m1142g();
                        } else if (c0396v2.f1342e.getLayoutParams() instanceof be) {
                            be g2 = (be) c0396v2.f1342e.getLayoutParams();
                        } else {
                            g2 = m1107a(c0396v2.f1342e.getLayoutParams());
                        }
                        addViewInLayout(c0396v2.f1342e, -1, g2);
                    }
                }
            }
            for (size = this.f806r.size() - 1; size >= this.f804p; size--) {
                c0396v = (C0396v) this.f806r.get(size);
                if (c0396v.f1342e != null) {
                    removeViewInLayout(c0396v.f1342e);
                }
                this.f806r.remove(size);
            }
        }
        if (itemCount > 0) {
            m1146h(0, MeasureSpec.makeMeasureSpec(0, 0));
            m1149i(0, MeasureSpec.makeMeasureSpec(0, 0));
            m1153k(0);
            p = mode == 0 ? m1161p(0) : Math.min(m1161p(0), size2 - cellsMarginHorizontal);
            i3 = m1162q(0);
        } else {
            i3 = 0;
            p = 0;
        }
        if (this.f805q == 1) {
            if (this.f796h > 0) {
                p = this.f796h;
            }
            if (this.f795g > 0) {
                itemCount = this.f795g;
            } else if (mode == 0) {
                itemCount = 1;
            } else {
                itemCount = this.f802n + p > 0 ? ((size2 - cellsMarginHorizontal) + this.f802n) / (this.f802n + p) : itemCount;
            }
            int i5;
            if (mode == 0) {
                size = this.f802n;
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
            if (this.f795g > 0) {
                size = this.f795g;
            } else if (mode == 0) {
                size = 1;
            } else if (this.f796h > 0) {
                if (this.f796h + this.f802n > 0) {
                    itemCount = ((size2 - cellsMarginHorizontal) + this.f802n) / (this.f796h + this.f802n);
                }
                size = Math.max(1, itemCount);
            } else {
                if (this.f802n + p > 0) {
                    itemCount = ((size2 - cellsMarginHorizontal) + this.f802n) / (this.f802n + p);
                }
                size = Math.max(1, itemCount);
            }
            if (f790a || size > 0) {
                if (mode != 0) {
                    p = (((size2 - cellsMarginHorizontal) + this.f802n) / size) - this.f802n;
                } else if (this.f796h > 0) {
                    p = this.f796h;
                }
                itemCount = p;
                p = size;
                size = this.f802n;
            } else {
                throw new AssertionError();
            }
        }
        this.f792d = p;
        if (size < 0) {
            this.f791b = this.f793e / p;
            this.f803o = 0;
        } else {
            this.f791b = itemCount;
            this.f803o = size;
        }
        this.f794f = 0;
        for (size = 0; size < this.f806r.size(); size++) {
            c0396v = (C0396v) this.f806r.get(size);
            int i6 = (((c0396v.f1339b - c0396v.f1338a) + this.f792d) - 1) / this.f792d;
            c0396v.f1340c = this.f794f;
            c0396v.f1341d = c0396v.f1340c + i6;
            this.f794f += i6;
        }
        this.f793e = (this.f791b * this.f792d) + (this.f803o * (this.f792d - 1));
        if (getItemCount() > 0) {
            m1146h(0, MeasureSpec.makeMeasureSpec(itemCount, 1073741824));
            m1149i(0, MeasureSpec.makeMeasureSpec(0, 0));
            m1153k(0);
            this.f797i = m1162q(0);
        } else {
            this.f797i = i3;
        }
        itemCount = 0;
        while (itemCount < this.f806r.size()) {
            c0396v = (C0396v) this.f806r.get(itemCount);
            mode = c0396v.f1341d - c0396v.f1340c;
            if (c0396v.f1342e != null) {
                g2 = (be) c0396v.f1342e.getLayoutParams();
                View view2 = c0396v.f1342e;
                cellsMarginHorizontal = MeasureSpec.makeMeasureSpec((this.f793e - g2.leftMargin) - g2.rightMargin, 1073741824);
                if (g2.height > 0) {
                    i6 = MeasureSpec.makeMeasureSpec(g2.height, 1073741824);
                } else {
                    i6 = MeasureSpec.makeMeasureSpec(0, 0);
                }
                view2.measure(cellsMarginHorizontal, i6);
                size = cellsMarginVertical + ((c0396v.f1342e.getMeasuredHeight() + g2.topMargin) + g2.bottomMargin);
            } else {
                size = cellsMarginVertical;
            }
            if (mode > 0) {
                size += (i3 * mode) + (this.f800l * (mode - 1));
                if (m1180c(itemCount, mode - 1)) {
                    size += this.f800l;
                }
            }
            itemCount++;
            cellsMarginVertical = size;
        }
        m1143g(this.f793e + getCellsMarginHorizontal(), cellsMarginVertical);
        if (getItemCount() >= 1 || this.f804p >= 1) {
            return this.f791b != i4 ? 1 : 0;
        } else {
            return -1;
        }
    }

    /* renamed from: a */
    protected final Rect m1168a(int i, Rect rect) {
        int b = m1174b(i, 0);
        rect.left = m1154l(b);
        rect.top = m1156m(b);
        rect.right = rect.left + this.f793e;
        rect.bottom = m1160o(b);
        return rect;
    }

    /* renamed from: b */
    protected final Rect m1175b(int i, Rect rect) {
        int b = m1174b(this.f794f - 1, 0);
        rect.left = getCellsMarginLeft() + ((this.f791b + this.f803o) * i);
        rect.top = getCellsMarginTop();
        rect.right = rect.left + this.f791b;
        rect.bottom = m1160o(b);
        return rect;
    }

    /* renamed from: d */
    protected final int mo453d(int i) {
        C0396v c0396v = (C0396v) this.f806r.get(mo454e(i));
        return ((i - c0396v.f1338a) / this.f792d) + c0396v.f1340c;
    }

    /* renamed from: b */
    protected final int m1174b(int i, int i2) {
        int f = m1183f(i);
        if (f < 0) {
            return -1;
        }
        C0396v c0396v = (C0396v) this.f806r.get(f);
        return Math.max(c0396v.f1338a, Math.min((c0396v.f1338a + (this.f792d * (i - c0396v.f1340c))) + i2, c0396v.f1339b - 1));
    }

    /* renamed from: e */
    protected final int mo454e(int i) {
        for (int i2 = 0; i2 < this.f806r.size(); i2++) {
            C0396v c0396v = (C0396v) this.f806r.get(i2);
            if (i >= c0396v.f1338a && i < c0396v.f1339b) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: f */
    protected final int m1183f(int i) {
        for (int i2 = 0; i2 < this.f806r.size(); i2++) {
            C0396v c0396v = (C0396v) this.f806r.get(i2);
            if (i >= c0396v.f1340c && i < c0396v.f1341d) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    protected final boolean m1180c(int i, int i2) {
        C0396v c0396v = (C0396v) this.f806r.get(i);
        if (i2 + 1 < c0396v.f1341d - c0396v.f1340c) {
            return true;
        }
        for (int i3 = i + 1; i3 < this.f806r.size(); i3++) {
            c0396v = (C0396v) this.f806r.get(i3);
            if (c0396v.f1342e != null) {
                return false;
            }
            if (c0396v.f1341d - c0396v.f1340c > 0) {
                return true;
            }
        }
        return false;
    }
}
