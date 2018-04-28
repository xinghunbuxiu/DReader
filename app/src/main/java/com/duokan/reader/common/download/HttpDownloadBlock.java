package com.duokan.reader.common.download;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.duokan.core.diagnostic.C0327f;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.ah;
import com.duokan.reader.common.download.DownloadBlock.BlockState;
import com.duokan.reader.common.download.DownloadTask.DownloadingStage;
import com.duokan.reader.common.p037c.C0558e;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import miuipub.date.Calendar;
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

class HttpDownloadBlock extends DownloadBlock {
    /* renamed from: q */
    static final /* synthetic */ boolean f1972q = (!HttpDownloadBlock.class.desiredAssertionStatus());
    /* renamed from: r */
    private static final String f1973r = HttpDownloadBlock.class.getName();
    /* renamed from: s */
    private String f1974s = null;
    /* renamed from: t */
    private String f1975t = null;
    /* renamed from: u */
    private C0604n f1976u = null;
    /* renamed from: v */
    private final HttpClient f1977v;

    enum RetryableResult {
        SUCCEEDED,
        FAILED,
        RETRY
    }

    public HttpDownloadBlock(long j, String str, SQLiteDatabase sQLiteDatabase, C0591a c0591a, C0327f c0327f, HttpClient httpClient) {
        super(j, str, sQLiteDatabase, c0591a, c0327f);
        this.f1977v = httpClient;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    protected void mo801b(com.duokan.reader.common.download.C0593c r9) {
        /*
        r8 = this;
        r7 = 0;
        r6 = 0;
        r4 = 0;
        r0 = f1972q;
        if (r0 != 0) goto L_0x0012;
    L_0x0008:
        r0 = r8.i;
        if (r0 != 0) goto L_0x0012;
    L_0x000c:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0012:
        r0 = f1972q;
        if (r0 != 0) goto L_0x0020;
    L_0x0016:
        r0 = r8.f1976u;
        if (r0 == 0) goto L_0x0020;
    L_0x001a:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0020:
        r0 = r8.d;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0027;
    L_0x0026:
        return;
    L_0x0027:
        r0 = f1972q;
        if (r0 != 0) goto L_0x003f;
    L_0x002b:
        r0 = r8.d;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x003f;
    L_0x0031:
        r0 = r8.g;
        r2 = r8.d;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x003f;
    L_0x0039:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x003f:
        r0 = r8.d;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x0053;
    L_0x0045:
        r0 = r8.g;
        r2 = r8.d;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0053;
    L_0x004d:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.SUCCEEDED;
        r8.m2737a(r6, r0);
        goto L_0x0026;
    L_0x0053:
        r0 = new com.duokan.reader.common.download.n;
        r0.<init>();
        r8.f1976u = r0;
        r0 = r8.f1976u;
        r1 = java.lang.Thread.currentThread();
        r0.f2017a = r1;
        r0 = r8.f1976u;
        r9 = (com.duokan.reader.common.download.C0605o) r9;
        r0.f2018b = r9;
        r0 = r8.f1976u;
        r0.f2025i = r7;
        r0 = r8.f1976u;
        r0.f2026j = r7;
        r8.h = r4;
        r0 = java.lang.System.nanoTime();
        r8.k = r0;
        r0 = r8.f1976u;
        r0 = r0.f2018b;
        if (r0 == 0) goto L_0x0096;
    L_0x007e:
        r0 = r8.f1976u;
        r0 = r0.f2018b;
        r0 = r0.b;
        if (r0 != 0) goto L_0x0096;
    L_0x0086:
        r0 = f1972q;
        if (r0 != 0) goto L_0x0094;
    L_0x008a:
        r0 = r8.b;
        if (r0 == 0) goto L_0x0094;
    L_0x008e:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0094:
        r8.g = r4;
    L_0x0096:
        r1 = r8.f1976u;
    L_0x0098:
        r0 = r1.f2025i;
        if (r0 <= 0) goto L_0x00df;
    L_0x009c:
        r0 = r1.f2025i;
        r2 = r8.mo802d();
        if (r0 <= r2) goto L_0x00ab;
    L_0x00a4:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        r8.m2737a(r1, r0);
        goto L_0x0026;
    L_0x00ab:
        r0 = f1972q;
        if (r0 != 0) goto L_0x00bf;
    L_0x00af:
        r2 = r8.g;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00bf;
    L_0x00b5:
        r0 = r1.f2018b;
        if (r0 != 0) goto L_0x00bf;
    L_0x00b9:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x00bf:
        r2 = r8.g;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x00d2;
    L_0x00c5:
        r0 = r1.f2018b;
        r0 = r0.b;
        if (r0 != 0) goto L_0x00d2;
    L_0x00cb:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        r8.m2737a(r1, r0);
        goto L_0x0026;
    L_0x00d2:
        r0 = r1.f2025i;
        r2 = r1.f2027k;
        r8.m2736a(r0, r2);
        r2 = java.lang.System.nanoTime();
        r1.f2027k = r2;
    L_0x00df:
        r0 = r8.o;
        r2 = com.duokan.reader.common.download.DownloadTask.DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING;
        if (r0 != r2) goto L_0x00e5;
    L_0x00e5:
        r0 = r8.m2735a(r1);
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;
        if (r0 != r2) goto L_0x00fb;
    L_0x00ed:
        r0 = r1.f2019c;
        if (r0 == 0) goto L_0x00f8;
    L_0x00f1:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;
    L_0x00f3:
        r8.m2737a(r1, r0);
        goto L_0x0026;
    L_0x00f8:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        goto L_0x00f3;
    L_0x00fb:
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;
        if (r0 != r2) goto L_0x0106;
    L_0x00ff:
        r0 = r1.f2025i;
        r0 = r0 + 1;
        r1.f2025i = r0;
        goto L_0x0098;
    L_0x0106:
        r0 = r8.m2739b(r1);
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;
        if (r0 != r2) goto L_0x011c;
    L_0x010e:
        r0 = r1.f2019c;
        if (r0 == 0) goto L_0x0119;
    L_0x0112:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.UNFINISHED;
    L_0x0114:
        r8.m2737a(r1, r0);
        goto L_0x0026;
    L_0x0119:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;
        goto L_0x0114;
    L_0x011c:
        r2 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;
        if (r0 == r2) goto L_0x00ff;
    L_0x0120:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.SUCCEEDED;
        r8.m2737a(r1, r0);
        r0 = f1972q;
        if (r0 != 0) goto L_0x0133;
    L_0x0129:
        r0 = r8.f1976u;
        if (r0 == r1) goto L_0x0133;
    L_0x012d:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0133:
        r8.f1976u = r6;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.HttpDownloadBlock.b(com.duokan.reader.common.download.c):void");
    }

    /* renamed from: f */
    protected void mo803f() {
        C0604n c0604n = this.f1976u;
        if (c0604n != null && !c0604n.f2019c) {
            c0604n.f2019c = true;
            if (c0604n.f2017a != null) {
                c0604n.f2017a.interrupt();
            }
            if (c0604n.f2020d != null) {
                try {
                    c0604n.f2020d.abort();
                } catch (Throwable th) {
                    ah.m871b(new C0603m(this, c0604n));
                }
            }
        }
    }

    /* renamed from: a */
    void m2738a(C0604n c0604n, boolean z) {
        long j = -1;
        if (!f1972q && c0604n == null) {
            throw new AssertionError();
        } else if (f1972q || c0604n.f2021e != null) {
            if (z) {
                if (f1972q || c0604n.f2018b == null) {
                    Matcher matcher;
                    int statusCode = c0604n.f2021e.getStatusLine().getStatusCode();
                    Header firstHeader = c0604n.f2021e.getFirstHeader(HTTP.CONTENT_LEN);
                    if (firstHeader != null) {
                        try {
                            j = Long.valueOf(firstHeader.getValue()).longValue();
                        } catch (NumberFormatException e) {
                        }
                    }
                    c0604n.f2018b = new C0605o();
                    c0604n.f2018b.a = j;
                    c0604n.f2018b.b = statusCode == HttpStatus.SC_PARTIAL_CONTENT;
                    Header firstHeader2 = c0604n.f2021e.getFirstHeader("Accept-Ranges");
                    if (firstHeader2 != null && firstHeader2.getValue().equals("bytes")) {
                        c0604n.f2018b.b = true;
                    }
                    firstHeader2 = c0604n.f2021e.getFirstHeader("Content-Type");
                    if (firstHeader2 != null && firstHeader2.getValue().length() > 0) {
                        matcher = Pattern.compile("(\\S*)").matcher(firstHeader2.getValue().split(VoiceWakeuperAidl.PARAMS_SEPARATE)[0]);
                        if (matcher.matches() && matcher.groupCount() > 0) {
                            c0604n.f2018b.c = matcher.group(1);
                        }
                    }
                    firstHeader2 = c0604n.f2021e.getFirstHeader("Last-Modified");
                    if (firstHeader2 != null) {
                        c0604n.f2018b.f2029i = firstHeader2.getValue();
                    }
                    firstHeader2 = c0604n.f2021e.getFirstHeader("ETag");
                    if (firstHeader2 != null) {
                        c0604n.f2018b.f2028h = firstHeader2.getValue();
                    }
                    c0604n.f2018b.e = (String) c0604n.f2022f.getAttribute("_http.redirect_location");
                    c0604n.f2018b.f = (String) c0604n.f2022f.getAttribute("_http.permament_redirect_location");
                    firstHeader2 = c0604n.f2021e.getFirstHeader(MIME.CONTENT_DISPOSITION);
                    if (firstHeader2 != null && firstHeader2.getValue().length() > 0) {
                        matcher = Pattern.compile(".*\\;.*filename\\=\\\"(.*)\\\"").matcher(firstHeader2.getValue());
                        if (matcher.matches() && matcher.groupCount() > 0) {
                            String group = matcher.group(1);
                            if (!C0558e.m2468b(group)) {
                                c0604n.f2018b.g = group;
                            }
                            byte[] bArr = new byte[0];
                            try {
                                bArr = group.getBytes("ISO-8859-1");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                if (!f1972q) {
                                    throw new AssertionError();
                                }
                            }
                            group = C0558e.m2466a(c0604n.f2021e);
                            if (c0604n.f2018b.g == null) {
                                try {
                                    c0604n.f2018b.g = Charset.forName(group).newDecoder().decode(ByteBuffer.wrap(bArr)).toString();
                                } catch (Exception e3) {
                                }
                            }
                            if (c0604n.f2018b.g == null) {
                                try {
                                    c0604n.f2018b.g = new String(bArr, group.equalsIgnoreCase("utf-8") ? "gb2312" : "utf-8");
                                } catch (Exception e4) {
                                }
                            }
                        }
                    }
                    Header firstHeader3 = c0604n.f2021e.getFirstHeader("Content-Location");
                    if (firstHeader3 != null && firstHeader3.getValue().length() > 0) {
                        try {
                            HttpHost httpHost = (HttpHost) c0604n.f2022f.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                            if (f1972q || httpHost != null) {
                                c0604n.f2018b.d = URIUtils.resolve(new URI(httpHost.toURI()), C0558e.m2467a(c0604n.f2021e, firstHeader3.getValue())).toString();
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
            if (!c0604n.f2019c) {
                m2663a(this.f1976u.f2018b, z);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    RetryableResult m2735a(C0604n c0604n) {
        if (!f1972q && c0604n == null) {
            throw new AssertionError();
        } else if (!f1972q && this.d == 0) {
            throw new AssertionError();
        } else if (c0604n.f2019c) {
            return RetryableResult.FAILED;
        } else {
            try {
                String str = this.i;
                if (!(c0604n.f2018b == null || c0604n.f2018b.f == null || c0604n.f2018b.f.length() <= 0)) {
                    str = c0604n.f2018b.f;
                }
                c0604n.f2021e = null;
                c0604n.f2022f = new BasicHttpContext();
                c0604n.f2020d = new HttpGet(str);
                if (this.d >= 0) {
                    long j = this.c + this.g;
                    long j2 = (this.c + this.d) - 1;
                    if (f1972q || j <= j2) {
                        c0604n.f2020d.addHeader("Range", "bytes=" + j + "-" + j2);
                        HttpGet httpGet = c0604n.f2020d;
                        String str2 = "If-Range";
                        str = c0604n.f2018b == null ? "" : !TextUtils.isEmpty(c0604n.f2018b.f2028h) ? c0604n.f2018b.f2028h : c0604n.f2018b.f2029i;
                        httpGet.addHeader(str2, str);
                    } else {
                        throw new AssertionError();
                    }
                } else if (this.o == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE) {
                    c0604n.f2020d.addHeader("Range", "bytes=0-");
                }
                try {
                    if (this.o == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE) {
                        c0604n.f2021e = this.f1977v.execute(c0604n.f2020d, c0604n.f2022f);
                    } else {
                        c0604n.f2021e = this.f1977v.execute(c0604n.f2020d, c0604n.f2022f);
                    }
                    if (c0604n.f2022f.getAttribute(ExecutionContext.HTTP_CONNECTION) instanceof HttpInetConnection) {
                        HttpInetConnection httpInetConnection = (HttpInetConnection) c0604n.f2022f.getAttribute(ExecutionContext.HTTP_CONNECTION);
                        this.n.m747a(LogLevel.EVENT, "" + this.b, "connection established", String.format(Locale.getDefault(), "local ip: %s\nremote ip: %s", new Object[]{httpInetConnection.getLocalAddress().getHostAddress(), httpInetConnection.getRemoteAddress().getHostAddress()}));
                    }
                    return RetryableResult.SUCCEEDED;
                } catch (Throwable e) {
                    this.n.m748a(LogLevel.WARNING, "" + this.b, "connection failed", e);
                    return RetryableResult.RETRY;
                }
            } catch (Exception e2) {
                return RetryableResult.RETRY;
            }
        }
    }

    /* renamed from: b */
    RetryableResult m2739b(C0604n c0604n) {
        boolean z = true;
        HttpEntity httpEntity = null;
        if (!f1972q && c0604n == null) {
            throw new AssertionError();
        } else if (!f1972q && c0604n.f2020d == null) {
            throw new AssertionError();
        } else if (f1972q || c0604n.f2021e != null) {
            RetryableResult retryableResult;
            HttpEntity httpEntity2 = null;
            c0604n.f2024h = null;
            try {
                StatusLine statusLine = c0604n.f2021e.getStatusLine();
                if (statusLine == null) {
                    retryableResult = RetryableResult.RETRY;
                    try {
                        c0604n.f2020d.abort();
                        if (c0604n.f2024h != null) {
                            c0604n.f2024h.close();
                        }
                        c0604n.f2024h = null;
                        if (null != null) {
                            httpEntity2.consumeContent();
                        }
                    } catch (Exception e) {
                    }
                } else {
                    switch (statusLine.getStatusCode()) {
                        case HttpStatus.SC_OK /*200*/:
                            if (this.c != 0 || this.g != 0) {
                                if (this.o == DownloadingStage.MULTI_BLOCK_SEQUENTIAL_DOWNLOADING && this.f1976u.f2026j < 5) {
                                    C0604n c0604n2 = this.f1976u;
                                    c0604n2.f2026j++;
                                    retryableResult = RetryableResult.RETRY;
                                    try {
                                        c0604n.f2020d.abort();
                                        if (c0604n.f2024h != null) {
                                            c0604n.f2024h.close();
                                        }
                                        c0604n.f2024h = null;
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
                                    c0604n.f2020d.abort();
                                    if (c0604n.f2024h != null) {
                                        c0604n.f2024h.close();
                                    }
                                    c0604n.f2024h = null;
                                    if (null != null) {
                                        httpEntity2.consumeContent();
                                        break;
                                    }
                                } catch (Exception e3) {
                                    break;
                                }
                            }
                            this.f1976u.f2026j = 0;
                            break;
                            break;
                        case HttpStatus.SC_PARTIAL_CONTENT /*206*/:
                            this.f1976u.f2026j = 0;
                            break;
                        default:
                            this.n.m749a(LogLevel.ERROR, "" + this.b, "response invalid(%d)", Integer.valueOf(statusLine.getStatusCode()));
                            retryableResult = RetryableResult.FAILED;
                            try {
                                c0604n.f2020d.abort();
                                if (c0604n.f2024h != null) {
                                    c0604n.f2024h.close();
                                }
                                c0604n.f2024h = null;
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
                        if (c0604n.f2018b != null) {
                            z = false;
                        }
                        m2738a(c0604n, z);
                        if (!f1972q && c0604n.f2018b == null) {
                            throw new AssertionError();
                        }
                    }
                    httpEntity = c0604n.f2021e.getEntity();
                    if (httpEntity == null) {
                        retryableResult = RetryableResult.RETRY;
                        try {
                            c0604n.f2020d.abort();
                            if (c0604n.f2024h != null) {
                                c0604n.f2024h.close();
                            }
                            c0604n.f2024h = null;
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (Exception e5) {
                        }
                    } else if (httpEntity.getContentLength() < 0 || this.d < 0 || httpEntity.getContentLength() >= this.d - this.g) {
                        c0604n.f2024h = httpEntity.getContent();
                        retryableResult = m2741c(c0604n);
                        try {
                            c0604n.f2020d.abort();
                            if (c0604n.f2024h != null) {
                                c0604n.f2024h.close();
                            }
                            c0604n.f2024h = null;
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (Exception e6) {
                        }
                    } else {
                        retryableResult = RetryableResult.FAILED;
                        try {
                            c0604n.f2020d.abort();
                            if (c0604n.f2024h != null) {
                                c0604n.f2024h.close();
                            }
                            c0604n.f2024h = null;
                            if (httpEntity != null) {
                                httpEntity.consumeContent();
                            }
                        } catch (Exception e7) {
                        }
                    }
                }
            } catch (Throwable e8) {
                this.n.m748a(LogLevel.WARNING, "" + this.b, "response exception", e8);
                retryableResult = RetryableResult.RETRY;
                try {
                    c0604n.f2020d.abort();
                    if (c0604n.f2024h != null) {
                        c0604n.f2024h.close();
                    }
                    c0604n.f2024h = null;
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                } catch (Exception e9) {
                }
            } catch (Throwable e82) {
                this.n.m748a(LogLevel.WARNING, "" + this.b, "response exception", e82);
                retryableResult = RetryableResult.FAILED;
                try {
                    c0604n.f2020d.abort();
                    if (c0604n.f2024h != null) {
                        c0604n.f2024h.close();
                    }
                    c0604n.f2024h = null;
                    if (httpEntity != null) {
                        httpEntity.consumeContent();
                    }
                } catch (Exception e10) {
                }
            } catch (Throwable th) {
                try {
                    c0604n.f2020d.abort();
                    if (c0604n.f2024h != null) {
                        c0604n.f2024h.close();
                    }
                    c0604n.f2024h = null;
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
    /* renamed from: c */
    com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult m2741c(com.duokan.reader.common.download.C0604n r13) {
        /*
        r12 = this;
        r10 = 0;
        r1 = 0;
        r0 = f1972q;
        if (r0 != 0) goto L_0x0011;
    L_0x0007:
        r0 = r13.f2024h;
        if (r0 != 0) goto L_0x0011;
    L_0x000b:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0011:
        r0 = f1972q;
        if (r0 != 0) goto L_0x0021;
    L_0x0015:
        r2 = r12.d;
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r0 != 0) goto L_0x0021;
    L_0x001b:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0021:
        r0 = r13.f2023g;
        if (r0 != 0) goto L_0x002b;
    L_0x0025:
        r0 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r0 = new byte[r0];
        r13.f2023g = r0;
    L_0x002b:
        r0 = r12.j;
        if (r0 != 0) goto L_0x0056;
    L_0x002f:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;
    L_0x0031:
        return r0;
    L_0x0032:
        r0 = r12.j;	 Catch:{ Exception -> 0x03f3 }
        r4 = r12.c;	 Catch:{ Exception -> 0x03f3 }
        r6 = r12.g;	 Catch:{ Exception -> 0x03f3 }
        r4 = r4 + r6;
        r0.write(r3, r4);	 Catch:{ Exception -> 0x03f3 }
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.g = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.h;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.h = r4;	 Catch:{ all -> 0x008d }
        r12.m2672g();	 Catch:{ all -> 0x008d }
        r4 = r12.c;	 Catch:{ all -> 0x008d }
        r6 = r12.g;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.m2659a(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0056:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x008d }
        r2 = r1;
    L_0x005b:
        r0 = r13.f2023g;	 Catch:{ Exception -> 0x0445 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0445 }
        if (r2 >= r0) goto L_0x03ba;
    L_0x0060:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0445 }
        r6 = r6 - r4;
        r8 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 >= 0) goto L_0x03ba;
    L_0x006b:
        r0 = r13.f2019c;	 Catch:{ Exception -> 0x0445 }
        if (r0 == 0) goto L_0x013b;
    L_0x006f:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x00d8;
    L_0x0073:
        r1 = f1972q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0098;
    L_0x0077:
        r4 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0098;
    L_0x007d:
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0098;
    L_0x0087:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x008d:
        r0 = move-exception;
        r1 = r12.j;	 Catch:{ Exception -> 0x05d8 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x05d8 }
    L_0x0094:
        r12.m2672g();
        throw r0;
    L_0x0098:
        r1 = r13.f2023g;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x009f:
        r1 = r13.f2019c;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x00b4;
    L_0x00a3:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x00af }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x00af }
    L_0x00ab:
        r12.m2672g();
        goto L_0x0031;
    L_0x00af:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00ab;
    L_0x00b4:
        r1 = r12.j;	 Catch:{ Exception -> 0x00e3 }
        r4 = r12.c;	 Catch:{ Exception -> 0x00e3 }
        r6 = r12.g;	 Catch:{ Exception -> 0x00e3 }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x00e3 }
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.g = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.h;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.h = r4;	 Catch:{ all -> 0x008d }
        r12.m2672g();	 Catch:{ all -> 0x008d }
        r4 = r12.c;	 Catch:{ all -> 0x008d }
        r6 = r12.g;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.m2659a(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x00d8:
        r1 = r12.j;	 Catch:{ Exception -> 0x0136 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0136 }
    L_0x00de:
        r12.m2672g();
        goto L_0x0031;
    L_0x00e3:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<init>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.b;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.m748a(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r12.mo802d();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x0121;
    L_0x010a:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.m2737a(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x011c }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x011c }
    L_0x0117:
        r12.m2672g();
        goto L_0x0031;
    L_0x011c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0117;
    L_0x0121:
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r13.f2027k;	 Catch:{ all -> 0x008d }
        r12.m2736a(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.f2027k = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.f2025i = r1;	 Catch:{ all -> 0x008d }
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
        r6 = r12.d;	 Catch:{ Exception -> 0x0445 }
        r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x0177;
    L_0x0147:
        r6 = r12.d;	 Catch:{ Exception -> 0x0445 }
        r8 = r12.g;	 Catch:{ Exception -> 0x0445 }
        r6 = r6 - r8;
        r8 = (long) r2;	 Catch:{ Exception -> 0x0445 }
        r6 = r6 - r8;
        r0 = (int) r6;	 Catch:{ Exception -> 0x0445 }
        r3 = r13.f2023g;	 Catch:{ Exception -> 0x0445 }
        r3 = r3.length;	 Catch:{ Exception -> 0x0445 }
        r3 = r3 - r2;
        r0 = java.lang.Math.min(r0, r3);	 Catch:{ Exception -> 0x0445 }
    L_0x0157:
        if (r0 > 0) goto L_0x0220;
    L_0x0159:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.SUCCEEDED;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x01bd;
    L_0x015d:
        r1 = f1972q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x017c;
    L_0x0161:
        r4 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x017c;
    L_0x0167:
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x017c;
    L_0x0171:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0177:
        r0 = r13.f2023g;	 Catch:{ Exception -> 0x0445 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0445 }
        r0 = r0 - r2;
        goto L_0x0157;
    L_0x017c:
        r1 = r13.f2023g;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0183:
        r1 = r13.f2019c;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0199;
    L_0x0187:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x0194 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0194 }
    L_0x018f:
        r12.m2672g();
        goto L_0x0031;
    L_0x0194:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x018f;
    L_0x0199:
        r1 = r12.j;	 Catch:{ Exception -> 0x01c8 }
        r4 = r12.c;	 Catch:{ Exception -> 0x01c8 }
        r6 = r12.g;	 Catch:{ Exception -> 0x01c8 }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x01c8 }
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.g = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.h;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.h = r4;	 Catch:{ all -> 0x008d }
        r12.m2672g();	 Catch:{ all -> 0x008d }
        r4 = r12.c;	 Catch:{ all -> 0x008d }
        r6 = r12.g;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.m2659a(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x01bd:
        r1 = r12.j;	 Catch:{ Exception -> 0x021b }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x021b }
    L_0x01c3:
        r12.m2672g();
        goto L_0x0031;
    L_0x01c8:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<init>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.b;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.m748a(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r12.mo802d();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x0206;
    L_0x01ef:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.m2737a(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x0201 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0201 }
    L_0x01fc:
        r12.m2672g();
        goto L_0x0031;
    L_0x0201:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01fc;
    L_0x0206:
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r13.f2027k;	 Catch:{ all -> 0x008d }
        r12.m2736a(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.f2027k = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.f2025i = r1;	 Catch:{ all -> 0x008d }
        goto L_0x0183;
    L_0x021b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x01c3;
    L_0x0220:
        r3 = r13.f2024h;	 Catch:{ Exception -> 0x0445 }
        r6 = r13.f2023g;	 Catch:{ Exception -> 0x0445 }
        r0 = r3.read(r6, r2, r0);	 Catch:{ Exception -> 0x0445 }
        if (r0 >= 0) goto L_0x03b6;
    L_0x022a:
        r0 = r12.d;	 Catch:{ Exception -> 0x0445 }
        r4 = -1;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x02f4;
    L_0x0232:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.SUCCEEDED;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x0291;
    L_0x0236:
        r1 = f1972q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0250;
    L_0x023a:
        r4 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0250;
    L_0x0240:
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0250;
    L_0x024a:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0250:
        r1 = r13.f2023g;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0257:
        r1 = r13.f2019c;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x026d;
    L_0x025b:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x0268 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0268 }
    L_0x0263:
        r12.m2672g();
        goto L_0x0031;
    L_0x0268:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0263;
    L_0x026d:
        r1 = r12.j;	 Catch:{ Exception -> 0x029c }
        r4 = r12.c;	 Catch:{ Exception -> 0x029c }
        r6 = r12.g;	 Catch:{ Exception -> 0x029c }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x029c }
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.g = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.h;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.h = r4;	 Catch:{ all -> 0x008d }
        r12.m2672g();	 Catch:{ all -> 0x008d }
        r4 = r12.c;	 Catch:{ all -> 0x008d }
        r6 = r12.g;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.m2659a(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0291:
        r1 = r12.j;	 Catch:{ Exception -> 0x02ef }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x02ef }
    L_0x0297:
        r12.m2672g();
        goto L_0x0031;
    L_0x029c:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<init>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.b;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.m748a(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r12.mo802d();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x02da;
    L_0x02c3:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.m2737a(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x02d5 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x02d5 }
    L_0x02d0:
        r12.m2672g();
        goto L_0x0031;
    L_0x02d5:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x02d0;
    L_0x02da:
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r13.f2027k;	 Catch:{ all -> 0x008d }
        r12.m2736a(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.f2027k = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.f2025i = r1;	 Catch:{ all -> 0x008d }
        goto L_0x0257;
    L_0x02ef:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0297;
    L_0x02f4:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;	 Catch:{ Exception -> 0x0445 }
        if (r2 <= 0) goto L_0x0353;
    L_0x02f8:
        r1 = f1972q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0312;
    L_0x02fc:
        r4 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0312;
    L_0x0302:
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0312;
    L_0x030c:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0312:
        r1 = r13.f2023g;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0319:
        r1 = r13.f2019c;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x032f;
    L_0x031d:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x032a }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x032a }
    L_0x0325:
        r12.m2672g();
        goto L_0x0031;
    L_0x032a:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0325;
    L_0x032f:
        r1 = r12.j;	 Catch:{ Exception -> 0x035e }
        r4 = r12.c;	 Catch:{ Exception -> 0x035e }
        r6 = r12.g;	 Catch:{ Exception -> 0x035e }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x035e }
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.g = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.h;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.h = r4;	 Catch:{ all -> 0x008d }
        r12.m2672g();	 Catch:{ all -> 0x008d }
        r4 = r12.c;	 Catch:{ all -> 0x008d }
        r6 = r12.g;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.m2659a(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0353:
        r1 = r12.j;	 Catch:{ Exception -> 0x03b1 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x03b1 }
    L_0x0359:
        r12.m2672g();
        goto L_0x0031;
    L_0x035e:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<init>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.b;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.m748a(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r12.mo802d();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x039c;
    L_0x0385:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.m2737a(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x0397 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0397 }
    L_0x0392:
        r12.m2672g();
        goto L_0x0031;
    L_0x0397:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0392;
    L_0x039c:
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r13.f2027k;	 Catch:{ all -> 0x008d }
        r12.m2736a(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.f2027k = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.f2025i = r1;	 Catch:{ all -> 0x008d }
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
        r0 = f1972q;	 Catch:{ all -> 0x008d }
        if (r0 != 0) goto L_0x03d6;
    L_0x03c0:
        r4 = r12.d;	 Catch:{ all -> 0x008d }
        r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r0 < 0) goto L_0x03d6;
    L_0x03c6:
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.d;	 Catch:{ all -> 0x008d }
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x03d6;
    L_0x03d0:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x03d6:
        r0 = r13.f2023g;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r0, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x03dd:
        r0 = r13.f2019c;	 Catch:{ all -> 0x008d }
        if (r0 == 0) goto L_0x0032;
    L_0x03e1:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x03ee }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x03ee }
    L_0x03e9:
        r12.m2672g();
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
        r6.<init>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.b;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.m748a(r5, r6, r7, r0);	 Catch:{ all -> 0x008d }
        r0 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r12.mo802d();	 Catch:{ all -> 0x008d }
        if (r0 <= r4) goto L_0x0431;
    L_0x041a:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.m2737a(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x042c }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x042c }
    L_0x0427:
        r12.m2672g();
        goto L_0x0031;
    L_0x042c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0427;
    L_0x0431:
        r0 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r13.f2027k;	 Catch:{ all -> 0x008d }
        r12.m2736a(r0, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.f2027k = r4;	 Catch:{ all -> 0x008d }
        r0 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r0 = r0 + 1;
        r13.f2025i = r0;	 Catch:{ all -> 0x008d }
        goto L_0x03dd;
    L_0x0445:
        r0 = move-exception;
        r1 = r12.n;	 Catch:{ all -> 0x0526 }
        r3 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x0526 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0526 }
        r4.<init>();	 Catch:{ all -> 0x0526 }
        r5 = "";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0526 }
        r5 = r12.b;	 Catch:{ all -> 0x0526 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0526 }
        r4 = r4.toString();	 Catch:{ all -> 0x0526 }
        r5 = "failed to read bytes";
        r1.m748a(r3, r4, r5, r0);	 Catch:{ all -> 0x0526 }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.RETRY;	 Catch:{ all -> 0x0526 }
        if (r2 <= 0) goto L_0x04c3;
    L_0x0468:
        r1 = f1972q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0482;
    L_0x046c:
        r4 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0482;
    L_0x0472:
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0482;
    L_0x047c:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0482:
        r1 = r13.f2023g;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x0489:
        r1 = r13.f2019c;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x049f;
    L_0x048d:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x049a }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x049a }
    L_0x0495:
        r12.m2672g();
        goto L_0x0031;
    L_0x049a:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0495;
    L_0x049f:
        r1 = r12.j;	 Catch:{ Exception -> 0x04ce }
        r4 = r12.c;	 Catch:{ Exception -> 0x04ce }
        r6 = r12.g;	 Catch:{ Exception -> 0x04ce }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x04ce }
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.g = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.h;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.h = r4;	 Catch:{ all -> 0x008d }
        r12.m2672g();	 Catch:{ all -> 0x008d }
        r4 = r12.c;	 Catch:{ all -> 0x008d }
        r6 = r12.g;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.m2659a(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x04c3:
        r1 = r12.j;	 Catch:{ Exception -> 0x0521 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0521 }
    L_0x04c9:
        r12.m2672g();
        goto L_0x0031;
    L_0x04ce:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<init>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.b;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.m748a(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r12.mo802d();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x050c;
    L_0x04f5:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.m2737a(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x0507 }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x0507 }
    L_0x0502:
        r12.m2672g();
        goto L_0x0031;
    L_0x0507:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0502;
    L_0x050c:
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r13.f2027k;	 Catch:{ all -> 0x008d }
        r12.m2736a(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.f2027k = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.f2025i = r1;	 Catch:{ all -> 0x008d }
        goto L_0x0489;
    L_0x0521:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x04c9;
    L_0x0526:
        r0 = move-exception;
        if (r2 <= 0) goto L_0x0584;
    L_0x0529:
        r1 = f1972q;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0543;
    L_0x052d:
        r4 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r1 < 0) goto L_0x0543;
    L_0x0533:
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = r12.d;	 Catch:{ all -> 0x008d }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0543;
    L_0x053d:
        r0 = new java.lang.AssertionError;	 Catch:{ all -> 0x008d }
        r0.<init>();	 Catch:{ all -> 0x008d }
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0543:
        r1 = r13.f2023g;	 Catch:{ all -> 0x008d }
        r3 = 0;
        r3 = java.nio.ByteBuffer.wrap(r1, r3, r2);	 Catch:{ all -> 0x008d }
    L_0x054a:
        r1 = r13.f2019c;	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0560;
    L_0x054e:
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x055b }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x055b }
    L_0x0556:
        r12.m2672g();
        goto L_0x0031;
    L_0x055b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0556;
    L_0x0560:
        r1 = r12.j;	 Catch:{ Exception -> 0x0585 }
        r4 = r12.c;	 Catch:{ Exception -> 0x0585 }
        r6 = r12.g;	 Catch:{ Exception -> 0x0585 }
        r4 = r4 + r6;
        r1.write(r3, r4);	 Catch:{ Exception -> 0x0585 }
        r4 = r12.g;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.g = r4;	 Catch:{ all -> 0x008d }
        r4 = r12.h;	 Catch:{ all -> 0x008d }
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r12.h = r4;	 Catch:{ all -> 0x008d }
        r12.m2672g();	 Catch:{ all -> 0x008d }
        r4 = r12.c;	 Catch:{ all -> 0x008d }
        r6 = r12.g;	 Catch:{ all -> 0x008d }
        r4 = r4 + r6;
        r6 = (long) r2;	 Catch:{ all -> 0x008d }
        r4 = r4 - r6;
        r2 = (long) r2;	 Catch:{ all -> 0x008d }
        r12.m2659a(r4, r2);	 Catch:{ all -> 0x008d }
    L_0x0584:
        throw r0;	 Catch:{ all -> 0x008d }
    L_0x0585:
        r1 = move-exception;
        r4 = r12.n;	 Catch:{ all -> 0x008d }
        r5 = com.duokan.core.diagnostic.LogLevel.WARNING;	 Catch:{ all -> 0x008d }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r6.<init>();	 Catch:{ all -> 0x008d }
        r7 = "";
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r7 = r12.b;	 Catch:{ all -> 0x008d }
        r6 = r6.append(r7);	 Catch:{ all -> 0x008d }
        r6 = r6.toString();	 Catch:{ all -> 0x008d }
        r7 = "failed to write bytes";
        r4.m748a(r5, r6, r7, r1);	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r12.mo802d();	 Catch:{ all -> 0x008d }
        if (r1 <= r4) goto L_0x05c3;
    L_0x05ac:
        r0 = com.duokan.reader.common.download.DownloadBlock.BlockState.FAILED;	 Catch:{ all -> 0x008d }
        r12.m2737a(r13, r0);	 Catch:{ all -> 0x008d }
        r0 = com.duokan.reader.common.download.HttpDownloadBlock.RetryableResult.FAILED;	 Catch:{ all -> 0x008d }
        r1 = r12.j;	 Catch:{ Exception -> 0x05be }
        r2 = 0;
        r1.force(r2);	 Catch:{ Exception -> 0x05be }
    L_0x05b9:
        r12.m2672g();
        goto L_0x0031;
    L_0x05be:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x05b9;
    L_0x05c3:
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r4 = r13.f2027k;	 Catch:{ all -> 0x008d }
        r12.m2736a(r1, r4);	 Catch:{ all -> 0x008d }
        r4 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
        r13.f2027k = r4;	 Catch:{ all -> 0x008d }
        r1 = r13.f2025i;	 Catch:{ all -> 0x008d }
        r1 = r1 + 1;
        r13.f2025i = r1;	 Catch:{ all -> 0x008d }
        goto L_0x054a;
    L_0x05d8:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.common.download.HttpDownloadBlock.c(com.duokan.reader.common.download.n):com.duokan.reader.common.download.HttpDownloadBlock$RetryableResult");
    }

    /* renamed from: a */
    protected void m2736a(int i, long j) {
        int min = Math.min((i * 2) * 1000, Calendar.MILLISECOND_OF_MINUTE);
        if (j != 0) {
            min = (int) (((long) min) - ((System.nanoTime() - j) / 1000000));
        }
        if (min > 0) {
            try {
                Thread.sleep((long) min);
            } catch (InterruptedException e) {
                if (!f1972q && !this.f1976u.f2019c) {
                    throw new AssertionError();
                }
            }
        }
    }

    /* renamed from: a */
    protected void m2737a(C0604n c0604n, BlockState blockState) {
        m2666b(blockState);
    }

    /* renamed from: d */
    public int mo802d() {
        if (this.o == DownloadingStage.MULTI_BLOCK_DOWNLOADING_HANDSHAKE || this.o == DownloadingStage.MULTI_BLOCK_PARALLEL_DOWNLOADING) {
            return 5;
        }
        if (this.o == DownloadingStage.MULTI_BLOCK_SEQUENTIAL_DOWNLOADING) {
            return 100;
        }
        return 100;
    }
}
