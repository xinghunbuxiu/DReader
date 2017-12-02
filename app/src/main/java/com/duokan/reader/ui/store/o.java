package com.duokan.reader.ui.store;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.b.i;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.app.y;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.webservices.duokan.DkStoreBookPrice;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter.ChapterState;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.domain.cmread.CmBookManager;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.payment.s;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.a;
import com.duokan.reader.domain.store.h;
import com.duokan.reader.domain.store.j;
import com.duokan.reader.domain.store.l;
import com.duokan.reader.domain.store.m;
import com.duokan.reader.domain.store.r;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.jq;

import java.util.HashSet;

public class o implements ah, l {
    static final /* synthetic */ boolean a = (!o.class.desiredAssertionStatus());
    private static final ai b = new ai();
    private final Context c;
    private final a d;
    private final DkCloudStorage e;
    private final com.duokan.reader.domain.bookshelf.ai f;
    private final HashSet g = new HashSet();

    private o(Context context, a aVar, DkCloudStorage dkCloudStorage, f fVar, b bVar, com.duokan.reader.domain.bookshelf.ai aiVar) {
        this.c = context;
        this.d = aVar;
        this.e = dkCloudStorage;
        this.f = aiVar;
        DkApp.get().runPreReady(new p(this));
    }

    public static void a(Context context, a aVar, DkCloudStorage dkCloudStorage, f fVar, b bVar, com.duokan.reader.domain.bookshelf.ai aiVar) {
        b.a(new o(context, aVar, dkCloudStorage, fVar, bVar, aiVar));
    }

    public static o a() {
        return (o) b.a();
    }

    public boolean a(String str) {
        return this.g.contains(str);
    }

    public void b(String str) {
        this.g.add(str);
    }

    public void c(String str) {
        this.g.remove(str);
    }

    public void a(c cVar, ao aoVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.g.add(cVar.H());
        this.d.a(cVar.H(), false, new x(this, cVar, flowChargingTransferChoice, aoVar));
    }

    public void a(y yVar, DkStoreFictionDetail dkStoreFictionDetail, boolean z, String[] strArr, float f, j jVar) {
        if (!a && jVar == null) {
            throw new AssertionError();
        } else if (new com.duokan.reader.common.webservices.duokan.y(dkStoreFictionDetail.getFiction().getBookUuid()).b() != 1) {
        }
    }

    public void a(String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            alVar.onDownloadCloudBookError("");
            return;
        }
        this.g.add(str);
        if (dkStoreBookDetail == null) {
            jq jqVar = new jq(topActivity);
            jqVar.a(this.c.getString(i.bookcity_store__shared__creating_order));
            jqVar.a(true);
            jqVar.setCancelOnBack(false);
            jqVar.setCancelOnTouchOutside(false);
            jqVar.show();
            this.d.a(str, false, new aa(this, jqVar, str, alVar, flowChargingTransferChoice));
            return;
        }
        b(str, dkStoreBookDetail, new ac(this, str, alVar), flowChargingTransferChoice);
    }

    public void a(String str, String str2, short s, an anVar) {
        com.duokan.reader.domain.account.i.f().a(PersonalAccount.class, new ad(this, str, str2, anVar));
    }

    public static void a(DkStoreFictionDetail dkStoreFictionDetail) {
        int i = 0;
        if (new com.duokan.reader.common.webservices.duokan.y(dkStoreFictionDetail.getFiction().getBookUuid()).b() != 1) {
            Integer[] a = aq.a(dkStoreFictionDetail.getFiction().getBookUuid(), dkStoreFictionDetail.allowFreeRead(), new ag(dkStoreFictionDetail));
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

    public static void d(String str) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity != null && !topActivity.isFinishing() && !TextUtils.isEmpty(str)) {
            ak akVar = new ak(topActivity);
            akVar.setPrompt(str);
            akVar.addButtonView(i.general__shared__confirm);
            akVar.show();
            akVar.setOnButtonClickedListener(new ah(akVar));
        }
    }

    public static void a(String str, am amVar) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            amVar.b();
        } else if (TextUtils.isEmpty(str) || !DkPublic.isVersionLessorThen(ReaderEnv.get().getKernelVersion(), str)) {
            amVar.a();
        } else {
            ap aiVar = new ai(topActivity, amVar);
            aiVar.setTitle(i.store__kernel_support_view__title);
            aiVar.setPrompt(i.store__kernel_support_view__message);
            aiVar.setCancelLabel(i.general__shared__cancel);
            aiVar.setOkLabel(i.store__kernel_support_view__continue_download);
            aiVar.show();
        }
    }

    public void a(m mVar, String str, DkStoreCallback dkStoreCallback) {
        if (!a && mVar == null) {
            throw new AssertionError();
        } else if (!a && dkStoreCallback == null) {
            throw new AssertionError();
        } else if (mVar.g() || mVar.e() == mVar.f()) {
            c(mVar, str, dkStoreCallback);
        } else {
            b(mVar, str, dkStoreCallback);
        }
    }

    @Deprecated
    public void a(String str, boolean z, boolean z2, int i, int i2, int i3, h hVar) {
        this.d.a(str, z, z2, i, i2, i3, new aj(this, str, hVar));
    }

    private void b(String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        a(dkStoreBookDetail.getMinKernelVersion(), new q(this, str, dkStoreBookDetail, alVar, flowChargingTransferChoice));
    }

    private void c(String str, DkStoreBookDetail dkStoreBookDetail, al alVar, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (!a && TextUtils.isEmpty(str)) {
            throw new AssertionError();
        } else if (!a && dkStoreBookDetail == null) {
            throw new AssertionError();
        } else if (a || alVar != null) {
            DkCloudStorage.a().a(str, new r(this, alVar, flowChargingTransferChoice, dkStoreBookDetail));
        } else {
            throw new AssertionError();
        }
    }

    private void b(m mVar, String str, DkStoreCallback dkStoreCallback) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            dkStoreCallback.a((s) mVar, "");
            return;
        }
        String str2;
        r vVar = new v(this, topActivity, mVar, str, dkStoreCallback);
        DkStoreBookPrice dkStoreBookPrice = mVar.h()[0];
        String string = this.c.getString(i.store__price_changed_item_view__content);
        Object[] objArr = new Object[3];
        objArr[0] = dkStoreBookPrice.mBookTitle;
        objArr[1] = this.c.getString(i.store__shared__yuan) + String.format("%.2f", new Object[]{Float.valueOf(((float) dkStoreBookPrice.mNewPrice) / 100.0f)});
        objArr[2] = this.c.getString(i.store__shared__yuan) + String.format("%.2f", new Object[]{Float.valueOf(((float) mVar.e()) / 100.0f)});
        String format = String.format(string, objArr);
        Object obj = "";
        for (int i = 0; i < mVar.i(); i++) {
            obj = obj + " " + String.format(this.c.getString(i.store__shopping_cart_payment_view__discount_template), new Object[]{mVar.a(i), Float.valueOf(mVar.b(i))});
        }
        if (TextUtils.isEmpty(obj)) {
            str2 = format;
        } else {
            str2 = obj + format;
        }
        vVar.setTitle(i.bookcity_store__shared__book_price_changed_title);
        vVar.b(str2);
        vVar.a(i.general__shared__cancel);
        vVar.show();
    }

    private void c(m mVar, String str, DkStoreCallback dkStoreCallback) {
        com.duokan.reader.domain.account.i.f().a(PersonalAccount.class, new w(this, mVar, str, dkStoreCallback));
    }

    private void a(DkStoreBookDetail dkStoreBookDetail, DkCloudBookManifest dkCloudBookManifest, FlowChargingTransferChoice flowChargingTransferChoice, al alVar) {
        c b = com.duokan.reader.domain.bookshelf.ai.a().b(dkStoreBookDetail.getBook().getBookUuid());
        if (b == null) {
            if (com.duokan.reader.domain.bookshelf.ai.a().a(dkStoreBookDetail, dkCloudBookManifest, flowChargingTransferChoice.wifiOnly()) != null) {
                alVar.onDownloadCloudBookStarted();
            } else {
                alVar.onDownloadCloudBookError("");
            }
        } else if (b.i() != BookState.PULLING) {
            if (b.i() == BookState.CLOUD_ONLY || (b.i() == BookState.NORMAL && !b.R())) {
                com.duokan.reader.domain.bookshelf.ai.a().b(dkStoreBookDetail, dkCloudBookManifest, flowChargingTransferChoice.wifiOnly());
            } else if (b.i() == BookState.NORMAL) {
                ((fv) b).a(dkCloudBookManifest, flowChargingTransferChoice.wifiOnly());
            } else if (b.i() == BookState.UPDATING && !a) {
                throw new AssertionError();
            }
            alVar.onDownloadCloudBookStarted();
        } else if (b.o() == BookType.TRIAL) {
            com.duokan.reader.domain.bookshelf.ai.a().a(b, true);
            if (com.duokan.reader.domain.bookshelf.ai.a().a(dkStoreBookDetail, dkCloudBookManifest, flowChargingTransferChoice.wifiOnly()) != null) {
                alVar.onDownloadCloudBookStarted();
            } else {
                alVar.onDownloadCloudBookError("");
            }
        } else {
            alVar.onDownloadCloudBookStarted();
        }
    }
}
