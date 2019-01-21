$(document).ready( function () {
	var table = $('#employeesTable').DataTable({
		
		"processing": true,
		"serverSide": true,
		"ajax": {
			"url": "/employees",
		}
	});
});