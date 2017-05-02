package com.uc.web.domain;

public interface TreeCode<KeyType> extends Code<KeyType> {
   public KeyType getParent();
   public void setParent(KeyType code);
   
}
