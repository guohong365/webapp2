package com.uc.web.domain;

public interface WithId<IdType> {
	IdType getId();
	void setId(IdType id);
}
