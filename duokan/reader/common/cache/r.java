package com.duokan.reader.common.cache;

import android.content.ContentValues;

public interface r {
    aa[] getPropertyDefinitions();

    ContentValues getPropertyValues(Object obj);

    String getUniqueId(Object obj);

    Object serializeItemCorePropertiesToJson(Object obj);

    Object serializeItemToJson(Object obj, Object obj2);
}
