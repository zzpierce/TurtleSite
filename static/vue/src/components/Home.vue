<template>
  <div>
    <div>Home sweet home..</div>
  </div>
</template>
<script>
  export default {
    events: {
      'hook:created': function() {
        alert('Home haha Home');
      }
    }
  };
</script>
