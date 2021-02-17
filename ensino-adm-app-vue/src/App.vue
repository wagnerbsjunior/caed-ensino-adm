<template>
  <div id="app">
    <!-- INICIO TEMPLATE -->
    <app-navbar/>
    <div id="layoutSidenav">
      <app-sidebar/>      
      <div id="layoutSidenav_content">
        <!-- SPA CONTENT -->
        <main>
           <app-home/>   
        </main>
        <!-- SPA CONTENT END -->
        <app-footer/>
      </div>        
    </div>    
    <!-- FINAL TEMPLATE -->
	</div> 
</template>

<script>
import Navbar from '@/components/template/Navbar.vue'
import Sidebar from '@/components/template/Sidebar.vue'
import Footer from '@/components/template/Footer.vue'
import Home from '@/components/layout/Home.vue'

export default {
  components: { 'app-navbar': Navbar, 'app-sidebar': Sidebar,
  'app-footer': Footer, 'app-home': Home }
}
</script>

<style>
  @import './assets/styles.css';
</style>
