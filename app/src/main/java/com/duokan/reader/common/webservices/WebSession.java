package com.duokan.reader.common.webservices;

import android.os.Looper;

import com.duokan.core.b.UrlTools.a;
import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.webservices.duokan.a.d;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class WebSession {
    static final  boolean $assertionsDisabled = (!WebSession.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String DEFAULT_SEQ_QUEUE = WebSession.class.getName();
    private static final long HTTP_COUNTING_TIME = TimeUnit.SECONDS.toMillis(100);
    private static final int HTTP_COUNT_TO_WARN = 20;
    private static final HashMap sHttpCountingMap = new HashMap();
    private static HttpLogger sHttpLogger = null;
    private CacheStrategy mCacheStrategy;
    private final a mHttpConfig;
    protected boolean mIsClosed;
    private int mMaxRetryCount;
    private final boolean mParallel;
    private final LinkedList mResponseList;
    private int mRetryCount;
    private final String mSeqQueueName;
    private Exception mSessionException;
    private Future mSessionFuture;
    private SessionState mSessionState;
    private SessionTask mSessionTask;

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

    public WebSession() {
        this(DEFAULT_SEQ_QUEUE);
    }

    protected WebSession(String str) {
        this.mIsClosed = true;
        this.mSessionState = SessionState.UNFINISHED;
        this.mRetryCount = 0;
        this.mMaxRetryCount = 0;
        this.mSessionException = null;
        this.mSessionTask = null;
        this.mSessionFuture = null;
        this.mResponseList = new LinkedList();
        this.mCacheStrategy = CacheStrategy.DISABLE_CACHE;
        this.mHttpConfig = new a();
        this.mParallel = $assertionsDisabled;
        this.mSeqQueueName = str;
    }

    protected WebSession(boolean z) {
        this.mIsClosed = true;
        this.mSessionState = SessionState.UNFINISHED;
        this.mRetryCount = 0;
        this.mMaxRetryCount = 0;
        this.mSessionException = null;
        this.mSessionTask = null;
        this.mSessionFuture = null;
        this.mResponseList = new LinkedList();
        this.mCacheStrategy = CacheStrategy.DISABLE_CACHE;
        this.mHttpConfig = new a();
        this.mParallel = z;
        this.mSeqQueueName = DEFAULT_SEQ_QUEUE;
    }

    public boolean getIsParallel() {
        return this.mParallel;
    }

    public boolean getIsClosed() {
        checkAccess();
        return this.mIsClosed;
    }

    public void setReadTimeout(int i) {
        this.mHttpConfig.b = i;
    }

    public void setConnectTimeout(int i) {
        this.mHttpConfig.a = i;
    }

    public void setMaxRetryCount(int i) {
        checkAccess();
        this.mMaxRetryCount = i;
    }

    public SessionState getSessionState() {
        checkAccess();
        return this.mSessionState;
    }

    protected CacheStrategy getCacheStrategy() {
        return this.mCacheStrategy;
    }

    public static void setLogger(HttpLogger fVar) {
        sHttpLogger = fVar;
    }

    public void refresh() {
        if ($assertionsDisabled || checkAccess()) {
            close();
            open(CacheStrategy.DO_NOT_USE_CACHE);
            return;
        }
        throw new AssertionError();
    }

    public void open() {
        open(CacheStrategy.DISABLE_CACHE);
    }

    public void open(CacheStrategy cacheStrategy) {
        open(cacheStrategy, 0);
    }

    public void open(long j) {
        open(CacheStrategy.DISABLE_CACHE, j);
    }

    public void open(CacheStrategy cacheStrategy, long j) {
        if (!$assertionsDisabled && !checkAccess()) {
            throw new AssertionError();
        } else if (this.mSessionTask == null || this.mSessionTask.a) {
            scheduleSessionTask(cacheStrategy, j);
        }
    }

    public void close() {
        if (!$assertionsDisabled && !checkAccess()) {
            throw new AssertionError();
        } else if (this.mSessionTask != null && !this.mSessionTask.a) {
            if ($assertionsDisabled || this.mSessionFuture != null) {
                this.mSessionTask.a = true;
                this.mSessionFuture.cancel(true);
                return;
            }
            throw new AssertionError();
        }
    }

    public boolean isCancelling() {
        return (this.mSessionTask == null || !this.mSessionTask.a) ? $assertionsDisabled : true;
    }

    protected d execute(com.duokan.reader.common.webservices.duokan.a.a aVar) {
        if (!$assertionsDisabled && this.mSessionTask == null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && this.mSessionTask.c != Thread.currentThread().getId()) {
            throw new AssertionError();
        } else if ($assertionsDisabled || aVar != null) {
            d fVar = new HttpLogger(this, aVar);
            this.mResponseList.add(fVar);
            fVar.e();
            return fVar;
        } else {
            throw new AssertionError();
        }
    }

    protected void fail() {
        if ($assertionsDisabled || this.mSessionTask.c == Thread.currentThread().getId()) {
            throw new WebSessionFailException();
        }
        throw new AssertionError();
    }

    protected void publishProgress(Object obj) {
        if (!$assertionsDisabled && this.mSessionTask == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || this.mSessionTask.c == Thread.currentThread().getId()) {
            TaskHandler.getTaskHandler(new e(this, obj));
        } else {
            throw new AssertionError();
        }
    }

    protected boolean shouldBreak() {
        if (!$assertionsDisabled && this.mSessionTask == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || this.mSessionTask.c == Thread.currentThread().getId()) {
            return this.mSessionTask.a;
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

    protected void onSessionProgressUpdate(Object obj) {
    }

    private void scheduleSessionTask(CacheStrategy cacheStrategy, long j) {
        this.mSessionTask = new SessionTask(this, cacheStrategy);
        if (this.mParallel) {
            this.mSessionFuture = j > 0 ? ah.submitScheduledFuture(this.mSessionTask, j) : ah.submitFuture(this.mSessionTask);
        } else {
            this.mSessionFuture = j > 0 ? ah.scheduledFuture(this.mSessionTask, this.mSeqQueueName, j) : ah.future(this.mSessionTask, this.mSeqQueueName);
        }
    }

    private boolean checkAccess() {
        return Thread.currentThread() == Looper.getMainLooper().getThread() ? true : $assertionsDisabled;
    }
}
