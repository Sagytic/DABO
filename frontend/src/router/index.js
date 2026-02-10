import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "landing",
    component: () => import("@/views/landing/landingPage.vue"),
  },
  {
    path: "/home",
    name: "home",
    component: () => import("@/views/mainPage.vue"),
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/user/userPage.vue"),
    children: [
      {
        path: "login",
        name: "login",
        component: () => import("@/components/user/loginPage.vue"),
      },
      {
        path: "signup",
        name: "signup",
        component: () => import("@/components/user/signUp.vue"),
      },
      {
        path: "findpassword",
        name: "findpassword",
        component: () => import("@/components/user/findPassword.vue"),
      },
      {
        path: "infochange",
        name: "infoChange",
        component: () => import("@/components/user/infoChange.vue"),
      },
      {
        path: "ranking",
        name: "ranking",
        component: () => import("@/components/user/rankingDetail.vue"),
      },
    ],
  },

  {
    path: "/reservation",
    name: "reservation",
    component: () => import("@/views/reservation/reservationMain.vue"),
    children: [
      {
        path: "bloodHouseList",
        name: "bloodHouseList",
        component: () => import("@/components/reservation/bloodHouseList.vue"),
      },
      {
        path: "nowReservation",
        name: "nowReservation",
        component: () => import("@/components/reservation/nowReservation.vue"),
      },
      {
        path: "reservationHistory",
        name: "reservationHistory",
        component: () => import("@/components/reservation/reservationHistory.vue"),
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
    component: () => import("@/views/daboWallet/daboWalletMain.vue"),
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
    component: () => import("@/components/wallet/testDabo.vue"),
  },
  {
    path: "/dabowallet/chargedabo",
    name: "chargedabo",
    component: () => import("@/views/daboWallet/chargeDabo.vue"),
  },
  {
    path: "/dabowallet/paydabo",
    name: "paydabo",
    component: () => import("@/views/daboWallet/payDabo.vue"),
  },
  {
    path: "/dabowallet/chargeconfirm",
    name: "chargeconfirm",
    component: () => import("@/views/daboWallet/chargeConfirm.vue"),
  },
  {
    path: "/bloodcard",
    name: "bloodCard",
    component: () => import("@/views/bloodCard/bloodCard.vue"),
    children: [
      {
        path: "list",
        name: "bloodcardList",
        component: () => import("@/components/bloodcard/bloodcardList.vue"),
      },
      {
        path: "create",
        name: "bloodcardCreate",
        component: () => import("@/components/bloodcard/bloodcardCreate.vue"),
      },
    ],
  },
  {
    path: "/badge",
    name: "badge",
    component: () => import("@/views/badge/badgeMain.vue"),
  },
  {
    path: "/mydabo",
    name: "myDabo",
    component: () => import("@/views/user/myDabo.vue"),
  },
  {
    name: "exBlockChain",
    path: "/exBlockChain",
    component: () => import("@/views/exBlockChain.vue"),
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
