package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.document.sbk.C0819n;
import com.duokan.reader.domain.document.sbk.C0969f;
import com.duokan.reader.domain.document.sbk.C0977p;
import com.duokan.reader.domain.document.sbk.C0978s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

class kq implements C0819n {
    /* renamed from: a */
    static final /* synthetic */ boolean f3474a = (!kh.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ kh f3475b;

    kq(kh khVar) {
        this.f3475b = khVar;
    }

    /* renamed from: a */
    public void mo1119a(C0969f c0969f, String str, C0977p c0977p, long[][] jArr) {
        if (f3474a || jArr != null) {
            File d = this.f3475b.m4219d();
            am aV = this.f3475b.aV();
            C0285n i = aV.mo1106i();
            try {
                aV.mo1090a();
                i.m677b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("book_id", Long.valueOf(this.f3475b.aH()));
                contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
                contentValues.put("layout_params", c0977p.toString());
                contentValues.put("file_size", Long.valueOf(d.length()));
                contentValues.put("modified_date", Long.valueOf(d.lastModified()));
                contentValues.put("content_digest", str);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(jArr);
                contentValues.put("pagination_result", byteArrayOutputStream.toByteArray());
                i.m668a("typesetting", null, contentValues);
                i.m681f();
                i.m678c();
            } catch (Exception e) {
                e.printStackTrace();
                i.m678c();
            } catch (Throwable th) {
                aV.mo1096b();
            }
            aV.mo1096b();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public long[][] mo1120a(C0969f c0969f, String str, C0977p c0977p) {
        long[][] jArr;
        File d = this.f3475b.m4219d();
        am aV = this.f3475b.aV();
        C0285n i = aV.mo1106i();
        Cursor cursor;
        try {
            aV.mo1090a();
            cursor = null;
            try {
                cursor = i.m670a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.f3475b.aH()}), null);
                cursor.moveToPosition(cursor.getCount());
                Object obj = null;
                while (cursor.moveToPrevious()) {
                    long j = cursor.getLong(cursor.getColumnIndex("file_size"));
                    long j2 = cursor.getLong(cursor.getColumnIndex("modified_date"));
                    String string = cursor.getString(cursor.getColumnIndex("kernel_version"));
                    CharSequence string2 = cursor.isNull(cursor.getColumnIndex("content_digest")) ? "" : cursor.getString(cursor.getColumnIndex("content_digest"));
                    if ((!d.isDirectory() && (j != d.length() || j2 != d.lastModified())) || !string.equals(ReaderEnv.get().getKernelVersion())) {
                        obj = 1;
                        break;
                    } else if (!TextUtils.equals(string2, str)) {
                        obj = 1;
                        break;
                    } else {
                        C0977p a = C0977p.m7264a(cursor.getString(cursor.getColumnIndex("layout_params")));
                        if (a != null && c0977p.equals(a)) {
                            jArr = (long[][]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("pagination_result")))).readObject();
                            if (cursor != null) {
                                cursor.close();
                            }
                            aV.mo1096b();
                            return jArr;
                        }
                    }
                }
                if (obj != null) {
                    i.m677b();
                    try {
                        i.m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.f3475b.aH()}));
                        i.m681f();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        jArr = (long[][]) null;
                        aV.mo1096b();
                        return jArr;
                    } finally {
                        i.m678c();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
            jArr = (long[][]) null;
            aV.mo1096b();
        } catch (Exception e22) {
            e22.printStackTrace();
            jArr = (long[][]) null;
            if (cursor != null) {
                cursor.close();
            }
            aV.mo1096b();
        } catch (Throwable th2) {
            aV.mo1096b();
        }
        return jArr;
    }

    /* renamed from: a */
    public C0978s mo1118a(C0969f c0969f, C0978s c0978s) {
        try {
            this.f3475b.bk();
        } catch (Throwable th) {
        }
        if (this.f3475b.m4242o() == BookType.SERIAL) {
            try {
                String[] bj = this.f3475b.bj();
                if (c0978s == null && bj.length > 0 && !this.f3475b.mo1041v(bj[0])) {
                    Semaphore semaphore = new Semaphore(0);
                    this.f3475b.mo1028a(Arrays.asList(new String[]{bj[0]}), new kr(this, semaphore));
                    semaphore.acquire();
                    List w = this.f3475b.mo1042w(bj[0]);
                    this.f3475b.mo1029a(w.subList(0, Math.min(3, w.size())), true, new ks(this, semaphore));
                    semaphore.acquire();
                }
            } catch (Throwable th2) {
            }
        }
        return this.f3475b.bq();
    }
}
