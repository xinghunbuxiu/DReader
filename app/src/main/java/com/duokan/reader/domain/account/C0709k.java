package com.duokan.reader.domain.account;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.alipay.android.client.Aes;
import com.alipay.android.client.Rsa;
import com.duokan.core.app.C0297a;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.p025a.IPermissionsResultListener;
import com.duokan.core.sys.p025a.Permissions;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.modelmsg.SendAuth$Resp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.duokan.reader.domain.account.k */
public class C0709k implements C0297a, IPermissionsResultListener {
    /* renamed from: a */
    static final /* synthetic */ boolean f2474a = (!C0709k.class.desiredAssertionStatus());
    /* renamed from: b */
    private static C0709k f2475b = null;
    /* renamed from: c */
    private final Context f2476c;
    /* renamed from: d */
    private final C0706e f2477d;
    /* renamed from: e */
    private final C0285n f2478e;
    /* renamed from: f */
    private final C0285n f2479f;
    /* renamed from: g */
    private final C0708i f2480g = new C0708i();
    /* renamed from: h */
    private final ao f2481h = new ao();
    /* renamed from: i */
    private String f2482i = null;
    /* renamed from: j */
    private int f2483j = 0;
    /* renamed from: k */
    private final HashMap<Class<? extends C0672a>, C0672a> f2484k = new HashMap();
    /* renamed from: l */
    private final CopyOnWriteArrayList<C0586j> f2485l = new CopyOnWriteArrayList();
    /* renamed from: m */
    private final ap f2486m;

    private C0709k(Context context) {
        this.f2476c = context;
        this.f2479f = ci.m3438a();
        this.f2478e = C0707f.m3460a();
        this.f2477d = new C0710l(this);
        this.f2486m = new ap(this.f2477d);
        DkApp.get().addActivityLifecycleMonitor(this);
        Permissions.getInstance().addPermissionsResultListener(this);
    }

    /* renamed from: a */
    public static C0709k m3476a() {
        if (f2474a || f2475b != null) {
            return f2475b;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static void m3478a(Context context) {
        if (f2474a || f2475b == null) {
            try {
                f2475b = new C0709k(context);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                if (!f2474a) {
                    throw new AssertionError();
                }
                return;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public AccountType m3501b() {
        if (m3502b(PersonalAccount.class) == null && ((PersonalAccount) m3502b(PersonalAccount.class)).mo839i()) {
            return AccountType.NONE;
        }
        return ((PersonalAccount) m3502b(PersonalAccount.class)).mo835e();
    }

    /* renamed from: a */
    public boolean m3499a(C0672a c0672a) {
        boolean z = true;
        if (c0672a == null || c0672a.mo835e() != m3501b()) {
            return false;
        }
        if (c0672a.mo835e().equals(AccountType.XIAOMI_GUEST)) {
            if (c0672a != m3502b(MiGuestAccount.class)) {
                z = false;
            }
            return z;
        } else if (!c0672a.mo835e().equals(AccountType.XIAO_MI)) {
            return false;
        } else {
            if (c0672a != m3502b(MiAccount.class)) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: a */
    public void m3494a(C0586j c0586j) {
        this.f2485l.addIfAbsent(c0586j);
    }

    /* renamed from: b */
    public void m3505b(C0586j c0586j) {
        this.f2485l.remove(c0586j);
    }

    /* renamed from: a */
    public void m3493a(C0699c c0699c) {
        UThread.runOnThread(new C0712n(this, c0699c));
    }

    /* renamed from: a */
    public void m3495a(C0666x c0666x) {
        UThread.runOnThread(new C0713o(this, c0666x));
    }

    /* renamed from: a */
    public void m3497a(Class<? extends C0672a> cls, C0666x c0666x) {
        if (f2474a || c0666x != null) {
            UThread.runOnThread(new C0734p(this, cls, c0666x));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m3496a(SendAuth$Resp sendAuth$Resp) {
        this.f2486m.m3373a((MiGuestAccount) m3502b(MiGuestAccount.class), sendAuth$Resp);
    }

    /* renamed from: a */
    public void m3498a(String str, C0420b c0420b) {
        UThread.runOnThread(new C0735q(this, c0420b, str));
    }

    /* renamed from: a */
    public synchronized boolean m3500a(Class<? extends C0672a> cls) {
        return !m3502b((Class) cls).mo839i();
    }

    /* renamed from: c */
    public synchronized boolean m3507c() {
        return ((PersonalAccount) m3502b(PersonalAccount.class)).mo843n();
    }

    /* renamed from: d */
    public synchronized UserAccount m3508d() {
        UserAccount userAccount;
        userAccount = (UserAccount) m3502b(MiGuestAccount.class);
        if (userAccount.mo839i()) {
            userAccount = (UserAccount) m3502b(MiAccount.class);
        }
        return userAccount;
    }

    /* renamed from: b */
    public synchronized <T extends C0672a> T m3502b(Class<T> cls) {
        T t;
        Exception e;
        t = (C0672a) this.f2484k.get(cls);
        if (t == null) {
            T a;
            try {
                a = this.f2480g.m3475a(cls).mo870a(this.f2477d);
                try {
                    a.mo841k();
                    t = a;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    t = a;
                    this.f2484k.put(cls, t);
                    return t;
                }
            } catch (Exception e3) {
                Exception exception = e3;
                a = t;
                e = exception;
                e.printStackTrace();
                t = a;
                this.f2484k.put(cls, t);
                return t;
            }
            this.f2484k.put(cls, t);
        }
        return t;
    }

    /* renamed from: e */
    public List<String> m3510e() {
        List<String> linkedList = new LinkedList();
        if (MiAccount.m3184a(this.f2476c)) {
            linkedList.add("MI_SYSTEM");
            if (MiAccount.m3186b(this.f2476c)) {
                linkedList.add("MI_LOCAL");
            }
        } else {
            linkedList.add("MI_LOCAL");
        }
        if (ThirdWeiXin.isWeiXinInstalled(this.f2476c)) {
            linkedList.add("WX_LOGIN");
        }
        return linkedList;
    }

    /* renamed from: f */
    public synchronized al m3511f() {
        return new al(m3502b(PersonalAccount.class));
    }

    /* renamed from: b */
    public void m3503b(C0672a c0672a) {
        m3484c(c0672a);
        Iterator it = this.f2485l.iterator();
        while (it.hasNext()) {
            ((C0586j) it.next()).onAccountLoginedTopHalf(c0672a);
        }
        it = this.f2485l.iterator();
        while (it.hasNext()) {
            ((C0586j) it.next()).onAccountLoginedBottomHalf(c0672a);
        }
    }

    /* renamed from: c */
    private void m3484c(C0672a c0672a) {
        if (c0672a instanceof UserAccount) {
            UserAccount userAccount = (UserAccount) c0672a;
            if (userAccount.mo852v() != null) {
                userAccount.mo850t();
                userAccount.mo851u();
            }
            if (c0672a.mo835e().equals(AccountType.XIAO_MI)) {
                m3480a("MI_LOCAL");
            } else if (c0672a.mo835e().equals(AccountType.XIAOMI_GUEST)) {
                m3480a("WX_LOGIN");
            }
        }
    }

    /* renamed from: g */
    public cm m3512g() {
        MiGuestAccount miGuestAccount = (MiGuestAccount) m3502b(MiGuestAccount.class);
        MiAccount miAccount = (MiAccount) m3502b(MiAccount.class);
        if (miGuestAccount != null && miGuestAccount.mo852v() != null) {
            return miGuestAccount.mo852v();
        }
        if (miAccount == null || miAccount.mo852v() == null) {
            return null;
        }
        return miAccount.mo852v();
    }

    /* renamed from: h */
    public User m3513h() {
        MiGuestAccount miGuestAccount = (MiGuestAccount) m3502b(MiGuestAccount.class);
        MiAccount miAccount = (MiAccount) m3502b(MiAccount.class);
        if (miGuestAccount != null && !miGuestAccount.mo839i()) {
            return ((bl) miGuestAccount.mo836f()).m3413d();
        }
        if (miAccount == null || miAccount.mo839i()) {
            return null;
        }
        return miAccount.mo848r().f2405e.f5458a;
    }

    /* renamed from: d */
    private void m3487d(C0672a c0672a) {
        Iterator it = this.f2485l.iterator();
        while (it.hasNext()) {
            ((C0586j) it.next()).onAccountLogoff(c0672a);
        }
        C0672a c0672a2 = (AnonymousAccount) m3502b(AnonymousAccount.class);
        if (c0672a2 != null && !c0672a2.mo839i()) {
            C0709k.m3476a().m3503b(c0672a2);
        }
    }

    /* renamed from: e */
    private void m3489e(C0672a c0672a) {
        Iterator it = this.f2485l.iterator();
        while (it.hasNext()) {
            ((C0586j) it.next()).onAccountDetailChanged(c0672a);
        }
    }

    /* renamed from: i */
    public String m3514i() {
        if (this.f2482i == null) {
            AnonymousAccount anonymousAccount = (AnonymousAccount) m3502b(AnonymousAccount.class);
            if (anonymousAccount != null) {
                this.f2482i = anonymousAccount.mo832b();
                try {
                    this.f2483j = Integer.valueOf("" + this.f2482i.charAt(this.f2482i.length() - 1), 16).intValue() % DeviceGroup.values().length;
                } catch (Throwable th) {
                }
            }
        }
        return this.f2482i;
    }

    /* renamed from: j */
    public Set<String> m3515j() {
        AnonymousAccount anonymousAccount = (AnonymousAccount) m3502b(AnonymousAccount.class);
        if (anonymousAccount != null) {
            return anonymousAccount.mo843n();
        }
        return new HashSet();
    }

    /* renamed from: a */
    public String m3491a(long j) {
        byte[] encrypt;
        String str = null;
        String str2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3zZXpKHRozglEzZrGhEo7pM9DikA51k6vXnsj3zYb4KzyJ9AixQuumn+FlrtYuBKuBAErK10YqNHTPkNDc0ErACnwv43rP37fOETsEiSB5vjMt7VOIP0WJsmkRWFlbvyD3yuM7KId5wEUsknVwZ278/l1fGHl8n97YSyNUyh9dQIDAQAB";
        try {
            encrypt = Aes.encrypt(m3514i() + "," + j, C0366o.m1034b(j + "", "md5"), "\u0000");
        } catch (Exception e) {
            e.printStackTrace();
            encrypt = str;
        }
        try {
            str = Base64.encodeToString(Rsa.encrypt(encrypt, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3zZXpKHRozglEzZrGhEo7pM9DikA51k6vXnsj3zYb4KzyJ9AixQuumn+FlrtYuBKuBAErK10YqNHTPkNDc0ErACnwv43rP37fOETsEiSB5vjMt7VOIP0WJsmkRWFlbvyD3yuM7KId5wEUsknVwZ278/l1fGHl8n97YSyNUyh9dQIDAQAB"), 2).replace("+", "-").replace("/", "_").replace("=", ".");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    /* renamed from: k */
    public String m3516k() {
        return ReaderEnv.get().getPrefString(PrivatePref.PERSONAL, "last_login_type_pref", "");
    }

    /* renamed from: a */
    private void m3480a(String str) {
        ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "last_login_type_pref", str);
    }

    /* renamed from: a */
    public synchronized void m3492a(C0420b c0420b) {
        this.f2486m.m3374a(new C0738t(this, c0420b));
    }

    /* renamed from: b */
    public synchronized void m3504b(C0420b c0420b) {
        this.f2486m.m3375b(new C0739u(this, c0420b));
    }

    /* renamed from: c */
    public synchronized void m3506c(C0420b c0420b) {
        this.f2486m.m3376c(new C0740v(this, c0420b));
    }

    /* renamed from: d */
    public synchronized void m3509d(C0420b c0420b) {
        this.f2486m.m3377d(new C0741w(this, c0420b));
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        UThread.postDelayed(new C0711m(this), 300);
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onSuccess() {
        m3503b(m3502b(PersonalAccount.class));
    }

    public void onFail() {
    }
}
