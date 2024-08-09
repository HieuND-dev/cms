$(document).ready(function () {
    // myScript.js
    // console.log("JavaScript file loaded successfully!");


    $("#formValidation").validate({
        rules: {
            email: {
                minlength: 5,
                maxlength: 50,
                email: true
            },
            password: {
                minlength: 8,
                maxlength: 50
            }

        },
        messages: {
            email: {
                // required: "Please enter your User name",
                minlength: jQuery.validator.format('Email has a minimum of 5 characters'),
                maxlength: jQuery.validator.format('Email has a minimum of 50 characters')
            },
            password: {
                minlength: jQuery.validator.format('Email has a minimum of 8 characters'),
                maxlength: jQuery.validator.format('Email has a minimum of 50 characters')
            }
        },
        submitHandler: function (form) {
            form.submit();
        }
    });
});