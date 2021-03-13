import { createApp } from 'vue'
import App from './App.vue'
import './index.css'
import router from './router.js'
import store from './store/index.js'
import BaseButton from './components/BaseButton.vue'
import BaseTable from './components/BaseTable.vue'
import BaseForm from './components/BaseForm.vue'

const app = createApp(App)

app.use(router)
app.use(store)

app.component('base-button', BaseButton)
app.component('base-table', BaseTable)
app.component('base-form', BaseForm)

app.mount('#app')
