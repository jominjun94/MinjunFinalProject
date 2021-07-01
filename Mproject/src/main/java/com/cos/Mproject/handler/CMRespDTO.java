package com.cos.Mproject.handler;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMRespDTO<T> {
	
	private int code; // 1 성공  , -1 실패
	private String message;
	private T data;
	//private Map<String,String> errorMap;


}
