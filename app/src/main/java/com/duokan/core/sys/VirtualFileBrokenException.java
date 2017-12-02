package com.duokan.core.sys;

import java.io.IOException;

public class VirtualFileBrokenException extends IOException {
    public VirtualFileBrokenException(String str) {
        super(str);
    }
}
