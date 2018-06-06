// JavaScript Document

$(function(){
if(!placeholderSupport()){   // 鍒ゆ柇娴忚鍣ㄦ槸鍚︽敮鎸� placeholder
    $('[placeholder]').focus(function() {
        var input = $(this);        if (input.val() == input.attr('placeholder')) {
            input.val('');
            input.removeClass('placeholder');
        }
    }).blur(function() {
        var input = $(this);
        if (input.val() == '' || input.val() == input.attr('placeholder')) {
            input.addClass('placeholder');
            input.val(input.attr('placeholder'));
        }
    }).blur();
};
})
function placeholderSupport() {
    return 'placeholder' in document.createElement('input');
}