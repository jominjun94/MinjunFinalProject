let index = {
	init:function(){ // on("click",fuction(){} 이렇게 하면 let _this = this; 를 해줘야만 한다 _this.save();
		$("#btn-save").on("click",()=>{//function(){} 이방법도 있긴하지만 , this를 쓰기 위한 방법이다 
			this.save();
		});
		
		
		$("#btn-delete").on("click",()=>{//function(){} 이방법도 있긴하지만 , this를 쓰기 위한 방법이다 
			this.deleteById();
		});
		$("#btn-deleteAdmin").on("click",()=>{//function(){} 이방법도 있긴하지만 , this를 쓰기 위한 방법이다 
			this.deleteByIdadmin();
		});
		},
	
	
	
	save: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					title: $("#title").val(),
					content: $("#content").val(),
					
			};
			
			//console.log(data);
			
			// ajax호출시 default가 비동기 호출
			// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해주네요.
			$.ajax({ 
				type: "POST",
				url: "/api/board",
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
			
			console.log(resp);
			location.href = "/board";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
			
			
			
		});
		
	},
	
	
	deleteById: function(){
		
		var id = $("#id").text();
				
					
			$.ajax({ 
				type: "DELETE",
				url: "/admin/api/board/" + id,
				dataType: "json", 
				contentType: "application/json; charset=utf-8"
			}).done(function(resp){
				
			console.log(resp);
			location.href = "/board";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
			
			
			
		});
		
	},
	
	
		deleteByIdadmin: function(){
		
		var id = $("#id").text();
				
					
			$.ajax({ 
				type: "DELETE",
				url: "/admin/api/board/" + id,
				dataType: "json", 
				contentType: "application/json; charset=utf-8"
			}).done(function(resp){
				
			console.log(resp);
			location.href = "/admin/board";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
			
			
			
		});
		
	}
	

	
	
	}

index.init();