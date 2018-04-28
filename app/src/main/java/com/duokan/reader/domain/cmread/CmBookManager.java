package com.duokan.reader.domain.cmread;

import android.net.Uri;
import android.os.Looper;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.p026a.C0272a;
import com.duokan.core.sys.UThread;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.C0650x;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionDetailInfo;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.store.C0466h;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class CmBookManager implements ai {
    public static final int SC_NOAUTH = 2;
    public static final int SC_NOLOGIN = 1;
    public static final int SC_OK = 0;
    private static final aj<CmBookManager> sWrapper = new aj();
    private final C0709k mAccountManager;
    private final C0272a mCache;
    private final ReaderEnv mEnv;
    private final HashMap<String, DkStoreFictionDetail> mFictionDetailMap = new HashMap();
    private Looper mHandlerLooper = null;
    private final Thread mHandlerThread;
    private final HashMap<String, DkCloudPurchasedFictionInfo> mPurchaseInfoMap = new HashMap();
    private final HashSet<String> mPurchasedFictionIds;

    private CmBookManager(ReaderEnv readerEnv, C0709k c0709k) {
        this.mEnv = readerEnv;
        this.mAccountManager = c0709k;
        this.mCache = new C0272a(Uri.fromFile(new File(readerEnv.getDatabaseDirectory(), "cmbooks.db")).toString());
        final Semaphore semaphore = new Semaphore(0);
        this.mHandlerThread = new Thread(new Runnable() {
            public void run() {
                Looper.prepare();
                CmBookManager.this.mHandlerLooper = Looper.myLooper();
                semaphore.release();
                Looper.loop();
            }
        });
        this.mHandlerThread.start();
        semaphore.acquireUninterruptibly();
        this.mPurchasedFictionIds = (HashSet) this.mCache.m631a(cacheKey("fictions"), new HashSet());
    }

    public void fetchFictionDetail(String str, boolean z, boolean z2, int i, int i2, int i3, C0466h c0466h) {
        final C0650x c0650x = new C0650x(str);
        final boolean z3 = z;
        final boolean z4 = z2;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final C0466h c0466h2 = c0466h;
        final String str2 = str;
        new WebSession(C0643q.f2173a) {
            private C0621a<DkStoreFictionDetailInfo> mResult = null;

            protected void onSessionTry() {
                this.mResult = new C0647u(this, CmBookManager.this.mAccountManager.m3502b(PersonalAccount.class)).m3035a(c0650x.m3046a(), z3, z4, i4, i5, i6);
            }

            protected void onSessionFailed() {
                c0466h2.onFetchBookDetailError(ManagedApp.get().getString(C0247i.general__shared__network_error));
            }

            protected void onSessionSucceeded() {
                if (this.mResult.b == 0) {
                    DkStoreItem dkStoreFictionDetail = new DkStoreFictionDetail(new DkStoreFiction(((DkStoreFictionDetailInfo) this.mResult.f2058a).mFictionInfo), (DkStoreFictionDetailInfo) this.mResult.f2058a);
                    if (!z3 && !z4 && i4 == -1 && i5 == -1 && i6 == -1) {
                        CmBookManager.this.mFictionDetailMap.put(str2, dkStoreFictionDetail);
                    }
                    c0466h2.onFetchBookDetailOk(dkStoreFictionDetail);
                    return;
                }
                c0466h2.onFetchBookDetailError(ManagedApp.get().getString(C0247i.bookcity_store__shared__fail_to_find_book));
            }
        }.open();
    }

    public DkCloudPurchasedFictionInfo getPurchaseInfo(String str) {
        return findPurchaseInfo(str);
    }

    public static void startup(ReaderEnv readerEnv, C0709k c0709k) {
        sWrapper.m709a(new CmBookManager(readerEnv, c0709k));
    }

    public static CmBookManager get() {
        return (CmBookManager) sWrapper.m707a();
    }

    private void setBookPurchased(DkStoreFictionDetail dkStoreFictionDetail, boolean z) {
        synchronized (this.mPurchaseInfoMap) {
            DkCloudPurchasedFictionInfo findPurchaseInfo = findPurchaseInfo(dkStoreFictionDetail.getFiction().getBookUuid());
            DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo = findPurchaseInfo;
            for (DkCloudFictionChapter dkCloudFictionChapter : dkStoreFictionDetail.getToc()) {
                if (dkCloudPurchasedFictionInfo == null) {
                    dkCloudPurchasedFictionInfo = addPurchaseInfo(dkStoreFictionDetail, dkCloudFictionChapter.getCloudId(), z);
                } else {
                    updatePurchaseInfo(dkCloudPurchasedFictionInfo, dkCloudFictionChapter.getCloudId(), z);
                }
            }
        }
    }

    private void setChapterPurchased(final String str, final String str2, final boolean z) {
        DkCloudPurchasedFictionInfo findPurchaseInfo = findPurchaseInfo(str);
        if (findPurchaseInfo == null) {
            UThread.runOnThread(new Runnable() {

                /* renamed from: com.duokan.reader.domain.cmread.CmBookManager$3$1 */
                class C08941 implements C0466h {
                    C08941() {
                    }

                    public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
                        CmBookManager.this.setChapterPurchased((DkStoreFictionDetail) dkStoreItem, str2, z);
                    }

                    public void onFetchBookDetailError(String str) {
                    }
                }

                public void run() {
                    DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) CmBookManager.this.mFictionDetailMap.get(str);
                    if (dkStoreFictionDetail != null) {
                        CmBookManager.this.setChapterPurchased(dkStoreFictionDetail, str2, z);
                        return;
                    }
                    CmBookManager.this.fetchFictionDetail(str, false, false, -1, -1, -1, new C08941());
                }
            });
            return;
        }
        synchronized (this.mPurchaseInfoMap) {
            updatePurchaseInfo(findPurchaseInfo, str2, z);
        }
    }

    private void setChapterPurchased(DkStoreFictionDetail dkStoreFictionDetail, String str, boolean z) {
        synchronized (this.mPurchaseInfoMap) {
            DkCloudPurchasedFictionInfo findPurchaseInfo = findPurchaseInfo(dkStoreFictionDetail.getFiction().getBookUuid());
            if (findPurchaseInfo == null) {
                addPurchaseInfo(dkStoreFictionDetail, str, z);
            } else {
                updatePurchaseInfo(findPurchaseInfo, str, z);
            }
        }
    }

    private DkCloudPurchasedFictionInfo addPurchaseInfo(DkStoreFictionDetail dkStoreFictionDetail, String str, boolean z) {
        String bookUuid = dkStoreFictionDetail.getFiction().getBookUuid();
        DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo = new DkCloudPurchasedFictionInfo();
        dkCloudPurchasedFictionInfo.mBookUuid = bookUuid;
        dkCloudPurchasedFictionInfo.mCoverUri = dkStoreFictionDetail.getFiction().getCoverUri();
        dkCloudPurchasedFictionInfo.mChapterCount = dkStoreFictionDetail.getFiction().getChapterCount();
        dkCloudPurchasedFictionInfo.mTitle = dkStoreFictionDetail.getFiction().getTitle();
        dkCloudPurchasedFictionInfo.mEntire = false;
        dkCloudPurchasedFictionInfo.mFinish = dkStoreFictionDetail.getFiction().isFinish();
        dkCloudPurchasedFictionInfo.mLatest = dkStoreFictionDetail.getFiction().getLatestChapterTitle();
        dkCloudPurchasedFictionInfo.mLatestId = dkStoreFictionDetail.getFiction().getLatestChapterId();
        dkCloudPurchasedFictionInfo.mAuthors = dkStoreFictionDetail.getFiction().getAuthors();
        dkCloudPurchasedFictionInfo.mEditors = new String[0];
        dkCloudPurchasedFictionInfo.mOrderUuid = "";
        dkCloudPurchasedFictionInfo.mPaidChapterId = new String[0];
        if (z) {
            dkCloudPurchasedFictionInfo.mPurchasedChapterIds.addIfAbsent(str);
        } else {
            dkCloudPurchasedFictionInfo.mNotPurchasedChapterIds.addIfAbsent(str);
        }
        this.mPurchaseInfoMap.put(bookUuid, dkCloudPurchasedFictionInfo);
        this.mPurchasedFictionIds.add(bookUuid);
        this.mCache.m632a();
        try {
            this.mCache.m634b(cacheKey(bookUuid), (Serializable) dkCloudPurchasedFictionInfo);
            this.mCache.m634b(cacheKey("fictions"), this.mPurchasedFictionIds);
            this.mCache.m635b();
        } catch (Throwable th) {
        } finally {
            dkCloudPurchasedFictionInfo = this.mCache;
            dkCloudPurchasedFictionInfo.m636c();
        }
        return dkCloudPurchasedFictionInfo;
    }

    private void updatePurchaseInfo(DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo, String str, boolean z) {
        int addIfAbsent;
        if (z) {
            addIfAbsent = (0 | dkCloudPurchasedFictionInfo.mPurchasedChapterIds.addIfAbsent(str)) | dkCloudPurchasedFictionInfo.mNotPurchasedChapterIds.remove(str);
        } else {
            addIfAbsent = (0 | dkCloudPurchasedFictionInfo.mPurchasedChapterIds.remove(str)) | dkCloudPurchasedFictionInfo.mNotPurchasedChapterIds.addIfAbsent(str);
        }
        if (addIfAbsent != 0) {
            this.mCache.m634b(cacheKey(dkCloudPurchasedFictionInfo.mBookUuid), (Serializable) dkCloudPurchasedFictionInfo);
        }
    }

    private DkCloudPurchasedFictionInfo findPurchaseInfo(String str) {
        DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo;
        synchronized (this.mPurchaseInfoMap) {
            dkCloudPurchasedFictionInfo = (DkCloudPurchasedFictionInfo) this.mPurchaseInfoMap.get(str);
            if (dkCloudPurchasedFictionInfo == null) {
                dkCloudPurchasedFictionInfo = (DkCloudPurchasedFictionInfo) this.mCache.m630a(cacheKey(str));
                if (dkCloudPurchasedFictionInfo != null) {
                    this.mPurchaseInfoMap.put(str, dkCloudPurchasedFictionInfo);
                }
            }
        }
        return dkCloudPurchasedFictionInfo;
    }

    private String cacheKey(String str) {
        return str + "@" + this.mAccountManager.m3508d().mo832b();
    }
}
