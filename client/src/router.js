import { createRouter, createWebHistory } from 'vue-router'
import ReservationPage from './pages/ReservationPage.vue'
import InfoPage from './pages/InfoPage.vue'
import SearchPage from './pages/SearchPage.vue'
import AddDataPage from './pages/AddDataPage.vue'
import DeleteDataPage from './pages/DeleteDataPage.vue'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      redirect: '/reservation',
    },
    {
      path: '/reservation',
      component: ReservationPage,
    },
    {
      path: '/info',
      component: InfoPage,
    },
    {
      path: '/search',
      component: SearchPage,
    },
    {
      path: '/add',
      component: AddDataPage,
    },
    {
      path: '/delete',
      component: DeleteDataPage,
    },
  ],
})

export default router
