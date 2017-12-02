package com.duokan.reader.ui.store;

import android.text.TextUtils;

import com.duokan.core.app.x;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.domain.cloud.bd;
import com.duokan.reader.domain.cloud.bk;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.epub.s;
import com.duokan.reader.domain.document.sbk.f;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.j;
import com.duokan.reader.ui.reading.ho;

import java.util.LinkedList;

public abstract class aq {
    protected static Integer[] a(String str, boolean z, aw awVar) {
        int i = 0;
        DkCloudPurchasedFiction b = DkUserPurchasedFictionsManager.a().b(str);
        bk b2 = bd.a().b();
        int i2;
        if ((c.n(str) ? b2.c : b2.b) > System.currentTimeMillis() && z && new y(str).b() == 0) {
            Integer[] numArr = new Integer[awVar.a()];
            for (i2 = 0; i2 < numArr.length; i2++) {
                numArr[i2] = Integer.valueOf(i2);
            }
            return numArr;
        } else if (b == null) {
            return new Integer[0];
        } else {
            if (b.isEntirePaid()) {
                Integer[] numArr2 = new Integer[awVar.a()];
                while (i < numArr2.length) {
                    numArr2[i] = Integer.valueOf(i);
                    i++;
                }
                return numArr2;
            }
            LinkedList linkedList = new LinkedList();
            for (i2 = 0; i2 < awVar.a(); i2++) {
                for (CharSequence equals : b.getPaidChaptersId()) {
                    if (TextUtils.equals(awVar.a(i2), equals)) {
                        linkedList.add(Integer.valueOf(i2));
                        break;
                    }
                }
            }
            return (Integer[]) linkedList.toArray(new Integer[0]);
        }
    }

    public static void a(x xVar, ReaderFeature readerFeature, DkStoreFictionDetail dkStoreFictionDetail, long j, j jVar) {
        a(readerFeature, dkStoreFictionDetail, j);
    }

    public static void a(x xVar, ho hoVar, long j) {
        ej ejVar = (ej) hoVar.G();
        CharSequence a = hoVar.a(j);
        if (!TextUtils.isEmpty(a)) {
            ax axVar = new ax();
            axVar.d.add(a);
            axVar.e += (float) hoVar.g(j);
            axVar.a = hoVar.b(j);
            new ay(xVar, ejVar.H(), ejVar.aw(), axVar, ejVar.bf(), ejVar.bg(), new ar(xVar, ejVar, axVar)).show();
        }
    }

    public static void a(ReaderFeature readerFeature, c cVar, long j) {
        if (cVar == null) {
            return;
        }
        if (j >= 0) {
            readerFeature.openBook(cVar, cVar.q() == BookFormat.EPUB ? s.a(j, 0, 0) : f.a(j, 0, 0), null);
        } else {
            readerFeature.openBook(cVar);
        }
    }

    public static c a(ReaderFeature readerFeature, DkStoreFictionDetail dkStoreFictionDetail, long j) {
        a a = j >= 0 ? c.m(dkStoreFictionDetail.getFiction().getBookUuid()) ? s.a(j, 0, 0) : f.a(j, 0, 0) : null;
        return a(readerFeature, dkStoreFictionDetail, a);
    }

    public static c a(ReaderFeature readerFeature, DkStoreFictionDetail dkStoreFictionDetail, a aVar) {
        c b = ai.a().b(dkStoreFictionDetail.getFiction().getBookUuid());
        if (b != null) {
            readerFeature.openBook(b, aVar, null);
            return b;
        }
        b = ai.a().a(dkStoreFictionDetail);
        readerFeature.openBook(b, aVar, null);
        return b;
    }

    private static void b(com.duokan.core.app.y yVar, DkStoreFictionDetail dkStoreFictionDetail, boolean z, String[] strArr, float f, j jVar) {
        o.a().a(yVar, dkStoreFictionDetail, z, strArr, f, jVar);
    }
}
