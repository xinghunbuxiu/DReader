package com.duokan.core.sys;

import java.io.IOException;

class VirtualFileAssertionFailsException extends IOException {
    private static final long serialVersionUID = -7827079784707807850L;

    public VirtualFileAssertionFailsException() {
        super("");
    }

    public VirtualFileAssertionFailsException(String str) {
        super(str);
    }
}
