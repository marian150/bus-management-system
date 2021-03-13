import getters from './getters.js'
import actions from './actions.js'
import mutations from './mutations.js'

export default {
  namespaced: true,
  state() {
    return {
      tickets: [
        {
          employee: {
            name: 'Sadio',
            phone: '5555555555',
          },
          client: {
            name: 'Yana',
            phone: '666666666',
          },
          resDate: new Date('2020-03-25'),
          travelDate: new Date('2020-03-30'),
          schedule: {
            day: 2,
            time: new Date().getHours(),
            price: 25,
            destination: 'Burgas',
          },
        },
        {
          employee: {
            name: 'Jurgen',
            phone: '1414141414',
          },
          client: {
            name: 'Yana',
            phone: '79797979797',
          },
          resDate: new Date('2020-04-02'),
          travelDate: new Date('2020-04-10'),
          freePlaces: 4,
          schedule: {
            day: 5,
            time: new Date().getHours(),
            price: 15,
            destination: 'Burgas',
          },
        },
        {
          employee: {
            name: 'Jurgen',
            phone: '1414141414',
          },
          client: {
            name: 'Sadio',
            phone: '79797979797',
          },
          resDate: new Date('2020-05-02'),
          travelDate: new Date('2020-05-10'),
          freePlaces: 8,
          schedule: {
            day: 5,
            time: new Date().getHours(),
            price: 15,
            destination: 'Burgas',
          },
        },
      ],
    }
  },
  getters,
  actions,
  mutations,
}
