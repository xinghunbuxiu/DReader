package com.duokan.core.sys.p025a;

import android.support.v4.content.ContextCompat;
import com.duokan.core.app.BaseActivity;
import com.duokan.reader.DkApp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Permissions implements IPermissionsResultListener {
    private static Permissions rxPermissions;
    private final String[] permissions = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private List<IPermissionsResultListener> permissionsResultListeners = new CopyOnWriteArrayList();
    private volatile boolean grantResults = false;

    private Permissions() {
        try {
            for (String checkSelfPermission : this.permissions) {
                if (ContextCompat.checkSelfPermission(DkApp.get(), checkSelfPermission) != 0) {
                    this.grantResults = false;
                    return;
                }
            }
            this.grantResults = true;
        } catch (Throwable th) {
            this.grantResults = false;
        }
    }

    public void setPermissionsResultListener(BaseActivity mActivity, IPermissionsResultListener listener) {
        if (this.grantResults) {
            listener.onSuccess();
            return;
        }
        addPermissionsResultListener(listener);
        new RequestPermissionsResult(mActivity, this.permissions, this).requestPermissions();
    }


    public void addPermissionsResultListener(IPermissionsResultListener listener) {
        if (this.grantResults) {
            listener.onSuccess();
        } else {
            this.permissionsResultListeners.add(listener);
        }
    }


    public static synchronized Permissions getInstance() {
        Permissions permissions;
        synchronized (Permissions.class) {
            if (rxPermissions == null) {
                rxPermissions = new Permissions();
            }
            permissions = rxPermissions;
        }
        return permissions;
    }

    public synchronized void onSuccess() {
        this.grantResults = true;
        for (IPermissionsResultListener onSuccess : this.permissionsResultListeners) {
            onSuccess.onSuccess();
        }
        this.permissionsResultListeners.clear();
    }

    public synchronized void onFail() {
        this.grantResults = false;
        for (IPermissionsResultListener onFail : this.permissionsResultListeners) {
            onFail.onFail();
        }
        this.permissionsResultListeners.clear();
    }

    /* renamed from: b */
    public boolean m834b() {
        return this.grantResults;
    }
}
