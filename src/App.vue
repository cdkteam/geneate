<template>
  <div id="app">
    <el-container>
        <!-- <HelloWorld /> -->
        <!-- <FamilyMap /> -->
    </el-container>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import FamilyMap from './components/familymap.vue'

export default {
  name: 'app',
  components: {
    HelloWorld,
    FamilyMap
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
