package com.duokan.reader.ui.store;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter.ChapterState;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.domain.cmread.CmBookManager;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.payment.C1089s;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.C1184j;
import com.duokan.reader.domain.store.C1186l;
import com.duokan.reader.domain.store.C1187m;
import com.duokan.reader.domain.store.C1192r;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.ja;
import java.util.HashSet;

/* renamed from: com.duokan.reader.ui.store.o */
public class C1502o implements ai, C1186l {
    /* renamed from: a */
    static final /* synthetic */ boolean f11456a = (!C1502o.class.desiredAssertionStatus());
    /* renamed from: b */
    private static final aj<C1502o> f11457b = new aj();
    /* renamed from: c */
    private final Context f11458c;
    /* renamed from: d */
    private final C1176a f11459d;
    /* renamed from: e */
    private final DkCloudStorage f11460e;
    /* renamed from: f */
    private final com.duokan.reader.domain.bookshelf.ai f11461f;
    /* renamed from: g */
    private final HashSet<String> f11462g = new HashSet();

    private C1502o(Context context, C1176a c1176a, DkCloudStorage dkCloudStorage, C0559f c0559f, C1016b c1016b, com.duokan.reader.domain.bookshelf.ai aiVar) {
        this.f11458c = context;
        this.f11459d = c1176a;
        this.f11460e = dkCloudStorage;
        this.f11461f = aiVar;
        DkApp.get().runPreReady(new C1503p(this));
    }

    /* renamed from: a */
    public static void m15411a(Context context, C1176a c1176a, DkCloudStorage dkCloudStorage, C0559f c0559f, C1016b c1016b, com.duokan.reader.domain.bookshelf.ai aiVar) {
        f11457b.m709a(new C1502o(context, c1176a, dkCloudStorage, c0559f, c1016b, aiVar));
    }

    /* renamed from: a */
    public static C1502o m15410a() {
        return (C1502o) f11457b.m707a();
    }

    /* renamed from: a */
    public boolean m15434a(String str) {
        return this.f11462g.contains(str);
    }

    /* renamed from: b */
    public void m15435b(String str) {
        this.f11462g.add(str);
    }

    /* renamed from: c */
    public void m15436c(String str) {
        this.f11462g.remove(str);
    }

    /* renamed from: a */
    public void m15429a(C0800c c0800c, ah ahVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.f11462g.add(c0800c.m4156I());
        this.f11459d.m8703a(c0800c.m4156I(), false, new C1511x(this, c0800c, flowChargingTransferChoice, ahVar));
    }

    /* renamed from: a */
    public void m15428a(IFeature mFeature, DkStoreFictionDetail dkStoreFictionDetail, boolean z, String[] strArr, float f, C1184j c1184j) {
        if (!f11456a && c1184j == null) {
            throw new AssertionError();
        } else if (new C0650x(dkStoreFictionDetail.getFiction().getBookUuid()).m3047b() != 1) {
        }
    }

    /* renamed from: a */
    public void m15431a(String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            alVar.onDownloadCloudBookError("");
            return;
        }
        this.f11462g.add(str);
        if (dkStoreBookDetail == null) {
            ja jaVar = new ja(topActivity);
            jaVar.m10843a(this.f11458c.getString(C0247i.bookcity_store__shared__creating_order));
            jaVar.m10844a(true);
            jaVar.setCancelOnBack(false);
            jaVar.setCancelOnTouchOutside(false);
            jaVar.show();
            this.f11459d.m8703a(str, false, new aa(this, jaVar, str, alVar, flowChargingTransferChoice));
            return;
        }
        m15421b(str, dkStoreBookDetail, new ac(this, str, alVar), flowChargingTransferChoice);
    }

    /* renamed from: a */
    public void m15432a(String str, String str2, short s, an anVar) {
        C0709k.m3476a().m3497a(PersonalAccount.class, new ad(this, str, str2, anVar));
    }

    /* renamed from: a */
    public static void m15413a(DkStoreFictionDetail dkStoreFictionDetail) {
        int i = 0;
        if (new C0650x(dkStoreFictionDetail.getFiction().getBookUuid()).m3047b() != 1) {
            Integer[] a = aq.m15260a(dkStoreFictionDetail.getFiction().getBookUuid(), dkStoreFictionDetail.allowFreeRead(), new ag(dkStoreFictionDetail));
            while (i < a.length) {
                dkStoreFictionDetail.getToc()[a[i].intValue()].setChapterState(ChapterState.ORDER);
                i++;
            }
        } else if (CmBookManager.get().getPurchaseInfo(dkStoreFictionDetail.getFiction().getBookUuid()) != null) {
            DkCloudFictionChapter[] toc = dkStoreFictionDetail.getToc();
            int length = toc.length;
            while (i < length) {
                DkCloudFictionChapter dkCloudFictionChapter = toc[i];
                if (CmBookManager.get().getPurchaseInfo(dkStoreFictionDetail.getFiction().getBookUuid()).mPurchasedChapterIds.contains(dkCloudFictionChapter.getCloudId())) {
                    dkCloudFictionChapter.setChapterState(ChapterState.ORDER);
                }
                i++;
            }
        }
    }

    /* renamed from: d */
    public static void m15426d(String str) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity != null && !topActivity.isFinishing() && !TextUtils.isEmpty(str)) {
            ak akVar = new ak(topActivity);
            akVar.setPrompt(str);
            akVar.addButtonView(C0247i.general__shared__confirm);
            akVar.show();
            akVar.setOnButtonClickedListener(new ah(akVar));
        }
    }

    /* renamed from: a */
    public static void m15417a(String str, am amVar) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            amVar.mo1843b();
        } else if (TextUtils.isEmpty(str) || !DkPublic.isVersionLessorThen(ReaderEnv.get().getKernelVersion(), str)) {
            amVar.mo1842a();
        } else {
            ap aiVar = new ai(topActivity, amVar);
            aiVar.setTitle(C0247i.store__kernel_support_view__title);
            aiVar.setPrompt(C0247i.store__kernel_support_view__message);
            aiVar.setCancelLabel(C0247i.general__shared__cancel);
            aiVar.setOkLabelResid(C0247i.store__kernel_support_view__continue_download);
            aiVar.show();
        }
    }

    /* renamed from: a */
    public void mo2540a(C1187m c1187m, String str, DkStoreCallback dkStoreCallback) {
        if (!f11456a && c1187m == null) {
            throw new AssertionError();
        } else if (!f11456a && dkStoreCallback == null) {
            throw new AssertionError();
        } else if (c1187m.m8721g() || c1187m.m8719e() == c1187m.m8720f()) {
            m15423c(c1187m, str, dkStoreCallback);
        } else {
            m15419b(c1187m, str, dkStoreCallback);
        }
    }

    @Deprecated
    /* renamed from: a */
    public void m15433a(String str, boolean z, boolean z2, int i, int i2, int i3, C0466h c0466h) {
        this.f11459d.m8704a(str, z, z2, i, i2, i3, new aj(this, str, c0466h));
    }

    /* renamed from: b */
    private void m15421b(String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        C1502o.m15417a(dkStoreBookDetail.getMinKernelVersion(), new C1504q(this, str, dkStoreBookDetail, alVar, flowChargingTransferChoice));
    }

    /* renamed from: c */
    private void m15424c(String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (!f11456a && TextUtils.isEmpty(str)) {
            throw new AssertionError();
        } else if (!f11456a && dkStoreBookDetail == null) {
            throw new AssertionError();
        } else if (f11456a || alVar != null) {
            DkCloudStorage.m4994a().m5014a(str, new C1505r(this, alVar, flowChargingTransferChoice, dkStoreBookDetail));
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    private void m15419b(C1187m c1187m, String str, DkStoreCallback dkStoreCallback) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            dkStoreCallback.mo1164a((C1089s) c1187m, "");
            return;
        }
        String str2;
        C1192r c1509v = new C1509v(this, topActivity, c1187m, str, dkStoreCallback);
        DkStoreBookPrice dkStoreBookPrice = c1187m.m8722h()[0];
        String string = this.f11458c.getString(C0247i.store__price_changed_item_view__content);
        Object[] objArr = new Object[3];
        objArr[0] = dkStoreBookPrice.mBookTitle;
        objArr[1] = this.f11458c.getString(C0247i.store__shared__yuan) + String.format("%.2f", new Object[]{Float.valueOf(((float) dkStoreBookPrice.mNewPrice) / 100.0f)});
        objArr[2] = this.f11458c.getString(C0247i.store__shared__yuan) + String.format("%.2f", new Object[]{Float.valueOf(((float) c1187m.m8719e()) / 100.0f)});
        String format = String.format(string, objArr);
        Object obj = "";
        for (int i = 0; i < c1187m.m8723i(); i++) {
            obj = obj + " " + String.format(this.f11458c.getString(C0247i.store__shopping_cart_payment_view__discount_template), new Object[]{c1187m.m8714a(i), Float.valueOf(c1187m.m8715b(i))});
        }
        if (TextUtils.isEmpty(obj)) {
            str2 = format;
        } else {
            str2 = obj + format;
        }
        c1509v.setTitle(C0247i.bookcity_store__shared__book_price_changed_title);
        c1509v.m8742b(str2);
        c1509v.m8740a(C0247i.general__shared__cancel);
        c1509v.show();
    }

    /* renamed from: c */
    private void m15423c(C1187m c1187m, String str, DkStoreCallback dkStoreCallback) {
        C0709k.m3476a().m3497a(PersonalAccount.class, new C1510w(this, c1187m, str, dkStoreCallback));
    }

    /* renamed from: a */
    private void m15412a(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, FlowChargingTransferChoice flowChargingTransferChoice, al alVar) {
        C0800c b = com.duokan.reader.domain.bookshelf.ai.m3980a().m3906b(dkStoreBookDetail.getBook().getBookUuid());
        if (b == null) {
            if (com.duokan.reader.domain.bookshelf.ai.m3980a().m3984a(dkStoreBookDetail, dkCloudBookManifest, flowChargingTransferChoice.wifiOnly()) != null) {
                alVar.onDownloadCloudBookStarted();
            } else {
                alVar.onDownloadCloudBookError("");
            }
        } else if (b.m4233i() != BookState.PULLING) {
            if (b.m4233i() == BookState.CLOUD_ONLY || (b.m4233i() == BookState.NORMAL && !b.m4167T())) {
                com.duokan.reader.domain.bookshelf.ai.m3980a().m3989b(dkStoreBookDetail, dkCloudBookManifest, flowChargingTransferChoice.wifiOnly());
            } else if (b.m4233i() == BookState.NORMAL) {
                ((fp) b).m4481a(dkCloudBookManifest, flowChargingTransferChoice.wifiOnly());
            } else if (b.m4233i() == BookState.UPDATING && !f11456a) {
                throw new AssertionError();
            }
            alVar.onDownloadCloudBookStarted();
        } else if (b.m4242o() == BookType.TRIAL) {
            com.duokan.reader.domain.bookshelf.ai.m3980a().m3886a(b, true);
            if (com.duokan.reader.domain.bookshelf.ai.m3980a().m3984a(dkStoreBookDetail, dkCloudBookManifest, flowChargingTransferChoice.wifiOnly()) != null) {
                alVar.onDownloadCloudBookStarted();
            } else {
                alVar.onDownloadCloudBookError("");
            }
        } else {
            alVar.onDownloadCloudBookStarted();
        }
    }
}
