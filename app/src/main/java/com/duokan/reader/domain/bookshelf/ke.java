package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.document.sbk.f;
import com.duokan.reader.domain.document.sbk.n;
import com.duokan.reader.domain.document.sbk.p;
import com.duokan.reader.domain.document.sbk.s;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

class ke implements n {
    static final /* synthetic */ boolean a = (!jv.class.desiredAssertionStatus());
    final /* synthetic */ jv b;

    ke(jv jvVar) {
        this.b = jvVar;
    }

    public void a(f fVar, String str, p pVar, long[][] jArr) {
        if (a || jArr != null) {
            File d = this.b.d();
            am aT = this.b.aT();
            com.duokan.core.a.n i = aT.i();
            try {
                aT.a();
                i.b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("book_id", Long.valueOf(this.b.aF()));
                contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
                contentValues.put("layout_params", pVar.toString());
                contentValues.put("file_size", Long.valueOf(d.length()));
                contentValues.put("modified_date", Long.valueOf(d.lastModified()));
                contentValues.put("content_digest", str);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(jArr);
                contentValues.put("pagination_result", byteArrayOutputStream.toByteArray());
                i.a("typesetting", null, contentValues);
                i.f();
                i.c();
            } catch (Exception e) {
                e.printStackTrace();
                i.c();
            } catch (Throwable th) {
                aT.b();
            }
            aT.b();
            return;
        }
        throw new AssertionError();
    }

    public long[][] a(f fVar, String str, p pVar) {
        long[][] jArr;
        File d = this.b.d();
        am aT = this.b.aT();
        com.duokan.core.a.n i = aT.i();
        Cursor cursor;
        try {
            aT.a();
            cursor = null;
            try {
                cursor = i.a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.b.aF()}), null);
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
                        p a = p.a(cursor.getString(cursor.getColumnIndex("layout_params")));
                        if (a != null && pVar.equals(a)) {
                            jArr = (long[][]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("pagination_result")))).readObject();
                            if (cursor != null) {
                                cursor.close();
                            }
                            aT.b();
                            return jArr;
                        }
                    }
                }
                if (obj != null) {
                    i.b();
                    try {
                        i.a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.b.aF()}));
                        i.f();
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        jArr = (long[][]) null;
                        aT.b();
                        return jArr;
                    } finally {
                        i.c();
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
            aT.b();
        } catch (Exception e22) {
            e22.printStackTrace();
            jArr = (long[][]) null;
            if (cursor != null) {
                cursor.close();
            }
            aT.b();
        } catch (Throwable th2) {
            aT.b();
        }
        return jArr;
    }

    public s a(f fVar, s sVar) {
        try {
            this.b.bi();
        } catch (Throwable th) {
        }
        if (this.b.o() == BookType.SERIAL) {
            try {
                String[] bh = this.b.bh();
                if (sVar == null && bh.length > 0 && !this.b.u(bh[0])) {
                    Semaphore semaphore = new Semaphore(0);
                    this.b.a(Arrays.asList(new String[]{bh[0]}), new kf(this, semaphore));
                    semaphore.acquire();
                    List v = this.b.v(bh[0]);
                    this.b.a(v.subList(0, Math.min(3, v.size())), true, new kg(this, semaphore));
                    semaphore.acquire();
                }
            } catch (Throwable th2) {
            }
        }
        return this.b.bo();
    }
}
