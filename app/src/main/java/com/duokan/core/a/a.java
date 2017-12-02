package com.duokan.core.a;

import android.content.ContentValues;
import android.database.Cursor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class a {
    private static final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();
    private final n b;

    public a(String str) {
        this(str, "");
    }

    public a(String str, String str2) {
        this.b = new n(str, str2);
        a(new b(this));
    }

    public Serializable a(String str, Serializable serializable) {
        Serializable a = a(str);
        return a != null ? a : serializable;
    }

    public Serializable a(String str) {
        return a(b(this.b, str));
    }

    public void a() {
        b(new c(this));
    }

    public void b() {
        b(new d(this));
    }

    public Future c() {
        return b(new e(this));
    }

    public boolean d() {
        while (true) {
            try {
                return ((Boolean) c().get()).booleanValue();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                return false;
            }
        }
    }

    public Future b(String str, Serializable serializable) {
        return a(new f(this, str, a(serializable)));
    }

    public boolean c(String str, Serializable serializable) {
        while (true) {
            try {
                return ((Boolean) b(str, serializable).get()).booleanValue();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                return false;
            }
        }
    }

    public List e() {
        List linkedList = new LinkedList();
        a(this.b, linkedList);
        b(this.b, linkedList);
        c(this.b, linkedList);
        return linkedList;
    }

    public Future b(String str) {
        return a(new g(this, str));
    }

    private Future a(l lVar) {
        return b(new h(this, lVar));
    }

    private Future b(l lVar) {
        return a.submit(new i(this, lVar));
    }

    private static byte[] b(n nVar, String str) {
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        Cursor a;
        try {
            a = nVar.a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s == '%4$s'", new Object[]{"objects", "stream", "name", str}), new String[0]);
            try {
                if (a.moveToFirst()) {
                    bArr = a.getBlob(0);
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th3) {
                        }
                    }
                } else if (a != null) {
                    try {
                        a.close();
                    } catch (Throwable th4) {
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                try {
                    th.printStackTrace();
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th6) {
                        }
                    }
                    return bArr;
                } catch (Throwable th7) {
                    th2 = th7;
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Throwable th8) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th9) {
            a = null;
            th2 = th9;
            if (a != null) {
                a.close();
            }
            throw th2;
        }
        return bArr;
    }

    private static void b(n nVar, String str, byte[] bArr) {
        if (bArr == null) {
            RuntimeException runtimeException = new RuntimeException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("stream", bArr);
        nVar.a("objects", null, contentValues, 5);
    }

    private static void a(n nVar, List list) {
        Cursor cursor = null;
        try {
            cursor = nVar.a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s", new Object[]{"objects", "name"}), new String[0]);
            while (cursor.moveToNext()) {
                list.add(cursor.getString(0));
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    private static void c(n nVar, String str) {
        nVar.a(String.format(Locale.getDefault(), "DELETE FROM %1$s WHERE %2$s == '%3$s'", new Object[]{"objects", "name", str}));
        nVar.a("DROP TABLE IF EXISTS " + j.a(str));
        nVar.a("DROP TABLE IF EXISTS " + k.a(str));
    }

    private static void b(n nVar, List list) {
        Cursor cursor = null;
        try {
            cursor = nVar.a(String.format(Locale.getDefault(), "SELECT name FROM sqlite_master WHERE type='table' AND name GLOB 'list-*'", new Object[0]), new String[0]);
            while (cursor.moveToNext()) {
                list.add(cursor.getString(0));
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    private static void c(n nVar, List list) {
        Cursor cursor = null;
        try {
            cursor = nVar.a(String.format(Locale.getDefault(), "SELECT name FROM sqlite_master WHERE type='table' AND name GLOB 'map-*'", new Object[0]), new String[0]);
            while (cursor.moveToNext()) {
                list.add(cursor.getString(0));
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }

    private static byte[] a(Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(serializable);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable th3) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    th.printStackTrace();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Throwable th5) {
                        }
                    }
                    return bArr;
                } catch (Throwable th6) {
                    th2 = th6;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th8) {
            objectOutputStream = bArr;
            th2 = th8;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw th2;
        }
        return bArr;
    }

    private static Serializable a(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream = null;
        if (bArr == null) {
            return null;
        }
        ObjectInputStream objectInputStream2;
        try {
            objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                Serializable serializable = (Serializable) objectInputStream2.readObject();
                if (objectInputStream2 == null) {
                    return serializable;
                }
                try {
                    objectInputStream2.close();
                    return serializable;
                } catch (Throwable th2) {
                    return serializable;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (Throwable th4) {
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable th6) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
    }

    private static void b(n nVar) {
        nVar.a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s BLOB)", new Object[]{"objects", "name", "stream"}));
    }
}
