package com.yis.lms.result;

import lombok.Data;
import org.springframework.lang.Nullable;

import com.yis.lms.utils.Constants;

@Data
public class RtnResult<T> extends RtnSuper {

	private static final long serialVersionUID = 6010098099349367077L;

	private T t;

	public RtnResult(){}

	public RtnResult(@Nullable T body,Constants.RtnStatus status){
		this.setT(body);
		this.setStatus(status.status());
		this.setMessage(status.value());
	}
	
	public RtnResult(Constants.RtnStatus status){
		this.setT(null);
		this.setStatus(status.status());
		this.setMessage(status.value());
	}
	public static<T> RtnResult<T> success(String rtnMsg,T t) {
		RtnResult rtnResult=RtnResult.t();
		rtnResult.setMessage(rtnMsg);
		rtnResult.setStatus(Constants.RtnCode.SUCCESS);
		rtnResult.setT(t);
		return rtnResult;
	}

	/**成功但不带数据**/
	public static<T> RtnResult<T> success(String rtnMsg){
		return success(rtnMsg,null);
	}

	public static RtnResult t() {
		return new RtnResult();
	}

	public  static RtnResult failure(String rtnMsg) {
		RtnResult rtnResult=RtnResult.t();
		rtnResult.setMessage(rtnMsg);
		rtnResult.setStatus(Constants.RtnCode.FAILURE);
		return rtnResult;
	}

	public void setSuccess(String rtnMsg, T e) {
		this.setT(e);
		this.setStatus(Constants.RtnStatus.OK.status());
		this.setMessage(rtnMsg);
	}

	public void setFailure(String rtnMsg) {
		this.setStatus(Constants.RtnStatus.INTERNAL_SERVER_ERROR.status());
		this.setMessage(rtnMsg);
	}

	public  static RtnResult unauthorize(String rtnMsg) {
		RtnResult rtnResult=RtnResult.t();
		rtnResult.setMessage(rtnMsg);
		rtnResult.setStatus(Constants.RtnStatus.UNAUTHORIZED.status());
		return rtnResult;
	}
	public  static RtnResult build(Integer rtnCode, String rtnMsg) {
		RtnResult rtnResult=RtnResult.t();
		rtnResult.setMessage(rtnMsg);
		rtnResult.setStatus(rtnCode);
		return rtnResult;
	}

	public  static RtnResult exception(String rtnMsg) {
		RtnResult rtnResult=RtnResult.t();
		rtnResult.setMessage(rtnMsg);
		rtnResult.setStatus(Constants.RtnStatus.NOT_IMPLEMENTED.status());
		return rtnResult;
	}
}
