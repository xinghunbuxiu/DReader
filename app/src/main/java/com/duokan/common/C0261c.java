package com.duokan.common;

import com.duokan.reader.p031a.p032a.p033a.C0510b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.duokan.common.c */
public class C0261c {
    /* renamed from: a */
    private RandomAccessFile f438a = null;
    /* renamed from: b */
    private String f439b = null;

    /* renamed from: a */
    boolean m590a(String str) {
        try {
            this.f438a = new RandomAccessFile(str, "r");
            this.f439b = new C0510b().m2213a(new File(str));
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    static int m571a(byte b) {
        return b & 255;
    }

    /* renamed from: a */
    static int m572a(byte b, byte b2) {
        return (C0261c.m571a(b) << 8) | C0261c.m571a(b2);
    }

    /* renamed from: a */
    static int m573a(byte b, byte b2, byte b3, byte b4) {
        return ((C0261c.m571a(b) << 24) | ((C0261c.m571a(b2) << 16) | (C0261c.m571a(b3) << 8))) | C0261c.m571a(b4);
    }

    /* renamed from: a */
    static int m574a(byte[] bArr, int i) {
        return C0261c.m573a(bArr[i], bArr[i + 1], bArr[i + 2], bArr[i + 3]);
    }

    /* renamed from: a */
    long m587a() {
        try {
            return this.f438a.getFilePointer();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    int m586a(byte[] bArr) {
        try {
            return this.f438a.read(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: b */
    void m593b() {
        try {
            this.f438a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    void m589a(long j) {
        try {
            this.f438a.seek(j);
            if (j != this.f438a.getFilePointer()) {
                System.out.print("failed");
                System.out.print(j);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public String m592b(String str) {
        if (!m590a(str)) {
            return null;
        }
        try {
            if (this.f438a.length() == 0) {
                return null;
            }
            byte[] bArr = new byte[12];
            if (-1 == m586a(bArr)) {
                m593b();
                return null;
            }
            C0264f c0264f = new C0264f();
            c0264f.f449b = C0261c.m572a(bArr[0], bArr[1]);
            c0264f.f450c = C0261c.m572a(bArr[2], bArr[3]);
            c0264f.f448a = C0261c.m572a(bArr[4], bArr[5]);
            String a = C0267i.m601a(str);
            Object obj = null;
            if (a != null && a.equalsIgnoreCase("ttf")) {
                obj = 1;
            }
            if (obj == null || (c0264f.f449b == 1 && c0264f.f450c == 0)) {
                C0265g c0265g = new C0265g();
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < c0264f.f448a; i++) {
                    m586a(bArr2);
                    if (m576b(bArr2, 4).compareToIgnoreCase("name") == 0) {
                        obj = 1;
                        c0265g.f451a = C0261c.m574a(bArr2, 8);
                        c0265g.f452b = C0261c.m574a(bArr2, 12);
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    m593b();
                    return null;
                }
                m589a((long) c0265g.f451a);
                C0263e c0263e = new C0263e();
                bArr = new byte[6];
                if (6 != m586a(bArr)) {
                    m593b();
                    return null;
                }
                c0263e.f446a = C0261c.m572a(bArr[2], bArr[3]);
                c0263e.f447b = C0261c.m572a(bArr[4], bArr[5]);
                C0262d c0262d = new C0262d();
                bArr2 = new byte[12];
                String str2 = null;
                for (int i2 = 0; i2 < c0263e.f446a; i2++) {
                    if (bArr2.length != m586a(bArr2)) {
                        m593b();
                        return null;
                    }
                    c0262d.f440a = C0261c.m572a(bArr2[0], bArr2[1]);
                    c0262d.f441b = C0261c.m572a(bArr2[2], bArr2[3]);
                    c0262d.f442c = C0261c.m572a(bArr2[4], bArr2[5]);
                    c0262d.f443d = C0261c.m572a(bArr2[6], bArr2[7]);
                    if ((m575a(c0262d) || m577b(c0262d) || m579c(c0262d) || m581d(c0262d)) && c0262d.f443d == 1) {
                        c0262d.f444e = C0261c.m572a(bArr2[8], bArr2[9]);
                        c0262d.f445f = C0261c.m572a(bArr2[10], bArr2[11]);
                        long a2 = m587a();
                        m589a((long) ((c0265g.f451a + c0262d.f445f) + c0263e.f447b));
                        byte[] bArr3 = new byte[c0262d.f444e];
                        if (m586a(bArr3) > 0) {
                            str2 = m588a(c0262d, bArr3);
                            if (c0262d.f442c == 2052) {
                                break;
                            }
                        }
                        m589a(a2);
                    }
                }
                m593b();
                return str2;
            }
            m593b();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private String m576b(byte[] bArr, int i) {
        try {
            return new String(bArr, 0, i, m594c());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    String m594c() {
        return this.f439b;
    }

    /* renamed from: a */
    String m588a(C0262d c0262d, byte[] bArr) {
        String b;
        if (c0262d.f440a == 3) {
            b = m591b(c0262d, bArr);
        } else if (c0262d.f440a == 1) {
            b = m595c(c0262d, bArr);
        } else {
            b = m594c();
        }
        try {
            return new String(bArr, b);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    String m591b(C0262d c0262d, byte[] bArr) {
        if (c0262d.f440a != 3) {
            return null;
        }
        if (c0262d.f442c == 2052 || c0262d.f442c == 1041) {
            return m580d();
        }
        return m578b(bArr) ? m580d() : m594c();
    }

    /* renamed from: c */
    String m595c(C0262d c0262d, byte[] bArr) {
        if (c0262d.f440a != 1) {
            return null;
        }
        if (c0262d.f442c == 33) {
            return m583f();
        }
        if (c0262d.f442c == 19) {
            return m584g();
        }
        if (c0262d.f442c == 11) {
            return m585h();
        }
        return m578b(bArr) ? m582e() : m594c();
    }

    /* renamed from: b */
    private boolean m578b(byte[] bArr) {
        try {
            Charset.forName("UTF-16BE").newDecoder().decode(ByteBuffer.wrap(bArr));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: d */
    private String m580d() {
        return "UTF-16BE";
    }

    /* renamed from: e */
    private String m582e() {
        return "ucs-2";
    }

    /* renamed from: f */
    private String m583f() {
        return "GBK";
    }

    /* renamed from: g */
    private String m584g() {
        return "Big5";
    }

    /* renamed from: h */
    private String m585h() {
        return "iso-2022-jp";
    }

    /* renamed from: a */
    private boolean m575a(C0262d c0262d) {
        if (c0262d.f440a == 3 && c0262d.f442c == 2052) {
            return true;
        }
        if (c0262d.f440a == 1 && c0262d.f442c == 33) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private boolean m577b(C0262d c0262d) {
        if (c0262d.f440a == 3 && c0262d.f442c == 1028) {
            return true;
        }
        if (c0262d.f440a == 1 && c0262d.f442c == 19) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m579c(C0262d c0262d) {
        if ((c0262d.f442c == 1033 && c0262d.f440a == 3) || c0262d.f442c == 0 || c0262d.f440a == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private boolean m581d(C0262d c0262d) {
        if ((c0262d.f442c == 1041 && c0262d.f440a == 3) || c0262d.f442c == 11 || c0262d.f440a == 1) {
            return true;
        }
        return false;
    }
}
