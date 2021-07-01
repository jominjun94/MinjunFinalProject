function toggleSubscribe(toUserId) {
	if (document.getElementById("myButton1").value == "subscribeCanel") {
		
		
		$.ajax({
		type: "delete",
		url: "/api/subscribe/" + toUserId,
		dataType: "json"
		
		
		}).done(res =>{
		document.getElementById("myButton1").value = "subscribe";
		location.reload();
		
		}).fail(error =>{
		console.log("구독 취소 실패 " , error);
		
		});
		
		
		
		
		
		
	} else if(document.getElementById("myButton1").value == "subscribe") {
	
	$.ajax({
		type: "post",
		url: "/api/subscribe/" + toUserId,
		dataType: "json"
		
		
		}).done(res =>{
		document.getElementById("myButton1").value = "subscribeCanel";
		location.reload();
		
		}).fail(error =>{
		console.log("구독 하기 실패 " , error);
		
		});
		
		
		
		
	}
}

