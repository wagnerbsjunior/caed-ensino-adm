<template>
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Sistema</div>
                    <a class="nav-link" href="index.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Principal
                    </a>
                    <div class="sb-sidenav-menu-heading">Dados</div>
                    <!-- INICIO CADASTROS -->
                    <app-cadastros/>
                    <!-- FINAL CADASTROS -->
                    <!-- INICIO RELATÓRIOS -->
                    <app-relatorios/>
                    <!-- FINAL RELATÓRIOS -->
                    <div class="sb-sidenav-menu-heading">Addons</div>
                    <a class="nav-link" href="charts.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                        Charts
                    </a>
                    <a class="nav-link" href="tables.html">
                        <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                        Tables
                    </a>
                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                Start Bootstrap
            </div>
        </nav>
    </div>
</template>

<script>
import Cadastros from '@/components/cadastros/Cadastros.vue'
import Relatorios from '@/components/relatorios/Relatorios.vue'

export default {
    components: { 'app-cadastros': Cadastros, 'app-relatorios': Relatorios }    
    
}
</script>

<style>
    
</style>