/*
  通用组件类
  对layui标准组件的二次封装
  李竞 2021-04-20
*/
// 数据选择树形组件
var comTree = function (tree, data) {
  tree.render({
    id: 'dictTree',
    elem: '#layerSelect',
    data: data,
    onlyIconControl: true,
    click: function (obj) {
      selectNode = obj;
      layer.msg(JSON.stringify(selectNode.data.title));
    },
  });
};

var comTree = function (tree, data) {
  tree.render({
    id: 'dictTree',
    elem: '#layerSelect',
    data: data,
    onlyIconControl: true,
    click: function (obj) {
      selectNode = obj;
      layer.msg(JSON.stringify(selectNode.data.title));
    },
  });
};

//数据选择组件弹出
var comLayer = function (layer, title, divBase, eleTitle, ele) {
  //组件弹出后,设置底层div不可用
  var v = '.' + divBase + ' *';
  $(v).attr('disabled', true);
  var eleT = '.' + divBase + ' input[name=' + eleTitle + ']';
  var eleV = '.' + divBase + ' input[name=' + ele + ']';
  //弹出组件设置
  layer.open({
    type: 1,
    skin: 'layui-layer-molv',
    title: title,
    area: ['400px', '450px'],
    shade: 0,
    shadeClose: false,
    content: jQuery('#layerSelect'),
    btn: ['确定', '取消'],
    yes: function (index) {
      if (typeof selectNode !== 'undefined' && selectNode != null) {
        $(eleT).val(selectNode.data.title);
        $(eleV).val(selectNode.data.field);
        selectNode = null;
        layer.close(index);
        //解除DIV不可用
        $(v).attr('disabled', false);
      } else {
        layer.msg('未选择数据,请重新选择,或取消!');
      }
    },
    btn2: function () {
      //解除DIV不可用
      $(v).attr('disabled', false);
    },
    cancel: function () {
      //解除DIV不可用
      $(v).attr('disabled', false);
    },
  });
};
//删除确认组件
var tipDialog = function (id, name) {
  layer.open({
    content: '确定要删除' + name + '发送接口吗?',
    yes: function (index, layero) {
      layer.close(index); //如果设定了yes回调，需进行手工关闭
      CoreUtil.sendDelete('/esb/sender', id, function (res) {
        layer.msg(res.msg);
        search();
      });
    },
  });
};
//穿梭框组件
var initTransfer = function (data) {
  transfer.render({
    elem: '#roles',
    data: data.allRole,
    title: ['赋予角色', '拥有角色'],
    showSearch: true,
    value: data.ownRoles,
    id: 'ownData',
    parseData: function (res) {
      return {
        value: res.id, //数据值
        title: res.name, //数据标题
      };
    },
  });
};
