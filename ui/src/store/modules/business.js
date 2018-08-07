import Vue from 'vue'
import store from '../index.js'

const state = {
    systemList: [],
    jobList: [],
    taskList: [],
    system: {},
    job: {},
    task: {},
    package: {},
    nodeList: [],
    node: {},
    eventList: [],
    event: {},
    ruleList: [],
    rule: {}
};

const mutations = {
    SET_SYSTEM_LIST(state, data) {
        state.systemList = data;
    },
    SET_SYSTEM(state, system) {
        state.system = system;
    },
    SET_JOB(state, job) {
        state.job = job;
    },
    UPDATE_BUSINESS_BY_NAME(state, nameAndValue) {
        Vue.set(state, nameAndValue.name, nameAndValue.value);
    }
};

export default {
    state,
    mutations
}

