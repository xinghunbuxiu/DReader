package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;

import com.duokan.core.a.n;
import com.duokan.reader.ReaderEnv;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class jq implements m {
    static final /* synthetic */ boolean a = (!jp.class.desiredAssertionStatus());
    final /* synthetic */ am b;
    final /* synthetic */ n c;
    final /* synthetic */ File d;
    final /* synthetic */ jp e;

    jq(jp jpVar, am amVar, n nVar, File file) {
        this.e = jpVar;
        this.b = amVar;
        this.c = nVar;
        this.d = file;
    }

    public void a(d dVar, q qVar, long[][] jArr) {
        if (a || jArr != null) {
            try {
                this.b.a();
                this.c.b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("book_id", Long.valueOf(this.e.aF()));
                contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
                contentValues.put("layout_params", qVar.toString());
                contentValues.put("file_size", Long.valueOf(this.d.length()));
                contentValues.put("modified_date", Long.valueOf(this.d.lastModified()));
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(jArr);
                contentValues.put("pagination_result", byteArrayOutputStream.toByteArray());
                this.c.a("typesetting", null, contentValues);
                this.c.f();
                this.c.c();
            } catch (Exception e) {
                e.printStackTrace();
                this.c.c();
            } catch (Throwable th) {
                this.b.b();
            }
            this.b.b();
            return;
        }
        throw new AssertionError();
    }

    public long[][] a(d dVar, q qVar) {
        long[][] jArr;
        Cursor cursor = null;
        try {
            this.b.a();
            cursor = this.c.a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.e.aF()}), null);
            cursor.moveToPosition(cursor.getCount());
            while (cursor.moveToPrevious()) {
                long j = cursor.getLong(cursor.getColumnIndex("file_size"));
                long j2 = cursor.getLong(cursor.getColumnIndex("modified_date"));
                String string = cursor.getString(cursor.getColumnIndex("kernel_version"));
                if (j == this.d.length() && j2 == this.d.lastModified() && string.equals(ReaderEnv.get().getKernelVersion())) {
                    q a = q.a(cursor.getString(cursor.getColumnIndex("layout_params")));
                    if (a != null && qVar.equals(a)) {
                        try {
                            jArr = (long[][]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("pagination_result")))).readObject();
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.b.b();
                        } catch (Exception e) {
                            e.printStackTrace();
                            jArr = (long[][]) null;
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.b.b();
                        }
                        return jArr;
                    }
                } else {
                    this.c.b();
                    try {
                        this.c.a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.e.aF()}));
                        this.c.f();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        jArr = (long[][]) null;
                        this.b.b();
                        return jArr;
                    } finally {
                        this.c.c();
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
            this.b.b();
        }
        jArr = (long[][]) null;
        this.b.b();
        return jArr;
    }
}
