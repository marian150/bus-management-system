import { createRouter, createWebHistory } from 'vue-router'
import ReservationPage from './pages/ReservationPage.vue'
import InfoPage from './pages/InfoPage.vue'
import SearchPage from './pages/SearchPage.vue'

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
  ],
})

export default router
