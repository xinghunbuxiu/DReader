package com.duokan.core.p026a;

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


public class C0272a {
    
    private static final ScheduledExecutorService f458a = Executors.newSingleThreadScheduledExecutor();
    
    private final C0285n f459b;

    public C0272a(String str) {
        this(str, "");
    }

    public C0272a(String str, String str2) {
        this.f459b = new C0285n(str, str2);
        m617a(new C0274b(this));
    }

    
    public <T extends Serializable> T m631a(String str, T t) {
        T a = m630a(str);
        return a != null ? a : t;
    }

    
    public <T extends Serializable> T m630a(String str) {
        return C0272a.m616a(C0272a.m627b(this.f459b, str));
    }

    
    public void m632a() {
        m623b(new C0275c(this));
    }

    
    public void m635b() {
        m623b(new C0276d(this));
    }

    
    public Future<Boolean> m636c() {
        return m623b(new C0277e(this));
    }

    
    public boolean m638d() {
        while (true) {
            try {
                return ((Boolean) m636c().get()).booleanValue();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                return false;
            }
        }
    }

    
    public Future<Boolean> m634b(String str, Serializable serializable) {
        return m617a(new C0278f(this, str, C0272a.m622a(serializable)));
    }

    
    public boolean m637c(String str, Serializable serializable) {
        while (true) {
            try {
                return ((Boolean) m634b(str, serializable).get()).booleanValue();
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                return false;
            }
        }
    }

    
    public List<String> m639e() {
        List linkedList = new LinkedList();
        C0272a.m621a(this.f459b, linkedList);
        C0272a.m626b(this.f459b, linkedList);
        C0272a.m629c(this.f459b, linkedList);
        return linkedList;
    }

    
    public Future<Boolean> m633b(String str) {
        return m617a(new C0279g(this, str));
    }

    
    private Future<Boolean> m617a(C0273l c0273l) {
        return m623b(new C0280h(this, c0273l));
    }

    
    private Future<Boolean> m623b(C0273l c0273l) {
        return f458a.submit(new C0281i(this, c0273l));
    }

    
    private static byte[] m627b(C0285n c0285n, String str) {
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        Cursor a;
        try {
            a = c0285n.m670a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s == '%4$s'", new Object[]{"objects", "stream", "name", str}), new String[0]);
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

    
    private static void m625b(C0285n c0285n, String str, byte[] bArr) {
        if (bArr == null) {
            RuntimeException runtimeException = new RuntimeException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", str);
        contentValues.put("stream", bArr);
        c0285n.m669a("objects", null, contentValues, 5);
    }

    
    private static void m621a(C0285n c0285n, List<String> list) {
        Cursor cursor = null;
        try {
            cursor = c0285n.m670a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s", new Object[]{"objects", "name"}), new String[0]);
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

    
    private static void m628c(C0285n c0285n, String str) {
        c0285n.m673a(String.format(Locale.getDefault(), "DELETE FROM %1$s WHERE %2$s == '%3$s'", new Object[]{"objects", "name", str}));
        c0285n.m673a("DROP TABLE IF EXISTS " + C0282j.m649a(str));
        c0285n.m673a("DROP TABLE IF EXISTS " + C0283k.m650a(str));
    }

    
    private static void m626b(C0285n c0285n, List<String> list) {
        Cursor cursor = null;
        try {
            cursor = c0285n.m670a(String.format(Locale.getDefault(), "SELECT name FROM sqlite_master WHERE type='table' AND name GLOB 'list-*'", new Object[0]), new String[0]);
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

    
    private static void m629c(C0285n c0285n, List<String> list) {
        Cursor cursor = null;
        try {
            cursor = c0285n.m670a(String.format(Locale.getDefault(), "SELECT name FROM sqlite_master WHERE type='table' AND name GLOB 'map-*'", new Object[0]), new String[0]);
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

    
    private static byte[] m622a(Serializable serializable) {
        Throwable th;
        Throwable th2;
        byte[] bArr = null;
        ObjectOutputStream objectOutputStream;
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

    
    private static <T extends Serializable> T m616a(byte[] bArr) {
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

    
    private static void m624b(C0285n c0285n) {
        c0285n.m673a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s BLOB)", new Object[]{"objects", "name", "stream"}));
    }
}
