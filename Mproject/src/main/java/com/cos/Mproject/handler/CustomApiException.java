package com.cos.Mproject.handler;



public class CustomApiException extends RuntimeException {
	
	// 객체 구분용 신경 쓰지 않아도 된다
		private static final long serialVersionUID =1L;
		

		
		public CustomApiException(String message) { // 메세지와 내가 담은 에러 넘겨준다. 저장됨
			super(message);

		}

	}
