package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.duokan.core.app.AppContext;
import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.ui.general.FlowPagesView.FlipEffect;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.PagesView.PageLayout;
import com.duokan.reader.ui.general.fw;
import com.duokan.reader.ui.general.fx;
import fi.harism.curl.CurlPageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class wy extends FrameLayout {
    /* renamed from: a */
    protected final su f9698a;
    /* renamed from: b */
    protected final PagesFrameView f9699b;
    /* renamed from: c */
    protected final CurlPageView f9700c;
    /* renamed from: d */
    protected final xo f9701d;
    /* renamed from: e */
    protected final xj f9702e = new xj();
    /* renamed from: f */
    protected final xi f9703f = new xi();
    /* renamed from: g */
    protected Bitmap f9704g = null;
    /* renamed from: h */
    protected Drawable f9705h = null;
    /* renamed from: i */
    protected WritingDirection f9706i = WritingDirection.LEFT_TO_RIGHT;
    /* renamed from: j */
    protected int f9707j = 0;
    /* renamed from: k */
    protected int f9708k = 0;
    /* renamed from: l */
    protected PageAnimationMode f9709l = PageAnimationMode.NONE;
    /* renamed from: m */
    protected View f9710m = null;

    /* renamed from: a */
    public abstract void mo2257a();

    protected abstract fm getFixedPagesView();

    protected abstract fs getFlowPagesView();

    public abstract hd getShowingDocPresenter();

    public abstract PagesView getShowingPagesView();

    public wy(Context context, xo xoVar) {
        super(context);
        this.f9701d = xoVar;
        this.f9698a = (su) AppContext.getAppContext(context).queryFeature(su.class);
        inflate(getContext(), C0256h.reading__reading_view, this);
        this.f9699b = (PagesFrameView) findViewById(C0255g.reading__reading_view__page_frame);
        this.f9700c = (CurlPageView) findViewById(C0255g.reading__reading_view__curl);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        m13635a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
    }

    /* renamed from: d */
    public final boolean m13654d() {
        return DkPublic.isLandscape(getContext());
    }

    /* renamed from: e */
    public final boolean m13655e() {
        return m13654d() && this.f9698a.mo2004U() != PageAnimationMode.VSCROLL && this.f9698a.i_();
    }

    public final FrameLayout getPagesFrameView() {
        return this.f9699b;
    }

    public CurlPageView getCurlView() {
        return this.f9700c;
    }

    public final int getPageWidth() {
        return this.f9707j;
    }

    public final int getPageHeight() {
        return this.f9708k;
    }

    public final void setLineDirection(WritingDirection writingDirection) {
        if (this.f9706i != writingDirection) {
            this.f9706i = writingDirection;
            mo2465b();
        }
    }

    public final void setStatusColor(int i) {
        getFlowPagesView().setPagesExtraColor(i);
        this.f9699b.setStatusColor(i);
    }

    public final void setStatusOpacity(float f) {
        this.f9699b.setStatusOpacity(f);
    }

    /* renamed from: a */
    public final void m13650a(Runnable runnable) {
        this.f9702e.m15064a(runnable);
    }

    /* renamed from: b */
    public final void m13653b(Runnable runnable) {
        this.f9703f.m15064a(runnable);
    }

    /* renamed from: f */
    public void m13656f() {
        View[] pageViews = getShowingPagesView().getPageViews();
        for (View view : pageViews) {
            ((gx) view).m14299e();
        }
    }

    /* renamed from: g */
    public void m13657g() {
        mo2257a();
        getFlowPagesView().setCouplePageMode(m13655e());
        setPageAnimationMode(this.f9698a.mo2004U());
    }

    /* renamed from: h */
    public void m13658h() {
        this.f9699b.m12435a();
    }

    /* renamed from: a */
    public void m13651a(boolean z) {
        getFlowPagesView().setCouplePageMode(m13655e());
        setPageAnimationMode(this.f9698a.mo2004U());
        PagesView showingPagesView = getShowingPagesView();
        if (showingPagesView != null) {
            showingPagesView.m10013c(z);
        }
    }

    /* renamed from: i */
    public void m13659i() {
        getFlowPagesView().setCouplePageMode(m13655e());
        setPageAnimationMode(this.f9698a.mo2004U());
        PagesView showingPagesView = getShowingPagesView();
        if (showingPagesView != null) {
            showingPagesView.m10022j();
        }
    }

    /* renamed from: j */
    public final void m13660j() {
        ah.m871b(new wz(this));
    }

    /* renamed from: k */
    public final void m13661k() {
        if (this.f9698a.mo1993J()) {
            View[] pageViews = getShowingPagesView().getPageViews();
            for (View view : pageViews) {
                ((gx) view).setShowStatus(false);
            }
            try {
                File o = m13646o();
                Bitmap c = C0544a.m2447c(getWidth(), getHeight(), Config.RGB_565);
                draw(new Canvas(c));
                ah.m871b(new xa(this, o, c));
            } catch (Throwable th) {
            }
        }
    }

    public void setPagesFrameBackground(Drawable drawable) {
        this.f9699b.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void m13648a(View view) {
        this.f9710m = view;
    }

    /* renamed from: a */
    public void m13649a(er erVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().getScrollDetector().m2041a(erVar);
        }
        getFlowPagesView().getScrollDetector().m2041a(erVar);
    }

    /* renamed from: a */
    public er[] m13652a(Class<?>... clsArr) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().getScrollDetector().m2045a((Class[]) clsArr);
        }
        return getFlowPagesView().getScrollDetector().m2045a((Class[]) clsArr);
    }

    public void setReadingGestureListener(es esVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().getScrollDetector().m2042a(esVar);
        }
        getFlowPagesView().getScrollDetector().m2042a(esVar);
    }

    public void setOnScrollListener(cg cgVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().setOnScrollListener(cgVar);
        }
        getFlowPagesView().setOnScrollListener(cgVar);
    }

    public void setOnPageBroadcastListener(fx fxVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().setOnPageBroadcastListener(fxVar);
        }
        getFlowPagesView().setOnPageBroadcastListener(fxVar);
    }

    public void setOnCurrentPageChangeListener(fw fwVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().setOnCurrentPageChangeListener(fwVar);
        }
        getFlowPagesView().setOnCurrentPageChangeListener(fwVar);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.f9702e);
        getViewTreeObserver().addOnPreDrawListener(this.f9703f);
        dv.m1921a((View) this, new xb(this));
        m13650a(new xd(this));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.f9702e);
        getViewTreeObserver().removeOnPreDrawListener(this.f9703f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        fs flowPagesView = getFlowPagesView();
        boolean a = m13635a(getWidth(), getHeight());
        Object obj = (flowPagesView == null || flowPagesView.m14143t() == m13655e()) ? null : 1;
        if (a || obj != null) {
            this.f9701d.mo1977q();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int b = m13636b(getMeasuredWidth(), getMeasuredHeight());
        if (getPaddingLeft() != b || getPaddingRight() != b) {
            setPadding(b, 0, b, 0);
            super.onMeasure(i, i2);
        }
    }

    public void draw(Canvas canvas) {
        if (this.f9705h == null) {
            canvas.drawColor(-16777216);
        }
        super.draw(canvas);
        if (this.f9705h != null) {
            this.f9705h.draw(canvas);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f9710m != null) {
            MotionEvent a = dv.m1908a(motionEvent, (View) this, this.f9710m);
            boolean dispatchTouchEvent = this.f9710m.dispatchTouchEvent(a);
            a.recycle();
            if (dispatchTouchEvent) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private final void setPageAnimationMode(PageAnimationMode pageAnimationMode) {
        if (this.f9709l != pageAnimationMode) {
            this.f9709l = pageAnimationMode;
            mo2465b();
        }
    }

    /* renamed from: b */
    private final void mo2465b() {
        fs flowPagesView = getFlowPagesView();
        if (this.f9706i != WritingDirection.RIGHT_TO_LEFT) {
            flowPagesView.setPageLeftShadow(null);
            switch (xh.f11143a[this.f9709l.ordinal()]) {
                case 1:
                case 2:
                    flowPagesView.setFlipEffect(FlipEffect.SCROLL);
                    flowPagesView.setPageRightShadow(null);
                    break;
                case 3:
                    flowPagesView.setFlipEffect(FlipEffect.FADE_IN);
                    flowPagesView.setPageRightShadow(null);
                    break;
                case 4:
                    flowPagesView.setFlipEffect(FlipEffect.NONE);
                    flowPagesView.setPageRightShadow(null);
                    break;
                default:
                    flowPagesView.setFlipEffect(FlipEffect.OVERLAP);
                    flowPagesView.setPageRightShadow(C0254f.reading__shared__page_right_shadow);
                    break;
            }
        }
        flowPagesView.setPageRightShadow(null);
        switch (xh.f11143a[this.f9709l.ordinal()]) {
            case 1:
            case 2:
                flowPagesView.setFlipEffect(FlipEffect.SCROLL);
                flowPagesView.setPageLeftShadow(null);
                break;
            case 3:
                flowPagesView.setFlipEffect(FlipEffect.FADE_IN);
                flowPagesView.setPageLeftShadow(null);
                break;
            case 4:
                flowPagesView.setFlipEffect(FlipEffect.NONE);
                flowPagesView.setPageLeftShadow(null);
                break;
            default:
                flowPagesView.setFlipEffect(FlipEffect.OVERLAP);
                flowPagesView.setPageLeftShadow(C0254f.reading__shared__page_left_shadow);
                break;
        }
        if (this.f9709l == PageAnimationMode.VSCROLL) {
            flowPagesView.setPageLayout(PageLayout.TOP_TO_BOTTOM);
        } else {
            flowPagesView.setPageLayout(this.f9706i == WritingDirection.RIGHT_TO_LEFT ? PageLayout.RIGHT_TO_LEFT : PageLayout.LEFT_TO_RIGHT);
        }
    }

    /* renamed from: a */
    private final boolean m13635a(int i, int i2) {
        int b = i - (m13636b(i, i2) * 2);
        boolean z = (this.f9707j == b && this.f9708k == i2) ? false : true;
        this.f9707j = b;
        this.f9708k = i2;
        return z;
    }

    /* renamed from: b */
    private final int m13636b(int i, int i2) {
        if (m13655e() && this.f9698a.mo1992G().ak()) {
            return (int) Math.max((((float) i) / 2.0f) - (((float) i2) * 0.75f), 0.0f);
        }
        return 0;
    }

    /* renamed from: c */
    private final Bitmap mo2466c() {
        Bitmap bitmap = null;
        try {
            File o = m13646o();
            if (o.exists()) {
                bitmap = C0544a.m2434a(getContext(), o.getAbsolutePath());
            }
        } catch (Throwable th) {
        }
        return bitmap;
    }

    /* renamed from: l */
    private final void m13643l() {
        ah.m871b(new xe(this));
    }

    /* renamed from: m */
    private final void m13644m() {
        int i = 0;
        File[] fileArr = (File[]) m13645n().toArray(new File[0]);
        if (fileArr.length > 100) {
            Arrays.sort(fileArr, new xf(this));
            while (i < fileArr.length / 2) {
                FileUtil.m793f(fileArr[i]);
                i++;
            }
        }
    }

    /* renamed from: n */
    private final List<File> m13645n() {
        return FileUtil.m776a(ReaderEnv.get().getReadingCacheDirectory(), new xg(this));
    }

    /* renamed from: o */
    private final File m13646o() {
        C0800c G = this.f9698a.mo1992G();
        return new File(ReaderEnv.get().getReadingCacheDirectory(), C0366o.m1034b(String.format(Locale.getDefault(), "book=%s;pos=%s;w=%d;h=%d;theme=%s;v=%d;", new Object[]{G.m4156I(), G.m4152E().toString(), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), this.f9698a.mo1997N(), Integer.valueOf(2)}), "md5") + ".snap");
    }
}
