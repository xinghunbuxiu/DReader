package com.duokan.core.sys;

import java.io.IOException;

public class VirtualFileUnknownException extends IOException {
    public VirtualFileUnknownException(String str) {
        super(str);
    }

    public VirtualFileUnknownException(String str, Throwable th) {
        super(str, th);
    }
}
