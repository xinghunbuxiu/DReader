package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.s;

import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ds extends FrameLayout {
    protected final FrameLayout a;
    protected int b = -1;
    private final int c;
    private final int d = UTools.closeAnimation(getContext(), 52.0f);
    private final int e = UTools.closeAnimation(getContext(), 2.0f);
    private final int f = UTools.closeAnimation(getContext(), 5.0f);
    private final int g = 14;
    private final FrameLayout h = ((FrameLayout) LayoutInflater.from(getContext()).inflate(g.surfing__immersive_surfing_view, this, false));
    private final View i;
    private final ViewGroup j;
    private final View k;
    private final cw l;
    private final View m;
    private final View n = this.h.findViewById(f.surfing__immersive_surfing_view__content);
    private final View o = this.n.findViewById(f.surfing__immersive_surfing_view__phone_content);
    private final View p = this.n.findViewById(f.surfing__immersive_surfing_view__hd_content);
    private final Drawable q;
    private final Map r = new HashMap();
    private ef s = null;

    public ds(Context context) {
        ViewGroup viewGroup;
        FrameLayout frameLayout;
        super(context);
        if (ReaderEnv.get().forHd()) {
            this.o.setVisibility(4);
            this.p.setVisibility(0);
        }
        this.h.setBackgroundDrawable(new dt(this));
        this.c = ((s) MyContextWrapper.getFeature(getContext()).queryFeature(ReaderFeature.class)).getTheme().getPageHeaderPaddingTop();
        a();
        if (ReaderEnv.get().forHd()) {
            viewGroup = (ViewGroup) this.h.findViewById(f.surfing__immersive_surfing_view__tabs_hd);
        } else {
            viewGroup = (ViewGroup) this.h.findViewById(f.surfing__immersive_surfing_view__tabs);
        }
        this.j = viewGroup;
        if (ReaderEnv.get().forHd()) {
            frameLayout = (FrameLayout) this.h.findViewById(f.surfing__immersive_surfing_view__right_hd);
        } else {
            frameLayout = (FrameLayout) this.h.findViewById(f.surfing__immersive_surfing_view__right);
        }
        this.a = frameLayout;
        this.l = new dx(this, context);
        this.l.setBackgroundColor(getResources().getColor(c.general__shared__page_background));
        this.l.setOnScrollListener(new dy(this));
        this.l.setOnFlipListener(new dz(this));
        addView(this.l, new LayoutParams(-1, -1));
        addView(this.h);
        this.i = new View(getContext());
        this.i.setBackgroundDrawable(new ea(this));
        addView(this.i, new LayoutParams(-1, this.c));
        this.q = getResources().getDrawable(e.surfing__surfing_tab_view__search);
        this.k = new View(getContext());
        this.k.setBackground(new eb(this));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 21;
        this.k.setOnClickListener(new ec(this));
        this.k.setContentDescription(getContext().getString(i.general__shared__search));
        this.a.addView(this.k, layoutParams);
        this.m = this.h.findViewById(f.surfing__immersive_surfing_view__search_bar);
        this.m.setBackgroundDrawable(new ed(this));
        this.m.setOnClickListener(new ee(this));
    }

    public int a(String str, View view) {
        View a = a(str);
        this.j.addView(a, new ViewGroup.LayoutParams(-2, -1));
        this.l.addView(view, new LayoutParams(-1, -1));
        a.setOnClickListener(new du(this, a));
        return this.j.getChildCount() - 1;
    }

    public int getCurrentPageIndex() {
        return this.b;
    }

    public void a(int i, boolean z) {
        if ((this.b != i || z) && i >= 0 && i < this.l.getChildCount()) {
            UTools.a(this.l, new UTools(this, i));
        }
    }

    public void a(int i) {
        a(i, null);
    }

    public void a(int i, Runnable runnable) {
        if (this.b == i) {
            TaskHandler.PostTask(runnable);
        } else if (i >= 0 && i < this.l.getChildCount()) {
            this.l.a(i, runnable, null);
        }
    }

    public void b(int i) {
        if (i >= 0 && i < this.l.getChildCount()) {
            this.j.getChildAt(i).setVisibility(8);
            this.l.getChildAt(i).setVisibility(8);
        }
    }

    public void c(int i) {
        if (i >= 0 && i < this.l.getChildCount()) {
            this.j.getChildAt(i).setVisibility(0);
            this.l.getChildAt(i).setVisibility(0);
        }
    }

    public void a() {
        int j;
        if (ReaderEnv.get().forHd() && DkPublic.isLandscape(getContext())) {
            j = (int) (((float) UTools.getWidthPixels(getContext())) * 0.1f);
        } else {
            j = 0;
        }
        this.h.setPadding(j, this.c, j, 0);
    }

    public void setOnCurrentPageChangedListener(ef efVar) {
        this.s = efVar;
    }

    public Map getVisibleViewIndexMap() {
        return this.r;
    }

    protected boolean b() {
        return true;
    }

    protected float c() {
        return 1.0f;
    }

    private void e() {
        this.r.clear();
        for (int i = 0; i < this.l.getChildCount(); i++) {
            Rect rect = (Rect) UTools.g.getRect();
            View childAt = this.l.getChildAt(i);
            if (childAt.getVisibility() != 0) {
                this.r.put(Integer.valueOf(i), Float.valueOf(0.0f));
            } else {
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.width() == 0 || rect.right <= this.l.getViewportBounds().left || rect.left >= this.l.getViewportBounds().right) {
                    this.r.put(Integer.valueOf(i), Float.valueOf(0.0f));
                } else if (rect.left < this.l.getViewportBounds().left) {
                    this.r.put(Integer.valueOf(i), Float.valueOf(((float) (rect.right - this.l.getViewportBounds().left)) / ((float) rect.width())));
                } else if (rect.right > this.l.getViewportBounds().right) {
                    this.r.put(Integer.valueOf(i), Float.valueOf(((float) (this.l.getViewportBounds().right - rect.left)) / ((float) rect.width())));
                } else {
                    this.r.put(Integer.valueOf(i), Float.valueOf(1.0f));
                    UTools.g.getRect(rect);
                }
            }
        }
    }

    private void a(Canvas canvas) {
        float c = c();
        canvas.drawColor(Color.argb((int) (255.0f * c), 255, 255, 255));
        if (getVisibleList().size() <= 1) {
            this.n.setVisibility(4);
            this.m.setVisibility(0);
            this.m.invalidate();
            return;
        }
        this.n.setVisibility(0);
        this.m.setVisibility(4);
        this.k.invalidate();
        for (int i = 0; i < this.l.getChildCount(); i++) {
            if (this.j.getChildAt(i) instanceof TextView) {
                float floatValue = ((Float) this.r.get(Integer.valueOf(i))).floatValue();
                ((TextView) this.j.getChildAt(i)).setTextColor(Color.rgb(a(255, (int) HttpStatus.SC_PROCESSING, floatValue, c), a(132, (int) HttpStatus.SC_PROCESSING, floatValue, c), a(0, (int) HttpStatus.SC_PROCESSING, floatValue, c)));
            }
        }
        a(canvas, c);
    }

    private void a(Canvas canvas, float f) {
        List visibleList = getVisibleList();
        if (visibleList.size() != 0 && this.b >= 0) {
            int right = this.l.getChildAt(((Integer) visibleList.get(0)).intValue()).getRight();
            int contentWidth = this.l.getContentWidth();
            float f2 = (((float) this.l.getViewportBounds().right) * (1.0f / ((float) (contentWidth - right)))) + (((float) right) / ((float) (right - contentWidth)));
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.general_font__shared__c);
            int i = dimensionPixelSize * 2;
            View childAt = this.j.getChildAt(((Integer) visibleList.get(0)).intValue());
            Rect rect = (Rect) UTools.g.getRect();
            childAt.getGlobalVisibleRect(rect);
            int width = (rect.right - (childAt.getWidth() / 2)) + (i / 2);
            View childAt2 = this.j.getChildAt(((Integer) visibleList.get(visibleList.size() - 1)).intValue());
            childAt2.getGlobalVisibleRect(rect);
            contentWidth = (int) ((((float) (((rect.right - (childAt2.getWidth() / 2)) + (i / 2)) - width)) * f2) + ((float) width));
            Paint paint = new Paint();
            float floatValue = ((Float) this.r.get(Integer.valueOf(this.b))).floatValue();
            if (((double) floatValue) < 0.5d) {
                floatValue = 1.0f - floatValue;
            }
            paint.setColor(Color.rgb(a(255, (int) HttpStatus.SC_PROCESSING, floatValue, f), a(132, (int) HttpStatus.SC_PROCESSING, floatValue, f), a(0, (int) HttpStatus.SC_PROCESSING, floatValue, f)));
            dimensionPixelSize = this.h.getPaddingTop() + (((childAt.getTop() + childAt.getPaddingTop()) + dimensionPixelSize) + this.f);
            RectF rectF = (RectF) UTools.h.getRect();
            rectF.set((float) (contentWidth - i), (float) dimensionPixelSize, (float) contentWidth, (float) (dimensionPixelSize + this.e));
            canvas.drawRoundRect(rectF, (float) (this.e / 2), (float) (this.e / 2), paint);
            UTools.h.getRect(rectF);
            UTools.g.getRect(rect);
        }
    }

    private void a(Canvas canvas, View view) {
        float c = c();
        int rgb = Color.rgb(a(255, 180, c), a(255, 180, c), a(255, 180, c));
        int i = (int) (((c + 1.0f) / 2.0f) * 255.0f);
        int i2 = (int) (c * 255.0f);
        RectF rectF = (RectF) UTools.h.getRect();
        rectF.set((float) view.getPaddingLeft(), (float) view.getPaddingTop(), (float) (view.getWidth() - view.getPaddingRight()), (float) (view.getHeight() - view.getPaddingBottom()));
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#fafafa"));
        paint.setAntiAlias(true);
        paint.setAlpha(i);
        canvas.drawRoundRect(rectF, (float) UTools.closeAnimation(getContext(), 5.0f), (float) UTools.closeAnimation(getContext(), 5.0f), paint);
        paint.setColor(Color.parseColor("#cccccc"));
        paint.setStrokeWidth(1.0f);
        paint.setAlpha(i2);
        paint.setStyle(Style.STROKE);
        canvas.drawRoundRect(rectF, (float) UTools.closeAnimation(getContext(), 5.0f), (float) UTools.closeAnimation(getContext(), 5.0f), paint);
        i2 = (int) (rectF.left + ((float) UTools.closeAnimation(getContext(), 8.0f)));
        int intrinsicWidth = this.q.getIntrinsicWidth() + i2;
        int max = (int) Math.max(rectF.top, rectF.centerY() - ((float) (this.q.getIntrinsicHeight() / 2)));
        int min = (int) Math.min(rectF.bottom, (float) (this.q.getIntrinsicHeight() + max));
        Drawable colorDrawable = new ColorDrawable(rgb);
        colorDrawable.setAlpha(i);
        es esVar = new es(colorDrawable);
        esVar.a(this.q);
        esVar.setBounds(i2, max, intrinsicWidth, min);
        esVar.draw(canvas);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setTextSize((float) UTools.addAnimation(getContext(), 12.0f));
        paint2.setColor(rgb);
        paint2.setAlpha(i);
        RectF rectF2 = (RectF) UTools.h.getRect();
        rectF2.set((float) (UTools.closeAnimation(getContext(), 8.0f) + intrinsicWidth), rectF.top, rectF.right, rectF.bottom);
        UTools.addAnimation(canvas, getResources().getString(i.bookshelf__shared__search), rectF2, 19, paint2);
        UTools.h.getRect(rectF2);
        UTools.h.getRect(rectF);
    }

    private int a(int i, int i2, float f, float f2) {
        return a(255, a(i2, i, f), f2);
    }

    private int a(int i, int i2, float f) {
        return Math.min(255, (int) (((float) i) + (((float) (i2 - i)) * f)));
    }

    private int a(TextView textView) {
        return this.j.indexOfChild(textView);
    }

    private void d(int i) {
        if (this.b != i) {
            int i2 = this.b;
            this.b = i;
            if (this.s != null) {
                this.s.a(i2, this.b);
            }
        }
    }

    private TextView a(String str) {
        TextView dwVar = new dw(this, getContext());
        dwVar.setText(str);
        dwVar.setGravity(1);
        dwVar.setSingleLine(true);
        dwVar.setEllipsize(TruncateAt.END);
        dwVar.setIncludeFontPadding(false);
        dwVar.setTextSize(14.0f);
        return dwVar;
    }

    private int getTabTextHeight() {
        return (UTools.addAnimation(getContext(), 14.0f) + this.e) + this.f;
    }

    public View getTabView() {
        return this.h;
    }

    public List getVisibleList() {
        List arrayList = new ArrayList();
        for (int i = 0; i < this.l.getChildCount(); i++) {
            if (this.l.getChildAt(i).getVisibility() == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public View getStatusView() {
        return this.i;
    }

    public void d() {
        this.b = -1;
        this.r.clear();
        this.l.g();
        this.j.removeAllViews();
    }
}
