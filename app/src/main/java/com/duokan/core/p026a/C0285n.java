package com.duokan.core.p026a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.app.ManagedApp;
import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.UThread;
import java.io.File;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class C0285n {
    
    static final  boolean f476a = (!C0285n.class.desiredAssertionStatus());
    
    private final ReentrantLock f477b;
    
    private final C0292s f478c;
    
    private final C0288t f479d;
    
    private boolean f480e;
    
    private boolean f481f;
    
    private Runnable f482g;

    public C0285n(String str) {
        this(str, "");
    }

    public C0285n(String str, String str2) {
        this.f477b = new ReentrantLock();
        this.f480e = false;
        this.f481f = false;
        this.f482g = null;
        this.f478c = new C0292s(str, str2);
        if (!TextUtils.isEmpty(this.f478c.f493b)) {
            ManagedApp.get().addOnRunningStateChangedListener(new C0287o(this));
        }
        this.f479d = new C0289p(this);
    }

    
    public String m671a() {
        return this.f478c.f492a;
    }

    
    public void m677b() {
        this.f479d.mo382b().beginTransaction();
    }

    
    public int m667a(String str, String str2, String[] strArr) {
        try {
            int delete = this.f479d.mo382b().delete(str, str2, strArr);
            return delete;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public void m678c() {
        try {
            this.f479d.mo381a().endTransaction();
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public void m674a(String str, Object[] objArr) {
        try {
            this.f479d.mo382b().execSQL(str, objArr);
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public void m673a(String str) {
        try {
            this.f479d.mo382b().execSQL(str);
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public int m679d() {
        try {
            int version = this.f479d.mo382b().getVersion();
            return version;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public boolean m680e() {
        try {
            boolean inTransaction = this.f479d.mo382b().inTransaction();
            return inTransaction;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public long m668a(String str, String str2, ContentValues contentValues) {
        try {
            long insert = this.f479d.mo382b().insert(str, str2, contentValues);
            return insert;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public long m675b(String str, String str2, ContentValues contentValues) {
        try {
            long insertOrThrow = this.f479d.mo382b().insertOrThrow(str, str2, contentValues);
            return insertOrThrow;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public long m669a(String str, String str2, ContentValues contentValues, int i) {
        try {
            long insertWithOnConflict = this.f479d.mo382b().insertWithOnConflict(str, str2, contentValues, i);
            return insertWithOnConflict;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public Cursor m670a(String str, String[] strArr) {
        Cursor c0284m;
        try {
            c0284m = new C0284m(this.f479d, this.f479d.mo382b().rawQuery(str, strArr));
            return c0284m;
        } finally {
            c0284m = this.f479d;
            c0284m.mo383c();
        }
    }

    
    public void m681f() {
        try {
            this.f479d.mo382b().setTransactionSuccessful();
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public void m672a(int i) {
        try {
            this.f479d.mo382b().setVersion(i);
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public int m666a(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            int update = this.f479d.mo382b().update(str, contentValues, str2, strArr);
            return update;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    public void m682g() {
        this.f477b.lock();
        try {
            Object obj = this.f480e;
            this.f480e = true;
            if (obj == null) {
                this.f479d.mo383c();
            }
        } finally {
            this.f477b.unlock();
        }
    }

    
    public List<String> m676b(String str) {
        try {
            List<String> a = C0293u.m693a(this.f479d.mo382b(), str);
            return a;
        } finally {
            this.f479d.mo383c();
        }
    }

    
    private void m661h() {
        if (!this.f481f) {
            this.f482g = null;
        }
    }

    
    private void m664i() {
        if (!f476a && !this.f477b.isHeldByCurrentThread()) {
            throw new AssertionError();
        } else if (!f476a && TextUtils.isEmpty(this.f478c.f493b)) {
            throw new AssertionError();
        } else if (!this.f481f) {
            File file = new File(Uri.parse(this.f478c.f492a).getPath());
            File file2 = new File(Uri.parse(this.f478c.f493b).getPath());
            if (file2.length() != file.length() || file2.lastModified() <= file.lastModified()) {
                this.f482g = new C0290q(this, file, file2);
                UThread.postDelayed(this.f482g, 15000);
            }
        }
    }

    
    private void m653a(File file, File file2) {
        if (!f476a && !this.f477b.isHeldByCurrentThread()) {
            throw new AssertionError();
        } else if (this.f479d.mo381a() == null) {
            try {
                File file3 = new File(Uri.parse(this.f478c.f493b + ".tmp").getPath());
                if (FileUtil.doCopyFile(file, file3)) {
                    file2.delete();
                    file3.renameTo(file2);
                    return;
                }
                file3.delete();
            } catch (Throwable th) {
            }
        }
    }

    
    private void m665j() {
        if (!f476a && !this.f477b.isHeldByCurrentThread()) {
            throw new AssertionError();
        } else if (!TextUtils.isEmpty(this.f478c.f493b)) {
            File file = new File(Uri.parse(this.f478c.f492a).getPath());
            File file2 = new File(Uri.parse(this.f478c.f493b).getPath());
            if (!file.exists() && file2.exists()) {
                File file3 = new File(Uri.parse(this.f478c.f492a + ".tmp").getPath());
                try {
                    if (FileUtil.doCopyFile(file2, file3)) {
                        file3.renameTo(file);
                    } else {
                        file3.delete();
                    }
                } catch (Throwable th) {
                }
            }
        }
    }
}
