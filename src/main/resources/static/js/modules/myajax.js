layui.define(['jquery', 'layer'], function (exports) {
  var $ = layui.jquery;
  var layer = layui.layer;
  var sendAJAX = function (url, params, rollback, method) {
    $.ajax({
      url: url,
      cache: false,
      async: true,
      data: params,
      type: method,
      contentType: 'application/json; charset=UTF-8',
      dataType: 'json',
      headers: {
        authorization: layui.data('LocalData').access_token,
      },
      success: function (res) {
        if (res.code == 0 && res.data != undefined) {
          rollback(res);
        } else if (res.code == 0 && res.data == undefined) {
          layer.msg(res.msg, { time: 2000 });
          rollback(res);
        } else {
          layer.msg(res.msg, { time: 2000 });
        }
      },
      error: function (XMLHttpRequest, textStatus, errorThrown) {
        if (XMLHttpRequest.status == 404) {
          top.window.location.href = '/index/404';
        } else {
          layer.msg('服务器好像除了点问题！请稍后试试');
        }
      },
    });
  };
  var object = {
    sendget: function (url, params, ft) {
      sendAJAX(url, params, ft, 'GET');
    },
    sendpost: function (url, params, ft) {
      sendAJAX(url, JSON.stringify(params), ft, 'POST');
    },
    sendput: function (url, params, ft) {
      sendAJAX(url, JSON.stringify(params), ft, 'PUT');
    },
    senddel: function (url, params, ft) {
      sendAJAX(url, JSON.stringify(params), ft, 'DELETE');
    },
  };
  //输出接口
  exports('myajax', object);
});
