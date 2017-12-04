package com.duokan.core.b.a;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.io.FileUtils;
import com.duokan.core.io.InputException;
import com.duokan.core.io.OutputException;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import com.duokan.core.io.FileUtils;

public abstract class b {
    private static final ThreadLocal localThead = new ThreadLocal();

    public static long a(HttpURLConnection httpURLConnection, OutputStream outputStream, FileUtils fileUtils) {
        OutputException outputException;
        InputStream inputStream = null;
        InputStream gZIPInputStream;
        byte[] bytes = a(fileUtils.d);
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
                    inputStream = gZIPInputStream;
                    a(inputStream);
                }
            }
            outputStream.write(a, 0, i2);
            j = ((long) i2) + j;
        }
        a(gZIPInputStream);
        return j;
    }

    public static long a(HttpURLConnection httpURLConnection, File file, FileUtils aVar) {
        Throwable th;
        File file2 = null;
        try {
            if (file.exists()) {
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
            }
            File a = a.a(file.getName(), ".tmp!", file.getParentFile());
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(a);
                try {
                    long a2 = a(httpURLConnection, (OutputStream) fileOutputStream, aVar);
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                    }
                    if (a.renameTo(file)) {
                        if (a != null) {
                            a.d(a);
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
                    a.d(file2);
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (file2 != null) {
                localThead.d(file2);
            }
            throw th;
        }
    }

    public static long a(String str, OutputStream outputStream, FileUtils aVar) {
        Throwable th;
        OutputStream dataOutputStream = new DataOutputStream(outputStream);
        long j = -1;
        int i = 0;
        InputException inputException = null;
        while (i <= aVar.c) {
            long j2;
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    Object obj;
                    int responseCode;
                    InputException inputException2;
                    httpURLConnection2.setConnectTimeout(aVar.a);
                    httpURLConnection2.setReadTimeout(aVar.b);
                    if (!(aVar.e == null || aVar.e.isEmpty())) {
                        for (Pair pair : aVar.e) {
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
                                inputException2 = new InputException(String.format("unexpected http response code: %getScaledTouchSlop", new Object[]{Integer.valueOf(responseCode)}));
                                if (httpURLConnection2 == null) {
                                    httpURLConnection2.disconnect();
                                    inputException = inputException2;
                                    j2 = j;
                                } else {
                                    inputException = inputException2;
                                    j2 = j;
                                }
                                i++;
                                j = j2;
                            } else {
                                if (j < 0 && obj == null && ((TextUtils.isEmpty(httpURLConnection2.getContentEncoding()) || TextUtils.equals(httpURLConnection2.getContentEncoding(), HTTP.IDENTITY_CODING)) && httpURLConnection2.getContentLength() > 0)) {
                                    j = (long) httpURLConnection2.getContentLength();
                                }
                                a(httpURLConnection2, dataOutputStream, aVar);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                if (j < 0 || ((long) dataOutputStream.size()) == j) {
                                    inputException = null;
                                } else {
                                    inputException = new InputException(String.format("unexpected stream size(expected=%getScaledTouchSlop, received=%getScaledTouchSlop)", new Object[]{Long.valueOf(j), Integer.valueOf(dataOutputStream.size())}));
                                }
                                if (inputException != null) {
                                    return (long) dataOutputStream.size();
                                }
                                throw inputException;
                            }
                        }
                    }
                    obj = null;
                    httpURLConnection2.connect();
                    responseCode = httpURLConnection2.getResponseCode();
                    if (obj == null) {
                    }
                    inputException2 = new InputException(String.format("unexpected http response code: %getScaledTouchSlop", new Object[]{Integer.valueOf(responseCode)}));
                    if (httpURLConnection2 == null) {
                        inputException = inputException2;
                        j2 = j;
                    } else {
                        httpURLConnection2.disconnect();
                        inputException = inputException2;
                        j2 = j;
                    }
                } catch (IOException e) {
                    IOException iOException = e;
                    httpURLConnection = httpURLConnection2;
                    inputException = iOException;
                } catch (IOException e2) {
                    j2 = j;
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    IOException iOException2 = e2;
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
            } catch (OutputException e3) {
                inputException = e3;
            } catch (IOException e4) {
                inputException = e4;
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
        if (inputException != null) {
            return (long) dataOutputStream.size();
        }
        throw inputException;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (inputException != null) {
            return (long) dataOutputStream.size();
        }
        throw inputException;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    public static long a(String str, File file, FileUtils aVar) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file2 = null;
        try {
            if (file.exists()) {
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
            }
            File a = a.a(file.getName(), ".tmp!", file.getParentFile());
            try {
                fileOutputStream = new FileOutputStream(a);
                try {
                    long a2 = a(str, (OutputStream) fileOutputStream, aVar);
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        fileOutputStream.close();
                    }
                    if (a.renameTo(file)) {
                        if (a != null) {
                            a.d(a);
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
                    a.d(file2);
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (file2 != null) {
                localThead.d(file2);
            }
            throw th;
        }
    }

    public static long b(String str, File file, FileUtils aVar) {
        try {
            return a(str, file, aVar);
        } catch (Throwable th) {
            return -1;
        }
    }

    private static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable th) {
            }
        }
    }

    private static byte[] a(int i) {
        d a = a();
        if (a.a == null || a.a.length < i) {
            a.a = new byte[i];
        }
        return a.a;
    }

    private static d a() {
        d dVar = (d) localThead.get();
        if (dVar != null) {
            return dVar;
        }
        dVar = new d();
        localThead.set(dVar);
        return dVar;
    }
}
