package com.cos.Mproject.handler;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException {
	// 객체 구분용 신경 쓰지 않아도 된다
		private static final long serialVersionUID =1L;
		
		
		//Message 이미 여기 상속되어있다!
		private Map<String,String> errorMap;
		
		public CustomValidationApiException(String message ,Map<String, String> errorMap) { // 메세지와 내가 담은 에러 넘겨준다. 저장됨
			super(message);
			this.errorMap = errorMap;
		}
		
		
		public CustomValidationApiException(String message) { // 메세지와 내가 담은 에러 넘겨준다. 저장됨
			super(message);

		}

		
		public Map<String,String> getErrorMap(){
			return errorMap;
		}
	}
