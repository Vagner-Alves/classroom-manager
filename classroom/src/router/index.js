import {createRouter, createWebHistory} from 'vue-router';

import HomeView from '@/views/HomeView.vue';

createRouter = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL)

})