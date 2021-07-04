<template>
  <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="512"
      img-height="auto"
      style="text-shadow: 1px 1px 2px #333"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="Every dog has his day."
        img-src="https://i.ibb.co/PcQkp25/apt.jpg"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide caption="No pain, No gain." img-src="https://i.ibb.co/0fmwyg1/apt.jpg">
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide
        caption="Failure is but a stepping stone to success."
        img-src="https://i.ibb.co/gr62MqK/ap3.jpg"
      ></b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide
        caption="Haste makes waste"
        img-src="https://i.ibb.co/LzW5qtb/ap2.jpg"
      ></b-carousel-slide>
    </b-carousel>

    <p class="mt-4">
      <!-- Slide #: {{ slide }}<br />
      Sliding: {{ sliding }} -->
    </p>

    <div class="mt-4">
      <h4>Member</h4>
      <b-card-group>
        <b-card
          img-src="https://i.ibb.co/rfx9JjG/image.jpg"
          img-alt="Card image"
          img-left
          class="mb-3"
          img-width="180"
          img-height="240"
        >
          <b-card-text> 노력하는 개발자 양영진입니다. </b-card-text>
        </b-card>

        <b-card
          img-src="https://i.ibb.co/fkCrT4M/gray.jpg"
          img-alt="Card image"
          img-right
          img-width="180"
          img-height="240"
        >
          <b-card-text> 발전하는 개발자 박채린입니다. </b-card-text>
        </b-card>
      </b-card-group>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    },
  },
};
</script>
