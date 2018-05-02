package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;

import com.duokan.core.a.n;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.document.txt.TxtContentEntryData;
import com.duokan.reader.domain.document.txt.ad;
import com.duokan.reader.domain.document.txt.p;
import com.duokan.reader.domain.document.txt.y;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class lc implements y {
    static final /* synthetic */ boolean a = (!lb.class.desiredAssertionStatus());
    final /* synthetic */ am b;
    final /* synthetic */ n c;
    final /* synthetic */ File d;
    final /* synthetic */ lb e;

    lc(lb lbVar, am amVar, n nVar, File file) {
        this.e = lbVar;
        this.b = amVar;
        this.c = nVar;
        this.d = file;
    }

    public void a(p pVar, ad adVar, int[][] iArr) {
        if (a || iArr != null) {
            try {
                this.b.a();
                this.c.b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("book_id", Long.valueOf(this.e.aF()));
                contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
                contentValues.put("layout_params", adVar.toString());
                contentValues.put("file_size", Long.valueOf(this.d.length()));
                contentValues.put("modified_date", Long.valueOf(this.d.lastModified()));
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(iArr);
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

    public int[][] a(p pVar, ad adVar) {
        int[][] iArr;
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
                    ad a = ad.a(cursor.getString(cursor.getColumnIndex("layout_params")));
                    if (a != null && adVar.equals(a)) {
                        try {
                            iArr = (int[][]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("pagination_result")))).readObject();
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.b.b();
                        } catch (Exception e) {
                            e.printStackTrace();
                            iArr = (int[][]) null;
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.b.b();
                        }
                        return iArr;
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
                        iArr = (int[][]) null;
                        this.b.b();
                        return iArr;
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
        iArr = (int[][]) null;
        this.b.b();
        return iArr;
    }

    public void a(p pVar, TxtContentEntryData[] txtContentEntryDataArr) {
        try {
            this.b.a();
            this.c.b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("book_id", Long.valueOf(this.e.aF()));
            contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
            contentValues.put("file_size", Long.valueOf(this.d.length()));
            contentValues.put("modified_date", Long.valueOf(this.d.lastModified()));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(txtContentEntryDataArr);
            contentValues.put("toc_data", byteArrayOutputStream.toByteArray());
            this.c.a("toc", null, contentValues);
            this.c.f();
            this.c.c();
        } catch (Exception e) {
            e.printStackTrace();
            this.c.c();
        } catch (Throwable th) {
            this.b.b();
        }
        this.b.b();
    }

    public TxtContentEntryData[] a(p pVar) {
        Cursor a;
        Exception e;
        Throwable th;
        try {
            this.b.a();
            try {
                a = this.c.a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"toc", "book_id", "" + this.e.aF()}), null);
                try {
                    if (a.moveToNext()) {
                        long j = a.getLong(a.getColumnIndex("file_size"));
                        long j2 = a.getLong(a.getColumnIndex("modified_date"));
                        if (j == this.d.length() && j2 == this.d.lastModified()) {
                            TxtContentEntryData[] txtContentEntryDataArr = (TxtContentEntryData[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(a.getColumnIndex("toc_data")))).readObject();
                            if (a != null) {
                                a.close();
                            }
                            this.b.b();
                            return txtContentEntryDataArr;
                        }
                        this.c.b();
                        try {
                            this.c.a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"toc", "book_id", "" + this.e.aF()}));
                            this.c.f();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (a != null) {
                                a.close();
                            }
                            this.b.b();
                            return null;
                        } finally {
                            this.c.c();
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                } catch (Exception e3) {
                    e2 = e3;
                }
            } catch (Exception e4) {
                e2 = e4;
                a = null;
                try {
                    e2.printStackTrace();
                    if (a != null) {
                        a.close();
                    }
                    this.b.b();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            this.b.b();
            return null;
        } catch (Exception e22) {
            e22.printStackTrace();
            if (a != null) {
                a.close();
            }
            this.b.b();
            return null;
        } catch (Throwable th4) {
            this.b.b();
        }
    }
}
