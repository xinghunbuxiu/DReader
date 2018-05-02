package com.duokan.reader.p031a.p032a.p033a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.a.a.a.b */
public class C0510b {
    /* renamed from: a */
    private RandomAccessFile f1723a = null;
    /* renamed from: b */
    private int f1724b = 0;
    /* renamed from: c */
    private C0509a f1725c = null;
    /* renamed from: d */
    private int f1726d = 4096;
    /* renamed from: e */
    private byte[] f1727e = null;
    /* renamed from: f */
    private byte[] f1728f = null;
    /* renamed from: g */
    private String f1729g = null;

    /* renamed from: a */
    public String m2213a(File file) {
        this.f1723a = new RandomAccessFile(file, "r");
        String a = m2211a();
        if (a.length() != 0) {
            this.f1723a.close();
            this.f1729g = a;
            return a;
        }
        this.f1724b = 0;
        a = m2212b();
        this.f1723a.close();
        this.f1729g = a;
        return a;
    }

    /* renamed from: a */
    private String m2211a() {
        byte[] bArr = new byte[2];
        int read = this.f1723a.read(bArr, 0, 2);
        if (read == 0) {
            this.f1724b = 0;
            return "GBK";
        } else if (read != 2) {
            return "";
        } else {
            if (bArr[0] == (byte) -1 && bArr[1] == (byte) -2) {
                this.f1724b = 2;
                return "UTF-16LE";
            } else if (bArr[0] == (byte) -2 && bArr[1] == (byte) -1) {
                this.f1724b = 2;
                return "UTF-16BE";
            } else if (bArr[0] != (byte) -17 || bArr[1] != (byte) -69) {
                return "";
            } else {
                bArr = new byte[1];
                if (this.f1723a.read(bArr, 0, 1) != 1) {
                    return "";
                }
                if (bArr[0] != (byte) -65) {
                    return "";
                }
                this.f1724b = 3;
                return HTTP.UTF_8;
            }
        }
    }

    /* renamed from: b */
    private String m2212b() {
        if (this.f1725c == null) {
            this.f1725c = new C0509a();
        }
        if (this.f1727e == null) {
            this.f1727e = new byte[this.f1726d];
        }
        try {
            int read = this.f1723a.read(this.f1727e);
            if (read <= 0) {
                return "GBK";
            }
            if (read < this.f1727e.length) {
                this.f1728f = new byte[read];
                System.arraycopy(this.f1727e, 0, this.f1728f, 0, read);
            } else {
                this.f1728f = this.f1727e;
            }
            return this.f1725c.m2187a(this.f1725c.m2188a(this.f1728f));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
