package com.duokan.reader.domain.cmread;

import android.net.Uri;
import android.os.Looper;

import com.duokan.core.a.a;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedFictionInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreFictionDetailInfo;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.common.webservices.duokan.v;
import com.duokan.reader.common.webservices.duokan.y;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.store.DkStoreFiction;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.domain.store.DkStoreItem;
import com.duokan.reader.domain.store.h;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

public class CmBookManager implements ah {
    public static final int SC_NOAUTH = 2;
    public static final int SC_NOLOGIN = 1;
    public static final int SC_OK = 0;
    private static final ai sWrapper = new ai();
    private final i mAccountManager;
    private final a mCache;
    private final ReaderEnv mEnv;
    private final HashMap mFictionDetailMap = new HashMap();
    private Looper mHandlerLooper = null;
    private final Thread mHandlerThread;
    private final HashMap mPurchaseInfoMap = new HashMap();
    private final HashSet mPurchasedFictionIds;

    private CmBookManager(ReaderEnv readerEnv, i iVar) {
        this.mEnv = readerEnv;
        this.mAccountManager = iVar;
        this.mCache = new a(Uri.fromFile(new File(readerEnv.getDatabaseDirectory(), "cmbooks.db")).toString());
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
        this.mPurchasedFictionIds = (HashSet) this.mCache.a(cacheKey("fictions"), new HashSet());
    }

    public void fetchFictionDetail(String str, boolean z, boolean z2, int i, int i2, int i3, h hVar) {
        final y yVar = new y(str);
        final boolean z3 = z;
        final boolean z4 = z2;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final h hVar2 = hVar;
        final String str2 = str;
        new r() {
            private b mResult = null;

            protected void onSessionTry() {
                this.mResult = new v(this, CmBookManager.this.mAccountManager.b(PersonalAccount.class)).a(yVar.a(), z3, z4, i4, i5, i6);
            }

            protected void onSessionFailed() {
                hVar2.onFetchBookDetailError(ManagedApp.get().getString(com.duokan.b.i.general__shared__network_error));
            }

            protected void onSessionSucceeded() {
                if (this.mResult.b == 0) {
                    DkStoreItem dkStoreFictionDetail = new DkStoreFictionDetail(new DkStoreFiction(((DkStoreFictionDetailInfo) this.mResult.a).mFictionInfo), (DkStoreFictionDetailInfo) this.mResult.a);
                    if (!z3 && !z4 && i4 == -1 && i5 == -1 && i6 == -1) {
                        CmBookManager.this.mFictionDetailMap.put(str2, dkStoreFictionDetail);
                    }
                    hVar2.onFetchBookDetailOk(dkStoreFictionDetail);
                    return;
                }
                hVar2.onFetchBookDetailError(ManagedApp.get().getString(com.duokan.b.i.bookcity_store__shared__fail_to_find_book));
            }
        }.open();
    }

    public DkCloudPurchasedFictionInfo getPurchaseInfo(String str) {
        return findPurchaseInfo(str);
    }

    public static void startup(ReaderEnv readerEnv, i iVar) {
        sWrapper.a(new CmBookManager(readerEnv, iVar));
    }

    public static CmBookManager get() {
        return (CmBookManager) sWrapper.a();
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
            TaskHandler.postTask(new Runnable() {
                public void run() {
                    DkStoreFictionDetail dkStoreFictionDetail = (DkStoreFictionDetail) CmBookManager.this.mFictionDetailMap.get(str);
                    if (dkStoreFictionDetail != null) {
                        CmBookManager.this.setChapterPurchased(dkStoreFictionDetail, str2, z);
                        return;
                    }
                    CmBookManager.this.fetchFictionDetail(str, false, false, -1, -1, -1, new h() {
                        public void onFetchBookDetailOk(DkStoreItem dkStoreItem) {
                            CmBookManager.this.setChapterPurchased((DkStoreFictionDetail) dkStoreItem, str2, z);
                        }

                        public void onFetchBookDetailError(String str) {
                        }
                    });
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
        this.mCache.a();
        try {
            this.mCache.b(cacheKey(bookUuid), (Serializable) dkCloudPurchasedFictionInfo);
            this.mCache.b(cacheKey("fictions"), this.mPurchasedFictionIds);
            this.mCache.b();
        } catch (Throwable th) {
        } finally {
            dkCloudPurchasedFictionInfo = this.mCache;
            dkCloudPurchasedFictionInfo.c();
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
            this.mCache.b(cacheKey(dkCloudPurchasedFictionInfo.mBookUuid), (Serializable) dkCloudPurchasedFictionInfo);
        }
    }

    private DkCloudPurchasedFictionInfo findPurchaseInfo(String str) {
        DkCloudPurchasedFictionInfo dkCloudPurchasedFictionInfo;
        synchronized (this.mPurchaseInfoMap) {
            dkCloudPurchasedFictionInfo = (DkCloudPurchasedFictionInfo) this.mPurchaseInfoMap.get(str);
            if (dkCloudPurchasedFictionInfo == null) {
                dkCloudPurchasedFictionInfo = (DkCloudPurchasedFictionInfo) this.mCache.a(cacheKey(str));
                if (dkCloudPurchasedFictionInfo != null) {
                    this.mPurchaseInfoMap.put(str, dkCloudPurchasedFictionInfo);
                }
            }
        }
        return dkCloudPurchasedFictionInfo;
    }

    private String cacheKey(String str) {
        return str + "@" + this.mAccountManager.c().b();
    }
}
