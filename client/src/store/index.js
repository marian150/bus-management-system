import { createStore } from 'vuex'
import clientsModule from './clients/index.js'
import employeesModule from './clients/index.js'
import ticketsModule from './tickets/index.js'

const store = createStore({
  modules: {
    clients: clientsModule,
    employees: employeesModule,
    tickets: ticketsModule,
  },
})

export default store
