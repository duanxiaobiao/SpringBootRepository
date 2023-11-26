

function initTaskList(baseHost) {
    $.ajax({
        url: baseHost + "/task/list",
        type: "GET",
        dataType: "json",
        success: function (data) {
            if (data.code !== 200) {
                console.log("任务列表接口调用失败");
                return;
            }
            $("#task-list-container tbody tr").remove();
            var currentUser = "'" + document.URL.split("?userId=")[1] + "'";
            var taskList = data.data;
            for (var i = 0; i < taskList.length; i++) {
                var task = taskList[i];
                var taskId = "'" + task['taskId'] + "'";
                var tableTr = $("<tr " + task["taskId"] + ">\n" +
                    "                <th>"+ task["taskId"] +"</th>\n" +
                    "                <th>"+ task["taskName"] +"</th>\n" +
                    "                <th>"+ task["total"] +"</th>\n" +
                    "                <th>"+ task["status"] +"</th>\n" +
                    "                <th>"+ task["progress"] + "%" +"</th>\n" +
                    "                <th>"+ task["createUserId"] +"</th>\n" +
                    "                <th>"+ task["createTime"] +"</th>\n" +
                    "                <th>"+ task["updateTime"] +"</th>\n" +
                    "                <th><button type=\"button\" class=\"btn btn-info\" " +
                    "                   onclick=startTask(" + taskId + "," + currentUser  + ")>启动任务</button>" +
                    "               </th>\n" +
                    "            </tr>");
                $("#task-list-container table").append(tableTr);
            }
        }
    });
}


// 启动任务
function startTask(taskId, currentUser) {
    $.ajax({
        type: "POST",
        url: "/task/start",
        data: {
            taskId: taskId,
            "currentUser": currentUser
        },
        success: function (data) {
            if (data.code != 200) {
                cocoMessage.error("任务启动失败！", 2000);
                return;
            }
            cocoMessage.success("任务启动成功！", 2000);
        }
    })
};