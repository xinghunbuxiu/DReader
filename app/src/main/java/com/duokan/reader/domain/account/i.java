package com.duokan.reader.domain.account;

import android.content.Context;
import android.util.Base64;

import com.alipay.android.client.Aes;
import com.alipay.android.client.Rsa;
import com.duokan.core.a.n;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.o;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class i {
    static final /* synthetic */ boolean a = (!i.class.desiredAssertionStatus());
    private static i b = null;
    private final Context c;
    private final e d;
    private final n e;
    private final n f;
    private String g = null;
    private int h = 0;
    private final HashMap i = new HashMap();
    private final CopyOnWriteArrayList<h> j = new CopyOnWriteArrayList();

    public AccountType a() {
        if (b(PersonalAccount.class) == null && ((PersonalAccount) b(PersonalAccount.class)).i()) {
            return AccountType.NONE;
        }
        return ((PersonalAccount) b(PersonalAccount.class)).e();
    }

    public boolean a(a aVar) {
        boolean z = true;
        if (aVar == null || aVar.e() != a()) {
            return false;
        }
        if (aVar.e().equals(AccountType.XIAOMI_GUEST)) {
            if (aVar != b(MiGuestAccount.class)) {
                z = false;
            }
            return z;
        } else if (!aVar.e().equals(AccountType.XIAO_MI)) {
            return false;
        } else {
            if (aVar != b(MiAccount.class)) {
                z = false;
            }
            return z;
        }
    }

    private i(Context context) {
        this.c = context;
        this.f = ce.a();
        this.e = f.a();
        this.d = new j(this);
        DkApp.get().addActivityLifecycleMonitor(new LifeEvent(this));
    }

    public void add(h hVar) {
        this.j.addIfAbsent(hVar);
    }

    public void remove(h hVar) {
        this.j.remove(hVar);
    }

    public void a(c cVar) {
        TaskHandler.postTask(new m(this, cVar));
    }

    public void a(u uVar) {
        TaskHandler.a(new n(this, uVar));
    }

    public void a(Class cls, u uVar) {
        if (a || uVar != null) {
            TaskHandler.postTask(new p(this, cls, uVar));
            return;
        }
        throw new AssertionError();
    }

    public void a(Resp resp) {
        ((PersonalAccount) b(PersonalAccount.class)).a(resp);
    }

    public void a(String str, b bVar) {
        TaskHandler.a(new TaskHandler(this, bVar, str));
    }

    public synchronized boolean a(Class cls) {
        return !b(cls).i();
    }

    public synchronized boolean b() {
        return ((PersonalAccount) b(PersonalAccount.class)).n();
    }

    public synchronized UserAccount c() {
        UserAccount userAccount;
        userAccount = (UserAccount) b(MiGuestAccount.class);
        if (userAccount.i()) {
            userAccount = (UserAccount) b(MiAccount.class);
        }
        return userAccount;
    }

    public synchronized a b(Class cls) {
        a aVar;
        if (a || cls != null) {
            aVar = (a) this.i.get(cls);
            if (aVar == null) {
                try {
                    aVar = (a) cls.getConstructor(new Class[]{e.class}).newInstance(new Object[]{this.d});
                    aVar.k();
                } catch (Exception e) {
                    Exception exception = e;
                    a aVar2 = aVar;
                    exception.printStackTrace();
                    aVar = aVar2;
                }
                this.i.put(cls, aVar);
            }
        } else {
            throw new AssertionError();
        }
        return aVar;
    }

    public List d() {
        List linkedList = new LinkedList();
        if (MiAccount.a(this.c)) {
            linkedList.add("MI_SYSTEM");
        }
        linkedList.add("MI_LOCAL");
        if (ThirdWeiXin.isWeiXinInstalled(this.c)) {
            linkedList.add("WX_LOGIN");
        }
        return linkedList;
    }

    public synchronized ab e() {
        return new ab(b(PersonalAccount.class));
    }

    public static i f() {
        if (a || b != null) {
            return b;
        }
        throw new AssertionError();
    }

    public static void a(Context context) {
        if (a || b == null) {
            try {
                b = new i(context);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                if (!a) {
                    throw new AssertionError();
                }
                return;
            }
        }
        throw new AssertionError();
    }

    public void b(a aVar) {
        if (aVar instanceof UserAccount) {
            UserAccount userAccount = (UserAccount) aVar;
            if (userAccount.v() != null) {
                userAccount.t();
                userAccount.u();
            }
            if (aVar.e().equals(AccountType.XIAO_MI)) {
                a("MI_LOCAL");
            } else if (aVar.e().equals(AccountType.XIAOMI_GUEST)) {
                a("WX_LOGIN");
            }
        }
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(aVar);
        }
        it = this.j.iterator();
        while (it.hasNext()) {
            ((h) it.next()).b(aVar);
        }
    }

    public cf g() {
        MiGuestAccount miGuestAccount = (MiGuestAccount) b(MiGuestAccount.class);
        MiAccount miAccount = (MiAccount) b(MiAccount.class);
        if (miGuestAccount != null && miGuestAccount.v() != null) {
            return miGuestAccount.v();
        }
        if (miAccount == null || miAccount.v() == null) {
            return null;
        }
        return miAccount.v();
    }

    public User h() {
        MiGuestAccount miGuestAccount = (MiGuestAccount) b(MiGuestAccount.class);
        MiAccount miAccount = (MiAccount) b(MiAccount.class);
        if (miGuestAccount != null && !miGuestAccount.i()) {
            return ((bq) miGuestAccount.f()).d();
        }
        if (miAccount == null || miAccount.i()) {
            return null;
        }
        return miAccount.o().e.a;
    }

    private final void c(a aVar) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((h) it.next()).c(aVar);
        }
        a aVar2 = (AnonymousAccount) b(AnonymousAccount.class);
        if (aVar2 != null && !aVar2.i()) {
            f().b(aVar2);
        }
    }

    private final void d(a aVar) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((h) it.next()).d(aVar);
        }
    }

    public String i() {
        if (this.g == null) {
            AnonymousAccount anonymousAccount = (AnonymousAccount) b(AnonymousAccount.class);
            if (anonymousAccount != null) {
                this.g = anonymousAccount.b();
                try {
                    this.h = Integer.valueOf("" + this.g.charAt(this.g.length() - 1), 16).intValue() % DeviceGroup.values().length;
                } catch (Throwable th) {
                }
            }
        }
        return this.g;
    }

    public Set j() {
        AnonymousAccount anonymousAccount = (AnonymousAccount) b(AnonymousAccount.class);
        if (anonymousAccount != null) {
            return anonymousAccount.o();
        }
        return new HashSet();
    }

    public String a(long j) {
        byte[] encrypt;
        String str = null;
        String str2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC3zZXpKHRozglEzZrGhEo7pM9DikA51k6vXnsj3zYb4KzyJ9AixQuumn+FlrtYuBKuBAErK10YqNHTPkNDc0ErACnwv43rP37fOETsEiSB5vjMt7VOIP0WJsmkRWFlbvyD3yuM7KId5wEUsknVwZ278/l1fGHl8n97YSyNUyh9dQIDAQAB";
        try {
            encrypt = Aes.encrypt(i() + "," + j, o.b(j + "", "md5"), "\u0000");
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

    public String k() {
        return ReaderEnv.get().getPrefString(PrivatePref.PERSONAL, "last_login_type_pref", "");
    }

    private void a(String str) {
        ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "last_login_type_pref", str);
    }
}
