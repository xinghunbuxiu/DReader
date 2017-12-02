package com.duokan.reader.common.webservices.duokan;

public enum RecommendType {
    RECOMMEND_HOMEPAGE("1"),
    RECOMMEND_FICTION_BOY("2"),
    RECOMMEND_FICTION_GIRL("3");
    
    private String mTypeIndex;

    public String value() {
        return this.mTypeIndex;
    }

    private RecommendType(String str) {
        this.mTypeIndex = str;
    }
}
