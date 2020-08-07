package com.yis.lms.result;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PageResult<T> implements Serializable {

	private  Integer pageNo;
	private  Integer pageSize;
	private  Integer total;

	private List<T> list;

	/**
	 *
	 */
	private static final long serialVersionUID = -5081559067834976350L;

}
