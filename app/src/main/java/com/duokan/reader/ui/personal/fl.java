package com.duokan.reader.ui.personal;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.af;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.c.g;
import com.duokan.reader.common.h;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.aw;
import com.duokan.reader.domain.cloud.bc;
import com.duokan.reader.domain.cloud.bd;
import com.duokan.reader.domain.cloud.bk;
import com.duokan.reader.domain.cloud.bl;
import com.duokan.reader.domain.cloud.cr;
import com.duokan.reader.domain.cloud.ec;
import com.duokan.reader.domain.cloud.eu;
import com.duokan.reader.domain.cloud.gf;
import com.duokan.reader.domain.cloud.gj;
import com.duokan.reader.domain.cloud.gk;
import com.duokan.reader.domain.cloud.gl;
import com.duokan.reader.domain.cloud.hj;
import com.duokan.reader.domain.cloud.o;
import com.duokan.reader.ui.b.f;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bf;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.s;

import org.apache.http.HttpStatus;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class fl extends ActivatedController implements SystemUiConditioner, g, h, com.duokan.reader.domain.account.h, bc, bl, cr, ec, eu, com.duokan.reader.domain.cloud.fl, gk, hj, o, f {
    private final ReaderFeature a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    private final StorePageController b;
    private final LinearScrollView c;
    private final FrameLayout d;
    private final bf e;
    private final TextView f;
    private final TextView g;
    private final View h;
    private final TextView i;
    private final TextView j;
    private final View k;
    private final View l;
    private final TextView m;
    private final TextView n;
    private final TextView o;
    private final View p;
    private final ViewGroup q;
    private final TextView r;
    private final TextView s;
    private final OnClickListener t;
    private final View u;
    private final LinkedList v = new LinkedList();
    private final View w;
    private final View x;
    private final int y;
    private int z = 0;

    public fl(IFeature featrue) {
        super(featrue);
        setContentView(com.duokan.c.h.personal__personal_center_view);
        this.c = (LinearScrollView) findViewById(com.duokan.c.g.personal__account_summary_view__scroller);
        this.q = (ViewGroup) findViewById(com.duokan.c.g.personal__account_summary_view__task);
        this.b = new PersonalController$1(this, getContext());
        this.b.setHasTitle(false);
        addSubController(this.b);
        this.t = new gi(this);
        this.y = ((s) x.a(getContext()).queryFeature(s.class)).getTheme().getPageHeaderPaddingTop();
        this.z = this.y;
        View guVar = new gu(this, getContext());
        ((ViewGroup) getContentView()).addView(guVar, new LayoutParams(-1, this.y));
        this.c.setOnScrollListener(new gz(this, guVar));
        ClipDrawable clipDrawable = new ClipDrawable(getDrawable(com.duokan.c.f.personal__account_summary_view__account_background), 48, 2);
        this.d = new ha(this, getContext());
        this.d.setOnClickListener(this.t);
        this.d.setBackgroundDrawable(new hb(this, clipDrawable));
        this.c.addView(this.d, 0, new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(com.duokan.c.h.personal__personal_base_info, this.d, true);
        View findViewById = this.d.findViewById(com.duokan.c.g.personal__account_summary_view__header);
        if (findViewById.getPaddingTop() != this.y) {
            findViewById.setPadding(0, this.y, 0, 0);
        }
        findViewById = findViewById(com.duokan.c.g.personal__account_summary_view__avatar_container);
        findViewById.setBackgroundDrawable(new hc(this, findViewById));
        this.e = (bf) findViewById(com.duokan.c.g.personal__account_summary_view__avatar);
        this.f = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__mi_login_name);
        this.g = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__mi_signature);
        this.h = LayoutInflater.from(getContext()).inflate(com.duokan.c.h.personal__limited_info_view, null, false);
        this.i = (TextView) this.h.findViewById(com.duokan.c.g.personal__account_summary_view__limited_type);
        this.j = (TextView) this.h.findViewById(com.duokan.c.g.personal__account_summary_view__limited);
        this.x = findViewById(com.duokan.c.g.personal__account_summary_view__mi);
        this.x.setOnClickListener(new hd(this));
        this.w = findViewById(com.duokan.c.g.personal__account_summary_view__wechat);
        this.w.setOnClickListener(new hf(this));
        this.r = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__last_login_mi);
        this.s = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__last_login_wx);
        this.m = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__my_coupon);
        this.m.setOnClickListener(new fn(this));
        this.n = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__my_cash);
        this.n.setOnClickListener(new fp(this));
        this.o = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__my_reward);
        this.o.setOnClickListener(new fr(this));
        this.q.addView(this.b.getContentView(), new LinearLayout.LayoutParams(-1, -1));
        this.p = findViewById(com.duokan.c.g.personal__account_summary_view__add_fund);
        this.p.setOnClickListener(new ft(this));
        findViewById(com.duokan.c.g.personal__account_summary_view__my_wish).setOnClickListener(new fu(this));
        findViewById(com.duokan.c.g.personal__account_summary_view__my_read_books).setOnClickListener(new fw(this));
        this.u = findViewById(com.duokan.c.g.personal__account_summary_view__my_purchased);
        this.u.setOnClickListener(new fz(this));
        findViewById(com.duokan.c.g.personal__account_summary_view__my_shopping_cart).setOnClickListener(new gb(this));
        findViewById(com.duokan.c.g.personal__account_summary_view__my_book_list).setOnClickListener(new gd(this));
        findViewById(com.duokan.c.g.personal__account_summary_view__my_notes).setOnClickListener(new gf(this));
        this.k = findViewById(com.duokan.c.g.personal__account_summary_view__message_button);
        this.l = findViewById(com.duokan.c.g.personal__account_summary_view__settings);
        this.l.setOnClickListener(new gk(this));
        this.k.setOnClickListener(new gl(this));
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        i.f().b((com.duokan.reader.domain.account.h) this);
        aw.a().b((bc) this);
        com.duokan.reader.domain.cloud.h.a().b((o) this);
        d.c().b((f) this);
        com.duokan.reader.common.d.a().b((h) this);
        DkUserPurchasedBooksManager.a().b((cr) this);
        DkUserPurchasedFictionsManager.a().b((ec) this);
        DkUserReadBookManager.a().b((eu) this);
        bd.a().b((bl) this);
        gf.a().b((gk) this);
        DkUserReadingNotesManager.a().b((com.duokan.reader.domain.cloud.fl) this);
        com.duokan.reader.common.c.f.b().b(this);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
    }

    public void onActive(boolean z) {
        if (z) {
            aw.a().a((bc) this);
            i.f().a((com.duokan.reader.domain.account.h) this);
            com.duokan.reader.domain.cloud.h.a().a((o) this);
            d.c().a((f) this);
            com.duokan.reader.common.d.a().a((h) this);
            DkUserPurchasedBooksManager.a().a((cr) this);
            DkUserPurchasedFictionsManager.a().a((ec) this);
            DkUserReadBookManager.a().a((eu) this);
            bd.a().a((bl) this);
            gf.a().a((gk) this);
            DkUserReadingNotesManager.a().a((com.duokan.reader.domain.cloud.fl) this);
            com.duokan.reader.common.c.f.b().a((g) this);
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
        }
        if (this.a.getPageCount() <= 0) {
            if (!ReaderEnv.get().getShowPurchasedHint()) {
                activate(this.b);
            } else if (!v()) {
                u();
            }
            c(false);
            getContentView().findViewById(com.duokan.c.g.personal__account_summary_view__scroller).scrollTo(0, 0);
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
        }
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
        e(aVar);
        q();
        b(true);
        if (ReaderEnv.get().getShowPurchasedHint()) {
            u();
        } else if (this.b.isActive()) {
            this.b.wakeUp();
        } else {
            activate(this.b);
        }
    }

    public void c(a aVar) {
        if (((PersonalAccount) i.f().b(PersonalAccount.class)).i()) {
            e(null);
            c(0);
            d(0);
            e(0);
            g(0);
            h(0);
            q();
            a(new bk());
        } else {
            j();
        }
        this.b.wakeUp();
        b(true);
    }

    public void d(a aVar) {
        if (aVar != null && !aVar.i()) {
            e(aVar);
        }
    }

    public void onConnectivityChanged(com.duokan.reader.common.c.f fVar) {
        if (com.duokan.reader.common.c.f.b().e() && isActive() && this.a.getPageCount() <= 0) {
            c(false);
            this.b.wakeUp();
        }
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        this.b.refresh();
    }

    public void c() {
        l();
    }

    public void a() {
    }

    public void a(ReadBook[] readBookArr) {
        m();
    }

    public void b(ReadBook[] readBookArr) {
    }

    public void g() {
        m();
    }

    public void b(int i) {
        g(d.c().e());
    }

    public void a(int i) {
        h(i);
    }

    public void d() {
        n();
    }

    public void b() {
        n();
    }

    public void a(String[] strArr) {
        n();
    }

    public void a(List list) {
    }

    public void e() {
        n();
    }

    public void b(String[] strArr) {
        n();
    }

    public void b(List list) {
    }

    public void f() {
        k();
    }

    public void a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        k();
    }

    public void a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        k();
    }

    public void a(gl glVar) {
        o();
    }

    public void a(bk bkVar) {
        b(bkVar);
    }

    public void a(boolean z) {
        e(z);
    }

    public void chooseStatusBarStyle(af afVar) {
        if (!isActive()) {
            return;
        }
        if (this.z < this.y) {
            afVar.a(Boolean.valueOf(true));
        } else {
            afVar.a(Boolean.valueOf(false));
        }
    }

    public void chooseNavigationBarMode(af afVar) {
    }

    public void chooseNavigationBarColor(af afVar) {
    }

    public void h() {
        if (ReaderEnv.get().getShowPurchasedHint()) {
            u();
        } else {
            activate(this.b);
        }
    }

    private void b(boolean z) {
        if (this.v.size() <= 0 || z) {
            Iterator it = this.v.iterator();
            while (it.hasNext()) {
                ((r) it.next()).close();
            }
            t();
            s();
            r();
        }
    }

    private void j() {
        k();
        l();
        m();
        n();
        o();
        p();
        b(d.c().e());
        a(com.duokan.reader.common.d.a().b());
        a(bd.a().b());
        e(i.f().b(PersonalAccount.class));
    }

    private void c(boolean z) {
        b(z);
        bd.a().c();
        j();
    }

    private void k() {
        c((int) DkUserReadingNotesManager.a().b());
    }

    private void l() {
        d(aw.a().b());
    }

    private void m() {
        e((int) com.duokan.reader.domain.cloud.h.a().c());
    }

    private void n() {
        f(DkUserPurchasedBooksManager.a().b().size() + DkUserPurchasedFictionsManager.a().b().size());
    }

    private void o() {
        d(!(gf.a().b() instanceof gj));
    }

    private void p() {
        e(PersonalPrefs.a().w());
    }

    private void a(TextView textView, int i, boolean z) {
        if ((z || i.f().b()) && i > 0) {
            textView.setVisibility(0);
            textView.setText(String.valueOf(i));
            return;
        }
        textView.setVisibility(4);
    }

    private void a(boolean z, Callable callable) {
        if (((PersonalAccount) i.f().b(PersonalAccount.class)).i()) {
            c(z, callable);
            return;
        }
        try {
            a((ActivatedController) callable.call(), z, null);
        } catch (Throwable th) {
        }
    }

    private void b(boolean z, Callable callable) {
        try {
            a((ActivatedController) callable.call(), z, null);
        } catch (Throwable th) {
        }
    }

    private void c(boolean z, Callable callable) {
        i.f().a(new gm(this, callable, z));
    }

    private void a(ActivatedController activatedControllerVar, boolean z, Runnable runnable) {
        if (activatedControllerVar != null) {
            activatedControllerVar.runBeforeDetach(new gn(this));
            deactivate(this.b);
            if (z) {
                this.a.pushHalfPageSmoothly(activatedControllerVar, runnable);
            } else {
                this.a.pushPageSmoothly(activatedControllerVar, runnable);
            }
        }
    }

    private void e(a aVar) {
        View findViewById = findViewById(com.duokan.c.g.personal__account_summary_view__no_account);
        View findViewById2 = findViewById(com.duokan.c.g.personal__account_summary_view__mi_account);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(com.duokan.c.g.personal__account_summary_view__mi_account_info);
        ViewGroup viewGroup2 = (ViewGroup) findViewById.findViewById(com.duokan.c.g.personal__account_summary_view__no_account_info);
        TextView textView = (TextView) this.u.findViewById(com.duokan.c.g.personal__account_summary_view__my_purchased_label);
        switch (gy.a[(aVar == null ? AccountType.NONE : aVar.e()).ordinal()]) {
            case 1:
            case 2:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                viewGroup2.removeView(this.h);
                if (this.h.getParent() == null) {
                    viewGroup.addView(this.h);
                }
                this.k.setVisibility(0);
                CharSequence c = ((PersonalAccount) i.f().b(PersonalAccount.class)).c();
                CharSequence a = aVar.f().a();
                CharSequence b = aVar.f().b();
                if (TextUtils.isEmpty(a) || c.equals(a)) {
                    this.f.setText(c);
                } else {
                    this.f.setText(a);
                }
                if (TextUtils.isEmpty(b)) {
                    this.g.setText(getResources().getString(j.personal__account_summary_view__no_signature));
                } else {
                    this.g.setText(b);
                }
                this.d.setOnClickListener(this.t);
                textView.setText(j.personal__account_summary_view__my_purchased_and_cloud);
                this.e.setMiAccount(aVar);
                return;
            default:
                findViewById.setVisibility(0);
                findViewById2.setVisibility(8);
                viewGroup.removeView(this.h);
                if (this.h.getParent() == null) {
                    viewGroup2.addView(this.h);
                }
                TextView textView2 = (TextView) findViewById(com.duokan.c.g.personal__account_summary_view__login_tip);
                if (ThirdWeiXin.isWeiXinInstalled(getContext())) {
                    this.w.setVisibility(0);
                    this.r.setVisibility(8);
                    this.s.setVisibility(8);
                    if (TextUtils.equals("WX_LOGIN", i.f().k())) {
                        this.s.setVisibility(0);
                    } else {
                        this.r.setVisibility(0);
                        if (TextUtils.equals("MI_LOCAL", i.f().k()) || TextUtils.equals("MI_SYSTEM", i.f().k())) {
                            this.r.setText(getString(j.personal__account_summary_view__last_login));
                        } else {
                            this.r.setText(getString(j.personal__account_summary_view__click_login));
                        }
                    }
                    textView2.setTextSize(12.0f);
                    textView2.setText(getString(j.personal__account_summary_view__login_tip));
                } else {
                    this.w.setVisibility(8);
                    this.s.setVisibility(8);
                    this.r.setText(getString(j.personal__account_summary_view__click_login));
                    textView2.setTextSize(14.0f);
                    textView2.setText(getString(j.personal__account_summary_view__login_and_sync));
                }
                this.k.setVisibility(0);
                this.d.setOnClickListener(null);
                textView.setText(j.personal__account_summary_view__my_purchased);
                this.e.a();
                return;
        }
    }

    private void c(int i) {
        a((TextView) findViewById(com.duokan.c.g.personal__account_summary_view__notes_count), i, false);
    }

    private void d(int i) {
        a((TextView) findViewById(com.duokan.c.g.personal__account_summary_view__wish_count), i, false);
    }

    private void e(int i) {
        a((TextView) findViewById(com.duokan.c.g.personal__account_summary_view__read_books_count), i, false);
    }

    private void f(int i) {
        a((TextView) findViewById(com.duokan.c.g.personal__account_summary_view__purchased_count), i, true);
    }

    private void d(boolean z) {
        findViewById(com.duokan.c.g.personal__account_summary_view__shopping_cart_dot).setVisibility(z ? 0 : 4);
    }

    private void e(boolean z) {
        findViewById(com.duokan.c.g.personal__account_summary_view__purchased_dot).setVisibility(z ? 0 : 4);
    }

    private void q() {
        if (i.f().a(PersonalAccount.class)) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
    }

    private void a(ActivatedController activatedControllerVar, Runnable runnable) {
        UmengManager.get().onEvent("V2_PERSONAL_HEADER_BUTTON", "Settings");
        if (activatedControllerVar == null) {
            activatedControllerVar = new it(getContext());
        }
        a(activatedControllerVar, true, runnable);
    }

    private void g(int i) {
        ((ImageView) this.k.findViewById(com.duokan.c.g.personal__account_summary_view__unread_message_count_image)).setVisibility(i > 0 ? 0 : 4);
    }

    private void h(int i) {
        ((ImageView) this.l.findViewById(com.duokan.c.g.personal__account_summary_view__unread_feedback_count_image)).setVisibility(i > 0 ? 0 : 4);
    }

    private void f(boolean z) {
        a(new ck(getContext(), false), true, null);
    }

    private void g(boolean z) {
        a(new ck(getContext(), true), true, null);
    }

    private void b(bk bkVar) {
        long currentTimeMillis = System.currentTimeMillis();
        int a = bkVar.a(currentTimeMillis);
        if (a == 0) {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        CharSequence a2 = a(bkVar, currentTimeMillis);
        if (a > 1) {
            a2 = a2 + "  " + getString(j.personal__account_summary_view__privilege_more);
            this.i.setVisibility(0);
            this.i.setText(b(bkVar, currentTimeMillis));
            this.j.setOnClickListener(new go(this, bkVar, currentTimeMillis));
        } else {
            this.i.setVisibility(8);
        }
        this.j.setVisibility(0);
        this.j.setText(a2);
    }

    private String a(bk bkVar, long j) {
        if (bkVar.b > j) {
            return a(j.personal__account_summary_view__serial_privilege_reminder, bkVar.b - j);
        }
        if (bkVar.a > j) {
            return a(j.personal__account_summary_view__pub_privilege_reminder, bkVar.a - j);
        }
        return a(j.personal__account_summary_view__comic_privilege_reminder, bkVar.c - j);
    }

    private String b(bk bkVar, long j) {
        if (bkVar.a(j) == 3) {
            return getString(j.personal__account_summary_view__all_privilege);
        }
        if (bkVar.b > j && bkVar.a > j) {
            return getString(j.personal__account_summary_view__serial_pub_privilege);
        }
        if (bkVar.b > j && bkVar.c > j) {
            return getString(j.personal__account_summary_view__serial_comic_privilege);
        }
        if (bkVar.a <= j || bkVar.c <= j) {
            return "";
        }
        return getString(j.personal__account_summary_view__pub_comic_privilege);
    }

    private String a(int i, long j) {
        Object obj = "";
        if (j > 0) {
            if (j < 60000) {
                obj = getContext().getString(j.personal__account_summary_view__privilege_1min);
            } else {
                long j2 = j / 86400000;
                obj = ReaderUi.b(getContext(), j);
                if (j2 > 0) {
                    j2 = j - (j2 * 86400000);
                    if (j2 > 3600000) {
                        obj = obj + ReaderUi.b(getContext(), j2);
                    }
                }
            }
        }
        if (TextUtils.isEmpty(obj)) {
            return obj;
        }
        return String.format(getString(i), new Object[]{obj});
    }

    private String c(bk bkVar, long j) {
        String str = "";
        Object a = a(j.personal__account_summary_view__serial_privilege_reminder, bkVar.b - j);
        Object a2 = a(j.personal__account_summary_view__pub_privilege_reminder, bkVar.a - j);
        Object a3 = a(j.personal__account_summary_view__comic_privilege_reminder, bkVar.c - j);
        if (!TextUtils.isEmpty(a)) {
            str = str + a + "\n\n";
        }
        if (!TextUtils.isEmpty(a2)) {
            str = str + a2;
            if (!TextUtils.isEmpty(a3)) {
                str = str + "\n\n";
            }
        }
        if (TextUtils.isEmpty(a3)) {
            return str;
        }
        return str + a3;
    }

    private void r() {
        if (i.f().a(PersonalAccount.class)) {
            new gp(this).open();
        } else {
            this.o.setText(getString(j.personal__account_summary_view__my_reward) + 0);
        }
    }

    private void s() {
        if (i.f().a(PersonalAccount.class)) {
            new gq(this).open();
        } else {
            this.n.setText(getString(j.personal__account_summary_view__my_cash) + 0);
        }
    }

    private void t() {
        if (i.f().a(PersonalAccount.class)) {
            new gr(this).open();
        } else {
            this.m.setText(getString(j.personal__account_summary_view__my_coupon) + 0);
        }
    }

    public void i() {
        this.c.a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }

    private void u() {
        UTools.addAnimation(getContentView(), new gs(this));
    }

    private boolean v() {
        MiAccount miAccount = (MiAccount) i.f().b(MiAccount.class);
        if ((miAccount == null || miAccount.i()) && DkApp.get().getAutoLogin() && MiAccount.a(getContext())) {
            return true;
        }
        return false;
    }

    private void a(String str) {
        com.duokan.reader.domain.statistics.a.k().b("personal_center", "click", str);
    }

    private void a(Rect rect) {
        ActivatedController gtVar = new gt(this, getContext());
        View gvVar = new gv(this, getContext());
        View imageView = new ImageView(getContext());
        View imageView2 = new ImageView(getContext());
        View gwVar = new gw(this, getContext(), gvVar, rect, imageView, imageView2);
        gwVar.setBackgroundColor(Color.argb(179, 0, 0, 0));
        gwVar.addView(gvVar, new ViewGroup.LayoutParams(-1, rect.height()));
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(com.duokan.c.f.personal__purchased_view__hint_arrow);
        gwVar.addView(imageView, new ViewGroup.LayoutParams(-2, -2));
        imageView2.setScaleType(ScaleType.CENTER);
        imageView2.setImageResource(com.duokan.c.f.personal__purchased_view__hint_text);
        gwVar.addView(imageView2, new ViewGroup.LayoutParams(-2, -2));
        gwVar.setOnClickListener(new gx(this, gtVar));
        gtVar.setContentView(gwVar);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).showPopup(gtVar);
    }
}
