import store from '../index.js'

const state = {
    logs: []
}

const mutations = {
    GETLOGS(state, data) {
        state.logs = data
    },
    CLEARLOGS(state) {
        state.logs = []
    }
}

export default {
    state,
    mutations
}
