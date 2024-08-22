<script setup>
import PulseLoader from 'vue-spinner/src/PulseLoader.vue';
import {reactive, onMounted} from 'vue';
import BackButton from '@/components/BackButton.vue';
import { useRoute, RouterLink , useRouter} from 'vue-router';
import { useToast } from 'vue-toastification';
import axios from 'axios';

const route = useRoute();
const router = useRouter();
const toast = useToast();
const jobId = route.params.id;

const state = reactive({
  job: {},
  isLoading: true
});

const deleteJob = async() =>{
  try {

     const confirm = window.confirm('Tem certeza que quer deletar esse recurso ?');
     if (confirm){
        await axios.delete(`/api/jobs/${jobId}`);
        toast.success('Recurso Deletado');
        router.push('/jobs');

     }
    

  } catch (error) {
    console.error('erro ao deletar', error);
    toast.error('não foi deletado');
    
  }
}

onMounted(async () => {
        try {
           const response = await axios.get(`/api/jobs/${jobId}`);
            state.job = response.data;
        } catch (error) {
            console.error('Error Fetching the data', error);
        } finally {
            state.isLoading =  false;
        }
    });


</script>

<template>
    <BackButton></BackButton>
    <section v-if="!state.isLoading" class="bg-green-50">
      <div class="container m-auto py-10 px-6">
        <div class="grid grid-cols-1 md:grid-cols-70/30 w-full gap-6">
          <main>
            <div
              class="bg-white p-6 rounded-lg shadow-md text-center md:text-left"
            >
              <div class="text-gray-500 mb-4">{{ state.job.type }}</div>
              <h1 class="text-3xl font-bold mb-4"> {{  state.job.title }}</h1>
              <div
                class="text-gray-500 mb-4 flex align-middle justify-center md:justify-start"
              >
                <i
                  class="pi pi-map-marker text-lg text-orange-700 mr-2"
                ></i>
                <p class="text-orange-700">{{ state.job.location }}</p>
              </div>
            </div>

            <div class="bg-white p-6 rounded-lg shadow-md mt-6">
              <h3 class="text-green-800 text-lg font-bold mb-6">
                Descrição
              </h3>

              <p class="mb-4">
                {{ state.job.description }}
              </p>

              
            </div>
          </main>

          <!-- Sidebar -->
          <aside>
            <!-- Company Info -->
            <div class="bg-white p-6 rounded-lg shadow-md">
              <h3 class="text-xl font-bold mb-6">Recursos Disponíveis</h3>

              <h2 class="text-2xl">{{ state.job.company.name }}</h2>

              <p class="my-2">
                {{ state.job.company.description }}
              </p>

              <hr class="my-4" />

              <p class="my-2 bg-green-100 p-2 font-bold">
                
              </p>
              <p class="my-2 bg-green-100 p-2 font-bold"> </p>
            </div>

            <!-- Manage -->
            <div class="bg-white p-6 rounded-lg shadow-md mt-6">
              <h3 class="text-xl font-bold mb-6">Gerenciar sala</h3>

              <button 
                class="bg-blue-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block"
              >
                Reservar
              </button>
              <RouterLink
            :to="`/jobs/edit/${state.job.id}`"
                class="bg-green-500 hover:bg-green-600 text-white text-center font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block"
                >Editar</RouterLink
              >
              <button @click="deleteJob"
                class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block"
              >
                Deletar
              </button>
            </div>
          </aside>
        </div>
      </div>
    </section>
    <div v-else="state.isLoading" class="text-center text-gray-500 py-6">
        <PulseLoader />
      </div>
</template>