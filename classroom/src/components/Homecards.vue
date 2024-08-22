<script setup>
    import Card from '@/components/Card.vue'
    import { RouterLink } from 'vue-router';
</script>

<template>
     <section class="py-4">
      <div class="container-xl lg:container m-auto">
        <div class="grid grid-cols-1 md:grid-cols-2 gap-4 p-4 rounded-lg">
          <div class="bg-gray-100 p-6 rounded-lg shadow-md">
            <h2 class="text-2xl font-bold">Para Docentes</h2>
            <p class="mt-2 mb-4">
              visualizar salas e laboratórios
            </p>
            <RouterLink
              to='/jobs'
              class="inline-block bg-black text-white rounded-lg px-4 py-2 hover:bg-gray-700"
            >
              ver salas
            </RouterLink>
          </div>
          <div class="bg-green-100 p-6 rounded-lg shadow-md">
            <h2 class="text-2xl font-bold">Para Administradores</h2>
            <p class="mt-2 mb-4">
              Adicionar salas e laboratórios.
            </p>
            <RouterLink
              to='/jobs/add'
              class="inline-block bg-green-500 text-white rounded-lg px-4 py-2 hover:bg-green-600"
            >
              Adicionar
            </RouterLink>
          </div>
        </div>
      </div>
    </section>
</template>