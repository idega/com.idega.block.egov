jQuery.noConflict();

jQuery(document).ready(function() {
	initializeProviderAreaDropdowns();
	initializeProviderTypeDropdowns();
});

function initializeProviderAreaDropdowns() {
	jQuery("select.areaDropdown").change(function() {
		var id = jQuery(this).attr('id');
		if (id == null) {
			return false;
		}
		
		ChildCareSession.getProvidersByArea(dwr.util.getValue(id), {
			callback: function(result) {
				var index = id.lastIndexOf('_');
				if(index > 0) {
					index = id.substring(index + 1);
					dwr.util.removeAllOptions('prm_provider_' + index);
					dwr.util.addOptions('prm_provider_' + index, result);
				}
			}
		});
	});
}

function initializeProviderTypeDropdowns() {
	jQuery("select.typeDropdown").change(function() {
		var id = jQuery(this).attr('id');
		if (id == null) {
			return false;
		}
		
		ChildCareSession.getProvidersByType(dwr.util.getValue(id), {
			callback: function(result) {
				var index = id.lastIndexOf('_');
				if(index > 0) {
					index = id.substring(index + 1);
					dwr.util.removeAllOptions('prm_provider_' + index);
					dwr.util.addOptions('prm_provider_' + index, result);
				}
			}
		});
	});
}