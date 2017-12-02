package com.duokan.reader.a.a.a;

import org.apache.http.protocol.HTTP;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class b {
    private RandomAccessFile a = null;
    private int b = 0;
    private a c = null;
    private int d = 4096;
    private byte[] e = null;
    private byte[] f = null;
    private String g = null;

    public String a(File file) {
        this.a = new RandomAccessFile(file, "r");
        String a = a();
        if (a.length() != 0) {
            this.a.close();
            this.g = a;
            return a;
        }
        this.b = 0;
        a = b();
        this.a.close();
        this.g = a;
        return a;
    }

    private String a() {
        byte[] bArr = new byte[2];
        int read = this.a.read(bArr, 0, 2);
        if (read == 0) {
            this.b = 0;
            return "GBK";
        } else if (read != 2) {
            return "";
        } else {
            if (bArr[0] == (byte) -1 && bArr[1] == (byte) -2) {
                this.b = 2;
                return "UTF-16LE";
            } else if (bArr[0] == (byte) -2 && bArr[1] == (byte) -1) {
                this.b = 2;
                return "UTF-16BE";
            } else if (bArr[0] != (byte) -17 || bArr[1] != (byte) -69) {
                return "";
            } else {
                bArr = new byte[1];
                if (this.a.read(bArr, 0, 1) != 1) {
                    return "";
                }
                if (bArr[0] != (byte) -65) {
                    return "";
                }
                this.b = 3;
                return HTTP.UTF_8;
            }
        }
    }

    private String b() {
        if (this.c == null) {
            this.c = new a();
        }
        if (this.e == null) {
            this.e = new byte[this.d];
        }
        try {
            int read = this.a.read(this.e);
            if (read <= 0) {
                return "GBK";
            }
            if (read < this.e.length) {
                this.f = new byte[read];
                System.arraycopy(this.e, 0, this.f, 0, read);
            } else {
                this.f = this.e;
            }
            return this.c.a(this.c.a(this.f));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
