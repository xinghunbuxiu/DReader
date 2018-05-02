package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.domain.bookshelf.z */
class C0839z {
    /* renamed from: a */
    private final long f3588a;
    /* renamed from: b */
    private boolean f3589b = false;
    /* renamed from: c */
    private final BookFormat f3590c;
    /* renamed from: d */
    private final am f3591d;
    /* renamed from: e */
    private LinkedList<C0798a> f3592e = new LinkedList();

    public C0839z(am amVar, long j, BookFormat bookFormat) {
        this.f3588a = j;
        this.f3590c = bookFormat;
        this.f3591d = amVar;
    }

    /* renamed from: a */
    public C0798a[] m4989a() {
        try {
            this.f3591d.mo1091a(this.f3588a);
            m4982c();
            C0798a[] c0798aArr = (C0798a[]) this.f3592e.toArray(new C0798a[0]);
            return c0798aArr;
        } finally {
            this.f3591d.mo1097b(this.f3588a);
        }
    }

    /* renamed from: a */
    public final void m4987a(C0798a c0798a) {
        try {
            this.f3591d.mo1091a(this.f3588a);
            m4982c();
            this.f3592e.add(m4983d(c0798a));
        } finally {
            this.f3591d.mo1097b(this.f3588a);
        }
    }

    /* renamed from: b */
    public final void m4991b(C0798a c0798a) {
        try {
            this.f3591d.mo1091a(this.f3588a);
            m4982c();
            Iterator it = this.f3592e.iterator();
            while (it.hasNext()) {
                if (c0798a.m3720b() == ((C0798a) it.next()).m3720b()) {
                    this.f3592e.remove(c0798a);
                    m4986f(c0798a);
                    break;
                }
            }
            this.f3591d.mo1097b(this.f3588a);
        } catch (Throwable th) {
            this.f3591d.mo1097b(this.f3588a);
        }
    }

    /* renamed from: c */
    public final void m4992c(C0798a c0798a) {
        try {
            this.f3591d.mo1091a(this.f3588a);
            m4982c();
            Iterator it = this.f3592e.iterator();
            while (it.hasNext()) {
                C0798a c0798a2 = (C0798a) it.next();
                if (c0798a != c0798a2) {
                    if (c0798a.m3720b() == c0798a2.m3720b()) {
                        this.f3592e.remove(c0798a2);
                        this.f3592e.add(c0798a);
                        m4985e(c0798a);
                        break;
                    }
                }
                m4985e(c0798a);
                break;
            }
            this.f3591d.mo1097b(this.f3588a);
        } catch (Throwable th) {
            this.f3591d.mo1097b(this.f3588a);
        }
    }

    /* renamed from: b */
    public void m4990b() {
        try {
            this.f3591d.mo1091a(this.f3588a);
            this.f3589b = false;
            m4989a();
        } finally {
            this.f3591d.mo1097b(this.f3588a);
        }
    }

    /* renamed from: a */
    public final void m4988a(DkCloudAnnotation[] dkCloudAnnotationArr) {
        int i = 0;
        C0285n h;
        try {
            this.f3591d.mo1091a(this.f3588a);
            m4982c();
            h = this.f3591d.mo1105h();
            h.m677b();
            int length = dkCloudAnnotationArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                h.m674a("DELETE FROM annotations WHERE annotation_uuid = ?", new String[]{dkCloudAnnotationArr[i2].getCloudId()});
            }
            h.m681f();
            h.m678c();
        } catch (Exception e) {
            e.printStackTrace();
            h.m678c();
        } catch (Throwable th) {
            this.f3591d.mo1097b(this.f3588a);
        }
        int length2 = dkCloudAnnotationArr.length;
        while (i < length2) {
            DkCloudAnnotation dkCloudAnnotation = dkCloudAnnotationArr[i];
            Iterator it = this.f3592e.iterator();
            while (it.hasNext()) {
                C0798a c0798a = (C0798a) it.next();
                if (dkCloudAnnotation.getCloudId().equals(c0798a.m3732i())) {
                    this.f3592e.remove(c0798a);
                    break;
                }
            }
            i++;
        }
        this.f3591d.mo1097b(this.f3588a);
    }

    /* renamed from: c */
    private void m4982c() {
        if (!this.f3589b) {
            this.f3592e = m4984d();
            this.f3589b = true;
        }
    }

    /* renamed from: d */
    private C0798a m4983d(C0798a c0798a) {
        C0285n h = this.f3591d.mo1105h();
        h.m677b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("book_id", Long.valueOf(c0798a.m3724c()));
            contentValues.put("added_date", Long.valueOf(c0798a.m3730g()));
            contentValues.put("annotation_type", c0798a.mo956a().toString());
            contentValues.put("annotation_range", c0798a.m3734k());
            if (c0798a instanceof ea) {
                contentValues.put("annotation_body", ((ea) c0798a).mo1008j());
            }
            contentValues.put("annotation_sample", c0798a.m3729f());
            contentValues.put("modified_date", Long.valueOf(c0798a.m3731h()));
            contentValues.put("annotation_uuid", c0798a.m3732i());
            c0798a.m3716a(h.m668a("annotations", null, contentValues));
            h.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.m678c();
        }
        return c0798a;
    }

    /* renamed from: e */
    private void m4985e(C0798a c0798a) {
        C0285n h = this.f3591d.mo1105h();
        h.m677b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("book_id", Long.valueOf(c0798a.m3724c()));
            contentValues.put("added_date", Long.valueOf(c0798a.m3730g()));
            contentValues.put("annotation_type", c0798a.mo956a().toString());
            contentValues.put("annotation_range", c0798a.m3734k());
            if (c0798a instanceof ea) {
                contentValues.put("annotation_body", c0798a.mo1008j());
            }
            contentValues.put("annotation_sample", c0798a.m3729f());
            contentValues.put("annotation_uuid", c0798a.m3732i());
            contentValues.put("modified_date", Long.valueOf(System.currentTimeMillis()));
            h.m666a("annotations", contentValues, " _id = " + c0798a.m3720b(), null);
            h.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.m678c();
        }
    }

    /* renamed from: f */
    private void m4986f(C0798a c0798a) {
        C0285n h = this.f3591d.mo1105h();
        h.m677b();
        try {
            h.m674a("DELETE FROM annotations WHERE _id = ?", new String[]{Long.toString(c0798a.m3720b())});
            h.m681f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.m678c();
        }
    }

    /* renamed from: d */
    private LinkedList<C0798a> m4984d() {
        Exception e;
        Throwable th;
        LinkedList<C0798a> linkedList = new LinkedList();
        C0285n h = this.f3591d.mo1105h();
        Cursor cursor = null;
        if (h != null) {
            Cursor a;
            try {
                a = h.m670a("SELECT * FROM annotations WHERE book_id = ? ORDER BY added_date DESC", new String[]{Long.toString(this.f3588a)});
                try {
                    if (a.moveToFirst()) {
                        do {
                            AnnotationType annotationType;
                            String string = a.getString(3);
                            if (string.equals("MARK")) {
                                annotationType = AnnotationType.BOOKMARK;
                            } else if (string.equals("DIGEST") || string.equals("NOTE")) {
                                annotationType = AnnotationType.COMMENT;
                            } else {
                                annotationType = AnnotationType.valueOf(string);
                            }
                            C0798a a2 = C0798a.m3711a(annotationType, a.getString(7));
                            a2.m3716a(a.getLong(0));
                            a2.m3721b(a.getLong(1));
                            a2.m3725c(a.getLong(2));
                            a2.m3717a(this.f3590c, a.getString(4));
                            if (a2 instanceof ea) {
                                ((ea) a2).m4381f(a.getString(5));
                            }
                            a2.m3719a(a.getString(6));
                            a2.m3727d(a.getLong(8));
                            linkedList.add(a2);
                        } while (a.moveToNext());
                    }
                    if (!(a == null || a.isClosed())) {
                        a.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = a;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    return linkedList;
                } catch (Throwable th3) {
                    th = th3;
                    a = cursor;
                    if (!(a == null || a.isClosed())) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                a = null;
                a.close();
                throw th;
            }
        }
        Log.w("", "Can't connect db!");
        return linkedList;
    }
}
