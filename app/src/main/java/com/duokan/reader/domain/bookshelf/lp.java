package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.document.txt.C0826y;
import com.duokan.reader.domain.document.txt.C1000p;
import com.duokan.reader.domain.document.txt.TxtContentEntryData;
import com.duokan.reader.domain.document.txt.ad;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class lp implements C0826y {
    /* renamed from: a */
    static final /* synthetic */ boolean f3560a = (!lo.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ am f3561b;
    /* renamed from: c */
    final /* synthetic */ C0285n f3562c;
    /* renamed from: d */
    final /* synthetic */ File f3563d;
    /* renamed from: e */
    final /* synthetic */ lo f3564e;

    lp(lo loVar, am amVar, C0285n c0285n, File file) {
        this.f3564e = loVar;
        this.f3561b = amVar;
        this.f3562c = c0285n;
        this.f3563d = file;
    }

    /* renamed from: a */
    public void mo1133a(C1000p c1000p, ad adVar, int[][] iArr) {
        if (f3560a || iArr != null) {
            try {
                this.f3561b.mo1090a();
                this.f3562c.m677b();
                ContentValues contentValues = new ContentValues();
                contentValues.put("book_id", Long.valueOf(this.f3564e.aH()));
                contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
                contentValues.put("layout_params", adVar.toString());
                contentValues.put("file_size", Long.valueOf(this.f3563d.length()));
                contentValues.put("modified_date", Long.valueOf(this.f3563d.lastModified()));
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ObjectOutputStream(byteArrayOutputStream).writeObject(iArr);
                contentValues.put("pagination_result", byteArrayOutputStream.toByteArray());
                this.f3562c.m668a("typesetting", null, contentValues);
                this.f3562c.m681f();
                this.f3562c.m678c();
            } catch (Exception e) {
                e.printStackTrace();
                this.f3562c.m678c();
            } catch (Throwable th) {
                this.f3561b.mo1096b();
            }
            this.f3561b.mo1096b();
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public int[][] mo1136a(C1000p c1000p, ad adVar) {
        int[][] iArr;
        Cursor cursor = null;
        try {
            this.f3561b.mo1090a();
            cursor = this.f3562c.m670a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.f3564e.aH()}), null);
            cursor.moveToPosition(cursor.getCount());
            while (cursor.moveToPrevious()) {
                long j = cursor.getLong(cursor.getColumnIndex("file_size"));
                long j2 = cursor.getLong(cursor.getColumnIndex("modified_date"));
                String string = cursor.getString(cursor.getColumnIndex("kernel_version"));
                if (j == this.f3563d.length() && j2 == this.f3563d.lastModified() && string.equals(ReaderEnv.get().getKernelVersion())) {
                    ad a = ad.m7383a(cursor.getString(cursor.getColumnIndex("layout_params")));
                    if (a != null && adVar.equals(a)) {
                        try {
                            iArr = (int[][]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("pagination_result")))).readObject();
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.f3561b.mo1096b();
                        } catch (Exception e) {
                            e.printStackTrace();
                            iArr = (int[][]) null;
                            if (cursor != null) {
                                cursor.close();
                            }
                            this.f3561b.mo1096b();
                        }
                        return iArr;
                    }
                } else {
                    this.f3562c.m677b();
                    try {
                        this.f3562c.m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"typesetting", "book_id", "" + this.f3564e.aH()}));
                        this.f3562c.m681f();
                        break;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        iArr = (int[][]) null;
                        this.f3561b.mo1096b();
                        return iArr;
                    } finally {
                        this.f3562c.m678c();
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
            this.f3561b.mo1096b();
        }
        iArr = (int[][]) null;
        this.f3561b.mo1096b();
        return iArr;
    }

    /* renamed from: a */
    public void mo1134a(C1000p c1000p, TxtContentEntryData[] txtContentEntryDataArr) {
        try {
            this.f3561b.mo1090a();
            this.f3562c.m677b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("book_id", Long.valueOf(this.f3564e.aH()));
            contentValues.put("kernel_version", ReaderEnv.get().getKernelVersion());
            contentValues.put("file_size", Long.valueOf(this.f3563d.length()));
            contentValues.put("modified_date", Long.valueOf(this.f3563d.lastModified()));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(txtContentEntryDataArr);
            contentValues.put("toc_data", byteArrayOutputStream.toByteArray());
            this.f3562c.m668a("toc", null, contentValues);
            this.f3562c.m681f();
            this.f3562c.m678c();
        } catch (Exception e) {
            e.printStackTrace();
            this.f3562c.m678c();
        } catch (Throwable th) {
            this.f3561b.mo1096b();
        }
        this.f3561b.mo1096b();
    }

    /* renamed from: a */
    public TxtContentEntryData[] mo1135a(C1000p c1000p) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            this.f3561b.mo1090a();
            try {
                a = this.f3562c.m670a(String.format("SELECT * FROM %s WHERE %s = \"%s\"", new Object[]{"toc", "book_id", "" + this.f3564e.aH()}), null);
                try {
                    if (a.moveToNext()) {
                        long j = a.getLong(a.getColumnIndex("file_size"));
                        long j2 = a.getLong(a.getColumnIndex("modified_date"));
                        if (j == this.f3563d.length() && j2 == this.f3563d.lastModified()) {
                            TxtContentEntryData[] txtContentEntryDataArr = (TxtContentEntryData[]) new ObjectInputStream(new ByteArrayInputStream(a.getBlob(a.getColumnIndex("toc_data")))).readObject();
                            if (a != null) {
                                a.close();
                            }
                            this.f3561b.mo1096b();
                            return txtContentEntryDataArr;
                        }
                        this.f3562c.m677b();
                        try {
                            this.f3562c.m673a(String.format("DELETE FROM %s WHERE %s = \"%s\"", new Object[]{"toc", "book_id", "" + this.f3564e.aH()}));
                            this.f3562c.m681f();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            if (a != null) {
                                a.close();
                            }
                            this.f3561b.mo1096b();
                            return null;
                        } finally {
                            this.f3562c.m678c();
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
                    this.f3561b.mo1096b();
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
            this.f3561b.mo1096b();
            return null;
        } catch (Exception e22) {
            e22.printStackTrace();
            if (a != null) {
                a.close();
            }
            this.f3561b.mo1096b();
            return null;
        } catch (Throwable th4) {
            this.f3561b.mo1096b();
        }
    }
}
