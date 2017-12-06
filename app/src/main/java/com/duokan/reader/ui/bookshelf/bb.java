package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.ui.UTools;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.ui.general.ReaderUi;

import java.util.LinkedList;
import java.util.List;

public class bb extends FrameLayout {
    static final /* synthetic */ boolean a = (!bb.class.desiredAssertionStatus());
    private List b = new LinkedList();
    private final Drawable c;
    private final Drawable d;
    private final Drawable e;
    private final Drawable f;
    private final int[] g;
    private final int h = Math.round(getResources().getDimension(e.general__shared__cover_grid_horz_padding));
    private int i = -1;
    private int j = -1;
    private bh k;
    private int l;
    private int m;
    private int[] n;

    public bb(Context context) {
        super(context);
        setPadding(UTools.getMinimumHeight(getContext(), 18.0f), 0, UTools.getMinimumHeight(getContext(), 18.0f), 0);
        this.i = ReaderUi.d(getContext(), getResources().getDisplayMetrics().widthPixels - (this.h * 2));
        this.j = (int) ((((float) this.i) * 349.0f) / 256.0f);
        this.c = getResources().getDrawable(f.bookshelf__recently_reading_left_shadow);
        this.d = getResources().getDrawable(f.bookshelf__recently_reading_right_shadow);
        this.e = getResources().getDrawable(f.bookshelf__recently_reading_begin_shadow);
        this.f = getResources().getDrawable(f.bookshelf__recently_reading_end_shadow);
        if (DkApp.get().forHd()) {
            this.g = new int[]{3, 1, 0, 2, 4, 5};
        } else {
            this.g = new int[]{1, 0, 2, 3};
        }
        setWillNotDraw(false);
    }

    public void a(List list, boolean z) {
        if (a || list != null) {
            b(list, z);
            return;
        }
        throw new AssertionError();
    }

    public void setOnItemClickListener(bh bhVar) {
        this.k = bhVar;
    }

    protected void onMeasure(int i, int i2) {
        this.i = ReaderUi.d(getContext(), MeasureSpec.getSize(i) - (this.h * 2));
        this.j = (int) ((((float) this.i) * 349.0f) / 256.0f);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.j + getPaddingTop(), 1073741824));
        if (this.m != getMeasuredWidth()) {
            this.m = getMeasuredWidth();
            b();
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
            View b = b(paddingRight);
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
            if (this.n[i] > this.n[i + 1]) {
                z = true;
            } else {
                z = false;
            }
            a(canvas, b(i), b(i + 1), z);
        }
        View b = b(0);
        this.e.setBounds(Math.max(b.getLeft() - this.e.getIntrinsicWidth(), UTools.getMinimumHeight(getContext(), 18.0f)), Math.max(b.getBottom() - this.e.getIntrinsicHeight(), b.getTop()), b.getLeft(), b.getBottom());
        this.e.draw(canvas);
        b = b(childCount - 1);
        int min = Math.min(b.getRight() + this.f.getIntrinsicWidth(), getResources().getDisplayMetrics().widthPixels - UTools.getMinimumHeight(getContext(), 18.0f));
        this.f.setBounds(b.getRight(), Math.max(b.getBottom() - this.f.getIntrinsicHeight(), b.getTop()), min, b.getBottom());
        this.f.draw(canvas);
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

    private void a(Canvas canvas, View view, View view2, boolean z) {
        int left = z ? view2.getLeft() - this.c.getIntrinsicWidth() : view.getRight();
        int top = z ? view.getTop() : view2.getTop();
        int left2 = z ? view2.getLeft() : view.getRight() + this.d.getIntrinsicWidth();
        int bottom = z ? view.getBottom() : view2.getBottom();
        Drawable drawable = z ? this.c : this.d;
        drawable.setBounds(left, top, left2, bottom);
        drawable.draw(canvas);
    }

    private int a(int i) {
        return getChildCount() - (this.n[i] + 1);
    }

    private View b(int i) {
        return getChildAt(a(i));
    }

    private int a() {
        if (DkApp.get().forHd()) {
            return DkPublic.isLandscape(getContext()) ? this.g.length : this.g.length - 1;
        } else {
            return this.g.length;
        }
    }

    private Point c(int i) {
        Point point = new Point();
        point.x += Math.round(((float) this.i) - ((((float) ((i + 1) / 2)) * 0.15f) * ((float) this.i)));
        point.y += Math.round(((float) this.j) - ((((float) ((i + 1) / 2)) * 0.15f) * ((float) this.j)));
        return point;
    }

    private void b() {
        int i;
        removeAllViews();
        this.l = Math.min(this.b.size(), a());
        this.n = new int[this.l];
        int i2 = 0;
        for (i = 0; i < this.g.length; i++) {
            if (this.g[i] < this.l) {
                int i3 = i2 + 1;
                this.n[i2] = this.g[i];
                i2 = i3;
            }
        }
        for (i = 0; i < this.l; i++) {
            View bgVar = new bg(this, getContext());
            bgVar.setItemData((an) this.b.get(i));
            bgVar.setEnabled(isEnabled());
            Point c = c(i);
            addView(bgVar, 0, new LayoutParams(c.x, c.y));
            a(bgVar);
            b(bgVar);
        }
    }

    private void a(View view) {
        view.setOnClickListener(new bc(this));
    }

    private void b(View view) {
        view.setOnLongClickListener(new bd(this));
    }

    private int getTotalCoverWidth() {
        int i = 0;
        int i2 = 0;
        while (i < this.l) {
            i2 += c(i).x;
            i++;
        }
        return i2;
    }

    private void b(List list, boolean z) {
        this.b = list;
        b();
    }
}
