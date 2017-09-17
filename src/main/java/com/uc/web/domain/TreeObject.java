package com.uc.web.domain;

public interface TreeObject extends WithId {
    Object getParent();
    void setParent(Object parent);
}
