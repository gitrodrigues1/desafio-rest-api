import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CitiesView from '../views/CitiesView.vue';
import CustomersView from '../views/CustomersView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/cities',
      name: 'cities',
      component: CitiesView
    },
    {
      path: '/customers',
      name: 'customers',
      component: CustomersView
    }
  ]
})

export default router
