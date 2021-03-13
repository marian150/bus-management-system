<template>
  <section class="flex flex-col items-center">
    <h2 class=" text-2xl my-3">Search</h2>
    <div class="flex flex-row justify-between items-center my-3">
      <h5>Search for:</h5>
      <select
        @change="changeSearchOption($event)"
        class="mx-3 border border-black"
        name="search-for"
        id="search-for"
      >
        <option value="client">Client</option>
        <option value="ticket">Ticket</option>
      </select>
    </div>
    <div
      v-if="searchFor === 'client'"
      class="flex flex-row justify-between items-center my-3"
    >
      <h5>Input:</h5>
      <base-form @submit.prevent="submitClientForm">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="phone"
          placeholder="Phone"
          v-model="searchedClientPhone"
        />
        <base-button class="text-white">Search</base-button>
      </base-form>
    </div>
    <div v-else class="flex flex-row justify-between items-center my-3">
      <h5>Input:</h5>
      <div class="flex flex-col">
        <base-form @submit.prevent="submitTicketForm" class="flex flex-col">
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="dest"
            placeholder="Destination"
            v-model="ticketDest"
          />
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="date"
            placeholder="Date"
            v-model="ticketDate"
          />
          <input
            class="mx-3 border-b border-black"
            type="text"
            id="time"
            placeholder="Time"
            v-model="ticketTime"
          />
          <base-button class="mt-2 text-white">Search</base-button>
        </base-form>
      </div>
    </div>
  </section>
  <section class="flex justify-center items-center my-5">
    <base-table v-if="dataForClient">
      <th class="p-2 border border-black">Name</th>
      <th class="p-2 border border-black">Phone</th>
      <template v-slot:table-body>
        <tr>
          <td class="p-2 border border-black">{{ client.name }}</td>
          <td class="p-2 border border-black">{{ client.phone }}</td>
        </tr>
      </template>
    </base-table>
    <base-table v-if="dataForTicket">
      <th class="p-2 border border-black">Destination</th>
      <th class="p-2 border border-black">Date</th>
      <th class="p-2 border border-black">Time</th>
      <th class="p-2 border border-black">Client</th>
      <template v-slot:table-body>
        <tr v-for="ticket in tickets" :key="ticket">
          <td class="p-2 border border-black">
            {{ ticket.schedule.destination }}
          </td>
          <td class="p-2 border border-black">{{ ticket.travelDate }}</td>
          <td class="p-2 border border-black">{{ ticket.schedule.time }}</td>
          <td class="p-2 border border-black">{{ ticket.client.name }}</td>
        </tr>
      </template>
    </base-table>
  </section>
</template>

<script>
export default {
  data() {
    return {
      searchFor: 'client',
      dataForClient: false,
      dataForTicket: false,
      searchedClientPhone: '',
      client: null,
      ticketDest: '',
      ticketDate: '',
      ticketTime: '',
      tickets: [],
    }
  },
  methods: {
    changeSearchOption(event) {
      if (event.target.value === 'client') {
        this.searchFor = 'client'
      } else {
        this.searchFor = 'ticket'
      }
    },
    submitClientForm() {
      this.dataForTicket = false
      const client = this.$store.getters['clients/clients'].find(
        (c) => c.phone === this.searchedClientPhone
      )
      this.client = {
        name: client.name,
        phone: client.phone,
      }
      this.dataForClient = true
    },
    submitTicketForm() {
      this.dataForClient = false
      const inputTicket = {
        dest: this.ticketDest,
        date: this.ticketDate,
        time: this.ticketTime,
      }
      const tickets = this.$store.getters['tickets/tickets'].filter((ticket) =>
        this.filterTickets(ticket, inputTicket)
      )
      this.tickets = tickets
      this.dataForTicket = true
    },
    filterTickets(t1, t2) {
      if (t1.schedule.destination === t2.dest) {
        return true
      }
    },
  },
}
</script>
