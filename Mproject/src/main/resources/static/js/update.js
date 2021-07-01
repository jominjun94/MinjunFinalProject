// (1) 회원정보 수정
function update(userId, event) {


	event.preventDefault();
	let data = $('#profileUpdate').serialize();
	// 기본 form은 serialize로 보내주면 되고 
	// 사진 같은거는 		// 서버에 이미지를 전송
	//let profileImageForm = $("#userProfileImageForm")[0];
	//console.log(profileImageForm);

	// FormData 객체를 이용하면 form 태그의 필드와 그 값을 나타내는 일련의 key/value 쌍을 담을 수 있다.
	//let formData = new FormData(profileImageForm);
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