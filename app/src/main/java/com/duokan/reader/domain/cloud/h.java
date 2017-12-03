package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.database.Cursor;
import android.util.Pair;

import com.duokan.core.a.n;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.c;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class h implements ah, com.duokan.reader.domain.account.h {
    static final /* synthetic */ boolean a = (!h.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final Context c;
    private final i d;
    private final n e;
    private final LinkedList f = new LinkedList();
    private final LinkedList g = new LinkedList();
    private DkCloudStatisticsInfo h = null;

    private h(Context context, i iVar) {
        this.c = context;
        this.d = iVar;
        this.e = f.a();
        DkApp.get().runPreReady(new i(this));
    }

    public static void a(Context context, i iVar) {
        b.a(new h(context, iVar));
    }

    public static h a() {
        return (h) b.a();
    }

    public void a(c cVar) {
        this.h = k();
        this.h.mOpenedBook = new Pair(Long.valueOf(System.currentTimeMillis() / 1000), cVar);
    }

    public void b() {
        if (!a && this.h.mOpenedBook == null) {
            throw new AssertionError();
        } else if (this.h != null) {
            DkCloudStatisticsInfo dkCloudStatisticsInfo = this.h;
            dkCloudStatisticsInfo.mNewReadPages++;
        }
    }

    public void b(c cVar) {
        if (!a && this.h.mOpenedBook == null) {
            throw new AssertionError();
        } else if (!a && !((c) this.h.mOpenedBook.second).equals(cVar)) {
            throw new AssertionError();
        } else if (this.h != null && this.h.mOpenedBook != null && this.h.mOpenedBook.second != null && this.h.mOpenedBook.second == cVar) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long longValue = ((Long) this.h.mOpenedBook.first).longValue();
            HashMap hashMap = new HashMap(this.h.mNewDistribution);
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
            this.h.mNewDistribution = hashMap;
            DkCloudStatisticsInfo dkCloudStatisticsInfo = this.h;
            dkCloudStatisticsInfo.mNewReadSeconds += j;
            this.h.mOpenedBook = null;
            a(this.h);
            this.h = null;
        }
    }

    public void a(boolean z, p pVar) {
        b(z, pVar);
    }

    public long c() {
        return k().mTotalReadingBooks;
    }

    public long d() {
        return k().mTotalSeconds;
    }

    public long e() {
        return k().mTotalCompletedBooks;
    }

    public long f() {
        return k().mTotalDays;
    }

    public double g() {
        return k().mRankingRatio;
    }

    public long h() {
        return k().mLatestMonthReadingTime;
    }

    public int[] i() {
        int i = Calendar.getInstance().get(15) / miuipub.date.Calendar.MILLISECOND_OF_HOUR;
        int[] iArr = new int[24];
        for (int i2 = 0; i2 < 24; i2++) {
            iArr[((i2 + 24) + i) % 24] = k().mReadingTimeDistribution[i2];
        }
        return iArr;
    }

    public void a(o oVar) {
        if (a || oVar != null) {
            this.g.add(oVar);
            return;
        }
        throw new AssertionError();
    }

    public void b(o oVar) {
        if (a || oVar != null) {
            this.g.remove(oVar);
            return;
        }
        throw new AssertionError();
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
        f(aVar);
        j();
    }

    public void c(a aVar) {
        b(aVar.a());
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DkCloudStatisticsInfo dkCloudStatisticsInfo = (DkCloudStatisticsInfo) it.next();
            if (aVar != null && aVar.a() == Long.valueOf(dkCloudStatisticsInfo.getCloudId()).longValue()) {
                this.f.remove(dkCloudStatisticsInfo);
                break;
            }
        }
        f(aVar);
        j();
    }

    public void d(a aVar) {
    }

    private void j() {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((o) it.next()).a();
        }
    }

    private void b(boolean z, p pVar) {
        if (z || this.d.b()) {
            this.d.a(new j(this, z, pVar));
        } else {
            pVar.a("");
        }
    }

    private void a(boolean z, JSONObject jSONObject, p pVar) {
        if (z || this.d.b()) {
            this.d.a(new k(this, jSONObject, pVar, z));
        } else {
            pVar.a("");
        }
    }

    private JSONObject e(a aVar) {
        DkCloudStatisticsInfo a = a(aVar, false);
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

    private DkCloudStatisticsInfo f(a aVar) {
        return a(aVar, true);
    }

    private DkCloudStatisticsInfo a(a aVar, boolean z) {
        DkCloudStatisticsInfo dkCloudStatisticsInfo;
        boolean z2;
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            DkCloudStatisticsInfo dkCloudStatisticsInfo2 = (DkCloudStatisticsInfo) it.next();
            if (!aVar.i() || Long.valueOf(dkCloudStatisticsInfo2.getCloudId()).longValue() != -1) {
                if (!aVar.i() && aVar.a() == Long.valueOf(dkCloudStatisticsInfo2.getCloudId()).longValue()) {
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
            long a = aVar.i() ? -1 : aVar.a();
            DkCloudStatisticsInfo a2 = a(a);
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
            this.f.addLast(dkCloudStatisticsInfo);
        } else {
            z2 = false;
        }
        if (a || dkCloudStatisticsInfo != null) {
            if (z) {
                this.f.remove(dkCloudStatisticsInfo);
                this.f.addFirst(dkCloudStatisticsInfo);
            }
            if (z2) {
                a(false, null, new n(this));
            }
            return dkCloudStatisticsInfo;
        }
        throw new AssertionError();
    }

    private DkCloudStatisticsInfo k() {
        if (a || this.f.size() >= 1) {
            a b = this.d.b(PersonalAccount.class);
            if (!(b == null || b.i())) {
                Iterator it = this.f.iterator();
                while (it.hasNext()) {
                    DkCloudStatisticsInfo dkCloudStatisticsInfo = (DkCloudStatisticsInfo) it.next();
                    if (b.a() == dkCloudStatisticsInfo.getAccountId()) {
                        return dkCloudStatisticsInfo;
                    }
                }
            }
            return (DkCloudStatisticsInfo) this.f.getFirst();
        }
        throw new AssertionError();
    }

    public void a(DkCloudStatisticsInfo dkCloudStatisticsInfo) {
        synchronized (this.e) {
            this.e.b();
            try {
                this.e.a("REPLACE INTO statistics( owner_id,total_reading_books,total_seconds,total_books,total_completed_books,total_days,ranking_ratio,latest_month_reading_time,latest_month_ranking_ratio,reading_distribution,new_read_pages,new_read_seconds,new_distribution,last_sync_time) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{Long.valueOf(dkCloudStatisticsInfo.getAccountId()), Long.valueOf(dkCloudStatisticsInfo.getTotalReadingBooks()), Long.valueOf(dkCloudStatisticsInfo.getTotalSeconds()), Long.valueOf(dkCloudStatisticsInfo.getTotalBooks()), Long.valueOf(dkCloudStatisticsInfo.getTotalCompletedBooks()), Long.valueOf(dkCloudStatisticsInfo.getTotalDays()), Double.valueOf(dkCloudStatisticsInfo.getRankingRatio()), Long.valueOf(dkCloudStatisticsInfo.getLatestMonthReadingTime()), Double.valueOf(dkCloudStatisticsInfo.getLatestMonthRankingRatio()), dkCloudStatisticsInfo.getTotalDistributionByte(), Long.valueOf(dkCloudStatisticsInfo.getNewReadPages()), Long.valueOf(dkCloudStatisticsInfo.getNewReadSeconds()), dkCloudStatisticsInfo.getNewDistributionByte(), Long.valueOf(dkCloudStatisticsInfo.getLastSyncTime())});
                this.e.f();
                this.e.c();
            } catch (Exception e) {
                e.printStackTrace();
                this.e.c();
            } catch (Throwable th) {
                this.e.c();
            }
        }
    }

    public DkCloudStatisticsInfo a(long j) {
        DkCloudStatisticsInfo makeInfo;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        synchronized (this.e) {
            Cursor a;
            try {
                a = this.e.a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"statistics", "owner_id", Long.valueOf(j)}), null);
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

    public void b(long j) {
        synchronized (this.e) {
            try {
                this.e.a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"statistics", "owner_id", Long.valueOf(j)}));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
