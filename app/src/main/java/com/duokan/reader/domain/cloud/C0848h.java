package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.database.Cursor;
import android.util.Pair;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0707f;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.C0800c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.cloud.h */
public class C0848h implements ai, C0586j {
    /* renamed from: a */
    static final /* synthetic */ boolean f4066a = (!C0848h.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<C0848h> f4067b = new aj();
    /* renamed from: c */
    private final Context f4068c;
    /* renamed from: d */
    private final C0709k f4069d;
    /* renamed from: e */
    private final C0285n f4070e;
    /* renamed from: f */
    private final LinkedList<DkCloudStatisticsInfo> f4071f = new LinkedList();
    /* renamed from: g */
    private final LinkedList<C0854n> f4072g = new LinkedList();
    /* renamed from: h */
    private DkCloudStatisticsInfo f4073h = null;

    private C0848h(Context context, C0709k c0709k) {
        this.f4068c = context;
        this.f4069d = c0709k;
        this.f4070e = C0707f.m3460a();
        DkApp.get().runPreReady(new C0849i(this));
    }

    /* renamed from: a */
    public static void m5607a(Context context, C0709k c0709k) {
        f4067b.m709a(new C0848h(context, c0709k));
    }

    /* renamed from: a */
    public static C0848h m5604a() {
        return (C0848h) f4067b.m707a();
    }

    /* renamed from: a */
    public void m5616a(C0800c c0800c) {
        this.f4073h = m5614k();
        this.f4073h.mOpenedBook = new Pair(Long.valueOf(System.currentTimeMillis() / 1000), c0800c);
    }

    /* renamed from: b */
    public void m5620b() {
        if (!f4066a && this.f4073h.mOpenedBook == null) {
            throw new AssertionError();
        } else if (this.f4073h != null) {
            DkCloudStatisticsInfo dkCloudStatisticsInfo = this.f4073h;
            dkCloudStatisticsInfo.mNewReadPages++;
        }
    }

    /* renamed from: b */
    public void m5622b(C0800c c0800c) {
        if (!f4066a && this.f4073h.mOpenedBook == null) {
            throw new AssertionError();
        } else if (!f4066a && !((C0800c) this.f4073h.mOpenedBook.second).equals(c0800c)) {
            throw new AssertionError();
        } else if (this.f4073h != null && this.f4073h.mOpenedBook != null && this.f4073h.mOpenedBook.second != null && this.f4073h.mOpenedBook.second == c0800c) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long longValue = ((Long) this.f4073h.mOpenedBook.first).longValue();
            HashMap hashMap = new HashMap(this.f4073h.mNewDistribution);
            long j = 0;
            while (longValue < currentTimeMillis) {
                long min = Math.min(((3600 + longValue) / 3600) * 3600, currentTimeMillis);
                long j2 = ((longValue / 3600) * 3600) / 100;
                long j3 = min - longValue;
                if (hashMap.containsKey(Long.valueOf(j2))) {
                    hashMap.put(Long.valueOf(j2), Long.valueOf(((Long) hashMap.get(Long.valueOf(j2))).longValue() + j3));
                } else {
                    hashMap.put(Long.valueOf(j2), Long.valueOf(j3));
                }
                j += j3;
                longValue = min;
            }
            this.f4073h.mNewDistribution = hashMap;
            DkCloudStatisticsInfo dkCloudStatisticsInfo = this.f4073h;
            dkCloudStatisticsInfo.mNewReadSeconds += j;
            this.f4073h.mOpenedBook = null;
            m5617a(this.f4073h);
            this.f4073h = null;
        }
    }

    /* renamed from: a */
    public void m5619a(boolean z, C0811o c0811o) {
        m5612b(z, c0811o);
    }

    /* renamed from: c */
    public long m5624c() {
        return m5614k().mTotalReadingBooks;
    }

    /* renamed from: d */
    public long m5625d() {
        return m5614k().mTotalSeconds;
    }

    /* renamed from: e */
    public long m5626e() {
        return m5614k().mTotalCompletedBooks;
    }

    /* renamed from: f */
    public long m5627f() {
        return m5614k().mTotalDays;
    }

    /* renamed from: g */
    public double m5628g() {
        return m5614k().mRankingRatio;
    }

    /* renamed from: h */
    public long m5629h() {
        return m5614k().mLatestMonthReadingTime;
    }

    /* renamed from: i */
    public int[] m5630i() {
        int i = Calendar.getInstance().get(15) / miuipub.date.Calendar.MILLISECOND_OF_HOUR;
        int[] iArr = new int[24];
        for (int i2 = 0; i2 < 24; i2++) {
            iArr[((i2 + 24) + i) % 24] = m5614k().mReadingTimeDistribution[i2];
        }
        return iArr;
    }

    /* renamed from: a */
    public void m5618a(C0854n c0854n) {
        if (f4066a || c0854n != null) {
            this.f4072g.add(c0854n);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public void m5623b(C0854n c0854n) {
        if (f4066a || c0854n != null) {
            this.f4072g.remove(c0854n);
            return;
        }
        throw new AssertionError();
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        m5610b(c0672a);
        m5613j();
    }

    public void onAccountLogoff(C0672a c0672a) {
        m5621b(c0672a.mo853a());
        Iterator it = this.f4071f.iterator();
        while (it.hasNext()) {
            DkCloudStatisticsInfo dkCloudStatisticsInfo = (DkCloudStatisticsInfo) it.next();
            if (c0672a != null && c0672a.mo853a() == Long.valueOf(dkCloudStatisticsInfo.getCloudId()).longValue()) {
                this.f4071f.remove(dkCloudStatisticsInfo);
                break;
            }
        }
        m5610b(c0672a);
        m5613j();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }

    /* renamed from: j */
    private void m5613j() {
        Iterator it = this.f4072g.iterator();
        while (it.hasNext()) {
            ((C0854n) it.next()).mo1913a();
        }
    }

    /* renamed from: b */
    private void m5612b(boolean z, C0811o c0811o) {
        if (z || this.f4069d.m3507c()) {
            this.f4069d.m3495a(new C0850j(this, z, c0811o));
        } else {
            c0811o.mo1089a("");
        }
    }

    /* renamed from: a */
    private void m5609a(boolean z, JSONObject jSONObject, C0811o c0811o) {
        if (z || this.f4069d.m3507c()) {
            this.f4069d.m3495a(new C0851k(this, jSONObject, c0811o, z));
        } else {
            c0811o.mo1089a("");
        }
    }

    /* renamed from: a */
    private JSONObject m5605a(C0672a c0672a) {
        DkCloudStatisticsInfo a = m5602a(c0672a, false);
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = ((System.currentTimeMillis() / 1000) / 3600) * 3600;
        for (Entry entry : a.mNewDistribution.entrySet()) {
            long longValue = ((Long) entry.getKey()).longValue();
            long longValue2 = ((Long) entry.getValue()).longValue();
            if (100 * longValue < currentTimeMillis) {
                jSONObject.put("" + longValue, longValue2);
            }
        }
        return jSONObject;
    }

    /* renamed from: b */
    private DkCloudStatisticsInfo m5610b(C0672a c0672a) {
        return m5602a(c0672a, true);
    }

    /* renamed from: a */
    private DkCloudStatisticsInfo m5602a(C0672a c0672a, boolean z) {
        DkCloudStatisticsInfo dkCloudStatisticsInfo;
        boolean z2;
        Iterator it = this.f4071f.iterator();
        while (it.hasNext()) {
            DkCloudStatisticsInfo dkCloudStatisticsInfo2 = (DkCloudStatisticsInfo) it.next();
            if (!c0672a.mo839i() || Long.valueOf(dkCloudStatisticsInfo2.getCloudId()).longValue() != -1) {
                if (!c0672a.mo839i() && c0672a.mo853a() == Long.valueOf(dkCloudStatisticsInfo2.getCloudId()).longValue()) {
                    dkCloudStatisticsInfo = dkCloudStatisticsInfo2;
                    break;
                }
            } else {
                dkCloudStatisticsInfo = dkCloudStatisticsInfo2;
                break;
            }
        }
        dkCloudStatisticsInfo = null;
        if (dkCloudStatisticsInfo == null) {
            long a = c0672a.mo839i() ? -1 : c0672a.mo853a();
            DkCloudStatisticsInfo a2 = m5615a(a);
            if (a2 == null) {
                a2 = new DkCloudStatisticsInfo(a);
                if (a != -1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                dkCloudStatisticsInfo = a2;
            } else {
                z2 = false;
                dkCloudStatisticsInfo = a2;
            }
            this.f4071f.addLast(dkCloudStatisticsInfo);
        } else {
            z2 = false;
        }
        if (f4066a || dkCloudStatisticsInfo != null) {
            if (z) {
                this.f4071f.remove(dkCloudStatisticsInfo);
                this.f4071f.addFirst(dkCloudStatisticsInfo);
            }
            if (z2) {
                m5609a(false, null, new C0853m(this));
            }
            return dkCloudStatisticsInfo;
        }
        throw new AssertionError();
    }

    /* renamed from: k */
    private DkCloudStatisticsInfo m5614k() {
        if (f4066a || this.f4071f.size() >= 1) {
            C0672a b = this.f4069d.m3502b(PersonalAccount.class);
            if (!(b == null || b.mo839i())) {
                Iterator it = this.f4071f.iterator();
                while (it.hasNext()) {
                    DkCloudStatisticsInfo dkCloudStatisticsInfo = (DkCloudStatisticsInfo) it.next();
                    if (b.mo853a() == dkCloudStatisticsInfo.getAccountId()) {
                        return dkCloudStatisticsInfo;
                    }
                }
            }
            return (DkCloudStatisticsInfo) this.f4071f.getFirst();
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void m5617a(DkCloudStatisticsInfo dkCloudStatisticsInfo) {
        synchronized (this.f4070e) {
            this.f4070e.m677b();
            try {
                this.f4070e.m674a("REPLACE INTO statistics( owner_id,total_reading_books,total_seconds,total_books,total_completed_books,total_days,ranking_ratio,latest_month_reading_time,latest_month_ranking_ratio,reading_distribution,new_read_pages,new_read_seconds,new_distribution,last_sync_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{Long.valueOf(dkCloudStatisticsInfo.getAccountId()), Long.valueOf(dkCloudStatisticsInfo.getTotalReadingBooks()), Long.valueOf(dkCloudStatisticsInfo.getTotalSeconds()), Long.valueOf(dkCloudStatisticsInfo.getTotalBooks()), Long.valueOf(dkCloudStatisticsInfo.getTotalCompletedBooks()), Long.valueOf(dkCloudStatisticsInfo.getTotalDays()), Double.valueOf(dkCloudStatisticsInfo.getRankingRatio()), Long.valueOf(dkCloudStatisticsInfo.getLatestMonthReadingTime()), Double.valueOf(dkCloudStatisticsInfo.getLatestMonthRankingRatio()), dkCloudStatisticsInfo.getTotalDistributionByte(), Long.valueOf(dkCloudStatisticsInfo.getNewReadPages()), Long.valueOf(dkCloudStatisticsInfo.getNewReadSeconds()), dkCloudStatisticsInfo.getNewDistributionByte(), Long.valueOf(dkCloudStatisticsInfo.getLastSyncTime())});
                this.f4070e.m681f();
                this.f4070e.m678c();
            } catch (Exception e) {
                e.printStackTrace();
                this.f4070e.m678c();
            } catch (Throwable th) {
                this.f4070e.m678c();
            }
        }
    }

    /* renamed from: a */
    public DkCloudStatisticsInfo m5615a(long j) {
        DkCloudStatisticsInfo makeInfo;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        synchronized (this.f4070e) {
            Cursor a;
            try {
                a = this.f4070e.m670a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"statistics", "owner_id", Long.valueOf(j)}), null);
                if (a != null) {
                    try {
                        if (a.moveToFirst()) {
                            makeInfo = DkCloudStatisticsInfo.makeInfo(a);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (a != null) {
                                if (!a.isClosed()) {
                                    a.close();
                                }
                            }
                            return makeInfo;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = a;
                            if (cursor != null) {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (a != null) {
                    if (!a.isClosed()) {
                        a.close();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                e.printStackTrace();
                if (a != null) {
                    if (a.isClosed()) {
                        a.close();
                    }
                }
                return makeInfo;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    if (cursor.isClosed()) {
                        cursor.close();
                    }
                }
                throw th;
            }
        }
        return makeInfo;
    }

    /* renamed from: b */
    public void m5621b(long j) {
        synchronized (this.f4070e) {
            try {
                this.f4070e.m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"statistics", "owner_id", Long.valueOf(j)}));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
