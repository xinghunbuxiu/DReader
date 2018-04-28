package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0562i;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonalPrefs implements C0562i, C0586j {
    /* renamed from: a */
    private static PersonalPrefs f3629a;
    /* renamed from: b */
    private final ReaderEnv f3630b;
    /* renamed from: c */
    private final Context f3631c;
    /* renamed from: d */
    private final C0709k f3632d;
    /* renamed from: e */
    private final ConcurrentHashMap<String, SharedPreferences> f3633e = new ConcurrentHashMap();
    /* renamed from: f */
    private final CopyOnWriteArrayList<go> f3634f = new CopyOnWriteArrayList();
    /* renamed from: g */
    private final CopyOnWriteArrayList<gm> f3635g = new CopyOnWriteArrayList();
    /* renamed from: h */
    private final CopyOnWriteArrayList<gn> f3636h = new CopyOnWriteArrayList();
    /* renamed from: i */
    private final CopyOnWriteArrayList<gp> f3637i = new CopyOnWriteArrayList();

    public enum UserGender {
        UNSPECIFIED,
        MALE,
        FEMALE
    }

    public enum UserTab {
        PUB,
        SERIAL,
        COMIC
    }

    public enum UserType {
        PUBLICATIONS,
        SERIALIZE,
        MALE,
        FEMALE
    }

    private PersonalPrefs(Context context, C0709k c0709k, C0559f c0559f, ReaderEnv readerEnv) {
        this.f3631c = context;
        this.f3632d = c0709k;
        this.f3630b = readerEnv;
        this.f3632d.m3494a((C0586j) this);
        c0559f.m2480a((C0562i) this);
    }

    /* renamed from: a */
    public static void m5177a(Context context, C0709k c0709k, C0559f c0559f, ReaderEnv readerEnv) {
        f3629a = new PersonalPrefs(context, c0709k, c0559f, readerEnv);
    }

    /* renamed from: a */
    public static PersonalPrefs m5175a() {
        return f3629a;
    }

    /* renamed from: a */
    public void m5204a(go goVar) {
        this.f3634f.addIfAbsent(goVar);
    }

    /* renamed from: b */
    public void m5215b(go goVar) {
        this.f3634f.remove(goVar);
    }

    /* renamed from: a */
    public void m5202a(gm gmVar) {
        this.f3635g.addIfAbsent(gmVar);
    }

    /* renamed from: b */
    public void m5213b(gm gmVar) {
        this.f3635g.remove(gmVar);
    }

    /* renamed from: a */
    public void m5203a(gn gnVar) {
        this.f3636h.addIfAbsent(gnVar);
    }

    /* renamed from: b */
    public void m5214b(gn gnVar) {
        this.f3636h.remove(gnVar);
    }

    /* renamed from: a */
    public void m5205a(gp gpVar) {
        this.f3637i.addIfAbsent(gpVar);
    }

    /* renamed from: b */
    public void m5216b(gp gpVar) {
        this.f3637i.remove(gpVar);
    }

    /* renamed from: b */
    public int m5210b() {
        Set c = m5219c();
        if (c == null) {
            return m5181b(m5244t());
        }
        if (c.isEmpty()) {
            return UserType.SERIALIZE.ordinal() + 1;
        }
        if (!c.contains(gq.f4063b) && c.contains(gq.f4064c)) {
            return UserType.MALE.ordinal() + 1;
        }
        if (!c.contains(gq.f4064c) && c.contains(gq.f4063b)) {
            return UserType.FEMALE.ordinal() + 1;
        }
        if (c.contains(gq.f4062a) || c.size() != 3) {
            return m5181b(m5244t());
        }
        return UserType.PUBLICATIONS.ordinal() + 1;
    }

    /* renamed from: a */
    public void m5199a(int i, boolean z) {
        int b = m5210b();
        if (b != i) {
            m5183b(m5244t(), i);
            m5198a(i);
            m5168J();
            if (z) {
                m5176a(i, b);
            }
        }
    }

    /* renamed from: c */
    public Set<String> m5219c() {
        return m5185c(m5244t());
    }

    /* renamed from: d */
    public String m5222d() {
        return m5197a(m5219c());
    }

    /* renamed from: a */
    public String m5197a(Set<String> set) {
        if (set == null) {
            return "";
        }
        Object obj = "";
        for (String str : set) {
            String obj2 = obj2 + "," + str;
        }
        if (TextUtils.isEmpty(obj2)) {
            return "empty";
        }
        return obj2.substring(1);
    }

    /* renamed from: a */
    public void m5207a(Set<String> set, boolean z) {
        if (set != null && !set.equals(m5219c())) {
            m5179a(m5244t(), (Set) set);
            m5169K();
            if (z) {
                m5187c(m5197a((Set) set));
            }
        }
    }

    /* renamed from: a */
    public void m5198a(int i) {
        if (m5219c() == null && i >= 1) {
            Set hashSet = new HashSet();
            switch (i) {
                case 1:
                    hashSet.add(gq.f4063b);
                    hashSet.add(gq.f4064c);
                    hashSet.add(gq.f4065d);
                    break;
                case 3:
                    hashSet.add(gq.f4064c);
                    break;
                case 4:
                    hashSet.add(gq.f4063b);
                    break;
            }
            m5207a(hashSet, true);
        }
    }

    /* renamed from: e */
    public String m5225e() {
        return m5244t().getString("user_persona", "");
    }

    /* renamed from: f */
    public LinkedList<UserTab> m5227f() {
        Queue priorityQueue = new PriorityQueue(3, new fz(this));
        if (TextUtils.isEmpty(m5225e())) {
            priorityQueue.add(new Pair(UserTab.SERIAL, Double.valueOf(1.0d)));
            priorityQueue.add(new Pair(UserTab.PUB, Double.valueOf(1.0d)));
            priorityQueue.add(new Pair(UserTab.COMIC, Double.valueOf(1.0d)));
        } else {
            try {
                JSONObject jSONObject = new JSONObject(m5225e());
                priorityQueue.add(new Pair(UserTab.PUB, Double.valueOf(jSONObject.optDouble("1", 0.0d))));
                priorityQueue.add(new Pair(UserTab.SERIAL, Double.valueOf(jSONObject.optDouble("2", 0.0d) + jSONObject.optDouble("3", 0.0d))));
                priorityQueue.add(new Pair(UserTab.COMIC, Double.valueOf(jSONObject.optDouble("4", 0.0d) + jSONObject.optDouble("5", 0.0d))));
            } catch (JSONException e) {
                priorityQueue.clear();
                priorityQueue.add(new Pair(UserTab.SERIAL, Double.valueOf(1.0d)));
                priorityQueue.add(new Pair(UserTab.PUB, Double.valueOf(1.0d)));
                priorityQueue.add(new Pair(UserTab.COMIC, Double.valueOf(1.0d)));
            }
        }
        LinkedList<UserTab> linkedList = new LinkedList();
        while (!priorityQueue.isEmpty()) {
            linkedList.add(((Pair) priorityQueue.poll()).first);
        }
        return linkedList;
    }

    /* renamed from: a */
    public void m5206a(String str) {
        Editor edit = m5244t().edit();
        edit.putString("user_persona", str);
        edit.apply();
        m5170L();
    }

    /* renamed from: g */
    public int m5229g() {
        return m5196a(m5244t());
    }

    /* renamed from: a */
    public int m5196a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getInt("user_gender", this.f3630b.getUserGender());
    }

    /* renamed from: b */
    public void m5212b(int i, boolean z) {
        if (m5229g() != i) {
            m5178a(m5244t(), i);
            m5231h();
            if (z) {
                m5163E();
            }
        }
    }

    /* renamed from: h */
    public void m5231h() {
        int g = m5229g();
        if (g > 0 && m5219c() == null) {
            m5198a(g == UserGender.MALE.ordinal() ? UserType.MALE.ordinal() + 1 : UserType.FEMALE.ordinal() + 1);
        }
    }

    /* renamed from: a */
    private void m5178a(SharedPreferences sharedPreferences, int i) {
        Editor edit = sharedPreferences.edit();
        edit.putInt("user_gender", i);
        edit.apply();
    }

    /* renamed from: i */
    public int m5233i() {
        return m5244t().getInt("user_favourite_count", 0);
    }

    /* renamed from: b */
    public void m5211b(int i) {
        Editor edit = m5244t().edit();
        edit.putInt("user_favourite_count", i);
        edit.apply();
    }

    /* renamed from: j */
    public boolean m5234j() {
        return m5244t().getBoolean("user_show_sign_in_panel", true);
    }

    /* renamed from: a */
    public void m5208a(boolean z) {
        Editor edit = m5244t().edit();
        edit.putBoolean("user_show_sign_in_panel", z);
        edit.apply();
    }

    /* renamed from: k */
    public boolean[] m5235k() {
        boolean[] zArr = new boolean[]{false, false, false, false, false, false, false};
        String[] split = m5244t().getString("global__sign_in_situation", "0,0,0,0,0,0,0").split(",");
        if (m5172N() + m5171M() > 7) {
            return zArr;
        }
        for (int i = 0; i < Math.min(split.length, zArr.length); i++) {
            if (i + 1 > m5172N()) {
                zArr[i] = false;
            } else {
                zArr[i] = split[i].equals("1");
            }
        }
        return zArr;
    }

    /* renamed from: b */
    public void m5217b(String str) {
        Editor edit = m5244t().edit();
        edit.putString("global__sign_in_situation", str);
        edit.apply();
    }

    /* renamed from: l */
    public int m5236l() {
        return (((m5172N() + m5171M()) - 1) % 7) + 1;
    }

    /* renamed from: c */
    public void m5220c(int i) {
        Editor edit = m5244t().edit();
        edit.putInt("global__last_sign_in_index", i);
        edit.apply();
    }

    /* renamed from: m */
    public boolean m5237m() {
        return m5171M() > 0;
    }

    /* renamed from: d */
    public void m5223d(int i) {
        Editor edit = m5244t().edit();
        edit.putInt("global__last_sign_in_date", i);
        edit.apply();
    }

    /* renamed from: n */
    public boolean m5238n() {
        return !m5237m() && m5244t().getBoolean("global__has_lottery_chance", false);
    }

    /* renamed from: b */
    public void m5218b(boolean z) {
        Editor edit = m5244t().edit();
        edit.putBoolean("global__has_lottery_chance", z);
        edit.apply();
    }

    /* renamed from: o */
    public boolean m5239o() {
        return m5244t().getBoolean("add_book_from_store", false);
    }

    /* renamed from: c */
    public void m5221c(boolean z) {
        Editor edit = m5244t().edit();
        edit.putBoolean("add_book_from_store", z);
        edit.apply();
    }

    /* renamed from: p */
    public boolean m5240p() {
        return m5244t().getBoolean("enter_task_page", false);
    }

    /* renamed from: d */
    public void m5224d(boolean z) {
        Editor edit = m5244t().edit();
        edit.putBoolean("enter_task_page", z);
        edit.apply();
    }

    /* renamed from: q */
    public boolean m5241q() {
        return m5244t().getBoolean("show_booshelf_menu_once", false);
    }

    /* renamed from: e */
    public void m5226e(boolean z) {
        Editor edit = m5244t().edit();
        edit.putBoolean("show_booshelf_menu_once", z);
        edit.apply();
    }

    /* renamed from: r */
    public boolean m5242r() {
        return m5244t().getBoolean("is_message_arrived", false);
    }

    /* renamed from: f */
    public void m5228f(boolean z) {
        Editor edit = m5244t().edit();
        edit.putBoolean("is_message_arrived", z);
        edit.apply();
    }

    /* renamed from: s */
    public int m5243s() {
        return (int) ((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000);
    }

    /* renamed from: a */
    public boolean m5209a(al alVar) {
        if (alVar == null) {
            return false;
        }
        return alVar.m3365a(new al(this.f3632d.m3502b(PersonalAccount.class)));
    }

    /* renamed from: t */
    public SharedPreferences m5244t() {
        return m5173a(this.f3632d.m3508d());
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m5246v();
        m5159A();
    }

    public void onAccountLogoff(C0672a c0672a) {
        m5193i(false);
        m5194j(false);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: a */
    public void mo949a(C0559f c0559f) {
        if (c0559f.m2486e() && ManagedApp.get().getRunningState() == RunningState.FOREGROUND) {
            m5246v();
            if (m5165G()) {
                m5187c(m5197a(m5219c()));
            } else {
                m5161C();
            }
            if (m5164F()) {
                m5176a(m5210b(), m5210b());
            } else {
                m5160B();
            }
            m5247w();
        }
    }

    /* renamed from: b */
    private int m5181b(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getInt("new_user_type", m5167I());
        } catch (Throwable th) {
            return m5167I();
        }
    }

    /* renamed from: b */
    private void m5183b(SharedPreferences sharedPreferences, int i) {
        Editor edit = sharedPreferences.edit();
        edit.putInt("new_user_type", i);
        edit.apply();
    }

    /* renamed from: c */
    private Set<String> m5185c(SharedPreferences sharedPreferences) {
        return sharedPreferences.getStringSet("user_channel", null);
    }

    /* renamed from: a */
    private void m5179a(SharedPreferences sharedPreferences, Set<String> set) {
        Editor edit = sharedPreferences.edit();
        edit.putStringSet("user_channel", set);
        edit.apply();
    }

    /* renamed from: A */
    private void m5159A() {
        m5161C();
        m5160B();
        m5247w();
    }

    /* renamed from: B */
    private void m5160B() {
        if (this.f3632d.m3507c()) {
            new gd(this, gl.f4061a).open();
        }
    }

    /* renamed from: a */
    private void m5176a(int i, int i2) {
        if (this.f3632d.m3507c()) {
            new ge(this, gl.f4061a, i, i2).open();
        }
    }

    /* renamed from: u */
    public void m5245u() {
        if (m5165G()) {
            m5187c(m5197a(m5219c()));
        } else {
            m5161C();
        }
    }

    /* renamed from: C */
    private void m5161C() {
        if (this.f3632d.m3507c()) {
            new gf(this, gl.f4061a).open();
        }
    }

    /* renamed from: c */
    private void m5187c(String str) {
        if (!TextUtils.isEmpty(str) && this.f3632d.m3507c()) {
            new gg(this, gl.f4061a, str).open();
        }
    }

    /* renamed from: v */
    public void m5246v() {
        if (this.f3632d.m3507c()) {
            new gh(this, gl.f4061a).open();
        }
    }

    /* renamed from: w */
    public void m5247w() {
        if (this.f3632d.m3507c()) {
            new gi(this, gl.f4061a).open();
        } else {
            m5162D();
        }
    }

    /* renamed from: D */
    private void m5162D() {
        m5231h();
        if (m5219c() == null) {
            m5207a(m5185c(m5166H()), true);
            m5179a(m5166H(), null);
        }
        if (m5210b() == 0) {
            m5199a(m5181b(m5166H()), true);
            m5183b(m5166H(), 0);
        }
        if (m5229g() == -1) {
            m5212b(m5196a(m5166H()), true);
            m5178a(m5166H(), -1);
        }
    }

    /* renamed from: E */
    private void m5163E() {
        int g = m5229g();
        if (g >= 0 && this.f3632d.m3507c()) {
            new gj(this, C0643q.f2173a, g).open();
        }
    }

    /* renamed from: F */
    private boolean m5164F() {
        return this.f3630b.getPrefBoolean(PrivatePref.PERSONAL, "user_type_update", false);
    }

    /* renamed from: i */
    private void m5193i(boolean z) {
        this.f3630b.setPrefBoolean(PrivatePref.PERSONAL, "user_type_update", z);
        this.f3630b.commitPrefs();
    }

    /* renamed from: G */
    private boolean m5165G() {
        return this.f3630b.getPrefBoolean(PrivatePref.PERSONAL, "user_channel_update", false);
    }

    /* renamed from: j */
    private void m5194j(boolean z) {
        this.f3630b.setPrefBoolean(PrivatePref.PERSONAL, "user_channel_update", z);
        this.f3630b.commitPrefs();
    }

    /* renamed from: a */
    private SharedPreferences m5173a(C0672a c0672a) {
        String str = "user-prefs@" + (c0672a.mo839i() ? "anon" : c0672a.mo832b());
        SharedPreferences sharedPreferences = (SharedPreferences) this.f3633e.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        this.f3633e.putIfAbsent(str, this.f3631c.getSharedPreferences(str, 0));
        return (SharedPreferences) this.f3633e.get(str);
    }

    /* renamed from: H */
    private SharedPreferences m5166H() {
        String str = "user-prefs@anon";
        SharedPreferences sharedPreferences = (SharedPreferences) this.f3633e.get("user-prefs@anon");
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        this.f3633e.putIfAbsent("user-prefs@anon", this.f3631c.getSharedPreferences("user-prefs@anon", 0));
        return (SharedPreferences) this.f3633e.get("user-prefs@anon");
    }

    /* renamed from: I */
    private int m5167I() {
        try {
            return UserType.valueOf(this.f3630b.getPrefString(PrivatePref.GLOBAL, "user_type", "").toUpperCase()).ordinal() + 1;
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: J */
    private void m5168J() {
        UThread.post(new gk(this));
    }

    /* renamed from: K */
    private void m5169K() {
        UThread.post(new ga(this));
    }

    /* renamed from: L */
    private void m5170L() {
        UThread.post(new gb(this));
    }

    /* renamed from: k */
    private void m5195k(boolean z) {
        UThread.post(new gc(this, z));
    }

    /* renamed from: M */
    private int m5171M() {
        return Math.max(m5243s() - m5244t().getInt("global__last_sign_in_date", m5243s()), 0);
    }

    /* renamed from: N */
    private int m5172N() {
        return m5244t().getInt("global__last_sign_in_index", 1);
    }

    /* renamed from: x */
    public boolean m5248x() {
        return m5244t().getBoolean("show_purchased_dot", false);
    }

    /* renamed from: g */
    public void m5230g(boolean z) {
        if (m5248x() != z) {
            m5200a(m5244t(), z);
            m5195k(z);
        }
    }

    /* renamed from: a */
    public void m5200a(SharedPreferences sharedPreferences, boolean z) {
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("show_purchased_dot", z);
        edit.apply();
    }

    /* renamed from: h */
    public synchronized void m5232h(boolean z) {
        this.f3630b.setSyncEnabled(z);
    }

    /* renamed from: y */
    public synchronized boolean m5249y() {
        boolean z;
        if (this.f3632d.m3501b().equals(AccountType.ANONYMOUS)) {
            z = false;
        } else {
            z = this.f3630b.getSyncEnabled();
        }
        return z;
    }

    /* renamed from: z */
    public synchronized boolean m5250z() {
        boolean z;
        if (this.f3632d.m3501b().equals(AccountType.ANONYMOUS)) {
            z = false;
        } else {
            z = this.f3630b.getSyncBookshelfEnabled();
        }
        return z;
    }
}
