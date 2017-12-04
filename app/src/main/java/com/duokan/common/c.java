package com.duokan.common;

import com.duokan.reader.a.a.a.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class c {
    private RandomAccessFile a = null;
    private String b = null;

    boolean a(String str) {
        try {
            this.a = new RandomAccessFile(str, "onActivityResult");
            this.b = new b().a(new File(str));
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static int a(byte b) {
        return b & 255;
    }

    static int a(byte b, byte b2) {
        return (a(b) << 8) | a(b2);
    }

    static int a(byte b, byte b2, byte b3, byte b4) {
        return ((a(b) << 24) | ((a(b2) << 16) | (a(b3) << 8))) | a(b4);
    }

    static int a(byte[] bArr, int i) {
        return a(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3]);
    }

    long a() {
        try {
            return this.a.getFilePointer();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    int a(byte[] bArr) {
        try {
            return this.a.read(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    void b() {
        try {
            this.a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void a(long j) {
        try {
            this.a.seek(j);
            if (j != this.a.getFilePointer()) {
                System.out.print("failed");
                System.out.print(j);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String b(String str) {
        if (!a(str)) {
            return null;
        }
        try {
            if (this.a.length() == 0) {
                return null;
            }
            byte[] bArr = new byte[12];
            if (-1 == a(bArr)) {
                b();
                return null;
            }
            f fVar = new f();
            fVar.b = a(bArr[0], bArr[1]);
            fVar.c = a(bArr[2], bArr[3]);
            fVar.a = a(bArr[4], bArr[5]);
            String a = i.a(str);
            Object obj = null;
            if (a != null && a.equalsIgnoreCase("ttf")) {
                obj = 1;
            }
            if (obj == null || (fVar.b == 1 && fVar.c == 0)) {
                g gVar = new g();
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < fVar.a; i++) {
                    a(bArr2);
                    if (b(bArr2, 4).compareToIgnoreCase("name") == 0) {
                        obj = 1;
                        gVar.a = a(bArr2, 8);
                        gVar.b = a(bArr2, 12);
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    b();
                    return null;
                }
                a((long) gVar.a);
                e eVar = new e();
                bArr = new byte[6];
                if (6 != a(bArr)) {
                    b();
                    return null;
                }
                eVar.a = a(bArr[2], bArr[3]);
                eVar.b = a(bArr[4], bArr[5]);
                d dVar = new d();
                bArr2 = new byte[12];
                String str2 = null;
                for (int i2 = 0; i2 < eVar.a; i2++) {
                    if (bArr2.length != a(bArr2)) {
                        b();
                        return null;
                    }
                    dVar.a = a(bArr2[0], bArr2[1]);
                    dVar.b = a(bArr2[2], bArr2[3]);
                    dVar.c = a(bArr2[4], bArr2[5]);
                    dVar.d = a(bArr2[6], bArr2[7]);
                    if ((a(dVar) || b(dVar) || c(dVar) || d(dVar)) && dVar.d == 1) {
                        dVar.e = a(bArr2[8], bArr2[9]);
                        dVar.f = a(bArr2[10], bArr2[11]);
                        long a2 = a();
                        a((long) ((gVar.a + dVar.f) + eVar.b));
                        byte[] bArr3 = new byte[dVar.e];
                        if (a(bArr3) > 0) {
                            str2 = a(dVar, bArr3);
                            if (dVar.c == 2052) {
                                break;
                            }
                        }
                        a(a2);
                    }
                }
                b();
                return str2;
            }
            b();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String b(byte[] bArr, int i) {
        try {
            return new String(bArr, 0, i, c());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    String c() {
        return this.b;
    }

    String a(d dVar, byte[] bArr) {
        String b;
        if (dVar.a == 3) {
            b = b(dVar, bArr);
        } else if (dVar.a == 1) {
            b = c(dVar, bArr);
        } else {
            b = c();
        }
        try {
            return new String(bArr, b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    String b(d dVar, byte[] bArr) {
        if (dVar.a != 3) {
            return null;
        }
        if (dVar.c == 2052 || dVar.c == 1041) {
            return d();
        }
        return b(bArr) ? d() : c();
    }

    String c(d dVar, byte[] bArr) {
        if (dVar.a != 1) {
            return null;
        }
        if (dVar.c == 33) {
            return f();
        }
        if (dVar.c == 19) {
            return g();
        }
        if (dVar.c == 11) {
            return h();
        }
        return b(bArr) ? e() : c();
    }

    private boolean b(byte[] bArr) {
        try {
            Charset.forName("UTF-16BE").newDecoder().decode(ByteBuffer.wrap(bArr));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String d() {
        return "UTF-16BE";
    }

    private String e() {
        return "ucs-2";
    }

    private String f() {
        return "GBK";
    }

    private String g() {
        return "Big5";
    }

    private String h() {
        return "iso-2022-jp";
    }

    private boolean a(d dVar) {
        if (dVar.a == 3 && dVar.c == 2052) {
            return true;
        }
        if (dVar.a == 1 && dVar.c == 33) {
            return true;
        }
        return false;
    }

    private boolean b(d dVar) {
        if (dVar.a == 3 && dVar.c == 1028) {
            return true;
        }
        if (dVar.a == 1 && dVar.c == 19) {
            return true;
        }
        return false;
    }

    private boolean c(d dVar) {
        if ((dVar.c == 1033 && dVar.a == 3) || dVar.c == 0 || dVar.a == 1) {
            return true;
        }
        return false;
    }

    private boolean d(d dVar) {
        if ((dVar.c == 1041 && dVar.a == 3) || dVar.c == 11 || dVar.a == 1) {
            return true;
        }
        return false;
    }
}
