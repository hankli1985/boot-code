/*
  通用组件类
  对layui标准组件的二次封装
  李竞 2021-04-20
*/
// 数据选择树形组件
layui.define(['tree'], function (exports) {
  var tree = layui.tree;
  var object = {
    open: function (data) {
      // console.log('sssssss');
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
    },
  };
  //输出接口
  exports('mytree', object);
});
