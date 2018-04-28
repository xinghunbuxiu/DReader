package com.duokan.reader.domain.bookshelf;

import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.io.IOUtils;
import com.duokan.core.io.OutputException;
import com.duokan.core.p027b.p028a.C0320a;
import com.duokan.core.p027b.p028a.C0321b;
import com.duokan.core.sys.C0352r;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.ag;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

class ev {
    /* renamed from: j */
    public static boolean f3130j = false;
    /* renamed from: k */
    private static final AtomicInteger f3131k = new AtomicInteger(0);
    /* renamed from: a */
    public final String f3132a;
    /* renamed from: b */
    public final C0352r f3133b;
    /* renamed from: c */
    public final long f3134c;
    /* renamed from: d */
    public final String[] f3135d;
    /* renamed from: e */
    public final Map<String, String> f3136e;
    /* renamed from: f */
    public final LinkedList<ag<Integer>> f3137f = new LinkedList();
    /* renamed from: g */
    public final FutureTask<Integer> f3138g;
    /* renamed from: h */
    public int f3139h = -1;
    /* renamed from: i */
    public Throwable f3140i = null;

    public ev(String str, C0352r c0352r, long j, String str2, Map<String, String> map) {
        this.f3132a = str;
        this.f3133b = c0352r;
        this.f3134c = j;
        this.f3135d = str2.split("\n");
        this.f3136e = map;
        this.f3138g = new FutureTask(new ew(this));
    }

    /* renamed from: a */
    private int m4442a(String str, C0320a c0320a) {
        if (TextUtils.isEmpty(str)) {
            return ICallback.CLEAR_ACCOUNT_AIDL;
        }
        String str2 = this.f3132a + ".tmp";
        long a;
        int i;
        if (this.f3133b == null) {
            File file = new File(Uri.parse(this.f3132a).getPath());
            if (file.exists()) {
                return 1;
            }
            File file2 = new File(file.getPath() + ".tmp");
            a = C0321b.m725a(str, file2, c0320a);
            if (a < 1 || (this.f3134c > 0 && a != this.f3134c)) {
                C0328a.m757c().m749a(LogLevel.ERROR, "dkbook", "unexpected file length(length=%d, httpUri=%s, fileUri=%s)", Long.valueOf(a), str, this.f3132a);
                FileUtil.m793f(file2);
                return 1007;
            }
            try {
                if (TextUtils.isEmpty((CharSequence) this.f3136e.get("md5"))) {
                    if (!(TextUtils.isEmpty((CharSequence) this.f3136e.get("sha1")) || C0366o.m1028a(file2, "sha1").startsWith((String) this.f3136e.get("sha1")))) {
                        FileUtil.m793f(file2);
                        return 1008;
                    }
                } else if (!C0366o.m1028a(file2, "md5").startsWith((String) this.f3136e.get("md5"))) {
                    FileUtil.m793f(file2);
                    return 1008;
                }
                if (file2.renameTo(file)) {
                    FileUtil.m793f(file2);
                    return 0;
                }
                if (file.exists()) {
                    i = 1;
                } else {
                    i = 1006;
                }
                FileUtil.m793f(file2);
                return i;
            } catch (Throwable th) {
                FileUtil.m793f(file2);
                throw th;
            }
        } else if (this.f3133b.mo418a(this.f3132a)) {
            return 1;
        } else {
            if (this.f3134c > 0) {
                this.f3133b.mo416a(str2, this.f3134c);
            }
            Closeable d = this.f3133b.mo424d(str2);
            try {
                a = C0321b.m726a(str, (OutputStream) d, c0320a);
                if (a < 1 || (this.f3134c > 0 && a != this.f3134c)) {
                    C0328a.m757c().m749a(LogLevel.ERROR, "dkbook", "unexpected file length(length=%d, httpUri=%s, fileUri=%s)", Long.valueOf(a), str, this.f3132a);
                    IOUtils.close(d);
                    this.f3133b.mo421b(str2);
                    return 1007;
                }
                IOUtils.close(d);
                d = this.f3133b.mo422c(str2);
                if (TextUtils.isEmpty((CharSequence) this.f3136e.get("md5"))) {
                    if (!(TextUtils.isEmpty((CharSequence) this.f3136e.get("sha1")) || C0366o.m1029a((InputStream) d, "sha1").startsWith((String) this.f3136e.get("sha1")))) {
                        IOUtils.close(d);
                        this.f3133b.mo421b(str2);
                        return 1008;
                    }
                } else if (!C0366o.m1029a((InputStream) d, "md5").startsWith((String) this.f3136e.get("md5"))) {
                    IOUtils.close(d);
                    this.f3133b.mo421b(str2);
                    return 1008;
                }
                IOUtils.close(d);
                if (this.f3133b.mo419a(str2, this.f3132a)) {
                    this.f3133b.mo421b(str2);
                    return 0;
                }
                if (this.f3133b.mo418a(this.f3132a)) {
                    i = 1;
                } else {
                    i = 1006;
                }
                this.f3133b.mo421b(str2);
                return i;
            } catch (Throwable th2) {
                try {
                    if (this.f3133b.mo418a(this.f3132a)) {
                        this.f3133b.mo421b(str2);
                        return 1;
                    }
                    this.f3140i = th2;
                    C0328a.m757c().m748a(LogLevel.ERROR, "dkbook", String.format("an exception occurs(httpUri=%s, fileUri=%s)", new Object[]{str, this.f3132a}), th2);
                    if (th2 instanceof OutputException) {
                        this.f3133b.mo421b(str2);
                        return 1006;
                    } else if (th2 instanceof IOException) {
                        this.f3133b.mo421b(str2);
                        return 1005;
                    } else {
                        this.f3133b.mo421b(str2);
                        return 1000;
                    }
                } catch (Throwable th22) {
                    this.f3133b.mo421b(str2);
                    throw th22;
                }
            }
        }
    }
}
