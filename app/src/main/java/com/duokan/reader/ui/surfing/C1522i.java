package com.duokan.reader.ui.surfing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.C0616o;
import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.io;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.PersonalPrefs.UserTab;
import com.duokan.reader.domain.cloud.ap;
import com.duokan.reader.domain.cloud.fo;
import com.duokan.reader.domain.cloud.fq;
import com.duokan.reader.domain.cloud.fr;
import com.duokan.reader.domain.cloud.ft;
import com.duokan.reader.domain.cloud.fy;
import com.duokan.reader.domain.cloud.gm;
import com.duokan.reader.domain.cloud.gn;
import com.duokan.reader.domain.cloud.go;
import com.duokan.reader.domain.cloud.gq;
import com.duokan.reader.domain.p044b.C0781b;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.C1367p;
import com.duokan.reader.ui.bookshelf.bp;
import com.duokan.reader.ui.bookshelf.ht;
import com.duokan.reader.ui.general.C1330e;
import com.duokan.reader.ui.general.hd;
import com.duokan.reader.ui.general.web.SearchController;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.p051b.C1278d;
import com.duokan.reader.ui.p051b.C1280f;
import com.duokan.reader.ui.personal.fz;
import com.duokan.reader.ui.store.C1493f;
import com.duokan.reader.ui.store.C1501n;
import com.duokan.reader.ui.store.ba;
import com.duokan.reader.ui.store.bl;
import com.duokan.reader.ui.store.bq;
import com.duokan.reader.ui.store.br;
import com.duokan.reader.ui.store.bv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.ui.surfing.i */
public class C1522i extends C1367p implements OnPrimaryClipChangedListener, io, fq, fy, gm, gn, go, C1280f, hd, al {
    /* renamed from: A */
    private final boolean f11527A;
    /* renamed from: B */
    private final LinkedList<UserTab> f11528B = new LinkedList();
    /* renamed from: C */
    private final Set<String> f11529C = new HashSet();
    /* renamed from: D */
    private int f11530D = 0;
    /* renamed from: E */
    private int f11531E = -1;
    /* renamed from: F */
    private String f11532F = "";
    /* renamed from: a */
    private final int f11533a = 0;
    /* renamed from: b */
    private final int f11534b = 1;
    /* renamed from: c */
    private final int f11535c = 2;
    /* renamed from: d */
    private final int f11536d = 3;
    /* renamed from: e */
    private final ba f11537e;
    /* renamed from: f */
    private final C1493f f11538f;
    /* renamed from: g */
    private final C1501n f11539g;
    /* renamed from: h */
    private int f11540h;
    /* renamed from: i */
    private int f11541i;
    /* renamed from: j */
    private int f11542j;
    /* renamed from: k */
    private final FrameLayout f11543k;
    /* renamed from: l */
    private final View f11544l;
    /* renamed from: m */
    private final LinearLayout f11545m;
    /* renamed from: n */
    private final FrameLayout f11546n;
    /* renamed from: o */
    private final ActivatedController[] f11547o = new ActivatedController[4];
    /* renamed from: p */
    private final et f11548p = new et();
    /* renamed from: q */
    private final br f11549q;
    /* renamed from: r */
    private bp f11550r = null;
    /* renamed from: s */
    private StorePageController f11551s = null;
    /* renamed from: t */
    private fz f11552t = null;
    /* renamed from: u */
    private final LinearLayout f11553u;
    /* renamed from: v */
    private final ClipboardManager f11554v;
    /* renamed from: w */
    private final View f11555w;
    /* renamed from: x */
    private final View f11556x;
    /* renamed from: y */
    private final View f11557y;
    /* renamed from: z */
    private SearchController f11558z = null;

    public C1522i(IFeature mFeature, boolean z) {
        super(mFeature);
        this.f11527A = z;
        this.f11543k = new C1523j(this, getContext());
        this.f11544l = new View(getContext());
        this.f11544l.setBackgroundColor(-1);
        this.f11544l.setVisibility(4);
        this.f11543k.addView(this.f11544l, new LayoutParams(-1, -1));
        this.f11545m = new LinearLayout(getContext());
        this.f11545m.setOrientation(1);
        m11280a(this.f11543k);
        this.f11543k.addView(this.f11545m, new LayoutParams(-1, -1));
        this.f11546n = new FrameLayout(getContext());
        this.f11545m.addView(this.f11546n, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.f11549q = new C1537x(this, getContext());
        addSubController(this.f11549q);
        this.f11547o[0] = this.f11549q;
        this.f11546n.addView(this.f11549q.getContentView(), new LayoutParams(-1, -1));
        bq adVar = new ad(this);
        this.f11537e = new af(this, getContext(), adVar);
        this.f11538f = new ag(this, getContext(), adVar);
        this.f11539g = new ah(this, getContext(), adVar);
        m15509q();
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(C0256h.surfing__surfing_navigate_view, this.f11545m, false);
        this.f11553u = (LinearLayout) frameLayout.findViewById(C0255g.surfing__surfing_navigate_view__tab);
        for (int i = 0; i < this.f11553u.getChildCount(); i++) {
            this.f11553u.getChildAt(i).setOnClickListener(new ai(this, i));
        }
        this.f11555w = this.f11553u.findViewById(C0255g.surfing__surfing_navigate_view__personal_message_count_image);
        this.f11556x = this.f11553u.findViewById(C0255g.surfing__surfing_navigate_view__personal_cart_count_image);
        this.f11557y = this.f11553u.findViewById(C0255g.surfing__surfing_navigate_view__personal_task_count_image);
        this.f11545m.addView(frameLayout);
        this.f11554v = (ClipboardManager) getContext().getApplicationContext().getSystemService("clipboard");
        if (!C0559f.m2476b().m2486e()) {
            m15499e(2);
        } else if (ReaderEnv.get().getLastShowStoreDay() != ReaderEnv.get().updateLastShowStoreDay()) {
            m15499e(0);
        } else {
            m15499e(2);
        }
    }

    /* renamed from: d */
    private void m15497d(int i) {
        switch (i) {
            case 0:
                if (!this.f11549q.isActive()) {
                    this.f11532F += "m";
                    return;
                }
                return;
            case 1:
                if (this.f11551s == null || !this.f11551s.isActive()) {
                    this.f11532F += "c";
                    return;
                }
                return;
            case 2:
                if (this.f11550r == null || !this.f11550r.isActive()) {
                    this.f11532F += "s";
                    return;
                }
                return;
            default:
                if (this.f11552t == null || !this.f11552t.isActive()) {
                    this.f11532F += "u";
                    return;
                }
                return;
        }
    }

    /* renamed from: q */
    private void m15509q() {
        int i = 0;
        LinkedList f = PersonalPrefs.m5175a().m5227f();
        WebLog.init().m762a(f.isEmpty());
        if (!this.f11528B.equals(f)) {
            this.f11528B.clear();
            this.f11528B.addAll(f);
            this.f11549q.m15339d();
            Set hashSet = new HashSet();
            if (((UserTab) f.get(0)).equals(UserTab.PUB) && f.size() == 1) {
                hashSet.add(gq.f4065d);
                hashSet.add(gq.f4063b);
                hashSet.add(gq.f4064c);
            }
            while (i < f.size()) {
                switch (ac.f11502a[((UserTab) f.get(i)).ordinal()]) {
                    case 1:
                        this.f11541i = i;
                        this.f11549q.m15334a(this.f11538f, getString(C0258j.surfing__shared__pub_store));
                        break;
                    case 2:
                        this.f11540h = i;
                        this.f11549q.m15334a(this.f11537e, getString(C0258j.surfing__shared__fiction_store));
                        break;
                    default:
                        this.f11542j = i;
                        this.f11549q.m15334a(this.f11539g, getString(C0258j.surfing__shared__comic_store));
                        break;
                }
                i++;
            }
            if (PersonalPrefs.m5175a().m5219c() != null) {
                m15486a(PersonalPrefs.m5175a().m5219c());
            } else if (PersonalPrefs.m5175a().m5210b() != 0) {
                m15516x();
            } else {
                m15486a(hashSet);
            }
            if (this.f11549q.isActive()) {
                this.f11549q.m15344i();
            }
        }
    }

    /* renamed from: e */
    private void m15499e(int i) {
        m15479a(i, null, null);
    }

    /* renamed from: a */
    private void m15479a(int i, Runnable runnable, Runnable runnable2) {
        WebLog c = WebLog.init();
        boolean z = i < 0 || i > this.f11553u.getChildCount() - 1;
        c.m762a(z);
        if (i >= 0 && i <= this.f11553u.getChildCount() - 1) {
            if (i == this.f11531E) {
                mo2556k();
                UThread.post(runnable);
                return;
            }
            UmengManager.get().onEvent("SURFING_SHOW_TAB_V1", "" + i);
            if (this.f11531E >= 0 && this.f11531E < this.f11547o.length && this.f11547o[this.f11531E] != null) {
                this.f11547o[this.f11531E].getContentView().setVisibility(4);
                deactivate(this.f11547o[this.f11531E]);
            }
            this.f11531E = i;
            int i2 = 0;
            while (i2 < this.f11547o.length) {
                boolean z2;
                View childAt = this.f11553u.getChildAt(i2);
                if (i2 == this.f11531E) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                childAt.setSelected(z2);
                ActivatedController c0303e = this.f11547o[i2];
                if (c0303e != null && i2 == this.f11531E) {
                    c0303e.getContentView().setVisibility(0);
                    c0303e.getContentView().scrollTo(0, 0);
                    activate(c0303e);
                }
                i2++;
            }
            if (this.f11547o[this.f11531E] == null) {
                Runnable ajVar = new aj(this, runnable);
                this.f11544l.setVisibility(0);
                switch (this.f11531E) {
                    case 1:
                        m15485a(ajVar, runnable2);
                        return;
                    case 2:
                        m15492b(ajVar, runnable2);
                        return;
                    case 3:
                        m15495c(ajVar, runnable2);
                        return;
                    default:
                        return;
                }
            }
            this.f11544l.setVisibility(4);
            UThread.post(runnable);
        }
    }

    /* renamed from: a */
    public void m15521a(C0800c c0800c) {
        m15492b(new ak(this, c0800c), null);
    }

    /* renamed from: k */
    public void mo2556k() {
        if (this.f11550r != null && this.f11550r.isActive()) {
            this.f11550r.m9305e();
        } else if (this.f11549q != null && this.f11549q.isActive()) {
            bl u = m15513u();
            if (u != null) {
                u.m15302e();
            }
        } else if (this.f11552t != null && this.f11552t.isActive()) {
            this.f11552t.m11926i();
        } else if (this.f11551s != null && this.f11551s.isActive()) {
            this.f11551s.backToTopSmoothly();
        }
    }

    /* renamed from: b */
    public void mo2550b(View view) {
        this.f11543k.addView(view);
    }

    /* renamed from: c */
    public void mo2553c(View view) {
        this.f11543k.removeView(view);
    }

    /* renamed from: a */
    public void mo2549a(boolean z, String str) {
        if (!z || TextUtils.isEmpty(this.f11532F)) {
            this.f11532F += str;
        }
    }

    /* renamed from: c */
    public void mo2552c(int i) {
        super.mo2552c(i);
        if (i == 0 && this.f11549q.isActive()) {
            bl u = m15513u();
            if (u != null) {
                u.m15300c();
            }
        }
    }

    protected boolean onPreviewBack() {
        m15536l();
        return super.onPreviewBack();
    }

    public boolean navigateSmoothly(String str) {
        return navigate(str, null, true, null);
    }

    public boolean navigate(String str, Object obj, boolean z, Runnable runnable) {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        if (path.equals("cart") || path.equals("store/cart")) {
            ActivatedController b = bv.m15357b(getContext());
            if (z) {
                ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(b, runnable);
            } else {
                ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushPage(b);
                UThread.post(runnable);
            }
            return true;
        }
        if (path.equals("search")) {
            m15480a(parse);
        }
        if (path.equals("store") || path.equals("market")) {
            m11289i();
            m15499e(0);
            return true;
        } else if (path.startsWith("store/") || path.startsWith("market/")) {
            m11289i();
            m15499e(0);
            int indexOf = path.indexOf(47);
            if (indexOf >= 0 && indexOf < path.length() - 1) {
                String substring = path.substring(indexOf + 1);
                if (substring.startsWith("search")) {
                    m15480a(parse);
                } else {
                    bl j = this.f11549q.m15345j();
                    if (j != null) {
                        j.navigate(substring, obj, z, runnable);
                    }
                }
            }
            return true;
        } else if (path.startsWith("personal/")) {
            Runnable c1524k = new C1524k(this, path, z, runnable, parse);
            m11289i();
            m15499e(3);
            c1524k.run();
            return true;
        } else if (path.equals("bookshelf")) {
            m11289i();
            m15499e(2);
            return true;
        } else if (!str.startsWith("bookshelf/")) {
            return false;
        } else {
            m11289i();
            m15479a(2, new C1526m(this, str, obj, z, runnable), null);
            return true;
        }
    }

    /* renamed from: a */
    private void m15480a(Uri uri) {
        String str = "";
        String str2 = "";
        String str3 = "";
        try {
            str = uri.getQueryParameter("key");
            str2 = uri.getQueryParameter("default_key");
            str3 = uri.getQueryParameter("miref");
        } catch (Throwable th) {
        }
        if (this.f11558z == null || !this.f11558z.isActive()) {
            mo2548a(str, str2, str3);
            return;
        }
        this.f11558z.setSearchSource(str3);
        this.f11558z.setDefaultSearchWord(str, str2);
        this.f11558z.checkDefaultSearch();
    }

    /* renamed from: l */
    public void m15536l() {
    }

    /* renamed from: m */
    public void mo2557m() {
    }

    /* renamed from: n */
    public void mo2558n() {
    }

    /* renamed from: o */
    public void mo2559o() {
        this.f11530D++;
        mo2558n();
    }

    /* renamed from: p */
    public void mo2561p() {
        this.f11530D--;
        mo2557m();
    }

    /* renamed from: a */
    public void mo2546a(View view, boolean z, Runnable runnable) {
        if (view != null) {
            Drawable c1330e = new C1330e();
            c1330e.m10544b(this.f11545m);
            c1330e.m10543a(z);
            View frameLayout = new FrameLayout(getContext());
            frameLayout.setBackgroundDrawable(c1330e);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            this.f11543k.addView(frameLayout, new LayoutParams(-1, -1));
            dv.showAnimation(frameLayout, runnable);
        }
    }

    /* renamed from: a */
    public void mo2545a(View view, Runnable runnable) {
        if (view != null) {
            View view2 = (FrameLayout) view.getParent();
            view2.setVisibility(4);
            dv.hideAnimation(view2, new C1527n(this, view2, runnable));
        }
    }

    /* renamed from: a */
    public void mo2547a(er erVar) {
        this.f11548p.m2041a(erVar);
    }

    /* renamed from: a */
    public void mo1701a() {
    }

    /* renamed from: b */
    public void mo1705b() {
    }

    /* renamed from: a */
    public void mo1702a(String str) {
    }

    /* renamed from: b */
    public void mo1917b(int i) {
        m15511s();
    }

    protected void onAttachToStub() {
        DkApp.get().runWhenAppReady(new C1528o(this));
    }

    protected void onDetachFromStub() {
        DkApp.get().runWhenAppReady(new C1529p(this));
    }

    protected void onActive(boolean z) {
        if (ReaderEnv.get().forHd()) {
            getActivity().setRequestedOrientation(2);
        } else {
            getActivity().setRequestedOrientation(1);
        }
        ReaderFeature readerFeature = (ReaderFeature) getContext().queryFeature(ReaderFeature.class);
        readerFeature.updateSystemUi(true);
        readerFeature.setScreenTimeout(0);
        readerFeature.setScreenBrightnessMode(BrightnessMode.SYSTEM);
        readerFeature.setKeyboardBrightnessMode(BrightnessMode.SYSTEM);
        if (z) {
            if (this.f11527A) {
                DkApp.get().runWhenUiReady(new C1530q(this));
            }
            if (ReaderEnv.get().isFreshInstall()) {
                ReaderEnv.get().setNeedAddNewbieBook(true);
            }
        }
        DkApp.get().runWhenUiReady(new C1534u(this));
    }

    protected void onDeactive() {
        super.onDeactive();
        if (!TextUtils.isEmpty(this.f11532F)) {
            C1163a.m8627k().m8654c(this.f11532F);
            this.f11532F = "";
        }
    }

    /* renamed from: a */
    public void mo2548a(String str, String str2, String str3) {
        if (this.f11558z != null) {
            this.f11558z.requestDetach();
        }
        this.f11558z = new SearchController(getContext());
        String str4 = "";
        if ((this.f11550r != null && this.f11550r.isActive()) || C0616o.m2804a().m2812b()) {
            str4 = "bookshelf";
        } else if (this.f11549q.isActive()) {
            str4 = "store_";
            bl u = m15513u();
            str4 = u instanceof ba ? str4 + "fiction" : u instanceof C1493f ? str4 + "publish" : str4 + "comic";
        } else if (this.f11551s != null && this.f11551s.isActive()) {
            str4 = "category";
        }
        this.f11558z.setOpenFrom(str4);
        this.f11558z.setDefaultSearchWord(str, str2);
        this.f11558z.setSearchSource(str3);
        this.f11558z.setXiaoAiAwake(C0616o.m2804a().m2812b());
        if ((this.f11550r == null || !this.f11550r.isActive()) && !C0616o.m2804a().m2812b()) {
            this.f11558z.setBookshelfResultPresenter(null);
        } else {
            this.f11558z.setBookshelfResultPresenter(new ht(this.f11550r.getContext()));
        }
        pushPage(this.f11558z);
    }

    /* renamed from: a */
    public void mo1915a(fr frVar) {
        m15489b(frVar);
    }

    /* renamed from: c */
    public void mo2551c() {
        m15512t();
    }

    /* renamed from: r */
    private void m15510r() {
        ai.m3980a().mo973a(false, false);
        C0781b.m3667b().m3684a();
        PersonalPrefs.m5175a().m5246v();
        PersonalPrefs.m5175a().m5245u();
        DkUserReadingNotesManager.m5136a().m5151a(C0519c.f1752a);
        ap.m5294a().m5303a(C0519c.f1752a);
        DkUserReadBookManager.m5115a().m5126a(C0519c.f1752a);
        UmengManager.get().checkUpdateAuto(getContext());
        m15514v();
    }

    /* renamed from: s */
    private void m15511s() {
        if (C1278d.m9042c().m9052d() > 0) {
            this.f11555w.setVisibility(0);
        } else {
            this.f11555w.setVisibility(4);
        }
    }

    /* renamed from: b */
    private void m15489b(fr frVar) {
        this.f11556x.setVisibility(frVar instanceof fo ? 0 : 4);
    }

    /* renamed from: t */
    private void m15512t() {
        if (ft.m5575a().m5584b() > 0 || !PersonalPrefs.m5175a().m5240p()) {
            this.f11557y.setVisibility(0);
        } else {
            this.f11557y.setVisibility(4);
        }
    }

    /* renamed from: a */
    private void m15485a(Runnable runnable, Runnable runnable2) {
        if (this.f11551s != null) {
            UThread.post(runnable);
        } else if (!DkApp.get().isReady()) {
            DkApp.get().runWhenAppReady(new C1535v(this, runnable, runnable2));
        } else if (this.f11531E == 1) {
            this.f11551s = new SurfingController$17(this, getContext());
            this.f11547o[1] = this.f11551s;
            this.f11546n.addView(this.f11551s.getContentView(), new ViewGroup.LayoutParams(-1, -1));
            addSubController(this.f11551s);
            activate(this.f11551s);
            UThread.post(runnable);
        } else {
            UThread.post(runnable2);
        }
    }

    /* renamed from: b */
    private void m15492b(Runnable runnable, Runnable runnable2) {
        if (this.f11550r != null) {
            UThread.post(runnable);
        } else if (!DkApp.get().isReady()) {
            DkApp.get().runWhenAppReady(new C1536w(this, runnable, runnable2));
        } else if (this.f11531E == 2) {
            this.f11550r = new bp(getContext());
            this.f11547o[2] = this.f11550r;
            this.f11546n.addView(this.f11550r.getContentView(), new ViewGroup.LayoutParams(-1, -1));
            addSubController(this.f11550r);
            activate(this.f11550r);
            UThread.post(runnable);
        } else {
            UThread.post(runnable2);
        }
    }

    /* renamed from: c */
    private void m15495c(Runnable runnable, Runnable runnable2) {
        if (this.f11552t != null) {
            UThread.post(runnable);
        } else if (!DkApp.get().isReady()) {
            DkApp.get().runWhenAppReady(new C1538y(this, runnable, runnable2));
        } else if (this.f11531E == 3) {
            this.f11552t = new fz(getContext());
            this.f11547o[3] = this.f11552t;
            this.f11546n.addView(this.f11552t.getContentView(), new ViewGroup.LayoutParams(-1, -1));
            addSubController(this.f11552t);
            activate(this.f11552t);
            UThread.post(runnable);
        } else {
            UThread.post(runnable2);
        }
    }

    /* renamed from: u */
    private bl m15513u() {
        return this.f11549q.m15345j();
    }

    /* renamed from: v */
    private void m15514v() {
        PersonalAccount personalAccount = (PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class);
        if (personalAccount != null && !personalAccount.mo839i()) {
            try {
                Object string = PersonalPrefs.m5175a().m5244t().getString(StorePageController.PAY_CONTINUE, null);
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    String string2 = jSONObject.getString("msg");
                    String string3 = jSONObject.getString("btn");
                    String optString = jSONObject.optString("click");
                    com.duokan.reader.ui.general.ap apVar = new com.duokan.reader.ui.general.ap(getContext());
                    apVar.setCancelOnTouchOutside(false);
                    apVar.setPrompt(string2);
                    apVar.setOkLabel(string3);
                    apVar.open(new C1539z(this, optString));
                }
            } catch (Exception e) {
            }
        }
    }

    public void onPrimaryClipChanged() {
        m15515w();
    }

    /* renamed from: w */
    private void m15515w() {
        if (ManagedApp.get().getRunningState() == RunningState.FOREGROUND) {
            try {
                String b = m15488b(this.f11554v.getPrimaryClip().getItemAt(0).coerceToText(getContext()).toString());
                if (!TextUtils.isEmpty(b) && b.length() == 8) {
                    if (C0559f.m2476b().m2486e()) {
                        StorePageController storePageController = new StorePageController(getContext());
                        storePageController.loadUrl(C0641o.m2934i().m2999z() + "/hs/user/redeem/" + b + "?native_transparent=1");
                        this.f11554v.setPrimaryClip(ClipData.newPlainText(null, null));
                        runAfterActive(new ab(this, storePageController));
                        return;
                    }
                    com.duokan.reader.ui.general.ap apVar = new com.duokan.reader.ui.general.ap(getContext());
                    apVar.setPrompt(C0258j.personal__personal_redeem_view__network_error);
                    apVar.setCancelLabel(C0258j.general__shared__cancel);
                    apVar.setOkLabelResid(C0258j.general__shared__retry);
                    apVar.setCancelOnBack(true);
                    apVar.setCancelOnTouchOutside(false);
                    apVar.open(new aa(this));
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: b */
    private String m15488b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*多看(A[2-9][2-9A-HJ-NP-Z]{6}).*").matcher(str.toUpperCase());
        if (!matcher.matches() || matcher.groupCount() <= 0) {
            return "";
        }
        return matcher.group(1);
    }

    /* renamed from: f */
    public void mo2555f() {
        m15516x();
    }

    /* renamed from: d */
    public void mo2527d() {
        m15486a(PersonalPrefs.m5175a().m5219c());
    }

    /* renamed from: x */
    private void m15516x() {
        if ((PersonalPrefs.m5175a().m5210b() == 1 ? 1 : 0) != 0) {
            this.f11549q.m15335a(Arrays.asList(new Integer[]{Integer.valueOf(this.f11540h), Integer.valueOf(this.f11542j)}));
        } else {
            this.f11549q.m15336b(Arrays.asList(new Integer[]{Integer.valueOf(this.f11540h), Integer.valueOf(this.f11542j)}));
        }
    }

    /* renamed from: a */
    private void m15486a(Set<String> set) {
        if (set != null) {
            this.f11529C.clear();
            this.f11529C.addAll(set);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(this.f11541i), Integer.valueOf(this.f11540h), Integer.valueOf(this.f11542j)}));
            if (set.contains(gq.f4062a)) {
                arrayList.add(Integer.valueOf(this.f11541i));
                arrayList2.remove(Integer.valueOf(this.f11541i));
            }
            if (set.contains(gq.f4063b) && set.contains(gq.f4064c)) {
                arrayList.add(Integer.valueOf(this.f11540h));
                arrayList2.remove(Integer.valueOf(this.f11540h));
            }
            if (set.contains(gq.f4065d)) {
                arrayList.add(Integer.valueOf(this.f11542j));
                arrayList2.remove(Integer.valueOf(this.f11542j));
            }
            if (arrayList.size() > 0) {
                this.f11549q.m15335a(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.f11549q.m15336b(arrayList2);
            }
        }
    }

    /* renamed from: e */
    public void mo2554e() {
        m15509q();
    }
}
