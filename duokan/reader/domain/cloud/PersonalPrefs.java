package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.classc;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PersonalPrefs implements classc.IConnectChanged, h {
    private static PersonalPrefs a;
    private final ReaderEnv b;
    private final Context c;
    private final i d;
    private final ConcurrentHashMap e = new ConcurrentHashMap();
    private final CopyOnWriteArrayList f = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList g = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList h = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList i = new CopyOnWriteArrayList();

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

    private PersonalPrefs(Context context, i iVar, classc.ConnectivityReceiver connectivity, ReaderEnv readerEnv) {
        this.c = context;
        this.d = iVar;
        this.b = readerEnv;
        this.d.add((h) this);
        connectivity.a((classc.IConnectChanged) this);
    }

    public static void a(Context context, i iVar, classc.ConnectivityReceiver connectivity, ReaderEnv readerEnv) {
        a = new PersonalPrefs(context, iVar, connectivity, readerEnv);
    }

    public static PersonalPrefs a() {
        return a;
    }

    public void a(hi hiVar) {
        this.f.add(hiVar);
    }

    public void b(hi hiVar) {
        this.f.remove(hiVar);
    }

    public void a(hg hgVar) {
        this.g.add(hgVar);
    }

    public void b(hg hgVar) {
        this.g.remove(hgVar);
    }

    public void a(hh hhVar) {
        this.h.add(hhVar);
    }

    public void b(hh hhVar) {
        this.h.remove(hhVar);
    }

    public void a(hj hjVar) {
        this.i.add(hjVar);
    }

    public void b(hj hjVar) {
        this.i.remove(hjVar);
    }

    public int b() {
        Set c = c();
        if (c == null) {
            return b(t());
        }
        if (c.isEmpty()) {
            return UserType.SERIALIZE.ordinal() + 1;
        }
        if (c.contains(hk.b) && !c.contains(hk.c)) {
            return UserType.MALE.ordinal() + 1;
        }
        if (c.contains(hk.c) && !c.contains(hk.b)) {
            return UserType.FEMALE.ordinal() + 1;
        }
        if (c.size() == 1 && c.contains(hk.a)) {
            return UserType.PUBLICATIONS.ordinal() + 1;
        }
        return b(t());
    }

    public void a(int i, boolean z) {
        int b = b();
        if (b != i) {
            b(t(), i);
            a(i);
            I();
            if (z) {
                a(i, b);
            }
        }
    }

    public Set c() {
        return c(t());
    }

    public String d() {
        return a(c());
    }

    public String a(Set set) {
        if (set == null) {
            return "";
        }
        Object obj = "";
        for (String str : set) {
            String str2 = obj + "," + str;
        }
        if (TextUtils.isEmpty(obj)) {
            return "empty";
        }
        return obj.substring(1);
    }

    public void a(Set set, boolean z) {
        if (set != null && !set.equals(c())) {
            a(t(), set);
            J();
            if (z) {
                c(a(set));
            }
        }
    }

    public void a(int i) {
        if (c() == null && i >= 1) {
            Set hashSet = new HashSet();
            switch (i) {
                case 1:
                    hashSet.add(hk.b);
                    hashSet.add(hk.c);
                    hashSet.add(hk.d);
                    break;
                case 3:
                    hashSet.add(hk.c);
                    break;
                case 4:
                    hashSet.add(hk.b);
                    break;
            }
            a(hashSet, true);
        }
    }

    public String e() {
        return t().getString("user_persona", "");
    }

    public LinkedList f() {
        Queue priorityQueue = new PriorityQueue(3, new gt(this));
        if (TextUtils.isEmpty(e())) {
            priorityQueue.add(new Pair(UserTab.SERIAL, Double.valueOf(1.0d)));
            priorityQueue.add(new Pair(UserTab.PUB, Double.valueOf(1.0d)));
            priorityQueue.add(new Pair(UserTab.COMIC, Double.valueOf(1.0d)));
        } else {
            try {
                JSONObject jSONObject = new JSONObject(e());
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
        LinkedList linkedList = new LinkedList();
        while (!priorityQueue.isEmpty()) {
            linkedList.add(((Pair) priorityQueue.poll()).first);
        }
        return linkedList;
    }

    public void a(String str) {
        Editor edit = t().edit();
        edit.putString("user_persona", str);
        edit.apply();
        K();
    }

    public int g() {
        return a(t());
    }

    public int a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getInt("user_gender", this.b.getUserGender());
    }

    public void b(int i, boolean z) {
        if (g() != i) {
            a(t(), i);
            h();
            if (z) {
                D();
            }
        }
    }

    public void h() {
        int g = g();
        if (g > 0 && c() == null) {
            a(g == UserGender.MALE.ordinal() ? UserType.MALE.ordinal() + 1 : UserType.FEMALE.ordinal() + 1);
        }
    }

    private void a(SharedPreferences sharedPreferences, int i) {
        Editor edit = sharedPreferences.edit();
        edit.putInt("user_gender", i);
        edit.apply();
    }

    public int i() {
        return t().getInt("user_favourite_count", 0);
    }

    public void b(int i) {
        Editor edit = t().edit();
        edit.putInt("user_favourite_count", i);
        edit.apply();
    }

    public boolean j() {
        return t().getBoolean("user_show_sign_in_panel", true);
    }

    public void a(boolean z) {
        Editor edit = t().edit();
        edit.putBoolean("user_show_sign_in_panel", z);
        edit.apply();
    }

    public boolean[] k() {
        boolean[] zArr = new boolean[]{false, false, false, false, false, false, false};
        String[] split = t().getString("global__sign_in_situation", "0,0,0,0,0,0,0").split(",");
        if (M() + L() > 7) {
            return zArr;
        }
        for (int i = 0; i < Math.min(split.length, zArr.length); i++) {
            if (i + 1 > M()) {
                zArr[i] = false;
            } else {
                zArr[i] = split[i].equals("1");
            }
        }
        return zArr;
    }

    public void b(String str) {
        Editor edit = t().edit();
        edit.putString("global__sign_in_situation", str);
        edit.apply();
    }

    public int l() {
        return (((M() + L()) - 1) % 7) + 1;
    }

    public void c(int i) {
        Editor edit = t().edit();
        edit.putInt("global__last_sign_in_index", i);
        edit.apply();
    }

    public boolean m() {
        return L() > 0;
    }

    public void d(int i) {
        Editor edit = t().edit();
        edit.putInt("global__last_sign_in_date", i);
        edit.apply();
    }

    public boolean n() {
        return !m() && t().getBoolean("global__has_lottery_chance", false);
    }

    public void b(boolean z) {
        Editor edit = t().edit();
        edit.putBoolean("global__has_lottery_chance", z);
        edit.apply();
    }

    public boolean o() {
        return t().getBoolean("add_book_from_store", false);
    }

    public void c(boolean z) {
        Editor edit = t().edit();
        edit.putBoolean("add_book_from_store", z);
        edit.apply();
    }

    public boolean p() {
        return t().getBoolean("enter_task_page", false);
    }

    public void d(boolean z) {
        Editor edit = t().edit();
        edit.putBoolean("enter_task_page", z);
        edit.apply();
    }

    public boolean q() {
        return t().getBoolean("show_booshelf_menu_once", false);
    }

    public void e(boolean z) {
        Editor edit = t().edit();
        edit.putBoolean("show_booshelf_menu_once", z);
        edit.apply();
    }

    public boolean r() {
        return t().getBoolean("is_message_arrived", false);
    }

    public void f(boolean z) {
        Editor edit = t().edit();
        edit.putBoolean("is_message_arrived", z);
        edit.apply();
    }

    public int s() {
        return (int) ((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000);
    }

    public boolean a(ab abVar) {
        if (abVar == null) {
            return false;
        }
        return abVar.a(new ab(this.d.b(PersonalAccount.class)));
    }

    public SharedPreferences t() {
        return e(this.d.c());
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
        z();
        u();
    }

    public void c(a aVar) {
        i(false);
        j(false);
    }

    public void d(a aVar) {
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        if ((connectivity.e() && ManagedApp.get().getOldRunningState() == RunningState.FOREGROUND) || connectivity.d()) {
            if (E()) {
                a(b(), b());
            } else {
                A();
            }
            if (F()) {
                c(a(c()));
            } else {
                B();
            }
            v();
        }
    }

    private int b(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getInt("new_user_type", H());
        } catch (Throwable th) {
            return H();
        }
    }

    private void b(SharedPreferences sharedPreferences, int i) {
        Editor edit = sharedPreferences.edit();
        edit.putInt("new_user_type", i);
        edit.apply();
    }

    private Set c(SharedPreferences sharedPreferences) {
        return sharedPreferences.getStringSet("user_channel", null);
    }

    private void a(SharedPreferences sharedPreferences, Set set) {
        Editor edit = sharedPreferences.edit();
        edit.putStringSet("user_channel", set);
        edit.apply();
    }

    private void z() {
        B();
        A();
        v();
    }

    private void A() {
        if (this.d.b()) {
            new gx(this).open();
        }
    }

    private void a(int i, int i2) {
        if (this.d.b()) {
            new gy(this, i, i2).open();
        }
    }

    private void B() {
        if (this.d.b()) {
            new gz(this).open();
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.d.b()) {
            new ha(this, str).open();
        }
    }

    public void u() {
        if (this.d.b()) {
            new hb(this).open();
        }
    }

    public void v() {
        if (this.d.b()) {
            new hc(this).open();
        } else {
            C();
        }
    }

    private void C() {
        h();
        if (c() == null) {
            a(c(G()), true);
            a(G(), null);
        }
        if (b() == 0) {
            a(b(G()), true);
            b(G(), 0);
        }
        if (g() == -1) {
            b(a(G()), true);
            a(G(), -1);
        }
    }

    private void D() {
        int g = g();
        if (g >= 0 && this.d.b()) {
            new hd(this, g).open();
        }
    }

    private boolean E() {
        return this.b.getPrefBoolean(PrivatePref.PERSONAL, "user_type_update", false);
    }

    private void i(boolean z) {
        this.b.setPrefBoolean(PrivatePref.PERSONAL, "user_type_update", z);
        this.b.commitPrefs();
    }

    private boolean F() {
        return this.b.getPrefBoolean(PrivatePref.PERSONAL, "user_channel_update", false);
    }

    private void j(boolean z) {
        this.b.setPrefBoolean(PrivatePref.PERSONAL, "user_channel_update", z);
        this.b.commitPrefs();
    }

    private SharedPreferences e(a aVar) {
        String str = "user-prefs@" + (aVar.i() ? "anon" : aVar.b());
        SharedPreferences sharedPreferences = (SharedPreferences) this.e.get(str);
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        this.e.putIfAbsent(str, this.c.getSharedPreferences(str, 0));
        return (SharedPreferences) this.e.get(str);
    }

    private SharedPreferences G() {
        String str = "user-prefs@anon";
        SharedPreferences sharedPreferences = (SharedPreferences) this.e.get("user-prefs@anon");
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        this.e.putIfAbsent("user-prefs@anon", this.c.getSharedPreferences("user-prefs@anon", 0));
        return (SharedPreferences) this.e.get("user-prefs@anon");
    }

    private int H() {
        try {
            return UserType.valueOf(this.b.getPrefString(PrivatePref.GLOBAL, "user_type", "").toUpperCase()).ordinal() + 1;
        } catch (Throwable th) {
            return 0;
        }
    }

    private void I() {
        TaskHandler.PostTask(new he(this));
    }

    private void J() {
        TaskHandler.PostTask(new gu(this));
    }

    private void K() {
        TaskHandler.PostTask(new gv(this));
    }

    private void k(boolean z) {
        TaskHandler.PostTask(new gw(this, z));
    }

    private int L() {
        return Math.max(s() - t().getInt("global__last_sign_in_date", s()), 0);
    }

    private int M() {
        return t().getInt("global__last_sign_in_index", 1);
    }

    public boolean w() {
        return t().getBoolean("show_purchased_dot", false);
    }

    public void g(boolean z) {
        if (w() != z) {
            a(t(), z);
            k(z);
        }
    }

    public void a(SharedPreferences sharedPreferences, boolean z) {
        Editor edit = sharedPreferences.edit();
        edit.putBoolean("show_purchased_dot", z);
        edit.apply();
    }

    public synchronized void h(boolean z) {
        this.b.setSyncEnabled(z);
    }

    public synchronized boolean x() {
        boolean z;
        if (this.d.a().equals(AccountType.ANONYMOUS)) {
            z = false;
        } else {
            z = this.b.getSyncEnabled();
        }
        return z;
    }

    public synchronized boolean y() {
        boolean z;
        if (this.d.a().equals(AccountType.ANONYMOUS)) {
            z = false;
        } else {
            z = this.b.getSyncBookshelfEnabled();
        }
        return z;
    }
}
