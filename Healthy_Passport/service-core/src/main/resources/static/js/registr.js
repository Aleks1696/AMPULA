
function createPatient() {
    jQuery.ajax({
            type: 'POST',
            url: '/patient/create',
            data:{
                login: jQuery ('#login').val(),
                password: jQuery('#password').val()
            },
            success: function () {
                jQuery('#login').val('');
                jQuery('#password').val('');
                jQuery('#passwordConfirm').val('');

            },
            error: function  () {
                jQuery('#login').val('');
                jQuery('#password').val('');
                jQuery('#passwordConfirm').val('');
                alert("Этот логин уже существует")

            }
        }
    )



}