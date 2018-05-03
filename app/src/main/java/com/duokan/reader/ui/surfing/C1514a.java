package com.duokan.reader.ui.surfing;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.duokan.core.app.ApplicationsStateCallbacks;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.ui.C0342j;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.cloud.PersonalPrefs.UserGender;
import com.duokan.reader.domain.cloud.gq;
import com.duokan.reader.domain.statistics.C1163a;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.ui.surfing.a */
public class C1514a extends C0342j implements ApplicationsStateCallbacks {
    /* renamed from: a */
    private final C1521h f11491a;
    /* renamed from: b */
    private final C1521h f11492b;
    /* renamed from: c */
    private final C1521h f11493c;
    /* renamed from: d */
    private final C1521h f11494d;
    /* renamed from: e */
    private final View f11495e;
    /* renamed from: f */
    private final Runnable f11496f;
    /* renamed from: g */
    private Set<String> f11497g = new HashSet();
    /* renamed from: h */
    private String f11498h = "";

    public C1514a(Context context, Runnable runnable) {
        super(context);
        setContentView(C0256h.general__choose_user_tendency_view);
        this.f11492b = new C1521h(this, context, C0254f.general__choose_user_tendency_view__male, context.getString(C0258j.welcome__choose_user_tendency_view__male), context.getString(C0258j.welcome__choose_user_tendency_view__male_desc));
        this.f11492b.setOnClickListener(new C1515b(this));
        this.f11493c = new C1521h(this, context, C0254f.general__choose_user_tendency_view__female, context.getString(C0258j.welcome__choose_user_tendency_view__female), context.getString(C0258j.welcome__choose_user_tendency_view__female_desc));
        this.f11493c.setOnClickListener(new C1516c(this));
        this.f11491a = new C1521h(this, context, C0254f.general__choose_user_tendency_view__pub, context.getString(C0258j.welcome__choose_user_tendency_view__pub), context.getString(C0258j.welcome__choose_user_tendency_view__pub_desc));
        this.f11491a.setOnClickListener(new C1517d(this));
        this.f11494d = new C1521h(this, context, C0254f.general__choose_user_tendency_view__comic, context.getString(C0258j.welcome__choose_user_tendency_view__comic), context.getString(C0258j.welcome__choose_user_tendency_view__comic_desc));
        this.f11494d.setOnClickListener(new C1518e(this));
        LinearLayout linearLayout = (LinearLayout) findViewById(C0255g.general__choose_user_tendency_view__content);
        linearLayout.addView(this.f11491a);
        linearLayout.addView(this.f11492b);
        linearLayout.addView(this.f11493c);
        linearLayout.addView(this.f11494d);
        this.f11495e = findViewById(C0255g.general__choose_user_tendency_view__confirm);
        this.f11495e.setOnClickListener(new C1519f(this));
        this.f11496f = runnable;
        setDimAmount(0.0f);
    }

    protected void onShow() {
        super.onShow();
        C1163a.m8627k().m8652b("expose", "", "");
        DkApp.get().addOnRunningStateChangedListener(this);
    }

    protected void onDismiss() {
        super.onDismiss();
        DkApp.get().removeOnRunningStateChangedListener(this);
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2 == RunningState.BACKGROUND) {
            C1163a.m8627k().m8652b("home", m15448a(this.f11497g), this.f11498h);
        }
    }

    protected boolean onBack() {
        PersonalPrefs.m5175a().m5212b(UserGender.UNSPECIFIED.ordinal(), true);
        PersonalPrefs.m5175a().m5206a("");
        C1163a.m8627k().m8652b("back", m15448a(this.f11497g), this.f11498h);
        m15449a();
        return true;
    }

    /* renamed from: a */
    private void m15451a(Set<String> set, boolean z) {
        String str = "";
        UserGender userGender = UserGender.UNSPECIFIED;
        String str2 = "";
        if (!set.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (set.contains(gq.f4062a)) {
                    str = str + "p";
                    jSONObject.put("1", 1);
                }
                if (set.contains(gq.f4065d)) {
                    str = str + "c";
                    jSONObject.put("4", 1);
                }
                if (set.contains(gq.f4063b)) {
                    userGender = UserGender.MALE;
                    str = str + "m";
                    jSONObject.put("2", 1);
                }
                if (set.contains(gq.f4064c)) {
                    userGender = UserGender.FEMALE;
                    str = str + "f";
                    jSONObject.put("3", 1);
                }
                if (set.contains(gq.f4063b) && set.contains(gq.f4064c)) {
                    userGender = UserGender.UNSPECIFIED;
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
            }
        }
        PersonalPrefs.m5175a().m5212b(userGender.ordinal(), z);
        PersonalPrefs.m5175a().m5206a(str2);
        if (z) {
            C1163a.m8627k().m8652b("start", str, this.f11498h);
            m15449a();
        }
    }

    /* renamed from: a */
    private String m15448a(Set<String> set) {
        String str = "";
        if (set.contains(gq.f4062a)) {
            str = str + "p";
        }
        if (set.contains(gq.f4065d)) {
            str = str + "c";
        }
        if (set.contains(gq.f4063b)) {
            str = str + "m";
        }
        if (set.contains(gq.f4064c)) {
            return str + "f";
        }
        return str;
    }

    /* renamed from: a */
    private void m15449a() {
        if (isShowing()) {
            AnimUtils.startAlphaAnimation(getContentView(), 1.0f, 0.0f, (int) HttpStatus.SC_OK, true, new C1520g(this));
        }
    }
}
