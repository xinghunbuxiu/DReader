package com.duokan.reader.common.webservices;

import android.os.Looper;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.p027b.p028a.HttpConfig;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.webservices.duokan.p040a.C0624a;
import com.duokan.reader.common.webservices.duokan.p040a.C0627d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class WebSession {
    static final /* synthetic */ boolean $assertionsDisabled = (!WebSession.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    public static final String DEFAULT_SEQ_QUEUE = WebSession.class.getName();
    private static final C0657i DEFAULT_WEBSESSION_CONFIG = new C0659k().m3094a();
    private static final long HTTP_COUNTING_TIME = TimeUnit.SECONDS.toMillis(100);
    private static final int HTTP_COUNT_TO_WARN = 20;
    private static final HashMap<String, Long> sHttpCountingMap = new HashMap();
    private static HttpLogger sHttpLogger = null;
    private CacheStrategy mCacheStrategy;
    private final HttpConfig mHttpConfig;
    protected boolean mIsClosed;
    private int mMaxRetryCount;
    private final LinkedList<C0653e> mResponseList;
    private int mRetryCount;
    private Exception mSessionException;
    private Future<?> mSessionFuture;
    private SessionState mSessionState;
    private C0654f mSessionTask;
    private C0657i mWebSessionConfig;

    public enum CacheStrategy {
        DISABLE_CACHE,
        DO_NOT_USE_CACHE,
        USE_CACHE_IF_FRESH,
        USE_CACHE_IF_EXISTS,
        USE_CACHE_ONLY
    }

    public enum SessionState {
        UNFINISHED,
        SUCCEEDED,
        CANCELLED,
        FAILED
    }

    protected abstract void onSessionFailed();

    protected abstract void onSessionSucceeded();

    protected abstract void onSessionTry();

    static /* synthetic */ int access$004(WebSession webSession) {
        int i = webSession.mRetryCount + 1;
        webSession.mRetryCount = i;
        return i;
    }

    public WebSession(C0657i c0657i) {
        this.mIsClosed = true;
        this.mSessionState = SessionState.UNFINISHED;
        this.mRetryCount = 0;
        this.mMaxRetryCount = 0;
        this.mSessionException = null;
        this.mSessionTask = null;
        this.mSessionFuture = null;
        this.mResponseList = new LinkedList();
        this.mCacheStrategy = CacheStrategy.DISABLE_CACHE;
        this.mHttpConfig = new HttpConfig();
        this.mWebSessionConfig = DEFAULT_WEBSESSION_CONFIG;
        this.mWebSessionConfig = c0657i;
    }

    protected int getRetryDelay(int i) {
        return (i * 2) * 1000;
    }

    public WebSession() {
        this(DEFAULT_WEBSESSION_CONFIG);
    }

    public boolean getIsParallel() {
        return this.mWebSessionConfig.f2205b;
    }

    public boolean getIsClosed() {
        checkAccess();
        return this.mIsClosed;
    }

    public void setReadTimeout(int i) {
        this.mHttpConfig.readTimeout = i;
    }

    public void setConnectTimeout(int i) {
        this.mHttpConfig.connectTimeout = i;
    }

    public void setMaxRetryCount(int i) {
        checkAccess();
        this.mMaxRetryCount = i;
    }

    public SessionState getSessionState() {
        checkAccess();
        return this.mSessionState;
    }

    public static void setLogger(HttpLogger httpLogger) {
        sHttpLogger = httpLogger;
    }

    public void open() {
        open(this.mWebSessionConfig.f2206c);
    }

    public void open(CacheStrategy cacheStrategy) {
        open(cacheStrategy, 0);
    }

    public void open(long j) {
        open(this.mWebSessionConfig.f2207d, j);
    }

    public void open(CacheStrategy cacheStrategy, long j) {
        if (!$assertionsDisabled && !checkAccess()) {
            throw new AssertionError();
        } else if (this.mSessionTask == null || this.mSessionTask.f2196a) {
            scheduleSessionTask(cacheStrategy, j);
        }
    }

    public void close() {
        if (!$assertionsDisabled && !checkAccess()) {
            throw new AssertionError();
        } else if (this.mSessionTask != null && !this.mSessionTask.f2196a) {
            if ($assertionsDisabled || this.mSessionFuture != null) {
                this.mSessionTask.f2196a = true;
                this.mSessionFuture.cancel(true);
                return;
            }
            throw new AssertionError();
        }
    }

    public boolean isCancelling() {
        return (this.mSessionTask == null || !this.mSessionTask.f2196a) ? $assertionsDisabled : true;
    }

    protected C0627d execute(C0624a c0624a) {
        if (!$assertionsDisabled && this.mSessionTask == null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && this.mSessionTask.f2198c != Thread.currentThread().getId()) {
            throw new AssertionError();
        } else if ($assertionsDisabled || c0624a != null) {
            C0627d c0653e = new C0653e(this, c0624a);
            this.mResponseList.add(c0653e);
            c0653e.m3091e();
            return c0653e;
        } else {
            throw new AssertionError();
        }
    }

    protected void fail() {
        if ($assertionsDisabled || this.mSessionTask.f2198c == Thread.currentThread().getId()) {
            throw new WebSessionFailException();
        }
        throw new AssertionError();
    }

    protected <T> void publishProgress(T t) {
        if (!$assertionsDisabled && this.mSessionTask == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || this.mSessionTask.f2198c == Thread.currentThread().getId()) {
            UThread.m1035a(new C0622d(this, t));
        } else {
            throw new AssertionError();
        }
    }

    protected boolean shouldBreak() {
        if (!$assertionsDisabled && this.mSessionTask == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || this.mSessionTask.f2198c == Thread.currentThread().getId()) {
            return this.mSessionTask.f2196a;
        } else {
            throw new AssertionError();
        }
    }

    protected void onSessionOpen() {
    }

    protected void onSessionCancelled() {
    }

    protected void onSessionClosed() {
    }

    protected boolean onSessionException(Exception exception, int i) {
        if (i < this.mMaxRetryCount) {
            return true;
        }
        return $assertionsDisabled;
    }

    protected void onSessionProgressUpdate() {
    }

    protected <T> void onSessionProgressUpdate(T t) {
    }

    private void scheduleSessionTask(CacheStrategy cacheStrategy, long j) {
        this.mSessionTask = new C0654f(this, cacheStrategy);
        if (this.mWebSessionConfig.f2205b) {
            this.mSessionFuture = j > 0 ? ah.m867a(this.mSessionTask, j) : ah.m871b(this.mSessionTask);
        } else {
            this.mSessionFuture = j > 0 ? ah.m868a(this.mSessionTask, this.mWebSessionConfig.f2204a, j) : ah.m866a(this.mSessionTask, this.mWebSessionConfig.f2204a);
        }
    }

    private boolean checkAccess() {
        return Thread.currentThread() == Looper.getMainLooper().getThread() ? true : $assertionsDisabled;
    }
}
