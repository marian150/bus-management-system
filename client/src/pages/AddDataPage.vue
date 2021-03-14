<template>
  <section class="flex flex-col items-center">
    <h2 class=" text-2xl my-3">Insert Data</h2>
    <div class="flex flex-row justify-between items-center my-3">
      <h5>Insert:</h5>
      <select
        @change="changeInsertOption($event)"
        class="mx-3 border border-black"
        name="search-for"
        id="insert-opt"
      >
        <option value="client">Client</option>
        <option value="employee">Employee</option>
        <option value="destination">Destination</option>
        <option value="position">Position</option>
        <option value="schedule">Schedule</option>
      </select>
    </div>
    <div
      v-if="insertFor === 'client'"
      class="flex flex-row justify-between items-end my-3"
    >
      <h5>Data:</h5>
      <base-form @submit.prevent="submitClientInsert">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="clName"
          placeholder="Name"
        />
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="clPhone"
          placeholder="Phone"
        />
        <base-button class="text-white">Submit</base-button>
      </base-form>
    </div>
    <div
      v-if="insertFor === 'employee'"
      class="flex flex-row justify-between items-end my-3"
    >
      <h5>Input:</h5>
      <base-form @submit.prevent="submitEmpInsert">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="empName"
          placeholder="Name"
        />
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="empPhone"
          placeholder="Phone"
        />
        <base-button class="mt-2 text-white">Submit</base-button>
      </base-form>
    </div>
    <div
      v-if="insertFor === 'destination'"
      class="flex flex-row justify-between items-end my-3"
    >
      <h5>Data:</h5>
      <base-form @submit.prevent="submitDestinationInsert">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="destination"
          placeholder="Destination"
        />
        <base-button class="text-white">Submit</base-button>
      </base-form>
    </div>
    <div
      v-if="insertFor === 'position'"
      class="flex flex-row justify-between items-end my-3"
    >
      <h5>Data:</h5>
      <base-form @submit.prevent="submitPositionInsert">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="position"
          placeholder="Position"
        />
        <base-button class="text-white">Submit</base-button>
      </base-form>
    </div>
    <div
      v-if="insertFor === 'schedule'"
      class="flex flex-row justify-between items-end my-3"
    >
      <h5>Data:</h5>
      <base-form @submit.prevent="submitScheduleInsert">
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="dayOfWeek"
          placeholder="Day of Week(Mon=1,...)"
        />
        <input
          class="mx-3 border-b border-black"
          type="text"
          id="time"
          placeholder="Time(hour)"
        />
        <select class="mx-3 border-b border-black" id="schDest">
          <option v-for="dest in destinations" :key="dest" :value="dest">{{
            dest
          }}</option>
        </select>
        <base-button class="text-white">Submit</base-button>
      </base-form>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      insertFor: 'client',
    }
  },
  computed: {
    destinations() {
      return ['Burgas', 'Varna', 'Sofia']
    },
  },
  methods: {
    changeInsertOption(event) {
      if (event.target.value === 'client') {
        this.insertFor = 'client'
      }
      if (event.target.value === 'employee') {
        this.insertFor = 'employee'
      }
      if (event.target.value === 'destination') {
        this.insertFor = 'destination'
      }
      if (event.target.value === 'position') {
        this.insertFor = 'position'
      }
      if (event.target.value === 'schedule') {
        this.insertFor = 'schedule'
      }
    },
  },
}
</script>
