package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.document.p045a.C0817m;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.document.p045a.C0918q;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class kc implements C0817m {
    /* renamed from: a */
    static final /* synthetic */ boolean f3438a = (!kb.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ am f3439b;
    /* renamed from: c */
    final /* synthetic */ C0285n f3440c;
    /* renamed from: d */
    final /* synthetic */ File f3441d;
    /* renamed from: e */
    final /* synthetic */ kb f3442e;

    kc(kb kbVar, am amVar, C0285n c0285n, File file) {
        this.f3442e = kbVar;
        this.f3439b = amVar;
        this.f3440c = c0285n;
        this.f3441d = file;
    }

    /* renamed from: a */
    public void mo1116a(C0904d c0904d, C0918q c0918q, long[][] jArr) {
        if (f3438a || jArr != null) {
            try {
                this.f3439b.mo1090a();
                this.f3440c.m677b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("book_id", Long.valueOf(this.f3442e.aH()));
                contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
                contentValues.put("layout_params", c0918q.toString());
                contentValues.put("file_size", Long.valueOf(this.f3441d.length()));
                contentValues.put("modified_date", Long.valueOf(this.f3441d.lastModified()));
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(jArr);
                contentValues.put("pagination_result", byteArrayOutputStream.toByteArray());
                this.f3440c.m668a("typesetting", null, contentValues);
                this.f3440c.m681f();
                this.f3440c.m678c();
            } catch (Exception e) {
                e.printStackTrace();
                this.f3440c.m678c();
            } catch (Throwable th) {
                this.f3439b.mo1096b();
            }
            this.f3439b.mo1096b();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public long[][] mo1117a(C0904d c0904d, C0918q c0918q) {
        long[][] jArr;
        Cursor cursor = null;
        try {
            this.f3439b.mo1090a();
            cursor = this.f3440c.m670a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.f3442e.aH()}), null);
            cursor.moveToPosition(cursor.getCount());
            while (cursor.moveToPrevious()) {
                long j = cursor.getLong(cursor.getColumnIndex("file_size"));
                long j2 = cursor.getLong(cursor.getColumnIndex("modified_date"));
                String string = cursor.getString(cursor.getColumnIndex("kernel_version"));
                if (j == this.f3441d.length() && j2 == this.f3441d.lastModified() && string.equals(ReaderEnv.get().getKernelVersion())) {
                    C0918q a = C0918q.m6087a(cursor.getString(cursor.getColumnIndex("layout_params")));
                    if (a != null && c0918q.equals(a)) {
                        try {
                            jArr = (long[][]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("pagination_result")))).readObject();
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.f3439b.mo1096b();
                        } catch (Exception e) {
                            e.printStackTrace();
                            jArr = (long[][]) null;
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.f3439b.mo1096b();
                        }
                        return jArr;
                    }
                } else {
                    this.f3440c.m677b();
                    try {
                        this.f3440c.m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.f3442e.aH()}));
                        this.f3440c.m681f();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        jArr = (long[][]) null;
                        this.f3439b.mo1096b();
                        return jArr;
                    } finally {
                        this.f3440c.m678c();
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e22) {
            e22.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            this.f3439b.mo1096b();
        }
        jArr = (long[][]) null;
        this.f3439b.mo1096b();
        return jArr;
    }
}
