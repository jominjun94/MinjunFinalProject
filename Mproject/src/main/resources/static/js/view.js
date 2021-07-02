function deleteImage(imageId){
	
	$.ajax({
		type:"DELETE",
		url:"/api/image/" + imageId + "/delete",
		dataType: "json"
		
	}).done(res=>{
		
		history.back();
		
		
		
	}).fail(error=>{
		console.log("이미지 삭제 실패 " , error);
	});
	
}

function toggleLike(imageId) {
	
	
	
	if(document.getElementById("buttonLike").value == "LIKE"){
		
		$.ajax({
			type:"post",
			url:"/api/image/"+imageId+"/likes",
			dataType: "json"
		}
			
		).done(res =>{
			document.getElementById("buttonLike").value = "LikeCancel";
			location.reload();
			
		}).fail(error =>{
			console.log("좋아요 취소 실패 " , error);
		});
		
		
	} else if(document.getElementById("buttonLike").value == "LikeCancel") {
		
		$.ajax({
		type: "delete",
		url:"/api/image/"+imageId+"/likes",
		dataType: "json"
		
		
		}).done(res =>{
		document.getElementById("buttonLike").value = "LIKE";
		location.reload();
		
		}).fail(error =>{
		console.log("좋아요 실패 " , error);
		
		});
		
		
	}


}