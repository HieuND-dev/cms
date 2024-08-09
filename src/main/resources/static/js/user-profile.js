$(document).ready(function () {


    $("#formValidation").validate({
        rules: {
            firstname: {
                minlength: 3,
                maxlength: 30
            },
            lastname: {
                minlength: 3,
                maxlength: 30
            },
            phone: {
                number: true,
                minlength: 9,
                maxlength: 13
            },
            description: {
                maxlength: 200
            }

        },
        messages: {
            // name: {
            //     // required: "Please enter your User name",
            //     minlength: jQuery.validator.format('First name has a minimum of 3 characters'),
            //     maxlength: jQuery.validator.format('First name has a minimum of 30 characters')
            // }
        },

        submitHandler: function (form) {
            form.submit();
        }
    });


});