import Vue from "vue";
import VueRouter from "vue-router";
import landing from "@/views/landing/landingPage.vue";
import Home from "@/views/mainPage.vue";
import badge from "@/views/badge/badgeMain.vue";

import daboWallet from "@/views/daboWallet/daboWalletMain.vue";

import reservation from "@/views/reservation/reservationMain.vue";
import BloodHouseList from "@/components/reservation/bloodHouseList.vue";
import NowReservation from "@/components/reservation/nowReservation.vue";
import ReservationHistory from "@/components/reservation/reservationHistory.vue";

import bloodCard from "@/views/bloodCard/bloodCard.vue";
import bloodcardList from "@/components/bloodcard/bloodcardList.vue";
import bloodcardCreate from "@/components/bloodcard/bloodcardCreate.vue";

import user from "@/views/user/userPage.vue";
import Login from "@/components/user/loginPage.vue";
import Signup from "@/components/user/signUp.vue";
import infoChange from "@/components/user/infoChange.vue";
import Ranking from "@/components/user/rankingDetail.vue";
import myDabo from "@/views/user/myDabo.vue";
import chargeDabo from "@/views/daboWallet/chargeDabo.vue";
import payDabo from "@/views/daboWallet/payDabo.vue";
import chargeConfirm from "@/views/daboWallet/chargeConfirm.vue";

import Findpassword from "@/components/user/findPassword.vue";
Vue.use(VueRouter);
import exBlockChain from "@/views/exBlockChain.vue";
import testDabo from "@/components/wallet/testDabo.vue"
const routes = [
  {
    path: "/",
    name: "landing",
    component: landing,
  },
  {
    path: "/home",
    name: "home",
    component: Home,
  },
  {
    path: "/user",
    name: "user",
    component: user,
    children: [
      {
        path: "login",
        name: "login",
        component: Login,
      },
      {
        path: "signup",
        name: "signup",
        component: Signup,
      },
      {
        path: "findpassword",
        name: "findpassword",
        component: Findpassword,
      },
      {
        path: "infochange",
        name: "infoChange",
        component: infoChange,
      },
      {
        path: "ranking",
        name: "ranking",
        component: Ranking,
      },
    ],
  },

  {
    path: "/reservation",
    name: "reservation",
    component: reservation,
    children: [
      {
        path: "bloodHouseList",
        name: "bloodHouseList",
        component: BloodHouseList,
      },
      {
        path: "nowReservation",
        name: "nowReservation",
        component: NowReservation,
      },
      {
        path: "reservationHistory",
        name: "reservationHistory",
        component: ReservationHistory,
      },
    ],
  },
  {
    path: "/donationBoard",
    name: "donationBoard",
    component: () => import("@/views/donationBoard/donationBoardPage.vue"),
    children: [
      {
        path: "listBoard",
        name: "listBoard",
        component: () => import("@/components/campaign/donationBoardList.vue"),
      },
      {
        path: "listItem",
        name: "listItem",
        component: () => import("@/components/campaign/donationBoardListItem.vue"),
      },
      {
        path: "createBoard",
        name: "createBoard",
        component: () => import("@/components/campaign/donationBoardCreate.vue"),
      },
      {
        path: "updateBoard",
        name: "updateBoard",
        component: () => import("@/components/campaign/donationBoardUpdate.vue"),
      },
      {
        path: "detailBoard/:campaignId",
        name: "detailBoard",
        component: () => import("@/components/campaign/donationBoardDetail.vue"),
      },
      {
        path: "myDonation",
        name: "myDonation",
        component: () => import("@/components/campaign/bloodCardDonation.vue"),
      },
      {
        path: "donationConfirm",
        name: "donationConfirm",
        component: () => import("@/components/campaign/donationConfirm.vue"),
      },
      {
        path: "daboDonation",
        name: "daboDonation",
        component: () => import("@/components/campaign/daboDonation.vue"),
      },
      {
        path: "daboConfirm",
        name: "daboConfirm",
        component: () => import("@/components/campaign/daboConfirm.vue"),
      },
    ],
  },
  {
    path: "/dabowallet",
    name: "daboWallet",
    component: daboWallet,
    // children: [
    //   {
    //     path: "/chargedabo",
    //     name: "chargedabo",
    //     component: chargeDabo,
    //   },
    // ]
  },
  {
    path: "/testDabo",
    name: "testDabo",
    component: testDabo,
  },
  {
    path: "/dabowallet/chargedabo",
    name: "chargedabo",
    component: chargeDabo,
  },
  {
    path: "/dabowallet/paydabo",
    name: "paydabo",
    component: payDabo,
  },
  {
    path: "/dabowallet/chargeconfirm",
    name: "chargeconfirm",
    component: chargeConfirm,
  },
  {
    path: "/bloodcard",
    name: "bloodCard",
    component: bloodCard,
    children: [
      {
        path: "list",
        name: "bloodcardList",
        component: bloodcardList,
      },
      {
        path: "create",
        name: "bloodcardCreate",
        component: bloodcardCreate,
      },
    ],
  },
  {
    path: "/badge",
    name: "badge",
    component: badge,
  },
  {
    path: "/mydabo",
    name: "myDabo",
    component: myDabo,
  },
  {
    name: "exBlockChain",
    path: "/exBlockChain",
    component: exBlockChain,
    children: [
      {
        name: "exBlockChain.dashboard",
        path: "dashboard",
        component: () => import("@/components/explorer/Dashboard.vue"),
      },
      {
        name: "exBlockChain.block",
        path: "blocks",
        component: () => import("@/components/explorer/BlockListView.vue"),
      },
      {
        name: "exBlockChain.block.detail",
        path: "block/:blockNumber",
        component: () => import("@/components/explorer/BlockDetail.vue"),
      },
      {
        name: "exBlockChain.tx",
        path: "txes",
        component: () => import("@/components/explorer/TxListView.vue"),
      },
      {
        name: "exBlockChain.tx.detail",
        path: "tx/:hash",
        component: () => import("@/components/explorer/TxDetail.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
