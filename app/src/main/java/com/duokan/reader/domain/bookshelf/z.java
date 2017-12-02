package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.duokan.core.a.n;
import com.duokan.reader.domain.cloud.DkCloudAnnotation;

import java.util.Iterator;
import java.util.LinkedList;

class z {
    private final long a;
    private boolean b = false;
    private final BookFormat c;
    private final am d;
    private LinkedList e = new LinkedList();

    public z(am amVar, long j, BookFormat bookFormat) {
        this.a = j;
        this.c = bookFormat;
        this.d = amVar;
    }

    public a[] a() {
        try {
            this.d.a(this.a);
            c();
            a[] aVarArr = (a[]) this.e.toArray(new a[0]);
            return aVarArr;
        } finally {
            this.d.b(this.a);
        }
    }

    public final void a(a aVar) {
        try {
            this.d.a(this.a);
            c();
            this.e.add(d(aVar));
        } finally {
            this.d.b(this.a);
        }
    }

    public final void b(a aVar) {
        try {
            this.d.a(this.a);
            c();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                if (aVar.b() == ((a) it.next()).b()) {
                    this.e.remove(aVar);
                    f(aVar);
                    break;
                }
            }
            this.d.b(this.a);
        } catch (Throwable th) {
            this.d.b(this.a);
        }
    }

    public final void c(a aVar) {
        try {
            this.d.a(this.a);
            c();
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar != aVar2) {
                    if (aVar.b() == aVar2.b()) {
                        this.e.remove(aVar2);
                        this.e.add(aVar);
                        e(aVar);
                        break;
                    }
                }
                e(aVar);
                break;
            }
            this.d.b(this.a);
        } catch (Throwable th) {
            this.d.b(this.a);
        }
    }

    public void b() {
        try {
            this.d.a(this.a);
            this.b = false;
            a();
        } finally {
            this.d.b(this.a);
        }
    }

    public final void a(DkCloudAnnotation[] dkCloudAnnotationArr) {
        n h;
        int i = 0;
        try {
            this.d.a(this.a);
            c();
            h = this.d.h();
            h.b();
            int length = dkCloudAnnotationArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                h.a("DELETE FROM annotations WHERE annotation_uuid = ?", new String[]{dkCloudAnnotationArr[i2].getCloudId()});
            }
            h.f();
            h.c();
        } catch (Exception e) {
            e.printStackTrace();
            h.c();
        } catch (Throwable th) {
            this.d.b(this.a);
        }
        int length2 = dkCloudAnnotationArr.length;
        while (i < length2) {
            DkCloudAnnotation dkCloudAnnotation = dkCloudAnnotationArr[i];
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (dkCloudAnnotation.getCloudId().equals(aVar.i())) {
                    this.e.remove(aVar);
                    break;
                }
            }
            i++;
        }
        this.d.b(this.a);
    }

    private void c() {
        if (!this.b) {
            this.e = d();
            this.b = true;
        }
    }

    private a d(a aVar) {
        n h = this.d.h();
        h.b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("book_id", Long.valueOf(aVar.c()));
            contentValues.put("added_date", Long.valueOf(aVar.g()));
            contentValues.put("annotation_type", aVar.a().toString());
            contentValues.put("annotation_range", aVar.k());
            if (aVar instanceof ef) {
                contentValues.put("annotation_body", ((ef) aVar).j());
            }
            contentValues.put("annotation_sample", aVar.f());
            contentValues.put("modified_date", Long.valueOf(aVar.h()));
            contentValues.put("annotation_uuid", aVar.i());
            aVar.a(h.a("annotations", null, contentValues));
            h.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.c();
        }
        return aVar;
    }

    private void e(a aVar) {
        n h = this.d.h();
        h.b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("book_id", Long.valueOf(aVar.c()));
            contentValues.put("added_date", Long.valueOf(aVar.g()));
            contentValues.put("annotation_type", aVar.a().toString());
            contentValues.put("annotation_range", aVar.k());
            if (aVar instanceof ef) {
                contentValues.put("annotation_body", aVar.j());
            }
            contentValues.put("annotation_sample", aVar.f());
            contentValues.put("annotation_uuid", aVar.i());
            contentValues.put("modified_date", Long.valueOf(System.currentTimeMillis()));
            h.a("annotations", contentValues, " _id = " + aVar.b(), null);
            h.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.c();
        }
    }

    private void f(a aVar) {
        n h = this.d.h();
        h.b();
        try {
            h.a("DELETE FROM annotations WHERE _id = ?", new String[]{Long.toString(aVar.b())});
            h.f();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.c();
        }
    }

    private LinkedList d() {
        Exception e;
        Throwable th;
        LinkedList linkedList = new LinkedList();
        n h = this.d.h();
        Cursor cursor = null;
        if (h != null) {
            Cursor a;
            try {
                a = h.a("SELECT * FROM annotations WHERE book_id = ? ORDER BY added_date DESC", new String[]{Long.toString(this.a)});
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
                            a a2 = a.a(annotationType, a.getString(7));
                            a2.a(a.getLong(0));
                            a2.b(a.getLong(1));
                            a2.c(a.getLong(2));
                            a2.a(this.c, a.getString(4));
                            if (a2 instanceof ef) {
                                ((ef) a2).f(a.getString(5));
                            }
                            a2.a(a.getString(6));
                            a2.d(a.getLong(8));
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
