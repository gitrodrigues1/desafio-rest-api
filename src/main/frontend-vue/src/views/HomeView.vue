<script setup>
import { ref } from 'vue';
import http from './http-common';
import { useObjectsStore } from '@/stores/ObjectsStore';

const cities = useObjectsStore()

const text = ref('');

function getCities(text) {
    console.log(text);
    console.log(cities.$state);
    if(cities.$state.cities.length === 0) {
        http.get("/cities/state/${text}")
        .then(response => response.data)
        .catch(error => console.error(error));
    }

}

</script>

<template>
    <div>
        <h2>Home</h2>
    </div>

    <form class="row g-3">
        <div class="col-4">
            <input class="form-control" 
                type="text" 
                placeholder="Type a brazilian city you would like to visit"
                v-model="text"
            >
        </div>
        <div class="col-auto">
            <button @click="getCities" class="btn btn-primary mb-3" type="button">Search</button>
        </div>
    </form>
    <table>
        <thead>
            <tr>
                <th>City</th>
                <th>State</th>
            </tr>
        </thead>
        <tbody v-for="c in cities.$state">
            <tr>
                <td>{{ c.name }}</td>
                <td>{{ c.state }}</td>
            </tr>
        </tbody>
    </table>

</template>