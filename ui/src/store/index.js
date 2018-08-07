import Vue from 'vue';
import Vuex from 'vuex';
import * as actions from './actions.js'
import * as getters from './getters'
import user from './modules/user.js'
import business from './modules/business.js'
import chartdata from './modules/chartdata.js'
import logs from './modules/logs'
Vue.use(Vuex)

export default new Vuex.Store({
    actions,
    getters,
    modules: {
        user,
        business,
        chartdata,
        logs  
    }
})
