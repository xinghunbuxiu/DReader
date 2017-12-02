package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.duokan.c.f;
import com.duokan.c.h;
import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.dv;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.DkStoreAdInfo;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.iu;
import com.duokan.reader.domain.bookshelf.kp;
import com.duokan.reader.domain.bookshelf.la;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.hj;
import com.duokan.reader.ui.s;

import java.util.List;
import java.util.concurrent.Callable;

public class g extends FrameLayout implements iu, la, hj, cw, eq {
    protected ReaderFeature a;
    protected cr b;
    protected cu c;
    private View d;
    private final cx e;
    private final gs f;
    private final ImageView g;
    private hl h;
    private final View i;
    private final LinearLayout j;
    private final ImageView k;
    private final View l;
    private Callable m = null;
    private final int n = dv.b(getContext(), 68.0f);

    public g(y yVar) {
        super((Context) yVar);
        this.b = (cr) yVar.queryFeature(cr.class);
        this.c = (cu) yVar.queryFeature(cu.class);
        this.a = (ReaderFeature) yVar.queryFeature(ReaderFeature.class);
        this.e = new h(this, null, getContext());
        this.e.a(new s(this));
        this.i = LayoutInflater.from(getContext()).inflate(h.bookshelf__bookshelf_header_view, this, false);
        View findViewById = this.i.findViewById(com.duokan.c.g.bookshelf__bookshelf_header_view__tab);
        int pageHeaderPaddingTop = ((s) x.a(getContext()).queryFeature(s.class)).getTheme().getPageHeaderPaddingTop();
        if (findViewById.getPaddingTop() != pageHeaderPaddingTop) {
            findViewById.setPadding(0, pageHeaderPaddingTop, 0, 0);
        }
        Drawable drawable = getResources().getDrawable(f.bookshelf__bookshelf_header_view__search_icon);
        View findViewById2 = findViewById.findViewById(com.duokan.c.g.bookshelf__bookshelf_header_view__search_bar);
        findViewById2.setBackgroundDrawable(new u(this, findViewById2, drawable));
        findViewById2.setOnClickListener(new v(this));
        this.l = findViewById.findViewById(com.duokan.c.g.bookshelf__bookshelf_header_view__dot);
        findViewById.findViewById(com.duokan.c.g.bookshelf__bookshelf_header_view__menu).setOnClickListener(new w(this));
        this.j = (LinearLayout) this.i.findViewById(com.duokan.c.g.bookshelf__bookshelf_header_view__recent_books);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f = new x(this, getContext(), findViewById);
        this.f.b(this.f.getGridPaddingLeft(), 0, this.f.getGridPaddingRight(), this.f.getGridPaddingBottom());
        this.f.c(0, 0, 0, 0);
        this.f.setBackgroundColor(Color.parseColor("#ffffff"));
        this.f.setAdapter(this.e);
        this.f.setSeekEnabled(true);
        this.f.setVerticalSeekDrawable(getResources().getDrawable(f.general__shared__thumb_seek_vert));
        this.f.e(0, displayMetrics.heightPixels / 4, 0, displayMetrics.heightPixels / 4);
        this.f.setOnItemClickListener(new y(this));
        addView(this.f, new LayoutParams(-1, -1));
        this.k = new ImageView(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2, 53);
        layoutParams.topMargin = this.n;
        this.k.setOnClickListener(new z(this));
        addView(this.k, layoutParams);
        this.k.setVisibility(8);
        this.g = (ImageView) LayoutInflater.from(getContext()).inflate(h.bookshelf__nightmode_view, this, false);
        this.g.setOnClickListener(new aa(this));
        i();
        addView(this.g);
        View view = new View(getContext());
        view.setBackgroundColor(-1);
        addView(view, new LayoutParams(-1, pageHeaderPaddingTop));
        this.f.setOnScrollListener(new i(this));
        this.c.a((cw) this);
    }

    private void j() {
        switch (PersonalPrefs.a().l()) {
            case 1:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_1);
                return;
            case 2:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_2);
                return;
            case 3:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_3);
                return;
            case 4:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_4);
                return;
            case 5:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_5);
                return;
            case 6:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_6);
                return;
            case 7:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_7);
                return;
            default:
                this.k.setImageResource(f.bookshelf__bar_view__sign_in_1);
                return;
        }
    }

    public void setHeaderViewEnable(boolean z) {
        if (this.h != null) {
            this.h.setEnabled(z);
        }
    }

    public void a(boolean z, int i, Runnable runnable) {
        if (i == 3) {
            this.k.setImageResource(f.bookshelf__bar_view__lottery);
            this.k.setOnClickListener(new j(this));
        } else if (i == 2) {
            this.k.setImageResource(f.bookshelf__bar_view__resign_in);
            this.k.setOnClickListener(new k(this));
        } else {
            j();
            this.k.setOnClickListener(new l(this));
        }
        if (this.k.getVisibility() != 0) {
            if (z) {
                dv.b(this.k, runnable);
            }
            this.k.setVisibility(0);
        }
    }

    public void a(boolean z, Runnable runnable) {
        if (this.k.getVisibility() == 0) {
            if (z) {
                dv.c(this.k, runnable);
            }
            this.k.setVisibility(8);
        }
    }

    public int[] getVisibleItemIndices() {
        return this.f.getVisibleItemIndices();
    }

    public Rect a(int i) {
        Rect g = this.f.g(i);
        dv.b(g, this.f);
        return g;
    }

    public int getItemCount() {
        return this.e.b();
    }

    public View[] getItemViews() {
        return this.f.getItemViews();
    }

    public cz b(int i) {
        return (cz) this.f.a(i);
    }

    public cz getDraggingItemView() {
        View[] itemViews = getItemViews();
        for (int i = 0; i < itemViews.length; i++) {
            if (itemViews[i] instanceof cz) {
                cz czVar = (cz) itemViews[i];
                if (czVar != null && czVar.getItem() == this.e.e()) {
                    return czVar;
                }
            }
        }
        return null;
    }

    public an c(int i) {
        if (i < 0 || i >= this.e.c()) {
            return null;
        }
        return (an) this.e.d(i);
    }

    public void a(an anVar, boolean z) {
        this.e.a(anVar, z);
    }

    public void a(Rect rect) {
        rect.set(0, 0, this.f.getWidth(), this.f.getHeight());
        rect.top += this.f.getHatVisibleHeight();
        dv.b(rect, this.f);
    }

    public boolean c_() {
        return this.f.d();
    }

    public boolean d_() {
        return this.f.e();
    }

    public void a(int i, int i2) {
        this.f.scrollBy(i, i2);
        this.f.f();
    }

    public void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f.a(i, i2, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.f.getGridScrollY();
    }

    public boolean a(int i, cz czVar) {
        return (i + 1) % this.f.getNumColumns() == 0;
    }

    public void a(an anVar, int i) {
        this.e.a(anVar, i);
    }

    public void a(an anVar, an anVar2, int i) {
        this.e.a(anVar, anVar2, i);
    }

    public void a(aa aaVar, an anVar) {
        this.e.a(aaVar, anVar);
    }

    public void a(an anVar) {
        f();
        int b = this.e.b(anVar);
        if (b >= 0) {
            this.f.e(b);
        }
    }

    public void e() {
        if (this.m == null) {
            this.m = new m(this);
            dv.a((View) this, this.m);
            invalidate();
        }
    }

    public void f() {
        if (this.m != null) {
            try {
                this.m.call();
            } catch (Throwable th) {
            }
        }
    }

    private void k() {
        this.l.setVisibility(PersonalPrefs.a().w() ? 0 : 4);
    }

    public void g() {
        List d = this.b.d();
        if (!this.e.a(d)) {
            this.e.a(this.f.getNumColumns(), true);
            this.e.b(d);
            this.e.a(this.f.getNumColumns(), false);
        }
    }

    public int getItemsCount() {
        return this.e.c();
    }

    public HatGridView getContentView() {
        return this.f;
    }

    public void a() {
    }

    public void b() {
        this.b.a(new n(this));
    }

    public void a(String str) {
    }

    public void a(cu cuVar, boolean z) {
        this.e.h(0, this.e.c());
    }

    public void a(cu cuVar, List list) {
        an d = this.c.d();
        if (d != null) {
            this.e.a(d);
        } else {
            this.e.h(0, this.e.c());
        }
    }

    public void b(cu cuVar, List list) {
        an d = this.c.d();
        if (d != null) {
            this.e.a(d);
        } else {
            this.e.h(0, this.e.c());
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            ai.a().a((iu) this);
            kp.a().a((la) this);
            PersonalPrefs.a().a((hj) this);
            e();
            k();
            return;
        }
        ai.a().b((iu) this);
        kp.a().b((la) this);
        PersonalPrefs.a().b((hj) this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            ai.a().a((iu) this);
            kp.a().a((la) this);
            PersonalPrefs.a().a((hj) this);
            k();
            e();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ai.a().b((iu) this);
        kp.a().b((la) this);
        PersonalPrefs.a().b((hj) this);
    }

    protected View getEmptyView() {
        if (this.d == null) {
            this.d = LayoutInflater.from(getContext()).inflate(h.bookshelf__empty_view, null);
            this.d.findViewById(com.duokan.c.g.bookshelf__empty_view__go_to_store).setOnClickListener(new o(this));
        }
        return this.d;
    }

    private void a(aa aaVar, boolean z) {
        this.c.a(aaVar, z, null);
    }

    public void h() {
        if (this.h == null) {
            this.h = new hl(getContext(), this.b, new p(this));
            this.h.a(false);
            this.j.addView(this.h, 0);
        }
    }

    public void i() {
        if (this.a.inNightMode()) {
            this.g.setVisibility(0);
            this.g.setSelected(true);
            return;
        }
        this.g.setVisibility(4);
    }

    public void a(boolean z, boolean z2) {
        if (!com.duokan.reader.common.c.f.b().e()) {
            a(z, null);
        } else if (!PersonalPrefs.a().j()) {
            a(z, null);
        } else if (!i.f().a(MiAccount.class) && MiAccount.a(getContext()) && DkApp.get().getAutoLogin()) {
            a(z, null);
        } else if (!i.f().a(PersonalAccount.class)) {
            a(z, 1, null);
        } else if (!PersonalPrefs.a().k()[PersonalPrefs.a().l() - 1]) {
            a(z, 1, null);
        } else if (kp.a().a(PersonalPrefs.a().k(), PersonalPrefs.a().l()) != 0) {
            a(z, 2, null);
        } else if (PersonalPrefs.a().n()) {
            a(z, 3, null);
        } else {
            a(z, null);
        }
    }

    public void a(boolean[] zArr, int i, List list, boolean z, boolean z2, boolean z3, boolean z4, int i2, DkStoreAdInfo[] dkStoreAdInfoArr) {
        if (kp.a().b().size() <= 1) {
            e icVar = new ic(x.a(getContext()), zArr, i, list, z, z2, z3, z4, i2, dkStoreAdInfoArr);
            this.a.showPopup(icVar);
            dv.b(icVar.getContentView(), null);
        }
    }

    public void c() {
    }

    public void b(String str) {
    }

    public void d() {
        if (kp.a().b().size() <= 1) {
            kp.a().a(true);
        }
    }

    public void a(boolean z) {
        k();
    }
}
