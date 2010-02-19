jQuery.noConflict();

jQuery(document).ready(function(){
	jQuery.threestateradiobutton = {
			last:undefined
			,__callback : function(a){
				if(jQuery.threestateradiobutton.last != undefined){
					jQuery.threestateradiobutton.last.checked = false;
					jQuery.threestateradiobutton.last = undefined;
				}		
			}		
		};

		jQuery('input[type=radio]').mousedown(function(){
			if(this.checked == true){
				jQuery.threestateradiobutton.last = this;
				setTimeout(jQuery.threestateradiobutton.__callback, 120);
			}
		});
});

function clearMatrix() {
	jQuery('input[type=radio]').each(function() {
		jQuery(this).attr('checked', false);
	});
}