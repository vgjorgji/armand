
$(document).ready( function() {

	// auto expand
	$(".auto-expand").hover(
		function() {
			$('.dropdown-menu', this).not(".submenu").stop(true, true).slideDown("fast");
			$(this).toggleClass('open');
		}, 
		function() {
			$('.dropdown-menu', this).not(".submenu").stop(true, true).slideUp("fast");
			$(this).toggleClass('open');
		}
	);

});