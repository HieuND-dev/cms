
$(document).ready(function () {
    $("#formValidation").validate({
        rules: {
            username: {
                minlength: 3,
                maxlength: 50
            },
            email: {
                minlength: 5,
                maxlength: 50,
                email: true
            },
            password: {
                minlength: 8,
                maxlength: 50
            },
            repassword: {
                minlength: 8,
                maxlength: 50,
                equalTo: "#password"
            }

        },
        messages: {
            // name: {
            //     // required: "Please enter your User name",
            //     minlength: jQuery.validator.format('User name has a minimum of 3 characters'),
            //     maxlength: jQuery.validator.format('User name has a minimum of 30 characters')
            // },
            // email: {
            //     required: "Please enter your email"
            // },
            // password: {
            //     required: "Please enter your password"
            // },
            repassword: {
                // required: "Please enter your confirm password",
                equalTo: 'Password does not matching'
            }
        },

        submitHandler: function (form) {
            form.submit();
        }
    });
});