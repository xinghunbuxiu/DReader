package com.duokan.core.app;

import android.content.Intent;

public interface OnActivityResultListener {
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
