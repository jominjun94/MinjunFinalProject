// (1) 회원정보 수정
function update(userId, event) {


	event.preventDefault();
	let data = $('#profileUpdate').serialize();

	console.log(data);

	$.ajax({

		type: "put",
		url: `/api/user/${userId}`,
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8", // 보낼때 spring 기본타입으로 받겟습니다!
		dataType: "json"// 받을값을 json으로 받겠습니다. 


	}).done(res => {

		console.log("update성공");
		location.href = `/`;
	}).fail(error => {

		if (error.data == null) {
			alert(error.responseJSON.message);
		} else {

			alert(error.responseJSON.data.name);
			console.log("실패", error);
		}
	});


}