<template>
  <el-container>
    <el-main>
      <vue-plyr>
        <div data-plyr-provider="youtube" :data-plyr-embed-id=embedid></div>
      </vue-plyr>
    </el-main>
    <el-footer>
      <el-row>
        <el-col :span="24">{{movie_title}}</el-col>
      </el-row>
      <el-row>
        <el-col :span="24">{{imdb_rating}}/10</el-col>
      </el-row>
      <el-divider></el-divider>
      <el-row>
        <el-col :span="24">{{description}}</el-col>
      </el-row>
      <el-divider></el-divider>
      <el-row>comments</el-row>
      <el-row>comments</el-row>
      <el-row>comments</el-row>
      <el-row>comments</el-row>
      <br>
      <br>
      <br>
      <br>
    </el-footer>
  </el-container>
</template>

<script>
  export default {
    data() {
      return {
        embedid: 'OrP_CtoeO9E', 
        urlGetAll: '/watch', 
        imdb_rating: 9.2, 
        movie_title: 'The Shawshank Redemption', 
        description: 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 
      }
    }, 

    methods: {

    }, 

    created() {
      this.embedid = this.$route.params.v;
      this.movie_title = this.$route.params.t;
    }
  }
</script>

<style>

</style>