function storyLoad() {

	$.ajax({
		url: "/api/images",
		dataType: "json"
	}).done(res => {
	
		console.log(res.data);
		
	
			let storyItem = getStoryItem(res.data);
			$("#storyList").append(storyItem);
		
		
		
		
		
		

	}).fail(error => {
		console.log("오류", error);

	});
}

storyLoad();

function getStoryItem(image){
	let item = ``;



	image.forEach((image)=>{
		
		
		item +=`<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<a href = "/user/${image.user.id}"><img class="card-img-top" src="/upload2/${image.postImageUrl}" /></a>
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<br />
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto"
										href="/image/${image.id}">View options</a>
										
							
										
								</div>
							</div>
						</div>
					</div>`;
		
		
		
	});
	



	
	return item;
	
}