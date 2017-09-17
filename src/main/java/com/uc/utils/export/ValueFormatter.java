package com.uc.utils.export;

public interface ValueFormatter<EntityType> {
	/**
	 * 格式化实体类型实例的列，
	 * @param column 列号， 从0开始
	 * @param data 实体实例
	 * @return 每列格式话的结果字串。如果列号超过实体能提供的数据范围，返回空串。例如 负数或大于等于最大列。
	 *        要判断是否结束，使用valid函数。
	 */
	String get(int column, EntityType data);	
	/**
	 * 判断数据是否在column还有数据，用于判断实体输出列结束
	 * @param column 列号，从0开始
	 * @param data 数据实例
	 * @return 
	 */
	default boolean valid(int column, EntityType data){
		return column >=0 && column < getCount();
	}
	/**
	 * 返回列数
	 * @return 列数
	 */
	int getCount();
}
