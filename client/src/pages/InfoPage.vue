<template>
  <section class="flex flex-col items-center">
    <h2 class=" text-2xl my-3">Information</h2>
    <div class="flex flex-row justify-between items-center my-3">
      <h5>Info type:</h5>
      <select
        @change="changeSearchOption($event)"
        class="mx-3 border border-black"
        name="search-for"
        id="search-for"
      >
        <option value="ticketsClient">Tickets for Client</option>
        <option value="lastFive">Last 5 Tickets by Employee</option>
        <option value="soldByEmp">Num tickets sold for Employee</option>
        <option value="freePlaces">Free places</option>
      </select>
    </div>
    <div
      v-if="searchFor === 'ticketsClient'"
      class="flex flex-row justify-between items-center my-3"
    >
      <h5>Input:</h5>
      <base-form @submit.prevent="submitTicketsClientForm">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="clName"
          placeholder="Client Name"
          v-model="searchedClientName"
        />
        <base-button class="text-white">Search</base-button>
      </base-form>
    </div>
    <div
      v-if="searchFor === 'lastFive'"
      class="flex flex-row justify-between items-center my-3"
    >
      <h5>Input:</h5>
      <base-form @submit.prevent="submitLastFiveForm">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="empName"
          placeholder="Employee Name"
          v-model="searchedEmpName"
        />
        <base-button class="text-white">Search</base-button>
      </base-form>
    </div>
    <div
      v-if="searchFor === 'freePlaces'"
      class="flex flex-row justify-between items-center my-3"
    >
      <h5>Input:</h5>
      <div class="flex flex-col">
        <base-form @submit.prevent="submitfreePlacesForm" class="flex flex-col">
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="dest"
            placeholder="Destination"
          />
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="date"
            placeholder="Date"
          />
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="time"
            placeholder="Time"
          />
          <base-button class="mt-2 text-white">Search</base-button>
        </base-form>
      </div>
    </div>
    <div
      v-if="searchFor === 'soldByEmp'"
      class="flex flex-row justify-between items-center my-3"
    >
      <h5>Input:</h5>
      <div class="flex flex-col">
        <base-form @submit.prevent="submitSoldByEmpForm" class="flex flex-col">
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="employeeName"
            placeholder="Employee Name"
          />
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="startDate"
            placeholder="Start Date"
          />
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="endDate"
            placeholder="End Date"
          />
          <base-button class="mt-2 text-white">Search</base-button>
        </base-form>
      </div>
    </div>
  </section>
  <section class="flex justify-center items-center my-5">
    <base-table v-if="dataForticketsClient">
      <th class="p-2 border border-black">Client</th>
      <th class="p-2 border border-black">Destination</th>
      <th class="p-2 border border-black">Date</th>
      <th class="p-2 border border-black">Time</th>
      <template v-slot:table-body>
        <tr v-for="ticket in ticketsForCl" :key="ticket">
          <td class="p-2 border border-black">{{ ticket.client.name }}</td>
          <td class="p-2 border border-black">
            {{ ticket.schedule.destination }}
          </td>
          <td class="p-2 border border-black">{{ ticket.travelDate }}</td>
          <td class="p-2 border border-black">{{ ticket.schedule.time }}</td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="dataForlastFive">
      <th class="p-2 border border-black">Employee</th>
      <th class="p-2 border border-black">Destination</th>
      <th class="p-2 border border-black">Date</th>
      <th class="p-2 border border-black">Time</th>
      <th class="p-2 border border-black">Res Date</th>
      <th class="p-2 border border-black">Client</th>
      <template v-slot:table-body>
        <tr v-for="ticket in ticketsForEmp" :key="ticket">
          <td class="p-2 border border-black">
            {{ ticket.employee.name }}
          </td>
          <td class="p-2 border border-black">
            {{ ticket.schedule.destination }}
          </td>
          <td class="p-2 border border-black">{{ ticket.travelDate }}</td>
          <td class="p-2 border border-black">{{ ticket.schedule.time }}</td>
          <td class="p-2 border border-black">{{ ticket.resDate }}</td>
          <td class="p-2 border border-black">{{ ticket.client.name }}</td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="dataForsoldByEmp">
      <th class="p-2 border border-black">Employee</th>
      <th class="p-2 border border-black">Destination</th>
      <th class="p-2 border border-black">Date</th>
      <th class="p-2 border border-black">Time</th>
      <th class="p-2 border border-black">Res Date</th>
      <th class="p-2 border border-black">Client</th>
      <template v-slot:table-body>
        <tr v-for="ticket in ticketsSoldByEmp" :key="ticket">
          <td class="p-2 border border-black">
            {{ ticket.employee.name }}
          </td>
          <td class="p-2 border border-black">
            {{ ticket.schedule.destination }}
          </td>
          <td class="p-2 border border-black">{{ ticket.travelDate }}</td>
          <td class="p-2 border border-black">{{ ticket.schedule.time }}</td>
          <td class="p-2 border border-black">{{ ticket.resDate }}</td>
          <td class="p-2 border border-black">{{ ticket.client.name }}</td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="dataForfreePlaces">
      <th class="p-2 border border-black">Free Places</th>
      <template v-slot:table-body>
        <tr>
          <td class="p-2 border border-black">
            {{ numFreePlaces }}
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
      dataForticketsClient: false,
      dataForlastFive: false,
      dataForsoldByEmp: false,
      dataForfreePlaces: false,
      searchFor: 'ticketsClient',
      ticketsForCl: [],
      ticketsForEmp: [],
      ticketsSoldByEmp: [],
      numFreePlaces: null,
    }
  },
  methods: {
    changeSearchOption(event) {
      if (event.target.value === 'ticketsClient') {
        this.searchFor = 'ticketsClient'
      }
      if (event.target.value === 'lastFive') {
        this.searchFor = 'lastFive'
      }
      if (event.target.value === 'soldByEmp') {
        this.searchFor = 'soldByEmp'
      }
      if (event.target.value === 'freePlaces') {
        this.searchFor = 'freePlaces'
      }
    },

    submitTicketsClientForm(event) {
      this.dataForlastFive = false
      this.dataForsoldByEmp = false
      this.dataForfreePlaces = false

      const ticketsForCl = this.$store.getters['tickets/tickets'].filter(
        (ticket) => ticket.client.name === event.target.elements.clName.value
      )

      this.ticketsForCl = ticketsForCl

      this.dataForticketsClient = true
    },
    submitLastFiveForm(event) {
      this.dataForticketsClient = false
      this.dataForsoldByEmp = false
      this.dataForfreePlaces = false

      let ticketsForEmp = this.$store.getters['tickets/tickets'].filter(
        (ticket) => ticket.employee.name === event.target.elements.empName.value
      )

      ticketsForEmp.sort(function(t1, t2) {
        if (t1.resDate > t2.resDate) {
          return -1
        }
        if (t1.resDate < t2.resDate) {
          return 1
        }
        return 0
      })

      this.ticketsForEmp = ticketsForEmp.slice(0, 5)

      this.dataForlastFive = true
    },
    submitSoldByEmpForm(event) {
      this.dataForticketsClient = false
      this.dataForfreePlaces = false
      this.dataForlastFive = false

      let input = {
        empName: event.target.elements.employeeName.value,
        stDate: new Date(event.target.elements.startDate.value),
        endDate: new Date(event.target.elements.endDate.value),
      }

      this.ticketsSoldByEmp = this.$store.getters['tickets/tickets'].filter(
        function(ticket) {
          if (
            ticket.employee.name === input.empName &&
            ticket.resDate < input.endDate &&
            ticket.resDate > input.stDate
          ) {
            return true
          }
        }
      )

      console.log(this.ticketsSoldByEmp)

      this.dataForsoldByEmp = true
    },
    submitfreePlacesForm(event) {
      this.dataForticketsClient = false
      this.dataForlastFive = false
      this.dataForsoldByEmp = false

      const input = {
        dest: event.target.elements.dest.value,
        date: new Date(event.target.elements.date.value),
        time: event.target.elements.time.value,
      }

      const numFreePlaces = this.$store.getters['tickets/tickets'].find(
        function(ticket) {
          if (
            ticket.schedule.destination === input.dest &&
            +ticket.travelDate == +input.date &&
            ticket.schedule.time == input.time
          ) {
            return true
          }
        }
      ).freePlaces

      this.numFreePlaces = numFreePlaces

      this.dataForfreePlaces = true
    },
  },
}
</script>
