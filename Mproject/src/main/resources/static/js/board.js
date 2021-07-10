let index = {
	init:function(){ 
		$("#btn-save").on("click",()=>{
			this.save();
		});
		
		
		$("#btn-delete").on("click",()=>{
			this.deleteById();
		});
		
		
			$("#btn-deleteAdmin").on("click",()=>{
			this.deleteByIdadmin();
		});
		
		
			$("#btn-deleteAdminReply").on("click",()=>{
			this.deleteAdminReply();
		});
		
			$("#btn-adminsave").on("click",()=>{
			this.adminSave();
		});
		
		$("#btn-reply-save").on("click",()=>{
			this.replyAdmin();
		});
		},
	
	
	
	save: function(){
		
			
			
			let data = {
					title: $("#title").val(),
					content: $("#content").val(),
					
			};
			
			
			$.ajax({ 
				type: "POST",
				url: "/api/board",
				data: JSON.stringify(data), 
				contentType: "application/json; charset=utf-8",
				dataType: "json" 
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
		
	},
	
		
		deleteAdminReply: function(){
		
		var id = $("#id").text();
				
					
			$.ajax({ 
				type: "DELETE",
				url: "/admin/api/board/reply/" + id,
				dataType: "json", 
				contentType: "application/json; charset=utf-8"
			}).done(function(resp){
				
			console.log(resp);
			location.href = "/admin/board/boardReply";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
			
			
			
		});
		
	},
	
	
	
		replyAdmin: function(){
		
		var userId = $("#userId").text();
				
					
			$.ajax({ 
				type: "POST",
				url: "/admin/api/board/reply/" + userId,
				dataType: "json", 
				contentType: "application/json; charset=utf-8"
			}).done(function(resp){
			
			var id = resp.data.username;
			console.log(resp);
			location.href = "/admin/reply/" + id;
			
		}).fail(function(error){
			alert(JSON.stringify(error));
			
			
			
		});
		
	},
	
	
	adminSave: function(){
			
			
	var userId = $("#userId").text();
	let data = {
					title: $("#title").val(),
					content: $("#content").val(),
					
			};
			

			$.ajax({ 
				type: "POST",
				url: "/admin/api/board/save/" + userId,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){
				
			
			
			location.href = "/admin/board/boardReply";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
			
			
			
			
		});
		
	}
	

	
	
	}

index.init();