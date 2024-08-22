<script setup>
    import { reactive } from 'vue';
    import router from '@/router';
    import { useToast } from 'vue-toastification';
    import axios from 'axios';

    const form = reactive({
        type: 'Sala',
        title: '',
        description: '',
        //salary: '',
        location: '',
        company: {
            //name: '',
            description: '',
            //contactEmail: '',
            //contactPhone: '',

        }

    });

    const toast = useToast();

    const handleSubmmit = async()=>{
        const newJob = {
            title: form.title,
            type: form.type,
            description: form.description,
            //salary: form.salary,
            location: form.location,
            company: {
                //name: form.company.name,
                description: form.company.description,
                //contactEmail: form.company.contactEmail,
                //contactPhone: form.company.contactPhone
            }
        }

    
        try {
           const response = await axios.post(`/api/jobs`, newJob);

           toast.success('Adicionado com Sucesso.');
           router.push(`/jobs/${response.data.id}`);

        } catch (error) {

            console.error('Error Fetching the data', error);
            toast.error('Não pode ser adiconado.')
        }
    
    };

</script>

<template>

    <section class="bg-green-50 ">
      <div class="container m-auto max-w-2xl py-24">
        <div
          class="bg-white px-6 py-8 mb-4 shadow-md rounded-md border m-4 md:m-0"
        >
          <form @submit.prevent="handleSubmmit">
            <h2 class="text-3xl text-center font-semibold mb-6">Adicionar</h2>

            <div class="mb-4">
              <label for="type" class="block text-gray-700 font-bold mb-2"
                >Tipo de Sala</label
              >
              <select
                v-model="form.type"
                id="type"
                name="type"
                class="border rounded w-full py-2 px-3"
                required
              >
                <option value="Sala">Sala de Aula</option>
                <option value="Laboratorio">Laboratório</option>
              </select>
            </div>

            <div class="mb-4">
              <label class="block text-gray-700 font-bold mb-2"
                >Nome</label
              >
              <input
                type="text"
                v-model="form.title"
                id="name"
                name="name"
                class="border rounded w-full py-2 px-3 mb-2"
                placeholder="A1, B2 etc."
                required
              />
            </div>
            <div class="mb-4">
              <label
                for="description"
                class="block text-gray-700 font-bold mb-2"
                >Descrição</label
              >
              <textarea
                id="description"
                v-model="form.description"
                name="description"
                class="border rounded w-full py-2 px-3"
                rows="4"
                placeholder="Disciplinas , turmas , turnos , quantidade de alunos suportados etc."
              ></textarea>
            </div>

            <div class="mb-4">
              <label class="block text-gray-700 font-bold mb-2">
                Disponibilidade
              </label>
              <input
                type="text"
                v-model="form.location"
                id="location"
                name="location"
                class="border rounded w-full py-2 px-3 mb-2"
                placeholder="disponibilidade (pode ser mudado depois)"
                required
              />
            </div>
            

            <h3 class="text-2xl mb-5">Informações dos Recursos</h3>

           

            <div class="mb-4">
              <label
                for="company_description"
                class="block text-gray-700 font-bold mb-2"
                >Adicionar Recursos</label
              >
              <textarea
                id="company_description"
                v-model="form.company.description"
                name="company_description"
                class="border rounded w-full py-2 px-3"
                rows="4"
                placeholder="Computadores, impressoras, Data show e etc..."
              ></textarea>
            </div>

        

            <div>
              <button 
                class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
                type="submit"
              >
                Adicionar
              </button>
            </div>
          </form>
        </div>
      </div>
    </section>
</template>