function toggleSubscribe(toUserId) {
	if (document.getElementById("myButton1").value == "SUBSCRIBECANCEL") {
		
		
		$.ajax({
		type: "delete",
		url: "/api/subscribe/" + toUserId,
		dataType: "json"
		
		
		}).done(res =>{
		document.getElementById("myButton1").value = "SUBSCRIBE";
		location.reload();
		
		}).fail(error =>{
		console.log("구독 취소 실패 " , error);
		
		});
		
		
		
		
		
		
	} else if(document.getElementById("myButton1").value == "SUBSCRIBE") {
	
	$.ajax({
		type: "post",
		url: "/api/subscribe/" + toUserId,
		dataType: "json"
		
		
		}).done(res =>{
		document.getElementById("myButton1").value = "SUBSCRIBECANCEL";
		location.reload();
		
		}).fail(error =>{
		console.log("구독 하기 실패 " , error);
		
		});
		
		
		
		
	}
}

