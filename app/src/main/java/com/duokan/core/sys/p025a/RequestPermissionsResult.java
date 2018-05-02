package com.duokan.core.sys.p025a;

import android.text.TextUtils;

import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.OnRequestPermissionsResultCallback;

public class RequestPermissionsResult implements OnRequestPermissionsResultCallback {
    private final String[] permissions;
    private final BaseActivity mActivity;
    private final IPermissionsResultListener permissionsResultListener;

    public RequestPermissionsResult(BaseActivity mActivity, String[] permissions, IPermissionsResultListener permissionsResultListener) {
        this.mActivity = mActivity;
        this.permissions = permissions;
        this.permissionsResultListener = permissionsResultListener;
    }

    RequestPermissionsResult(BaseActivity mActivity, C0340e c0340e, IPermissionsResultListener rermissionsResult) {
        this(mActivity, new String[]{c0340e.mo399a()}, rermissionsResult);
    }

    public void requestPermissions() {
        this.mActivity.requestPermissions(this.permissions, this);
    }

    @Override
    public void onRequestPermissionsResult(String[] permissions, int[] grantResults) {
        int length = this.permissions.length;
        int i = 0;
        while (i < length) {
            if (isRevoked(permissions, grantResults, this.permissions[i])) {
                i++;
            } else {
                this.permissionsResultListener.onFail();
                return;
            }
        }
        this.permissionsResultListener.onSuccess();
    }

    private boolean isRevoked(String[] permissions, int[] grantResults, String permission) {
        int i = 0;
        while (i < permissions.length) {
            if (!TextUtils.equals(permission, permissions[i])) {
                i++;
            } else if (grantResults[i] == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
