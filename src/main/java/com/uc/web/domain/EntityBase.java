package com.uc.web.domain;

import com.uc.utils.ObjectPropertyFormator;

public class EntityBase {
	@Override
	public String toString() {
		return ObjectPropertyFormator.format(this);
	}
}
