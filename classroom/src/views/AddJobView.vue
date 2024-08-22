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
            name: '',
            description: '',
            contactEmail: '',
            contactPhone: '',

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
                name: form.company.name,
                description: form.company.description,
                contactEmail: form.company.contactEmail,
                contactPhone: form.company.contactPhone
            }
        }

    
        try {
           const response = await axios.post(`/api/jobs`, newJob);

           toast.success('job added sucessfully');
           router.push(`/jobs/${response.data.id}`);

        } catch (error) {

            console.error('Error Fetching the data', error);
            toast.error('Job was not added')
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
                <option value="Part-Time">Laboratório</option>
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
                placeholder="eg. Beautiful Apartment In Miami"
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
                placeholder="Add any job duties, expectations, requirements, etc"
              ></textarea>
            </div>

           
          

            <div class="mb-4">
              <label class="block text-gray-700 font-bold mb-2">
                Location
              </label>
              <input
                type="text"
                v-model="form.location"
                id="location"
                name="location"
                class="border rounded w-full py-2 px-3 mb-2"
                placeholder="Company Location"
                required
              />
            </div>

            <h3 class="text-2xl mb-5">Company Info</h3>

            <div class="mb-4">
              <label for="company" class="block text-gray-700 font-bold mb-2"
                >Company Name</label
              >
              <input
                type="text"
                v-model="form.company.name"
                id="company"
                name="company"
                class="border rounded w-full py-2 px-3"
                placeholder="Company Name"
              />
            </div>

            <div class="mb-4">
              <label
                for="company_description"
                class="block text-gray-700 font-bold mb-2"
                >Company Description</label
              >
              <textarea
                id="company_description"
                v-model="form.company.description"
                name="company_description"
                class="border rounded w-full py-2 px-3"
                rows="4"
                placeholder="What does your company do?"
              ></textarea>
            </div>

            <div class="mb-4">
              <label
                for="contact_email"
                class="block text-gray-700 font-bold mb-2"
                >Contact Email</label
              >
              <input
                type="email"
                v-model="form.company.contactEmail"
                id="contact_email"
                name="contact_email"
                class="border rounded w-full py-2 px-3"
                placeholder="Email address for applicants"
                required
              />
            </div>
            <div class="mb-4">
              <label
                for="contact_phone"
                class="block text-gray-700 font-bold mb-2"
                >Contact Phone</label
              >
              <input
                type="tel"
                v-model="form.company.contactPhone"
                id="contact_phone"
                name="contact_phone"
                class="border rounded w-full py-2 px-3"
                placeholder="Optional phone for applicants"
              />
            </div>

            <div>
              <button 
                class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
                type="submit"
              >
                Add Job
              </button>
            </div>
          </form>
        </div>
      </div>
    </section>
</template>