var Login = function () {
    
    return {
        //main function to initiate the module
        init: function () {
        	$.backstretch([
        			        "media/image/bg/1.jpg",
        			        "media/image/bg/2.jpg",
        			        "media/image/bg/3.jpg",
        			        "media/image/bg/4.jpg"
        			        ], {
        			          fade: 1000,
        			          duration: 8000
        			      });
           $('.login-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: true, // do not focus the last invalid input
	            rules: {
	            	username: {
	                    required: true
	                },
	                realname: {
	                    required: true
	                },
	            },

	            messages: {
	                username: {
	                    required: "用户名不能为空"
	                },
	                realname: {
	                    required: "真实姓名不能为空"
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   
	                //$('.alert-error', $('.login-form')).show();
	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	           /* submitHandler: function (form) {
	            	$.post("loginController/login.do", { username: form.username.value, passwordcode: form.passwordcode.value } );
	            }*/
	        });

	       $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	            	alert(form.username.value);
	                if ($('.login-form').validate().form()) {
		            	$.post("loginController/login.do", { username: form.username.value, passwordcode: form.passwordcode.value } );
	                }
	                return false;
	            }
	        });
        }    };

}();