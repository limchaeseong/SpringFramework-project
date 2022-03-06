$(function(){
		var cost = $('#cost');
		var num = $('#num');
		
		$('#sel_cost').change(function(){
			if($(this).find('option:selected').val()=='-1'){
				$('#cost').removeAttr('placeholder');
				$('#cost').val('');
				$('#cost').focus();
			}else{
				var element = $(this).find('option:selected').val();
				cost.val(element);
			}
		})
		
		$('#sel_num').change(function(){
			if($(this).find('option:selected').val()=='-1'){
				$('#num').removeAttr('placeholder');
				$('#num').focus();
			}else{
				var element = $(this).find('option:selected').val();
				num.val(element);
			}
		})
		
		$('#all_day').click(function(){
			var checked = $('#all_day').is(':checked');
			if(checked){
				$('#s_time').css("visibility","hidden");
				$('#f_time').css("visibility","hidden");
				$('#s_time').val(null);
				$('#f_time').val(null);
				$('#s_time').attr("required",false);
				$('#f_time').attr("required",false);
			}else{
				$('#s_time').css("visibility","visible");
				$('#f_time').css("visibility","visible");
				$('#s_time').attr("required",true);
				$('#f_time').attr("required",true);
			}
		})
		
		$('#address1').on("click",function(){
			new daum.Postcode({
				oncomplete : function(data){
					$('#address1').val(data.address);
					$('#address2').focus();
				}
			}).open();
		})
	})