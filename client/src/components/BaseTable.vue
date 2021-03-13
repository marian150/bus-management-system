<template>
  <table class="border border-black table-auto">
    <thead>
      <tr>
        <slot></slot>
      </tr>
    </thead>
    <tbody>
      <slot name="table-body"></slot>
    </tbody>
  </table>
</template>
