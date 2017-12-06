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

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.io.FileUtils;
import com.duokan.core.sys.ah;
import com.duokan.core.sys.o;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.WritingDirection;
import com.duokan.reader.ui.general.FlowPagesView.FlipEffect;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.PagesView.PageLayout;
import com.duokan.reader.ui.general.gc;
import com.duokan.reader.ui.general.gd;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class wl extends FrameLayout {
    protected final sh a;
    protected final PagesFrameView b;
    protected final CurlPageView c;
    protected final xb d;
    protected final ww e = new ww();
    protected final wv f = new wv();
    protected Bitmap g = null;
    protected Drawable h = null;
    protected WritingDirection i = WritingDirection.LEFT_TO_RIGHT;
    protected int j = 0;
    protected int k = 0;
    protected PageAnimationMode l = PageAnimationMode.NONE;
    protected View m = null;

    public abstract void a();

    protected abstract fi getFixedPagesView();

    protected abstract fo getFlowPagesView();

    public abstract gy getShowingDocPresenter();

    public abstract PagesView getShowingPagesView();

    public wl(Context context, xb xbVar) {
        super(context);
        this.d = xbVar;
        this.a = (sh) MyContextWrapper.getFeature(context).queryFeature(sh.class);
        inflate(getContext(), h.reading__reading_view, this);
        this.b = (PagesFrameView) findViewById(g.reading__reading_view__page_frame);
        this.c = (CurlPageView) findViewById(g.reading__reading_view__curl);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        setWillNotDraw(false);
        setWillNotCacheDrawing(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
    }

    public final boolean d() {
        return DkPublic.isLandscape(getContext());
    }

    public final boolean e() {
        return d() && this.a.U() != PageAnimationMode.VSCROLL && this.a.h_();
    }

    public final FrameLayout getPagesFrameView() {
        return this.b;
    }

    public CurlPageView getCurlView() {
        return this.c;
    }

    public final int getPageWidth() {
        return this.j;
    }

    public final int getPageHeight() {
        return this.k;
    }

    public final void setLineDirection(WritingDirection writingDirection) {
        if (this.i != writingDirection) {
            this.i = writingDirection;
            b();
        }
    }

    public final void setStatusColor(int i) {
        getFlowPagesView().setPagesExtraColor(i);
        this.b.setStatusColor(i);
    }

    public final void setStatusOpacity(float f) {
        this.b.setStatusOpacity(f);
    }

    public final void a(Runnable runnable) {
        this.e.a(runnable);
    }

    public final void b(Runnable runnable) {
        this.f.a(runnable);
    }

    public void f() {
        View[] pageViews = getShowingPagesView().getPageViews();
        for (View view : pageViews) {
            ((gs) view).e();
        }
    }

    public void g() {
        a();
        getFlowPagesView().setCouplePageMode(e());
        setPageAnimationMode(this.a.U());
    }

    public void h() {
        this.b.a();
    }

    public void a(boolean z) {
        getFlowPagesView().setCouplePageMode(e());
        setPageAnimationMode(this.a.U());
        PagesView showingPagesView = getShowingPagesView();
        if (showingPagesView != null) {
            showingPagesView.c(z);
        }
    }

    public void i() {
        getFlowPagesView().setCouplePageMode(e());
        setPageAnimationMode(this.a.U());
        PagesView showingPagesView = getShowingPagesView();
        if (showingPagesView != null) {
            showingPagesView.j();
        }
    }

    public final void j() {
        ah.submitFuture(new wm(this));
    }

    public final void k() {
        if (this.a.J()) {
            View[] pageViews = getShowingPagesView().getPageViews();
            for (View view : pageViews) {
                ((gs) view).setShowStatus(false);
            }
            try {
                File o = o();
                Bitmap c = a.c(getWidth(), getHeight(), Config.RGB_565);
                draw(new Canvas(c));
                ah.submitFuture(new wn(this, o, c));
            } catch (Throwable th) {
            }
        }
    }

    public void setPagesFrameBackground(Drawable drawable) {
        this.b.setBackgroundDrawable(drawable);
    }

    public void a(View view) {
        this.m = view;
    }

    public void a(er erVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().getScrollDetector().a(erVar);
        }
        getFlowPagesView().getScrollDetector().a(erVar);
    }

    public er[] a(Class... clsArr) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().getScrollDetector().a(clsArr);
        }
        return getFlowPagesView().getScrollDetector().a(clsArr);
    }

    public void setReadingGestureListener(OnTouchChangeListener esVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().getScrollDetector().a(esVar);
        }
        getFlowPagesView().getScrollDetector().a(esVar);
    }

    public void setOnScrollListener(OnScrollListener cgVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().setOnScrollListener(cgVar);
        }
        getFlowPagesView().setOnScrollListener(cgVar);
    }

    public void setOnPageBroadcastListener(gd gdVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().setOnPageBroadcastListener(gdVar);
        }
        getFlowPagesView().setOnPageBroadcastListener(gdVar);
    }

    public void setOnCurrentPageChangeListener(gc gcVar) {
        if (getFixedPagesView() != null) {
            getFixedPagesView().setOnCurrentPageChangeListener(gcVar);
        }
        getFlowPagesView().setOnCurrentPageChangeListener(gcVar);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.e);
        getViewTreeObserver().addOnPreDrawListener(this.f);
        UTools.creatCallTask((View) this, new wo(this));
        a(new wq(this));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.e);
        getViewTreeObserver().removeOnPreDrawListener(this.f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        fo flowPagesView = getFlowPagesView();
        boolean a = a(getWidth(), getHeight());
        Object obj = (flowPagesView == null || flowPagesView.t() == e()) ? null : 1;
        if (a || obj != null) {
            this.d.q();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int b = b(getMeasuredWidth(), getMeasuredHeight());
        if (getPaddingLeft() != b || getPaddingRight() != b) {
            setPadding(b, 0, b, 0);
            super.onMeasure(i, i2);
        }
    }

    public void draw(Canvas canvas) {
        if (this.h == null) {
            canvas.drawColor(-16777216);
        }
        super.draw(canvas);
        if (this.h != null) {
            this.h.draw(canvas);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.m != null) {
            MotionEvent a = UTools.resetMotionEvent(motionEvent, (View) this, this.m);
            boolean dispatchTouchEvent = this.m.dispatchTouchEvent(a);
            a.recycle();
            if (dispatchTouchEvent) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private final void setPageAnimationMode(PageAnimationMode pageAnimationMode) {
        if (this.l != pageAnimationMode) {
            this.l = pageAnimationMode;
            b();
        }
    }

    private final void b() {
        fo flowPagesView = getFlowPagesView();
        if (this.i != WritingDirection.RIGHT_TO_LEFT) {
            flowPagesView.setPageLeftShadow(null);
            switch (wu.a[this.l.ordinal()]) {
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
                    flowPagesView.setPageRightShadow(f.reading__shared__page_right_shadow);
                    break;
            }
        }
        flowPagesView.setPageRightShadow(null);
        switch (wu.a[this.l.ordinal()]) {
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
                flowPagesView.setPageLeftShadow(f.reading__shared__page_left_shadow);
                break;
        }
        if (this.l == PageAnimationMode.VSCROLL) {
            flowPagesView.setPageLayout(PageLayout.TOP_TO_BOTTOM);
        } else {
            flowPagesView.setPageLayout(this.i == WritingDirection.RIGHT_TO_LEFT ? PageLayout.RIGHT_TO_LEFT : PageLayout.LEFT_TO_RIGHT);
        }
    }

    private final boolean a(int i, int i2) {
        int b = i - (b(i, i2) * 2);
        boolean z = (this.j == b && this.k == i2) ? false : true;
        this.j = b;
        this.k = i2;
        return z;
    }

    private final int b(int i, int i2) {
        if (e() && this.a.G().ai()) {
            return (int) Math.max((((float) i) / 2.0f) - (((float) i2) * 0.75f), 0.0f);
        }
        return 0;
    }

    private final Bitmap c() {
        Bitmap bitmap = null;
        try {
            File o = o();
            if (o.exists()) {
                bitmap = a.a(getContext(), o.getAbsolutePath());
            }
        } catch (Throwable th) {
        }
        return bitmap;
    }

    private final void l() {
        ah.submitFuture(new wr(this));
    }

    private final void m() {
        int i = 0;
        File[] fileArr = (File[]) n().toArray(new File[0]);
        if (fileArr.length > 100) {
            Arrays.sort(fileArr, new ws(this));
            while (i < fileArr.length / 2) {
                FileUtils.deleteFile(fileArr[i]);
                i++;
            }
        }
    }

    private final List n() {
        return FileUtils.DirFileFilter(ReaderEnv.get().getReadingCacheDirectory(), new wt(this));
    }

    private final File o() {
        c G = this.a.G();
        return new File(ReaderEnv.get().getReadingCacheDirectory(), o.b(String.format(Locale.getDefault(), "book=%s;pos=%s;IActivityRunStatusChanged=%getTriangleEdge;getPhysicalXPixels=%getTriangleEdge;theme=%s;v=%getTriangleEdge;", new Object[]{G.H(), G.D().toString(), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), this.a.N(), Integer.valueOf(2)}), "md5") + ".snap");
    }
}
