// 注册单选
import Vue from 'vue'
Vue.component('single-select', {
    props: ['optionsdata', 'selecteddata'],
    data: function () {
        var data = {
            originOptions: [],
            displayOptions: [],
            show: false,
            search: '',
            selected: {
                id: "",
                name: ""
            }
        }
        return data
    },
    computed: {},
    ready: function () {
        window.addEventListener('click', this.blur)
    },
    watch: {
        optionsdata: function (val, oldVal) {
            this.originOptions = val;
            this.show = false;
            // 默认值
            if (this.selected.id == '') {
                this.selected = this.originOptions[0];
            }
        },
        selecteddata: function (val, oldVal) {
            this.selected = val
        }
    },

    methods: {
        singleFocus: function () {
            if (!this.show) {
                document.body.click();
                console.log('single show')
                this.show = true;
                this.singleSearch();
                this.searchInputFocus();
            }
            else {
                this.blur();
            }
        },
        searchInputFocus: function () {
            // var searchInput = this.$el.getElementsByClassName('search-input')[0];
            //
            // this.$nextTick(function () {
            //   searchInput.focus();
            // })

        },
        singleSelect: function (id) {
            var mySelf = this;
            var displayOptions = mySelf.displayOptions;
            for (var i = 0; i < displayOptions.length; i++) {
                var item = displayOptions[i]
                //在展示数组里找 找到后1.添加到selected
                if (item.id == id) {
                    var selected = mySelf.selected;
                    selected.id = item.id
                    selected.name = item.name
                }
            }
            mySelf.show = false;
            this.search = '';
        },
        singleSearch: function () {
            var mySelf = this;
            var search = mySelf.search;
            var REG_RULE = new RegExp(search, "i") //根据用户输入值做正则
            var originOptions = mySelf.originOptions;
            //将展示列表置空 然后用正则去原始列表中匹配
            mySelf.displayOptions = [];

            //console.log('搜索的内容是' + search)
            for (var i = 0; i < originOptions.length; i++) {
                var item = originOptions[i]
                if (REG_RULE.test(item.name)) {
                    mySelf.displayOptions.push(item)
                }
            }
        },
        blur: function () {
            console.log('hide single！！')
            this.show = false;
            this.search = '';
        }
    },
    template: '<div class="functional-select-wrapper" v-on:click.stop="singleFocus()">' +
    '<label class="display-container clearfix" v-bind:class="(show)?\'single-selected-focus\':\'\'">' +
    '<p v-show="selected.id == \'\' ">' +
    '<span v-if="originOptions.length != 0 ">请选择</span>' +
    '<span v-else>没有选项</span>' +
    '</p>' +
    '<p class="single-selected">{{ selected.name }}</p>' +
    '<i class="drop" v-bind:class="(show)?\'drop-up\':\'\'">▼</i>' +
    '</label>' +
    '<div class="options-container" v-show="show">' +
    '<ul class="options-ul-list">' +
    '<li v-show="displayOptions.length == 0">没有查询到数据</li>' +
    '<li v-for="item in displayOptions" v-on:click.stop.prevent="singleSelect(item.id)" v-bind:class=" (item.id == selected.id)?\'selected\':\'\' ">{{ item.name }}</li>' +
    '</ul>' +
    '</div>' +
    '</div>'

})

// 注册多选
Vue.component('multiple-select', {
    props: ['optionsdata', 'selecteddata'],
    data: function () {
        var data = {
            originOptions: [],
            displayOptions: [],
            show: false,
            search: '',
            selectedList: [],
            selectedIdList: []
        }
        return data
    },
    computed: {},
    ready: function () {
        window.addEventListener('click', this.blur)
    },
    watch: {
        optionsdata: function (val, oldVal) {
            this.show = false;
            this.originOptions = val;
        },
        selecteddata: function (val, oldVal) {
            this.selectedList = val;
            this.selectedIdList = [];
            for (var i = 0; i < this.selectedList.length; i++) {
                var item = this.selectedList[i];
                this.selectedIdList.push(item.id);
            }
        }

    },

    methods: {
        multipleFocus: function () {
            if (!this.show) {
                document.body.click();
                console.log('multiple show');
                this.show = true;
                this.multipleSearch();
                this.searchInputFocus();
            }
            else {
                this.blur();
            }
        },
        searchInputFocus: function () {
            // var searchInput = this.$el.getElementsByClassName('search-input')[0];
            //
            // this.$nextTick(function () {
            //   searchInput.focus();
            // })

        },
        multipleSelect: function (id) {
            var mySelf = this;
            var displayOptions = mySelf.originOptions;
            var selectedList = mySelf.selectedList;
            var selectedIdList = mySelf.selectedIdList;
            if (selectedIdList.indexOf(id) != -1) {
                mySelf.multipleRemove(id);
                return;
            }

            for (var i = 0; i < displayOptions.length; i++) {
                var item = displayOptions[i]
                if (item.id == id) {
                    selectedList.push(item);
                    selectedIdList.push(id);
                    mySelf.multipleInitSearch();
                    mySelf.multipleSearch();
                    mySelf.dispatchData();
                    mySelf.searchInputFocus();
                }
            }

        },
        dispatchData: function () {
            // console.log('派发！！');
            // this.$dispatch('selected', this.selectedList);
        },
        multipleRemove: function (id) {
            console.log('删除！' + id)
            var mySelf = this;
            var selectedList = mySelf.selectedList;
            var selectedIdList = mySelf.selectedIdList;
            for (var i = 0; i < selectedList.length; i++) {
                var item = selectedList[i]
                if (item.id == id) {
                    //1.从selectedList中删除 2.从selectedIdList中删除
                    selectedList.splice(i, 1);
                    var index = selectedIdList.indexOf(item.id)
                    selectedIdList.splice(index, 1)
                    mySelf.multipleInitSearch();
                    mySelf.multipleSearch();
                    mySelf.dispatchData();
                    mySelf.searchInputFocus();
                    return;
                }
            }
        },
        multipleSearch: function (event) {
            var mySelf = this;
            var search = mySelf.search;
            var REG_RULE = new RegExp(search, "i") //根据用户输入值做正则

            var originOptions = mySelf.originOptions;
            var displayOptions = mySelf.displayOptions;

            // 通过回车键 添加
            if (event && event.keyCode == 13 && search != '' && originOptions.length > 0) {
                console.log('回车！');
                console.log('通过回车添加的值' + search);

                for (var i = 0; i < originOptions.length; i++) {
                    var item = originOptions[i]
                    if (item.name == search) {
                        mySelf.multipleSelect(item.id);
                        return;
                    }
                    else if (i == (originOptions.length - 1)) {
                        alert('不存在的选项！');
                        return;
                    }
                }
            }

            //将展示列表置空 然后用正则去原始列表中匹配
            mySelf.displayOptions = [];
            //正则表达 匹配搜索字符
            for (var i = 0; i < originOptions.length; i++) {
                var item = originOptions[i]
                if (REG_RULE.test(item.name)) {
                    mySelf.displayOptions.push(item)
                    // console.log(JSON.stringify(item))
                }
            }
            // console.log(JSON.stringify(mySelf.multiple.displayOptions))
        },
        multipleInitSearch: function () {
            var mySelf = this;
            //重置搜索框 1.清空搜索数据 2.下拉框展示全量
            mySelf.search = '';
        },
        blur: function () {
            console.log('hide multiple！！')
            this.show = false;
            this.search = '';
        }

    },
    template: '<div class="functional-select-wrapper" v-on:click.stop="multipleFocus()">' +
    '<label class="display-container multiple-select-container clearfix" v-bind:class="(show)?\'single-selected-focus\':\'\'">' +
    '<p v-show="selectedList.length == 0 ">' +
    '<span v-if="originOptions.length != 0 ">请选择</span>' +
    '<span v-else>没有选项</span>' +
    '</p>' +
    '<p class="multiple-selected-item" v-for="item in selectedList" track-by="$index">{{ item.name }}<i v-on:click.stop.prevent="multipleRemove(item.id)">×</i></p>' +
    '<i class="drop" v-bind:class="(show)?\'drop-up\':\'\'">▼</i>' +
    '</label>' +
    '<div class="options-container" v-show="show">' +
    '<div class="search-container">' +
    '<input placeholder="search here" class="search-input" v-model="search" v-on:keyup="multipleSearch($event)" v-on:click.stop />' +
    '</div>' +
    '<ul class="options-ul-list">' +
    '<li v-show="displayOptions.length == 0">没有查询到数据</li>' +
    '<li v-for="item in displayOptions" v-on:click.stop.prevent="multipleSelect(item.id)" v-bind:class=" selectedIdList.indexOf(item.id)!=-1?\'selected\':\'\' ">{{ item.name }}</li>' +
    '</ul>' +
    '</div>' +
    '</div>'
})
