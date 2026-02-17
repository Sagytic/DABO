<template>
  <div class="signup-page">
    <p class="header">Sign Up</p>
    <form class="form" @submit.prevent="submitForm">
      <div class="submit-form">
        <label for="name" class="visually-hidden">Name</label>
        <input
          type="text"
          id="name"
          name="name"
          placeholder="Name"
          v-model="name"
          required
        />
        <div class="">
          <label for="nickname" class="visually-hidden">NickName</label>
          <input
            type="text"
            id="nickname"
            name="nickname"
            placeholder="NickName"
            v-model="nickname"
            required
          />
        </div>
        <div class="input-bloodtype" role="radiogroup" aria-labelledby="bloodtype-label">
          <span id="bloodtype-label">Blood Type</span>
          <div class="form_radio_btn d-flex">
            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice1"
              name="contact"
              value="A"
            />
            <label for="contactChoice1">A</label>

            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice2"
              name="contact"
              value="B"
            />
            <label for="contactChoice2">B</label>

            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice3"
              name="contact"
              value="AB"
            />
            <label for="contactChoice3">AB</label>

            <input
              type="radio"
              v-model="bloodtype"
              id="contactChoice4"
              name="contact"
              value="O"
            />
            <label for="contactChoice4">O</label>
          </div>
        </div>

        <div class="d-flex">
          <label for="email" class="visually-hidden">Email</label>
          <input
            class=""
            type="email"
            id="email"
            v-model="email"
            name="email"
            placeholder="Email"
            required
          />
        </div>
        <label for="password" class="visually-hidden">Password</label>
        <input
          type="password"
          id="password"
          v-model="password"
          name="password"
          placeholder="Password"
          required
        />
        <label for="passwordConfirm" class="visually-hidden">Password Check</label>
        <input
          type="password"
          id="passwordConfirm"
          v-model="passwordConfirm"
          name="passwordChk"
          placeholder="Password Check"
          required
        />
        <button type="submit" class="btn_red">
          <span>SignUp</span>
        </button>

        <!-- <p>뒤에 레이아웃 만들어지면 이 부분 옮겨야 함.</p> -->
        <!-- <button v-on:click="createWallet">지갑주소 생성하기</button> -->
        <!-- <p>privatekey : {{ privateKey }}</p> -->
        <!-- <p>walletAddress : {{ walletAddress }}</p> -->
        <!-- <button @click="goToLogin">로그인창으로~!</button> -->
        <!-- <button v-on:click="saveWallet">서버에 저장</button> -->
      </div>
    </form>
    <!-- <button @click = "onShowModal">Modal Test</button> -->
    <Modal v-if="showModal && !walletCreated" @close="showModal = false">
      <!-- header slot starts -->
      <h3 slot="header">
        DABO 지갑 생성을<br />축하합니다!
        <!-- <i class="fas fa-times closeModalBtn" @click="showModal = false"></i> -->
      </h3>

      <div slot="body" style="word-break: break-all">
        <br />
        <button @click="chargeETH"></button>
        <br />
        <div style="display: flex; justify-content: space-between">
          <span>[비밀키]</span>
          <span @click="copyPrivateKey"
            ><i class="fa-solid fa-copy"></i> 복사하기</span
          >
        </div>
        <p>{{ privateKey }}</p>
        <p style="text-align: left">[지갑 주소]</p>
        <span>{{ walletAddress }}</span>
      </div>
      <div slot="footer">
        <button class="btn_red" @click="goToLogin">Go To Login</button>
      </div>
    </Modal>
    <spinner
      v-if="showModal && walletCreated"
      @close="showModal && !walletCreated"
    >
    </spinner>
  </div>
</template>

<script>
import axios from "axios";
import { registerWallet } from "@/api/wallet.js";
import Web3 from "web3";
import { API_BASE_URL } from "@/config";
import * as walletService from "@/api/wallet.js";
import { createWeb3 } from "@/utils/web3.js";
import Modal from "@/components/user/walletModal.vue";
import spinner from "@/components/user/walletSpinner.vue";
export default {
  components: {
    Modal,
    spinner,
  },
  data() {
    return {
      showModal: false,
      walletCreated: false,
      name: "",
      nickname: "",
      bloodtype: "",
      email: "",
      password: "",
      passwordConfirm: "",
      privateKey:
        "0x17947ddb6fae4d679ea3afe98aff1a33950f5d2e846c278d46c439b72068282d",
      walletAddress: "",
      userId: "",
      wallet: {
        id: 0,
        ownerId: null,
        address: "",
        balance: 0,
        payBalance: 0,
        cash: 0,
        receivingCount: 0,
      },
    };
  },
  methods: {
    copyPrivateKey() {
      this.$copyText(this.privateKey).then(
        function (e) {
          alert("Copied");
          console.log(e);
        },
        function (e) {
          alert("Can not copy");
          console.log(e);
        }
      );
    },
    onShowModal() {
      // alert("Click");
      this.showModal = true;
    },
    goToLogin() {
      this.$router.push("login");
    },
    async submitForm() {
      const userData = {
        name: this.name,
        nickname: this.nickname,
        bloodType: this.bloodtype,
        email: this.email,
        password: this.password,
        passwordConfirm: this.passwordConfirm,
      };
      console.log(userData);
      this.walletCreated = true;

      const response = await axios

        .post(API_BASE_URL + "/api/user/signup", userData)
        .then((response) => {
          console.log("SignUp START");
          console.log(response);
          // this.$router.push("login");
          this.userId = response.data.userId;
        })
        .then(() => {
          console.log(this.userId);
          console.log("createWallet START");
          this.createWallet();
        })
        .then(() => {
          console.log("saveWallet START");
          this.saveWallet();
        })
        .then(() => {
          this.walletCreated = false;
          this.onShowModal();
          // console.log("chargeETH START")
          // this.chargeETH();
        })
        .catch((err) => {
          console.log(err.response);
          alert("회원가입에 실패했습니다. 다시 시도해주세요.");
        });
      console.log(response);
    },

    createWallet: function () {
      console.log("createWallet");
      /**
       * 지갑 주소와 private key를 생성
       *
       */

      var web3 = new Web3();

      var wallet = web3.eth.accounts.create("DABO_WALLET");
      this.walletAddress = wallet.address;
      this.privateKey = wallet.privateKey;
    },

    saveWallet: function () {
      console.log("saveWallet");
      /**
       * 생성된 사용자의 지갑 정보(주소, private key) 를 서버에 등록한다.
       */

      var vm = this;

      registerWallet(
        this.userId,
        this.walletAddress,
        function (res) {
          vm.$store.commit("setUserId", res.data.userId);
          vm.$store.commit("setWalletAddress", res.data.address);
          alert("지갑 주소가 등록되었습니다.");
          vm.chargeETH();
          // vm.$router.push("login");
        },
        function (err) {
          console.log(err);
          console.log("지갑 주소 등록 실패");
        }
      );
    },
    chargeETH() {
      /**
       * cash 충전을 위한 이더 충전
       */
      // if(this.wallet.balance <= 1)
      console.log("eth charge START");
      const scope = this;
      walletService.chargeEther(
        this.walletAddress,
        function () {
          // scope.isCharging = false;
          console.log("이더가 충전 되었습니다.");
          scope.fetchWalletInfo();
          // this.onShowModal();
        },
        function (err) {
          console.log(err);
          console.log("이더 충전에 실패했습니다.");
          // scope.isCharging = false;
        }
      );
    },
    fetchWalletInfo() {
      const vm = this;
      walletService.findByUserId(this.userId, function (response) {
        const data = response.data;
        const web3 = createWeb3();
        data["balance"] = web3.utils.fromWei(
          data["balance"].toString(),
          "ether"
        );
        vm.wallet = data;
        vm.$store.commit("setWallet", data);
      });
    },
  },
};
</script>

<style scoped>
.signup-page {
  text-align: -webkit-center;
  margin: 0 auto;
  width: 70%;
  font-weight: bold;
}
.btn_check {
  width: 20% !important;
  font-size: 12px;
}
.btn_red {
  background-color: #e52d27;
  color: #fff;
  border-radius: 10px;
  border: none;
  width: 100%;
  font-size: 12px;
}
.header {
  margin-top: 10%;
  margin-bottom: 10%;
  font-size: x-large;
}
.submit-form input {
  width: 100%;
  height: 35px;
  margin-top: 2%;
  margin-bottom: 2%;
  border-radius: 8px;
  background-color: #f6f6f6;
  border-color: #e8e8e8;
}
.submit-form input::placeholder {
  color: #bdbdbd;
  font-size: 12px;
  padding: 10px;
}
.btn_input {
  margin: 0;
  position: absolute;
  right: 1%;
  top: 8px;
  height: 29px;
}

.input-bloodtype span {
  margin-top: 5%;
  font-size: 12px;
  float: left;
}

.form_radio_btn {
  width: 100%;
  height: 40px;
  border: 1px solid #eae7e7;
  border-radius: 8px;
  margin-bottom: 10px;
}
.form_radio_btn input[type="radio"] {
  display: none;
}
.form_radio_btn label {
  width: 25%;
  display: block;
  border-radius: 8px;
  margin: 0 auto;
  text-align: center;
  height: -webkit-fill-available;
  line-height: 45px;
}

.form_radio_btn input[type="radio"]:checked + label {
  background: #e52d27a1;
  color: #fff;
}

.form_radio_btn label:hover {
  color: #666;
}

.form_radio_btn input[type="radio"] + label {
  background: #f9fafc;
  color: #666;
}

.visually-hidden {
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip: rect(0, 0, 0, 0);
  white-space: nowrap;
  border: 0;
}
</style>
