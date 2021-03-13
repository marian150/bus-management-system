<template>
  <header class="bg-green-700 text-white h-20 flex justify-center items-center">
    <nav class="flex w-full justify-center">
      <ul class=" w-full flex justify-around items-center list-none m-0 p-0">
        <li>
          <router-link class="p-2" to="/reservation">Reservation</router-link>
        </li>
        <li>
          <router-link class="p-2" to="/info">Info</router-link>
        </li>
        <li>
          <router-link class="p-2" to="/search">Search</router-link>
        </li>
      </ul>
    </nav>
  </header>
</template>

<style scoped>
header a:hover,
header a:focus,
header a.router-link-active {
  border-radius: 0.25rem;
  background-color: #065f46;
  padding: 0.5rem;
}
</style>
