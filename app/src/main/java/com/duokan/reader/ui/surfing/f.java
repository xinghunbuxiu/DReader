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

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.BrightnessMode;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iu;
import com.duokan.reader.domain.cloud.DkUserReadBookManager;
import com.duokan.reader.domain.cloud.DkUserReadingNotesManager;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.PersonalPrefs.UserTab;
import com.duokan.reader.domain.cloud.aw;
import com.duokan.reader.domain.cloud.gi;
import com.duokan.reader.domain.cloud.gk;
import com.duokan.reader.domain.cloud.gl;
import com.duokan.reader.domain.cloud.gn;
import com.duokan.reader.domain.cloud.gs;
import com.duokan.reader.domain.cloud.hg;
import com.duokan.reader.domain.cloud.hh;
import com.duokan.reader.domain.cloud.hi;
import com.duokan.reader.domain.cloud.hk;
import com.duokan.reader.ui.bookshelf.bk;
import com.duokan.reader.ui.bookshelf.hm;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.ho;
import com.duokan.reader.ui.general.web.SearchController;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.p;
import com.duokan.reader.ui.personal.fl;
import com.duokan.reader.ui.store.ba;
import com.duokan.reader.ui.store.bl;
import com.duokan.reader.ui.store.bq;
import com.duokan.reader.ui.store.br;
import com.duokan.reader.ui.store.bv;
import com.duokan.reader.ui.store.n;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f extends p implements OnPrimaryClipChangedListener, iu, gk, gs, hg, hh, hi, com.duokan.reader.ui.b.f, ho, af {
    private int A = 0;
    private int B = -1;
    private String C = "";
    private final int a = 0;
    private final int b = 1;
    private final int c = 2;
    private final int d = 3;
    private int e;
    private int f;
    private int g;
    private final FrameLayout h;
    private final View i;
    private final LinearLayout j;
    private final FrameLayout k;
    private final ActivatedController[] l = new ActivatedController[4];
    private final et m = new et();
    private final br n;
    private bk o = null;
    private StorePageController p = null;
    private fl q = null;
    private final LinearLayout r;
    private final ClipboardManager s;
    private final View t;
    private final View u;
    private final View v;
    private SearchController w = null;
    private final boolean x;
    private final LinkedList y = new LinkedList();
    private final Set z = new HashSet();

    public f(IFeature featrue, boolean z) {
        super(featrue);
        this.x = z;
        this.h = new g(this, getContext());
        this.i = new View(getContext());
        this.i.setBackgroundColor(-1);
        this.i.setVisibility(4);
        this.h.addView(this.i, new LayoutParams(-1, -1));
        this.j = new LinearLayout(getContext());
        this.j.setOrientation(1);
        a(this.h);
        this.h.addView(this.j, new LayoutParams(-1, -1));
        this.k = new FrameLayout(getContext());
        this.j.addView(this.k, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.n = new TaskHandler(this, getContext());
        addSubController(this.n);
        this.l[0] = this.n;
        this.k.addView(this.n.getContentView(), new LayoutParams(-1, -1));
        q();
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(h.surfing__surfing_navigate_view, this.j, false);
        this.r = (LinearLayout) frameLayout.findViewById(g.surfing__surfing_navigate_view__tab);
        for (int i = 0; i < this.r.getChildCount(); i++) {
            this.r.getChildAt(i).setOnClickListener(new w(this, i));
        }
        this.t = this.r.findViewById(g.surfing__surfing_navigate_view__personal_message_count_image);
        this.u = this.r.findViewById(g.surfing__surfing_navigate_view__personal_cart_count_image);
        this.v = this.r.findViewById(g.surfing__surfing_navigate_view__personal_task_count_image);
        this.j.addView(frameLayout);
        this.s = (ClipboardManager) getContext().getApplicationContext().getSystemService("clipboard");
        if (!com.duokan.reader.common.c.f.b().e()) {
            e(2);
        } else if (ReaderEnv.get().getLastShowStoreDay() != ReaderEnv.get().updateLastShowStoreDay()) {
            e(0);
        } else {
            e(2);
        }
    }

    private void d(int i) {
        switch (i) {
            case 0:
                if (!this.n.isActive()) {
                    this.C += "BaseActivity";
                    return;
                }
                return;
            case 1:
                if (this.p == null || !this.p.isActive()) {
                    this.C += "showAnimation";
                    return;
                }
                return;
            case 2:
                if (this.o == null || !this.o.isActive()) {
                    this.C += "s";
                    return;
                }
                return;
            default:
                if (this.q == null || !this.q.isActive()) {
                    this.C += "u";
                    return;
                }
                return;
        }
    }

    private void q() {
        int i = 0;
        LinkedList f = PersonalPrefs.a().f();
        a.c().a(f.isEmpty());
        if (!this.y.equals(f)) {
            this.y.clear();
            this.y.addAll(f);
            this.n.d();
            Set hashSet = new HashSet();
            if (((UserTab) f.get(0)).equals(UserTab.PUB) && f.size() == 1) {
                hashSet.add(hk.d);
                hashSet.add(hk.b);
                hashSet.add(hk.c);
            }
            bq xVar = new x(this);
            bl baVar = new ba(getContext(), xVar);
            bl fVar = new com.duokan.reader.ui.store.f(getContext(), xVar);
            bl nVar = new n(getContext(), xVar);
            Iterator it = f.iterator();
            while (it.hasNext()) {
                switch (v.a[((UserTab) it.next()).ordinal()]) {
                    case 1:
                        this.f = i;
                        this.n.a(fVar, getString(j.surfing__shared__pub_store));
                        break;
                    case 2:
                        this.e = i;
                        this.n.a(baVar, getString(j.surfing__shared__fiction_store));
                        break;
                    default:
                        this.g = i;
                        this.n.a(nVar, getString(j.surfing__shared__comic_store));
                        break;
                }
                i++;
            }
            if (PersonalPrefs.a().c() != null) {
                a(PersonalPrefs.a().c());
            } else if (PersonalPrefs.a().b() != 0) {
                x();
            } else {
                a(hashSet);
            }
            if (this.n.isActive()) {
                this.n.i();
            }
        }
    }

    private void e(int i) {
        a(i, null, null);
    }

    private void a(int i, Runnable runnable, Runnable runnable2) {
        a c = a.c();
        boolean z = i < 0 || i > this.r.getChildCount() - 1;
        c.a(z);
        if (i >= 0 && i <= this.r.getChildCount() - 1) {
            if (i == this.B) {
                k();
                t.b(runnable);
                return;
            }
            UmengManager.get().onEvent("SURFING_SHOW_TAB_V1", "" + i);
            if (this.B >= 0 && this.B < this.l.length && this.l[this.B] != null) {
                this.l[this.B].getContentView().setVisibility(4);
                deactivate(this.l[this.B]);
            }
            this.B = i;
            int i2 = 0;
            while (i2 < this.l.length) {
                boolean z2;
                View childAt = this.r.getChildAt(i2);
                if (i2 == this.B) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                childAt.setSelected(z2);
                ActivatedController activatedControllerVar = this.l[i2];
                if (activatedControllerVar != null && i2 == this.B) {
                    activatedControllerVar.getContentView().setVisibility(0);
                    activatedControllerVar.getContentView().scrollTo(0, 0);
                    activate(activatedControllerVar);
                }
                i2++;
            }
            if (this.l[this.B] == null) {
                Runnable zVar = new z(this, runnable);
                this.i.setVisibility(0);
                switch (this.B) {
                    case 1:
                        a(zVar, runnable2);
                        return;
                    case 2:
                        b(zVar, runnable2);
                        return;
                    case 3:
                        c(zVar, runnable2);
                        return;
                    default:
                        return;
                }
            }
            this.i.setVisibility(4);
            t.b(runnable);
        }
    }

    public void a(c cVar) {
        b(new aa(this, cVar), null);
    }

    public void k() {
        if (this.o != null && this.o.isActive()) {
            this.o.e();
        } else if (this.n != null && this.n.isActive()) {
            bl u = u();
            if (u != null) {
                u.d();
            }
        } else if (this.q != null && this.q.isActive()) {
            this.q.i();
        } else if (this.p != null && this.p.isActive()) {
            this.p.backToTopSmoothly();
        }
    }

    public void b(View view) {
        this.h.addView(view);
    }

    public void c(View view) {
        this.h.removeView(view);
    }

    public void a(boolean z, String str) {
        if (!z || TextUtils.isEmpty(this.C)) {
            this.C += str;
        }
    }

    public void c(int i) {
        super.c(i);
        if (i == 0 && this.n.isActive()) {
            bl u = u();
            if (u != null) {
                u.c();
            }
        }
    }

    protected boolean onPreviewBack() {
        l();
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
            ActivatedController b = bv.b(getContext());
            if (z) {
                ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushPageSmoothly(b, runnable);
            } else {
                ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).pushPage(b);
                t.b(runnable);
            }
            return true;
        }
        if (path.equals("search")) {
            a(parse);
        }
        if (path.equals("store") || path.equals("market")) {
            i();
            e(0);
            return true;
        } else if (path.startsWith("store/") || path.startsWith("market/")) {
            i();
            e(0);
            int indexOf = path.indexOf(47);
            if (indexOf >= 0 && indexOf < path.length() - 1) {
                String substring = path.substring(indexOf + 1);
                if (substring.startsWith("search")) {
                    a(parse);
                } else {
                    bl j = this.n.j();
                    if (j != null) {
                        j.navigate(substring, obj, z, runnable);
                    }
                }
            }
            return true;
        } else if (path.startsWith("personal/")) {
            Runnable abVar = new ab(this, path, z, runnable);
            i();
            e(3);
            abVar.run();
            return true;
        } else if (path.equals("bookshelf")) {
            i();
            e(2);
            return true;
        } else if (!str.startsWith("bookshelf/")) {
            return false;
        } else {
            i();
            a(2, new ad(this, str, obj, z, runnable), null);
            return true;
        }
    }

    private void a(Uri uri) {
        String str = "";
        String str2 = "";
        String str3 = "";
        try {
            str = uri.getQueryParameter("key");
            str2 = uri.getQueryParameter("default_key");
            str3 = uri.getQueryParameter("miref");
        } catch (Throwable th) {
        }
        if (this.w == null || !this.w.isActive()) {
            a(str, str2, str3);
            return;
        }
        this.w.setSearchSource(str3);
        this.w.setDefaultSearchWord(str, str2);
        this.w.checkDefaultSearch();
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
        this.A++;
        n();
    }

    public void p() {
        this.A--;
        m();
    }

    public void a(View view, boolean z, Runnable runnable) {
        if (view != null) {
            Drawable eVar = new com.duokan.reader.ui.general.e();
            eVar.b(this.j);
            eVar.a(z);
            View frameLayout = new FrameLayout(getContext());
            frameLayout.setBackgroundDrawable(eVar);
            frameLayout.addView(view, new LayoutParams(-1, -1));
            this.h.addView(frameLayout, new LayoutParams(-1, -1));
            UTools.closeAnimation(frameLayout, runnable);
        }
    }

    public void a(View view, Runnable runnable) {
        if (view != null) {
            View view2 = (FrameLayout) view.getParent();
            view2.setVisibility(4);
            UTools.showAnimation(view2, new ae(this, view2, runnable));
        }
    }

    public void a(er erVar) {
        this.m.a(erVar);
    }

    public void a() {
    }

    public void b() {
    }

    public void a(String str) {
    }

    public void b(int i) {
        s();
    }

    protected void onAttachToStub() {
        DkApp.get().runWhenAppReady(new h(this));
    }

    protected void onDetachFromStub() {
        DkApp.get().runWhenAppReady(new i(this));
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
            if (this.x) {
                DkApp.get().runWhenUiReady(new j(this));
            }
            if (ReaderEnv.get().isFreshInstall()) {
                ReaderEnv.get().setNeedAddNewbieBook(true);
            }
        }
        DkApp.get().runWhenUiReady(new n(this));
    }

    protected void onDeactive() {
        super.onDeactive();
        if (!TextUtils.isEmpty(this.C)) {
            com.duokan.reader.domain.statistics.a.k().d(this.C);
            this.C = "";
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.w != null) {
            this.w.requestDetach();
        }
        this.w = new SearchController(getContext());
        String str4 = "";
        if (this.o != null && this.o.isActive()) {
            str4 = "bookshelf";
        } else if (this.n.isActive()) {
            str4 = "store_";
            bl u = u();
            str4 = u instanceof ba ? str4 + "fiction" : u instanceof com.duokan.reader.ui.store.f ? str4 + "publish" : str4 + "comic";
        } else if (this.p != null && this.p.isActive()) {
            str4 = "category";
        }
        this.w.setOpenFrom(str4);
        this.w.setDefaultSearchWord(str, str2);
        this.w.setSearchSource(str3);
        if (this.o == null || !this.o.isActive()) {
            this.w.setBookshelfResultPresenter(null);
        } else {
            this.w.setBookshelfResultPresenter(new hm(this.o.getContext()));
        }
        pushPage(this.w);
    }

    public void a(gl glVar) {
        b(glVar);
    }

    public void c() {
        t();
    }

    private void r() {
        ai.a().a(false, false);
        b.b().a();
        PersonalPrefs.a().u();
        DkUserReadingNotesManager.a().a(com.duokan.reader.common.async.a.c.a);
        aw.a().a(com.duokan.reader.common.async.a.c.a);
        DkUserReadBookManager.a().a(com.duokan.reader.common.async.a.c.a);
        UmengManager.get().checkUpdateAuto(getContext());
        v();
    }

    private void s() {
        if (d.c().d() > 0) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(4);
        }
    }

    private void b(gl glVar) {
        this.u.setVisibility(glVar instanceof gi ? 0 : 4);
    }

    private void t() {
        if (gn.a().b() > 0 || !PersonalPrefs.a().p()) {
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(4);
        }
    }

    private void a(Runnable runnable, Runnable runnable2) {
        if (this.p != null) {
            t.b(runnable);
        } else if (!DkApp.get().isReady()) {
            DkApp.get().runWhenAppReady(new o(this, runnable, runnable2));
        } else if (this.B == 1) {
            this.p = new SurfingController$14(this, getContext());
            this.l[1] = this.p;
            this.k.addView(this.p.getContentView(), new ViewGroup.LayoutParams(-1, -1));
            addSubController(this.p);
            activate(this.p);
            t.b(runnable);
        } else {
            t.b(runnable2);
        }
    }

    private void b(Runnable runnable, Runnable runnable2) {
        if (this.o != null) {
            t.b(runnable);
        } else if (!DkApp.get().isReady()) {
            DkApp.get().runWhenAppReady(new p(this, runnable, runnable2));
        } else if (this.B == 2) {
            this.o = new bk(getContext());
            this.l[2] = this.o;
            this.k.addView(this.o.getContentView(), new ViewGroup.LayoutParams(-1, -1));
            addSubController(this.o);
            activate(this.o);
            t.b(runnable);
        } else {
            t.b(runnable2);
        }
    }

    private void c(Runnable runnable, Runnable runnable2) {
        if (this.q != null) {
            t.b(runnable);
        } else if (!DkApp.get().isReady()) {
            DkApp.get().runWhenAppReady(new q(this, runnable, runnable2));
        } else if (this.B == 3) {
            this.q = new fl(getContext());
            this.l[3] = this.q;
            this.k.addView(this.q.getContentView(), new ViewGroup.LayoutParams(-1, -1));
            addSubController(this.q);
            activate(this.q);
            t.b(runnable);
        } else {
            t.b(runnable2);
        }
    }

    private bl u() {
        return this.n.j();
    }

    private void v() {
        PersonalAccount personalAccount = (PersonalAccount) i.f().b(PersonalAccount.class);
        if (personalAccount != null && !personalAccount.i()) {
            try {
                Object string = PersonalPrefs.a().t().getString(StorePageController.PAY_CONTINUE, null);
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    String string2 = jSONObject.getString("msg");
                    String string3 = jSONObject.getString("btn");
                    String optString = jSONObject.optString("click");
                    ap apVar = new ap(getContext());
                    apVar.setCancelOnTouchOutside(false);
                    apVar.setPrompt(string2);
                    apVar.setOkLabel(string3);
                    apVar.open(new r(this, optString));
                }
            } catch (Exception e) {
            }
        }
    }

    public void onPrimaryClipChanged() {
        w();
    }

    private void w() {
        if (ManagedApp.get().getOldRunningState() == RunningState.FOREGROUND) {
            try {
                String b = b(this.s.getPrimaryClip().getItemAt(0).coerceToText(getContext()).toString());
                if (!TextUtils.isEmpty(b) && b.length() == 8) {
                    if (com.duokan.reader.common.c.f.b().e()) {
                        StorePageController storePageController = new StorePageController(getContext());
                        storePageController.loadUrl(com.duokan.reader.common.webservices.duokan.p.i().z() + "/hs/user/redeem/" + b + "?native_transparent=1");
                        this.s.setPrimaryClip(ClipData.newPlainText(null, null));
                        runAfterActive(new u(this, storePageController));
                        return;
                    }
                    ap apVar = new ap(getContext());
                    apVar.setPrompt(j.personal__personal_redeem_view__network_error);
                    apVar.setCancelLabel(j.general__shared__cancel);
                    apVar.setOkLabel(j.general__shared__retry);
                    apVar.setCancelOnBack(true);
                    apVar.setCancelOnTouchOutside(false);
                    apVar.open(new s(this));
                }
            } catch (Throwable th) {
            }
        }
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*多看(A[2-9][2-9A-HJ-NP-Z]{6}).*").matcher(str.toUpperCase());
        if (!matcher.matches() || matcher.groupCount() <= 0) {
            return "";
        }
        return matcher.group(1);
    }

    public void f() {
        x();
    }

    public void d() {
        a(PersonalPrefs.a().c());
    }

    private void x() {
        if ((PersonalPrefs.a().b() == 1 ? 1 : 0) != 0) {
            this.n.a(Arrays.asList(new Integer[]{Integer.valueOf(this.e), Integer.valueOf(this.g)}));
        } else {
            this.n.b(Arrays.asList(new Integer[]{Integer.valueOf(this.e), Integer.valueOf(this.g)}));
        }
    }

    private void a(Set set) {
        if (set != null) {
            this.z.clear();
            this.z.addAll(set);
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(this.g)}));
            if (set.contains(hk.a)) {
                arrayList.add(Integer.valueOf(this.f));
                arrayList2.remove(Integer.valueOf(this.f));
            }
            if (set.contains(hk.b) && set.contains(hk.c)) {
                arrayList.add(Integer.valueOf(this.e));
                arrayList2.remove(Integer.valueOf(this.e));
            }
            if (set.contains(hk.d)) {
                arrayList.add(Integer.valueOf(this.g));
                arrayList2.remove(Integer.valueOf(this.g));
            }
            if (arrayList.size() > 0) {
                this.n.a(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.n.b(arrayList2);
            }
        }
    }

    public void e() {
        q();
    }
}
