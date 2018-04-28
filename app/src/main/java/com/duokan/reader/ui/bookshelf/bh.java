package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.ui.general.ReaderUi;
import java.util.LinkedList;
import java.util.List;

public class bh extends FrameLayout {
    /* renamed from: a */
    static final /* synthetic */ boolean f6163a = (!bh.class.desiredAssertionStatus());
    /* renamed from: b */
    private List<C0800c> f6164b = new LinkedList();
    /* renamed from: c */
    private final Drawable f6165c;
    /* renamed from: d */
    private final Drawable f6166d;
    /* renamed from: e */
    private final Drawable f6167e;
    /* renamed from: f */
    private final Drawable f6168f;
    /* renamed from: g */
    private final int[] f6169g;
    /* renamed from: h */
    private final int f6170h = Math.round(getResources().getDimension(C0253e.general__shared__cover_grid_horz_padding));
    /* renamed from: i */
    private int f6171i = -1;
    /* renamed from: j */
    private int f6172j = -1;
    /* renamed from: k */
    private bn f6173k;
    /* renamed from: l */
    private int f6174l;
    /* renamed from: m */
    private int f6175m;
    /* renamed from: n */
    private int[] f6176n;

    public bh(Context context) {
        super(context);
        setPadding(dv.m1932b(getContext(), 18.0f), 0, dv.m1932b(getContext(), 18.0f), 0);
        this.f6171i = ReaderUi.m10168d(getContext(), getResources().getDisplayMetrics().widthPixels - (this.f6170h * 2));
        this.f6172j = (int) ((((float) this.f6171i) * 349.0f) / 256.0f);
        this.f6165c = getResources().getDrawable(C0254f.bookshelf__recently_reading_left_shadow);
        this.f6166d = getResources().getDrawable(C0254f.bookshelf__recently_reading_right_shadow);
        this.f6167e = getResources().getDrawable(C0254f.bookshelf__recently_reading_begin_shadow);
        this.f6168f = getResources().getDrawable(C0254f.bookshelf__recently_reading_end_shadow);
        if (DkApp.get().forHd()) {
            this.f6169g = new int[]{3, 1, 0, 2, 4, 5};
        } else {
            this.f6169g = new int[]{1, 0, 2, 3};
        }
        setWillNotDraw(false);
    }

    /* renamed from: a */
    public void m9200a(List<C0800c> list, boolean z) {
        if (f6163a || list != null) {
            m9198b(list, z);
            return;
        }
        throw new AssertionError();
    }

    public void setOnItemClickListener(bn bnVar) {
        this.f6173k = bnVar;
    }

    protected void onMeasure(int i, int i2) {
        this.f6171i = ReaderUi.m10168d(getContext(), MeasureSpec.getSize(i) - (this.f6170h * 2));
        this.f6172j = (int) ((((float) this.f6171i) * 349.0f) / 256.0f);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.f6172j + getPaddingTop(), 1073741824));
        if (this.f6175m != getMeasuredWidth()) {
            this.f6175m = getMeasuredWidth();
            m9196b();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        int paddingLeft = i + getPaddingLeft();
        int paddingRight = i3 - getPaddingRight();
        int totalCoverWidth = getTotalCoverWidth();
        if (childCount < 2 || totalCoverWidth < paddingRight - paddingLeft) {
            i5 = 3;
            totalCoverWidth = (((paddingRight - paddingLeft) - (totalCoverWidth - ((childCount - 1) * 3))) / 2) + 1;
            paddingLeft += totalCoverWidth;
            paddingRight -= totalCoverWidth;
        } else {
            i5 = (totalCoverWidth - (paddingRight - paddingLeft)) / (childCount - 1);
        }
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View b = m9195b(paddingRight);
            b.layout(paddingLeft, i4 - b.getMeasuredHeight(), b.getMeasuredWidth() + paddingLeft, i4);
            if (i5 < 0) {
                paddingLeft += b.getMeasuredWidth();
            } else {
                paddingLeft += b.getMeasuredWidth() - i5;
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int childCount = getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            boolean z;
            if (this.f6176n[i] > this.f6176n[i + 1]) {
                z = true;
            } else {
                z = false;
            }
            m9193a(canvas, m9195b(i), m9195b(i + 1), z);
        }
        View b = m9195b(0);
        this.f6167e.setBounds(Math.max(b.getLeft() - this.f6167e.getIntrinsicWidth(), dv.m1932b(getContext(), 18.0f)), Math.max(b.getBottom() - this.f6167e.getIntrinsicHeight(), b.getTop()), b.getLeft(), b.getBottom());
        this.f6167e.draw(canvas);
        b = m9195b(childCount - 1);
        int min = Math.min(b.getRight() + this.f6168f.getIntrinsicWidth(), getResources().getDisplayMetrics().widthPixels - dv.m1932b(getContext(), 18.0f));
        this.f6168f.setBounds(b.getRight(), Math.max(b.getBottom() - this.f6168f.getIntrinsicHeight(), b.getTop()), min, b.getBottom());
        this.f6168f.draw(canvas);
    }

    public void clearAnimation() {
        super.clearAnimation();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    /* renamed from: a */
    private void m9193a(Canvas canvas, View view, View view2, boolean z) {
        int left = z ? view2.getLeft() - this.f6165c.getIntrinsicWidth() : view.getRight();
        int top = z ? view.getTop() : view2.getTop();
        int left2 = z ? view2.getLeft() : view.getRight() + this.f6166d.getIntrinsicWidth();
        int bottom = z ? view.getBottom() : view2.getBottom();
        Drawable drawable = z ? this.f6165c : this.f6166d;
        drawable.setBounds(left, top, left2, bottom);
        drawable.draw(canvas);
    }

    /* renamed from: a */
    private int m9191a(int i) {
        return getChildCount() - (this.f6176n[i] + 1);
    }

    /* renamed from: b */
    private View m9195b(int i) {
        return getChildAt(m9191a(i));
    }

    /* renamed from: a */
    private int m9190a() {
        if (DkApp.get().forHd()) {
            return DkPublic.isLandscape(getContext()) ? this.f6169g.length : this.f6169g.length - 1;
        } else {
            return this.f6169g.length;
        }
    }

    /* renamed from: c */
    private Point m9199c(int i) {
        Point point = new Point();
        point.x += Math.round(((float) this.f6171i) - ((((float) ((i + 1) / 2)) * 0.15f) * ((float) this.f6171i)));
        point.y += Math.round(((float) this.f6172j) - ((((float) ((i + 1) / 2)) * 0.15f) * ((float) this.f6172j)));
        return point;
    }

    /* renamed from: b */
    private void m9196b() {
        int i;
        removeAllViews();
        this.f6174l = Math.min(this.f6164b.size(), m9190a());
        this.f6176n = new int[this.f6174l];
        int i2 = 0;
        for (i = 0; i < this.f6169g.length; i++) {
            if (this.f6169g[i] < this.f6174l) {
                int i3 = i2 + 1;
                this.f6176n[i2] = this.f6169g[i];
                i2 = i3;
            }
        }
        for (i = 0; i < this.f6174l; i++) {
            View bmVar = new bm(this, getContext());
            bmVar.setItemData((an) this.f6164b.get(i));
            bmVar.setEnabled(isEnabled());
            Point c = m9199c(i);
            addView(bmVar, 0, new LayoutParams(c.x, c.y));
            m9194a(bmVar);
            m9197b(bmVar);
        }
    }

    /* renamed from: a */
    private void m9194a(View view) {
        view.setOnClickListener(new bi(this));
    }

    /* renamed from: b */
    private void m9197b(View view) {
        view.setOnLongClickListener(new bj(this));
    }

    private int getTotalCoverWidth() {
        int i = 0;
        int i2 = 0;
        while (i < this.f6174l) {
            i2 += m9199c(i).x;
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    private void m9198b(List<C0800c> list, boolean z) {
        this.f6164b = list;
        m9196b();
    }
}
