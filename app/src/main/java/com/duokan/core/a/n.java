package com.duokan.core.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.sys.TaskHandler;

import java.io.File;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class n {
    static final /* synthetic */ boolean a = (!n.class.desiredAssertionStatus());
    private final ReentrantLock b;
    private final s c;
    private final TaskHandler d;
    private boolean e;
    private boolean f;
    private Runnable g;

    public n(String str) {
        this(str, "");
    }

    public n(String str, String str2) {
        this.b = new ReentrantLock();
        this.e = false;
        this.f = false;
        this.g = null;
        this.c = new s(str, str2);
        if (!TextUtils.isEmpty(this.c.b)) {
            ManagedApp.get().addOnRunningStateChangedListener(new o(this));
        }
        this.d = new p(this);
    }

    public String a() {
        return this.c.a;
    }

    public void b() {
        this.d.getThread().beginTransaction();
    }

    public int a(String str, String str2, String[] strArr) {
        try {
            int delete = this.d.getThread().delete(str, str2, strArr);
            return delete;
        } finally {
            this.d.removeCallbacks();
        }
    }

    public void c() {
        try {
            this.d.isCurrentThread().endTransaction();
        } finally {
            this.d.removeCallbacks();
        }
    }

    public void a(String str, Object[] objArr) {
        try {
            this.d.getThread().execSQL(str, objArr);
        } finally {
            this.d.removeCallbacks();
        }
    }

    public void a(String str) {
        try {
            this.d.getThread().execSQL(str);
        } finally {
            this.d.removeCallbacks();
        }
    }

    public int d() {
        try {
            int version = this.d.getThread().getVersion();
            return version;
        } finally {
            this.d.removeCallbacks();
        }
    }

    public boolean e() {
        try {
            boolean inTransaction = this.d.getThread().inTransaction();
            return inTransaction;
        } finally {
            this.d.removeCallbacks();
        }
    }

    public long a(String str, String str2, ContentValues contentValues) {
        try {
            long insert = this.d.getThread().insert(str, str2, contentValues);
            return insert;
        } finally {
            this.d.removeCallbacks();
        }
    }

    public long b(String str, String str2, ContentValues contentValues) {
        try {
            long insertOrThrow = this.d.getThread().insertOrThrow(str, str2, contentValues);
            return insertOrThrow;
        } finally {
            this.d.removeCallbacks();
        }
    }

    public long a(String str, String str2, ContentValues contentValues, int i) {
        try {
            long insertWithOnConflict = this.d.getThread().insertWithOnConflict(str, str2, contentValues, i);
            return insertWithOnConflict;
        } finally {
            this.d.removeCallbacks();
        }
    }

    public Cursor a(String str, String[] strArr) {
        Cursor mVar;
        try {
            mVar = new m(this.d, this.d.getThread().rawQuery(str, strArr));
            return mVar;
        } finally {
            mVar = this.d;
            mVar.c();
        }
    }

    public void f() {
        try {
            this.d.getThread().setTransactionSuccessful();
        } finally {
            this.d.removeCallbacks();
        }
    }

    public void a(int i) {
        try {
            this.d.getThread().setVersion(i);
        } finally {
            this.d.removeCallbacks();
        }
    }

    public int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            int update = this.d.getThread().update(str, contentValues, str2, strArr);
            return update;
        } finally {
            this.d.removeCallbacks();
        }
    }

    public void g() {
        this.b.lock();
        try {
            Object obj = this.e;
            this.e = true;
            if (obj == null) {
                this.d.removeCallbacks();
            }
        } finally {
            this.b.unlock();
        }
    }

    public List b(String str) {
        try {
            List a = u.a(this.d.getThread(), str);
            return a;
        } finally {
            this.d.removeCallbacks();
        }
    }

    private void h() {
        if (!this.f) {
            this.g = null;
        }
    }

    private void i() {
        if (!a && !this.b.isHeldByCurrentThread()) {
            throw new AssertionError();
        } else if (!a && TextUtils.isEmpty(this.c.b)) {
            throw new AssertionError();
        } else if (!this.f) {
            File file = new File(Uri.parse(this.c.a).getPath());
            File file2 = new File(Uri.parse(this.c.b).getPath());
            if (file2.length() != file.length() || file2.lastModified() <= file.lastModified()) {
                this.g = new q(this, file, file2);
                TaskHandler.postDelayed(this.g, 15000);
            }
        }
    }

    private void a(File file, File file2) {
        if (!a && !this.b.isHeldByCurrentThread()) {
            throw new AssertionError();
        } else if (this.d.isCurrentThread() == null) {
            try {
                File file3 = new File(Uri.parse(this.c.b + ".tmp").getPath());
                if (a.a(file, file3)) {
                    file2.delete();
                    file3.renameTo(file2);
                    return;
                }
                file3.delete();
            } catch (Throwable th) {
            }
        }
    }

    private void j() {
        if (!a && !this.b.isHeldByCurrentThread()) {
            throw new AssertionError();
        } else if (!TextUtils.isEmpty(this.c.b)) {
            File file = new File(Uri.parse(this.c.a).getPath());
            File file2 = new File(Uri.parse(this.c.b).getPath());
            if (!file.exists() && file2.exists()) {
                File file3 = new File(Uri.parse(this.c.a + ".tmp").getPath());
                try {
                    if (a.a(file2, file3)) {
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
