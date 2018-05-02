package com.duokan.reader.domain.bookshelf;

public enum BookState {
    NORMAL,
    CLOUD_ONLY,
    PULLING,
    UPDATING,
    CAN_PULL,
    CAN_UPDATE
}
