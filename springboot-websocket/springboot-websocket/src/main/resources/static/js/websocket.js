function init(baseHost, webSocketUrl) {
    openWebSocket(baseHost, webSocketUrl);
    initTaskList(baseHost);
}


var websocket = null;

function openWebSocket(baseHost, webSocketUrl) {
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket(webSocketUrl);
    } else {
        cocoMessage.success('当前浏览器 Not support websocket', 3000)
    }
    //连接发生错误的回调方法
    websocket.onerror = function() {
        setMessageInnerHTML("WebSocket连接发生错误");
    };
    //连接成功建立的回调方法
    websocket.onopen = function() {
        cocoMessage.success("WebSocket连接成功", 3000);
    }
    //接收到消息的回调方法
    websocket.onmessage = function(event) {
        var resultJson = JSON.parse(event.data);
        if (resultJson.type !== 'title') {
            initTaskList(baseHost);
            return;
        }
        setMessageInnerHTML(resultJson.message);
    }
    //连接关闭的回调方法
    websocket.onclose = function() {
        console.log("WebSocket连接关闭");
    }
}


//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function() {
    closeWebSocket();
}
//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    // cocoMessage.success(innerHTML, 3000);
    toastr.success(innerHTML);
}
//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}