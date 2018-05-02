package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.C0616o;
import com.duokan.reader.common.webservices.duokan.DkSignInReward;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.io;
import com.duokan.reader.domain.bookshelf.lb;
import com.duokan.reader.domain.bookshelf.ln;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.gp;
import com.duokan.reader.ui.C0435s;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.duokan.reader.ui.bookshelf.g */
public class C1290g extends FrameLayout implements io, ln, gp, db, ex {
    /* renamed from: a */
    protected ReaderFeature f6481a;
    /* renamed from: b */
    protected cw f6482b;
    /* renamed from: c */
    protected cz f6483c;
    /* renamed from: d */
    private View f6484d;
    /* renamed from: e */
    private final dc f6485e;
    /* renamed from: f */
    private final gz f6486f;
    /* renamed from: g */
    private final ImageView f6487g;
    /* renamed from: h */
    private hs f6488h;
    /* renamed from: i */
    private final SignInBookshelfView f6489i;
    /* renamed from: j */
    private final View f6490j;
    /* renamed from: k */
    private final View f6491k;
    /* renamed from: l */
    private final LinearLayout f6492l;
    /* renamed from: m */
    private final View f6493m;
    /* renamed from: n */
    private final int f6494n;
    /* renamed from: o */
    private Callable<Boolean> f6495o = null;
    /* renamed from: p */
    private boolean f6496p;

    public C1290g(IFeature mFeature) {
        super((Context) mFeature);
        this.f6482b = (cw) mFeature.queryFeature(cw.class);
        this.f6483c = (cz) mFeature.queryFeature(cz.class);
        this.f6481a = (ReaderFeature) mFeature.queryFeature(ReaderFeature.class);
        this.f6485e = new C1291h(this, null, getContext());
        this.f6485e.m9455a(new C1310x(this));
        this.f6490j = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__bookshelf_header_view, this, false);
        View findViewById = this.f6490j.findViewById(C0255g.bookshelf__bookshelf_header_view__tab);
        int pageHeaderPaddingTop = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderPaddingTop();
        int pageHeaderHeight = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderHeight();
        findViewById.setLayoutParams(new LayoutParams(-1, pageHeaderHeight));
        findViewById.setPadding(0, pageHeaderPaddingTop, 0, 0);
        View findViewById2 = this.f6490j.findViewById(C0255g.xiaoai_view);
        if (C0616o.m2804a().m2814d()) {
            findViewById2.setClickable(true);
            findViewById2.setOnClickListener(new C1312z(this));
        } else {
            findViewById2.setVisibility(8);
        }
        Drawable drawable = getResources().getDrawable(C0254f.bookshelf__bookshelf_header_view__search_icon);
        View findViewById3 = findViewById.findViewById(C0255g.bookshelf__bookshelf_header_view__search_bar);
        findViewById3.setBackgroundDrawable(new ab(this, pageHeaderHeight, pageHeaderPaddingTop, findViewById3, drawable, findViewById));
        findViewById3.setOnClickListener(new ac(this));
        this.f6493m = findViewById.findViewById(C0255g.bookshelf__bookshelf_header_view__dot);
        findViewById.findViewById(C0255g.bookshelf__bookshelf_header_view__menu).setOnClickListener(new ad(this, findViewById));
        this.f6489i = (SignInBookshelfView) this.f6490j.findViewById(C0255g.bookshelf__bookshelf_header_view__sign_in);
        this.f6492l = (LinearLayout) this.f6490j.findViewById(C0255g.bookshelf__bookshelf_header_view__recent_books);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f6486f = new ae(this, getContext(), findViewById);
        this.f6489i.setBookshelfView(this.f6486f);
        this.f6486f.m1250b(this.f6486f.getGridPaddingLeft(), 0, this.f6486f.getGridPaddingRight(), this.f6486f.getGridPaddingBottom());
        this.f6486f.m1255c(0, 0, 0, 0);
        this.f6494n = this.f6486f.getGridPaddingBottom();
        this.f6486f.setBackgroundColor(Color.parseColor("#ffffff"));
        this.f6486f.setAdapter(this.f6485e);
        this.f6486f.setSeekEnabled(true);
        this.f6486f.setVerticalSeekDrawable(getResources().getDrawable(C0254f.general__shared__thumb_seek_vert));
        this.f6486f.m1260e(0, displayMetrics.heightPixels / 4, 0, displayMetrics.heightPixels / 4);
        this.f6486f.setOnItemClickListener(new af(this));
        addView(this.f6486f, new FrameLayout.LayoutParams(-1, -1));
        new FrameLayout.LayoutParams(-2, -2, 53).topMargin = pageHeaderHeight;
        this.f6487g = (ImageView) LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__nightmode_view, this, false);
        this.f6487g.setOnClickListener(new ag(this));
        m9702i();
        addView(this.f6487g);
        this.f6491k = new View(getContext());
        this.f6491k.setBackgroundColor(-1);
        addView(this.f6491k, new FrameLayout.LayoutParams(-1, pageHeaderPaddingTop));
        this.f6486f.setOnScrollListener(new C1294i(this, findViewById, findViewById3));
        this.f6483c.mo1645a((db) this);
        this.f6489i.setVisibility(8);
    }

    public void setHeaderViewEnable(boolean z) {
        if (this.f6488h != null) {
            this.f6488h.setEnabled(z);
        }
    }

    public int[] getVisibleItemIndices() {
        return this.f6486f.getVisibleItemIndices();
    }

    /* renamed from: a */
    public Rect mo1661a(int i) {
        Rect g = this.f6486f.m1265g(i);
        dv.m1936b(g, this.f6486f);
        return g;
    }

    public int getItemCount() {
        return this.f6485e.m9457b();
    }

    public View[] getItemViews() {
        return this.f6486f.getItemViews();
    }

    /* renamed from: b */
    public de mo1670b(int i) {
        return (de) this.f6486f.m1241a(i);
    }

    public de getDraggingItemView() {
        View[] itemViews = getItemViews();
        for (int i = 0; i < itemViews.length; i++) {
            if (itemViews[i] instanceof de) {
                de deVar = (de) itemViews[i];
                if (deVar != null && deVar.getItem() == this.f6485e.m9463e()) {
                    return deVar;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    public an mo1671c(int i) {
        if (i < 0 || i >= this.f6485e.mo506c()) {
            return null;
        }
        return (an) this.f6485e.mo509d(i);
    }

    /* renamed from: a */
    public void mo1668a(an anVar, boolean z) {
        this.f6485e.m9454a(anVar, z);
    }

    /* renamed from: a */
    public void mo1664a(Rect rect) {
        rect.set(0, 0, this.f6486f.getWidth(), this.f6486f.getHeight());
        rect.top += this.f6486f.getHatVisibleHeight();
        dv.m1936b(rect, this.f6486f);
    }

    public boolean d_() {
        return this.f6486f.m1258d();
    }

    public boolean e_() {
        return this.f6486f.m1261e();
    }

    /* renamed from: a */
    public void mo1662a(int i, int i2) {
        this.f6486f.scrollBy(i, i2);
        this.f6486f.m1263f();
    }

    /* renamed from: a */
    public void mo1663a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        int max;
        if (this.f6489i.getVisibility() != 8) {
            if (this.f6486f.getViewportBounds().top >= this.f6489i.getHeight()) {
                max = Math.max(i2, this.f6489i.getHeight());
            } else if (i2 < this.f6489i.getHeight()) {
                max = 0;
            }
            this.f6486f.mo434a(i, max, i3, runnable, runnable2);
        }
        max = i2;
        this.f6486f.mo434a(i, max, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.f6486f.getGridScrollY();
    }

    /* renamed from: a */
    public boolean mo1669a(int i, de deVar) {
        return (i + 1) % this.f6486f.getNumColumns() == 0;
    }

    /* renamed from: a */
    public void mo1666a(an anVar, int i) {
        this.f6485e.m9452a(anVar, i);
    }

    /* renamed from: a */
    public void mo1667a(an anVar, an anVar2, int i) {
        this.f6485e.m9453a(anVar, anVar2, i);
    }

    /* renamed from: a */
    public void mo1665a(aa aaVar, an anVar) {
        this.f6485e.m9450a(aaVar, anVar);
    }

    /* renamed from: a */
    public void m9680a(an anVar) {
        m9697d();
        int b = this.f6485e.m9458b(anVar);
        if (b >= 0) {
            this.f6486f.m1259e(b);
        }
    }

    /* renamed from: c */
    public void m9696c() {
        int i = this.f6486f.getViewportBounds().top;
        if (this.f6495o == null) {
            this.f6495o = new C1296j(this, i);
            dv.m1922a((View) this, this.f6495o);
            invalidate();
        }
    }

    /* renamed from: d */
    public void m9697d() {
        if (this.f6495o != null) {
            try {
                this.f6495o.call();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: j */
    private void m9673j() {
        this.f6493m.setVisibility(PersonalPrefs.m5175a().m5248x() ? 0 : 4);
    }

    /* renamed from: e */
    public void m9698e() {
        List d = this.f6482b.m9444d();
        if (!this.f6485e.m9456a(d)) {
            this.f6485e.m9449a(this.f6486f.getNumColumns(), true);
            this.f6485e.m9459b(d);
            this.f6485e.m9449a(this.f6486f.getNumColumns(), false);
        }
    }

    public int getItemsCount() {
        return this.f6485e.mo506c();
    }

    public HatGridView getContentView() {
        return this.f6486f;
    }

    /* renamed from: a */
    public void mo1701a() {
    }

    /* renamed from: b */
    public void mo1705b() {
        this.f6482b.m9438a(new C1299m(this));
    }

    /* renamed from: a */
    public void mo1702a(String str) {
    }

    /* renamed from: a */
    public void mo1628a(cz czVar, boolean z) {
        this.f6485e.mo2519h(0, this.f6485e.mo506c());
    }

    /* renamed from: a */
    public void mo1627a(cz czVar, List<an> list) {
        an d = this.f6483c.mo1660d();
        if (d != null) {
            this.f6485e.m9451a(d);
        } else {
            this.f6485e.mo2519h(0, this.f6485e.mo506c());
        }
    }

    /* renamed from: b */
    public void mo1629b(cz czVar, List<an> list) {
        an d = this.f6483c.mo1660d();
        if (d != null) {
            this.f6485e.m9451a(d);
        } else {
            this.f6485e.mo2519h(0, this.f6485e.mo506c());
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            m9696c();
            m9673j();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ai.m3980a().m3888a((io) this);
        lb.m4896a().m4917a((ln) this);
        PersonalPrefs.m5175a().m5205a((gp) this);
        if (getVisibility() == 0) {
            m9673j();
            m9696c();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ai.m3980a().m3911b((io) this);
        lb.m4896a().m4921b((ln) this);
        PersonalPrefs.m5175a().m5216b((gp) this);
    }

    /* renamed from: f */
    public void m9699f() {
        this.f6489i.setActive(true);
        this.f6489i.m9092b();
    }

    /* renamed from: g */
    public void m9700g() {
        this.f6489i.setActive(false);
    }

    protected View getEmptyView() {
        if (this.f6484d == null) {
            this.f6484d = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__empty_view, null);
            this.f6484d.findViewById(C0255g.bookshelf__empty_view__go_to_store).setOnClickListener(new C1300n(this));
        }
        return this.f6484d;
    }

    /* renamed from: a */
    private void m9660a(aa aaVar, boolean z) {
        this.f6483c.mo1643a(aaVar, z, null);
    }

    /* renamed from: h */
    public void m9701h() {
        if (this.f6488h == null) {
            this.f6488h = new hs(getContext(), this.f6482b, new C1301o(this));
            this.f6488h.m9804a(false);
            this.f6492l.addView(this.f6488h, 0);
        }
    }

    /* renamed from: i */
    public void m9702i() {
        if (this.f6481a.inNightMode()) {
            this.f6487g.setVisibility(0);
            this.f6487g.setSelected(true);
            return;
        }
        this.f6487g.setVisibility(4);
    }

    /* renamed from: a */
    public void mo1703a(boolean z) {
        if (PersonalPrefs.m5175a().m5234j() && (C0709k.m3476a().m3500a(MiAccount.class) || !MiAccount.m3186b(getContext()) || !DkApp.get().getAutoLogin())) {
            boolean a = this.f6489i.m9091a();
            if (this.f6489i.getVisibility() == 8) {
                this.f6489i.setVisibility(0);
                dv.m1921a(this.f6489i, new C1306t(this, this.f6486f.getViewportBounds().top, a));
            }
        } else if (this.f6489i.getVisibility() == 0) {
            dv.m1921a(this.f6489i, new C1304r(this));
        } else {
            this.f6489i.setVisibility(8);
            m9663a(null);
        }
    }

    /* renamed from: a */
    public void mo1704a(boolean[] zArr, int i, List<DkSignInReward> list, boolean z, boolean z2, boolean z3) {
        if (lb.m4896a().m4920b().size() <= 1) {
            ActivatedController ieVar = new ie(AppContext.getAppContext(getContext()));
            this.f6481a.pushPageSmoothly(ieVar, new C1309w(this, ieVar, zArr, i, list, z, z2, z3));
        }
    }

    /* renamed from: b */
    public void mo1706b(String str) {
    }

    /* renamed from: b */
    public void mo1707b(boolean z) {
        m9673j();
    }

    /* renamed from: a */
    private void m9663a(Runnable runnable) {
        int gridPaddingBottom = this.f6486f.getGridPaddingBottom();
        if (this.f6489i.getVisibility() == 8) {
            gridPaddingBottom = this.f6494n;
        } else {
            int height = getHeight();
            int contentHeight = this.f6486f.getContentHeight();
            if (contentHeight - this.f6489i.getHeight() < height) {
                gridPaddingBottom = Math.max(this.f6494n, ((height - contentHeight) + this.f6489i.getHeight()) + this.f6486f.getGridPaddingBottom());
            } else if (contentHeight - this.f6489i.getHeight() > height) {
                gridPaddingBottom = Math.max(this.f6494n, height + ((this.f6486f.getGridPaddingBottom() - contentHeight) + this.f6489i.getHeight()));
            }
        }
        if (gridPaddingBottom != this.f6486f.getGridPaddingBottom()) {
            this.f6486f.m1250b(this.f6486f.getGridPaddingLeft(), 0, this.f6486f.getGridPaddingRight(), gridPaddingBottom);
            this.f6486f.m1255c(0, 0, 0, 0);
        }
        dv.m1921a(this.f6486f, runnable);
    }

    /* renamed from: a */
    private int m9656a(int i, int i2, float f) {
        return Math.min(255, (int) (((float) i) + (((float) (i2 - i)) * f)));
    }
}
