package com.duokan.reader.common.download;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.duokan.core.diagnostic.HttpLogger;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.download.DownloadTask.DownloadingStage;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import miuipub.date.Calendar;

class HttpDownloadBlock extends DownloadBlock {
    static final /* synthetic */ boolean q = (!HttpDownloadBlock.class.desiredAssertionStatus());
    private static final String r = HttpDownloadBlock.class.getName();
    private String s = null;
    private String t = null;
    private n u = null;
    private final HttpClient v;

    enum RetryableResult {
        SUCCEEDED,
        FAILED,
        RETRY
    }

    public HttpDownloadBlock(long j, String str, SQLiteDatabase sQLiteDatabase, a aVar, HttpLogger fVar, HttpClient httpClient) {
        super(j, str, sQLiteDatabase, aVar, fVar);
        this.v = httpClient;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void b(com.duokan.reader.common.download.c r9) {
        /*
        r8 = this;
        r7 = 0;
        r6 = 0;
        r4 = 0;
        r0 = q;
        if (r0 != 0) goto L_0x0012;
    L_0x0008:
        r0 = r8.getPhysicalYPixels;
        if (r0 != 0) goto L_0x0012;
    L_0x000c:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x0012:
        r0 = q;
        if (r0 != 0) goto L_0x0020;
    L_0x0016:
        r0 = r8.u;
        if (r0 == 0) goto L_0x0020;
    L_0x001a:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x0020:
        r0 = r8.getTriangleEdge;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0027;
    L_0x0026:
        return;
    L_0x0027:
        r0 = q;
        if (r0 != 0) goto L_0x003f;
    L_0x002b:
        r0 = r8.getTriangleEdge;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x003f;
    L_0x0031:
        r0 = r8.SessionTask;
        r2 = r8.getTriangleEdge;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x003f;
    L_0x0039:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x003f:
        r0 = r8.getTriangleEdge;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0053;
    L_0x0045:
        r0 = r8.SessionTask;
        r2 = r8.getTriangleEdge;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0053;
    L_0x004d:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.SUCCEEDED;
        r8.setDrawable(r6, r0);
        goto L_0x0026;
    L_0x0053:
        r0 = new com.duokan.reader.common.download.n;
        r0.<creatCallTask>();
        r8.u = r0;
        r0 = r8.u;
        r1 = java.lang.Thread.currentThread();
        r0.setDrawable = r1;
        r0 = r8.u;
        r9 = (com.duokan.reader.common.download.o) r9;
        r0.getVisible = r9;
        r0 = r8.u;
        r0.getPhysicalYPixels = r7;
        r0 = r8.u;
        r0.getWidthPixels = r7;
        r8.getPhysicalXPixels = r4;
        r0 = java.lang.System.nanoTime();
        r8.getHeightPixels = r0;
        r0 = r8.u;
        r0 = r0.getVisible;
        if (r0 == 0) goto L_0x0096;
    L_0x007e:
        r0 = r8.u;
        r0 = r0.getVisible;
        r0 = r0.getVisible;
        if (r0 != 0) goto L_0x0096;
    L_0x0086:
        r0 = q;
        if (r0 != 0) goto L_0x0094;
    L_0x008a:
        r0 = r8.getVisible;
        if (r0 == 0) goto L_0x0094;
    L_0x008e:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x0094:
        r8.SessionTask = r4;
    L_0x0096:
        r1 = r8.u;
    L_0x0098:
        r0 = r1.getPhysicalYPixels;
        if (r0 <= 0) goto L_0x00df;
    L_0x009c:
        r0 = r1.getPhysicalYPixels;
        r2 = r8.getTriangleEdge();
        if (r0 <= r2) goto L_0x00ab;
    L_0x00a4:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        r8.setDrawable(r1, r0);
        goto L_0x0026;
    L_0x00ab:
        r0 = q;
        if (r0 != 0) goto L_0x00bf;
    L_0x00af:
        r2 = r8.SessionTask;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00bf;
    L_0x00b5:
        r0 = r1.getVisible;
        if (r0 != 0) goto L_0x00bf;
    L_0x00b9:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x00bf:
        r2 = r8.SessionTask;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x00d2;
    L_0x00c5:
        r0 = r1.getVisible;
        r0 = r0.getVisible;
        if (r0 != 0) goto L_0x00d2;
    L_0x00cb:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        r8.setDrawable(r1, r0);
        goto L_0x0026;
    L_0x00d2:
        r0 = r1.getPhysicalYPixels;
        r2 = r1.getHeightPixels;
        r8.setDrawable(r0, r2);
        r2 = java.lang.System.nanoTime();
        r1.getHeightPixels = r2;
    L_0x00df:
        r0 = r8.o;
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;
        if (r0 != r2) goto L_0x00e5;
    L_0x00e5:
        r0 = r8.setDrawable(r1);
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;
        if (r0 != r2) goto L_0x00fb;
    L_0x00ed:
        r0 = r1.getScaledMaximumFlingVelocity;
        if (r0 == 0) goto L_0x00f8;
    L_0x00f1:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;
    L_0x00f3:
        r8.setDrawable(r1, r0);
        goto L_0x0026;
    L_0x00f8:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        goto L_0x00f3;
    L_0x00fb:
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;
        if (r0 != r2) goto L_0x0106;
    L_0x00ff:
        r0 = r1.getPhysicalYPixels;
        r0 = r0 + 1;
        r1.getPhysicalYPixels = r0;
        goto L_0x0098;
    L_0x0106:
        r0 = r8.getVisible(r1);
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;
        if (r0 != r2) goto L_0x011c;
    L_0x010e:
        r0 = r1.getScaledMaximumFlingVelocity;
        if (r0 == 0) goto L_0x0119;
    L_0x0112:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;
    L_0x0114:
        r8.setDrawable(r1, r0);
        goto L_0x0026;
    L_0x0119:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        goto L_0x0114;
    L_0x011c:
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;
        if (r0 == r2) goto L_0x00ff;
    L_0x0120:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.SUCCEEDED;
        r8.setDrawable(r1, r0);
        r0 = q;
        if (r0 != 0) goto L_0x0133;
    L_0x0129:
        r0 = r8.u;
        if (r0 == r1) goto L_0x0133;
    L_0x012d:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x0133:
        r8.u = r6;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.HttpDownloadBlock.getVisible(com.duokan.reader.common.download.getScaledMaximumFlingVelocity):void");
    }

    protected void f() {
        n nVar = this.u;
        if (nVar != null && !nVar.c) {
            nVar.c = true;
            if (nVar.a != null) {
                nVar.a.interrupt();
            }
            if (nVar.d != null) {
                nVar.d.abort();
            }
        }
    }

    void a(n nVar, boolean z) {
        long j = -1;
        if (!q && nVar == null) {
            throw new AssertionError();
        } else if (q || nVar.e != null) {
            if (z) {
                if (q || nVar.b == null) {
                    Matcher matcher;
                    int statusCode = nVar.e.getStatusLine().getStatusCode();
                    Header firstHeader = nVar.e.getFirstHeader(HTTP.CONTENT_LEN);
                    if (firstHeader != null) {
                        try {
                            j = Long.valueOf(firstHeader.getValue()).longValue();
                        } catch (NumberFormatException e) {
                        }
                    }
                    nVar.b = new o();
                    nVar.b.a = j;
                    nVar.b.b = statusCode == HttpStatus.SC_PARTIAL_CONTENT;
                    Header firstHeader2 = nVar.e.getFirstHeader("Accept-Ranges");
                    if (firstHeader2 != null && firstHeader2.getValue().equals("bytes")) {
                        nVar.b.b = true;
                    }
                    firstHeader2 = nVar.e.getFirstHeader("Content-Type");
                    if (firstHeader2 != null && firstHeader2.getValue().length() > 0) {
                        matcher = Pattern.compile("(\\S*)").matcher(firstHeader2.getValue().split(";")[0]);
                        if (matcher.matches() && matcher.groupCount() > 0) {
                            nVar.b.c = matcher.group(1);
                        }
                    }
                    firstHeader2 = nVar.e.getFirstHeader("Last-Modified");
                    if (firstHeader2 != null) {
                        nVar.b.i = firstHeader2.getValue();
                    }
                    firstHeader2 = nVar.e.getFirstHeader("ETag");
                    if (firstHeader2 != null) {
                        nVar.b.h = firstHeader2.getValue();
                    }
                    nVar.b.e = (String) nVar.f.getAttribute("_http.redirect_location");
                    nVar.b.f = (String) nVar.f.getAttribute("_http.permament_redirect_location");
                    firstHeader2 = nVar.e.getFirstHeader(MIME.CONTENT_DISPOSITION);
                    if (firstHeader2 != null && firstHeader2.getValue().length() > 0) {
                        matcher = Pattern.compile(".*\\;.*filename\\=\\\"(.*)\\\"").matcher(firstHeader2.getValue());
                        if (matcher.matches() && matcher.groupCount() > 0) {
                            String group = matcher.group(1);
                            if (!e.b(group)) {
                                nVar.b.g = group;
                            }
                            byte[] bArr = new byte[0];
                            try {
                                bArr = group.getBytes("ISO-8859-1");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                if (!q) {
                                    throw new AssertionError();
                                }
                            }
                            group = e.a(nVar.e);
                            if (nVar.b.g == null) {
                                try {
                                    nVar.b.g = Charset.forName(group).newDecoder().decode(ByteBuffer.wrap(bArr)).toString();
                                } catch (Exception e3) {
                                }
                            }
                            if (nVar.b.g == null) {
                                try {
                                    nVar.b.g = new String(bArr, group.equalsIgnoreCase("utf-8") ? "gb2312" : "utf-8");
                                } catch (Exception e4) {
                                }
                            }
                        }
                    }
                    Header firstHeader3 = nVar.e.getFirstHeader("Content-Location");
                    if (firstHeader3 != null && firstHeader3.getValue().length() > 0) {
                        try {
                            HttpHost httpHost = (HttpHost) nVar.f.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                            if (q || httpHost != null) {
                                nVar.b.d = URIUtils.resolve(new URI(httpHost.toURI()), e.a(nVar.e, firstHeader3.getValue())).toString();
                            } else {
                                throw new AssertionError();
                            }
                        } catch (Exception e5) {
                        }
                    }
                } else {
                    throw new AssertionError();
                }
            }
            if (!nVar.c) {
                a(this.u.b, z);
            }
        } else {
            throw new AssertionError();
        }
    }

    RetryableResult a(n nVar) {
        if (!q && nVar == null) {
            throw new AssertionError();
        } else if (!q && this.d == 0) {
            throw new AssertionError();
        } else if (nVar.c) {
            return RetryableResult.FAILED;
        } else {
            try {
                String str = this.i;
                if (!(nVar.b == null || nVar.b.f == null || nVar.b.f.length() <= 0)) {
                    str = nVar.b.f;
                }
                nVar.e = null;
                nVar.f = new BasicHttpContext();
                nVar.d = new HttpGet(str);
                if (this.d >= 0) {
                    long j = this.c + this.g;
                    long j2 = (this.c + this.d) - 1;
                    if (q || j <= j2) {
                        nVar.d.addHeader("Range", "bytes=" + j + "-" + j2);
                        HttpGet httpGet = nVar.d;
                        String str2 = "If-Range";
                        str = nVar.b == null ? "" : !TextUtils.isEmpty(nVar.b.h) ? nVar.b.h : nVar.b.i;
                        httpGet.addHeader(str2, str);
                    } else {
                        throw new AssertionError();
                    }
                } else if (this.o == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE) {
                    nVar.d.addHeader("Range", "bytes=0-");
                }
                try {
                    if (this.o == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE) {
                        nVar.e = this.v.execute(nVar.d, nVar.f);
                    } else {
                        nVar.e = this.v.execute(nVar.d, nVar.f);
                    }
                    if (nVar.f.getAttribute(ExecutionContext.HTTP_CONNECTION) instanceof HttpInetConnection) {
                        HttpInetConnection httpInetConnection = (HttpInetConnection) nVar.f.getAttribute(ExecutionContext.HTTP_CONNECTION);
                        this.n.print(LogLevel.EVENT, "" + this.b, "connection established", String.format(Locale.getDefault(), "local ip: %s\nremote ip: %s", new Object[]{httpInetConnection.getLocalAddress().getHostAddress(), httpInetConnection.getRemoteAddress().getHostAddress()}));
                    }
                    return RetryableResult.SUCCEEDED;
                } catch (Throwable e) {
                    this.n.printStackTrace(LogLevel.WARNING, "" + this.b, "connection failed", e);
                    return RetryableResult.RETRY;
                }
            } catch (Exception e2) {
                return RetryableResult.RETRY;
            }
        }
    }

    RetryableResult b(n nVar) {
        boolean z = true;
        HttpEntity httpEntity = null;
        if (!q && nVar == null) {
            throw new AssertionError();
        } else if (!q && nVar.d == null) {
            throw new AssertionError();
        } else if (q || nVar.e != null) {
            RetryableResult retryableResult;
            HttpEntity httpEntity2 = null;
            nVar.h = null;
            try {
                StatusLine statusLine = nVar.e.getStatusLine();
                if (statusLine == null) {
                    retryableResult = RetryableResult.RETRY;
                    try {
                        nVar.d.abort();
                        if (nVar.h != null) {
                            nVar.h.close();
                        }
                        nVar.h = null;
                        if (null != null) {
                            httpEntity2.consumeContent();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    switch (statusLine.getStatusCode()) {
                        case HttpStatus.SC_OK /*200*/:
                            if (this.c != 0 || this.g != 0) {
                                if (this.o == DownloadingStage.MULTI_BLOCK_SEQUENTIAL_DOWNLOADING && this.u.j < 5) {
                                    n nVar2 = this.u;
                                    nVar2.j++;
                                    retryableResult = RetryableResult.RETRY;
                                    try {
                                        nVar.d.abort();
                                        if (nVar.h != null) {
                                            nVar.h.close();
                                        }
                                        nVar.h = null;
                                        if (null != null) {
                                            httpEntity2.consumeContent();
                                            break;
                                        }
                                    } catch (Exception e2) {
                                        break;
                                    }
                                }
                                retryableResult = RetryableResult.FAILED;
                                try {
                                    nVar.d.abort();
                                    if (nVar.h != null) {
                                        nVar.h.close();
                                    }
                                    nVar.h = null;
                                    if (null != null) {
                                        httpEntity2.consumeContent();
                                        break;
                                    }
                                } catch (Exception e3) {
                                    break;
                                }
                            }
                            this.u.j = 0;
                            break;
                        break;
                        case HttpStatus.SC_PARTIAL_CONTENT /*206*/:
                            this.u.j = 0;
                            break;
                        default:
                            this.n.a(LogLevel.ERROR, "" + this.b, "response invalid(%getTriangleEdge)", Integer.valueOf(statusLine.getStatusCode()));
                            retryableResult = RetryableResult.FAILED;
                            try {
                                nVar.d.abort();
                                if (nVar.h != null) {
                                    nVar.h.close();
                                }
                                nVar.h = null;
                                if (null != null) {
                                    httpEntity2.consumeContent();
                                    break;
                                }
                            } catch (Exception e4) {
                                break;
                            }
                            break;
                    }
                    if (this.o == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE || this.o == DownloadingStage.MONO_BLOCK_DOWNLOADING) {
                        if (nVar.b != null) {
                            z = false;
                        }
                        a(nVar, z);
                        if (!q && nVar.b == null) {
                            throw new AssertionError();
                        }
                    }
                    httpEntity = nVar.e.getEntity();
                    if (httpEntity == null) {
                        retryableResult = RetryableResult.RETRY;
                        try {
                            nVar.d.abort();
                            if (nVar.h != null) {
                                nVar.h.close();
                            }
                            nVar.h = null;
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (Exception e5) {
                        }
                    } else if (httpEntity.getContentLength() < 0 || this.d < 0 || httpEntity.getContentLength() >= this.d - this.g) {
                        nVar.h = httpEntity.getContent();
                        retryableResult = c(nVar);
                        try {
                            nVar.d.abort();
                            if (nVar.h != null) {
                                nVar.h.close();
                            }
                            nVar.h = null;
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (Exception e6) {
                        }
                    } else {
                        retryableResult = RetryableResult.FAILED;
                        try {
                            nVar.d.abort();
                            if (nVar.h != null) {
                                nVar.h.close();
                            }
                            nVar.h = null;
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (Exception e7) {
                        }
                    }
                }
            } catch (Throwable e8) {
                this.n.printStackTrace(LogLevel.WARNING, "" + this.b, "response exception", e8);
                retryableResult = RetryableResult.RETRY;
                try {
                    nVar.d.abort();
                    if (nVar.h != null) {
                        nVar.h.close();
                    }
                    nVar.h = null;
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                } catch (Exception e9) {
                }
            } catch (Throwable e82) {
                this.n.printStackTrace(LogLevel.WARNING, "" + this.b, "response exception", e82);
                retryableResult = RetryableResult.FAILED;
                try {
                    nVar.d.abort();
                    if (nVar.h != null) {
                        nVar.h.close();
                    }
                    nVar.h = null;
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                } catch (Exception e10) {
                }
            } catch (Throwable th) {
                try {
                    nVar.d.abort();
                    if (nVar.h != null) {
                        nVar.h.close();
                    }
                    nVar.h = null;
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                } catch (Exception e11) {
                }
            }
            return retryableResult;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult c(com.duokan.reader.common.download.n r13) {
        /*
        r12 = this;
        r10 = 0;
        r1 = 0;
        r0 = q;
        if (r0 != 0) goto L_0x0011;
    L_0x0007:
        r0 = r13.getPhysicalXPixels;
        if (r0 != 0) goto L_0x0011;
    L_0x000b:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x0011:
        r0 = q;
        if (r0 != 0) goto L_0x0021;
    L_0x0015:
        r2 = r12.getTriangleEdge;
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r0 != 0) goto L_0x0021;
    L_0x001b:
        r0 = new java.lang.AssertionError;
        r0.<creatCallTask>();
        throw r0;
    L_0x0021:
        r0 = r13.SessionTask;
        if (r0 != 0) goto L_0x002b;
    L_0x0025:
        r0 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = new byte[r0];
        r13.SessionTask = r0;
    L_0x002b:
        r0 = r12.getWidthPixels;
        if (r0 != 0) goto L_0x0056;
    L_0x002f:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;
    L_0x0031:
        return r0;
    L_0x0032:
        r0 = r12.getWidthPixels;	 Catch:{ Exception -> 0x03f3 }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x03f3 }
        r6 = r12.SessionTask;	 Catch:{ Exception -> 0x03f3 }
        r4 = r4 + r6;
        r0.write(r3, r4);	 Catch:{ Exception -> 0x03f3 }
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.SessionTask = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.getPhysicalXPixels;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.getPhysicalXPixels = r4;	 Catch:{ all -> 0x008d }
        r12.SessionTask();	 Catch:{ all -> 0x008d }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        r6 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0056:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x008d }
        r2 = r1;
    L_0x005b:
        r0 = r13.SessionTask;	 Catch:{ Exception -> 0x0445 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0445 }
        if (r2 >= r0) goto L_0x03ba;
    L_0x0060:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0445 }
        r6 = r6 - r4;
        r8 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 >= 0) goto L_0x03ba;
    L_0x006b:
        r0 = r13.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x0445 }
        if (r0 == 0) goto L_0x013b;
    L_0x006f:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x00d8;
    L_0x0073:
        r1 = q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0098;
    L_0x0077:
        r4 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0098;
    L_0x007d:
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0098;
    L_0x0087:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<creatCallTask>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x008d:
        r0 = move-exception;
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x05d8 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x05d8 }
    L_0x0094:
        r12.SessionTask();
        throw r0;
    L_0x0098:
        r1 = r13.SessionTask;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x009f:
        r1 = r13.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x00b4;
    L_0x00a3:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x00af }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x00af }
    L_0x00ab:
        r12.SessionTask();
        goto L_0x0031;
    L_0x00af:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00ab;
    L_0x00b4:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x00e3 }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x00e3 }
        r6 = r12.SessionTask;	 Catch:{ Exception -> 0x00e3 }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x00e3 }
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.SessionTask = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.getPhysicalXPixels;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.getPhysicalXPixels = r4;	 Catch:{ all -> 0x008d }
        r12.SessionTask();	 Catch:{ all -> 0x008d }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        r6 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x00d8:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0136 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0136 }
    L_0x00de:
        r12.SessionTask();
        goto L_0x0031;
    L_0x00e3:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<creatCallTask>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.getVisible;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.setDrawable(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r12.getTriangleEdge();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x0121;
    L_0x010a:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x011c }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x011c }
    L_0x0117:
        r12.SessionTask();
        goto L_0x0031;
    L_0x011c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0117;
    L_0x0121:
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r13.getHeightPixels;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.getHeightPixels = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.getPhysicalYPixels = r1;	 Catch:{ all -> 0x008d }
        goto L_0x009f;
    L_0x0136:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00de;
    L_0x013b:
        r0 = r12.o;	 Catch:{ Exception -> 0x0445 }
        r3 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;	 Catch:{ Exception -> 0x0445 }
        if (r0 != r3) goto L_0x0141;
    L_0x0141:
        r6 = r12.getTriangleEdge;	 Catch:{ Exception -> 0x0445 }
        r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x0177;
    L_0x0147:
        r6 = r12.getTriangleEdge;	 Catch:{ Exception -> 0x0445 }
        r8 = r12.SessionTask;	 Catch:{ Exception -> 0x0445 }
        r6 = r6 - r8;
        r8 = (long) r2;	 Catch:{ Exception -> 0x0445 }
        r6 = r6 - r8;
        r0 = (int) r6;	 Catch:{ Exception -> 0x0445 }
        r3 = r13.SessionTask;	 Catch:{ Exception -> 0x0445 }
        r3 = r3.length;	 Catch:{ Exception -> 0x0445 }
        r3 = r3 - r2;
        r0 = java.lang.Math.min(r0, r3);	 Catch:{ Exception -> 0x0445 }
    L_0x0157:
        if (r0 > 0) goto L_0x0220;
    L_0x0159:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.SUCCEEDED;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x01bd;
    L_0x015d:
        r1 = q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x017c;
    L_0x0161:
        r4 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x017c;
    L_0x0167:
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x017c;
    L_0x0171:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<creatCallTask>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0177:
        r0 = r13.SessionTask;	 Catch:{ Exception -> 0x0445 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0445 }
        r0 = r0 - r2;
        goto L_0x0157;
    L_0x017c:
        r1 = r13.SessionTask;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0183:
        r1 = r13.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0199;
    L_0x0187:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0194 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0194 }
    L_0x018f:
        r12.SessionTask();
        goto L_0x0031;
    L_0x0194:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x018f;
    L_0x0199:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x01c8 }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x01c8 }
        r6 = r12.SessionTask;	 Catch:{ Exception -> 0x01c8 }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x01c8 }
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.SessionTask = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.getPhysicalXPixels;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.getPhysicalXPixels = r4;	 Catch:{ all -> 0x008d }
        r12.SessionTask();	 Catch:{ all -> 0x008d }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        r6 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x01bd:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x021b }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x021b }
    L_0x01c3:
        r12.SessionTask();
        goto L_0x0031;
    L_0x01c8:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<creatCallTask>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.getVisible;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.setDrawable(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r12.getTriangleEdge();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x0206;
    L_0x01ef:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0201 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0201 }
    L_0x01fc:
        r12.SessionTask();
        goto L_0x0031;
    L_0x0201:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01fc;
    L_0x0206:
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r13.getHeightPixels;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.getHeightPixels = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.getPhysicalYPixels = r1;	 Catch:{ all -> 0x008d }
        goto L_0x0183;
    L_0x021b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01c3;
    L_0x0220:
        r3 = r13.getPhysicalXPixels;	 Catch:{ Exception -> 0x0445 }
        r6 = r13.SessionTask;	 Catch:{ Exception -> 0x0445 }
        r0 = r3.read(r6, r2, r0);	 Catch:{ Exception -> 0x0445 }
        if (r0 >= 0) goto L_0x03b6;
    L_0x022a:
        r0 = r12.getTriangleEdge;	 Catch:{ Exception -> 0x0445 }
        r4 = -1;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x02f4;
    L_0x0232:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.SUCCEEDED;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x0291;
    L_0x0236:
        r1 = q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0250;
    L_0x023a:
        r4 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0250;
    L_0x0240:
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0250;
    L_0x024a:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<creatCallTask>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0250:
        r1 = r13.SessionTask;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0257:
        r1 = r13.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x026d;
    L_0x025b:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0268 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0268 }
    L_0x0263:
        r12.SessionTask();
        goto L_0x0031;
    L_0x0268:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0263;
    L_0x026d:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x029c }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x029c }
        r6 = r12.SessionTask;	 Catch:{ Exception -> 0x029c }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x029c }
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.SessionTask = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.getPhysicalXPixels;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.getPhysicalXPixels = r4;	 Catch:{ all -> 0x008d }
        r12.SessionTask();	 Catch:{ all -> 0x008d }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        r6 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0291:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x02ef }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x02ef }
    L_0x0297:
        r12.SessionTask();
        goto L_0x0031;
    L_0x029c:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<creatCallTask>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.getVisible;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.setDrawable(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r12.getTriangleEdge();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x02da;
    L_0x02c3:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x02d5 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x02d5 }
    L_0x02d0:
        r12.SessionTask();
        goto L_0x0031;
    L_0x02d5:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x02d0;
    L_0x02da:
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r13.getHeightPixels;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.getHeightPixels = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.getPhysicalYPixels = r1;	 Catch:{ all -> 0x008d }
        goto L_0x0257;
    L_0x02ef:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0297;
    L_0x02f4:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x0353;
    L_0x02f8:
        r1 = q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0312;
    L_0x02fc:
        r4 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0312;
    L_0x0302:
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0312;
    L_0x030c:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<creatCallTask>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0312:
        r1 = r13.SessionTask;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0319:
        r1 = r13.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x032f;
    L_0x031d:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x032a }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x032a }
    L_0x0325:
        r12.SessionTask();
        goto L_0x0031;
    L_0x032a:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0325;
    L_0x032f:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x035e }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x035e }
        r6 = r12.SessionTask;	 Catch:{ Exception -> 0x035e }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x035e }
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.SessionTask = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.getPhysicalXPixels;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.getPhysicalXPixels = r4;	 Catch:{ all -> 0x008d }
        r12.SessionTask();	 Catch:{ all -> 0x008d }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        r6 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0353:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x03b1 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x03b1 }
    L_0x0359:
        r12.SessionTask();
        goto L_0x0031;
    L_0x035e:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<creatCallTask>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.getVisible;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.setDrawable(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r12.getTriangleEdge();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x039c;
    L_0x0385:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0397 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0397 }
    L_0x0392:
        r12.SessionTask();
        goto L_0x0031;
    L_0x0397:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0392;
    L_0x039c:
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r13.getHeightPixels;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.getHeightPixels = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.getPhysicalYPixels = r1;	 Catch:{ all -> 0x008d }
        goto L_0x0319;
    L_0x03b1:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0359;
    L_0x03b6:
        r0 = r0 + r2;
        r2 = r0;
        goto L_0x005b;
    L_0x03ba:
        if (r2 <= 0) goto L_0x0056;
    L_0x03bc:
        r0 = q;	 Catch:{ all -> 0x008d }
        if (r0 != 0) goto L_0x03d6;
    L_0x03c0:
        r4 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r0 < 0) goto L_0x03d6;
    L_0x03c6:
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x03d6;
    L_0x03d0:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<creatCallTask>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x03d6:
        r0 = r13.SessionTask;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r0, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x03dd:
        r0 = r13.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        if (r0 == 0) goto L_0x0032;
    L_0x03e1:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x03ee }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x03ee }
    L_0x03e9:
        r12.SessionTask();
        goto L_0x0031;
    L_0x03ee:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x03e9;
    L_0x03f3:
        r0 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<creatCallTask>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.getVisible;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.setDrawable(r5, r6, r7, r0);	 Catch:{ all -> 0x008d }
        r0 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r12.getTriangleEdge();	 Catch:{ all -> 0x008d }
        if (r0 <= r4) goto L_0x0431;
    L_0x041a:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x042c }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x042c }
    L_0x0427:
        r12.SessionTask();
        goto L_0x0031;
    L_0x042c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0427;
    L_0x0431:
        r0 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r13.getHeightPixels;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r0, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.getHeightPixels = r4;	 Catch:{ all -> 0x008d }
        r0 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r0 = r0 + 1;
        r13.getPhysicalYPixels = r0;	 Catch:{ all -> 0x008d }
        goto L_0x03dd;
    L_0x0445:
        r0 = move-exception;
        r1 = r12.n;	 Catch:{ all -> 0x0526 }
        r3 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x0526 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0526 }
        r4.<creatCallTask>();	 Catch:{ all -> 0x0526 }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0526 }
        r5 = r12.getVisible;	 Catch:{ all -> 0x0526 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0526 }
        r4 = r4.toString();	 Catch:{ all -> 0x0526 }
        r5 = "failed to read bytes";
        r1.setDrawable(r3, r4, r5, r0);	 Catch:{ all -> 0x0526 }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;	 Catch:{ all -> 0x0526 }
        if (r2 <= 0) goto L_0x04c3;
    L_0x0468:
        r1 = q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0482;
    L_0x046c:
        r4 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0482;
    L_0x0472:
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0482;
    L_0x047c:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<creatCallTask>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0482:
        r1 = r13.SessionTask;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0489:
        r1 = r13.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x049f;
    L_0x048d:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x049a }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x049a }
    L_0x0495:
        r12.SessionTask();
        goto L_0x0031;
    L_0x049a:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0495;
    L_0x049f:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x04ce }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x04ce }
        r6 = r12.SessionTask;	 Catch:{ Exception -> 0x04ce }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x04ce }
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.SessionTask = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.getPhysicalXPixels;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.getPhysicalXPixels = r4;	 Catch:{ all -> 0x008d }
        r12.SessionTask();	 Catch:{ all -> 0x008d }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        r6 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x04c3:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0521 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0521 }
    L_0x04c9:
        r12.SessionTask();
        goto L_0x0031;
    L_0x04ce:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<creatCallTask>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.getVisible;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.setDrawable(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r12.getTriangleEdge();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x050c;
    L_0x04f5:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0507 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0507 }
    L_0x0502:
        r12.SessionTask();
        goto L_0x0031;
    L_0x0507:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0502;
    L_0x050c:
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r13.getHeightPixels;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.getHeightPixels = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.getPhysicalYPixels = r1;	 Catch:{ all -> 0x008d }
        goto L_0x0489;
    L_0x0521:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x04c9;
    L_0x0526:
        r0 = move-exception;
        if (r2 <= 0) goto L_0x0584;
    L_0x0529:
        r1 = q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0543;
    L_0x052d:
        r4 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0543;
    L_0x0533:
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.getTriangleEdge;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0543;
    L_0x053d:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<creatCallTask>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0543:
        r1 = r13.SessionTask;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x054a:
        r1 = r13.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0560;
    L_0x054e:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x055b }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x055b }
    L_0x0556:
        r12.SessionTask();
        goto L_0x0031;
    L_0x055b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0556;
    L_0x0560:
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x0585 }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ Exception -> 0x0585 }
        r6 = r12.SessionTask;	 Catch:{ Exception -> 0x0585 }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x0585 }
        r4 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.SessionTask = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.getPhysicalXPixels;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.getPhysicalXPixels = r4;	 Catch:{ all -> 0x008d }
        r12.SessionTask();	 Catch:{ all -> 0x008d }
        r4 = r12.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x008d }
        r6 = r12.SessionTask;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0584:
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0585:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<creatCallTask>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.getVisible;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.setDrawable(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r12.getTriangleEdge();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x05c3;
    L_0x05ac:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.getWidthPixels;	 Catch:{ Exception -> 0x05be }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x05be }
    L_0x05b9:
        r12.SessionTask();
        goto L_0x0031;
    L_0x05be:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x05b9;
    L_0x05c3:
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r4 = r13.getHeightPixels;	 Catch:{ all -> 0x008d }
        r12.setDrawable(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.getHeightPixels = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.getPhysicalYPixels;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.getPhysicalYPixels = r1;	 Catch:{ all -> 0x008d }
        goto L_0x054a;
    L_0x05d8:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.HttpDownloadBlock.getScaledMaximumFlingVelocity(com.duokan.reader.common.download.n):com.duokan.reader.common.download.HttpDownloadBlock$RetryableResult");
    }

    protected void a(int i, long j) {
        int min = Math.min((i * 2) * Calendar.MILLISECOND_OF_SECOND, Calendar.MILLISECOND_OF_MINUTE);
        if (j != 0) {
            min = (int) (((long) min) - ((System.nanoTime() - j) / 1000000));
        }
        if (min > 0) {
            try {
                Thread.sleep((long) min);
            } catch (InterruptedException e) {
                if (!q && !this.u.c) {
                    throw new AssertionError();
                }
            }
        }
    }

    protected void a(n nVar, BlockState blockState) {
        b(blockState);
    }

    public int d() {
        if (this.o == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE || this.o == DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING) {
            return 5;
        }
        if (this.o == DownloadingStage.MULTI_BLOCK_SEQUENTIAL_DOWNLOADING) {
            return 100;
        }
        return 100;
    }
}
