import getters from './getters.js'
import actions from './actions.js'
import mutations from './mutations.js'

export default {
  namespaced: true,
  state() {
    return {
      clients: [
        {
          name: 'Yana',
          phone: '1111111111',
        },
        {
          name: 'Mariyan',
          phone: '2222222222',
        },
      ],
    }
  },
  getters,
  actions,
  mutations,
}
