<template>
  <section class="flex flex-col items-center">
    <h2 class=" text-2xl my-3">Delete Data</h2>
    <div class="flex flex-row justify-between items-center my-3">
      <h5>Delete:</h5>
      <select
        @change="changeDeleteOption($event)"
        class="mx-3 border border-black"
        name="search-for"
        id="delete-opt"
      >
        <option value="client">Client</option>
        <option value="employee">Employee</option>
        <option value="destination">Destination</option>
        <option value="position">Position</option>
        <option value="schedule">Schedule</option>
      </select>
    </div>
    <base-table v-if="deleteFor === 'client'">
      <th class="p-2 border border-black">Client</th>
      <th class="p-2 border border-black">Phone</th>
      <th class="p-2 border border-black"></th>
      <template v-slot:table-body>
        <tr v-for="client in clients" :key="client">
          <td class="p-2 border border-black">
            {{ client.name }}
          </td>
          <td class="p-2 border border-black">
            {{ client.phone }}
          </td>
          <td class="p-2 border border-black">
            <base-button>Delete</base-button>
          </td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="deleteFor === 'employee'">
      <th class="p-2 border border-black">Employee</th>
      <th class="p-2 border border-black">Phone</th>
      <th class="p-2 border border-black"></th>
      <template v-slot:table-body>
        <tr v-for="employee in employees" :key="employee">
          <td class="p-2 border border-black">
            {{ employee.name }}
          </td>
          <td class="p-2 border border-black">
            {{ employee.phone }}
          </td>
          <td class="p-2 border border-black">
            <base-button>Delete</base-button>
          </td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="deleteFor === 'destination'">
      <th class="p-2 border border-black">Destination</th>
      <th class="p-2 border border-black"></th>
      <template v-slot:table-body>
        <tr v-for="dest in destinations" :key="dest">
          <td class="p-2 border border-black">
            {{ dest.name }}
          </td>
          <td class="p-2 border border-black">
            <base-button>Delete</base-button>
          </td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="deleteFor === 'position'">
      <th class="p-2 border border-black">Position</th>
      <th class="p-2 border border-black"></th>
      <template v-slot:table-body>
        <tr v-for="position in positions" :key="position">
          <td class="p-2 border border-black">
            {{ position.name }}
          </td>
          <td class="p-2 border border-black">
            <base-button>Delete</base-button>
          </td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="deleteFor === 'schedule'">
      <th class="p-2 border border-black">Destination</th>
      <th class="p-2 border border-black">Time</th>
      <th class="p-2 border border-black">Day of Week</th>
      <th class="p-2 border border-black">Price</th>
      <th class="p-2 border border-black"></th>
      <template v-slot:table-body>
        <tr v-for="schedule in schedules" :key="schedule">
          <td class="p-2 border border-black">
            {{ schedule.destination }}
          </td>
          <td class="p-2 border border-black">
            {{ schedule.time }}
          </td>
          <td class="p-2 border border-black">{{ schedule.day }}</td>
          <td class="p-2 border border-black">{{ schedule.price }}</td>
          <td class="p-2 border border-black">
            <base-button>Delete</base-button>
          </td>
        </tr>
      </template>
    </base-table>
  </section>
</template>

<script>
export default {
  data() {
    return {
      deleteFor: 'client',
    }
  },
  methods: {
    changeDeleteOption(event) {
      if (event.target.value === 'client') {
        this.deleteFor = 'client'
      }
      if (event.target.value === 'employee') {
        this.deleteFor = 'employee'
      }
      if (event.target.value === 'destination') {
        this.deleteFor = 'destination'
      }
      if (event.target.value === 'position') {
        this.deleteFor = 'position'
      }
      if (event.target.value === 'schedule') {
        this.deleteFor = 'schedule'
      }
    },
  },
  computed: {
    clients() {
      return this.$store.getters['clients/clients']
    },
  },
}
</script>
