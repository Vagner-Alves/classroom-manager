<script setup>
import { RouterLink } from 'vue-router';
</script>

<template>
      
    <section>
        <div class="flex justify-center items-center mt-52">
    <div class="w-full max-w-xs">
      <form class="bg-green-700 shadow-md rounded px-8 pt-6 pb-8 mb-4">
        <div class="identity-input mb-4">
          <label
            for="identity"
            class="block text-white text-sm font-bold mb-2"
          >
            Email</label
          >
          <input
            id="identity"
            class="shadow appearance-none borderrounded w-full py-2 px-3 text-green-900 mb-3 leading-tight focus:outline-none focus:shadow-outline"
            type="text"
            placeholder="Email"
            aria-describedby="emailHelp"
            v-model="email"
          />
          <span class="text-xs text-red-700" id="emailHelp"></span>
        </div>

        <div class="password-input mb-6">
          <label
            for="identity"
            class="block text-white text-sm font-bold mb-2"
            >Senha</label
          >

          <input
            aria-describedby="passwordHelp"
            v-model="password"

            class="shadow appearance-none borderrounded w-full py-2 px-3 text-green-900 mb-3 leading-tight focus:outline-none focus:shadow-outline"
            id="password"
            type="password"
            placeholder="*******"
          />

          <span class="text-xs text-red-700" id="passwordHelp"></span>
        </div>

        <div class="flex items-center justify-between">
          <RouterLink to="/"
            class="bg-green-900 hover:bg-black text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            type="submit"
          >
            Entrar
          </RouterLink>
          <a
            class="inline-block align-baseline font-bold text-sm text-white hover:text-blue-800"
            href="#"
          >
            criar conta
          </a>
        </div>
      </form>
    </div>
  </div>

        
    </section>
</template>