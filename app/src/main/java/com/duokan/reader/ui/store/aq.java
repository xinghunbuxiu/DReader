package com.duokan.reader.ui.store;

import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.av;
import com.duokan.reader.domain.cloud.bb;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.epub.C0952s;
import com.duokan.reader.domain.document.sbk.C0969f;
import com.duokan.reader.domain.store.C1184j;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.reading.hy;
import java.util.LinkedList;

public abstract class aq {
    /* renamed from: a */
    protected static Integer[] m15260a(String str, boolean z, aw awVar) {
        int i = 0;
        DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.m5072a().m5101b(str);
        bb b2 = av.m5316a().m5334b();
        int i2;
        if ((C0800c.m4143o(str) ? b2.f3742c : b2.f3741b) > System.currentTimeMillis() && z && new C0650x(str).m3047b() == 0) {
            Integer[] numArr = new Integer[awVar.mo2525a()];
            for (i2 = 0; i2 < numArr.length; i2++) {
                numArr[i2] = Integer.valueOf(i2);
            }
            return numArr;
        } else if (b == null) {
            return new Integer[0];
        } else {
            if (b.isEntirePaid()) {
                Integer[] numArr2 = new Integer[awVar.mo2525a()];
                while (i < numArr2.length) {
                    numArr2[i] = Integer.valueOf(i);
                    i++;
                }
                return numArr2;
            }
            LinkedList linkedList = new LinkedList();
            for (i2 = 0; i2 < awVar.mo2525a(); i2++) {
                for (CharSequence equals : b.getPaidChaptersId()) {
                    if (TextUtils.equals(awVar.mo2526a(i2), equals)) {
                        linkedList.add(Integer.valueOf(i2));
                        break;
                    }
                }
            }
            return (Integer[]) linkedList.toArray(new Integer[0]);
        }
    }

    /* renamed from: a */
    public static void m15256a(AppContext appContext, ReaderFeature readerFeature, DkStoreFictionDetail dkStoreFictionDetail, long j, C1184j c1184j) {
        m15254a(readerFeature, dkStoreFictionDetail, j);
    }

    /* renamed from: a */
    public static void m15257a(AppContext appContext, hy hyVar, long j) {
        ee eeVar = (ee) hyVar.mo1992G();
        CharSequence a = hyVar.mo2356a(j);
        if (!TextUtils.isEmpty(a)) {
            ax axVar = new ax();
            axVar.f11336d.add(a);
            axVar.f11337e += (float) hyVar.mo2194g(j);
            axVar.f11333a = hyVar.mo2359b(j);
            new ay(appContext, eeVar.getId(), eeVar.ay(), axVar, eeVar.bh(), eeVar.bi(), new ar(appContext, eeVar, axVar)).show();
        }
    }

    /* renamed from: a */
    public static void m15259a(ReaderFeature readerFeature, C0800c c0800c, long j) {
        if (c0800c == null) {
            return;
        }
        if (j >= 0) {
            readerFeature.openBook(c0800c, c0800c.mo1039q() == BookFormat.EPUB ? C0952s.m6987a(j, 0, 0) : C0969f.m7162a(j, 0, 0), null);
        } else {
            readerFeature.openBook(c0800c);
        }
    }

    /* renamed from: a */
    public static C0800c m15254a(ReaderFeature readerFeature, DkStoreFictionDetail dkStoreFictionDetail, long j) {
        C0896a a = j >= 0 ? C0800c.m4142n(dkStoreFictionDetail.getFiction().getBookUuid()) ? C0952s.m6987a(j, 0, 0) : C0969f.m7162a(j, 0, 0) : null;
        return m15255a(readerFeature, dkStoreFictionDetail, a);
    }

    /* renamed from: a */
    public static C0800c m15255a(ReaderFeature readerFeature, DkStoreFictionDetail dkStoreFictionDetail, C0896a c0896a) {
        C0800c b = ai.m3980a().m3906b(dkStoreFictionDetail.getFiction().getBookUuid());
        if (b != null) {
            readerFeature.openBook(b, c0896a, null);
            return b;
        }
        b = ai.m3980a().m3874a(dkStoreFictionDetail);
        readerFeature.openBook(b, c0896a, null);
        return b;
    }

    /* renamed from: b */
    private static void m15261b(IFeature mFeature, DkStoreFictionDetail dkStoreFictionDetail, boolean z, String[] strArr, float f, C1184j c1184j) {
        C1502o.m15410a().m15428a(mFeature, dkStoreFictionDetail, z, strArr, f, c1184j);
    }
}
