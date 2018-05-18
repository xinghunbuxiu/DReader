package com.duokan.core.p027b.p028a;

import android.text.TextUtils;
import android.util.Pair;

import com.duokan.core.io.FileAlreadyExistsException;
import com.duokan.core.io.FileUtil;
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


public abstract class C0321b {

    private static final ThreadLocal<C0323d> f550a = new ThreadLocal();


    public static long m728a(HttpURLConnection httpURLConnection, OutputStream outputStream, HttpConfig httpConfig) {
        OutputException outputException;
        InputStream inputStream = null;
        try {
            InputStream gZIPInputStream;
            byte[] a = C0321b.m731a(httpConfig.f548d);
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
                        C0321b.close(inputStream);
                        throw th;
                    }
                }
                outputStream.write(a, 0, i2);
                j = ((long) i2) + j;
            }
            C0321b.close(gZIPInputStream);
            return j;


        }
    }


    public static long m727a(HttpURLConnection httpURLConnection, File file, HttpConfig httpConfig) {
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
                    long a2 = C0321b.m728a(httpURLConnection, (OutputStream) fileOutputStream, httpConfig);
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


    public static long getOutputStreamSize(String actionUrl, OutputStream outputStream, HttpConfig httpConfig) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        HttpURLConnection httpURLConnection = null;
        long contentLength = -1;
        int size = 0;
        while (size <= httpConfig.f547c) {
            try {
                int responseCode;
                Object obj;
                InputException inputException;
                URL url = new URL(actionUrl);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(httpConfig.connectTimeout);
                httpURLConnection.setReadTimeout(httpConfig.readTimeout);
                if (!(httpConfig.pairLists == null || httpConfig.pairLists.isEmpty())) {
                    for (Pair<String, String> pair : httpConfig.pairLists) {
                        httpURLConnection.addRequestProperty(pair.first, pair.second);
                    }
                }
                if (size > 0) {
                    if (dataOutputStream.size() > 0) {
                        httpURLConnection.setRequestProperty("Range", "bytes=" + dataOutputStream.size() + "-");
                        obj = 1;
                        httpURLConnection.connect();
                        responseCode = httpURLConnection.getResponseCode();
                        if ((obj == null || responseCode != HttpStatus.SC_OK) && (obj == null || responseCode != HttpStatus.SC_PARTIAL_CONTENT)) {
                            inputException = new InputException(String.format("unexpected http response code: %d", new Object[]{Integer.valueOf(responseCode)}));
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            size++;
                        } else {
                            if (contentLength < 0 && obj == null && ((TextUtils.isEmpty(httpURLConnection.getContentEncoding()) || TextUtils.equals(httpURLConnection.getContentEncoding(), HTTP.IDENTITY_CODING)) && httpURLConnection.getContentLength() > 0)) {
                                contentLength = httpURLConnection.getContentLength();
                            }
                            C0321b.m728a(httpURLConnection, dataOutputStream, httpConfig);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            if (contentLength < 0 || (dataOutputStream.size()) == contentLength) {
                                httpURLConnection = null;
                            } else {
                                inputException = new InputException(String.format("unexpected stream size(expected=%d, received=%d)", new Object[]{contentLength, dataOutputStream.size()})))
                            }
                            if (httpURLConnection != null) {
                                return dataOutputStream.size();
                            }
                        }
                    }
                }
                obj = null;
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (obj == null) {
                }
                inputException = new InputException(String.format("unexpected http response code: %d", new Object[]{Integer.valueOf(responseCode)}));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } finally {
            }
        }
        return dataOutputStream.size();
    }


    public static long getFileLength(String actionUrl, File file, HttpConfig httpConfig) {
        FileOutputStream fileOutputStream = null;
        long putStreamSize = 0;
        try {
            if (file.exists()) {
                throw new FileAlreadyExistsException(String.format("the file(%s) already exists", new Object[]{file.getAbsolutePath()}));
            }
            File tmpFiles = FileUtil.findFile(file.getName(), ".tmp!", file.getParentFile());
            fileOutputStream = new FileOutputStream(tmpFiles);
            putStreamSize = getOutputStreamSize(actionUrl, fileOutputStream, httpConfig);
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.getFD().sync();
                fileOutputStream.close();
            }
            if (tmpFiles.renameTo(file)) {
                if (tmpFiles != null) {
                    FileUtil.deleteFile(tmpFiles);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return putStreamSize;

    }


    public static long m732b(String str, File file, HttpConfig httpConfig) {
        try {
            return getFileLength(str, file, httpConfig);
        } catch (Throwable th) {
            return -1;
        }
    }


    private static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static byte[] m731a(int i) {
        C0323d a = C0321b.m729a();
        if (a.bytes == null || a.bytes.length < i) {
            a.bytes = new byte[i];
        }
        return a.bytes;
    }


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
