/**
 * Amos
 * 公共工具函数
 */
/**
 * 为空判断函数
 * @param str1
 * @param str2
 * @returns {*}
 */
function ifNull(str1,str2){
    if(typeof str1 == 'number') {
        return str1;
    }
    if(str1==""||str1==null||typeof(str1)=="undefined"||str1=="undefined"){
        return str2;
    }
    return str1;
}

/**
 * 根据文件格式返回对应的图标
 * @param type
 */
function typeIcon(type) {
    if (type == 'EXCEL'){
        return "<i class='fa fa-file-excel-o'></i>EXCEL格式"
    }
    if (type == 'SPSS'){
        return "<i class='fa fa-bar-chart'></i>SPSS格式"
    }
    if (type == 'STATA'){
        return "<i class='fa fa-th'></i>STATA格式"
    }
    if (type == 'Tabular'){
        return "<i class='fa fa-table'></i>Tabular格式"
    }
    if (type == 'CSV'){
        return "<i class='fa fa-file-text-o'></i>CSV格式"
    }
    if (type == 'ZIP'){
        return "<i class='fa fa-table'></i>ZIP格式"
    }
}

/**
 * 根据条件判断显示值
 * @param condition
 * @param val1
 * @param val2
 * @returns {*}
 */
function ifTrue(condition,val1,val2){
    if(condition){
        return val1;
    }
    return val2;
}

function alertBox(msg){// 弹出提示框，需要用户点击确认
    layer.alert(msg, {icon: 0});
}

function alertError(msg){// 弹出错误信息
    layer.alert(msg, {icon: 2});
}

function getRandomStr (length) {// 获取指定位数的随机数
    var s = [];
    var hexDigits = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (var i = 0; i < length; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 62), 1);
    }
    return s.join("");
}

function S4() {// 生成4位随机数
    return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
}

function getGuid() {// 通过随机数和时间戳获取一个唯一的标识符
    return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
}

function goToPosition(parentSelector, selector) {// 滚动到选择器所在的位置
    var position = $(selector).position().top;
    $(parentSelector).animate({
        scrollTop : position
    }, 500);
}

function validateStrFor_9z(str) {// 验证字符串只能由数字、字母、下划线组成
    var reg = /^\w+$/;
    if(reg.test(str)) {
        return true;
    } else {
        return false;
    }
}

function editSelected() {// 编辑选中的文本
    var text = $(this).text();// 获取原先的文本

    // 创建一个文本编辑区域保存并替代先前的文本
    var input;// 添加文本框
    var questionGuid;
    var itemGuid;
    var rowGuid;
    var colGuid;

    if($(this).hasClass("title")) {// 问卷标题
        input = $('<input style="width:100%;">');
        input.attr("type", "text");
        $(this).html(input);
    }else if($(this).hasClass("description")) {// 问卷描述
        input = $('<textarea style="height:'+$(this).height()+';width:100%;resize:vertical;font-size:16px;">');
        $(this).html(input);
    }else if($(this).hasClass("question-title-text")) {// 问题标题
        input = $('<input style="width: 100%">');
        input.attr("type", "text");
        $(this).html(input);

        questionGuid = $(this).parents("[data-question-guid]").data('question-guid');
    }else if($(this).hasClass('question-title-id')){// 问题编号
        if(_questionnaireInfo.userdefine.questionid){// 用户自定义编号
            input = $('<input style="width:100%;">');
            input.attr("type", "text");
            $(this).html(input);

            questionGuid = $(this).parents("[data-question-guid]").data('question-guid');
        }
    }else if ($(this).hasClass("question-item-text")) {// 问题选项
        input = $('<input style="width:100%;">');
        input.attr("type", "text");
        $(this).html(input);

        questionGuid = $(this).parents("[data-question-guid]").data('question-guid');
        itemGuid = $(this).parents('[data-item-guid]').data('item-guid');

        // 为选项添加工具条
        var toolbar = '<div class="tool-bar btn-group">';
        toolbar += '<a class="btn btn-sm btn-primary" title="选项设置" onmousedown="setItem(\''+questionGuid+'\', \''+itemGuid+'\')"><i class="fa fa-cog"></i></a>';
        toolbar += '<a class="btn btn-sm btn-primary" title="上移选项" onmousedown="moveItemUp(\''+questionGuid+'\', \''+itemGuid+'\')"><i class="fa fa-arrow-up"></i></a>';
        toolbar += '<a class="btn btn-sm btn-primary" title="下移选项" onmousedown="moveItemDown(\''+questionGuid+'\', \''+itemGuid+'\')"><i class="fa fa-arrow-down"></i></a>';
        toolbar += '<a class="btn btn-sm btn-primary" title="删除选项" onmousedown="deleteItem(\''+questionGuid+'\', \''+itemGuid+'\')"><i class="fa fa-trash"></i></a>';
        toolbar += '</div>';
        $(this).append(toolbar);

        // 若选项后面有文本框，则隐去文本框
        if($(this).next().is('input')) {
            $(this).next().hide();
        }
    }else if($(this).hasClass('question-item-id')){// 选项编号
        if(_questionnaireInfo.userdefine.itemid){
            input = $('<input style="width:100%;">');
            input.attr("type", "text");
            $(this).html(input);

            questionGuid = $(this).parents("[data-question-guid]").data('question-guid');
            itemGuid = $(this).parents('[data-item-guid]').data('item-guid');
        }
    }else if($(this).hasClass("matrix_row")){// 表格行
        input = $('<input style="width:100%;">');
        input.attr("type", "text");
        $(this).html(input);

        questionGuid = $(this).parents("[data-question-guid]").data('question-guid');
        rowGuid = $(this).parents("[data-row-guid]").data('row-guid');

        // 为表格行添加工具条
        var toolbar = '<div class="tool-bar">';
        toolbar += '<a class="btn btn-sm" title="上移表格行" onmousedown="moveRowUp(\''+questionGuid+'\', \''+rowGuid+'\')"><i class="fa fa-arrow-up"></i></a>';
        toolbar += '<a class="btn btn-sm" title="下移表格行" onmousedown="moveRowDown(\''+questionGuid+'\', \''+rowGuid+'\')"><i class="fa fa-arrow-down"></i></a>';
        toolbar += '<a class="btn btn-sm" title="删除表格行" onmousedown="deleteMatrixRow(\''+questionGuid+'\', \''+rowGuid+'\')"><i class="fa fa-trash"></i></a>';
        toolbar += '</div>';
        $(this).append(toolbar);
    }else if($(this).hasClass("matrix_row_number")){ // 行编号
        if(_questionnaireInfo.userdefine.rowid){
            input = $('<input style="width:100%;">');
            input.attr("type", "text");
            $(this).html(input);

            questionGuid = $(this).parents("[data-question-guid]").data('question-guid');
            rowGuid = $(this).parents("[data-row-guid]").data('row-guid');
        }
    }else if($(this).hasClass("matrix_col")){// 表格列
        input = $('<input style="width:100%;">');
        input.attr("type", "text");
        $(this).html(input);

        questionGuid = $(this).parents('[data-question-guid]').data('question-guid');
        colGuid = $(this).parents('[data-col-guid]').data('col-guid');

        // 为表格列添加工具条
        var toolbar = '<div class="tool-bar">';
        toolbar += '<a class="btn btn-sm" title="编辑列问题" onmousedown="editColQuestion(\''+questionGuid+'\', \''+colGuid+'\')"><i class="fa fa-edit"></i></a>';
        toolbar += '<a class="btn btn-sm" title="左移列问题" onmousedown="moveColLeft(\''+questionGuid+'\', \''+colGuid+'\')"><i class="fa fa-arrow-left"></i></a>';
        toolbar += '<a class="btn btn-sm" title="右移列问题" onmousedown="moveColRight(\''+questionGuid+'\', \''+colGuid+'\')"><i class="fa fa-arrow-right"></i></a>';
        toolbar += '<a class="btn btn-sm" title="删除列问题" onmousedown="deleteMatrixCol(\''+questionGuid+'\', \''+colGuid+'\')"><i class="fa fa-trash"></i></a>';
        toolbar += '</div>';
        $(this).append(toolbar);
    }else if($(this).hasClass("matrix_col_number")){// 列编号
        if(_questionnaireInfo.userdefine.colid){
            input = $('<input style="width:100%;">');
            input.attr("type", "text");
            $(this).html(input);

            questionGuid = $(this).parents("[data-question-guid]").data('question-guid');
            colGuid = $(this).parents('[data-col-guid]').data('col-guid');
        }
    }else if($(this).hasClass("col_item") && $(this).parents('.question').length > 0){// 一维表格列问题的选项
        input = $('<input style="width:100%;">');
        input.attr("type", "text");
        $(this).html(input);

        questionGuid=$(this).parents('[data-question-guid]').data('question-guid');
        itemGuid = $(this).parents('[data-item-guid]').data('item-guid');
        colGuid = $(this).parents('[data-col-guid]').data('col-guid');

        // 为选项添加工具条
        var toolbar = '<div class="tool-bar">';
        toolbar += '<a class="btn btn-sm" title="左移选项" onmousedown="moveColItemLeft(\''+questionGuid+'\', \''+itemGuid+'\',\''+colGuid+'\')"><i class="fa fa-arrow-left"></i></a>';
        toolbar += '<a class="btn btn-sm" title="右移选项" onmousedown="moveColItemRight(\''+questionGuid+'\', \''+itemGuid+'\',\''+colGuid+'\')"><i class="fa fa-arrow-right"></i></a>';
        toolbar += '<a class="btn btn-sm" title="删除选项" onmousedown="deleteColItem(\''+questionGuid+'\', \''+itemGuid+'\',\''+colGuid+'\')"><i class="fa fa-trash"></i></a>';
        toolbar += '</div>';
        $(this).append(toolbar);
    }else if($(this).hasClass("col_item") && $(this).parents('#settings').length > 0){// 多维表格列问题的选项
        input = $('<input style="width:100%;">');
        input.attr("type", "text");
        $(this).html(input);

        questionGuid=$("#settings #questionGuid").val();
        itemGuid = $(this).parents('[data-item-guid]').data('item-guid');
        colGuid=$("#settings #colGuid").val();

        // 为选项添加工具条
        var toolbar = '<div class="tool-bar">';
        toolbar += '<a class="btn btn-sm" title="上移选项" onmousedown="moveColItemUp(\''+questionGuid+'\', \''+itemGuid+'\',\''+colGuid+'\')"><i class="fa fa-arrow-up"></i></a>';
        toolbar += '<a class="btn btn-sm" title="下移选项" onmousedown="moveColItemDown(\''+questionGuid+'\', \''+itemGuid+'\',\''+colGuid+'\')"><i class="fa fa-arrow-down"></i></a>';
        toolbar += '<a class="btn btn-sm" title="删除选项" onmousedown="deleteColItem(\''+questionGuid+'\', \''+itemGuid+'\',\''+colGuid+'\')"><i class="fa fa-trash"></i></a>';
        toolbar += '</div>';
        $(this).append(toolbar);
    }else if($(this).hasClass("col_item_number") && $(this).parents('.question').length > 0){// 一维表格列问题选项的编号
        if(_questionnaireInfo.userdefine.itemid){
            input = $('<input style="width:100%;">');
            input.attr("type", "text");
            $(this).html(input);

            questionGuid=$(this).parents('[data-question-guid]').data('question-guid');
            itemGuid = $(this).parents('[data-item-guid]').data('item-guid');
            colGuid = $(this).parents('[data-col-guid]').data('col-guid');
        }
    }else if($(this).hasClass("col_item_number") && $(this).parents('#settings').length > 0){// 多维表格列问题选项的编号
        if(_questionnaireInfo.userdefine.itemid){
            input = $('<input style="width:100%;">');
            input.attr("type", "text");
            $(this).html(input);

            questionGuid=$("#settings #questionGuid").val();
            itemGuid = $(this).parents('[data-item-guid]').data('item-guid');
            colGuid=$("#settings #colGuid").val();
        }
    }

    if(input === undefined) {
        return false;
    }
    input.focus().val(text);
    // 自动调整textarea的大小
    autosize($('.description textarea'));
    autosize.update($('.description textarea'));
    $(this).removeClass('edit');
    $(this).addClass('editing');

    // 文本框失去焦点时，以文本框的内容替换文本框，然后保存更改的内容
    input.blur(function() {
        var inputText = $(this).val();

        $(this).parent().removeClass('editing');
        $(this).parent().addClass('edit');

        // 输入不能为空
        if (inputText.trim().length == 0) {
            $(this).parent().html(text);
            return;
        }

        // 当文本内容改变时，保存改变后的内容
        if (inputText != text) {
            if($(this).parent().hasClass('title')){// 问卷标题
                editQuestionnaireTitle(inputText);
            }else if($(this).parent().hasClass('description')){// 问卷描述
                inputText = inputText.replace(/\r/g,'').replace(/\n/g,'');
                editQuestionnaireDesc(inputText);
            }else if($(this).parent().hasClass('question-title-id')) {// 问题编号
                editQuestionId(questionGuid,inputText);
            }else if($(this).parent().hasClass('question-title-text')){// 问题标题
                editQuestionTitle(questionGuid,inputText);
            }else if($(this).parent().hasClass('question-item-text')){// 选项标题
                editItemTitle(questionGuid,itemGuid,inputText);
            }else if($(this).parent().hasClass('question-item-id')){// 选项编号
                editItemId(questionGuid,itemGuid,inputText);
            }else if($(this).parent().hasClass('matrix_row')){// 行标题
                editMatrixRowTitle(questionGuid,rowGuid,inputText);
            }else if($(this).parent().hasClass('matrix_row_number')){// 行编号
                editMatrixRowId(questionGuid,rowGuid,inputText);
            }else if($(this).parent().hasClass('matrix_col')){// 列标题
                editMatrixColTitle(questionGuid,colGuid,inputText);
            }else if($(this).parent().hasClass('matrix_col_number')){// 列编号
                editMatrixColId(questionGuid,colGuid,inputText);
            }else if($(this).parent().hasClass('col_item')){// 表格列选项标题
                editColItemTitle(questionGuid,colGuid,itemGuid,inputText);
            }else if($(this).parent().hasClass('col_item_number')){// 列选项编号
                editColItemId(questionGuid,colGuid,itemGuid,inputText);
            }
        }
        if($(this).parent().next().is('input:hidden')){
            $(this).parent().next().show();// 重现被隐藏的文本框
        }

        $(this).parent().html(inputText);
    });
}

// 上传资源文件
function readyToUploadResFile(qGuid, iGuid) { // 链接点击事件
    $('#uploadResFile').data('qGuid', qGuid);
    if(StringUtils.isNotBlank(iGuid)) { // 题干的资源文件
        $('#uploadResFile').data('iGuid', iGuid);
    }
    $('#uploadResFile').click();
}

function uploadResFile(_this) { // 文件域选择事件
    var file = $(_this)[0].files[0];  //FileList Objects
    $(_this).val('');

    var fileName = file.name.toLowerCase();
    var fileType = fileName.substr(fileName.lastIndexOf('.')+1);

    var resType = '';
    var resURL = '';

    if($.inArray(fileType, _supportImageType) > -1) {
        resType = 'img';
    } else if($.inArray(fileType, _supportAudioType) > -1) {
        resType = 'audio';
    } else if($.inArray(fileType, _supportVideoType) > -1) {
        resType = 'video';
    } else {
        alertBox('不支持的文件类型，系统目前只支持以下几种类型：<br>图像文件：'+_supportImageType.join('|')+'<br>音频文件：'+_supportAudioType.join('|')+'<br>视频文件：'+_supportVideoType.join('|'));
        return false;
    }

    if(StringUtils.isBlank(_questionnaireInfo.resuploadurl)) {
        alertBox('无法连接到服务器');
        return false;
    } else {
        var formData = new FormData();//构造空对象，下面用append 方法赋值
        formData.append("file", file);

        $.ajax({
            url : _questionnaireInfo.resuploadurl,
            type : 'POST',
            async: false,
            data : formData,
            processData : false,
            contentType : false,
            success: function(result) {
                if(result.success) {
                    resURL = result.msg;
                } else {
                    alertBox(result.msg);
                }
            },
            error: function() {
                alertBox("上传资源文件时遇到问题");
            }
        });
    }

    if(StringUtils.isBlank(resURL)) {
        return false;
    } else {
        var qGuid = $(_this).data('qGuid');
        var iGuid = $(_this).data('iGuid');
        var question = getQuestionByGuid(qGuid, _questionMap);

        if(StringUtils.isBlank(iGuid)) { // 题干的资源文件
            question.restype = resType;
            question.resurl = resURL;
        } else { // 选项的资源文件
            var qItem = getItemByGuid(question, iGuid);
            qItem.restype = resType;
            qItem.resurl = resURL;
        }
        refreshQuestionnaire();
    }
}

function removeResFile(qGuid, iGuid) {
    var question = getQuestionByGuid(qGuid, _questionMap);
    var fileName = '';
    if(StringUtils.isBlank(iGuid)) { // 题干的资源文件
        fileName = question.resurl.substr(question.resurl.lastIndexOf('/')+1);
        question.restype = '';
        question.resurl = '';
    } else { // 选项的资源文件
        var qItem = getItemByGuid(question, iGuid);
        fileName = qItem.resurl.substr(qItem.resurl.lastIndexOf('/')+1);
        qItem.restype = '';
        qItem.resurl = '';
    }
    refreshQuestionnaire();

    $.post(_questionnaireInfo.resremoveurl, {
        fileName: fileName
    });
}

function toastInfoMessage(msg) {
    toastr.clear();
    toastr.info(msg);
}

function toastErrorMessage(msg) {
    toastr.clear();
    toastr.error(msg);
}
