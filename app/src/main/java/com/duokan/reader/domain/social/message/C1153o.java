package com.duokan.reader.domain.social.message;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.sys.p025a.IPermissionsResultListener;
import com.duokan.core.sys.p025a.Permissions;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.cloud.push.MessageWakeupListener;

/* renamed from: com.duokan.reader.domain.social.message.o */
public class C1153o implements ai, IPermissionsResultListener, C0586j, MessageWakeupListener {
    /* renamed from: h */
    private static final aj<C1153o> f5562h = new aj();
    /* renamed from: a */
    private long f5563a = 0;
    /* renamed from: b */
    private final C0709k f5564b;
    /* renamed from: c */
    private final int[] f5565c;
    /* renamed from: d */
    private long f5566d = 600000;
    /* renamed from: e */
    private final C1161v f5567e = new C1161v();
    /* renamed from: f */
    private al f5568f = al.f2359g;
    /* renamed from: g */
    private String f5569g = "";

    private C1153o(Context context, C0709k c0709k, int[] iArr) {
        this.f5564b = c0709k;
        this.f5564b.m3494a((C0586j) this);
        this.f5565c = iArr;
        Permissions.getInstance().addPermissionsResultListener(this);
    }

    /* renamed from: a */
    public static void m8592a(Context context, C0709k c0709k, int[] iArr) {
        f5562h.m709a(new C1153o(context, c0709k, iArr));
    }

    /* renamed from: a */
    public static C1153o m8590a() {
        return (C1153o) f5562h.m707a();
    }

    /* renamed from: a */
    public void m8599a(C1137x c1137x) {
        this.f5567e.m8612a(c1137x);
    }

    /* renamed from: a */
    public void mo785a(MessageSubType messageSubType, Object obj, boolean z) {
        if (MessageSubType.MESSAGE_LOOPER == messageSubType) {
            this.f5563a = System.currentTimeMillis();
            m8594c();
        }
    }

    /* renamed from: b */
    public void m8601b() {
        m8594c();
        DkApp.get().runWhenAppReady(new C1154p(this));
    }

    /* renamed from: a */
    public void m8600a(boolean z, C1158z c1158z) {
        if (z || !this.f5568f.m3364a()) {
            this.f5564b.m3497a(PersonalAccount.class, new C1155q(this, c1158z));
        } else {
            c1158z.mo1521a(false, false);
        }
    }

    /* renamed from: c */
    private void m8594c() {
        m8600a(false, new C1159t(this));
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f5568f = new al(this.f5564b.m3502b(PersonalAccount.class));
        this.f5569g = ReaderEnv.get().getPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.f5568f.f2362c, "");
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m8600a(false, new C1160u(this));
    }

    public void onAccountLogoff(C0672a c0672a) {
        this.f5569g = "";
        if (!(this.f5568f == null || this.f5568f.m3364a())) {
            ReaderEnv.get().setPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.f5568f.f2362c, this.f5569g);
        }
        this.f5568f = new al(null);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    public void onSuccess() {
        this.f5568f = new al(this.f5564b.m3502b(PersonalAccount.class));
        if (!this.f5568f.m3364a()) {
            this.f5569g = ReaderEnv.get().getPrefString(PrivatePref.PERSONAL, "latest_unread_message_threshold_pref_" + this.f5568f.f2362c, "");
        }
    }

    public void onFail() {
    }
}
