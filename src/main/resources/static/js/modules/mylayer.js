layui.define(['jquery', 'layer'], function (exports) {
  var $ = layui.jquery;
  var layer = layui.layer;
  var object = {
    open: function (title) {
      layer.open({
        type: 1,
        skin: 'layui-layer-molv',
        title: title,
        area: ['400px', '450px'],
        shade: 0,
        shadeClose: false,
        content: $('#layerSelect'),
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
    },
  };
  //输出接口
  exports('mylayer', object);
});

// var comLayer = function (layer, title, divBase, eleTitle, ele) {
//   //组件弹出后,设置底层div不可用
//   var v = '.' + divBase + ' *';
//   $(v).attr('disabled', true);
//   var eleT = '.' + divBase + ' input[name=' + eleTitle + ']';
//   var eleV = '.' + divBase + ' input[name=' + ele + ']';
//   //弹出组件设置
//   layer.open({
//     type: 1,
//     skin: 'layui-layer-molv',
//     title: title,
//     area: ['400px', '450px'],
//     shade: 0,
//     shadeClose: false,
//     content: jQuery('#layerSelect'),
//     btn: ['确定', '取消'],
//     yes: function (index) {
//       if (typeof selectNode !== 'undefined' && selectNode != null) {
//         $(eleT).val(selectNode.data.title);
//         $(eleV).val(selectNode.data.field);
//         selectNode = null;
//         layer.close(index);
//         //解除DIV不可用
//         $(v).attr('disabled', false);
//       } else {
//         layer.msg('未选择数据,请重新选择,或取消!');
//       }
//     },
//     btn2: function () {
//       //解除DIV不可用
//       $(v).attr('disabled', false);
//     },
//     cancel: function () {
//       //解除DIV不可用
//       $(v).attr('disabled', false);
//     },
//   });
// };
