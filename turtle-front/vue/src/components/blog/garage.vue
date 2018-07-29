<template>
  <div class="blog-main">
    <div class="g-panel">
      <div class="img-link" id="di-link" @click="toDinosaur()">
        <img src="../../assets/large-d.png" />
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {

      }
    },
    methods: {
      toDinosaur() {
        this.$router.push({
          name: 'dinosaur'
        });
      }
    }
  }
</script>
<style scoped>

  .img-link {
    width: 350px;
    height: 250px;
  }

  #di-link {
    background-color: palevioletred;
    -webkit-transition: 600ms;
    -moz-transition: 600ms;
    -o-transition: 600ms;
    transition: 600ms;
  }

  #di-link:hover {
    background-color: indianred;
    cursor: pointer;
  }

  .img-link img {
    margin: 40px;
  }

</style>
