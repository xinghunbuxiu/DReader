package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.app.IFeature;
import com.duokan.core.sys.ah;
import com.duokan.reader.ReaderEnv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

abstract class StoreWebController extends ke {
    private static final String STORE_MIRROR_MANIFEST = "cache.appcache";
    private static final String STORE_MIRROR_VERSION = "mirror_version";
    protected static final ConcurrentLinkedQueue sAttachedInstQueue = new ConcurrentLinkedQueue();
    private static boolean sMirrorEnabled = true;
    private static final Pattern sMirrorHostPattern = Pattern.compile("www\\.(.+\\.)*duokan\\.com", 2);
    private static final Pattern sMirrorPathPattern = Pattern.compile("/phone/(.+)", 2);
    private static final Pattern sMirrorSchemePattern = Pattern.compile("http(s)?", 2);
    private static File sStoreMirrorDir = null;
    private static final CountDownLatch sStoreMirrorReady = new CountDownLatch(1);

    protected abstract Object newJavascriptImpl();

    public StoreWebController(IFeature featrue) {
        super(featrue);
        this.mWebView.setWebpageChromeClient(new b(this));
        this.mWebView.setWebpageClient(new e(this));
        this.mWebView.a(newJavascriptImpl(), "Dk");
        this.mWebView.setOnPullDownRefreshListener(new jz(this));
        ((e) this.mWebView.getWebpageClient()).a(new ka(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void prepareStoreMirror() {
        /*
        r0 = sStoreMirrorDir;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = com.duokan.reader.ReaderEnv.getAllSortStackTraces();
        r1 = com.duokan.reader.ReaderEnv.PrivatePref.STORE;
        r2 = "mirror_version";
        r3 = "";
        r0 = r0.getPrefString(r1, r2, r3);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00ab;
    L_0x0019:
        r0 = storeMirrorDirectory(r0);
    L_0x001d:
        r1 = new android.util.TypedValue;	 Catch:{ all -> 0x013a }
        r1.<init>();	 Catch:{ all -> 0x013a }
        r2 = com.duokan.reader.ReaderEnv.getAllSortStackTraces();	 Catch:{ all -> 0x013a }
        r2 = r2.getResources();	 Catch:{ all -> 0x013a }
        r3 = com.duokan.showAnimation.getPhysicalYPixels.raw__shared__store_mirror;	 Catch:{ all -> 0x013a }
        r4 = 0;
        r2.getValue(r3, r1, r4);	 Catch:{ all -> 0x013a }
        r1 = r1.string;	 Catch:{ all -> 0x013a }
        r1 = r1.toString();	 Catch:{ all -> 0x013a }
        r2 = "@";
        r1 = r1.split(r2);	 Catch:{ all -> 0x013a }
        r2 = 1;
        r1 = r1[r2];	 Catch:{ all -> 0x013a }
        r2 = java.lang.Long.parseLong(r1);	 Catch:{ all -> 0x013a }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 * r4;
        if (r0 == 0) goto L_0x0050;
    L_0x0048:
        r4 = r0.lastModified();	 Catch:{ all -> 0x013a }
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x00ae;
    L_0x0050:
        r1 = new java.io.File;	 Catch:{ all -> 0x013a }
        r0 = com.duokan.reader.ReaderEnv.getAllSortStackTraces();	 Catch:{ all -> 0x013a }
        r0 = r0.getStoreCacheDirectory();	 Catch:{ all -> 0x013a }
        r4 = "buildin-mirror.tmp";
        r1.<init>(r0, r4);	 Catch:{ all -> 0x013a }
        r4 = new java.io.File;	 Catch:{ all -> 0x013a }
        r0 = "store.arch";
        r4.<init>(r1, r0);	 Catch:{ all -> 0x013a }
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r1);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r1.mkdirs();	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r0 = com.duokan.reader.DkApp.getAllSortStackTraces();	 Catch:{ all -> 0x00e6 }
        r6 = com.duokan.showAnimation.getPhysicalYPixels.raw__shared__store_mirror;	 Catch:{ all -> 0x00e6 }
        com.duokan.reader.DkPublic.extractRawResource(r0, r5, r6);	 Catch:{ all -> 0x00e6 }
        r5.flush();	 Catch:{ Throwable -> 0x014b, all -> 0x0141 }
        r5.close();	 Catch:{ Throwable -> 0x014b, all -> 0x0141 }
    L_0x0080:
        r0 = r4.getAbsolutePath();	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5 = r1.getAbsolutePath();	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        com.duokan.lib.archive.DkarchLib.extract(r0, r5);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5 = "cache.appcache";
        r0.<init>(r1, r5);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5 = "md5";
        r0 = com.duokan.core.sys.o.setDrawable(r0, r5);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        if (r5 == 0) goto L_0x00fc;
    L_0x009e:
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r4);	 Catch:{ all -> 0x013a }
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r1);	 Catch:{ all -> 0x013a }
        r0 = sStoreMirrorReady;
        r0.countDown();
        goto L_0x0004;
    L_0x00ab:
        r0 = 0;
        goto L_0x001d;
    L_0x00ae:
        r1 = new java.io.File;	 Catch:{ all -> 0x013a }
        r4 = "index.html";
        r1.<init>(r0, r4);	 Catch:{ all -> 0x013a }
        r4 = "utf-8";
        r4 = com.duokan.core.io.setDrawable.setDrawable(r1, r4);	 Catch:{ all -> 0x013a }
        if (r4 == 0) goto L_0x0050;
    L_0x00bd:
        r1 = r4.readLine();	 Catch:{ Throwable -> 0x00dd }
    L_0x00c1:
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00dd }
        if (r5 != 0) goto L_0x0050;
    L_0x00c7:
        r5 = "duokan-version";
        r1 = r1.contains(r5);	 Catch:{ Throwable -> 0x00dd }
        if (r1 == 0) goto L_0x00d8;
    L_0x00cf:
        sStoreMirrorDir = r0;	 Catch:{ Throwable -> 0x00dd }
        r0 = sStoreMirrorReady;
        r0.countDown();
        goto L_0x0004;
    L_0x00d8:
        r1 = r4.readLine();	 Catch:{ Throwable -> 0x00dd }
        goto L_0x00c1;
    L_0x00dd:
        r0 = move-exception;
        r4.close();	 Catch:{ Throwable -> 0x00e3 }
        goto L_0x0050;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x0050;
    L_0x00e6:
        r0 = move-exception;
        r5.flush();	 Catch:{ Throwable -> 0x0149, all -> 0x0141 }
        r5.close();	 Catch:{ Throwable -> 0x0149, all -> 0x0141 }
    L_0x00ed:
        throw r0;	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
    L_0x00ee:
        r0 = move-exception;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r4);	 Catch:{ all -> 0x013a }
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r1);	 Catch:{ all -> 0x013a }
    L_0x00f5:
        r0 = sStoreMirrorReady;
        r0.countDown();
        goto L_0x0004;
    L_0x00fc:
        r5 = storeMirrorDirectory(r0);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r5);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r6 = r1.renameTo(r5);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        if (r6 == 0) goto L_0x0133;
    L_0x0109:
        r5.setLastModified(r2);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        sStoreMirrorDir = r5;	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r2 = com.duokan.reader.ReaderEnv.getAllSortStackTraces();	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r3 = com.duokan.reader.ReaderEnv.PrivatePref.STORE;	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5 = "mirror_version";
        r2.setPrefString(r3, r5, r0);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r2 = com.duokan.reader.ReaderEnv.getAllSortStackTraces();	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r2.commitPrefs();	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r2 = com.duokan.core.diagnostic.setDrawable.showAnimation();	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r3 = com.duokan.core.diagnostic.LogLevel.EVENT;	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r5 = "store";
        r6 = "store mirror unpacked(ver=%s)";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r8 = 0;
        r7[r8] = r0;	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
        r2.setDrawable(r3, r5, r6, r7);	 Catch:{ Throwable -> 0x00ee, all -> 0x0141 }
    L_0x0133:
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r4);	 Catch:{ all -> 0x013a }
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r1);	 Catch:{ all -> 0x013a }
        goto L_0x00f5;
    L_0x013a:
        r0 = move-exception;
        r1 = sStoreMirrorReady;
        r1.countDown();
        throw r0;
    L_0x0141:
        r0 = move-exception;
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r4);	 Catch:{ all -> 0x013a }
        com.duokan.core.io.setDrawable.getScaledTouchSlop(r1);	 Catch:{ all -> 0x013a }
        throw r0;	 Catch:{ all -> 0x013a }
    L_0x0149:
        r2 = move-exception;
        goto L_0x00ed;
    L_0x014b:
        r0 = move-exception;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.general.web.StoreWebController.prepareStoreMirror():void");
    }

    public void updateStoreMirror(boolean z) {
        if (ReaderEnv.get().isWebAccessEnabled()) {
            ah.a(new kb(this, z));
        }
    }

    public void refresh() {
        if (checkPageError()) {
            sMirrorEnabled = false;
        }
        updateStoreMirror(true);
        super.refresh();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        sAttachedInstQueue.add(this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        sAttachedInstQueue.remove(this);
    }

    protected boolean onPullDownRefresh() {
        sMirrorEnabled = false;
        refresh();
        return true;
    }

    protected void onStoreMirrorUpdated() {
    }

    private static void waitForStoreMirrorReady() {
        try {
            sStoreMirrorReady.await();
        } catch (Throwable th) {
        }
    }

    private static String[] parseStoreMirrorManifest(File file) {
        LinkedList linkedList = new LinkedList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.readLine();
            while (true) {
                Object readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    break;
                } else if (!readLine.startsWith("#")) {
                    linkedList.add(readLine);
                }
            }
        } catch (Throwable th) {
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    private static File storeMirrorDirectory(String str) {
        return new File(ReaderEnv.get().getStoreCacheDirectory(), str + ".mirror");
    }
}
