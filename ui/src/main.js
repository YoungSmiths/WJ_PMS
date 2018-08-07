// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Breadcrumbs from './router/Breadcrumbs.js'
import Vue from 'vue'
import VueBreadcrumbs from 'vue-breadcrumbs'
import App from './components/App.vue'
import router from './router'
import store from './store'
import appConfig from './config'
import Message from './components/Message.vue'
import FiltersAndDirectives from './plugins/FiltersAndDirectives'


import $ from 'jquery'
window.$ = $;
import 'datatables'
import 'datatables/media/css/jquery.dataTables.css'
import './components/App.css'

var echarts = require('echarts');
import './plugins/validation.js'
var isProduction = (process.env.NODE_ENV === 'production');
Vue.config.devtools = false;

Vue.prototype.appConfig = appConfig;
Vue.prototype.$message = Message;

Vue.prototype.appConfig.domain = location.protocol + '//' + location.host;
Vue.prototype.appConfig.apiBase = (isProduction ? appConfig.domain : '');
// Vue.prototype.appConfig.apiBase = (isProduction ? appConfig.domain : 'http://localhost:3000');
Vue.prototype.apiBase = Vue.prototype.appConfig.apiBase;

Vue.use(VueBreadcrumbs, Breadcrumbs);
Vue.use(FiltersAndDirectives);

router.beforeEach(function (to, from, next) {
    if (store.state.user.token === 'login' || to.name === 'home') {
        next()
    } else if (to.name !== 'home') {
        router.push('/home')
        Vue.prototype.$message.alert('请先登录！');
        next();
    } else {
        next();
    }
});

/* eslint-disable no-new */
new Vue({
    el: '#app',
    store: store,
    router: router,
    render: h => h(App),
    template: '<App/>',
    beforeCreate () {
    },
    created () {
        window.vue = this;
        // this.checkToken();
    },
    methods: {
        checkToken () {
            if (!window.localStorage.getItem('token')) {
                this.$router.push('/')
                this.$store.dispatch('clearToken')
                // this.$store.dispatch('clearApplications')

                return;
            }
            let param = {
                token: this.$store.state.user.token
            }
            $.ajax({
                url: Vue.prototype.appConfig.apiBase + `api/user/checkCurrentToken/${new Date().valueOf()}`,
                type: 'POST',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(param),
                cache: false,
                async: false,
                success: (data) => {
                    if (data.code !== 0) {
                        if (this.$route.path !== '/') {
                            this.$router.push('/')
                            this.$message.alert('登陆超时！')
                        }
                        this.$store.dispatch('clearToken')
                        // this.$store.dispatch('clearApplications')
                    }
                },
                error: (data) => {
                    if (this.$route.path !== '/') {
                        this.$router.push('/')
                        this.$message.alert('登陆超时！')
                    }
                    this.$store.dispatch('clearToken')
                    // this.$store.dispatch('clearApplications')
                }
            })
        }
    },
    components: {App}
})
