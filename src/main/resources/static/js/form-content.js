
$(document).ready(function () {

    $("#formValidation").validate({
        rules: {
            title: {
                minlength: 10,
                maxlength: 200
            },
            brief: {
                minlength: 10,
                maxlength: 150
            },
            contentField: {
                minlength: 10,
                maxlength: 1000
            }

        },
        messages: {
            // title: {
            //     // required: "Please enter your User name",
            //     minlength: jQuery.validator.format('Title has a minimum of 10 characters'),
            //     maxlength: jQuery.validator.format('Title name has a minimum of 200 characters')
            // }
        },

        submitHandler: function (form) {
            form.submit();
        }
    });


});