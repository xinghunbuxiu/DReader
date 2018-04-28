package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0242d;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.ui.C0435s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;

public class dr extends FrameLayout {
    /* renamed from: a */
    protected final FrameLayout f7103a;
    /* renamed from: b */
    protected int f7104b = -1;
    /* renamed from: c */
    private final int f7105c;
    /* renamed from: d */
    private final int f7106d;
    /* renamed from: e */
    private final int f7107e;
    /* renamed from: f */
    private final int f7108f = 14;
    /* renamed from: g */
    private final int f7109g = dv.m1932b(getContext(), 29.0f);
    /* renamed from: h */
    private final FrameLayout f7110h;
    /* renamed from: i */
    private final View f7111i;
    /* renamed from: j */
    private final ViewGroup f7112j;
    /* renamed from: k */
    private final View f7113k;
    /* renamed from: l */
    private final cw f7114l;
    /* renamed from: m */
    private final View f7115m;
    /* renamed from: n */
    private final View f7116n;
    /* renamed from: o */
    private final View f7117o;
    /* renamed from: p */
    private final View f7118p;
    /* renamed from: q */
    private final Map<Integer, Float> f7119q = new HashMap();
    /* renamed from: r */
    private ee f7120r = null;

    public dr(Context context) {
        ViewGroup viewGroup;
        FrameLayout frameLayout;
        super(context);
        int pageHeaderHeight = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderHeight();
        this.f7106d = dv.m1932b(getContext(), 2.0f);
        this.f7107e = dv.m1932b(getContext(), 8.0f);
        this.f7110h = (FrameLayout) LayoutInflater.from(getContext()).inflate(C0245g.surfing__immersive_surfing_view, this, false);
        this.f7110h.setLayoutParams(new LayoutParams(-1, pageHeaderHeight));
        this.f7116n = this.f7110h.findViewById(C0244f.surfing__immersive_surfing_view__content);
        this.f7117o = this.f7116n.findViewById(C0244f.surfing__immersive_surfing_view__phone_content);
        this.f7118p = this.f7116n.findViewById(C0244f.surfing__immersive_surfing_view__hd_content);
        if (ReaderEnv.get().forHd()) {
            this.f7117o.setVisibility(4);
            this.f7118p.setVisibility(0);
        }
        this.f7110h.setBackgroundDrawable(new ds(this));
        this.f7105c = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(ReaderFeature.class)).getTheme().getPageHeaderPaddingTop();
        m10514a();
        if (ReaderEnv.get().forHd()) {
            viewGroup = (ViewGroup) this.f7110h.findViewById(C0244f.surfing__immersive_surfing_view__tabs_hd);
        } else {
            viewGroup = (ViewGroup) this.f7110h.findViewById(C0244f.surfing__immersive_surfing_view__tabs);
        }
        this.f7112j = viewGroup;
        if (ReaderEnv.get().forHd()) {
            frameLayout = (FrameLayout) this.f7110h.findViewById(C0244f.surfing__immersive_surfing_view__right_hd);
        } else {
            frameLayout = (FrameLayout) this.f7110h.findViewById(C0244f.surfing__immersive_surfing_view__right);
        }
        this.f7103a = frameLayout;
        this.f7114l = new dw(this, context);
        this.f7114l.setBackgroundColor(getResources().getColor(C0241c.general__shared__page_background));
        this.f7114l.setOnScrollListener(new dx(this));
        this.f7114l.setOnFlipListener(new dy(this));
        addView(this.f7114l, new LayoutParams(-1, -1));
        addView(this.f7110h);
        this.f7111i = new View(getContext());
        this.f7111i.setBackgroundDrawable(new dz(this));
        addView(this.f7111i, new LayoutParams(-1, this.f7105c));
        this.f7113k = new View(getContext());
        this.f7113k.setBackground(new ea(this));
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 21;
        this.f7113k.setOnClickListener(new eb(this));
        this.f7113k.setContentDescription(getContext().getString(C0247i.general__shared__search));
        this.f7103a.addView(this.f7113k, layoutParams);
        this.f7115m = this.f7110h.findViewById(C0244f.surfing__immersive_surfing_view__search_bar);
        this.f7115m.setBackgroundDrawable(new ec(this));
        this.f7115m.setOnClickListener(new ed(this));
    }

    /* renamed from: a */
    public void m10518a(String str, View view) {
        View a = m10498a(str);
        this.f7112j.addView(a, new ViewGroup.LayoutParams(-2, -1));
        if (this.f7114l.indexOfChild(view) == -1) {
            this.f7114l.addView(view, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.f7114l.bringChildToFront(view);
        }
        a.setOnClickListener(new dt(this, a));
    }

    public int getCurrentPageIndex() {
        return this.f7104b;
    }

    /* renamed from: a */
    public void m10517a(int i, boolean z) {
        if ((this.f7104b != i || z) && i >= 0 && i < this.f7114l.getChildCount()) {
            dv.m1921a(this.f7114l, new du(this, i));
        }
    }

    /* renamed from: a */
    public void m10515a(int i) {
        m10516a(i, null);
    }

    /* renamed from: a */
    public void m10516a(int i, Runnable runnable) {
        if (this.f7104b == i) {
            UThread.post(runnable);
        } else if (i >= 0 && i < this.f7114l.getChildCount()) {
            this.f7114l.m9069a(i, runnable, null);
        }
    }

    /* renamed from: b */
    public void m10519b(int i) {
        if (i >= 0 && i < this.f7114l.getChildCount()) {
            this.f7112j.getChildAt(i).setVisibility(8);
            this.f7114l.getChildAt(i).setVisibility(8);
        }
    }

    /* renamed from: c */
    public void m10522c(int i) {
        if (i >= 0 && i < this.f7114l.getChildCount()) {
            this.f7112j.getChildAt(i).setVisibility(0);
            this.f7114l.getChildAt(i).setVisibility(0);
        }
    }

    /* renamed from: a */
    public void m10514a() {
        int j;
        if (ReaderEnv.get().forHd() && DkPublic.isLandscape(getContext())) {
            j = (int) (((float) dv.getWidthPixels(getContext())) * 0.1f);
        } else {
            j = 0;
        }
        this.f7110h.setPadding(j, this.f7105c, j, 0);
    }

    public void setOnCurrentPageChangedListener(ee eeVar) {
        this.f7120r = eeVar;
    }

    public Map<Integer, Float> getVisibleViewIndexMap() {
        return this.f7119q;
    }

    /* renamed from: b */
    protected boolean mo2530b() {
        return true;
    }

    /* renamed from: c */
    protected float mo2531c() {
        return 1.0f;
    }

    /* renamed from: d */
    protected float mo2532d() {
        return 1.0f;
    }

    /* renamed from: e */
    protected float mo2533e() {
        return 1.0f;
    }

    protected String getSearchKeyWord() {
        return getResources().getString(C0247i.bookshelf__shared__search);
    }

    /* renamed from: f */
    protected void mo2534f() {
        ((hd) AppContext.getAppContext(getContext()).queryFeature(hd.class)).mo2548a("", "", "");
    }

    /* renamed from: h */
    private void m10513h() {
        this.f7119q.clear();
        for (int i = 0; i < this.f7114l.getChildCount(); i++) {
            Rect rect = (Rect) dv.f1198g.addAnimation();
            View childAt = this.f7114l.getChildAt(i);
            if (childAt.getVisibility() != 0) {
                this.f7119q.put(Integer.valueOf(i), Float.valueOf(0.0f));
            } else {
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.width() == 0 || rect.right <= this.f7114l.getViewportBounds().left || rect.left >= this.f7114l.getViewportBounds().right) {
                    this.f7119q.put(Integer.valueOf(i), Float.valueOf(0.0f));
                } else if (rect.left < this.f7114l.getViewportBounds().left) {
                    this.f7119q.put(Integer.valueOf(i), Float.valueOf(((float) (rect.right - this.f7114l.getViewportBounds().left)) / ((float) rect.width())));
                } else if (rect.right > this.f7114l.getViewportBounds().right) {
                    this.f7119q.put(Integer.valueOf(i), Float.valueOf(((float) (this.f7114l.getViewportBounds().right - rect.left)) / ((float) rect.width())));
                } else {
                    this.f7119q.put(Integer.valueOf(i), Float.valueOf(1.0f));
                    dv.f1198g.clearAnimation(rect);
                }
            }
        }
    }

    /* renamed from: a */
    private void m10499a(Canvas canvas) {
        List visibleList = getVisibleList();
        if (visibleList.size() != 0 && this.f7104b >= 0) {
            float c = mo2531c();
            if (visibleList.size() == 1) {
                canvas.drawColor(Color.argb((int) ((mo2532d() * c) * 255.0f), 255, 255, 255));
                this.f7116n.setVisibility(4);
                this.f7115m.setVisibility(0);
                this.f7115m.invalidate();
                return;
            }
            canvas.drawColor(Color.argb((int) (c * 255.0f), 255, 255, 255));
            this.f7116n.setVisibility(0);
            this.f7115m.setVisibility(4);
            this.f7113k.invalidate();
            for (int i = 0; i < this.f7114l.getChildCount(); i++) {
                if (this.f7112j.getChildAt(i) instanceof TextView) {
                    float floatValue = ((Float) this.f7119q.get(Integer.valueOf(i))).floatValue();
                    ((TextView) this.f7112j.getChildAt(i)).setTextColor(Color.rgb(m10494a(255, (int) HttpStatus.SC_PROCESSING, floatValue, c), m10494a(132, (int) HttpStatus.SC_PROCESSING, floatValue, c), m10494a(0, (int) HttpStatus.SC_PROCESSING, floatValue, c)));
                }
            }
            m10500a(canvas, c);
        }
    }

    /* renamed from: a */
    private void m10500a(Canvas canvas, float f) {
        List visibleList = getVisibleList();
        if (visibleList.size() != 0 && this.f7104b >= 0) {
            int right = this.f7114l.getChildAt(((Integer) visibleList.get(0)).intValue()).getRight();
            int contentWidth = this.f7114l.getContentWidth();
            float f2 = (((float) this.f7114l.getViewportBounds().right) * (1.0f / ((float) (contentWidth - right)))) + (((float) right) / ((float) (right - contentWidth)));
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0242d.general_font__shared__c);
            int i = dimensionPixelSize * 2;
            View childAt = this.f7112j.getChildAt(((Integer) visibleList.get(0)).intValue());
            Rect rect = (Rect) dv.f1198g.addAnimation();
            childAt.getGlobalVisibleRect(rect);
            int width = (rect.right - (childAt.getWidth() / 2)) + (i / 2);
            View childAt2 = this.f7112j.getChildAt(((Integer) visibleList.get(visibleList.size() - 1)).intValue());
            childAt2.getGlobalVisibleRect(rect);
            contentWidth = (int) ((((float) (((rect.right - (childAt2.getWidth() / 2)) + (i / 2)) - width)) * f2) + ((float) width));
            Paint paint = new Paint();
            float floatValue = ((Float) this.f7119q.get(Integer.valueOf(this.f7104b))).floatValue();
            if (((double) floatValue) < 0.5d) {
                floatValue = 1.0f - floatValue;
            }
            paint.setColor(Color.rgb(m10494a(255, (int) HttpStatus.SC_PROCESSING, floatValue, f), m10494a(132, (int) HttpStatus.SC_PROCESSING, floatValue, f), m10494a(0, (int) HttpStatus.SC_PROCESSING, floatValue, f)));
            dimensionPixelSize = this.f7110h.getPaddingTop() + (((childAt.getTop() + childAt.getPaddingTop()) + dimensionPixelSize) + this.f7107e);
            RectF rectF = (RectF) dv.f1199h.addAnimation();
            rectF.set((float) (contentWidth - i), (float) dimensionPixelSize, (float) contentWidth, (float) (dimensionPixelSize + this.f7106d));
            canvas.drawRoundRect(rectF, (float) (this.f7106d / 2), (float) (this.f7106d / 2), paint);
            dv.f1199h.clearAnimation(rectF);
            dv.f1198g.clearAnimation(rect);
        }
    }

    /* renamed from: a */
    private void m10501a(Canvas canvas, View view) {
        float c = mo2531c();
        int rgb = Color.rgb(m10493a(255, 122, c), m10493a(255, 122, c), m10493a(255, 122, c));
        int d = (int) ((((c + 1.0f) / 2.0f) * 255.0f) * mo2532d());
        RectF rectF = (RectF) dv.f1199h.addAnimation();
        int height = view.getHeight() - view.getPaddingBottom();
        rectF.set((float) view.getPaddingLeft(), (float) Math.max(0, height - this.f7109g), (float) (view.getWidth() - view.getPaddingRight()), (float) height);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#f2f2f2"));
        paint.setAntiAlias(true);
        paint.setAlpha(d);
        canvas.drawRoundRect(rectF, (float) dv.m1932b(getContext(), 4.0f), (float) dv.m1932b(getContext(), 4.0f), paint);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize((float) dv.getScaledDensity(getContext(), 12.0f));
        paint.measureText(getSearchKeyWord());
        Drawable drawable = getResources().getDrawable(C0243e.surfing__surfing_tab_view__search_light);
        int max = (int) Math.max(rectF.left, rectF.centerX() - ((float) (((int) (((float) (drawable.getIntrinsicWidth() + dv.m1932b(getContext(), 7.0f))) + paint.measureText(getSearchKeyWord()))) / 2)));
        int min = (int) Math.min(rectF.right, (float) (drawable.getIntrinsicWidth() + max));
        int max2 = (int) Math.max(rectF.top, rectF.centerY() - ((float) (drawable.getIntrinsicHeight() / 2)));
        int min2 = (int) Math.min(rectF.bottom, (float) (drawable.getIntrinsicHeight() + max2));
        drawable.setAlpha(d);
        drawable.setBounds(max, max2, min, min2);
        drawable.draw(canvas);
        paint.setColor(rgb);
        paint.setAlpha(d);
        RectF rectF2 = (RectF) dv.f1199h.addAnimation();
        rectF2.set((float) ((drawable.getIntrinsicWidth() + max) + dv.m1932b(getContext(), 7.0f)), rectF.top, rectF.right, rectF.bottom);
        dv.m1914a(canvas, getSearchKeyWord(), rectF2, 19, paint);
        dv.f1199h.clearAnimation(rectF2);
        dv.f1199h.clearAnimation(rectF);
    }

    /* renamed from: a */
    private int m10494a(int i, int i2, float f, float f2) {
        return m10493a(255, m10493a(i2, i, f), f2);
    }

    /* renamed from: a */
    private int m10493a(int i, int i2, float f) {
        return Math.min(255, (int) (((float) i) + (((float) (i2 - i)) * f)));
    }

    /* renamed from: a */
    private int m10495a(TextView textView) {
        return this.f7112j.indexOfChild(textView);
    }

    /* renamed from: d */
    private void m10509d(int i) {
        if (this.f7104b != i) {
            int i2 = this.f7104b;
            this.f7104b = i;
            if (this.f7120r != null) {
                this.f7120r.mo2536a(i2, this.f7104b);
            }
        }
    }

    /* renamed from: a */
    private TextView m10498a(String str) {
        TextView dvVar = new dv(this, getContext());
        dvVar.setText(str);
        dvVar.setGravity(1);
        dvVar.setSingleLine(true);
        dvVar.setEllipsize(TruncateAt.END);
        dvVar.setIncludeFontPadding(false);
        dvVar.setTextSize(14.0f);
        return dvVar;
    }

    private int getTabTextHeight() {
        return (dv.getScaledDensity(getContext(), 14.0f) + this.f7106d) + this.f7107e;
    }

    public View getTabView() {
        return this.f7110h;
    }

    public List<Integer> getVisibleList() {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < this.f7114l.getChildCount(); i++) {
            if (this.f7114l.getChildAt(i).getVisibility() == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    public View getStatusView() {
        return this.f7111i;
    }

    /* renamed from: g */
    public void m10526g() {
        this.f7104b = -1;
        this.f7119q.clear();
        this.f7114l.m9073g();
        this.f7112j.removeAllViews();
    }
}
