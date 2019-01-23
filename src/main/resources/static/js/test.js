$(document).ready( function () {
	$("#submit-btn").on('click',() => {
		let sendJson = {};
		sendJson["0"] = "hien0";
		sendJson["1"] = "hien1";
		$.ajax({
			type: "POST",
			url: "/api/receive",
			contentType: "application/json",
			data: JSON.stringify(sendJson),
		}).done(function(msg) {
			console.log("ok " + msg);
		}).fail(function(error) {
			console.log("loi " + error);
		});
		
	});
});