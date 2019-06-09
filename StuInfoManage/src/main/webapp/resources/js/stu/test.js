$(document).ready(function () {
    $("p").click(function () {
        $(this).hide();
    });
});

$(function () {
    var registerStuUrl = '/StuInfoManage_war/stuadmin/registerStu';
    $('#submit').click(function () {
        var stu = {};
        stu.stuName = $('#stu-name').val();
        stu.stuGender = $('#stu-gender').val();
        var stuImg = $('#stu-img')[0].files[0];
        var formData = new FormData();
        formData.append('stuImg', stuImg);
        formData.append('stuStr', JSON.stringify(stu));

        $.ajax({
            url: registerStuUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    $.toast('提交成功!');
                } else {
                    $.toast('提交失败:' + data.errMsg);
                }
            }
        })
    })
});