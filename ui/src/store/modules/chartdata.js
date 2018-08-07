import store from '../index.js'

const state = {
  chartData: []
}

const mutations = {
  GETCHARTDATA(state, data) {
    state.chartData = data
  },
  CLEARCHARTDATA(state) {
    state.chartData = []
  }
}

export default {
  state,
  mutations
}
