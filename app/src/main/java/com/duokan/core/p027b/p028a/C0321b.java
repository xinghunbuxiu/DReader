package com.duokan.core.p027b.p028a;

import android.text.TextUtils;
import android.util.Pair;
import com.duokan.core.io.FileUtil;
import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.io.InputException;
import com.duokan.core.io.OutputException;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.core.b.a.b */
public abstract class C0321b {
    /* renamed from: a */
    private static final ThreadLocal<C0323d> f550a = new ThreadLocal();

    /* renamed from: a */
    public static long m728a(HttpURLConnection httpURLConnection, OutputStream outputStream, C0320a c0320a) {
        OutputException outputException;
        Throwable th;
        InputStream inputStream = null;
        try {
            InputStream gZIPInputStream;
            byte[] a = C0321b.m731a(c0320a.f548d);
            if (TextUtils.equals(httpURLConnection.getContentEncoding(), "gzip")) {
                gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
            } else {
                gZIPInputStream = httpURLConnection.getInputStream();
            }
            int i = 0;
            long j = 0;
            while (i >= 0) {
                int i2 = 0;
                while (i >= 0) {
                    try {
                        if (i2 >= a.length) {
                            break;
                        }
                        int read = gZIPInputStream.read(a, i2, a.length - i2);
                        if (read > 0) {
                            i2 += read;
                            i = read;
                        } else {
                            i = read;
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        inputStream = gZIPInputStream;
                        th = th3;
                        C0321b.m730a(inputStream);
                        throw th;
                    }
                }
                outputStream.write(a, 0, i2);
                j = ((long) i2) + j;
            }
            C0321b.m730a(gZIPInputStream);
            return j;
        } catch (Throwable th4) {
            th = th4;
            C0321b.m730a(inputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static long m727a(HttpURLConnection httpURLConnection, File file, C0320a c0320a) {
        Throwable th;
        File file2 = null;
        try {
            if (file.exists()) {
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
            }
            File a = FileUtil.findFile(file.getName(), ".tmp!", file.getParentFile());
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(a);
                try {
                    long a2 = C0321b.m728a(httpURLConnection, (OutputStream) fileOutputStream, c0320a);
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                    }
                    if (a.renameTo(file)) {
                        if (a != null) {
                            FileUtil.deleteFile(a);
                        }
                        return a2;
                    }
                    throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                file2 = a;
                if (file2 != null) {
                    FileUtil.deleteFile(file2);
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (file2 != null) {
                FileUtil.deleteFile(file2);
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static long m726a(String str, OutputStream outputStream, C0320a c0320a) {
        Throwable th;
        OutputStream dataOutputStream = new DataOutputStream(outputStream);
        long j = -1;
        int i = 0;
        InputException e = null;
        while (i <= c0320a.f547c) {
            long j2;
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    Object obj;
                    int responseCode;
                    InputException inputException;
                    httpURLConnection2.setConnectTimeout(c0320a.f545a);
                    httpURLConnection2.setReadTimeout(c0320a.f546b);
                    if (!(c0320a.f549e == null || c0320a.f549e.isEmpty())) {
                        for (Pair pair : c0320a.f549e) {
                            httpURLConnection2.addRequestProperty((String) pair.first, (String) pair.second);
                        }
                    }
                    if (i > 0) {
                        if (dataOutputStream.size() > 0) {
                            httpURLConnection2.setRequestProperty("Range", "bytes=" + dataOutputStream.size() + "-");
                            obj = 1;
                            httpURLConnection2.connect();
                            responseCode = httpURLConnection2.getResponseCode();
                            if ((obj == null || responseCode != HttpStatus.SC_OK) && (obj == null || responseCode != HttpStatus.SC_PARTIAL_CONTENT)) {
                                inputException = new InputException(String.format("unexpected http response code: %d", new Object[]{Integer.valueOf(responseCode)}));
                                if (httpURLConnection2 == null) {
                                    httpURLConnection2.disconnect();
                                    e = inputException;
                                    j2 = j;
                                } else {
                                    e = inputException;
                                    j2 = j;
                                }
                                i++;
                                j = j2;
                            } else {
                                if (j < 0 && obj == null && ((TextUtils.isEmpty(httpURLConnection2.getContentEncoding()) || TextUtils.equals(httpURLConnection2.getContentEncoding(), HTTP.IDENTITY_CODING)) && httpURLConnection2.getContentLength() > 0)) {
                                    j = (long) httpURLConnection2.getContentLength();
                                }
                                C0321b.m728a(httpURLConnection2, dataOutputStream, c0320a);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                if (j < 0 || ((long) dataOutputStream.size()) == j) {
                                    e = null;
                                } else {
                                    e = new InputException(String.format("unexpected stream size(expected=%d, received=%d)", new Object[]{Long.valueOf(j), Integer.valueOf(dataOutputStream.size())}));
                                }
                                if (e != null) {
                                    return (long) dataOutputStream.size();
                                }
                                throw e;
                            }
                        }
                    }
                    obj = null;
                    httpURLConnection2.connect();
                    responseCode = httpURLConnection2.getResponseCode();
                    if (obj == null) {
                    }
                    inputException = new InputException(String.format("unexpected http response code: %d", new Object[]{Integer.valueOf(responseCode)}));
                    if (httpURLConnection2 == null) {
                        e = inputException;
                        j2 = j;
                    } else {
                        httpURLConnection2.disconnect();
                        e = inputException;
                        j2 = j;
                    }
                } catch (IOException e2) {
                    IOException iOException = e2;
                    httpURLConnection = httpURLConnection2;
                    e = iOException;
                } catch (IOException e22) {
                    j2 = j;
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    IOException e3 = e22;
                    httpURLConnection = httpURLConnection3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    j = j2;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                }
            } catch (OutputException e4) {
                e3 = e4;
            } catch (IOException e5) {
                e3 = e5;
                j2 = j;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                i++;
                j = j2;
            } catch (Throwable th4) {
                th = th4;
            }
            i++;
            j = j2;
        }
        if (e3 != null) {
            return (long) dataOutputStream.size();
        }
        throw e3;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (e3 != null) {
            return (long) dataOutputStream.size();
        }
        throw e3;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    /* renamed from: a */
    public static long m725a(String str, File file, C0320a c0320a) {
        Throwable th;
        File file2 = null;
        try {
            if (file.exists()) {
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
            }
            File a = FileUtil.findFile(file.getName(), ".tmp!", file.getParentFile());
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(a);
                try {
                    long a2 = C0321b.m726a(str, (OutputStream) fileOutputStream, c0320a);
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                    }
                    if (a.renameTo(file)) {
                        if (a != null) {
                            FileUtil.deleteFile(a);
                        }
                        return a2;
                    }
                    throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                file2 = a;
                if (file2 != null) {
                    FileUtil.deleteFile(file2);
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (file2 != null) {
                FileUtil.deleteFile(file2);
            }
            throw th;
        }
    }

    /* renamed from: b */
    public static long m732b(String str, File file, C0320a c0320a) {
        try {
            return C0321b.m725a(str, file, c0320a);
        } catch (Throwable th) {
            return -1;
        }
    }

    /* renamed from: a */
    private static void m730a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    private static byte[] m731a(int i) {
        C0323d a = C0321b.m729a();
        if (a.f551a == null || a.f551a.length < i) {
            a.f551a = new byte[i];
        }
        return a.f551a;
    }

    /* renamed from: a */
    private static C0323d m729a() {
        C0323d c0323d = (C0323d) f550a.get();
        if (c0323d != null) {
            return c0323d;
        }
        c0323d = new C0323d();
        f550a.set(c0323d);
        return c0323d;
    }
}
