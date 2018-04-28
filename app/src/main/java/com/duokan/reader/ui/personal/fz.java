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
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.af;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.SystemUiConditioner;
import com.duokan.reader.SystemUiMode;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.C0590d;
import com.duokan.reader.common.C0610h;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0562i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.domain.cloud.C0848h;
import com.duokan.reader.domain.cloud.C0854n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.ap;
import com.duokan.reader.domain.cloud.au;
import com.duokan.reader.domain.cloud.av;
import com.duokan.reader.domain.cloud.bb;
import com.duokan.reader.domain.cloud.bc;
import com.duokan.reader.domain.cloud.cf;
import com.duokan.reader.domain.cloud.dn;
import com.duokan.reader.domain.cloud.ed;
import com.duokan.reader.domain.cloud.et;
import com.duokan.reader.domain.cloud.fl;
import com.duokan.reader.domain.cloud.fp;
import com.duokan.reader.domain.cloud.fq;
import com.duokan.reader.domain.cloud.fr;
import com.duokan.reader.domain.cloud.gp;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bf;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.p051b.C1278d;
import com.duokan.reader.ui.p051b.C1280f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.http.HttpStatus;

public class fz extends ActivatedController implements SystemUiConditioner, C0562i, C0610h, C0586j, au, bc, cf, dn, ed, et, fq, gp, C0854n, C1280f {
    /* renamed from: a */
    private final ReaderFeature f8574a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    /* renamed from: b */
    private final StorePageController f8575b;
    /* renamed from: c */
    private final LinearScrollView f8576c;
    /* renamed from: d */
    private final FrameLayout f8577d;
    /* renamed from: e */
    private final bf f8578e;
    /* renamed from: f */
    private final TextView f8579f;
    /* renamed from: g */
    private final TextView f8580g;
    /* renamed from: h */
    private final View f8581h;
    /* renamed from: i */
    private final TextView f8582i;
    /* renamed from: j */
    private final TextView f8583j;
    /* renamed from: k */
    private final View f8584k;
    /* renamed from: l */
    private final View f8585l;
    /* renamed from: m */
    private final TextView f8586m;
    /* renamed from: n */
    private final TextView f8587n;
    /* renamed from: o */
    private final TextView f8588o;
    /* renamed from: p */
    private final ViewGroup f8589p;
    /* renamed from: q */
    private final TextView f8590q;
    /* renamed from: r */
    private final TextView f8591r;
    /* renamed from: s */
    private final OnClickListener f8592s;
    /* renamed from: t */
    private final View f8593t;
    /* renamed from: u */
    private final LinkedList<WebSession> f8594u = new LinkedList();
    /* renamed from: v */
    private final View f8595v;
    /* renamed from: w */
    private final View f8596w;
    /* renamed from: x */
    private final int f8597x;
    /* renamed from: y */
    private String f8598y = "";
    /* renamed from: z */
    private int f8599z = 0;

    public fz(IFeature mFeature) {
        super(mFeature);
        setContentView(C0256h.personal__personal_center_view);
        this.f8576c = (LinearScrollView) findViewById(C0255g.personal__account_summary_view__scroller);
        this.f8589p = (ViewGroup) findViewById(C0255g.personal__account_summary_view__task);
        this.f8575b = new PersonalController$1(this, getContext());
        this.f8575b.setHasTitle(false);
        addSubController(this.f8575b);
        this.f8592s = new gw(this);
        this.f8597x = ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderPaddingTop();
        this.f8599z = this.f8597x;
        View hiVar = new hi(this, getContext());
        ((ViewGroup) getContentView()).addView(hiVar, new LayoutParams(-1, this.f8597x));
        this.f8576c.setOnScrollListener(new hm(this, hiVar));
        ClipDrawable clipDrawable = new ClipDrawable(getDrawable(C0254f.personal__account_summary_view__account_background), 48, 2);
        this.f8577d = new hn(this, getContext());
        this.f8577d.setOnClickListener(this.f8592s);
        this.f8577d.setBackgroundDrawable(new ho(this, clipDrawable));
        this.f8576c.addView(this.f8577d, 0, new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(C0256h.personal__personal_base_info, this.f8577d, true);
        View findViewById = this.f8577d.findViewById(C0255g.personal__account_summary_view__header);
        if (findViewById.getPaddingTop() != this.f8597x) {
            findViewById.setPadding(0, this.f8597x, 0, 0);
        }
        findViewById = findViewById(C0255g.personal__account_summary_view__avatar_container);
        findViewById.setBackgroundDrawable(new hp(this, findViewById));
        this.f8578e = (bf) findViewById(C0255g.personal__account_summary_view__avatar);
        this.f8579f = (TextView) findViewById(C0255g.personal__account_summary_view__mi_login_name);
        this.f8580g = (TextView) findViewById(C0255g.personal__account_summary_view__mi_signature);
        this.f8581h = LayoutInflater.from(getContext()).inflate(C0256h.personal__limited_info_view, null, false);
        this.f8582i = (TextView) this.f8581h.findViewById(C0255g.personal__account_summary_view__limited_type);
        this.f8583j = (TextView) this.f8581h.findViewById(C0255g.personal__account_summary_view__limited);
        this.f8596w = findViewById(C0255g.personal__account_summary_view__mi);
        this.f8596w.setOnClickListener(new hq(this));
        this.f8595v = findViewById(C0255g.personal__account_summary_view__wechat);
        this.f8595v.setOnClickListener(new hs(this));
        this.f8590q = (TextView) findViewById(C0255g.personal__account_summary_view__last_login_mi);
        this.f8591r = (TextView) findViewById(C0255g.personal__account_summary_view__last_login_wx);
        this.f8586m = (TextView) findViewById(C0255g.personal__account_summary_view__my_coupon);
        this.f8586m.setOnClickListener(new gb(this));
        this.f8587n = (TextView) findViewById(C0255g.personal__account_summary_view__my_cash);
        this.f8587n.setOnClickListener(new gd(this));
        this.f8588o = (TextView) findViewById(C0255g.personal__account_summary_view__my_reward);
        this.f8588o.setOnClickListener(new gf(this));
        this.f8589p.addView(this.f8575b.getContentView(), new LinearLayout.LayoutParams(-1, -1));
        findViewById(C0255g.personal__account_summary_view__my_wish).setOnClickListener(new gh(this));
        findViewById(C0255g.personal__account_summary_view__my_read_books).setOnClickListener(new gj(this));
        this.f8593t = findViewById(C0255g.personal__account_summary_view__my_purchased);
        this.f8593t.setOnClickListener(new gm(this));
        findViewById(C0255g.personal__account_summary_view__my_shopping_cart).setOnClickListener(new go(this));
        findViewById(C0255g.personal__account_summary_view__my_book_list).setOnClickListener(new gq(this));
        findViewById(C0255g.personal__account_summary_view__my_notes).setOnClickListener(new gs(this));
        this.f8584k = findViewById(C0255g.personal__account_summary_view__message_button);
        this.f8585l = findViewById(C0255g.personal__account_summary_view__settings);
        this.f8585l.setOnClickListener(new gv(this));
        this.f8584k.setOnClickListener(new gy(this));
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C0709k.m3476a().m3505b((C0586j) this);
        ap.m5294a().m5308b((au) this);
        C0848h.m5604a().m5623b((C0854n) this);
        C1278d.m9042c().m9051b((C1280f) this);
        C0590d.m2643a().m2655b((C0610h) this);
        DkUserPurchasedBooksManager.m5029a().m5065b((cf) this);
        DkUserPurchasedFictionsManager.m5072a().m5104b((dn) this);
        DkUserReadBookManager.m5115a().m5132b((ed) this);
        av.m5316a().m5335b((bc) this);
        fl.m5554a().m5563b((fq) this);
        DkUserReadingNotesManager.m5136a().m5157b((et) this);
        C0559f.m2476b().m2482b((C0562i) this);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).removeSystemUiConditioner(this);
        Iterator it = this.f8594u.iterator();
        while (it.hasNext()) {
            ((WebSession) it.next()).close();
        }
    }

    public void onActive(boolean z) {
        if (z) {
            ap.m5294a().m5306a((au) this);
            C0709k.m3476a().m3494a((C0586j) this);
            C0848h.m5604a().m5618a((C0854n) this);
            C1278d.m9042c().m9049a((C1280f) this);
            C0590d.m2643a().m2652a((C0610h) this);
            DkUserPurchasedBooksManager.m5029a().m5056a((cf) this);
            DkUserPurchasedFictionsManager.m5072a().m5096a((dn) this);
            DkUserReadBookManager.m5115a().m5129a((ed) this);
            av.m5316a().m5333a((bc) this);
            fl.m5554a().m5561a((fq) this);
            DkUserReadingNotesManager.m5136a().m5152a((et) this);
            C0559f.m2476b().m2480a((C0562i) this);
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).addSystemUiConditioner(this);
        }
        if (this.f8574a.getPageCount() <= 0) {
            if (!ReaderEnv.get().getShowPurchasedHint()) {
                activate(this.f8575b);
            } else if (!m11903u()) {
                m11902t();
            }
            m11868c(false);
            getContentView().findViewById(C0255g.personal__account_summary_view__scroller).scrollTo(0, 0);
            ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
        }
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m11847a(c0672a);
        m11854a(true);
        if (ReaderEnv.get().getShowPurchasedHint()) {
            m11902t();
        } else if (this.f8575b.isActive()) {
            this.f8575b.wakeUp();
        } else {
            activate(this.f8575b);
        }
    }

    public void onAccountLogoff(C0672a c0672a) {
        if (((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo839i()) {
            m11847a(null);
            m11865c(0);
            m11871d(0);
            m11875e(0);
            m11880g(0);
            m11883h(0);
            mo1914a(new bb());
        } else {
            m11887j();
        }
        this.f8575b.wakeUp();
        m11854a(true);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
        if (c0672a != null && !c0672a.mo839i()) {
            m11847a(c0672a);
        }
    }

    /* renamed from: a */
    public void mo949a(C0559f c0559f) {
        if (C0559f.m2476b().m2486e() && isActive() && this.f8574a.getPageCount() <= 0) {
            m11868c(false);
            this.f8575b.wakeUp();
        }
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
        this.f8575b.refresh();
    }

    /* renamed from: c */
    public void mo1919c() {
        m11891l();
    }

    /* renamed from: a */
    public void mo1913a() {
    }

    /* renamed from: a */
    public void mo1916a(ReadBook[] readBookArr) {
        m11893m();
    }

    /* renamed from: b */
    public void mo1918b(ReadBook[] readBookArr) {
    }

    /* renamed from: g */
    public void mo1920g() {
        m11893m();
    }

    /* renamed from: b */
    public void mo1917b(int i) {
        m11880g(C1278d.m9042c().m9053e());
    }

    /* renamed from: a */
    public void mo1595a(int i) {
        m11883h(i);
    }

    /* renamed from: d */
    public void mo965d() {
        m11895n();
    }

    /* renamed from: b */
    public void mo962b() {
        m11895n();
    }

    /* renamed from: a */
    public void mo961a(String[] strArr) {
        m11895n();
    }

    /* renamed from: a */
    public void mo960a(List<DkCloudStoreBook> list) {
    }

    /* renamed from: e */
    public void mo966e() {
        m11895n();
    }

    /* renamed from: b */
    public void mo964b(String[] strArr) {
        m11895n();
    }

    /* renamed from: b */
    public void mo963b(List<DkCloudStoreBook> list) {
    }

    /* renamed from: f */
    public void mo967f() {
        m11889k();
    }

    /* renamed from: a */
    public void mo958a(DkCloudNoteBookInfo dkCloudNoteBookInfo) {
        m11889k();
    }

    /* renamed from: a */
    public void mo959a(String str, DkCloudAnnotation[] dkCloudAnnotationArr) {
        m11889k();
    }

    /* renamed from: a */
    public void mo1915a(fr frVar) {
        m11897o();
    }

    /* renamed from: a */
    public void mo1914a(bb bbVar) {
        m11858b(bbVar);
    }

    /* renamed from: b */
    public void mo1707b(boolean z) {
        m11876e(z);
    }

    public void chooseStatusBarStyle(af<Boolean> afVar) {
        if (!isActive()) {
            return;
        }
        if (this.f8599z < this.f8597x) {
            afVar.mo975a(Boolean.valueOf(true));
        } else {
            afVar.mo975a(Boolean.valueOf(false));
        }
    }

    public void chooseNavigationBarMode(af<SystemUiMode> afVar) {
    }

    public void chooseNavigationBarColor(af<Integer> afVar) {
    }

    /* renamed from: h */
    public void m11925h() {
        if (ReaderEnv.get().getShowPurchasedHint()) {
            m11902t();
        } else {
            activate(this.f8575b);
        }
    }

    /* renamed from: a */
    private void m11854a(boolean z) {
        if (this.f8594u.size() <= 0 || z) {
            Iterator it = this.f8594u.iterator();
            while (it.hasNext()) {
                ((WebSession) it.next()).close();
            }
            m11901s();
            m11900r();
            m11899q();
        }
    }

    /* renamed from: j */
    private void m11887j() {
        m11889k();
        m11891l();
        m11893m();
        m11895n();
        m11897o();
        m11898p();
        mo1917b(C1278d.m9042c().m9053e());
        mo1595a(C0590d.m2643a().m2654b());
        mo1914a(av.m5316a().m5334b());
        m11847a(C0709k.m3476a().m3502b(PersonalAccount.class));
    }

    /* renamed from: c */
    private void m11868c(boolean z) {
        m11854a(z);
        av.m5316a().m5336c();
        m11887j();
    }

    /* renamed from: k */
    private void m11889k() {
        m11865c((int) DkUserReadingNotesManager.m5136a().m5156b());
    }

    /* renamed from: l */
    private void m11891l() {
        m11871d(ap.m5294a().m5307b());
    }

    /* renamed from: m */
    private void m11893m() {
        m11875e((int) C0848h.m5604a().m5624c());
    }

    /* renamed from: n */
    private void m11895n() {
        m11878f(DkUserPurchasedBooksManager.m5029a().m5063b().size() + DkUserPurchasedFictionsManager.m5072a().m5102b().size());
    }

    /* renamed from: o */
    private void m11897o() {
        m11873d(!(fl.m5554a().m5562b() instanceof fp));
    }

    /* renamed from: p */
    private void m11898p() {
        m11876e(PersonalPrefs.m5175a().m5248x());
    }

    /* renamed from: a */
    private void m11844a(TextView textView, int i, boolean z) {
        if ((z || C0709k.m3476a().m3507c()) && i > 0) {
            textView.setVisibility(0);
            textView.setText(String.valueOf(i));
            return;
        }
        textView.setVisibility(4);
    }

    /* renamed from: a */
    private void m11855a(boolean z, Callable<ActivatedController> callable) {
        if (((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo839i()) {
            m11869c(z, (Callable) callable);
            return;
        }
        try {
            m11846a((ActivatedController) callable.call(), z, null);
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    private void m11862b(boolean z, Callable<ActivatedController> callable) {
        try {
            m11846a((ActivatedController) callable.call(), z, null);
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    private void m11869c(boolean z, Callable<ActivatedController> callable) {
        C0709k.m3476a().m3495a(new gz(this, callable, z));
    }

    /* renamed from: a */
    private void m11846a(ActivatedController c0303e, boolean z, Runnable runnable) {
        if (c0303e != null) {
            c0303e.runBeforeDetach(new ha(this));
            deactivate(this.f8575b);
            if (z) {
                this.f8574a.pushHalfPageSmoothly(c0303e, runnable);
            } else {
                this.f8574a.pushPageSmoothly(c0303e, runnable);
            }
        }
    }

    /* renamed from: a */
    private void m11847a(C0672a c0672a) {
        View findViewById = findViewById(C0255g.personal__account_summary_view__no_account);
        View findViewById2 = findViewById(C0255g.personal__account_summary_view__mi_account);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(C0255g.personal__account_summary_view__mi_account_info);
        ViewGroup viewGroup2 = (ViewGroup) findViewById.findViewById(C0255g.personal__account_summary_view__no_account_info);
        TextView textView = (TextView) this.f8593t.findViewById(C0255g.personal__account_summary_view__my_purchased_label);
        switch (hl.f8660a[(c0672a == null ? AccountType.NONE : c0672a.mo835e()).ordinal()]) {
            case 1:
            case 2:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                viewGroup2.removeView(this.f8581h);
                if (this.f8581h.getParent() == null) {
                    viewGroup.addView(this.f8581h);
                }
                this.f8584k.setVisibility(0);
                CharSequence c = ((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)).mo833c();
                CharSequence a = c0672a.mo836f().mo871a();
                CharSequence b = c0672a.mo836f().mo872b();
                if (TextUtils.isEmpty(a) || c.equals(a)) {
                    this.f8579f.setText(c);
                } else {
                    this.f8579f.setText(a);
                }
                if (TextUtils.isEmpty(b)) {
                    this.f8580g.setText(getResources().getString(C0258j.personal__account_summary_view__no_signature));
                } else {
                    this.f8580g.setText(b);
                }
                this.f8577d.setOnClickListener(this.f8592s);
                textView.setText(C0258j.personal__account_summary_view__my_purchased_and_cloud);
                this.f8578e.setMiAccount(c0672a);
                return;
            default:
                findViewById.setVisibility(0);
                findViewById2.setVisibility(8);
                viewGroup.removeView(this.f8581h);
                if (this.f8581h.getParent() == null) {
                    viewGroup2.addView(this.f8581h);
                }
                TextView textView2 = (TextView) findViewById(C0255g.personal__account_summary_view__login_tip);
                if (ThirdWeiXin.isWeiXinInstalled(getContext())) {
                    this.f8595v.setVisibility(0);
                    this.f8590q.setVisibility(8);
                    this.f8591r.setVisibility(8);
                    if (TextUtils.equals("WX_LOGIN", C0709k.m3476a().m3516k())) {
                        this.f8591r.setVisibility(0);
                    } else {
                        this.f8590q.setVisibility(0);
                        if (TextUtils.equals("MI_LOCAL", C0709k.m3476a().m3516k()) || TextUtils.equals("MI_SYSTEM", C0709k.m3476a().m3516k())) {
                            this.f8590q.setText(getString(C0258j.personal__account_summary_view__last_login));
                        } else {
                            this.f8590q.setText(getString(C0258j.personal__account_summary_view__click_login));
                        }
                    }
                    textView2.setTextSize(12.0f);
                    textView2.setText(getString(C0258j.personal__account_summary_view__login_tip));
                } else {
                    this.f8595v.setVisibility(8);
                    this.f8591r.setVisibility(8);
                    this.f8590q.setText(getString(C0258j.personal__account_summary_view__click_login));
                    textView2.setTextSize(14.0f);
                    textView2.setText(getString(C0258j.personal__account_summary_view__login_and_sync));
                }
                this.f8584k.setVisibility(0);
                this.f8577d.setOnClickListener(null);
                textView.setText(C0258j.personal__account_summary_view__my_purchased);
                this.f8578e.m9930a();
                return;
        }
    }

    /* renamed from: c */
    private void m11865c(int i) {
        m11844a((TextView) findViewById(C0255g.personal__account_summary_view__notes_count), i, false);
    }

    /* renamed from: d */
    private void m11871d(int i) {
        m11844a((TextView) findViewById(C0255g.personal__account_summary_view__wish_count), i, false);
    }

    /* renamed from: e */
    private void m11875e(int i) {
        m11844a((TextView) findViewById(C0255g.personal__account_summary_view__read_books_count), i, false);
    }

    /* renamed from: f */
    private void m11878f(int i) {
        m11844a((TextView) findViewById(C0255g.personal__account_summary_view__purchased_count), i, true);
    }

    /* renamed from: d */
    private void m11873d(boolean z) {
        findViewById(C0255g.personal__account_summary_view__shopping_cart_dot).setVisibility(z ? 0 : 4);
    }

    /* renamed from: e */
    private void m11876e(boolean z) {
        findViewById(C0255g.personal__account_summary_view__purchased_dot).setVisibility(z ? 0 : 4);
    }

    /* renamed from: a */
    private void m11845a(ActivatedController c0303e, Runnable runnable) {
        UmengManager.get().onEvent("V2_PERSONAL_HEADER_BUTTON", "Settings");
        if (c0303e == null) {
            c0303e = new jg(getContext());
        }
        m11846a(c0303e, true, runnable);
    }

    /* renamed from: g */
    private void m11880g(int i) {
        ((ImageView) this.f8584k.findViewById(C0255g.personal__account_summary_view__unread_message_count_image)).setVisibility(i > 0 ? 0 : 4);
    }

    /* renamed from: h */
    private void m11883h(int i) {
        ((ImageView) this.f8585l.findViewById(C0255g.personal__account_summary_view__unread_feedback_count_image)).setVisibility(i > 0 ? 0 : 4);
    }

    /* renamed from: f */
    private void m11879f(boolean z) {
        m11846a(new cd(getContext(), false), true, null);
    }

    /* renamed from: g */
    private void m11881g(boolean z) {
        m11846a(new cd(getContext(), true), true, null);
    }

    /* renamed from: b */
    private void m11858b(bb bbVar) {
        long currentTimeMillis = System.currentTimeMillis();
        int a = bbVar.m5342a(currentTimeMillis);
        if (a == 0) {
            this.f8582i.setVisibility(8);
            this.f8583j.setVisibility(8);
            return;
        }
        CharSequence a2 = m11840a(bbVar, currentTimeMillis);
        if (a > 1) {
            a2 = a2 + "  " + getString(C0258j.personal__account_summary_view__privilege_more);
            this.f8582i.setVisibility(0);
            this.f8582i.setText(m11856b(bbVar, currentTimeMillis));
            this.f8583j.setOnClickListener(new hb(this, bbVar, currentTimeMillis));
        } else {
            this.f8582i.setVisibility(8);
        }
        this.f8583j.setVisibility(0);
        this.f8583j.setText(a2);
    }

    /* renamed from: a */
    private String m11840a(bb bbVar, long j) {
        if (bbVar.f3741b > j) {
            return m11839a(C0258j.personal__account_summary_view__serial_privilege_reminder, bbVar.f3741b - j);
        }
        if (bbVar.f3740a > j) {
            return m11839a(C0258j.personal__account_summary_view__pub_privilege_reminder, bbVar.f3740a - j);
        }
        return m11839a(C0258j.personal__account_summary_view__comic_privilege_reminder, bbVar.f3742c - j);
    }

    /* renamed from: b */
    private String m11856b(bb bbVar, long j) {
        if (bbVar.m5342a(j) == 3) {
            return getString(C0258j.personal__account_summary_view__all_privilege);
        }
        if (bbVar.f3741b > j && bbVar.f3740a > j) {
            return getString(C0258j.personal__account_summary_view__serial_pub_privilege);
        }
        if (bbVar.f3741b > j && bbVar.f3742c > j) {
            return getString(C0258j.personal__account_summary_view__serial_comic_privilege);
        }
        if (bbVar.f3740a <= j || bbVar.f3742c <= j) {
            return "";
        }
        return getString(C0258j.personal__account_summary_view__pub_comic_privilege);
    }

    /* renamed from: a */
    private String m11839a(int i, long j) {
        Object obj = "";
        if (j > 0) {
            if (j < 60000) {
                obj = getContext().getString(C0258j.personal__account_summary_view__privilege_1min);
            } else {
                long j2 = j / 86400000;
                obj = ReaderUi.m10163b(getContext(), j);
                if (j2 > 0) {
                    j2 = j - (j2 * 86400000);
                    if (j2 > 3600000) {
                        obj = obj + ReaderUi.m10163b(getContext(), j2);
                    }
                }
            }
        }
        if (TextUtils.isEmpty(obj)) {
            return obj;
        }
        return String.format(getString(i), new Object[]{obj});
    }

    /* renamed from: c */
    private String m11864c(bb bbVar, long j) {
        String str = "";
        Object a = m11839a(C0258j.personal__account_summary_view__serial_privilege_reminder, bbVar.f3741b - j);
        Object a2 = m11839a(C0258j.personal__account_summary_view__pub_privilege_reminder, bbVar.f3740a - j);
        Object a3 = m11839a(C0258j.personal__account_summary_view__comic_privilege_reminder, bbVar.f3742c - j);
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

    /* renamed from: q */
    private void m11899q() {
        if (C0709k.m3476a().m3500a(PersonalAccount.class)) {
            new hc(this).open();
        } else {
            this.f8588o.setText(getString(C0258j.personal__account_summary_view__my_reward) + 0);
        }
    }

    /* renamed from: r */
    private void m11900r() {
        if (C0709k.m3476a().m3500a(PersonalAccount.class)) {
            new hd(this).open();
        } else {
            this.f8587n.setText(getString(C0258j.personal__account_summary_view__my_cash) + 0);
        }
    }

    /* renamed from: s */
    private void m11901s() {
        if (C0709k.m3476a().m3500a(PersonalAccount.class)) {
            new he(this).open();
        } else {
            this.f8586m.setText(getString(C0258j.personal__account_summary_view__my_coupon) + 0);
        }
    }

    /* renamed from: i */
    public void m11926i() {
        this.f8576c.mo434a(0, 0, HttpStatus.SC_MULTIPLE_CHOICES, null, null);
    }

    /* renamed from: t */
    private void m11902t() {
        dv.m1921a(getContentView(), new hf(this));
    }

    /* renamed from: u */
    private boolean m11903u() {
        MiAccount miAccount = (MiAccount) C0709k.m3476a().m3502b(MiAccount.class);
        if ((miAccount == null || miAccount.mo839i()) && DkApp.get().getAutoLogin() && MiAccount.m3186b(getContext())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m11853a(String str) {
        C1163a.m8627k().m8655c("personal_center", "click", str);
    }

    /* renamed from: a */
    private void m11843a(Rect rect) {
        ActivatedController hgVar = new hg(this, getContext());
        View hhVar = new hh(this, getContext());
        View imageView = new ImageView(getContext());
        View imageView2 = new ImageView(getContext());
        View hjVar = new hj(this, getContext(), hhVar, rect, imageView, imageView2);
        hjVar.setBackgroundColor(Color.argb(179, 0, 0, 0));
        hjVar.addView(hhVar, new ViewGroup.LayoutParams(-1, rect.height()));
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageResource(C0254f.personal__purchased_view__hint_arrow);
        hjVar.addView(imageView, new ViewGroup.LayoutParams(-2, -2));
        imageView2.setScaleType(ScaleType.CENTER);
        imageView2.setImageResource(C0254f.personal__purchased_view__hint_text);
        hjVar.addView(imageView2, new ViewGroup.LayoutParams(-2, -2));
        hjVar.setOnClickListener(new hk(this, hgVar));
        hgVar.setContentView(hjVar);
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).showPopup(hgVar);
        ReaderEnv.get().setShowPurchasedHint(false);
    }
}
