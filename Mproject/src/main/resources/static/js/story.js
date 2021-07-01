function storyLoad() {

	$.ajax({
		url: "/api/images",
		dataType: "json"
	}).done(res => {
		
		console.log(res);
		res.data.forEach((image)=>{
			let storyItem = getStoryItem(image);
			$("#storyList").append(storyItem);
		});

	}).fail(error => {
		console.log("오류", error);

	});
}

storyLoad();

function getStoryItem(image){
	let item = `
	<div>
		<p>${image.caption}</p> 
	</div>`;
	

	
	return item;
	
}