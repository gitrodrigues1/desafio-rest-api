<script setup>
import { RouterLink, RouterView } from 'vue-router'
import { useStore } from 'vuex';
import Navbar from './components/Navbar.vue'


</script>

<template>
  <header>
    
    <Navbar />

  </header>

  <RouterView />
</template>

