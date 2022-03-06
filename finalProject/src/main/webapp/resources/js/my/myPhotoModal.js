$('#photoBtn').click(function () {
	$('#myPhotoModal').fadeIn();
	console.log('going?');
	});
$('.profileBtn').click(function () {
	$('#myPhotoModal').fadeOut();
		location.reload();
	});
$('.myCancelBtn').click(function () {
		$('#myPhotoModal').fadeOut();
		location.reload();});