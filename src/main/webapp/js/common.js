document.writeln("<script src=\"../../common/jquery/jquery-v.3.3.1.js\"></script>")
document.writeln("<script src=\"../../common/Popper.js\"></script>")
document.writeln("<script src=\"../../common/bootstrap-4.0.0-dist/js/bootstrap.js\"></script>")
document.writeln("<script src=\"../../common/bootstrap-table-v1.12.1/bootstrap-table.js\"></script>")

/**
 * 日志
 * @param a
 */
function log(a){
    console.log(a)
}

/*
* type              请求的方式  默认为get
* url               发送请求的地址
* param             发送请求的参数
* isShowLoader      是否显示loader动画  默认为false
* dataType          返回JSON数据  默认为JSON格式数据
* callBack          请求的回调函数
*/
(function(){
    function AjaxRequest(opts){
        this.type         = opts.type || "get";
        this.url          = opts.url;
        this.param        = opts.param || {};
        this.isShowLoader = opts.isShowLoader || false;
        this.dataType     = opts.dataType || "json";
        this.callBack     = opts.callBack;
        this.init();
    }

    AjaxRequest.prototype = {
        //初始化
        init: function(){
            this.sendRequest();
        },
        //渲染loader
        showLoader: function(){
            if(this.isShowLoader){
                var loader = '<div class="ajaxLoader"><div class="loader">加载中...</div></div>';
                $("body").append(loader);
            }
        },
        //隐藏loader
        hideLoader: function(){
            if(this.isShowLoader){
                $(".ajaxLoader").remove();
            }
        },
        //发送请求
        sendRequest: function(){
            var self = this;
            $.ajax({
                type: this.type,
                url: this.url,
                data: this.param,
                dataType: this.dataType,
                beforeSend: this.showLoader(),
                success: function(res){
                    self.hideLoader();
                    if (res != null && res != "") {
                        if(self.callBack){
                            if (Object.prototype.toString.call(self.callBack) === "[object Function]") {   //Object.prototype.toString.call方法--精确判断对象的类型
                                self.callBack(res);
                            }else{
                                log("callBack is not a function");
                            }
                        }
                    }
                }
            });
        }
    };
    window.AjaxRequest = AjaxRequest;
})();